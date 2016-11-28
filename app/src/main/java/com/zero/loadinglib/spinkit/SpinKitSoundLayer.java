package com.zero.loadinglib.spinkit;

import android.graphics.Canvas;
import com.zero.loadinglib.AbsAnimLayer;

/**
 * @author linzewu
 * @date 2016/11/27
 */
public class SpinKitSoundLayer extends AbsAnimLayer {
    
    private int mStripWidth;
    private int mStripNumber;
    private int mStripMinLength;
    private int mStripMaxLength;
    
    @Override
    protected void onMeasureLayer(int designWidth, int designHeight, 
                                  int realWidth, int realHeight) {
        
    }

    @Override
    protected void onDrawLayer(Canvas canvas, float percent, float scaleSize) {

    }
}
