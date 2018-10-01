package com.example.a47420.facetoface;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.a47420.facetoface.base.BaseActivity;
import com.example.a47420.facetoface.custom_view.view_pager.YoungViewPager;
import com.example.a47420.facetoface.custom_view.view_pager.YoungViewPagerAdapter;
import com.example.a47420.facetoface.fragment.history.HistoryFragment;
import com.example.a47420.facetoface.fragment.local.LocalFragment;
import com.example.a47420.facetoface.fragment.main.MainFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private YoungViewPager mViewPager;
    private int[] bnts = new int[]{R.id.btn_local,R.id.btn_main,R.id.btn_history};

    @Override
    protected void init() {
        mViewPager.setOnClickListener(this);
        mViewPager.initListener(bnts,new YoungViewPagerAdapter(getSupportFragmentManager(),getPagerFragments()));
    }

    private List<Fragment> getPagerFragments() {
        List<Fragment> list = new ArrayList<>();
        list.add(new LocalFragment());
        list.add(new MainFragment());
        list.add(new HistoryFragment());
        return list;
    }

    @Override
    protected void initView() {
        mViewPager = (YoungViewPager) findViewById(R.id.view_pager_main);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {

    }
}

