package com.zero.loadinglib;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

import java.util.List;


/**
 * @author linzewu
 * @date 2016/11/27
 */
public abstract class AnimDrawable extends Drawable implements IAnimDrawable {
    
    /* 默认设计尺寸为768*1280 */
    private static final float DEFAULT_DRAWABLE_WIDTH = 768f;
    private static final float DEFAULT_DRAWABLE_HEIGHT = 1280f;
    /* 默认的透明度 */
    private static final float DEFAULT_DRAWABLE_ALPHA = 1f;
    
    private AnimDrawableController mAnimDrawableController;
    private List<AbsAnimLayer> mAbsAnimLayers;
    
    /* 当前动画执行百分比 */
    private float mCurrentPercent;
    /* Drawable设计图上的宽度 Drawable内部宽度 */
    private float mDrawableDesignWidth;
    /* Drawable设计图上的高度 Drawable内部高度 */
    private float mDrawableDesignHeight;
    
    private float mDrawableAlpha; 
    private ColorFilter mColorFilter;
    
    public AnimDrawable() {
        initAnimDrawable();
    }
    
    @Override
    public void draw(Canvas canvas) {
        if (mDrawableDesignWidth == 0 || mDrawableDesignHeight == 0) {
            return ;
        }
        for (AbsAnimLayer absAnimLayer : mAbsAnimLayers) {
            absAnimLayer.onDrawLayer(canvas, mCurrentPercent);
        }
    }
    
    private void initAnimDrawable() {
        mAnimDrawableController = new AnimDrawableController(this);
        mAnimDrawableController.setAnimDuration(getAnimDuration());
        mDrawableDesignWidth = getDrawableDesignWidth();
        mDrawableDesignHeight = getDrawableDesignHeight();
        if (mDrawableDesignWidth <= 0) {
            mDrawableDesignWidth = DEFAULT_DRAWABLE_WIDTH;
        }
        if (mDrawableDesignHeight <= 0) {
            mDrawableDesignHeight = DEFAULT_DRAWABLE_HEIGHT;
        }
        mDrawableAlpha = DEFAULT_DRAWABLE_ALPHA;
        initAnimLayer();
    }
    
    protected void initAnimLayer() {
        mAbsAnimLayers = getAnimLayer();
        for (AbsAnimLayer absAnimLayer : mAbsAnimLayers) {
            absAnimLayer.onMeasureLayer((int)mDrawableDesignWidth, (int) mDrawableDesignHeight);
        }
    }

    /**
     * 初始化Drawable动画层
     */
    protected abstract List<AbsAnimLayer> getAnimLayer();

    /**
     * 初始化Drawable内部宽度
     * @return
     */
    protected abstract int getDrawableDesignWidth();

    /**
     * 初始化Drawable内部宽度
     * @return
     */
    protected abstract int getDrawableDesignHeight();

    /**
     * 初始化动画循环时间
     * @return
     */
    protected abstract long getAnimDuration();
    

    @Override
    public void startAnim() {
        mAnimDrawableController.startAnim();
    }

    @Override
    public void stopAnim() {
        mAnimDrawableController.stopAnim();
    }

    @Override
    public void refreshAnim(float percent) {
        this.mCurrentPercent = percent;
        invalidateSelf();
    }

    @Override
    public boolean isAnimRunning() {
        return mAnimDrawableController.isAnimRunning();
    }

    @Override
    public void setAlpha(int alpha) {
        this.mDrawableAlpha = alpha;
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
    
    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
    }
    
    /* 当View设置为wrap_content时获取宽度值 */
    @Override
    public int getIntrinsicWidth() {
        return (int) mDrawableDesignWidth;
    }

    /* 当View设置为wrap_content时获取高度值 */
    @Override
    public int getIntrinsicHeight() {
        return (int) mDrawableDesignHeight;
    }
}
