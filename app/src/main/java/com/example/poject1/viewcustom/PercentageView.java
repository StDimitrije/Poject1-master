package com.example.poject1.viewcustom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.example.poject1.R;
import com.example.poject1.util.Util;

import androidx.appcompat.widget.AppCompatTextView;

public class PercentageView extends AppCompatTextView {

    private static final float CIRCLE_STROKE_WIDTH_DP = 4;

    private int mForegroundCircleColor;
    private int mBackgroundCircleColor;
    private float mCircleStrokeWidthInPx;

    private RectF mRectF;
    private Paint mPaint;

    public PercentageView(Context context) {
        super(context);
        init(null);
    }

    public PercentageView(Context context, AttributeSet attrs) {

        super(context, attrs);
        init(attrs);
    }

    public PercentageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float left = 0 + mCircleStrokeWidthInPx;
        float top = 0 + mCircleStrokeWidthInPx;
        float bottom = getHeight() - mCircleStrokeWidthInPx;
        float right = getWidth() - mCircleStrokeWidthInPx;

        mRectF.set(left, top, right, bottom);

        mPaint.setAntiAlias(true);
        mPaint.setColor(mBackgroundCircleColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mCircleStrokeWidthInPx);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        canvas.drawOval(mRectF, mPaint);

        mPaint.setColor(mForegroundCircleColor);


        float sweepAngle = getSweepAngle();
        canvas.drawArc(mRectF, 270f, sweepAngle, false, mPaint);

    }

    private float getSweepAngle() {
        CharSequence text = getText();
        boolean isNumber = TextUtils.isDigitsOnly(text);
        boolean isEmpty = TextUtils.isEmpty(text);

        if (isEmpty || !isNumber){
            return 0;
        }

        int number = Integer.parseInt(text.toString());
        float angle = (number / 100f) * 360;
        return angle;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int length = Math.min(width, height);
        int newMeasureSpec = MeasureSpec.makeMeasureSpec(length, MeasureSpec.EXACTLY);

        super.onMeasure(newMeasureSpec, newMeasureSpec);
    }

    private void init(AttributeSet attrs){

        parseAttributes(attrs);
        mRectF = new RectF();
        mPaint = new Paint();
    }

    private void parseAttributes(AttributeSet attrs) {

        if (attrs == null) {
            return;
        }
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.PercentageTextView);
        mForegroundCircleColor = typedArray.getColor(R.styleable.PercentageTextView_foregroundCircleColor, 0);
        mBackgroundCircleColor = typedArray.getColor(R.styleable.PercentageTextView_backgroundCircleColor, 0);
        int defaultValue = (int) Util.DpToPx(getContext(), CIRCLE_STROKE_WIDTH_DP);
        mCircleStrokeWidthInPx = typedArray.getDimensionPixelSize(R.styleable.PercentageTextView_circleStrokeWidth, defaultValue);
        typedArray.recycle();
    }




}
