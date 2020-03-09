package com.bawei.wangjiangwei.contract;

import com.bawei.wangjiangwei.base.mvp.IBaseModel;
import com.bawei.wangjiangwei.base.mvp.IBaseView;
import com.bawei.wangjiangwei.model.entity.BeginEntity;

/**
 * data:2020/3/9
 * author:王江伟(DJ慢羊羊)
 * function:正在热映的契约类
 */
public interface BeginContract {
    interface IModel extends IBaseModel {
        void getBeginData(int page,int count,ModelCallback modelCallback);

        interface ModelCallback {
            void BeginSuccess(BeginEntity beginEntity);
            void BeginError(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void BeginSuccess(BeginEntity beginEntity);
        void BeginError(Throwable throwable);
    }
    interface IPresenter{
        void getBeginData(int page,int count);
    }
}
