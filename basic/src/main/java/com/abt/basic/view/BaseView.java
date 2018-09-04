package com.abt.basic.view;

/**
 * @描述： @BaseView
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public interface BaseView {

    /**
     * Show error message
     *
     * @param errorMsg error message
     */
    void showErrorMsg(String errorMsg);

    /**
     * Show error
     */
    void showError();

    /**
     * Show loading
     */
    void showLoading();

    /**
     * Show login view
     */
    void showLoginView();

    /**
     * Show logout view
     */
    void showLogoutView();

    /**
     * Show collect fail
     */
    void showCollectFail();

    /**
     * Show cancel collect fail
     */
    void showCancelCollectFail();

    /**
     * Show collect success
     */
    void showCollectSuccess();

    /**
     * Show cancel collect success
     */
    void showCancelCollectSuccess();

}
