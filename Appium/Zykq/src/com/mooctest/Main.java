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

        // permission
        driver.findElementById("com.freshideas.airindex:id/rtp_permission_next_btn").click();
        driver.findElementById("android:id/button2").click();

        // AQI
        driver.findElementById("com.freshideas.airindex:id/menu_share_id").click();
        driver.findElementByXPath("//android.widget.TextView[@text='保存到相册']").click();
        driver.findElementById("android:id/button2").click();
        driver.findElementByXPath("//android.widget.TextView[@text='微博']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='关闭']").click();
        driver.findElementById("com.freshideas.airindex:id/menu_share_id").click();
        driver.findElementByXPath("//android.widget.TextView[@text='微信朋友圈']").click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementById("com.freshideas.airindex:id/menu_share_id").click();
        driver.findElementByXPath("//android.widget.TextView[@text='微信好友']").click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementById("com.freshideas.airindex:id/menu_share_id").click();
        driver.findElementByXPath("//android.widget.TextView[@text='QQ']").click();
        driver.findElementById("com.freshideas.airindex:id/menu_share_id").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Twitter']").click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementById("com.freshideas.airindex:id/menu_share_id").click();
        driver.findElementByXPath("//android.widget.TextView[@text='邮箱']").click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementById("android:id/button2").click();
        driver.findElementById("com.freshideas.airindex:id/menu_share_id").click();
        driver.findElementByXPath("//android.widget.TextView[@text='更多']").click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementById("com.freshideas.airindex:id/dashboard_footer_layout").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();
        driver.findElementById("com.freshideas.airindex:id/dashboard_section_close").click();
        driver.findElementById("com.freshideas.airindex:id/dashboard_promote_btn").click();

        // details
        driver.findElementsById("com.freshideas.airindex:id/dashboard_name").get(0).click();
        driver.findElementById("com.freshideas.airindex:id/detail_info_id").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.TextView[@text='PM10']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.TextView[@text='PM2.5']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.TextView[@text='O3']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.TextView[@text='NO2']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.TextView[@text='CO']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.TextView[@text='SO2']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();

        // menu
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='在意空气']").click();
        driver.findElementById("com.freshideas.airindex:id/mainNav_accountLayout_id").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='在意空气']").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='发现']").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='在意空气']").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='编辑设备列表']").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='在意空气']").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='设置']").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='在意空气']").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='关于']").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();

        // map
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='在意空气']").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='空气质量地图']").click();
        driver.findElementById("com.freshideas.airindex:id/map_replayLayout_id").click();
        driver.findElementById("com.freshideas.airindex:id/map_menuBtn_id").click();

        // ranking
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='在意空气']").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='排行榜']").click();
        driver.findElementById("com.freshideas.airindex:id/rank_id").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();
        driver.findElementById("com.freshideas.airindex:id/rank_worst_id").click();
        driver.findElementById("com.freshideas.airindex:id/rank_best_id").click();

        // locations
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='在意空气']").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='编辑收藏地点列表']").click();
        driver.findElementById("com.freshideas.airindex:id/menu_add_id").click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();
        driver.findElementsById("com.freshideas.airindex:id/modifyCityItem_trash_id").get(0).click();
        driver.findElementById("com.freshideas.airindex:id/modifyCityItem_delBtn_id").click();
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
        File app = new File(appDir, "Zykq.apk");

        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("appPackage", "com.freshideas.airindex");
        capabilities.setCapability("appActivity", ".MainActivity");
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