package net.mooctest;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static net.mooctest.MatrixInverse.EPS;

public class MatrixInverseTest {

    @Test
    public void Test() {
        double[][] matrix = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            Assert.assertTrue(Arrays.deepEquals(inverse(matrix), MatrixInverse.inverse(matrix)));
            Assert.assertTrue(isInconsistent(matrix) == MatrixInverse.isInconsistent(matrix));
            Assert.assertTrue(hasMultipleSolutions(matrix) == MatrixInverse.hasMultipleSolutions(matrix));
            for (int x = 0; x < matrix.length; x++) {
                for (int y = 0; y < matrix[x].length; y++) {
                    matrix[x][y] = rand.nextDouble() * 1000.0 - 500.0;
                }
            }
        }
        Assert.assertNull(MatrixInverse.inverse(new double[][]{{0}, {0}}));
    }

    private static double[][] inverse(double[][] matrix) {
        if (matrix.length != matrix[0].length) return null;
        int n = matrix.length;
        double[][] augmented = new double[n][n * 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                augmented[i][j] = matrix[i][j];
            augmented[i][i + n] = 1;
        }
        solve(augmented);
        double[][] inv = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                inv[i][j] = augmented[i][j + n];
        return inv;
    }

    private static void solve(double[][] augmentedMatrix) {
        int nRows = augmentedMatrix.length, nCols = augmentedMatrix[0].length, lead = 0;
        for (int r = 0; r < nRows; r++) {
            if (lead >= nCols) break;
            int i = r;
            while (Math.abs(augmentedMatrix[i][lead]) < EPS) {
                if (++i == nRows) {
                    i = r;
                    if (++lead == nCols) return;
                }
            }
            double[] temp = augmentedMatrix[r];
            augmentedMatrix[r] = augmentedMatrix[i];
            augmentedMatrix[i] = temp;
            double lv = augmentedMatrix[r][lead];
            for (int j = 0; j < nCols; j++) augmentedMatrix[r][j] /= lv;
            for (i = 0; i < nRows; i++) {
                if (i != r) {
                    lv = augmentedMatrix[i][lead];
                    for (int j = 0; j < nCols; j++) augmentedMatrix[i][j] -= lv * augmentedMatrix[r][j];
                }
            }
            lead++;
        }
    }

    private static boolean isInconsistent(double[][] arr) {
        int nCols = arr[0].length;
        outer:
        for (int y = 0; y < arr.length; y++) {
            if (Math.abs(arr[y][nCols - 1]) > EPS) {
                for (int x = 0; x < nCols - 1; x++)
                    if (Math.abs(arr[y][x]) > EPS) continue outer;
                return true;
            }
        }
        return false;
    }

    private static boolean hasMultipleSolutions(double[][] arr) {
        int nCols = arr[0].length, nEmptyRows = 0;
        outer:
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < nCols; x++)
                if (Math.abs(arr[y][x]) > EPS) continue outer;
            nEmptyRows++;
        }
        return nCols - 1 > arr.length - nEmptyRows;
    }

}
