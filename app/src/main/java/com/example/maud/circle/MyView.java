package com.example.maud.circle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MyView extends View
{
    private Paint paint;
     List<String> pointsFromPhone;
     public int x,y,rad;
     public float turnDegrees;
     public Canvas canvas;

    public MyView(Context context)
    {
        super(context);
        paint = new Paint();
    }

    protected void draw()
    {
        canvas = new Canvas();
        x = canvas.getWidth()/2;
        y = 0;
        rad = 20;

        paint.setStyle(Paint.Style.FILL);
        canvas.drawColor(Color.DKGRAY);
        // Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#CD5C5C"));
        canvas.drawCircle(x, y, rad, paint);
    }

    void setDegrees(float newDegrees) {
        //both newDegrees and turnDegrees are working fine
        turnDegrees = newDegrees;
    }

    void drawCanvas() {
        canvas.save();
        canvas.rotate(turnDegrees);
        Log.d("degrees", "drawCanvas: turnDegrees" + turnDegrees);
    }
}