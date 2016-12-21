package com.zero.loadinglib.spinkit;

import android.graphics.Canvas;
import android.graphics.Point;

import com.zero.loadinglib.AbsAnimLayer;
import com.zero.loadinglib.util.evaluator.SizeEvaluator;
import com.zero.loadinglib.util.interpolator.ProtrusionsInterpolator;
import com.zero.loadinglib.util.interpolator.ReverseInterpolator;

/**
 * @author linzewu
 * @date 2016/12/18
 */
public class SpinKitNineSquareLayer extends AbsAnimLayer {

    private Point mCenterPoint;
    private Point[] mPoints;
    private int[] mSquareSizes;
    private int mMaxSquareSize;
    private ReverseInterpolator mReverseInterpolator;
    private ProtrusionsInterpolator[] mProtrusionsInterpolators;
    private SizeEvaluator mSizeEvaluator;

    @Override
    protected void onMeasureLayer(int designWidth, int designHeight) {
        mMaxSquareSize = (int) (0.08f * designWidth);
        mCenterPoint = new Point(designWidth / 2, designHeight / 2);

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

        mProtrusionsInterpolators[0] = new ProtrusionsInterpolator(0f, 5f);
        mProtrusionsInterpolators[1] = new ProtrusionsInterpolator(1f, 6f);
        mProtrusionsInterpolators[3] = new ProtrusionsInterpolator(1f, 6f);
        mProtrusionsInterpolators[2] = new ProtrusionsInterpolator(2f, 7f);
        mProtrusionsInterpolators[4] = new ProtrusionsInterpolator(2f, 7f);
        mProtrusionsInterpolators[6] = new ProtrusionsInterpolator(2f, 7f);
        mProtrusionsInterpolators[5] = new ProtrusionsInterpolator(3f, 8f);
        mProtrusionsInterpolators[7] = new ProtrusionsInterpolator(3f, 8f);
        mProtrusionsInterpolators[8] = new ProtrusionsInterpolator(4f, 9f);
    }

    @Override
    protected void onDrawLayer(Canvas canvas, float percent) {
        for (int i = 0; i < mPoints.length; i++) {
            mSquareSizes[i] = mReverseInterpolator.getInterpolation()
        }
    }
}
