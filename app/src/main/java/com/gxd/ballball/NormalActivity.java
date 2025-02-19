package com.gxd.ballball;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.kaisengao.likeview.like.KsgLikeView;
import com.gxd.ballball.utils.ToastUtils;
import com.gxd.ballball.R;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @ClassName: NormalActivity
 * @Author: KaiSenGao
 * @CreateDate: 8/5/21 10:23 PM
 * @Description: 普通模式
 */
public class NormalActivity extends AppCompatActivity {

    private KsgLikeView mLikeView;

    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_normal);
        // InitView
        this.initView();
    }

    /**
     * InitView
     */
    private void initView() {
        this.mLikeView = findViewById(R.id.live_view);
        // 添加资源文件
        this.mLikeView.addLikeImages(
                R.drawable.heart0, R.drawable.heart1, R.drawable.heart2,
                R.drawable.heart3, R.drawable.heart4, R.drawable.heart5,
                R.drawable.heart6, R.drawable.heart7, R.drawable.heart8);
        // 单个发送
        this.findViewById(R.id.single).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(NormalActivity.this, "宝宝我爱你！");
                mLikeView.addFavor();
            }
        });
        // 多个发送
        this.findViewById(R.id.multiple).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean selected = view.isSelected();
                if (selected) {
                    mHandler.removeCallbacks(mLikeRunnable);
                } else {
                    ToastUtils.showToast(NormalActivity.this, "宝宝我真的爱你！");
                    mHandler.postDelayed(mLikeRunnable, 100);
                }
                view.setSelected(!selected);
//                ToastUtils.showShort("宝宝我真的爱你！");
            }
        });
        this.findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * LikeRunnable
     */
    private final Runnable mLikeRunnable = new Runnable() {
        @Override
        public void run() {
            // 添加 发送
            mLikeView.addFavor();
            mHandler.postDelayed(mLikeRunnable, 100);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(mLikeRunnable);
    }
}