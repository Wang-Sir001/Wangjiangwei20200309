package com.bawei.wangjiangwei.view.fragment;

import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.wangjiangwei.R;
import com.bawei.wangjiangwei.base.BaseFragment;
import com.bawei.wangjiangwei.contract.BeginContract;
import com.bawei.wangjiangwei.model.adapter.BeginAdapter;
import com.bawei.wangjiangwei.model.entity.BeginEntity;
import com.bawei.wangjiangwei.presenter.BeginPresenter;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BeginFragment extends BaseFragment<BeginPresenter> implements BeginContract.IView {

    @BindView(R.id.recy)
    RecyclerView recy;

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected BeginPresenter initPresenter() {
        return new BeginPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_begin;
    }

    @Override
    protected void initData() {
        presenter.getBeginData(1, 5);
    }

    @Override
    public void BeginSuccess(BeginEntity beginEntity) {
        List<BeginEntity.ResultBean> result = beginEntity.getResult();
        BeginAdapter beginAdapter = new BeginAdapter(getActivity(),result);
        recy.setAdapter(beginAdapter);
        Log.i("xxx",result.get(1).getName());
    }

    @Override
    public void BeginError(Throwable throwable) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
