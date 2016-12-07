package com.zero.loadinglib.fish;

import android.graphics.Canvas;
import android.graphics.Point;

import com.zero.loadinglib.AbsAnimLayer;

/**
 * 鱼动画层
 * @author linzewu
 * @date 16-12-7
 */
public class FishLayer extends AbsAnimLayer {
    
    private Circle mFishEyesCircle;
    private Circle mFishMouthCircle;
    
    @Override
    protected void onMeasureLayer(int designWidth, int designHeight) {
        
    }

    @Override
    protected void onDrawLayer(Canvas canvas, float percent) {

    }
    
    private class Circle {
        private Point mCirclePoint;
        private int mCircleRadius;
        
        public Circle(Point circlePoint, int circleRadius) {
            this.mCirclePoint = circlePoint;
            this.mCircleRadius  = circleRadius;
        }
    }
    
}
