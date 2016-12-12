package com.zero.loadinglib.util.interpolator;

import android.view.animation.Interpolator;

/**
 * 反转插值器
 * 0-1 1-0 通过sin函数 实现两个过程均有先加速后减速
 * @author linzewu
 * @date 2016/12/11
 */
public class ReverseSinInterpolator implements Interpolator {
    @Override
    public float getInterpolation(float input) {
        return 0;
    }
}
