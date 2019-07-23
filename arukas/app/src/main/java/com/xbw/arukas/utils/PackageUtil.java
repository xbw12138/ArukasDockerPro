package com.xbw.arukas.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.xbw.arukas.Config.Config;

import java.util.ArrayList;
import java.util.List;

public class PackageUtil {
    /**
     * 跳转其他app  跳转首个activity不需要 export
     * @param context 上下文
     * @param packageName 全包名
     * @param className 首个activity名称
     */
    public static void jumpToApp(Context context,String packageName, String className, String f, String data, int flag) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        Bundle bundle = new Bundle();
        bundle.putString(f, data);
        intent.setFlags(flag);
        intent.putExtras(bundle);
        ComponentName cn = new ComponentName(packageName, className);
        intent.setComponent(cn);
        context.startActivity(intent);
    }

    /**
     * 判断app是否安装
     * @param context 上下文
     * @param packageName 全包名
     * @return
     */
    public static boolean isAppInstalled(Context context, String packageName) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        List<String> pName = new ArrayList<String>();
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                pName.add(pn);
            }
        }
        return pName.contains(packageName);
    }
    /**
     * 打开外部浏览器下载
     * @param context
     * @param downloadWebUrl
     */
    public static void jumpToWeb(Context context ,String downloadWebUrl) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(downloadWebUrl);
        intent.setData(content_url);
        context.startActivity(intent);
    }

}
