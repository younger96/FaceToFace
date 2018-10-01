package com.example.a47420.facetoface.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * Created by 47420 on 2017/2/24.
 */

public abstract class BaseActivity extends AppCompatActivity {
    public FrameLayout rootContainer;

    public Context mContext;
    protected String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(getLayoutID());

        TAG = getClass().getSimpleName();


        initView();

        mContext = this;

        init();

    }

    protected abstract void init();

    protected abstract void initView();

    protected abstract int getLayoutID();


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
