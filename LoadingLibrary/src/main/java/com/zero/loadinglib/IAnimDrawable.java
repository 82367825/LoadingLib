package com.zero.loadinglib;

/**
 * @author linzewu
 * @date 2016/11/27
 */
public interface IAnimDrawable {
    
    void startAnim();
    
    void stopAnim();
    
    void refreshAnim(float percent);
    
    boolean isAnimRunning();
    
}
