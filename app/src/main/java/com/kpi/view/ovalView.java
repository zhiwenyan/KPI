package com.kpi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

import com.storm.kpi.R;


public class ovalView extends TextView {
    private Paint mpanit;
    private int color = Color.GREEN;  //默认的颜色

    public ovalView(Context context) {
        this(context, null);
    }

    public ovalView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public ovalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mpanit = new Paint();

        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.oval);
        color = (int) ta.getDimension(R.styleable.oval_oval_color, color);
        ta.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mpanit.setAntiAlias(true);
        mpanit.setColor(color);
        RectF rectF = new RectF(0, 0, 400, 200);
        canvas.drawOval(rectF, mpanit);
    }
}
