package com.zero.loadinglib.spinkit;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import com.zero.loadinglib.AbsAnimLayer;

/**
 * @author linzewu
 * @date 2016/11/27
 */
public class SpinKitSoundLayer extends AbsAnimLayer {
    
    private static final float STATUS_PERCENT_CLAM = 0.2f;
    private static final float STATUS_PERCENT_BEAT = 0.8f;
    private static final int DEFAULT_COLOR = 0xFF808080;
    private static final int DEFAULT_STRIP_NUMBER = 4;
    private static final int DEFAULT_STRIP_WIDTH = 15;
    private static final int DEFAULT_STRIP_INTERVAL = 10;
    private static final int DEFAULT_STRIP_MIN_LENGTH = 35;
    private static final int DEFAULT_STRIP_MAX_LENGTH = 55;
    
    private Paint mPaint;
    private int mColor = DEFAULT_COLOR;
    private int mStripWidth = DEFAULT_STRIP_WIDTH;
    private int mStripInterval = DEFAULT_STRIP_INTERVAL;
    private int mStripNumber = DEFAULT_STRIP_NUMBER;
    private int mStripMinLength = DEFAULT_STRIP_MIN_LENGTH;
    private int mStripMaxLength = DEFAULT_STRIP_MAX_LENGTH;
    
    private PointF[] mStripCenterPoint;
    
    
    
    public SpinKitSoundLayer() {
        mPaint = new Paint();
        mPaint.setColor(mColor);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mStripCenterPoint = new PointF[mStripNumber];
    }


    @Override
    protected void onMeasureLayer(int realWidth, int realHeight) {
        mStripMaxLength = (int) (scaleSize * mStripMaxLength);
        mStripMinLength = (int) (scaleSize * mStripMinLength);
        mStripWidth = (int) (scaleSize * mStripWidth);
        mStripInterval = (int) (scaleSize * mStripInterval);
    }

    @Override
    protected void onDrawLayer(Canvas canvas, float percent) {
        if (percent <= STATUS_PERCENT_CLAM) {
            
        } else if (percent > STATUS_PERCENT_CLAM && percent < STATUS_PERCENT_BEAT) {
             
        } else {
            
        }
    }
    
    private void drawClamSound(Canvas canvas) {
        
    }
    
    private void drawBeatSound(Canvas canvas) {
        
    }
    
}
