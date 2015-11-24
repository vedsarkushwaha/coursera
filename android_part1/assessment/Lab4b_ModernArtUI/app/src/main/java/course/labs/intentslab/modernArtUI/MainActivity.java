package course.labs.intentslab.modernArtUI;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView textView1;
	TextView textView2;
	TextView textView3;
	TextView textView4;
	TextView textView5;
	TextView textView6;
	TextView textView7;
	TextView textView8;
	TextView textView9;

	SeekBar seekBar1;

	private static final int MENU_MORE_INFO = Menu.FIRST;
	static private final String URL = "http://www.google.com";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.color_table);

		initializeViews();

		seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			int progress = 0;
			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
				progress = progresValue;
				updateColor(progresValue);
//				textView5.setText(String.valueOf(progresValue));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});
	}

	private void initializeViews() {

		textView1 = (TextView) findViewById(R.id.textView1);
		textView2 = (TextView) findViewById(R.id.textView2);
		textView3 = (TextView) findViewById(R.id.textView3);
		textView4 = (TextView) findViewById(R.id.textView4);
		textView5 = (TextView) findViewById(R.id.textView5);
		textView6 = (TextView) findViewById(R.id.textView6);
		textView7 = (TextView) findViewById(R.id.textView7);
		textView8 = (TextView) findViewById(R.id.textView8);
		textView9 = (TextView) findViewById(R.id.textView9);

		seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
	}

	private void updateColor(int progresValue) {

		int newLeftColor = 0xff000000 + progresValue;
		int newRightColor = 0xff0000ff - progresValue;

		textView1.setBackgroundColor(newLeftColor);
		textView2.setBackgroundColor(newLeftColor);
		textView4.setBackgroundColor(newLeftColor);
		textView7.setBackgroundColor(newLeftColor);

		textView3.setBackgroundColor(newRightColor);
		textView6.setBackgroundColor(newRightColor);
		textView8.setBackgroundColor(newRightColor);
		textView9.setBackgroundColor(newRightColor);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(Menu.NONE, MENU_MORE_INFO, Menu.NONE, "More Information");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case MENU_MORE_INFO:
				openDialog();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	public void openDialog(){
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		alertDialogBuilder.setMessage("Not that interesting, I know...\nWould you like to google something else?");

		alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				Toast.makeText(MainActivity.this, "Let's go then!", Toast.LENGTH_SHORT).show();
				startBrowser();
			}
		});

		alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//finish();
			}
		});

		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	}

	private void startBrowser() {
		Intent baseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
		startActivity(baseIntent);
	}
}
