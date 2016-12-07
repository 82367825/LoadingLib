package com.zero.loadinglib.spinkit;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.zero.loadinglib.AbsAnimLayer;

/**
 * 
 * @author linzewu
 * @date 16-12-6
 */
public class SpinKitBeatCircleLayer extends AbsAnimLayer {
    
    private int mColor;
    
    private Point mCenterPoint;
    private int mOuterCircleRadius;
    private int mInnerCircleMaxRadius;
    private int mInnerCircleMinRadius;
    
    private AccelerateDecelerateInterpolator mAccelerateDecelerateInterpolator;
    
    
    @Override
    protected void onMeasureLayer(int designWidth, int designHeight) {
        
    }

    @Override
    protected void onDrawLayer(Canvas canvas, float percent) {

    }


    /**
     * 跳动圆的运动轨迹
     */
    private class CirclePointEvaluator implements TypeEvaluator<Point> {

        private int mPathCircleCenterX;
        private int mPathCircleCenterY;
        private int mPathCircleRadius;
        
        @Override
        public Point evaluate(float fraction, Point startValue, Point endValue) {
            return null;
        }
    }

    /**
     * 跳动圆的半径大小变化
     */
    private class CircleRadiusEvaluator implements TypeEvaluator<Integer> {

        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
            return null;
        }
    }
}
