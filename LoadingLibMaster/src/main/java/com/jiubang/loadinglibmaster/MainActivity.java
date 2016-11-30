package com.jiubang.loadinglibmaster;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.zero.loadinglib.spinkit.SpinKitAnimDrawable;

/**
 * @author linzewu
 * @date 16-11-30
 */
public class MainActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpinKitAnimDrawable spinKitAnimDrawable = new SpinKitAnimDrawable();
        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageDrawable(spinKitAnimDrawable);
        spinKitAnimDrawable.startAnim();
    }
    
}
