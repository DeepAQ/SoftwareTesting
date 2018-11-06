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

        // toutiao
        driver.findElementById("cn.etouch.ecalendar:id/rl_toutiao_img").click();
        driver.findElementByXPath("//android.widget.TextView[@text='活动']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='推荐']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='养生']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='情感']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='亲子']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='历史']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='星座']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='娱乐']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='美食']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='社会']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='体育']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='旅游']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='教育']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='国际']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='科技']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='热点']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='搞笑']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='南京市']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='汽车']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='家居']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='小说']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='段子']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='奇闻']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='时尚']").click();
        driver.findElementById("cn.etouch.ecalendar:id/tv_more").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_edit").click();
        driver.findElementsById("cn.etouch.ecalendar:id/img_edit").get(0).click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_edit").click();
        driver.findElementById("cn.etouch.ecalendar:id/iv_close").click();
        driver.findElementsById("cn.etouch.ecalendar:id/layout").get(0).click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_collect").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_know").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_more").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_wxpy").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementById("cn.etouch.ecalendar:id/btn_more").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_wx_pyq").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementById("cn.etouch.ecalendar:id/btn_more").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_qq").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_more").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_qzone").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_more").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_sina").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_sms_life").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementById("cn.etouch.ecalendar:id/btn_more").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_copy2clip").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_more").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_other").click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementById("cn.etouch.ecalendar:id/btn_more").click();
        driver.findElementsById("cn.etouch.ecalendar:id/ll_item").get(1).click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
        driver.findElementById("cn.etouch.ecalendar:id/btn_more").click();
        driver.findElementById("cn.etouch.ecalendar:id/tv_cancel").click();
        driver.findElementById("cn.etouch.ecalendar:id/tv_comment").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/ettv_coment").click();
        driver.findElementById("cn.etouch.ecalendar:id/ettv_zan").click();
        driver.findElementById("cn.etouch.ecalendar:id/ettv_share").click();
        driver.findElementById("cn.etouch.ecalendar:id/tv_cancel").click();
        driver.findElementById("cn.etouch.ecalendar:id/button1").click();
        driver.findElementById("cn.etouch.ecalendar:id/rl_back_calendar").click();

        // switch
        driver.findElementById("cn.etouch.ecalendar:id/LinearLayout02").click();
        driver.findElementById("cn.etouch.ecalendar:id/textView_nongli").click();
        driver.findElementById("cn.etouch.ecalendar:id/textView_gongli").click();
        driver.findElementById("cn.etouch.ecalendar:id/button_ok").click();
        driver.findElementById("cn.etouch.ecalendar:id/LinearLayout02").click();
        driver.findElementById("cn.etouch.ecalendar:id/button_cancel").click();

        // menu
        driver.findElementById("cn.etouch.ecalendar:id/tv_add").click();
        driver.findElementById("cn.etouch.ecalendar:id/rl_note").click();
        driver.findElementById("cn.etouch.ecalendar:id/rl_todo").click();
        driver.findElementById("cn.etouch.ecalendar:id/rl_fes").click();
        driver.findElementById("cn.etouch.ecalendar:id/rl_alarm").click();
        driver.findElementById("cn.etouch.ecalendar:id/rl_task").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_save").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_back").click();

        // almanac
        driver.findElementById("cn.etouch.ecalendar:id/layout_almanac").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_share").click();
        driver.findElementById("cn.etouch.ecalendar:id/tv_cancel").click();
        driver.findElementById("cn.etouch.ecalendar:id/tv_almanac").click();
        driver.findElementById("cn.etouch.ecalendar:id/title_gtime").click();
        driver.findElementById("cn.etouch.ecalendar:id/button_cancel").click();
        driver.findElementById("cn.etouch.ecalendar:id/tv_date").click();
        driver.findElementById("cn.etouch.ecalendar:id/button_cancel").click();
        driver.findElementById("cn.etouch.ecalendar:id/img_pre_date").click();
        driver.findElementById("cn.etouch.ecalendar:id/img_next_date").click();
        driver.findElementById("cn.etouch.ecalendar:id/tv_year").click();
        driver.findElementById("cn.etouch.ecalendar:id/button_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/text_daoli").click();
        driver.findElementById("cn.etouch.ecalendar:id/button_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_yi_ji").click();
        driver.findElementById("cn.etouch.ecalendar:id/button_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/image_jiri_search").click();
        driver.findElementById("cn.etouch.ecalendar:id/text_ji").click();
        driver.findElementById("cn.etouch.ecalendar:id/text_yi").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/layout_compass").click();
        driver.findElementById("cn.etouch.ecalendar:id/iv_xi").click();
        driver.findElementById("cn.etouch.ecalendar:id/iv_fu").click();
        driver.findElementById("cn.etouch.ecalendar:id/iv_yang").click();
        driver.findElementById("cn.etouch.ecalendar:id/iv_yin").click();
        driver.findElementById("cn.etouch.ecalendar:id/iv_cai").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/tx_wuxing").click();
        driver.findElementById("cn.etouch.ecalendar:id/button_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/tx_chongsha").click();
        driver.findElementById("cn.etouch.ecalendar:id/button_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/tx_zhishen").click();
        driver.findElementById("cn.etouch.ecalendar:id/button_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_shieshen").click();
        driver.findElementById("cn.etouch.ecalendar:id/button_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_pengzu").click();
        driver.findElementById("cn.etouch.ecalendar:id/button_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_jishen").click();
        driver.findElementById("cn.etouch.ecalendar:id/button_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_taishen").click();
        driver.findElementById("cn.etouch.ecalendar:id/button_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_xiongshen").click();
        driver.findElementById("cn.etouch.ecalendar:id/button_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_xingxiu").click();
        driver.findElementById("cn.etouch.ecalendar:id/button_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_time_jixiong").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_almanac_fanyi").click();
        driver.findElementById("cn.etouch.ecalendar:id/button_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/tv_yunshi").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_back").click();

        // weather
        driver.findElementById("cn.etouch.ecalendar:id/relativeLayout_bottom_4").click();
        driver.findElementById("cn.etouch.ecalendar:id/layout_city").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_add").click();
        driver.findElementById("cn.etouch.ecalendar:id/edt_selectCity_input").sendKeys("北京");
        driver.findElementByXPath("//android.widget.TextView[@text='北京, 中国']").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_city_edit").click();
        driver.findElementById("cn.etouch.ecalendar:id/iv_edit").click();
        driver.findElementById("cn.etouch.ecalendar:id/tv_delete").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_environemnt").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_home").click();
        driver.findElementById("cn.etouch.ecalendar:id/et_ad_down").click();
        driver.findElementById("cn.etouch.ecalendar:id/button1").click();
        driver.findElementById("cn.etouch.ecalendar:id/rl_jump").click();
        driver.findElementById("cn.etouch.ecalendar:id/button1").click();

        // haoxue
        driver.findElementById("cn.etouch.ecalendar:id/relativeLayout_bottom_3").click();
        driver.findElementById("cn.etouch.ecalendar:id/iv_purchase").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_wallet").click();
        driver.findElementById("cn.etouch.ecalendar:id/tv_payment_record").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/ll_score").click();
        driver.findElementById("cn.etouch.ecalendar:id/button_back").click();
        driver.findElementByXPath("//android.widget.TextView[@text='¥118']").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_back").click();
        driver.findElementByXPath("//android.widget.TextView[@text='¥218']").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_back").click();
        driver.findElementByXPath("//android.widget.TextView[@text='¥488']").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/tv_back").click();
        driver.findElementById("cn.etouch.ecalendar:id/btn_back").click();

        // tabs
        driver.findElementById("cn.etouch.ecalendar:id/relativeLayout_bottom_1").click();
        driver.findElementById("cn.etouch.ecalendar:id/relativeLayout_bottom_2").click();
        driver.findElementById("cn.etouch.ecalendar:id/relativeLayout_bottom_0").click();
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
        File app = new File(appDir, "Zhwnl.apk");

        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("appPackage", "cn.etouch.ecalendar");
        capabilities.setCapability("appActivity", ".ECalendar");
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