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

        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='打开']").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='知乎日报']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='日报']").click();
        driver.findElementById("com.codeest.geeknews:id/fab_calender").click();
        driver.findElementById("com.codeest.geeknews:id/tv_calender_enter").click();
        driver.findElementById("com.codeest.geeknews:id/iv_top_image").click();
        driver.findElementById("com.codeest.geeknews:id/fab_like").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();

        driver.findElementByXPath("//android.widget.TextView[@text='主题']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='日常心理学']").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();

        driver.findElementByXPath("//android.widget.TextView[@text='专栏']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='深夜惊奇']").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();

        driver.findElementByXPath("//android.widget.TextView[@text='热门']").click();

        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='打开']").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='微信精选']").click();
        driver.findElementById("com.codeest.geeknews:id/action_search").click();
        driver.findElementById("com.codeest.geeknews:id/action_up_btn").click();
        driver.findElementById("com.codeest.geeknews:id/action_search").click();
        driver.findElementById("com.codeest.geeknews:id/searchTextView").sendKeys("测试");
        driver.sendKeyEvent(AndroidKeyCode.ENTER);
        driver.findElementsById("com.codeest.geeknews:id/tv_wechat_item_title").get(0).click();
        driver.findElementById("com.codeest.geeknews:id/action_like").click();
        driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='复制链接到剪贴板']").click();
        driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='分享链接']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();

        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='打开']").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='干货集中营']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='ANDROID']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='IOS']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='前端']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='福利']").click();

        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='打开']").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='收藏']").click();

        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='打开']").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='设置']").click();
        driver.findElementById("com.codeest.geeknews:id/cb_setting_cache").click();
        driver.findElementById("com.codeest.geeknews:id/cb_setting_image").click();
        driver.findElementById("com.codeest.geeknews:id/cb_setting_night").click();
        driver.findElementByXPath("//android.widget.TextView[@text='意见反馈']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.TextView[@text='清除缓存']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='检查更新']").click();

        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='打开']").click();
        driver.findElementByXPath("//android.widget.CheckedTextView[@text='关于']").click();
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
        File app = new File(appDir, "GeekNews.apk");

        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("appPackage", "com.codeest.geeknews");
        capabilities.setCapability("appActivity", "com.codeest.geeknews.ui.main.activity.WelcomeActivity");
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