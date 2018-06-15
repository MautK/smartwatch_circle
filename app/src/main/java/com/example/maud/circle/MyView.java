package com.example.maud.circle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MyView extends View
{
    private Paint paint;
     List<String> pointsFromPhone;

    public MyView(Context context)
    {
        super(context);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        int x = 200;
        int y = 100;
        int rad = 50;


        paint.setStyle(Paint.Style.FILL);
        canvas.drawColor(Color.DKGRAY);
        // Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#CD5C5C"));
        canvas.drawCircle(x, y, rad, paint);
    }

//    void getPoints(){
//       //read the arraylist with slice
//        pointsFromPhone new ArrayList<>(10);
//        String element1X = pointsFromPhone.get(2);
//
//    }
//
//    getOrientation(){
//
//    }
//
//    turnPoints(){
//
//    }
}