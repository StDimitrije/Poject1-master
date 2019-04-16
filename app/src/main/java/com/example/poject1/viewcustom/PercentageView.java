package com.example.poject1.viewcustom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.example.poject1.R;
import com.example.poject1.model.Category;
import com.example.poject1.util.Util;

import java.util.List;

import androidx.appcompat.widget.AppCompatTextView;

public class PercentageView extends AppCompatTextView {

    private static final float CIRCLE_STROKE_WIDTH_DP = 4;
    private List<Category> mCategoryList;


    private RectF mRectF;
    private Paint mPaint;

    public PercentageView(Context context) {
        super(context);
    }

    public PercentageView(Context context, AttributeSet attrs) {

        super(context, attrs);
    }

    public PercentageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setCategoryList(List<Category> categoryList) {
        mCategoryList = categoryList;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float strokeWidth = Util.DpToPx(getContext(), CIRCLE_STROKE_WIDTH_DP);
        float left = 0 + strokeWidth;
        float top = 0 + strokeWidth;
        float bottom = canvas.getHeight() - strokeWidth;
        float right = canvas.getWidth() - strokeWidth;
        float sweepAngle = 0;
        float startAngle = 0;

        mRectF = new RectF();
        mPaint = new Paint();

        mRectF.set(left,top,right,bottom);
        int color = getContext().getResources().getColor(R.color.colorPrimary);
        mPaint.setColor(color);

        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(16);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        canvas.drawOval(mRectF, mPaint);


        int i = 0;
        int sumCategory=0;

        int color1 = getContext().getResources().getColor(R.color.pie1);
        int color2 = getContext().getResources().getColor(R.color.pie2);
        int color3 = getContext().getResources().getColor(R.color.pie3);
        int color4 = getContext().getResources().getColor(R.color.pie4);
        int color5 = getContext().getResources().getColor(R.color.pie5);
        int color6 = getContext().getResources().getColor(R.color.pie6);
        int color7 = getContext().getResources().getColor(R.color.pie7);
        int colors[] = {color1, color2, color3, color4, color5,color6,color7};

        for(Category category: mCategoryList){

            sumCategory += category.getmSum();
        }

        for(Category category: mCategoryList){
            mPaint.setColor(colors[i++]);
            if(category.getmSum()!=0){
                sweepAngle = category.getmSum() / sumCategory * 360;
            }else{
                sweepAngle = 0;
            }

            canvas.drawArc(mRectF, startAngle, sweepAngle, false, mPaint);
            startAngle+=sweepAngle;
        }



    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int length = Math.min(width, height);
        int newMeasureSpec = MeasureSpec.makeMeasureSpec(length, MeasureSpec.EXACTLY);

        super.onMeasure(newMeasureSpec, newMeasureSpec);
    }




}
