package com.kf.as9193;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.kf.framework.Params;
import com.kf.framework.SDKPluginWrapper;
import com.kf.framework.java.KFSDK;
import com.kf.framework.java.KFSDKPay;
import com.kf.framework.java.KFSDKStatistic;
import com.kf.framework.java.KFSDKUser;
import com.kf.utils.LogText;
import com.kf.utils.ToastBuilder;

import java.util.HashMap;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KFSDK.getInstance().init(this);
        testLogSave();
    }

    private void testLogSave() {
        String log = LogText.readLogClear(getApplicationContext());
        if (!log.equals("")) {
            ToastBuilder.make(this, log, ToastBuilder.MIDDLE_TOAST_SINGLE);
        }
    }

    public void login(View view) {
        KFSDKUser.getInstance().login();
    }

    public void logout(View view) {
        KFSDKUser.getInstance().logout();
    }

    public void switchAccout(View view) {
        KFSDKUser.getInstance().changeAccout();
    }

    public void exit(View view) {
        KFSDKUser.getInstance().exit();
    }

    public void pay(View view) {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put(Params.Pay.KEY_AMOUNT, "1");//购买商品金额
        params.put(Params.Pay.KEY_ORDER_NO, "");//订单号
        params.put(Params.Pay.KEY_SERVER_ID, "1");//服务器ID
        params.put(Params.Pay.KEY_PRODUCT_ID, "1");//购买商品的商品ID
        params.put(Params.Pay.KEY_PRODUCT_NUM, "1");//购买商品的数量
        params.put(Params.Pay.KEY_GAMEEXTEND, "");//额外参数,没有传""
        params.put(Params.Pay.KEY_NOTIFY_URL, "");//应用方提供的支付结果通知uri,没有先传任意测试字符串
        params.put(Params.Pay.KEY_CONIN_NAME, "金币");
        params.put(Params.Pay.KEY_RATE, "10");
        params.put(Params.Pay.KEY_ROLE_ID, "1");
        params.put(Params.Pay.KEY_ROLE_NAME, "11");
        params.put(Params.Pay.KEY_ROLE_LEVEL, "1");
        params.put(Params.Pay.KEY_PRODUCT_NAME, "商品名字");
        params.put(Params.Pay.KEY_SERVER_NAME, "dd");//服务器ID

        KFSDKPay.getInstance().pay(params);
    }

    public void getOrderInfo(View view) {
        String orderId = "1231231";
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put(Params.Pay.KEY_PAY_ORDER_ID, orderId);
        KFSDKPay.getInstance().getOrderInfo(params);
    }

    public void recordLogin(View view) {
        HashMap<String, String> params = new HashMap<String, String>();
        //用户标识：只用添加用户ID即可
        params.put(Params.Statistic.KEY_ROLE_USERMARK, KFSDKUser.getInstance().userId + "@bdgame");
        // 用户类型：0为临时账户，1为注册用户，2为第三方用户
        params.put(Params.Statistic.KEY_ROLE_USERTYPE, "1");
        // 服务器ID
        params.put(Params.Statistic.KEY_ROLE_SERVER_ID, "13");
        // 账户id
        params.put(Params.Statistic.KEY_ROLE_USERID, "879876546");
        // 账户account
        params.put(Params.Statistic.KEY_ROLE_USENICK, "account");
        KFSDKStatistic.getInstance().recordLogin(params);
    }

    public void recordRoleUp(View view) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put(Params.Statistic.KEY_ROLE_USERMARK, KFSDKUser.getInstance().userId + "@bdgame");
        params.put(Params.Statistic.KEY_ROLE_ID, "1");
        //角色账号
        params.put(Params.Statistic.KEY_ROLE_USERID, "lewan10086");
        // 角色等级
        params.put(Params.Statistic.KEY_ROLE_LEVEL, "15");
        // 服务器ID
        params.put(Params.Statistic.KEY_ROLE_SERVER_ID, "2");
        // 角色昵称
        params.put(Params.Statistic.KEY_ROLE_NAME, "lewan10086");
        //角色等级
        params.put(Params.Statistic.KEY_ROLE_GRADE, "10");
        // 服务器名称
        params.put(Params.Statistic.KEY_ROLE_SERVER_NAME, "服务器名称");

        KFSDKStatistic.getInstance().recordRoleUp(params);
    }

    public void recordRoleCreate(View view) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put(Params.Statistic.KEY_ROLE_USERMARK, KFSDKUser.getInstance().userId + "@bdgame");
        //角色id
        params.put(Params.Statistic.KEY_ROLE_ID, "1222");
        // 角色账号
        params.put(Params.Statistic.KEY_ROLE_USERID, "lewan10086");
        // 角色等级
        params.put(Params.Statistic.KEY_ROLE_LEVEL, "15");
        // 角色昵称
        params.put(Params.Statistic.KEY_ROLE_NAME, "角色昵称");
        // 服务器id
        params.put(Params.Statistic.KEY_ROLE_SERVER_ID, "2");
        // 服务器名称
        params.put(Params.Statistic.KEY_ROLE_SERVER_NAME, "服务器名称");
        KFSDKStatistic.getInstance().recordRoleCreate(params);
    }

    public void recordBtnClicked(View view) {
        HashMap<String, String> params = new HashMap<String, String>();
        // cp标示
        params.put(Params.Statistic.KEY_ROLE_USERMARK, KFSDKUser.getInstance().userId + "@bdgame");
        // 游戏名称
        params.put(Params.Statistic.KEY_ROLE_GAMENAME, "秦时明月2");
        params.put(Params.Statistic.KEY_BUTTON_NAME, "大招按钮");
        KFSDKStatistic.getInstance().recordBtnClicked(params);
    }

    @Override
    public void onResume() {
        SDKPluginWrapper.onResume();
        super.onResume();
    }

}
