package com.zero.loadinglib;

import android.animation.ValueAnimator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;

/**
 * @author linzewu
 * @date 2016/11/27
 */
public class AnimDrawableController implements ValueAnimator.AnimatorUpdateListener {
    
    private ValueAnimator mDrawableValueAnimator;
    private IAnimDrawable mDrawable;
    
    private static final long DEFAULT_ANIM_DURATION = 2000;
    private long mAnimDuration;

    public AnimDrawableController(IAnimDrawable drawable) {
        this.mDrawable = drawable;
        mAnimDuration = DEFAULT_ANIM_DURATION;
        initValueAnimator();
    }
    
    private void initValueAnimator() {
        mDrawableValueAnimator = ValueAnimator.ofFloat(0f, 1f);
        mDrawableValueAnimator.setInterpolator(new LinearInterpolator());
        mDrawableValueAnimator.setDuration(mAnimDuration);
        mDrawableValueAnimator.setRepeatCount(Animation.INFINITE);
        mDrawableValueAnimator.setRepeatMode(Animation.RESTART);
        mDrawableValueAnimator.addUpdateListener(this);
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        float animationValue = (float) animation.getAnimatedValue();
        if (mDrawable != null) {
            mDrawable.refreshAnim(animationValue);
        }
    }
    
    public void startAnim() {
        mDrawableValueAnimator.start();
    }
    
    
    public void stopAnim() {
        mDrawableValueAnimator.cancel();
    }
    
    public void setAnimDuration(long animDuration) {
        this.mAnimDuration = animDuration;
    }
    
    public boolean isAnimRunning() {
        return mDrawableValueAnimator.isRunning();
    }
    
}
