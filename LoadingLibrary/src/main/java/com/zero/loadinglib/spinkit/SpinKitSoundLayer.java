package com.zero.loadinglib.spinkit;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;

import com.zero.loadinglib.AbsAnimLayer;

/**
 * @author linzewu
 * @date 2016/11/27
 */
public class SpinKitSoundLayer extends AbsAnimLayer {

    private static final int DEFAULT_SOUND_NUM = 4;
    private static final int DEFAULT_SOUND_MIN_LENGTH = 20;
    private static final int DEFAULT_SOUND_MAX_LENGTH = 100;
    private static final int DEFAULT_SOUND_COLOR = 0xff0099cc;
    

    @Override
    protected void onMeasureLayer(int designWidth, int designHeight) {
        
    }

    @Override
    protected void onDrawLayer(Canvas canvas, float percent) {

    }
    
    
    private class SoundLengthEvaluator implements TypeEvaluator<Integer> {
        
        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
            return ;
        }
    }
    
}
