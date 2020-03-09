package com.bawei.wangjiangwei.base.mvp;

import java.lang.ref.WeakReference;

/**
 * data:2020/3/9
 * author:王江伟(DJ慢羊羊)
 * function:BasePresenter契约类
 */
public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView> {
    public M model;
    //使用弱引用
    private WeakReference<V> mVWeakReference;

    public BasePresenter() {
        model = initModel();
    }

    //绑定
    public void attach(V v){
        mVWeakReference = new WeakReference<>(v);
    }

    //解绑
    public void detac(){
        if (mVWeakReference != null) {
            mVWeakReference.clear();
            mVWeakReference=null;
        }
    }

    protected abstract M initModel();

    //外界提供view
    public V getView(){
        return mVWeakReference.get();
    }
}
