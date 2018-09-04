package com.abt.basic.presenter;

import com.abt.basic.view.BaseView;

/**
 * @描述： @Presenter基类
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public interface AbstractPresenter<T extends BaseView> {

    /**
     * 注入View
     *
     * @param view view
     */
    void attachView(T view);

    /**
     * 回收View
     */
    void detachView();

}
