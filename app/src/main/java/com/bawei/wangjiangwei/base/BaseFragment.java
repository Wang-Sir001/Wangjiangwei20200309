package com.bawei.wangjiangwei.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bawei.wangjiangwei.base.mvp.BasePresenter;
import com.bawei.wangjiangwei.base.mvp.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * data:2020/3/9
 * author:王江伟(DJ慢羊羊)
 * function:BaseFragment基类
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {

    public P presenter;
    private Unbinder mBind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(LayoutId(), container, false);

        presenter = initPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        mBind = ButterKnife.bind(this, inflate);

        initView(inflate);

        return inflate;
    }

    protected abstract void initView(View inflate);

    protected abstract P initPresenter();

    protected abstract int LayoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.detac();
        }
        if (presenter != null) {
            mBind.unbind();
        }
    }
}
