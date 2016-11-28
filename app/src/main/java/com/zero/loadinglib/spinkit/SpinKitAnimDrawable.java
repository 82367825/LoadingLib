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
    private static final int DRAWABLE_DESIGN_HEIGHT = 1280;
    private static final long ANIM_DURATION = 2500;
    
    public static final int TYPE_BOUNCE = 1;
    public static final int TYPE_CUDE = 2;
    public static final int TYPE_DOT = 3;
    public static final int TYPE_SOUND = 4;
    
    private int mCurrentType;
    
    @Override
    protected List<AbsAnimLayer> getAnimLayer() {
        List<AbsAnimLayer> absAnimLayers = new ArrayList<AbsAnimLayer>();
        return null;
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
