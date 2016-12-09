package com.zero.loadinglib.util.interpolator;

import android.view.animation.Interpolator;

/**
 * 间歇插值器
 * 先静止，后匀速，再静止，后匀速
 * @author linzewu
 * @date 16-12-1
 */
public class IntermittentInterpolator implements Interpolator {
    
    private static final float FIRST_INTERMITTENT_FRACTION = 0f;
    private static final float FIRST_INTERMITTENT_RECOVER_FRACTION = 0.2f;
    private static final float SECOND_INTERMITTENT_FRACTION = 0.5f;
    private static final float SECOND_INTERMITTENT_RECOVER_FRACTION = 0.7f;
    
    @Override
    public float getInterpolation(float input) {
        if (input >= FIRST_INTERMITTENT_FRACTION && input <= FIRST_INTERMITTENT_RECOVER_FRACTION) {
            return 0f;
        } else if (input > FIRST_INTERMITTENT_RECOVER_FRACTION && input <= 
                SECOND_INTERMITTENT_FRACTION) {
            return (input - FIRST_INTERMITTENT_RECOVER_FRACTION) / 
                    (2 * (0.5f - FIRST_INTERMITTENT_RECOVER_FRACTION)); 
        } else if (input > SECOND_INTERMITTENT_FRACTION && input <= 
                SECOND_INTERMITTENT_RECOVER_FRACTION) {
            return 0.5f;
        } else {
            return 0.5f + (input - SECOND_INTERMITTENT_RECOVER_FRACTION) / 
                    (2 * (1f - SECOND_INTERMITTENT_RECOVER_FRACTION));
        }
    }
}
