package com.abt.basic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.abt.basic.R;
import com.abt.basic.presenter.AbstractPresenter;
import com.abt.basic.util.CommonUtils;
import com.abt.basic.view.BaseView;

import javax.inject.Inject;

/**
 * @描述： @MVP模式的BaseFragment
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public abstract class BaseFragment<T extends AbstractPresenter> extends AbstractSimpleFragment implements BaseView {

    @Inject
    protected T mPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    // TODO
    /*public FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(BaseApp.getAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }*/

    @Override
    public void showErrorMsg(String errorMsg) {
        if (isAdded()) {
            CommonUtils.showSnackMessage(_mActivity, errorMsg);
        }
    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showCollectFail() {
        CommonUtils.showSnackMessage(_mActivity, getString(R.string.collect_fail));
    }

    @Override
    public void showCancelCollectFail() {
        CommonUtils.showSnackMessage(_mActivity, getString(R.string.cancel_collect_fail));
    }

    @Override
    public void showCollectSuccess() {

    }

    @Override
    public void showCancelCollectSuccess() {

    }

    @Override
    public void showLoginView() {

    }

    @Override
    public void showLogoutView() {

    }

    /**
     * 注入当前Fragment所需的依赖
     */
    protected abstract void initInject();

}
