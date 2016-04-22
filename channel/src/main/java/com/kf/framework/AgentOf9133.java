package com.kf.framework;

import android.app.Activity;
import android.content.Context;

import com.kf.framework.callback.IInitCallback;
import com.kf.framework.callback.IPayCallback;
import com.kf.framework.callback.IUserCallback;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by "蔡刚" on 16/4/22.
 */
public class AgentOf9133 extends ChannelBaseAggent{
    @Override
    public void initSDK(Context ctx, Hashtable<String, String> cpInfo, IInitCallback initCallback) {

    }

    @Override
    public void userLogin(Activity activity, IUserCallback listener) {

    }

    @Override
    public void pay(Activity activity, HashMap<String, Object> params, IPayCallback listener) {

    }

    @Override
    public void logout(Activity activity, IUserCallback listener) {

    }

    @Override
    public void changeAccount(Activity activity, IUserCallback listener) {

    }

    @Override
    public void exitDialog(Activity activity, IUserCallback listener) {

    }

    @Override
    public void exit() {

    }

    @Override
    public void userCenter(Activity activity) {

    }
}
