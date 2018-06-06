package com.fanwe.dialogview;

import android.app.Activity;

import com.fanwe.lib.dialoger.animator.ScaleXYCreater;
import com.fanwe.lib.dialoger.impl.FDialoger;
import com.fanwe.lib.dialogview.impl.FConfirmView;

public class ConfirmDialoger extends FDialoger
{
    private FConfirmView mConfirmView;

    public ConfirmDialoger(Activity activity)
    {
        super(activity);
        setContentView(getConfirmView());
        setPadding(0, 0, 0, 0);
        setAnimatorCreater(new ScaleXYCreater());
    }

    public FConfirmView getConfirmView()
    {
        if (mConfirmView == null)
            mConfirmView = new FConfirmView(getContext());
        return mConfirmView;
    }
}
