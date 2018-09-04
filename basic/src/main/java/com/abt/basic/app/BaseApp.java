package com.abt.basic.app;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.abt.basic.core.dao.DaoMaster;
import com.abt.basic.core.dao.DaoSession;
import com.abt.basic.di.component.AppComponent;
import com.squareup.leakcanary.RefWatcher;

/**
 * @描述： @BaseApp
 * @作者： @黄卫旗
 * @创建时间： @06/06/2018
 */
public class BaseApp extends Application {

    private DaoSession mDaoSession;
    private static BaseApp instance;
    private RefWatcher refWatcher;
    private static volatile AppComponent appComponent;

    public static synchronized BaseApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initGreenDao();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, Constants.DB_NAME);
        SQLiteDatabase database = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        mDaoSession = daoMaster.newSession();
    }

    public static synchronized AppComponent getAppComponent() {
        if (appComponent == null) {
            //TODO
            /*appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();*/
        }
        return appComponent;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public static RefWatcher getRefWatcher(Context context) {
        BaseApp application = (BaseApp) context.getApplicationContext();
        return application.refWatcher;
    }
}
