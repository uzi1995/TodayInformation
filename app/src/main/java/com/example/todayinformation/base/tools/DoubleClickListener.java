package com.example.todayinformation.base.tools;

import android.view.View;


public class DoubleClickListener implements View.OnClickListener{

    private final View.OnClickListener mOnClickListener;
    private long old;

    public DoubleClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override
    public void onClick(View v) {
        long now = System.currentTimeMillis();
        if (now - old > 1000) {
            if (mOnClickListener != null) {
                mOnClickListener.onClick(v);
            }
        }
        old = now;
    }
}
