package net.mooctest;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ALUTest {

	@Test(timeout = 4000)
	public void test() {
		ALU alu = new ALU();

		assertEquals("0000000011101001", alu.integerRepresentation("233", 16));
		assertEquals("1111111100010111", alu.integerRepresentation("-233", 16));

		assertEquals("01000000010010010000111111011010", alu.ieee754("3.1415926", 32));
		assertEquals("1100000000001000000000000000000000000000000000000000000000000000", alu.ieee754("-3.00", 64));
		assertEquals("0000000000000000000000000000000000000000000000000000000000000000", alu.ieee754("0.0", 64));
		assertEquals("0011111111001101110100101111000111000000000000000000000000000000", alu.ieee754("0.233", 64));
		assertEquals("0100000001101101001", alu.ieee754("233", 64));
		assertEquals("", alu.ieee754("3.1415926", 0));
//
		assertEquals("0000001000", alu.floatRepresentation("0.01", 4, 5));

		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		assertEquals("00010100", alu.floatRepresentation("0.01", 2, 5));
		ps.flush();
		assertTrue(os.toString().trim().contains("-6"));
		assertTrue(os.toString().trim().contains("0000001010"));

		assertEquals("NaN", alu.floatRepresentation(String.valueOf(Integer.MAX_VALUE), 2, 5));
		assertEquals("+Inf", alu.floatRepresentation("2", -1, 1));

		assertEquals("233", alu.integerTrueValue("0000000011101001"));

		assertEquals("11.375", alu.floatTrueValue("01000001001101100000", 8, 11));
		assertEquals("-11.375", alu.floatTrueValue("11000001001101100000", 8, 11));
		assertEquals("+Inf", alu.floatTrueValue("01111111100000000000", 8, 11));
		assertEquals("-Inf", alu.floatTrueValue("11111111100000000000", 8, 11));
		assertEquals("NaN", alu.floatTrueValue("11111111100000000001", 8, 11));
		assertEquals("0", alu.floatTrueValue("10000000000000000000", 8, 11));
		assertEquals("-4.9591167925315254E-39", alu.floatTrueValue("10000000001101100000", 8, 11));

		assertEquals("10000", alu.oneAdder("1111"));

		assertEquals("000000111", alu.adder("0100", "0011", '0', 8));
		assertEquals("1000111", alu.adder("1100", "1011", '0', 6));
		assertEquals("0111111", alu.adder("1100", "0011", '0', 6));

		assertEquals("1000", alu.leftShift("0010", 2));
	}

}
