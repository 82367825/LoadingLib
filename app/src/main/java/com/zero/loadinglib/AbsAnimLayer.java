package com.zero.loadinglib;

import android.graphics.Canvas;

/**
 * @author linzewu
 * @date 2016/11/27
 */
public abstract class AbsAnimLayer {

    /**
     * 绘制动画层大小
     * <br><strong>NOTE:</strong> 当尺寸发生变化的时候调用      
     * @param realWidth 实际宽度
     * @param realHeight 实际高度
     */
    protected abstract void onMeasureLayer(int realWidth, int realHeight);

    /**
     * 绘制动画层
     * <br><strong>NOTE:</strong> 当动画线程每次刷新调用
     * @param canvas 画布
     * @param percent 动画百分比
     */
    protected abstract void onDrawLayer(Canvas canvas, float percent);
    
}
