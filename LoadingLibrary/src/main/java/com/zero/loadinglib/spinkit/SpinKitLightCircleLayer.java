package com.zero.loadinglib.spinkit;

import android.graphics.Canvas;
import android.graphics.Point;

import com.zero.loadinglib.AbsAnimLayer;

/**
 * 
 * @author linzewu
 * @date 16-12-6
 */
public class SpinKitLightCircleLayer extends AbsAnimLayer {
    
    private int mColor;
    
    private Point mCenterPoint;
    private int mOuterCircleRadius;
    private int mInnerCircleMaxRadius;
    private int mInnerCircleMinRadius;
    
    
    @Override
    protected void onMeasureLayer(int designWidth, int designHeight) {
        
    }

    @Override
    protected void onDrawLayer(Canvas canvas, float percent) {

    }
}
