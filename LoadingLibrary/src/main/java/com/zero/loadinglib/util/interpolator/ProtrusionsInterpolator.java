package com.zero.loadinglib.util.interpolator;

import android.view.animation.Interpolator;

/**
 * 
 * 先静止，后匀速，后静止
 * @author linzewu
 * @date 16-12-9
 */
public class ProtrusionsInterpolator implements Interpolator {
    
    private static final float DEFAULT_START_FRACTION = 0.3f;
    private static final float DEFAULT_END_FRACTION = 0.7f;
    private float mStartFraction = DEFAULT_START_FRACTION;
    private float mEndFraction = DEFAULT_END_FRACTION;
    
    public ProtrusionsInterpolator() {
    }
    
    public ProtrusionsInterpolator(float startFraction, float endFraction) {
        this.mStartFraction = startFraction;
        this.mEndFraction = endFraction;
    }
    
    @Override
    public float getInterpolation(float input) {
        if (input <= mStartFraction) {
            return 0f;
        } else if (input > mStartFraction && input <= mEndFraction) {
            return (input - mStartFraction) / (mEndFraction - mStartFraction);
        } else {
            return 1f;
        }
    }
    
    
}
