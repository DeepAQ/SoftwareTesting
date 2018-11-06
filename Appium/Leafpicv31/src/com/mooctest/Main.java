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
        int w = driver.manage().window().getSize().width;
        int h = driver.manage().window().getSize().height;
        try {
            waitForActivity(driver, "MainActivity");
            // 抽屉菜单
            driver.findElementByXPath("//android.widget.ImageButton[@index='0']").click();
            driver.findElementById("com.horaapps.leafpic:id/ll_drawer_hidden").click();
            driver.findElementByXPath("//android.widget.ImageButton[@index='0']").click();
            driver.findElementById("com.horaapps.leafpic:id/ll_drawer_Default").click();
            driver.findElementByXPath("//android.widget.ImageButton[@index='0']").click();
            driver.findElementById("com.horaapps.leafpic:id/ll_drawer_Wallpapers").click();
            driver.findElementById("android:id/button1").click();
            driver.findElementById("com.horaapps.leafpic:id/ll_drawer_Donate").click();
            driver.findElementById("com.horaapps.leafpic:id/button_donate_paypal").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            waitForActivity(driver, "DonateActivity");
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementById("com.horaapps.leafpic:id/ll_drawer_Setting").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementById("com.horaapps.leafpic:id/ll_drawer_About").click();
            driver.findElementById("com.horaapps.leafpic:id/ll_about_version").click();
            driver.findElementById("com.horaapps.leafpic:id/ll_about_license").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementById("com.horaapps.leafpic:id/ll_about_libs").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementById("com.horaapps.leafpic:id/ll_donald").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementById("com.horaapps.leafpic:id/ll_gilbert").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementById("com.horaapps.leafpic:id/ll_about_support_translate").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementById("com.horaapps.leafpic:id/ll_about_support_rate").click();
            driver.findElementById("com.horaapps.leafpic:id/ll_about_support_github").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            waitForActivity(driver, "AboutActivity");
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            waitForActivity(driver, "MainActivity");
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            // 搜索
            driver.findElementById("com.horaapps.leafpic:id/search_action").click();
            driver.findElementByXPath("//android.widget.ImageButton[@index='0']").click();
            // 排序
            driver.findElementById("com.horaapps.leafpic:id/sort_action").click();
            driver.findElementByXPath("//android.widget.TextView[@text='名称']").click();
            driver.findElementById("com.horaapps.leafpic:id/sort_action").click();
            driver.findElementByXPath("//android.widget.TextView[@text='日期']").click();
            driver.findElementById("com.horaapps.leafpic:id/sort_action").click();
            driver.findElementByXPath("//android.widget.TextView[@text='大小']").click();
            driver.findElementById("com.horaapps.leafpic:id/sort_action").click();
            driver.findElementByXPath("//android.widget.TextView[@text='升序排列']").click();
            driver.findElementById("com.horaapps.leafpic:id/sort_action").click();
            driver.findElementByXPath("//android.widget.TextView[@text='升序排列']").click();
            // 图库
            driver.findElementById("com.horaapps.leafpic:id/fab_camera").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementById("com.horaapps.leafpic:id/album_preview").click();
            // 筛选
            driver.findElementById("com.horaapps.leafpic:id/filter_menu").click();
            driver.findElementByXPath("//android.widget.TextView[@text='视频']").click();
            driver.findElementById("com.horaapps.leafpic:id/filter_menu").click();
            driver.findElementByXPath("//android.widget.TextView[@text='图像']").click();
            driver.findElementById("com.horaapps.leafpic:id/filter_menu").click();
            driver.findElementByXPath("//android.widget.TextView[@text='Gif 动态图']").click();
            driver.findElementById("com.horaapps.leafpic:id/filter_menu").click();
            driver.findElementByXPath("//android.widget.TextView[@text='全部']").click();
            // 选项
            driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='排除']").click();
            driver.findElementById("android:id/button2").click();
            driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='隐藏']").click();
            driver.findElementById("android:id/button2").click();
            driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='重命名']").click();
            driver.findElementById("android:id/button3").click();
            driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='删除']").click();
            driver.findElementById("android:id/button2").click();
            // 图片
            driver.findElementById("com.horaapps.leafpic:id/photo_preview").click();
            driver.findElementById("com.horaapps.leafpic:id/shareButton").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementById("com.horaapps.leafpic:id/deletePhoto").click();
            driver.findElementById("android:id/button2").click();
            driver.findElementById("com.horaapps.leafpic:id/rotatePhoto").click();
            driver.findElementByXPath("//android.widget.TextView[@text='向右旋转 90°']").click();
            driver.findElementById("com.horaapps.leafpic:id/rotatePhoto").click();
            driver.findElementByXPath("//android.widget.TextView[@text='向左旋转 90°']").click();
            driver.findElementById("com.horaapps.leafpic:id/rotatePhoto").click();
            driver.findElementByXPath("//android.widget.TextView[@text='旋转 180°']").click();
            // 编辑
            driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='编辑']").click();
            driver.findElementByXPath("//android.widget.ImageButton[@content-desc='转到上一层级']").click();
            driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='编辑']").click();
            driver.findElementById("com.horaapps.leafpic:id/crop_aspect_ratio_1_1").click();
            driver.findElementById("com.horaapps.leafpic:id/crop_aspect_ratio_3_4").click();
            driver.findElementById("com.horaapps.leafpic:id/crop_aspect_ratio_3_2").click();
            driver.findElementById("com.horaapps.leafpic:id/crop_aspect_ratio_16_9").click();
            driver.findElementById("com.horaapps.leafpic:id/crop_aspect_ratio_original").click();
            driver.findElementById("com.horaapps.leafpic:id/state_scale").click();
            driver.findElementById("com.horaapps.leafpic:id/state_aspect_ratio").click();
            driver.findElementById("com.horaapps.leafpic:id/state_rotate").click();
            driver.findElementById("com.horaapps.leafpic:id/wrapper_rotate_by_angle").click();
            driver.findElementById("com.horaapps.leafpic:id/wrapper_reset_rotate").click();
            driver.findElementById("com.horaapps.leafpic:id/menu_crop").click();
            // 其它选项
            driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='设为...']").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='复制到']").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='移动到']").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='重命名']").click();
            driver.findElementById("android:id/button3").click();
            driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='详情']").click();
            driver.findElementById("android:id/button1").click();
            driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='使用...编辑']").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='使用...打开']").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='上传']").click();
            // 设置
            driver.findElementByXPath("//android.widget.ImageView[@content-desc='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='更多选项']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='设置']").click();
            driver.findElementById("com.horaapps.leafpic:id/ll_excluded_album").click();
            try {
                driver.findElementById("com.horaapps.leafpic:id/UnExclude_icon").click();
            } catch (Exception ignored) {
            }
            driver.sendKeyEvent(AndroidKeyCode.BACK);
            driver.findElementById("com.horaapps.leafpic:id/ll_security").click();
            driver.findElementById("com.horaapps.leafpic:id/active_security_switch").click();
            driver.findElementById("com.horaapps.leafpic:id/security_password_edittxt").click();
            driver.findElementById("com.horaapps.leafpic:id/security_body_apply_hidden_switch").click();
            driver.findElementById("com.horaapps.leafpic:id/security_body_apply_delete_switch").click();
            driver.findElementById("android:id/button2").click();
            driver.findElementById("com.horaapps.leafpic:id/ll_basic_theme").click();
            driver.findElementById("com.horaapps.leafpic:id/ll_dark_basic_theme").click();
            driver.findElementById("com.horaapps.leafpic:id/ll_dark_amoled_basic_theme").click();
            driver.findElementById("com.horaapps.leafpic:id/ll_white_basic_theme").click();
            driver.findElementById("android:id/button1").click();
            driver.findElementById("com.horaapps.leafpic:id/ll_primaryColor").click();
            driver.findElementById("com.horaapps.leafpic:id/pickerPrimary").click();
            driver.findElementById("com.horaapps.leafpic:id/pickerPrimary2").click();
            driver.findElementById("android:id/button3").click();
            driver.findElementById("com.horaapps.leafpic:id/ll_accentColor").click();
            driver.findElementById("com.horaapps.leafpic:id/pickerAccent").click();
            driver.findElementById("android:id/button3").click();
            driver.swipe(w / 2, h * 3 / 4, w / 2, h / 4, 200);
            driver.findElementById("com.horaapps.leafpic:id/ll_custom_thirdAct").click();
            driver.findElementById("com.horaapps.leafpic:id/apply_theme_3th_act_enabled").click();
            driver.findElementById("com.horaapps.leafpic:id/pickerTransparent").click();
            driver.findElementById("android:id/button3").click();
            driver.sendKeyEvent(AndroidKeyCode.BACK);
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
        File app = new File(appDir, "Leafpicv31.apk");

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
        capabilities.setCapability("appWaitActivity", "com.horaapps.leafpic.MainActivity");
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