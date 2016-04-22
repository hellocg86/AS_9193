package com.kf.framework;

import java.util.HashMap;

/**
 * Created by "蔡刚" on 16/4/22.
 */
public class Pay9133 implements IPay{

    @Override
    public boolean isSupportFunction(String functionName) {
        return false;
    }

    @Override
    public void pay(HashMap<String, Object> params) {

    }

    @Override
    public void getOrderInfo(HashMap<String, Object> params) {

    }
}
