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
    Paint paint = new Paint();
    Canvas canvas;
    public int x,y,rad;
    public float turnDegrees;

    public MyView(Context context)
    {
        super(context);
//        paint = ;
//        canvas = new Canvas();
        x = 50;
        y = 100;
        rad = 20;

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
//        canvas.drawPaint(paint);
        paint.setColor(Color.parseColor("#CD5C5C"));

    }

    @Override
    protected void onDraw(Canvas blaCanvas) {
        super.onDraw(blaCanvas);
        canvas = blaCanvas;
        canvas.rotate(turnDegrees, this.getWidth()/2, this.getHeight()/2);
        canvas.drawCircle(x, y, rad, paint);
        invalidate();
    }


    void setDegrees(float newDegrees) {
//        canvas.rotate(newDegrees);
        //both newDegrees and turnDegrees are working fine
        turnDegrees = newDegrees;
    }
}
