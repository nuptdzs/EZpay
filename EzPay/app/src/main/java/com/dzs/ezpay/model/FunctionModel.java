package com.dzs.ezpay.model;

/**
 * Created by Administrator on 2016/4/27.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class FunctionModel {
    int funcId;
    String funcName;
    Class Activity;
    String data;

    public FunctionModel(int funcId, String funcName, int funIconRes,String data,Class Activity) {
        this.funcId = funcId;
        this.funcName = funcName;
        this.funIconRes = funIconRes;
        this.Activity = Activity;
        this.data = data;
    }

    public Class getActivity() {
        return Activity;
    }

    public void setActivity(Class activity) {
        Activity = activity;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getFunIconRes() {
        return funIconRes;
    }

    public void setFunIconRes(int funIconRes) {
        this.funIconRes = funIconRes;
    }

    public int getFuncId() {
        return funcId;
    }

    public void setFuncId(int funcId) {
        this.funcId = funcId;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    int funIconRes;
}
