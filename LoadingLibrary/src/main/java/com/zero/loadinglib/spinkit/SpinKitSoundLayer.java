package com.zero.loadinglib.spinkit;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.zero.loadinglib.AbsAnimLayer;

/**
 * @author linzewu
 * @date 2016/11/27
 */
public class SpinKitSoundLayer extends AbsAnimLayer {

    private static final float STATUS_PERCENT_CLAM = 0.2f;
    private static final int DEFAULT_COLOR = 0xff0099cc;
    private static final int DEFAULT_STRIP_NUMBER = 4;
    private static final int DEFAULT_STRIP_WIDTH = 15;
    private static final int DEFAULT_STRIP_INTERVAL = 10;
    private static final int DEFAULT_STRIP_MIN_LENGTH = 35;
    private static final int DEFAULT_STRIP_MAX_LENGTH = 55;
    private static final int DEFAULT_STRIP_LEFT_PADDING = 100;
    private static final int DEFAULT_STRIP_RIGHT_PADDING = 100;

    private Paint mPaint;
    private int mColor = DEFAULT_COLOR;
    private int mStripWidth = DEFAULT_STRIP_WIDTH;
    private int mStripInterval = DEFAULT_STRIP_INTERVAL;
    private int mStripNumber = DEFAULT_STRIP_NUMBER;
    private int mStripMinLength = DEFAULT_STRIP_MIN_LENGTH;
    private int mStripMaxLength = DEFAULT_STRIP_MAX_LENGTH;
    private int mStripLeftPadding = DEFAULT_STRIP_LEFT_PADDING;
    private int mStripRightPadding = DEFAULT_STRIP_RIGHT_PADDING;

    private Point[] mStripCenterPoint;
    private int[] mStripLengths;
    private StripEvaluator[] mStripEvaluators;

    public SpinKitSoundLayer() {
        mPaint = new Paint();
        mPaint.setColor(mColor);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mStripCenterPoint = new Point[mStripNumber];
        mStripLengths = new int[mStripNumber];
        mStripEvaluators = new StripEvaluator[mStripNumber];
    }

    @Override
    protected void onMeasureLayer(int realWidth, int realHeight) {
        mStripMaxLength = (int) (0.2f * realHeight);
        mStripMinLength = (int) (0.12f * realHeight);
        mStripWidth = (int) (0.05f * realWidth);
        mStripInterval = (int) (2f * mStripWidth);

        float animRunningTime = 1 - STATUS_PERCENT_CLAM;
        float animRunningInterval = animRunningTime / ((mStripNumber + 1) / 2);

        mStripLeftPadding = mStripRightPadding = (realWidth - mStripInterval * (mStripNumber - 1)) / 2;
        for (int i = 0; i < mStripCenterPoint.length; i++) {
            mStripCenterPoint[i] = new Point();
            mStripCenterPoint[i].x = mStripLeftPadding + i * mStripInterval;
            mStripCenterPoint[i].y = realHeight / 2;
            mStripLengths[i] = mStripMinLength;
            mStripEvaluators[i] = new StripEvaluator(STATUS_PERCENT_CLAM + animRunningInterval * i, STATUS_PERCENT_CLAM + animRunningInterval * (i + 2));
        }
    }

    @Override
    protected void onDrawLayer(Canvas canvas, float percent) {
        if (percent <= STATUS_PERCENT_CLAM) {
            drawClamSound(canvas);
        } else {
            drawBeatSound(canvas, percent);
        }
    }

    private void drawClamSound(Canvas canvas) {
        for (int i = 0; i < mStripCenterPoint.length; i++) {
            Rect rect = new Rect(mStripCenterPoint[i].x - mStripWidth / 2, mStripCenterPoint[i].y - mStripLengths[i] / 2, mStripCenterPoint[i].x + mStripWidth / 2, mStripCenterPoint[i].y + mStripLengths[i] / 2);
            canvas.drawRect(rect, mPaint);
        }
    }

    private void drawBeatSound(Canvas canvas, float percent) {
        for (int i = 0; i < mStripCenterPoint.length; i++) {
            mStripLengths[i] = mStripEvaluators[i].evaluate(percent, mStripMinLength, mStripMaxLength);
            Rect rect = new Rect(mStripCenterPoint[i].x - mStripWidth / 2, mStripCenterPoint[i].y - mStripLengths[i] / 2, mStripCenterPoint[i].x + mStripWidth / 2, mStripCenterPoint[i].y + mStripLengths[i] / 2);
            canvas.drawRect(rect, mPaint);
        }
    }


    private class StripEvaluator implements TypeEvaluator<Integer> {

        private float mStartChangeFraction;
        private float mEndChangeFraction;

        public StripEvaluator(float startChangeFraction, float endChangeFraction) {
            this.mStartChangeFraction = startChangeFraction;
            this.mEndChangeFraction = endChangeFraction;
        }

        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
            if (fraction < mStartChangeFraction && fraction > mEndChangeFraction) {
                return startValue;
            }
            float halfFraction = (mStartChangeFraction + mEndChangeFraction) / 2;
            if (fraction < halfFraction) {
                return (int) (startValue + (fraction - mStartChangeFraction) * (endValue - startValue));
            } else {
                return (int) (endValue - (fraction - halfFraction) * (endValue - startValue));
            }
        }
    }

}
