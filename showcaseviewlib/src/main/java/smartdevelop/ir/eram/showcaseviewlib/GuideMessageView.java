package smartdevelop.ir.eram.showcaseviewlib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.text.Spannable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

class GuideMessageView extends LinearLayout {

    public static final int GREY= 0xFFbbbdbf;
    private Paint mPaint;
    private RectF mRect;

    private TextView mTitleTextView;
    private TextView mContentTextView;

    private TextView mNextBtnText;
    private TextView mCloseBtnText;

    private ImageView mNextBtnIcon;
    private ImageView mCloseBtnIcon;

    GuideMessageView(Context context) {
        super(context);

        float density = context.getResources().getDisplayMetrics().density;
        setWillNotDraw(false);
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);

        mRect = new RectF();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        final int padding = (int) (6 * density);
        final int paddingBetween = (int) (3 * density);

       mTitleTextView = new TextView(context);
       mTitleTextView.setPadding(padding, padding, padding, paddingBetween);
       mTitleTextView.setGravity(Gravity.CENTER);
       mTitleTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
       mTitleTextView.setTextColor(Color.BLACK);
       addView(mTitleTextView, new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        mContentTextView = new TextView(context);
        mContentTextView.setTextColor(Color.BLACK);
        mContentTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        mContentTextView.setPadding(padding, paddingBetween, padding, padding);
        mContentTextView.setGravity(Gravity.CENTER);
        addView(mContentTextView, new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        mNextBtnText = new TextView(context);
        mNextBtnText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        mNextBtnText.setPadding(padding, paddingBetween, padding, padding);
        mNextBtnText.setGravity(Gravity.CENTER);
        addView(mNextBtnText, new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        mCloseBtnText = new TextView(context);
        mCloseBtnText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        mCloseBtnText.setPadding(padding, paddingBetween, padding, padding);
        mCloseBtnText.setGravity(Gravity.CENTER);
        addView(mCloseBtnText, new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        mNextBtnIcon = new ImageView(context);
        mNextBtnIcon.setPadding(padding, paddingBetween, padding, padding);
        addView(mNextBtnIcon, new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        mCloseBtnIcon = new ImageView(context);
        mCloseBtnIcon.setPadding(padding, paddingBetween, padding, padding);
        mCloseBtnIcon.setGravity(Gravity.TOP);
        addView(mCloseBtnIcon, new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

    }

   public void setTitle(String title) {
       if (title == null) {
           removeView(mTitleTextView);
           return;
       }
       mTitleTextView.setText(title);
   }


    public void setContentText(String content) {
        mContentTextView.setText(content);
    }

    public void setNextBtnIcon(int content) {
        mNextBtnIcon.setBackgroundResource(content);
    }

    public void setCloseBtnIcon(int content) {
        mCloseBtnIcon.setBackgroundResource(content);
    }

    public void setNextBtnListener(OnClickListener listener) {
        mNextBtnText.setOnClickListener(listener);
    }

    public void setCloseBtnListener(OnClickListener listener) {
        mCloseBtnText.setOnClickListener(listener);
    }

    public void setNextBtnText(String content) {
        mNextBtnText.setText(content);
    }

    public void setCloseBtnText(String content) {
        mCloseBtnText.setText(content);
    }

    public void setNextBtnTextTypeFace(Typeface typeFace) {
        mNextBtnText.setTypeface(typeFace);
    }

    public void setCloseBtnTextTypeFace(Typeface typeFace) {
        mCloseBtnText.setTypeface(typeFace);
    }

    public void setNextBtnTextSize(int size) {
        mNextBtnText.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    public void setCloseBtnTextSize(int size) {
        mCloseBtnText.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    public void setCloseBtnTextColor(int color) {
        mCloseBtnText.setTextColor(color);
    }

    public void setNextBtnTextColor(int color) {
        mNextBtnText.setTextColor(color);
    }

    public void setContentSpan(Spannable content) {
        mContentTextView.setText(content);
    }

    public void setContentTypeFace(Typeface typeFace) {
        mContentTextView.setTypeface(typeFace);
    }

   public void setTitleTypeFace(Typeface typeFace) {
       mTitleTextView.setTypeface(typeFace);
   }

   public void setTitleTextSize(int size) {
       mTitleTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
   }

    public void setContentTextSize(int size) {
        mContentTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    public void setColor(int color) {

        mPaint.setAlpha(255);
        mPaint.setColor(color);

        invalidate();
    }

    int location[] = new int[2];

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.getLocationOnScreen(location);


        mRect.set(getPaddingLeft(),
                getPaddingTop(),
                getWidth() - getPaddingRight(),
                getHeight() - getPaddingBottom());

        canvas.drawRoundRect(mRect, 15f, 15f, mPaint);
        canvas.drawColor(GREY);
    }
}
