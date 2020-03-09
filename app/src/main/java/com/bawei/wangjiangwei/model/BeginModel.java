package com.bawei.wangjiangwei.model;

import com.bawei.wangjiangwei.api.BeginApiServise;
import com.bawei.wangjiangwei.contract.BeginContract;
import com.bawei.wangjiangwei.model.entity.BeginEntity;
import com.bawei.wangjiangwei.util.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * data:2020/3/9
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class BeginModel implements BeginContract.IModel {
    @Override
    public void getBeginData(int page, int count, ModelCallback modelCallback) {
        NetUtils.getInstance().getCreat(BeginApiServise.class)
                .begin(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BeginEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BeginEntity beginEntity) {
                        modelCallback.BeginSuccess(beginEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelCallback.BeginError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
