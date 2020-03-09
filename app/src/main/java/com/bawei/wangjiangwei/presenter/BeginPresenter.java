package com.bawei.wangjiangwei.presenter;

import com.bawei.wangjiangwei.base.mvp.BasePresenter;
import com.bawei.wangjiangwei.contract.BeginContract;
import com.bawei.wangjiangwei.model.BeginModel;
import com.bawei.wangjiangwei.model.entity.BeginEntity;

/**
 * data:2020/3/9
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class BeginPresenter extends BasePresenter<BeginModel, BeginContract.IView> implements BeginContract.IPresenter {
    @Override
    protected BeginModel initModel() {
        return new BeginModel();
    }

    @Override
    public void getBeginData(int page, int count) {
        model.getBeginData(page, count, new BeginContract.IModel.ModelCallback() {
            @Override
            public void BeginSuccess(BeginEntity beginEntity) {
                getView().BeginSuccess(beginEntity);
            }

            @Override
            public void BeginError(Throwable throwable) {
                getView().BeginError(throwable);
            }
        });
    }
}
