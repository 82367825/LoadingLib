package com.zero.loadinglib.util.interpolator;

import android.view.animation.Interpolator;

/**
 * @author linzewu
 * @date 16-12-9
 */
public class FlashInterpolator implements Interpolator {
    
    @Override
    public float getInterpolation(float input) {
        if (input <= 0.5f) {
            return 0;
        } else {
            return 1;
        }
    }
}
