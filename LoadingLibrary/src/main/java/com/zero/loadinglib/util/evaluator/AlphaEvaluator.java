package com.zero.loadinglib.util.evaluator;

import android.animation.TypeEvaluator;

/**
 * 透明度线性变化
 * @author linzewu
 * @date 16-12-9
 */
public class AlphaEvaluator implements TypeEvaluator<Integer> {
    
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        return (int)(startValue + fraction * (endValue - startValue));
    }
}
