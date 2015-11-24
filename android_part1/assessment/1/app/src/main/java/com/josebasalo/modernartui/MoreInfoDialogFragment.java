package com.josebasalo.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * Created by basalo on 7/11/15.
 */
public class MoreInfoDialogFragment extends DialogFragment {
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        DialogInterface.OnClickListener positiveClick = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moma.org"));
                getActivity().startActivity(intent);
            }
        };

        DialogInterface.OnClickListener negativeClick = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dismiss();
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setNegativeButton(getString(R.string.not_now), negativeClick);
        builder.setPositiveButton(getString(R.string.visit_moma), positiveClick);
        builder.setTitle(getString(R.string.title_more_info_dialog));
        Dialog dialog = builder.create();
        return dialog;
    }
}
