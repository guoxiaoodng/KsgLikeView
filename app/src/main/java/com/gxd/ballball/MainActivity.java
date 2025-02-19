package com.gxd.ballball;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.gxd.ballball.utils.ToastUtils;
import com.gxd.ballball.R;

/**
 * @ClassName: MainActivity
 * @Author: KaiSenGao
 * @CreateDate: 2019-09-17 14:23
 * @Description: 啦啦啦啦啦 德玛西亚
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
    }

    public void intentNormal(View view) {
        this.startActivity(new Intent(this, NormalActivity.class));
    }

    public void intentRecycler(View view) {
        com.gxd.ballball.utils.ToastUtils.showToast(this, "开发中...");
//        this.startActivity(new Intent(this, RecyclerActivity.class));
    }

    public void intentViewpager2(View view) {
        com.gxd.ballball.utils.ToastUtils.showToast(this, "开发中...");
//        this.startActivity(new Intent(this, Viewpager2Activity.class));
    }

    public void call(View view) {
        makePhoneCall();
    }

    private void makePhoneCall() {
        String phoneNum = "tel:" + "19812249039";
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        } else {
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(phoneNum)));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                ToastUtils.showToast(this, "权限被拒绝");
            }
        }
    }
}
