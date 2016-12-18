package com.zero.loadinglib.spinkit;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.zero.loadinglib.AbsAnimLayer;
import com.zero.loadinglib.util.evaluator.SizeEvaluator;
import com.zero.loadinglib.util.interpolator.ProtrusionsInterpolator;
import com.zero.loadinglib.util.interpolator.ReverseInterpolator;

/**
 * @author linzewu
 * @date 2016/11/27
 */
public class SpinKitSoundLayer extends AbsAnimLayer {

    private static final int DEFAULT_SOUND_NUM = 5;
    private static final int DEFAULT_SOUND_MIN_LENGTH = 20;
    private static final int DEFAULT_SOUND_MAX_LENGTH = 100;
    private static final int DEFAULT_SOUND_WIDTH = 30;
    private static final int DEFAULT_SOUND_INTERVAL = 80;
    private static final int DEFAULT_SOUND_COLOR = 0xff0099cc;
    
    private int mSoundNumber = DEFAULT_SOUND_NUM;
    private int mSoundMinLength = DEFAULT_SOUND_MIN_LENGTH;
    private int mSoundMaxLength = DEFAULT_SOUND_MAX_LENGTH;
    private int mSoundColor = DEFAULT_SOUND_COLOR;
    
    private int mSoundInterval = DEFAULT_SOUND_INTERVAL;
    private int mSoundWidth = DEFAULT_SOUND_WIDTH;
    
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private int mPaddingBottom;
    
    private Point[] mSoundCenterPoints;
    
    private SizeEvaluator mSizeEvaluator;
    private ReverseInterpolator mReverseInterpolator;
    private int[] mSoundLengths;
    private ProtrusionsInterpolator[] mProtrusionsInterpolators;
    
    private Paint mPaint;
    
    public SpinKitSoundLayer() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(mSoundColor);
        mSizeEvaluator = new SizeEvaluator();
        mReverseInterpolator = new ReverseInterpolator();
    }

    @Override
    protected void onMeasureLayer(int designWidth, int designHeight) {
        mSoundMinLength = (int) (designHeight * 0.15f);
        mSoundMaxLength = (int) (designHeight * 0.3f);
        mSoundWidth = (int) (designWidth * 0.028f);
        mSoundInterval = (int) (designWidth * 0.05f);
        
        mPaddingTop = (designHeight - mSoundMinLength) / 2;
        mPaddingBottom = mPaddingTop + mSoundMinLength;
        mPaddingLeft = (designWidth - (mSoundNumber - 1) * mSoundInterval) / 2;
        mPaddingRight = mPaddingLeft + (mSoundNumber - 1) * mSoundInterval;
        
        
        mSoundCenterPoints = new Point[mSoundNumber];
        mSoundLengths = new int[mSoundNumber];
        mProtrusionsInterpolators = new ProtrusionsInterpolator[mSoundNumber];
        for (int i = 0; i < mSoundCenterPoints.length; i++) {
            mSoundCenterPoints[i] = new Point(mPaddingLeft + i * mSoundInterval, designHeight / 2);
            mSoundLengths[i] = mSoundMinLength;
            mProtrusionsInterpolators[i] = new ProtrusionsInterpolator(i * 0.1f, i * 0.1f + 0.4f);
        }
    }

    @Override
    protected void onDrawLayer(Canvas canvas, float percent) {
        for(int i = 0; i < mSoundCenterPoints.length; i++) {
            float fraction = mReverseInterpolator.getInterpolation(
                    mProtrusionsInterpolators[i].getInterpolation(percent));
            mSoundLengths[i] = mSizeEvaluator.evaluate(fraction, mSoundMinLength, mSoundMaxLength);
            
            Rect rect = new Rect(mSoundCenterPoints[i].x - mSoundWidth / 2,
                    mSoundCenterPoints[i].y - mSoundLengths[i] / 2,
                    mSoundCenterPoints[i].x + mSoundWidth / 2,
                    mSoundCenterPoints[i].y + mSoundLengths[i] / 2);
            canvas.drawRect(rect, mPaint);
        }
    }
    
}
