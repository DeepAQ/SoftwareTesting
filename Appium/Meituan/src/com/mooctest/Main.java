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
        waitForActivity(driver, "MainActivity");
        driver.findElementById("com.sankuai.meituan:id/city_button").click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementsByXPath("//android.widget.TextView[@text='南京']").get(1).click();

        driver.findElementByXPath("//android.view.View[@content-desc='附近']").click();
        driver.findElementByXPath("//android.view.View[@content-desc='发现']").click();
        driver.findElementByXPath("//android.view.View[@content-desc='订单']").click();
        driver.findElementByXPath("//android.view.View[@content-desc='我的']").click();
        driver.findElementByXPath("//android.view.View[@content-desc='首页']").click();

        driver.findElementByXPath("//android.view.View[@content-desc='美食']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='优惠团购']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.TextView[@text='附近好券']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.TextView[@text='预约订座']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.TextView[@text='外卖']").click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.TextView[@text='新店特惠']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.TextView[@text='自助餐']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.TextView[@text='火锅']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.TextView[@text='江浙菜']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);

        driver.findElementById("com.sankuai.meituan:id/food_list_map_menu_img").click();
        driver.findElementById("com.sankuai.meituan:id/food_search_header_search").click();
        driver.findElementByXPath("//android.widget.TextView[@text='新街口地区']").click();
        driver.findElementById("com.sankuai.meituan:id/food_map_location_button").click();
        driver.findElementById("com.sankuai.meituan:id/food_search_header_back").click();

        driver.findElementById("com.sankuai.meituan:id/tv_search_text").click();
        driver.findElementById("com.sankuai.meituan:id/search_edit").sendKeys("小龙虾");
        driver.findElementById("com.sankuai.meituan:id/search").click();
        driver.findElementById("com.sankuai.meituan:id/category").click();
        driver.findElementByXPath("//android.widget.TextView[@text='美食']").click();
        driver.findElementById("com.sankuai.meituan:id/category").click();
        driver.swipe(800, 600, 800, 200, 500);
        driver.swipe(800, 600, 800, 200, 500);
        driver.swipe(800, 600, 800, 200, 500);
        driver.swipe(800, 600, 800, 200, 500);
        driver.swipe(800, 600, 800, 200, 500);
        driver.findElementByXPath("//android.widget.TextView[@text='海鲜']").click();
        driver.findElementById("com.sankuai.meituan:id/area").click();
        driver.findElementByXPath("//android.widget.TextView[@text='鼓楼区']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='新街口/金轮/五台山体育中心']").click();
        driver.findElementById("com.sankuai.meituan:id/sort").click();
        driver.findElementByXPath("//android.widget.TextView[@text='好评优先']").click();
        driver.findElementById("com.sankuai.meituan:id/senior_filter").click();
        driver.findElementByXPath("//android.widget.TextView[@text='5~10人餐']").click();
        driver.findElementById("com.sankuai.meituan:id/bottom_confirm").click();

        driver.findElementsById("com.sankuai.meituan:id/image").get(0).click();
        driver.findElementById("com.sankuai.meituan:id/favor").click();
        driver.findElementById("com.sankuai.meituan:id/share").click();
        driver.findElementById("com.sankuai.meituan:id/share_cancel").click();
        driver.findElementById("com.sankuai.meituan:id/share").click();
        driver.findElementByXPath("//android.widget.TextView[@text='微信好友']"); //.click();
//        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.TextView[@text='朋友圈']"); //.click();
//        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.TextView[@text='复制']").click();
        driver.findElementById("com.sankuai.meituan:id/share").click();
        driver.findElementByXPath("//android.widget.TextView[@text='更多']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);

        driver.findElementById("com.sankuai.meituan:id/food_poi_top_image").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();
        driver.findElementById("com.sankuai.meituan:id/food_poi_address_container").click();
        driver.findElementById("com.sankuai.meituan:id/food_header_back").click();
        driver.findElementById("com.sankuai.meituan:id/food_poi_taxi_img").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementById("com.sankuai.meituan:id/food_poi_telephone_img").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementByXPath("//android.widget.TextView[@text='优惠信息']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='用户评论']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='商家信息']").click();

        driver.quit();
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
        File app = new File(appDir, "Meituan.apk");

        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        //设置apk路径
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.sankuai.meituan");
        capabilities.setCapability("appActivity", "com.meituan.android.pt.homepage.activity.Welcome");

        //设置使用unicode键盘，支持输入中文和特殊字符
        capabilities.setCapability("unicodeKeyboard", "true");
        //设置用例执行完成后重置键盘
        capabilities.setCapability("resetKeyboard", "true");
        capabilities.setCapability("noSign", "true");

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