package com.example.todayinformation.base.tools;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;


public class AnimationUtil {


    public static void startTranslationXAnim(View taget, float positionStart, float positionEnd, Animator.AnimatorListener listener) {
        ObjectAnimator titleAnim = ObjectAnimator.ofFloat(taget, "translationX", positionStart, positionEnd);
        titleAnim.setDuration(1000);
        titleAnim.start();
        if (listener != null) {
            titleAnim.addListener(listener);
        }
    }
}
