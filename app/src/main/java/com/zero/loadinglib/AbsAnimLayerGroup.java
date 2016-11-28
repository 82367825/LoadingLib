package com.zero.loadinglib;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linzewu
 * @date 2016/11/27
 */
public abstract class AbsAnimLayerGroup extends AbsAnimLayer {

    private List<AbsAnimLayer> mAbsAnimLayers;
    
    public AbsAnimLayerGroup() {
        mAbsAnimLayers = new ArrayList<AbsAnimLayer>();
    }

    @Override
    protected void onMeasureLayer(int designWidth, int designHeight, int realWidth, int realHeight) {
        for (AbsAnimLayer absAnimLayer : mAbsAnimLayers) {
            absAnimLayer.onMeasureLayer(designWidth, designHeight, realWidth, realHeight);
        }
    }

    @Override
    protected void onDrawLayer(Canvas canvas, float percent, float scaleSize) {
        for (AbsAnimLayer absAnimLayer : mAbsAnimLayers) {
            absAnimLayer.onDrawLayer(canvas, percent, scaleSize);
        }
    }
}
