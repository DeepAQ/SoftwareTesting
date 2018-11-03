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
        try {
            // 引导页
            waitForActivity(driver, "GuidActivity");
            int w = driver.manage().window().getSize().width;
            int h = driver.manage().window().getSize().height;
            for (int i = 0; i < 3; i++) {
                driver.swipe(w * 3 / 4, h / 2, w / 4, h / 2, 200);
            }
            driver.findElementById("com.smzdm.client.android:id/iv_start").click();

            // 首页
            waitForActivity(driver, "HomeActivity");
            driver.findElementByXPath("//android.widget.TextView[@text='白菜专区']").click();

            // 白菜专区
            waitForActivity(driver, "BaicaiActivity");
            driver.findElementById("com.smzdm.client.android:id/tv_all_care").click();
            // 分享
            waitForActivity(driver, "CommonPagerActivity");
            driver.findElementById("com.smzdm.client.android:id/action_share").click();
            driver.findElementById("com.smzdm.client.android:id/shar_cancel").click();
            driver.findElementById("com.smzdm.client.android:id/action_share").click();
            driver.findElementById("com.smzdm.client.android:id/share_sina_ll").click();
            waitForActivity(driver, "WeiboSdkWebActivity");
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementById("com.smzdm.client.android:id/action_share").click();
            driver.findElementById("com.smzdm.client.android:id/share_wx_circle_ll").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementById("com.smzdm.client.android:id/action_share").click();
            driver.findElementById("com.smzdm.client.android:id/share_wx_ll").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementById("com.smzdm.client.android:id/action_share").click();
            driver.findElementById("com.smzdm.client.android:id/qq_shar_ll").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementById("com.smzdm.client.android:id/action_share").click();
            driver.findElementById("com.smzdm.client.android:id/qqzone_shar_ll").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementById("com.smzdm.client.android:id/action_share").click();
            driver.findElementById("com.smzdm.client.android:id/share_copy_ll").click();
            // 关注
            driver.findElementById("com.smzdm.client.android:id/btn_follow").click();
            // 关闭登录页面
            waitForActivity(driver, "LoginActivity");
            driver.findElementById("com.smzdm.client.android:id/iv_close").click();
            // 更多
            waitForActivity(driver, "CommonPagerActivity");
            driver.findElementById("com.smzdm.client.android:id/iv_arrow_more").click();
            // 内容
            waitForActivity(driver, "CommonPagerActivity");
            driver.findElementByXPath("//android.widget.TextView[@text='好价']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='全部']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='好文']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='原创']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='轻晒单']").click();
            driver.findElementByXPath("//android.widget.ToggleButton[@text='最新']").click();
            // 返回
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            waitForActivity(driver, "BaicaiActivity");
            driver.sendKeyEvent(AndroidKeyCode.BACK);

            // 搜索
            waitForActivity(driver, "HomeActivity");
            driver.findElementById("com.smzdm.client.android:id/action_search").click();
            waitForActivity(driver, "SearchActivity");
            driver.findElementById("com.smzdm.client.android:id/edit_text_search").sendKeys("笔记本");
            driver.findElementById("com.smzdm.client.android:id/iv_search").click();

            // 搜索结果
            waitForActivity(driver, "SearchResultActivity");
            driver.findElementById("com.smzdm.client.android:id/tv_guide").click();
            // 书签
            driver.findElementById("com.smzdm.client.android:id/iv_subscribe").click();
            // 关闭登录页面
            waitForActivity(driver, "LoginActivity");
            driver.findElementById("com.smzdm.client.android:id/iv_close").click();
            waitForActivity(driver, "SearchResultActivity");
            driver.findElementByXPath("//android.widget.RadioButton[@text='综合排序']").click();
            driver.findElementByXPath("//android.widget.RadioButton[@text='最新排序']").click();
            // 筛选
            driver.findElementById("com.smzdm.client.android:id/ll_filter").click();
            driver.findElementById("com.smzdm.client.android:id/iv_collapse").click();
            driver.findElementById("com.smzdm.client.android:id/ll_filter").click();
            driver.findElementByXPath("//android.widget.CheckedTextView[@text='电脑数码']").click();
            driver.findElementById("com.smzdm.client.android:id/tv_confirm").click();
            // Tab
            waitForActivity(driver, "SearchResultActivity");
            driver.findElementByXPath("//android.widget.TextView[@text='综合']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='好价']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='好文']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='好物']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='用户']").click();
            // 返回
            driver.findElementById("com.smzdm.client.android:id/iv_search_up").click();
        } finally {
            driver.quit();
        }
    }

    private void waitForActivity(AppiumDriver driver, String activity) {
        activity = "." + activity;
        while (!driver.currentActivity().contains(activity)) {
            System.out.println("- Waiting for " + activity);
            Thread.yield();
        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
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
        File app = new File(appDir, "Smzdm.apk");

        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");

        //设置安卓系统版本
//        capabilities.setCapability("platformVersion", "4.4");
        //设置apk路径
        capabilities.setCapability("app", app.getAbsolutePath());

        //设置app的主包名和主类名
        capabilities.setCapability("appPackage", "com.smzdm.client.android");
        capabilities.setCapability("appActivity", "com.smzdm.client.android.activity.WelComeActivity");
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