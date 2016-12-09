package com.zero.loadinglib.util.evaluator;

import android.animation.TypeEvaluator;
import android.graphics.Point;

/**
 * 位移线性变化
 * 轨迹：直角
 * @author linzewu
 * @date 16-12-9
 */
public class TransRightAngleEvaluator implements TypeEvaluator<Point> {
    
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        //直角点坐标
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
