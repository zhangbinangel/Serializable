package cn.panasonic.com.litepal;

import org.litepal.LitePalApplication;

/**
 * Created by Administrator on 2016/11/8.
 */

public class MyApplication extends LitePalApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        LitePalApplication.initialize(this);
    }
}
