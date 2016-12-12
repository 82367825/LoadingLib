package com.zero.loadinglib.util.interpolator;

import android.view.animation.Interpolator;

/**
 * 重复插值器
 * 返回 0-1 0-1 ...
 * @author linzewu
 * @date 16-12-9
 */
public class RepeatInterpolator implements Interpolator {

    private static final int DEFAULT_REPEAT_TIMES = 2;
    private int mRepeatTimes = DEFAULT_REPEAT_TIMES;

    
    public RepeatInterpolator() {
    }

    /**
     * 设置重复的次数
     * @param repeatTimes
     */
    public RepeatInterpolator(int repeatTimes) {
        this.mRepeatTimes = repeatTimes;
    }
    
    @Override
    public float getInterpolation(float input) {
        float intervalTime = input / mRepeatTimes;
        float currentInput = input % intervalTime;
        return currentInput / intervalTime;
    }
    
    
}
