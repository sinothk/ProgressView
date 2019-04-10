# ProgressView
进度条

# 引入

  ## Step 1. Add the JitPack repository to your build file
    Add it in your root build.gradle at the end of repositories:

      allprojects {
        repositories {
          ...
          maven { url 'https://jitpack.io' }
        }
      }
  
  
  ## Step 2. Add the dependency
      dependencies {
              implementation 'com.github.sinothk:ProgressView:2.0.0410'
      }
      
# 使用1 单独使用
    <com.sinothk.view.progress.loading1.HiveProgressView
        android:id="@+id/hive_progress"
        android:layout_width="92dp"
        android:layout_height="92dp"
        android:layout_gravity="center"
        app:hive_animDuration="2000"
        app:hive_color="@color/colorAccent"
        app:hive_cornerRadius="10"
        app:hive_maxAlpha="100"
        app:hive_rainbow="true"
        app:hive_shrink="true" />
        
# 使用2 复合使用
   ## XML 
      <com.sinothk.view.progress.LoadingView
            android:id="@+id/loadingView"
            android:layout_width="@dimen/dp_120"
            android:layout_height="@dimen/dp_120"
            android:layout_gravity="center"
            app:res_img_empty="@drawable/progress_view_no_data"
            app:res_img_error="@drawable/progress_view_error"
            app:res_img_net_error="@drawable/progress_view_no_signal"
            app:view_style="2" />
            
   ## java
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
