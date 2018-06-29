package com.example.maud.circle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MyView extends View
{
    Paint paint;
    Canvas canvas;
    public int x,y,rad;
    public float turnDegrees;

    public MyView(Context context)
    {
        super(context);
        paint = new Paint();
//        canvas = new Canvas();

    }

    @Override
    protected void onDraw(Canvas blaCanvas) {
        super.onDraw(blaCanvas);
        x = 50;
        y = 100;
        rad = 20;
        canvas = blaCanvas;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        setDegrees(-0);
        paint.setColor(Color.parseColor("#CD5C5C"));
        canvas.drawCircle(x, y, rad, paint);
    }


    void setDegrees(float newDegrees) {
        canvas.rotate(newDegrees);
        //both newDegrees and turnDegrees are working fine
//        turnDegrees = newDegrees;
    }
}
