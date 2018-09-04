package com.abt.basic.activity;

import com.abt.basic.R;
import com.abt.basic.presenter.AbstractPresenter;
import com.abt.basic.util.CommonUtils;
import com.abt.basic.view.BaseView;

import javax.inject.Inject;

/**
 * @描述： @MVP模式的BaseActivity
 * @作者： @黄卫旗
 * @创建时间： @05/06/2018
 */
public abstract class BaseActivity<T extends AbstractPresenter> extends AbstractSimpleActivity implements BaseView {

    @Inject
    protected T mPresenter;

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    //TODO
    /*protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(BaseApp.getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }*/

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        CommonUtils.showSnackMessage(this, errorMsg);
    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showCollectFail() {
        CommonUtils.showSnackMessage(this, getString(R.string.collect_fail));
    }

    @Override
    public void showCancelCollectFail() {
        CommonUtils.showSnackMessage(this, getString(R.string.cancel_collect_fail));
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
     * 注入当前Activity所需的依赖
     */
    protected abstract void initInject();

}
