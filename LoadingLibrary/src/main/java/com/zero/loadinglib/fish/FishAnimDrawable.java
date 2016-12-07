package com.zero.loadinglib.fish;

import com.zero.loadinglib.AbsAnimLayer;
import com.zero.loadinglib.AnimDrawable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linzewu
 * @date 16-12-7
 */
public class FishAnimDrawable extends AnimDrawable {
    @Override
    protected List<AbsAnimLayer> getAnimLayer() {
        List<AbsAnimLayer> absAnimLayers = new ArrayList<>();
        absAnimLayers.add(new FishLayer());
        absAnimLayers.add(new FishBubbleLayer());
        return absAnimLayers;
    }

    @Override
    protected int getDrawableDesignWidth() {
        return 0;
    }

    @Override
    protected int getDrawableDesignHeight() {
        return 0;
    }

    @Override
    protected long getAnimDuration() {
        return 0;
    }
}
