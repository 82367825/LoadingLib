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
 * @date 2016/12/18
 */
public class SpinKitNineSquareLayer extends AbsAnimLayer {

    private static final int DEFAULT_COLOR = 0xff0099cc;
    private Point mCenterPoint;
    private Point[] mPoints;
    private int[] mSquareSizes;
    private int mMaxSquareSize;
    private ReverseInterpolator mReverseInterpolator;
    private ProtrusionsInterpolator[] mProtrusionsInterpolators;
    private SizeEvaluator mSizeEvaluator;
    private int mColor = DEFAULT_COLOR;
    
    private Paint mPaint;
    
    public SpinKitNineSquareLayer() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(mColor);
    }

    @Override
    protected void onMeasureLayer(int designWidth, int designHeight) {
        mMaxSquareSize = (int) (0.08f * designWidth);
        mCenterPoint = new Point(designWidth / 2, designHeight / 2);
        mSquareSizes = new int[9];
        mSizeEvaluator = new SizeEvaluator();
        mReverseInterpolator = new ReverseInterpolator();
        mPoints = new Point[9];
        mProtrusionsInterpolators = new ProtrusionsInterpolator[9];
        mPoints[0] = new Point(mCenterPoint.x - mMaxSquareSize, mCenterPoint.y - mMaxSquareSize);
        mPoints[1] = new Point(mCenterPoint.x, mCenterPoint.y - mMaxSquareSize);
        mPoints[2] = new Point(mCenterPoint.x + mMaxSquareSize, mCenterPoint.y - mMaxSquareSize);
        mPoints[3] = new Point(mCenterPoint.x - mMaxSquareSize, mCenterPoint.y);
        mPoints[4] = new Point(mCenterPoint.x, mCenterPoint.y);
        mPoints[5] = new Point(mCenterPoint.x + mMaxSquareSize, mCenterPoint.y);
        mPoints[6] = new Point(mCenterPoint.x - mMaxSquareSize, mCenterPoint.y + mMaxSquareSize);
        mPoints[7] = new Point(mCenterPoint.x, mCenterPoint.y + mMaxSquareSize);
        mPoints[8] = new Point(mCenterPoint.x + mMaxSquareSize, mCenterPoint.y + mMaxSquareSize);

        //为了增强效果
        mMaxSquareSize = mMaxSquareSize + 5;

        mProtrusionsInterpolators[0] = new ProtrusionsInterpolator(0f, 0.5f);
        mProtrusionsInterpolators[1] = new ProtrusionsInterpolator(0.1f, 0.6f);
        mProtrusionsInterpolators[3] = new ProtrusionsInterpolator(0.1f, 0.6f);
        mProtrusionsInterpolators[2] = new ProtrusionsInterpolator(0.2f, 0.7f);
        mProtrusionsInterpolators[4] = new ProtrusionsInterpolator(0.2f, 0.7f);
        mProtrusionsInterpolators[6] = new ProtrusionsInterpolator(0.2f, 0.7f);
        mProtrusionsInterpolators[5] = new ProtrusionsInterpolator(0.3f, 0.8f);
        mProtrusionsInterpolators[7] = new ProtrusionsInterpolator(0.3f, 0.8f);
        mProtrusionsInterpolators[8] = new ProtrusionsInterpolator(0.4f, 0.9f);
    }

    @Override
    protected void onDrawLayer(Canvas canvas, float percent) {
        for (int i = 0; i < mPoints.length; i++) {
            float fraction = mReverseInterpolator.getInterpolation(mProtrusionsInterpolators[i]
                    .getInterpolation(percent));
            mSquareSizes[i] = mSizeEvaluator.evaluate(fraction, mMaxSquareSize, 0);
            Rect rect = new Rect(mPoints[i].x - mSquareSizes[i] / 2, 
                    mPoints[i].y - mSquareSizes[i] / 2,
                    mPoints[i].x + mSquareSizes[i] / 2, 
                    mPoints[i].y + mSquareSizes[i] / 2);
            canvas.drawRect(rect, mPaint);
        }
    }
}
