package com.example.diplomaproject.Donation;


import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class LockableViewPager extends ViewPager {
    private boolean swipable;

    public LockableViewPager(Context context) {
        super(context);
    }

    public LockableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.swipable = true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.swipable) {
            return super.onTouchEvent(event);
        }
        return false;
    }

    @Override

    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.swipable) {
            return super.onInterceptTouchEvent(event);
        }
        return false;
    }

    public void setSwipable(boolean swipable) {
        this.swipable = swipable;
    }
}