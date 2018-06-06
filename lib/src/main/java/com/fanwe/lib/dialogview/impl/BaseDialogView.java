package com.fanwe.lib.dialogview.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class BaseDialogView extends FrameLayout implements View.OnClickListener
{
    public BaseDialogView(Context context)
    {
        super(context);
        init();
    }

    public BaseDialogView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public BaseDialogView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init()
    {
        final int widthScreenPercent = (int) (getContext().getResources().getDisplayMetrics().widthPixels * 0.8f);
        final int widthFix = (int) (getContext().getResources().getDisplayMetrics().density * 300);

        final int width = Math.min(widthScreenPercent, widthFix);
        final int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        setLayoutParams(new ViewGroup.LayoutParams(width, height));
    }

    public void setContentView(int layoutId)
    {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(layoutId, this, true);
    }

    public void setContentView(View view)
    {
        removeAllViews();
        addView(view);
    }

    @Override
    public void onClick(View v)
    {

    }

    protected static void setBackgroundDrawable(View view, Drawable drawable)
    {
        if (view == null)
        {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundDrawable(drawable);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}
