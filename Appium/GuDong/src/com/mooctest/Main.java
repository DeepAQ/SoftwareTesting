package com.mooctest;

import io.appium.java_client.AndroidKeyCode;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Main {

    /**
     * 所有和AppiumDriver相关的操作都必须写在该函数中
     *
     * @param driver
     */
    public void test(AppiumDriver driver) {
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS); //设置尝试定位控件的最长时间为8s,也就是最多尝试8s
        /*
         * 余下的测试逻辑请按照题目要求进行编写
         */

        driver.findElementByXPath("//android.widget.Button[@text='确定']").click();
        driver.findElementByXPath("//android.widget.Button[@text='取消']").click();

        driver.findElementById("name.gudong.translate:id/menu_book").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();
        waitForActivity(driver, "MainActivity");

        driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='历史记录']").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();
        waitForActivity(driver, "MainActivity");

        driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='支持作者']").click();
        driver.findElementById("android:id/button3").click();
        driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='支持作者']").click();
        driver.findElementById("android:id/button1").click();

        driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='去评分']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        waitForActivity(driver, "MainActivity");

        driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='关于(1.8.0)']").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();

        driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='设置']").click();
        driver.findElementByXPath("//android.widget.Button[@text='知道了']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='开启划词翻译']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='开启自动发音']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='打开 App 自动翻译粘贴板单词']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='开启定时单词提醒']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='背单词提示间隔时间']").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='半小时']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='提示显示时间']").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='2秒钟']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='开启单词联想输入']").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();

        driver.findElementById("android:id/input").sendKeys("test");
        driver.findElementById("name.gudong.translate:id/tv_clear").click();
        driver.findElementById("android:id/input").sendKeys("test");
        driver.findElementById("android:id/input").click();
        driver.findElementById("name.gudong.translate:id/sp_translate_way").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='金山']").click();
        driver.findElementById("name.gudong.translate:id/sp_translate_way").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='谷歌']").click();
        driver.findElementById("name.gudong.translate:id/sp_translate_way").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='百度']").click();
        driver.findElementById("name.gudong.translate:id/sp_translate_way").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='有道']").click();
        driver.findElementById("name.gudong.translate:id/bt_translate").click();

        driver.findElementById("name.gudong.translate:id/iv_favorite").click();
        driver.findElementById("name.gudong.translate:id/iv_sound").click();
        driver.findElementById("name.gudong.translate:id/iv_paste").click();
    }

    private void waitForActivity(AppiumDriver driver, String activity) {
        activity = "." + activity;
        while (!driver.currentActivity().contains(activity)) {
            System.out.println("- Waiting for " + activity);
            Thread.yield();
        }
        System.out.println(">> Begin " + activity);
    }

    /**
     * AppiumDriver的初始化逻辑必须写在该函数中
     *
     * @return
     */
    public AppiumDriver initAppiumTest() {

        AppiumDriver driver = null;
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apk");
        File app = new File(appDir, "GuDong.apk");

        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("appPackage", "name.gudong.translate");
        capabilities.setCapability("appActivity", "name.gudong.translate.ui.activitys.MainActivity");
        capabilities.setCapability("noSign", "true");

        //设置apk路径
        capabilities.setCapability("app", app.getAbsolutePath());

        //设置使用unicode键盘，支持输入中文和特殊字符
        capabilities.setCapability("unicodeKeyboard", "true");
        //设置用例执行完成后重置键盘
        capabilities.setCapability("resetKeyboard", "true");
        //初始化
        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return driver;
    }

    public void start() {
        test(initAppiumTest());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }


}