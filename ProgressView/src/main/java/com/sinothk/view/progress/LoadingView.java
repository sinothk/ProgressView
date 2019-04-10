package com.sinothk.view.progress;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sinothk.view.progress.loading1.HiveProgressView;

/**
 * <pre>
 *  创建:  梁玉涛 2019/4/10 on 9:22
 *  项目:  ProgressViewLib
 *  描述:
 *  更新:
 * <pre>
 */
public class LoadingView extends LinearLayout {
    // 属性
    private int viewStyle;
    private int resultErrorImgId;
    private int resultEmptyImgId;
    private int resultNetErrorImgId;
    //
    private HiveProgressView progressView;
    private TextView tipTv;
    private LinearLayout resultView;
    private ImageView tipImgIv;

    public LoadingView(Context context) {
        super(context);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initAttributes(attrs, defStyleAttr);

        initView();
    }

    private void initAttributes(AttributeSet attrs, int defStyleAttr) {
        final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.LoadingView, defStyleAttr, 0);

        viewStyle = a.getInteger(R.styleable.LoadingView_view_style, 0);

        resultErrorImgId = a.getResourceId(R.styleable.LoadingView_res_img_error, R.drawable.progress_view_error);
        resultEmptyImgId = a.getResourceId(R.styleable.LoadingView_res_img_empty, R.drawable.progress_view_no_data);
        resultNetErrorImgId = a.getResourceId(R.styleable.LoadingView_res_img_net_error, R.drawable.progress_view_no_signal);

        a.recycle();
    }

    private void initView() {//orientation
        this.setOrientation(VERTICAL);

        View loadingView;
        if (viewStyle == 0) {
            loadingView = LayoutInflater.from(getContext()).inflate(R.layout.progress_view_style1, null);
        }else{
            loadingView = LayoutInflater.from(getContext()).inflate(R.layout.progress_view_style1, null);
        }

        // 通用部分
        progressView = loadingView.findViewById(R.id.progressView);

        resultView = loadingView.findViewById(R.id.resultView);
        tipImgIv = loadingView.findViewById(R.id.tipImgIv);
        tipTv = loadingView.findViewById(R.id.tipTv);

        this.addView(loadingView);
    }

    public void setRetryListener(OnClickListener retryListener) {
        if (retryListener != null && resultView != null) {
            resultView.setOnClickListener(retryListener);
        }
    }

    public void showLoading() {
        progressView.setVisibility(VISIBLE);
        resultView.setVisibility(GONE);
    }

    public void showEmpty(String tipTxt) {
        progressView.setVisibility(GONE);
        resultView.setVisibility(VISIBLE);

        tipImgIv.setImageResource(resultEmptyImgId);
        tipTv.setText(tipTxt);
    }

    public void showError(String tipTxt) {
        progressView.setVisibility(GONE);
        resultView.setVisibility(VISIBLE);

        tipImgIv.setImageResource(resultErrorImgId);
        tipTv.setText(tipTxt);
    }

    public void showNetError(String tipTxt) {
        progressView.setVisibility(GONE);
        resultView.setVisibility(VISIBLE);

        tipImgIv.setImageResource(resultNetErrorImgId);
        tipTv.setText(tipTxt);
    }
}
