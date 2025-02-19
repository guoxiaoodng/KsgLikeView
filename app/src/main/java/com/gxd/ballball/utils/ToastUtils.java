package com.gxd.ballball.utils;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatTextView;

import com.gxd.ballball.R;

public class ToastUtils {

    private static long lastToastTime;
    private static long TIME = 1000;

    public static void showToast(Activity activity, int res, int duration) {
//        showToast(activity, StringUtils.getString(res), duration);
    }

    public static void showToast(Activity activity, String text) {
        showToast(activity, text, 1500);
    }

    public static void showToast(Activity context, String text, int duration) {
        try {
           /* if (StringUtils.isEmpty(text)) {
                return;
            }*/
            TIME = duration;
            LayoutInflater inflater = context.getLayoutInflater();
            View customView = inflater.inflate(R.layout.layout_toast, null);
            AppCompatTextView tvText = customView.findViewById(R.id.tv_text);
            tvText.setText(text);

            Toast toast = new Toast(context);
            toast.setDuration(duration);
            toast.setGravity(Gravity.BOTTOM, 0, 100);
            toast.setView(customView);
            toast.show();
        } catch (Exception e) {
//            LogUtils.e(e.toString());
        }
    }

    public static boolean isShowToast() {
        long time = System.currentTimeMillis();
        if (time - lastToastTime < TIME) {
            return true;
        }
        lastToastTime = time;
        return false;
    }
}
