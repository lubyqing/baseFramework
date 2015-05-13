package com.base.framework.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ImageView;
import com.base.framework.R;

public class BaseProgressDialog extends Dialog {
    private static BaseProgressDialog mProgressDialog = null;

    private static AnimationDrawable animationDrawable;

    private BaseProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    public static BaseProgressDialog createDialog(Context context) {
        mProgressDialog =
                new BaseProgressDialog(context, R.style.LightProgressDialog);
        mProgressDialog.setContentView(R.layout.base_progress_dialog);
        mProgressDialog.setCancelable(true);
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams
                lp =
                mProgressDialog.getWindow().getAttributes();
        lp.dimAmount = 0.2f;
        mProgressDialog.getWindow().setAttributes(lp);

        /**
         * SHOULD NOT cancel all request here. The cancel action should trigger by dialog user!
         *
         * mProgressDialog.setOnDismissListener(new OnDismissListener() {
         *   @Override
         *   public void onDismiss(DialogInterface dialog) {
         *       ApiService.cancelAllRequest(true);
         *   }
         *});
         */

        ImageView
                imageView =
                (ImageView) mProgressDialog.findViewById(R.id.iv_loading);
        animationDrawable = (AnimationDrawable) imageView.getBackground();
        return mProgressDialog;
    }

    @Override
    public void show() {
        super.show();
        animationDrawable.start();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        animationDrawable.stop();
    }
}
