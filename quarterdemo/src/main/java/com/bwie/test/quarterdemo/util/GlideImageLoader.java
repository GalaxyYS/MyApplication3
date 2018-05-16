package com.bwie.test.quarterdemo.util;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Galaxy on 2018/5/12.
 */

public class GlideImageLoader extends ImageLoader{
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        Uri parse = Uri.parse((String) path);

        imageView.setImageURI(parse);
    }


    @Override
    public ImageView createImageView(Context context) {

        SimpleDraweeView simpleDraweeView=new SimpleDraweeView(context);

        return simpleDraweeView;
    }
}
