package com.sinothk.view.progress.demo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sinothk.view.progress.LoadingView;

public class ProgressLoading2DemoMainActivity extends AppCompatActivity {

    LoadingView progressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_style2_demo_main);

        progressView = findViewById(R.id.loadingView);
        progressView.setRetryListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });

        start();
    }

    private void start() {
        progressView.showLoading();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        progressView.showEmpty("暂无数据");
                        progressView.showError("访问失败");
//                        progressView.showNetError("网络不可用");
                    }
                });
            }
        }, 3000);
    }
}
