package prototype.activities;

import prototype.helper.Helper;
import prototype.start.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.TabActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class ReadingActivity extends Activity {

	final private int PUSH_FINISH_ELEMENT = 1;
	private Dialog dialog;
	private ImageButton likeImageButton, dislikeImageButton, skipImageButton,
			submitImageButton;
	private boolean bookMarkPushed, finishBookPushed;
	private ImageView topBarImage, bookMarkImage, finishBookImage;
	private int book = 0;
	private OnClickListener topBarImageClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			//Toast.makeText(ReadingActivity.this, "TopBar Push", 10).show();

		}
	};

	private OnClickListener bookMarkImageClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			if (bookMarkPushed) {
				bookMarkImage.setImageResource(R.drawable.bookmark);
				bookMarkPushed = false;

			} else if (!bookMarkPushed) {
				bookMarkImage.setImageResource(R.drawable.bookmark_pushed);
				bookMarkPushed = true;

			}

			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {

					SharedPreferences myPrefs = ReadingActivity.this
							.getSharedPreferences("myPrefs",
									MODE_WORLD_READABLE);
					int tab = myPrefs.getInt("curentTab", 0);
					new Helper().ShowMainActivityAndSetCurrentTab(
							ReadingActivity.this, tab);
					bookMarkImage.setImageResource(R.drawable.bookmark);
					bookMarkPushed = false;

				}
			}, 250);

		}
	};
	private OnClickListener finishBookImageClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			if (finishBookPushed) {
				finishBookImage.setImageResource(R.drawable.finish_book);
				finishBookPushed = false;
			} else if (!finishBookPushed) {
				finishBookImage.setImageResource(R.drawable.finish_book_pushed);
				finishBookPushed = true;
			}

			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					didFinishBook();

				}
			}, 250);

		}
	};

	public void didFinishBook() {

		TabActivity tabActivity = (TabActivity) this.getParent();
		tabActivity.getTabHost().setCurrentTab(6);
	}

	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {

		dialog = new Dialog(this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

		dialog.setContentView(R.layout.activity_reading_finish_book);

		return dialog;
	}

	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {

			super.handleMessage(msg);
			dialog.dismiss();
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SetUp();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tab_host, menu);
		return true;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		SetUp();

	}

	private void SetUp() {
		setContentView(R.layout.activity_reading);
		bookMarkPushed = false;
		finishBookPushed = false;
		topBarImage = (ImageView) findViewById(R.id.topBarImage);
		bookMarkImage = (ImageView) findViewById(R.id.bookMarkImage);

		finishBookImage = (ImageView) findViewById(R.id.finishBookImage);

		topBarImage.setOnClickListener(topBarImageClick);
		bookMarkImage.setOnClickListener(bookMarkImageClick);
		finishBookImage.setOnClickListener(finishBookImageClick);
		SharedPreferences myPrefs = ReadingActivity.this.getSharedPreferences(
				"myPrefs", MODE_WORLD_READABLE);
		book = myPrefs.getInt("lastInt", -1);
		if (book != 2) {
			// Toast.makeText(this, "!=2 : " + book, 10).show();
			finishBookImage.setVisibility(View.GONE);
			SharedPreferences.Editor prefsEditor = myPrefs.edit();
			prefsEditor.putInt("lastInt", book);
			prefsEditor.commit();
		}
		if (book == 2) {

			// Toast.makeText(this, "==2 : " + book, 10).show();
			SharedPreferences.Editor prefsEditor = myPrefs.edit();
			prefsEditor.putInt("lastInt", 0);
			prefsEditor.commit();
			finishBookImage.setVisibility(View.VISIBLE);
		}
		book = 0;

	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		// Toast.makeText(this, "restart", 10).show();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		// Toast.makeText(this, "resume", 10).show();
		SetUp();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		// Toast.makeText(this, "stop", 10).show();
	}

}
