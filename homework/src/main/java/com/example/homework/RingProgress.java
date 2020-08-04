package com.example.homework;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class RingProgress extends View {

    private Context context;
    private String title;
    private String num;
    private String unit;
    private float titleSize;
    private float numSize;
    private float unitSize;
    private int titleColor;
    private int numColor;
    private int unitColor;
    private int circleColor;
    private int ringColor;
    private int endCircleColor;
    private float ringWidth;
    private float radius;
    private float endCircleRadius;
    private Paint endCirclePaint;//画终点实心大圆
    private Paint endCirclePaint2;//画终点实心小圆
    private Paint titlePaint;//画第一行文字
    private Paint numPaint;//画第二行文字
    private Paint unitPaint;//画第三行文字
    private Paint ringPaint;//画进度圆弧
    private Paint circlePaint;//画背景圆
    private int width;
    private int height;
    private float edgeDistance;
    private float currentPercent = 0.3f;

    public RingProgress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.RingProgress);
        title = array.getString(R.styleable.RingProgress_title);
        num = array.getString(R.styleable.RingProgress_num);
        unit = array.getString(R.styleable.RingProgress_unit);
        titleSize = array.getDimension(R.styleable.RingProgress_titleSize, 20);
        numSize = array.getDimension(R.styleable.RingProgress_numSize, 10);
        unitSize = array.getDimension(R.styleable.RingProgress_unitSize, 10);
        titleColor = array.getColor(R.styleable.RingProgress_titleColor, 0);
        numColor = array.getColor(R.styleable.RingProgress_numColor, 0);
        unitColor = array.getColor(R.styleable.RingProgress_unitColor, 0);
        circleColor = array.getColor(R.styleable.RingProgress_circleColor, 0);
        ringColor = array.getColor(R.styleable.RingProgress_ringColor, 0);
        endCircleColor = array.getColor(R.styleable.RingProgress_endCircleColor, 0);
        ringWidth = array.getDimension(R.styleable.RingProgress_ringWidth, 5);
        radius = array.getDimension(R.styleable.RingProgress_radius, 5);
        endCircleRadius = array.getDimension(R.styleable.RingProgress_endCircleRadius, 5);
        edgeDistance = array.getDimension(R.styleable.RingProgress_edgeDistance, 6);

        titlePaint = new Paint();
        titlePaint.setAntiAlias(true);
        titlePaint.setColor(titleColor);
        titlePaint.setTextSize(titleSize);

        numPaint = new Paint();
        numPaint.setAntiAlias(true);
        numPaint.setColor(numColor);
        numPaint.setTextSize(numSize);

        unitPaint = new Paint();
        unitPaint.setAntiAlias(true);
        unitPaint.setColor(unitColor);
        unitPaint.setTextSize(unitSize);

        ringPaint = new Paint();
        ringPaint.setAntiAlias(true);
        ringPaint.setColor(ringColor);
        ringPaint.setStyle(Paint.Style.STROKE);
        ringPaint.setStrokeCap(Paint.Cap.ROUND);
        ringPaint.setStrokeWidth(ringWidth);

        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);
        circlePaint.setStrokeWidth(radius);
        circlePaint.setColor(circleColor);
        circlePaint.setStyle(Paint.Style.STROKE);

        endCirclePaint = new Paint();
        endCirclePaint.setAntiAlias(true);
        endCirclePaint.setColor(endCircleColor);
        endCirclePaint.setStyle(Paint.Style.FILL);


        endCirclePaint2 = new Paint();
        endCirclePaint2.setAntiAlias(true);
        endCirclePaint2.setColor(Color.WHITE);
        endCirclePaint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        if (width > height){
            width = height;
        }
        if (height > width){
            height = width;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //<dimen name="px_to_dip_12">6.00dp</dimen>
        //    <dimen name="px_to_dip_14">7.00dp</dimen>
        //    <dimen name="px_to_dip_8">4.00dp</dimen>
        //    <dimen name="px_to_dip_20">10.00dp</dimen>
        //    <dimen name="px_to_dip_24">12.00dp</dimen>
        //    <dimen name="px_to_dip_48">24.00dp</dimen>
        //    <dimen name="px_to_dip_230">115.00dp</dimen>
        //    <dimen name="px_to_dip_90">45.00dp</dimen>
        int x = width/2;
        int y = height/2;
        radius = x - edgeDistance;

        canvas.drawCircle(x, y, radius, circlePaint);

        RectF rectF = new RectF(edgeDistance,
                edgeDistance,
                width - edgeDistance,
                height - edgeDistance);
        canvas.drawArc(rectF, -90,
                360 * currentPercent,
                false, ringPaint);

        Rect textRect = new Rect();

        titlePaint.getTextBounds(title, 0, title.length(), textRect);
        canvas.drawText(title, width / 2 - textRect.width() / 2,
                height / 4 + textRect.height() / 2, titlePaint);

        numPaint.getTextBounds(num, 0, num.length(), textRect);
        canvas.drawText(num, width / 2 - textRect.width() / 2,
                height / 2 + textRect.height() / 2, numPaint);

        unitPaint.getTextBounds(unit, 0, unit.length(), textRect);
        canvas.drawText(unit, width / 2 - textRect.width() / 2,
                height * 2 / 3 + textRect.height() / 2, unitPaint);

        if (currentPercent < 1 && currentPercent > 0) {
            canvas.drawCircle(x + rectF.width() / 2 * (float) Math.sin(360 * currentPercent * Math.PI / 180),
                    y - rectF.width() / 2 * (float) Math.cos(360 * currentPercent * Math.PI / 180), endCircleRadius / 2, endCirclePaint);


            canvas.drawCircle(x + rectF.width() / 2 * (float) Math.sin(360 * currentPercent * Math.PI / 180),
                    y - rectF.width() / 2 * (float) Math.cos(360 * currentPercent * Math.PI / 180), endCircleRadius / 4, endCirclePaint2);

        }
    }
    public void setValue(String value) {
        this.num = value;
        invalidate();
    }
    public void setCurrentPercent(float currentPercent) {
        this.currentPercent = currentPercent;
        invalidate();
    }
}
