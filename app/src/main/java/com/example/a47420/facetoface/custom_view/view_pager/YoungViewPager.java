package com.example.a47420.facetoface.custom_view.view_pager;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class YoungViewPager extends ViewPager {
    private int[] btns ;
    private List<ImageButton> btnList = new ArrayList<>();
    public YoungViewPager(@NonNull Context context) {
        this(context, null);
    }

    public YoungViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public void initListener(int[] btnsNavigate, PagerAdapter pagerAdapter){
        btns = btnsNavigate;
        initBtnList();
        this.setOffscreenPageLimit(btns.length);
        this.setAdapter(pagerAdapter);
        this.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetNavigationButtons();
                selectNavigationButton(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        this.setCurrentItem(0);
        selectNavigationButton(0);
    }

    private void initBtnList() {
        for (int ibtnId : btns) {
            ImageButton ibtn = (ImageButton) findViewById(ibtnId);
            btnList.add(ibtn);
        }
    }


    //还原图标原本大小
    private void resetNavigationButtons() {
        for (int i = 0; i < getNavigationButtons().size(); i++) {
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(getNavigationButtons().get(i), "scaleX", 1f, 1f);
            ObjectAnimator animator2 = ObjectAnimator.ofFloat(getNavigationButtons().get(i), "scaleY", 1f, 1f);
            AnimatorSet set = new AnimatorSet();
            set.setDuration(300);
            set.playTogether(animator1, animator2);
            set.start();
        }
    }

    //放大1.3倍的动画
    private void selectNavigationButton(int position) {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(getNavigationButtons().get(position), "scaleX", 1f, 1.3f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(getNavigationButtons().get(position), "scaleY", 1f, 1.3f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(700);
        set.playTogether(animator1, animator2);
        set.setInterpolator(new OvershootInterpolator());
        set.start();
    }


    //添加点击事件
    private List<ImageButton> getNavigationButtons() {
        return btnList;
    }

}
