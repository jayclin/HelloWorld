package com.example.helloworld.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.helloworld.R;

public class MyView extends View {
    private Paint mPaint;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        mPaint=new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(getResources().getColor(R.color.colorPrimary));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(36);
        mPaint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.second_hand);
        Bitmap bitmap1=BitmapFactory.decodeResource(getResources(),R.drawable.biaopan);
        Rect src=new Rect(0,0,bitmap1.getWidth(),bitmap1.getHeight());
        Rect dst=new Rect(bitmap1.getWidth()/2-bitmap.getWidth()/2,0,bitmap1.getWidth()/2+bitmap.getWidth()/2,bitmap1.getHeight()/2+bitmap.getHeight()/10);
        canvas.drawBitmap(bitmap,src,dst,new Paint());
        canvas.drawBitmap(bitmap1,new Matrix(),new Paint());
    }
}
