package com.bwie.test.huangxing20180508_test;

import android.graphics.drawable.Animatable;
import android.media.ImageReader;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class MainActivity extends AppCompatActivity {


    private  String  ImageUrl="http://pic38.nipic.com/20140228/5571398_215900721128_2.jpg";
    private String imgGif = "http://p0.so.qhmsg.com/bdr/_240_/t0108891eccefd6968f.gif";
    private SimpleDraweeView simpleDraweeView;

    ControllerListener listener=new BaseControllerListener() {

        @Override
        public void onFinalImageSet(String id, @Nullable Object imageInfo, @Nullable Animatable animatable) {
            Toast.makeText(MainActivity.this,"成功",Toast.LENGTH_SHORT).show();
        }


        @Override
        public void onFailure(String id, Throwable throwable) {

            Toast.makeText(MainActivity.this,"失败",Toast.LENGTH_SHORT).show();
        }


    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleDraweeView = findViewById(R.id.fresco);



     //   method();
        method2();


    }

    private void method() {
        ImageRequest  request= ImageRequestBuilder.newBuilderWithSource(Uri.parse(ImageUrl))
                .setProgressiveRenderingEnabled(true)
                .build();
        DraweeController  draweeController= Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setTapToRetryEnabled(true)
                .setControllerListener(listener)
                .build();

        simpleDraweeView.setController(draweeController);

    }

    private void  method2(){


        DraweeController draweeController=Fresco.newDraweeControllerBuilder()

                .setUri(imgGif)
                .setAutoPlayAnimations(true)
                .build();

        simpleDraweeView.setController(draweeController);
    }
}
