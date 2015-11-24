package com.example.vedsark.modernartui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String TAG="myLogger";
    FrameLayout fr1;
    FrameLayout fr2;
    FrameLayout fr3;
    FrameLayout fr4;
    FrameLayout fr5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar sb = (SeekBar) findViewById(R.id.seekBar);
        fr1 = (FrameLayout) findViewById(R.id.frameLayout1);
        fr1.setBackgroundColor(0xffffffff);

        fr2 = (FrameLayout) findViewById(R.id.frameLayout2);
        fr2.setBackgroundColor(0xffff0000);

        fr3 = (FrameLayout) findViewById(R.id.frameLayout3);
        fr3.setBackgroundColor(0xff00ff00);

        fr4 = (FrameLayout) findViewById(R.id.frameLayout4);
        fr4.setBackgroundColor(0xff0000ff);

        fr5 = (FrameLayout) findViewById(R.id.frameLayout5);
        fr5.setBackgroundColor(0xff000000);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i(TAG,progress+"");
                fr1.setBackgroundColor(0xff000000 + 0x10000*(0xff-progress) + 0x100*(0xff-progress) + 0xff-progress);
                fr2.setBackgroundColor(0xff000000 + 0x10000*(0xff-progress) + 0x100*progress);
                fr3.setBackgroundColor(0xff000000 + 0x100*(0xff-progress) + progress);
                fr4.setBackgroundColor(0xff000000 + 0x10000*progress + 0xff-progress);
                fr5.setBackgroundColor(0xff000000 + 0x10000*progress + 0x100*progress + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Get a reference to the MenuInflater
        MenuInflater inflater = getMenuInflater();

        // Inflate the menu using activity_menu.xml
        inflater.inflate(R.menu.mymenu, menu);

        // Return true to display the menu
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        Toast.makeText(getApplicationContext(), "This is menu Click", Toast.LENGTH_SHORT).show();
//        return true;
        AlertDialog.Builder alertBox = new AlertDialog.Builder(this);
        alertBox.setMessage("Inspired by the works of Modern Art masters such as Piet Mondrian and Ben Nicholson\n\n" +
                "Click below to learn more!\n\n");
        alertBox.setNegativeButton("Visit MOMA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i(TAG, which + "");
                Intent openPage = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moma.org"));
                Intent chooserIntent = Intent.createChooser(openPage, "open MoMa.org with:");
                startActivity(chooserIntent);
            }
        });
        alertBox.setPositiveButton("Not Now", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i(TAG,which +"");
            }
        });
        alertBox.show();
        return true;
    }
}