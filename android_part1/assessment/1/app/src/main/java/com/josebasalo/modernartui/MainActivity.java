package com.josebasalo.modernartui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private LinearLayout rectangle1;
    private LinearLayout rectangle2;
    private LinearLayout rectangle3;
    private LinearLayout rectangle4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rectangle1 = (LinearLayout) findViewById(R.id.rectangle_1);
        rectangle2 = (LinearLayout) findViewById(R.id.rectangle_2);
        rectangle3 = (LinearLayout) findViewById(R.id.rectangle_3);
        rectangle4 = (LinearLayout) findViewById(R.id.rectangle_4);

        initBackgroundColors();

        ((SeekBar) findViewById(R.id.seekBar)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateBackgroundColors(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void initBackgroundColors() {
        rectangle1.setBackgroundColor(Color.rgb(0, 255, 255)); //CYAN
        rectangle2.setBackgroundColor(Color.rgb(255, 0, 255)); //MAGENTA
        rectangle3.setBackgroundColor(Color.rgb(255, 0, 0)); //RED
        rectangle4.setBackgroundColor(Color.rgb(0, 0, 255)); //BUE
    }

    private void updateBackgroundColors(int value) {
        rectangle1.setBackgroundColor(Color.rgb(0 + value, 255 - value, 255));
        rectangle2.setBackgroundColor(Color.rgb(255, 0 + value, 255 - value));
        rectangle3.setBackgroundColor(Color.rgb(255 - value, 0 + value, 0 + value));
        rectangle4.setBackgroundColor(Color.rgb(0 + value, 0, 255 - value));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_more:
                new MoreInfoDialogFragment().show(getFragmentManager(), TAG );
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
