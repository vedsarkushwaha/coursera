package com.example.diorisaguilar.modernart;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    private TextView mTextView4;
    private TextView mTextView5;

    final String DIALOG_MESSAGE = "Inspired by the works of artists such as Piet Mondrian and Ben Nicholson";
    final String DIALOG_MESSAGE2 = "Click below to learn more!";
    final String VISIT_MOMA = "Visit MOMA";
    final String NOT_NOW = "Not Now";

    final List<Integer> colorArray = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        mTextView1 =  (TextView)findViewById(R.id.textView);
        mTextView2 =  (TextView)findViewById(R.id.textView2);
        mTextView3 =  (TextView)findViewById(R.id.textView3);
        mTextView4 =  (TextView)findViewById(R.id.textView4);
        mTextView5 =  (TextView)findViewById(R.id.textView5);

        int color = GetRandomRGBColor();
        mTextView1.setBackgroundColor(color);
        colorArray.add(color);

        color = GetRandomRGBColor();
        mTextView2.setBackgroundColor(color);
        colorArray.add(color);

        color = GetRandomRGBColor();
        mTextView3.setBackgroundColor(color);
        colorArray.add(color);

        color = GetRandomGreyColor();
        mTextView4.setBackgroundColor(color);
        colorArray.add(color);

        color = GetRandomRGBColor();
        mTextView5.setBackgroundColor(color);
        colorArray.add(color);

        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;

                mTextView1.setBackgroundColor(GetProgressColor(colorArray.get(0), progress));
                mTextView2.setBackgroundColor(GetProgressColor(colorArray.get(1), progress));
                mTextView3.setBackgroundColor(GetProgressColor(colorArray.get(2), progress));
                mTextView4.setBackgroundColor(GetProgressColor(colorArray.get(3), progress));
                mTextView5.setBackgroundColor(GetProgressColor(colorArray.get(4), progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {

            AlertDialog.Builder alertbuilder = new AlertDialog.Builder(this);
            alertbuilder.setMessage(DIALOG_MESSAGE + "\n\n" + DIALOG_MESSAGE2);

            alertbuilder.setPositiveButton(NOT_NOW, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });

            alertbuilder.setNegativeButton(VISIT_MOMA, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.moma.org"));
                    Bundle b = new Bundle();
                    b.putBoolean("new_window", true);
                    intent.putExtras(b);
                    startActivity(intent);
                }
            });


            AlertDialog dialog = alertbuilder.create();
            dialog.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public int GetProgressColor(int color, int variation)
    {
        int Rcolor = Color.red(color);
        int Gcolor = Color.green(color);
        int Bcolor = Color.blue(color);

        Rcolor = GetValidColor(Rcolor, variation);
        Gcolor = GetValidColor(Gcolor, variation);
        Bcolor = GetValidColor(Bcolor, variation);

        return Color.rgb(Rcolor, Gcolor, Bcolor);
    }

    private int GetRandomRGBColor()
    {
        Random intRandom = new Random();
        return Color.rgb(intRandom.nextInt(255) + 1,
                         intRandom.nextInt(255) + 1,
                         intRandom.nextInt(255) + 1);
    }

    public int GetValidColor(int color, int progress)
    {
        if(color + progress > 0 && color + progress < 255){
            color = color + progress;
        }else if(color + progress < 0) {
            color = 0;
        }else {
            color = 255;
        }

        return color;
    }

    private int GetRandomGreyColor()
    {
        Random intRandom = new Random();
        int color = intRandom.nextInt(255) + 1;
        return Color.rgb(color,color,color);
    }

}
