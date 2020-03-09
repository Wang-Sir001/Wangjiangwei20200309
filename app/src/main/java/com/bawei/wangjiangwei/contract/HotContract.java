package com.bawei.wangjiangwei.contract;

import com.bawei.wangjiangwei.base.mvp.IBaseModel;
import com.bawei.wangjiangwei.base.mvp.IBaseView;
import com.bawei.wangjiangwei.model.entity.HotEntity;

/**
 * data:2020/3/9
 * author:王江伟(DJ慢羊羊)
 * function:热门电影的契约类
 */
public interface HotContract {
    interface IModel extends IBaseModel {
        void getHotData(int page,int count,ModelCallback modelCallback);

        interface ModelCallback{
            void HotSuccess(HotEntity hotEntity);
            void HotError(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void HotSuccess(HotEntity hotEntity);
        void HotError(Throwable throwable);
    }
    interface IPresnter{
        void getHotData(int page,int count);
    }
}
