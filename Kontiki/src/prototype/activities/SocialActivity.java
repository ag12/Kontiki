package prototype.activities;

import prototype.adapter.ImageAdapter;
import prototype.adapter.SocialArrayadapter;
import prototype.externals.CoverFlow;
import prototype.helper.Helper;
import prototype.start.R;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class SocialActivity extends ListActivity {

	final private int PUSH_LIST_ELEMENT = 1;
	private Dialog dialog;

	private ImageButton customExitButton2, customStartReadingButton2,
			customDiscussButton2;

	private Button customExitButton, customStartReadingButton,
			customDiscussButton;
	private ImageView discussionImage, newsFeedImage;
	private OnClickListener newFeedImageClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			Toast.makeText(SocialActivity.this, "news feed my ass", 10).show();

		}
	};
	private OnClickListener discussionClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			Toast.makeText(SocialActivity.this, "discuss", 10).show();

		}
	};
	private OnClickListener customExitButtonClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			handler.sendEmptyMessage(0);

		}
	};
	private OnClickListener customStartReadingClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			// handler.sendEmptyMessage(0);
			// new Handler().postDelayed(new Runnable() {

			// @Override
			// public void run() {

			SharedPreferences myPrefs = SocialActivity.this
					.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
			SharedPreferences.Editor prefsEditor = myPrefs.edit();
			prefsEditor.putInt("curentTab", 2);
			prefsEditor.commit();
			Helper.GoToBookReadingView(SocialActivity.this);

			// }
			// }, 250);

		}
	};
	private OnClickListener customDiscussClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Toast.makeText(SocialActivity.this, "discuss?", 10).show();

		}
	};

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_social);
		ListView socialListView = (ListView) findViewById(android.R.id.list);

		int[] people = new int[] { 1, 2, 3, 4/*, 5 /* ,6,7,8 */};
		String[] emptySpaces = { "", "", "", ""/*, ""/* ,"","","" */};
		SocialArrayadapter arrayadapter = new SocialArrayadapter(this,
				R.layout.row_layout_social, people, emptySpaces);

		socialListView.setAdapter(arrayadapter);

		newsFeedImage = (ImageView) findViewById(R.id.news_feed_img);
		discussionImage = (ImageView) findViewById(R.id.discussions_img);
		newsFeedImage.setOnClickListener(newFeedImageClick);
		discussionImage.setOnClickListener(discussionClick);

		LinearLayout layout = (LinearLayout) findViewById(R.id.cowerflowLayout);

		CoverFlow coverFlow;
		coverFlow = new CoverFlow(this);

		ImageAdapter imageAdapter = new ImageAdapter(this);

		coverFlow.setAdapter(imageAdapter);

		coverFlow.setSpacing(-25);
		coverFlow.setSelection(4, true);
		coverFlow.setAnimationDuration(1000);

		layout.addView(coverFlow);

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		showDialog(PUSH_LIST_ELEMENT);
	}

	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {

		dialog = new Dialog(this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

		// IF USING BUTTONS
		dialog.setContentView(R.layout.social_push_activity);
		customExitButton = (Button) dialog.findViewById(R.id.customExitButton);
		customExitButton.setVisibility(View.VISIBLE);
		customExitButton.setBackgroundColor(Color.TRANSPARENT);
		customExitButton.setOnClickListener(customExitButtonClick);

		customStartReadingButton = (Button) dialog
				.findViewById(R.id.customStartReadingButton);
		customStartReadingButton.setVisibility(View.VISIBLE);
		customStartReadingButton.setBackgroundColor(Color.TRANSPARENT);
		customStartReadingButton.setOnClickListener(customStartReadingClick);

		customDiscussButton = (Button) dialog
				.findViewById(R.id.customDiscussButton);
		customDiscussButton.setVisibility(View.VISIBLE);
		customDiscussButton.setBackgroundColor(Color.TRANSPARENT);
		customDiscussButton.setOnClickListener(customDiscussClick);

		// IF USING IMAGEBUTTONS
		/*
		 * dialog.setContentView(R.layout.social_push_activity2);
		 * customExitButton2 = (ImageButton)
		 * dialog.findViewById(R.id.customExitButton);
		 * customExitButton2.setVisibility(View.VISIBLE);
		 * customExitButton2.setBackgroundColor(Color.TRANSPARENT);
		 * customExitButton2.setOnClickListener(customExitButtonClick);
		 * 
		 * customStartReadingButton2 = (ImageButton) dialog
		 * .findViewById(R.id.customStartReadingButton);
		 * customExitButton2.setVisibility(View.VISIBLE);
		 * customStartReadingButton2.setBackgroundColor(Color.TRANSPARENT);
		 * customStartReadingButton2
		 * .setOnClickListener(customStartReadingClick);
		 * 
		 * customDiscussButton2 = (ImageButton) dialog
		 * .findViewById(R.id.customDiscussButton);
		 * customExitButton2.setVisibility(View.VISIBLE);
		 * customDiscussButton2.setBackgroundColor(Color.TRANSPARENT);
		 * customDiscussButton2.setOnClickListener(customDiscussClick);
		 */

		return dialog;
	}

	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {

			super.handleMessage(msg);
			dialog.dismiss();
		}

	};

	public void show(String s, int i) {
		Toast.makeText(this, s + "" + i, 10).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tab_host, menu);
		return true;
	}

}
