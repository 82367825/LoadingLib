package com.zero.loadinglib.spinkit;

import android.graphics.Canvas;
import android.graphics.Point;

import com.zero.loadinglib.AbsAnimLayer;
import com.zero.loadinglib.util.interpolator.ProtrusionsInterpolator;
import com.zero.loadinglib.util.interpolator.ReverseInterpolator;

/**
 * @author linzewu
 * @date 2016/12/18
 */
public class SpinKitNineSquareLayer extends AbsAnimLayer {
    
    private Point mCenterPoint;
    private Point[] mPoints;
    
    private int mSquareSize;
    private ReverseInterpolator mReverseInterpolator;
    private ProtrusionsInterpolator[] mProtrusionsInterpolators;
    
    @Override
    protected void onMeasureLayer(int designWidth, int designHeight) {
        mSquareSize = (int) (0.08f * designWidth);
        mCenterPoint = new Point(designWidth / 2, designHeight / 2);
        mReverseInterpolator = new ReverseInterpolator();
        mPoints = new Point[9];
        mProtrusionsInterpolators = new ProtrusionsInterpolator[9];
        mPoints[0] = new Point(mCenterPoint.x - mSquareSize, mCenterPoint.y - mSquareSize);
        mPoints[1] = new Point(mCenterPoint.x, mCenterPoint.y - mSquareSize);
        mPoints[2] = new Point(mCenterPoint.x + mSquareSize, mCenterPoint.y - mSquareSize);
        mPoints[3] = new Point(mCenterPoint.x - mSquareSize, mCenterPoint.y);
        mPoints[4] = new Point(mCenterPoint.x, mCenterPoint.y);
        mPoints[5] = new Point(mCenterPoint.x + mSquareSize, mCenterPoint.y);
        mPoints[6] = new Point(mCenterPoint.x - mSquareSize, mCenterPoint.y + mSquareSize);
        mPoints[7] = new Point(mCenterPoint.x, mCenterPoint.y + mSquareSize);
        mPoints[8] = new Point(mCenterPoint.x + mSquareSize, mCenterPoint.y + mSquareSize);
        
        mProtrusionsInterpolators[0] = 
    }

    @Override
    protected void onDrawLayer(Canvas canvas, float percent) {

    }
}
