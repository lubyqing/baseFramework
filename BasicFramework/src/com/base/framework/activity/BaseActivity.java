package com.base.framework.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.base.framework.common.base.AppManager;
import com.base.framework.utils.ToastUtils;

/**
 * 窗口基类
 * 
 */
@SuppressLint("NewApi")
public class BaseActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 添加Activity到堆栈
        AppManager.getAppManager().addActivity(this);
    }


    /**
     * 以无参数的模式启动Activity。
     * 
     * @param activityClass
     */
    public void startActivity(Class<? extends Activity> activityClass) {
        startActivity(getLocalIntent(activityClass, null));
     //   me.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }
    
    /**
     * 以绑定参数的模式启动Activity。
     * 
     * @param activityClass
     */
    public void startActivity(Class<? extends Activity> activityClass, Bundle bd) {
        startActivity(getLocalIntent(activityClass, bd));
    //    me.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }
    
    /**
     * 在底部显示一条toast信息,大约3秒钟时间。<br>
     * 若想让toast显示时间较长，请调用showLongMessage
     * 
     * @param msg
     */
    public void showMessage(Object msg) {
        Toast.makeText(this, msg + "", Toast.LENGTH_SHORT).show();
    }
    
    /**
     * 以较长的时间来toast显示，大约5秒钟显示。
     * 
     * @param msg
     */
    public void showLongMessage(String msg) {
        ToastUtils.showLongMessage(this, msg);
    }
    
    /**
     * 显示消息提示，避免重复提示
     * 
     * @param msg
     */
    public void showToast(String msg) {
        ToastUtils.showShortMessage(this, msg);
    }

    @Override
    protected void onDestroy() {
        AppManager.getAppManager().finishActivity(this);

        super.onDestroy();
    }

    /**
     * 获取当前程序中的本地目标
     *
     * @param localIntent
     * @return
     */
    public Intent getLocalIntent(Class<? extends Context> localIntent, Bundle bd) {
        Intent intent = new Intent(this, localIntent);
        if (null != bd) {
            intent.putExtras(bd);
        }
        return intent;
    }

}
