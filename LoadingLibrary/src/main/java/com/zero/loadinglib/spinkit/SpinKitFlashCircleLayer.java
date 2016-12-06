package com.zero.loadinglib.spinkit;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.Point;

import com.zero.loadinglib.AbsAnimLayer;

/**
 * 大小圆闪动
 * @author linzewu
 * @date 16-12-6
 */
public class SpinKitFlashCircleLayer extends AbsAnimLayer {

    private static final int DEFAULT_COLOR = 0xff0099cc;
    private static final int DEFAULT_MAX_RADIUS = 150;
    private static final int DEFAULT_MIN_RADIUS = 20;
    private static final int DEFAULT_RADIUS = 50;
    
    private Point mCenterPoint;
    private int mCircleColor = DEFAULT_COLOR;
    private int mCircleRadius1 = DEFAULT_RADIUS;
    private int mCircleRadius2 = DEFAULT_RADIUS;
    private int mCircleMaxRadius = DEFAULT_MAX_RADIUS;
    private int mCircleMinRadius = DEFAULT_MIN_RADIUS;
    
    @Override
    protected void onMeasureLayer(int designWidth, int designHeight) {
        mCenterPoint = new Point(designWidth / 2, designHeight / 2);
        mCircleMaxRadius = designWidth / 4;
        mCircleMinRadius = designWidth / 20; 
    }

    @Override
    protected void onDrawLayer(Canvas canvas, float percent) {

    }
    
    private class CircleAlphaEvaluator implements TypeEvaluator<Integer> {

        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
            return null;
        }
    }
    
    
    private class CircleRadiusEvaluator implements TypeEvaluator<Integer> {

        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
            return null;
        }
    }
    
}
