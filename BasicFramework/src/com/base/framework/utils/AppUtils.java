package com.base.framework.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.base.framework.common.base.BaseApplication;

import java.io.File;

/**
 * Created by tanchuanzhi on 2015/5/8.
 * 跟App相关的辅助类
 */
public class AppUtils {

        /**
         * 获取应用程序名称
         */
        public static String getAppName(Context context)
        {
            try
            {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(
                        context.getPackageName(), 0);
                int labelRes = packageInfo.applicationInfo.labelRes;
                return context.getResources().getString(labelRes);
            } catch (NameNotFoundException e)
            {
                e.printStackTrace();
            }
            return null;
        }
    /**
     * 获取应用versionName
     * @return
     */
    public static String getVersionName() {
        String version = "0";
        PackageManager packageManager = BaseApplication.getAppContext()
                                                       .getPackageManager();

        PackageInfo packInfo;
        try {
            packInfo = packageManager.getPackageInfo(BaseApplication.getAppContext().getPackageName(), 0);
            version = packInfo.versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

    /**
     * 获取应用versionCode this method is TODO
     *
     * @return 应用版本code
     * @createTime 2014年8月12日 上午11:41:15
     * @author tcz
     */
    public static int getVersionCode() {
        int version = 0;
        PackageManager packageManager = BaseApplication.getAppContext()
                                                       .getPackageManager();

        PackageInfo packInfo;
        try {
            packInfo = packageManager.getPackageInfo(BaseApplication
                                                             .getAppContext().getPackageName(), 0);
            version = packInfo.versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

    /**
     * 安装APK文件
     */
    public static void installApk(Context context,String filePath) {
        File apkFile = new File(filePath);
        if (!apkFile.exists()) {
            return;
        }
        // 通过Intent安装APK文件
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(Uri.parse("file://" + apkFile.toString()),
                         "application/vnd.android.package-archive");
        context.startActivity(i);
    }

}
