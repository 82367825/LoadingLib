package com.zero.loadinglib.util.interpolator;

import android.view.animation.Interpolator;

/**
 * 先减速后加速插值器
 *
 * @author linzewu
 * @date 16-12-9
 */
public class DeceAcceInterpolator implements Interpolator {

    @Override
    public float getInterpolation(float input) {
        float result;
        if (input <= 0.5) {
            result = (float) (Math.sin(Math.PI * input)) / 2;
        } else {
            result = (float) (2 - Math.sin(Math.PI * input)) / 2;
        }
        return result;
    }
}
