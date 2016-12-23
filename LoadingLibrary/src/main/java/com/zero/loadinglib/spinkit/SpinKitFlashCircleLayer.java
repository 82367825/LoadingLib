package com.zero.loadinglib.spinkit;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import com.zero.loadinglib.AbsAnimLayer;
import com.zero.loadinglib.util.evaluator.AlphaEvaluator;
import com.zero.loadinglib.util.evaluator.SizeEvaluator;
import com.zero.loadinglib.util.interpolator.ReverseInterpolator;

/**
 * 大小圆闪动
 * @author linzewu
 * @date 16-12-6
 */
public class SpinKitFlashCircleLayer extends AbsAnimLayer {

    private static final int DEFAULT_COLOR = 0xff0099cc;
    private static final int DEFAULT_MAX_RADIUS = 150;
    private static final int DEFAULT_MIN_RADIUS = 5;
    private static final int DEFAULT_RADIUS = 50;
    private static final int DEFAULT_ALPHA = 100;
    private static final int DEFAULT_MAX_ALPHA = 200;
    private static final int DEFAULT_MIN_ALPHA = 85;
    
    private Point mCenterPoint;
    private int mCircleColor = DEFAULT_COLOR;
    private int mCircleRadius1 = DEFAULT_RADIUS;
    private int mCircleRadius2 = DEFAULT_RADIUS;
    private int mCircleAlpha1 = DEFAULT_ALPHA;
    private int mCircleAlpha2 = DEFAULT_ALPHA;
    private int mCircleMaxRadius = DEFAULT_MAX_RADIUS;
    private int mCircleMinRadius = DEFAULT_MIN_RADIUS;
    private int mCircleMaxAlpha = DEFAULT_MAX_ALPHA;
    private int mCircleMinAlpha = DEFAULT_MIN_ALPHA;
    
    private Paint mPaint;
    
    private SizeEvaluator mSizeEvaluator;
    private AlphaEvaluator mAlphaEvaluator;
    private ReverseInterpolator mReverseInterpolator;
    
    public SpinKitFlashCircleLayer() {
        mPaint = new Paint();
        mPaint.setColor(mCircleColor);
        mPaint.setAntiAlias(true);
        mAlphaEvaluator = new AlphaEvaluator();
        mSizeEvaluator = new SizeEvaluator();
        mReverseInterpolator = new ReverseInterpolator();
    }
    
    @Override
    protected void onMeasureLayer(int designWidth, int designHeight) {
        mCenterPoint = new Point(designWidth / 2, designHeight / 2);
        mCircleMaxRadius = designWidth / 5;
    }

    @Override
    protected void onDrawLayer(Canvas canvas, float percent) {
        mCircleRadius1 = mSizeEvaluator.evaluate(mReverseInterpolator.getInterpolation(percent), 
                mCircleMinRadius, mCircleMaxRadius);
        mCircleRadius2 = mSizeEvaluator.evaluate(mReverseInterpolator.getInterpolation(percent), 
                mCircleMaxRadius, mCircleMinRadius);
        mCircleAlpha1 = mAlphaEvaluator.evaluate(percent, mCircleMaxAlpha, mCircleMinAlpha);
        mCircleAlpha2 = mAlphaEvaluator.evaluate(percent, mCircleMinAlpha, mCircleMaxAlpha);
        mPaint.setAlpha(mCircleAlpha1);
        canvas.drawCircle(mCenterPoint.x, mCenterPoint.y, mCircleRadius1, mPaint);
        mPaint.setAlpha(mCircleAlpha2);
        canvas.drawCircle(mCenterPoint.x, mCenterPoint.y, mCircleRadius2, mPaint);
    }
}
