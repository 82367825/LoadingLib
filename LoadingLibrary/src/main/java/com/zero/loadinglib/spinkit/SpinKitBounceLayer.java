package com.zero.loadinglib.spinkit;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.animation.Interpolator;

import com.zero.loadinglib.AbsAnimLayer;
import com.zero.loadinglib.util.IntermittentInterpolator;

/**
 * @author linzewu
 * @date 2016/11/27
 */
public class SpinKitBounceLayer extends AbsAnimLayer {
    
    private static final int DEFAULT_COLOR = 0xff0099cc;
    private static final int DEFAULT_MAX_SIDE_LENGTH = 60;
    private static final int DEFAULT_MIN_SIDE_LENGTH = 15;
    
    private int mBounceColor = DEFAULT_COLOR;
    private int mBounceMaxSideLength = DEFAULT_MAX_SIDE_LENGTH;
    private int mBounceMinSideLength = DEFAULT_MIN_SIDE_LENGTH;
    private Point mBounceLeftPoint;
    private Point mBounceRightPoint;
    private Point mMovingPoint1;
    private Point mMovingPoint2;
    private int mMovingSquareSize1;
    private int mMovingSquareSize2;
    private Rect mMovingSquareRect1;
    private Rect mMovingSquareRect2;
    private Paint mPaint;
    
    private BouncePointEvaluator mBouncePointEvaluator;
    private BounceSizeEvaluator mBounceSizeEvaluator;
    private BounceRotateEvaluator mBounceRotateEvaluator;
    private IntermittentInterpolator mIntermittentInterpolator;
    
    public SpinKitBounceLayer() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(mBounceColor);
    }
    
    @Override
    protected void onMeasureLayer(int designWidth, int designHeight) {
        mBouncePointEvaluator = new BouncePointEvaluator();
        mBounceSizeEvaluator = new BounceSizeEvaluator();
        mBounceRotateEvaluator = new BounceRotateEvaluator();
        mIntermittentInterpolator = new IntermittentInterpolator();
        mBounceLeftPoint = new Point((int)(0.3f * designWidth), (int)(0.4f * designHeight));
        mBounceRightPoint = new Point((int)(0.7f * designWidth), (int)(0.6f * designHeight));
        mBounceMaxSideLength = (int) (0.08f * designWidth);
        mBounceMinSideLength = (int) (0.03f * designWidth);
        mMovingSquareRect1 = new Rect();
        mMovingSquareRect2 = new Rect();
    }

    @Override
    protected void onDrawLayer(Canvas canvas, float percent) {
        float animPercent = mIntermittentInterpolator.getInterpolation(percent);
        mMovingPoint1 = mBouncePointEvaluator.evaluate(animPercent, mBounceLeftPoint, mBounceRightPoint);
        mMovingPoint2 = mBouncePointEvaluator.evaluate(animPercent, mBounceRightPoint, mBounceLeftPoint);
        mMovingSquareSize1 = mBounceSizeEvaluator.evaluate(animPercent, mBounceMaxSideLength, 
                mBounceMinSideLength);
        mMovingSquareSize2 = mBounceSizeEvaluator.evaluate(animPercent, mBounceMaxSideLength,
                mBounceMinSideLength);
        mMovingSquareRect1.left = mMovingPoint1.x - mMovingSquareSize1 / 2;
        mMovingSquareRect1.right = mMovingPoint1.x + mMovingSquareSize1 / 2;
        mMovingSquareRect1.top = mMovingPoint1.y - mMovingSquareSize1 / 2;
        mMovingSquareRect1.bottom = mMovingPoint1.y + mMovingSquareSize1 / 2;
        mMovingSquareRect2.left = mMovingPoint2.x - mMovingSquareSize2 / 2;
        mMovingSquareRect2.right = mMovingPoint2.x + mMovingSquareSize2 / 2;
        mMovingSquareRect2.top = mMovingPoint2.y - mMovingSquareSize2 / 2;
        mMovingSquareRect2.bottom = mMovingPoint2.y + mMovingSquareSize2 / 2;
        
        float rotate = mBounceRotateEvaluator.evaluate(animPercent, 0, 180);
        int saveLayer = canvas.save();
        canvas.rotate(rotate, mMovingPoint1.x, mMovingPoint1.y);
        canvas.drawRect(mMovingSquareRect1, mPaint);
        canvas.restoreToCount(saveLayer);
        saveLayer = canvas.save();
        canvas.rotate(rotate, mMovingPoint2.x, mMovingPoint2.y);
        canvas.drawRect(mMovingSquareRect2, mPaint);
        canvas.restoreToCount(saveLayer);
    }
    
    
    private class BounceRotateEvaluator implements TypeEvaluator<Integer> {

        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
            if (fraction <= 0.5f) {
                return (int)(fraction * 2 * (endValue - startValue));
            } else {
                return (int)((fraction - 0.5f) * 2 * (endValue - startValue));
            }
        }
    }
    
    private class BounceSizeEvaluator implements TypeEvaluator<Integer> {

        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
            if (fraction <= 0.5f) {
                return (int)(startValue + fraction * 2 * (endValue - startValue));
            } else {
                return (int)(endValue + (fraction - 0.5) * 2 * (startValue - endValue));
            }
        }
    }
    
    
    private class BouncePointEvaluator implements TypeEvaluator<Point> {
        
        @Override
        public Point evaluate(float fraction, Point startValue, Point endValue) {
            //中间点坐标
            Point pausePoint = new Point(endValue.x, startValue.y);
            if (fraction <= 0.5f) {
                float percent = fraction / 0.5f;
                int currentX = (int)(startValue.x + (pausePoint.x - startValue.x) * percent);
                return new Point(currentX, startValue.y);
            } else {
                float percent = (fraction - 0.5f) / 0.5f;
                int currentY = (int)(pausePoint.y + (endValue.y - pausePoint.y) * percent);
                return new Point(pausePoint.x, currentY);
            }
        }
    }
}
