package com.kpi.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * ProgressDialog.STYLE_SPINNER
 */
public class DialogUtils {
    private static ProgressDialog ProgressDialog;

    public static void showProgressDialog(Context context, String message) {
        ProgressDialog = new ProgressDialog(context);
        ProgressDialog.setMessage(message);
        ProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        ProgressDialog.setCanceledOnTouchOutside(true);
        ProgressDialog.show();

    }

    public static void dissmissProgressDialog() {
        ProgressDialog.dismiss();
    }
}
