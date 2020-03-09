package com.bawei.wangjiangwei.view.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.wangjiangwei.R;
import com.bawei.wangjiangwei.base.BaseActivity;
import com.bawei.wangjiangwei.base.mvp.BasePresenter;
import com.bawei.wangjiangwei.view.fragment.AboutFragment;
import com.bawei.wangjiangwei.view.fragment.BeginFragment;
import com.bawei.wangjiangwei.view.fragment.HotFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;

    List<String> mStrings = new ArrayList<>();
    List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void initData() {

        AboutFragment aboutFragment = new AboutFragment();
        BeginFragment beginFragment = new BeginFragment();
        HotFragment hotFragment = new HotFragment();

        mFragments.add(beginFragment);
        mFragments.add(aboutFragment);
        mFragments.add(hotFragment);

        mStrings.add("正在热映");
        mStrings.add("即将上映");
        mStrings.add("热门电影");

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mStrings.get(position);
            }
        });

        tab.setupWithViewPager(vp);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

}
