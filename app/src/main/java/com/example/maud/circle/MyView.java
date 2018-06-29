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
Paint paint = null;
     public int x,y,rad;
     public float turnDegrees;

    public MyView(Context context)
    {
        super(context);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        x = 50;
        y = 100;
        rad = 20;

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        paint.setColor(Color.parseColor("#CD5C5C"));
        canvas.rotate(-20);
        canvas.drawCircle(x, y, rad, paint);
    }


    void setDegrees(float newDegrees) {
        //both newDegrees and turnDegrees are working fine
        turnDegrees = newDegrees;
    }
}