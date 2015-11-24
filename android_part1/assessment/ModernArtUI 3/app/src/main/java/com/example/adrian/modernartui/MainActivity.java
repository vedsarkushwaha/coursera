package com.example.adrian.modernartui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1,tv2,tv3,tv4,tv5;
    private SeekBar sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        tv4 = (TextView) findViewById(R.id.textView4);
        tv5 = (TextView) findViewById(R.id.textView5);
        sb =  (SeekBar)  findViewById(R.id.seekBar);
        sb.setProgress(0);
        setTextViewColors(0);
        tv4.setBackgroundColor(Color.argb(0xff,120,120,120));
        sb.setMax(170);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setTextViewColors(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setTextViewColors(int progress)
    {
        progress+=50;
        tv1.setBackgroundColor(Color.argb(0xff,0xff-progress,progress,progress));
        tv2.setBackgroundColor(Color.argb(0xff,50,progress,0xff-progress));
        tv3.setBackgroundColor(Color.argb(0xff,0,100,progress));
    //    tv4.setBackgroundColor(Color.argb(0xff,0xff-progress,0xff-progress,0xff-progress));
        tv5.setBackgroundColor(Color.argb(0xff,progress,150,220-progress));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.more_info)
        {
            MoreInfoDialog mi = new MoreInfoDialog();
            mi.show(getFragmentManager(),"MyDialog");
            return true;

        }
        return false;
    }
}
