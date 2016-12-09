package com.zero.loadinglib.util.interpolator;

import android.view.animation.Interpolator;

/**
 * 反转插值器
 * 0-1 1-0
 * @author linzewu
 * @date 16-12-9
 */
public class ReverseInterpolator implements Interpolator {
    
    @Override
    public float getInterpolation(float input) {
        if (input <= 0.5f) {
            return input / 0.5f;
        } else {
            return (1 - input) / 0.5f;
        }
    }
    
}
