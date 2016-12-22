package com.zero.loadinglib.spinkit;

import com.zero.loadinglib.AbsAnimLayer;
import com.zero.loadinglib.AnimDrawable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linzewu
 * @date 2016/11/27
 */
public class SpinKitAnimDrawable extends AnimDrawable {
    
    private static final int DRAWABLE_DESIGN_WIDTH = 768;
    private static final int DRAWABLE_DESIGN_HEIGHT = 768;
    private static final long ANIM_DURATION = 500;
    
    public static final int TYPE_BOUNCE = 1;
    public static final int TYPE_NINE_SQUARE = 2;
    public static final int TYPE_FLASH_CIRCLE = 3;
    public static final int TYPE_SOUND = 4;
    
    private int mCurrentType;
    
    public SpinKitAnimDrawable setType(int currentType) {
        this.mCurrentType = currentType;
        return this;
    }
    
    @Override
    protected List<AbsAnimLayer> getAnimLayer() {
        List<AbsAnimLayer> absAnimLayers = new ArrayList<AbsAnimLayer>();
        switch (this.mCurrentType) {
            case TYPE_BOUNCE:
                absAnimLayers.add(new SpinKitBounceLayer());
                break;
            case TYPE_FLASH_CIRCLE:
                absAnimLayers.add(new SpinKitFlashCircleLayer());
                break;
            case TYPE_NINE_SQUARE:
                absAnimLayers.add(new SpinKitFlashCircleLayer());
                break;
            case TYPE_SOUND:
                absAnimLayers.add(new SpinKitSoundLayer());
                break;
            default:
                break;
        }
        return absAnimLayers;
    }

    @Override
    protected int getDrawableDesignWidth() {
        return DRAWABLE_DESIGN_WIDTH;
    }

    @Override
    protected int getDrawableDesignHeight() {
        return DRAWABLE_DESIGN_HEIGHT;
    }

    @Override
    protected long getAnimDuration() {
        return ANIM_DURATION;
    }
}
