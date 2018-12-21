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
              implementation 'com.github.sinothk:ProgressView:1.0.1221'
      }
      
# 使用
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
