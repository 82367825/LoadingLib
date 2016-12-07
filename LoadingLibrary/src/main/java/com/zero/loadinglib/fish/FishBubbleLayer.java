package com.zero.loadinglib.fish;

import android.graphics.Canvas;
import android.graphics.Point;

import com.zero.loadinglib.AbsAnimLayer;

/**
 * 鱼吐气动画层
 * @author linzewu
 * @date 16-12-7
 */
public class FishBubbleLayer extends AbsAnimLayer {
    
    
    
    @Override
    protected void onMeasureLayer(int designWidth, int designHeight) {
        
    }

    @Override
    protected void onDrawLayer(Canvas canvas, float percent) {

    }
    
    private class FishBubble {
        private Point mBubblePoint;
        private int mBubbleRadius;
        
        public FishBubble() {
            
        }
    }
    
}
