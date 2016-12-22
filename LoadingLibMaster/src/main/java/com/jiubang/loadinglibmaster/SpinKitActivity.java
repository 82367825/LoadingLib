package com.jiubang.loadinglibmaster;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.zero.loadinglib.spinkit.SpinKitAnimDrawable;

/**
 * @author linzewu
 * @date 16-12-7
 */
public class SpinKitActivity extends Activity {

    private ImageView mBounceImageView;
    private ImageView mFlashCircleImageView;
    private ImageView mNineSquareImageView;
    private ImageView mSoundImageView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinkit);
        
        mBounceImageView = (ImageView) findViewById(R.id.spinkit_bounce);
        mBounceImageView.setImageDrawable(new SpinKitAnimDrawable().setType(SpinKitAnimDrawable.TYPE_BOUNCE));
        
        mFlashCircleImageView = (ImageView) findViewById(R.id.spinkit_flashcircle);
        mFlashCircleImageView.setImageDrawable(new SpinKitAnimDrawable().setType(SpinKitAnimDrawable.TYPE_FLASH_CIRCLE));
        
        mNineSquareImageView = (ImageView) findViewById(R.id.spinkit_ninesquare);
        mNineSquareImageView.setImageDrawable(new SpinKitAnimDrawable().setType(SpinKitAnimDrawable.TYPE_NINE_SQUARE));
        
        mSoundImageView = (ImageView) findViewById(R.id.spinkit_sound);
        mSoundImageView.setImageDrawable(new SpinKitAnimDrawable().setType(SpinKitAnimDrawable.TYPE_SOUND));
    }
}
