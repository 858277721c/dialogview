package com.fanwe.dialogview;

import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fanwe.lib.animator.FNodeAnimator;
import com.fanwe.lib.dialogview.DialogView;
import com.fanwe.lib.dialogview.FDialogView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_show:

                Button button = new Button(this);
                button.setText("I am a button");

                AnimatorSet animatorShow = new FNodeAnimator(button)
                        .scaleX(0, 1).setDuration(300)
                        .withClone().scaleY(0, 1).chain().toAnimatorSet();

                AnimatorSet animatorHide = new FNodeAnimator(button)
                        .scaleX(1, 0).setDuration(300)
                        .withClone().scaleY(1, 0).chain().toAnimatorSet();

                FDialogView dialogView = new FDialogView(this);
                dialogView.setContentView(button);
                dialogView.setShowAnimator(animatorShow);
                dialogView.setHideAnimator(animatorHide);
                dialogView.setOnDismissListener(new DialogView.OnDismissListener()
                {
                    @Override
                    public void onDismiss(DialogView dialogView)
                    {
                        Log.i(TAG, "onDismiss:" + dialogView);
                        Toast.makeText(MainActivity.this, "onDismiss", Toast.LENGTH_SHORT).show();
                    }
                });
                dialogView.show();

                break;
        }
    }
}
