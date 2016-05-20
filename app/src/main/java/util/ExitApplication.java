package util;


import android.app.Activity;
import android.app.Application;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * 使用方法：
 * 1.在每个Activity的OnCreate()方法中调用ExitApplication.getInstance.addActivity(this)方法
 * 2.在监听事件中调用ExitApplication.getInstance.exit()方法
 */
public class ExitApplication extends Application {
    private static List<Activity>  activityList = new LinkedList();

    private static ExitApplication instance;

    private ExitApplication() {

    }

    // 单例模式中获取唯一的ExitApplication实例
    public static ExitApplication getInstance() {

        if (null == instance) {
            instance = new ExitApplication();
        }

        return instance;
    }

    // 添加到Activity容器中
    public void addActivity(Activity activity) {
        activityList.add(activity);

//        Log.v(">>>",activityList.size()+"<>"+activity.toString());
    }

    // 返回时,清除Activity
    public void clearActivity(Activity activity){
        activityList.remove(activity);
        activity.finish();
    }

    // 遍历所有Activity并finish
    public void exit() {
        for (Activity activity : activityList) {
            if (activity != null){
                activity.finish();
//                Log.v("雨",activity.toString());
            }
        }

//        Log.v("雨",String.valueOf(activityList.size()));

        android.os.Process.killProcess(android.os.Process.myPid());

        System.exit(0);

    }
}
