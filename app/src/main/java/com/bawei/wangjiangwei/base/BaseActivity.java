package com.bawei.wangjiangwei.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.wangjiangwei.base.mvp.BasePresenter;
import com.bawei.wangjiangwei.base.mvp.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * data:2020/3/9
 * author:王江伟(DJ慢羊羊)
 * function:BaseActivity基类
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    //链接P层
    public P presenter;
    private Unbinder mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LayoutId());
        presenter = initPresenter();

        if (presenter != null) {
            presenter.attach(this);
        }
        //绑定ButterKnife
        mBind = ButterKnife.bind(this);
        initView();
        initData();

    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int LayoutId();

    //解绑
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detac();
        }
        if (presenter != null) {
            mBind.unbind();
        }
    }
}
