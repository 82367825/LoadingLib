package com.zero.loadinglib.spinkit;

import android.graphics.Canvas;
import android.graphics.Point;

import com.zero.loadinglib.AbsAnimLayer;
import com.zero.loadinglib.util.evaluator.SizeEvaluator;
import com.zero.loadinglib.util.interpolator.ReverseInterpolator;

/**
 * @author linzewu
 * @date 2016/11/27
 */
public class SpinKitSoundLayer extends AbsAnimLayer {

    private static final int DEFAULT_SOUND_NUM = 4;
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
    
    public SpinKitSoundLayer() {
        mSizeEvaluator = new SizeEvaluator();
        mReverseInterpolator = new ReverseInterpolator();
    }

    @Override
    protected void onMeasureLayer(int designWidth, int designHeight) {
        mSoundMinLength = (int) (designHeight * 0.3f);
        mSoundMaxLength = (int) (designHeight * 0.5f);
        mSoundWidth = (int) (designWidth * 0.05f);
        mSoundInterval = (int) (designWidth * 0.1f);
        
        mPaddingTop = (designHeight - mSoundMinLength) / 2;
        mPaddingBottom = mPaddingTop + mSoundMinLength;
        mPaddingLeft = (designWidth - (mSoundNumber - 1) * mSoundInterval) / 2;
        mPaddingRight = mPaddingLeft + (mSoundNumber - 1) * mSoundInterval;
        
        mSoundCenterPoints = new Point[mSoundNumber];
        for (int i = 0; i < mSoundCenterPoints.length; i++) {
            mSoundCenterPoints[i] = new Point();
        }
    }

    @Override
    protected void onDrawLayer(Canvas canvas, float percent) {

    }
    
}
