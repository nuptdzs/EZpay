package com.dzs.ezpay.common;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

/**
 * 抽象的基础fragment，封装一些共有的fragment操作，实现IBaseView接口 可供presenter调用
 */
public abstract class BaseFragment extends Fragment implements IBaseView{
    protected View rootView;
    private Toast toast;
    private ProgressDialog progressDialog;

    protected abstract void initView();

    /**
     * 如果存在toast 就不再创建新的 只对原来的toast进行修改
     * @param msg
     */
    @Override
    public void showToast(String msg) {
        if(null == toast){
            toast = Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT);
        }else {
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * 同理 展示加载框
     * @param msg
     */
    @Override
    public void showLoading(String msg) {
        if(null == progressDialog){
            progressDialog = new ProgressDialog(getContext());
        }
        progressDialog.setMessage(msg);
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        if(null != progressDialog){
            progressDialog.dismiss();
        }
    }

    @Override
    public Intent _getIntent() {
        return getActivity().getIntent();
    }
}
