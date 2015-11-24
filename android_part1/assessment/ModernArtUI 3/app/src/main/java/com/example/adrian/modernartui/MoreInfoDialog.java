package com.example.adrian.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Adrian on 03.11.2015.
 */


public class MoreInfoDialog extends DialogFragment {
    protected static final String URL = "http://www.moma.org";
    protected static final CharSequence CHOOSER_TEXT = "Please choose browser";

    public MoreInfoDialog() {

    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View customAlertDialog;



        LayoutInflater li = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        customAlertDialog = li.inflate(R.layout.more_info_dialog,null);
        builder.setView(customAlertDialog);


        final AlertDialog dialog = builder.create();

        TextView positive_button = (TextView) customAlertDialog.findViewById(R.id.textView6);
        positive_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent baseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                Intent chooserIntent = new Intent(Intent.createChooser(baseIntent, CHOOSER_TEXT));
                startActivity(chooserIntent);
            }
        });

        TextView negative_button = (TextView) customAlertDialog.findViewById(R.id.textView7);
        negative_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });



        // 3. Get the AlertDialog from create()

        return dialog;
    }

}


