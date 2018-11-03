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

        waitForActivity(driver, "PrivacyActivity");
        driver.findElementById("com.jingdong.app.mall:id/btb").click();
        driver.findElementById("com.jingdong.app.mall:id/l5").click();

        waitForActivity(driver, "MainFrameActivity");
        driver.findElementByXPath("//android.widget.FrameLayout[@content-desc='首页']").click();
        driver.findElementByXPath("//android.widget.FrameLayout[@content-desc='分类']").click();
        driver.findElementByXPath("//android.widget.FrameLayout[@content-desc='购物车']").click();
        driver.findElementByXPath("//android.widget.FrameLayout[@content-desc='我的']").click();
        driver.findElementByXPath("//android.widget.FrameLayout[@content-desc='发现']").click();

        driver.findElementById("com.jingdong.app.mall:id/k5").click();
        driver.findElementById("com.jingdong.app.mall:id/k5").click();
        driver.findElementById("com.jd.lib.scan:id/iv_back").click();
        driver.findElementById("com.jingdong.app.mall:id/ak4").click();
        driver.findElementById("com.jd.lib.meme:id/title_back").click();
        driver.findElementById("com.jingdong.app.mall:id/bp6").click();
        driver.findElementById("com.jd.lib.login:id/login_newtitle_back").click();
        driver.findElementByXPath("//android.widget.TextView[@text='关注']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='精选']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='视频']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='直播']").click();

        driver.findElementByXPath("//android.widget.FrameLayout[@content-desc='首页']").click();
        driver.findElementById("com.jingdong.app.mall:id/a2z").click();
        driver.findElementById("com.jd.lib.search:id/search_text").sendKeys("耳机");
        driver.findElementById("com.jingdong.app.mall:id/avs").click();

        driver.findElementById("com.jd.lib.search:id/switch_grid_list").click();
        driver.findElementById("com.jd.lib.search:id/switch_grid_list").click();
        driver.findElementById("com.jd.lib.search:id/iv_search_recommend_banner").click();
        driver.findElementById("com.jingdong.app.mall:id/fg").click();

        driver.findElementById("com.jd.lib.search:id/sort_search_button_composite").click();
        driver.findElementById("com.jd.lib.search:id/sort_button_commentnum").click();
        driver.findElementById("com.jd.lib.search:id/sort_search_button_composite").click();
        driver.findElementById("com.jd.lib.search:id/sort_new_product").click();
        driver.findElementById("com.jd.lib.search:id/sort_search_button_composite").click();
        driver.findElementById("com.jd.lib.search:id/sort_button_synthesis").click();

        driver.findElementById("com.jd.lib.search:id/sort_search_button_price").click();
        driver.findElementById("com.jd.lib.search:id/sort_search_button_sales").click();
        driver.findElementById("com.jd.lib.search:id/sort_search_button_filter").click();
        driver.findElementById("com.jd.lib.search:id/product_filter_address_txt").click();
        driver.findElementByXPath("//android.widget.TextView[@text='江苏']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='南京市']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='鼓楼区']").click();
        driver.findElementByXPath("//android.widget.CheckBox[@text='仅看有货']").click();
        driver.findElementsById("com.jd.lib.search:id/product_filter_iv").get(1).click();
        driver.findElementByXPath("//android.widget.CheckBox[@text='索尼（SONY）']").click();
        driver.swipe(800, 600, 800, 200, 500);
        driver.findElementByXPath("//android.widget.CheckBox[@text='耳机']").click();
        driver.findElementById("com.jd.lib.search:id/filter_bottom_confirm").click();


        driver.findElementsById("com.jd.lib.search:id/product_list_item_image").get(0).click();
        driver.findElementByXPath("//android.widget.ImageView[@content-desc='图片1']").click();
        driver.findElementById("com.jingdong.app.mall:id/ag").click();
        driver.findElementById("com.jd.lib.productdetail:id/pd_nav_share").click();
        driver.findElementByXPath("//android.widget.TextView[@text='微信好友']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementById("com.jd.lib.productdetail:id/pd_nav_share").click();
        driver.findElementByXPath("//android.widget.TextView[@text='朋友圈']").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementById("com.jd.lib.productdetail:id/pd_nav_share").click();
        driver.findElementByXPath("//android.widget.TextView[@text='QQ好友']").click();
//        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementById("com.jd.lib.productdetail:id/pd_nav_share").click();
        driver.findElementByXPath("//android.widget.TextView[@text='QQ空间']").click();
//        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementById("com.jd.lib.productdetail:id/pd_nav_share").click();
        driver.findElementByXPath("//android.widget.TextView[@text='新浪微博']").click();
//        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementById("com.jd.lib.productdetail:id/pd_nav_share").click();
        driver.findElementByXPath("//android.widget.TextView[@text='复制链接']").click();
        driver.findElementById("com.jd.lib.productdetail:id/pd_nav_share").click();
        driver.findElementById("com.jingdong.app.mall:id/c1p").click();

        driver.findElementById("com.jd.lib.productdetail:id/pd_nav_more").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementById("com.jd.lib.productdetail:id/detail_reduce_notice_layout").click();
        driver.findElementById("com.jd.lib.login:id/login_newtitle_back").click();
        driver.findElementById("com.jd.lib.productdetail:id/detail_price_concern_layout").click();
        driver.findElementById("com.jd.lib.login:id/login_newtitle_back").click();
        driver.findElementById("com.jd.lib.productdetail:id/detail_desc_overtax_icon").click();
        driver.findElementById("com.jingdong.app.mall:id/ata").click();
        driver.findElementById("com.jd.lib.productdetail:id/detail_desc_overtax_icon").click();
        driver.findElementById("com.jingdong.app.mall:id/atk").click();

        driver.findElementById("com.jd.lib.productdetail:id/detail_promotion_layout").click();
        driver.findElementById("com.jingdong.app.mall:id/ata").click();
        driver.findElementById("com.jd.lib.productdetail:id/dongdong_layout").click();
        driver.findElementById("com.jd.lib.login:id/login_newtitle_back").click();
        driver.findElementById("com.jd.lib.productdetail:id/goto_shopcar").click();
        driver.findElementById("com.jingdong.app.mall:id/avi").click();
        driver.findElementById("com.jd.lib.productdetail:id/add_2_car").click();
        driver.findElementById("com.jd.lib.productdetail:id/detail_style_cancel").click();
        driver.findElementById("com.jd.lib.productdetail:id/add_2_car").click();
        driver.findElementById("com.jd.lib.productdetail:id/detail_style_add_2_car").click();

        driver.swipe(800, 1600, 800, 200, 500);
        driver.findElementById("com.jd.lib.productdetail:id/pd_tab1").click();
        driver.findElementById("com.jd.lib.productdetail:id/pd_tab2").click();
        driver.findElementById("com.jd.lib.productdetail:id/pd_tab3").click();
        driver.findElementById("com.jd.lib.productdetail:id/pd_tab4").click();

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
        File app = new File(appDir, "JDmall.apk");

        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        //设置apk路径
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.jingdong.app.mall");
        capabilities.setCapability("appActivity", ".main.MainActivity");

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