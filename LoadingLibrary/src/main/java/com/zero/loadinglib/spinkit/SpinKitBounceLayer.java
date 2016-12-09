package com.zero.loadinglib.spinkit;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.zero.loadinglib.AbsAnimLayer;
import com.zero.loadinglib.util.evaluator.RotateEvaluator;
import com.zero.loadinglib.util.evaluator.SizeEvaluator;
import com.zero.loadinglib.util.evaluator.TransRightAngleEvaluator;
import com.zero.loadinglib.util.interpolator.IntermittentInterpolator;
import com.zero.loadinglib.util.interpolator.RepeatInterpolator;
import com.zero.loadinglib.util.interpolator.ReverseInterpolator;

/**
 * 两个矩阵旋转
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
    
    private TransRightAngleEvaluator mTransRightAngleEvaluator;
    private SizeEvaluator mSizeEvaluator;
    private RotateEvaluator mRotateEvaluator;
    
    private IntermittentInterpolator mIntermittentInterpolator;
    private RepeatInterpolator mRepeatInterpolator;
    private ReverseInterpolator mReverseInterpolator;
    
    public SpinKitBounceLayer() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(mBounceColor);
    }
    
    @Override
    protected void onMeasureLayer(int designWidth, int designHeight) {
        mTransRightAngleEvaluator = new TransRightAngleEvaluator();
        mSizeEvaluator = new SizeEvaluator();
        mRotateEvaluator = new RotateEvaluator();
        mIntermittentInterpolator = new IntermittentInterpolator();
        mRepeatInterpolator = new RepeatInterpolator();
        mReverseInterpolator = new ReverseInterpolator();
        mBounceLeftPoint = new Point((int)(0.4f * designWidth), (int)(0.4f * designHeight));
        mBounceRightPoint = new Point((int)(0.6f * designWidth), (int)(0.6f * designHeight));
        mBounceMaxSideLength = (int) (0.12f * designWidth);
        mBounceMinSideLength = (int) (0.04f * designWidth);
        mMovingSquareRect1 = new Rect();
        mMovingSquareRect2 = new Rect();
    }

    @Override
    protected void onDrawLayer(Canvas canvas, float percent) {
        float animPercent = mIntermittentInterpolator.getInterpolation(percent);
        mMovingPoint1 = mTransRightAngleEvaluator.evaluate(animPercent, mBounceLeftPoint, mBounceRightPoint);
        mMovingPoint2 = mTransRightAngleEvaluator.evaluate(animPercent, mBounceRightPoint, mBounceLeftPoint);
        mMovingSquareSize1 = mSizeEvaluator.evaluate(mReverseInterpolator.getInterpolation(animPercent), 
                mBounceMaxSideLength, mBounceMinSideLength);
        mMovingSquareSize2 = mSizeEvaluator.evaluate(mReverseInterpolator.getInterpolation(animPercent), 
                mBounceMaxSideLength, mBounceMinSideLength);
        mMovingSquareRect1.left = mMovingPoint1.x - mMovingSquareSize1 / 2;
        mMovingSquareRect1.right = mMovingPoint1.x + mMovingSquareSize1 / 2;
        mMovingSquareRect1.top = mMovingPoint1.y - mMovingSquareSize1 / 2;
        mMovingSquareRect1.bottom = mMovingPoint1.y + mMovingSquareSize1 / 2;
        mMovingSquareRect2.left = mMovingPoint2.x - mMovingSquareSize2 / 2;
        mMovingSquareRect2.right = mMovingPoint2.x + mMovingSquareSize2 / 2;
        mMovingSquareRect2.top = mMovingPoint2.y - mMovingSquareSize2 / 2;
        mMovingSquareRect2.bottom = mMovingPoint2.y + mMovingSquareSize2 / 2;
        
        float rotate1 = mRotateEvaluator.evaluate(mRepeatInterpolator.getInterpolation(animPercent), 
                90, -90);
        int saveLayer = canvas.save();
        canvas.rotate(rotate1, mMovingPoint1.x, mMovingPoint1.y);
        canvas.drawRect(mMovingSquareRect1, mPaint);
        canvas.restoreToCount(saveLayer);
        
        float rotate2 = mRotateEvaluator.evaluate(mRepeatInterpolator.getInterpolation(animPercent), 
                -90, 90);
        saveLayer = canvas.save();
        canvas.rotate(rotate2, mMovingPoint2.x, mMovingPoint2.y);
        canvas.drawRect(mMovingSquareRect2, mPaint);
        canvas.restoreToCount(saveLayer);
    }
}
