package prototype.activities;

import prototype.adapter.SocialArrayadapter_Rev2;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class SocialActivity_Rev2 extends ListActivity {

	private int id = 0;
	private Button customExitButton, customStartReadingButton,
			customDiscussButton;
	final private int PUSH_LIST_ELEMENT = 1;
	private Dialog dialog;
	private SocialArrayadapter_Rev2 arrayadapter;
	private ListView socialListView;
	private boolean activityTabIsPushed, discussTabIsPushed = false;
	private ImageView activityImageView, discussionImageView,
			subMenuLefImageView, subMenuAddFriendImageView;
	private OnClickListener activityImageViewClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			if (!activityTabIsPushed) {

				activityImageView
						.setImageResource(R.drawable.activity_feed_pushed);
				discussionImageView
						.setImageResource(R.drawable.discussion_board);
				activityTabIsPushed = true;
				SetAdapter();
				SwapToActivity();
				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {

					}
				}, 250);

				discussTabIsPushed = false;
				return;
			}

		}
	};
	private OnClickListener discussionImageViewClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			if (!discussTabIsPushed) {

				activityImageView.setImageResource(R.drawable.activity_feed);
				discussionImageView
						.setImageResource(R.drawable.discussion_board_pushed);
				discussTabIsPushed = true;
				CleanAdapter();
				SwapToDiscuss();
				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub

					}
				}, 250);

				activityTabIsPushed = false;
				return;
			}
		}
	};
	private OnClickListener subMenuLefImageViewClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			int id_push = 0;

			if (activityTabIsPushed) {
				id = R.drawable.sub_menu_add_favorites;
				id_push = R.drawable.sub_menu_add_favorites_pushed;
			} else if (discussTabIsPushed) {
				id = R.drawable.sub_menu_add_mybooks;
				id_push = R.drawable.sub_menu_add_mybooks_pushed;
			}
			subMenuLefImageView.setImageResource(id_push);
			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub

					subMenuLefImageView.setImageResource(id);
				}
			}, 350);

			/*
			 * else if (leftMenuIsPushed) { subMenuLefImageView
			 * .setImageResource(R.drawable.sub_menu_add_favorites);
			 * leftMenuIsPushed = false;
			 * 
			 * new Handler().postDelayed(new Runnable() {
			 * 
			 * @Override public void run() { // TODO Auto-generated method stub
			 * 
			 * } }, 250); return; }
			 */
		}
	};
	private OnClickListener subMenuAddFriendImageViewClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			subMenuAddFriendImageView
					.setImageResource(R.drawable.sub_menu_add_friend_pushed);

			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub

					subMenuAddFriendImageView
							.setImageResource(R.drawable.sub_menu_add_friend);

				}
			}, 350);

			/*
			 * else if (addFeriendIsPushed) { subMenuAddFriendImageView
			 * .setImageResource(R.drawable.sub_menu_add_friend);
			 * addFeriendIsPushed = false;
			 * 
			 * new Handler().postDelayed(new Runnable() {
			 * 
			 * @Override public void run() { // TODO Auto-generated method stub
			 * 
			 * } }, 250); return; }
			 */

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

			SharedPreferences myPrefs = SocialActivity_Rev2.this
					.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
			SharedPreferences.Editor prefsEditor = myPrefs.edit();
			prefsEditor.putInt("curentTab", 2);
			prefsEditor.commit();
			Helper.GoToBookReadingView(SocialActivity_Rev2.this);

			// }
			// }, 250);

		}
	};
	private OnClickListener customDiscussClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Toast.makeText(SocialActivity_Rev2.this, "discuss?", 10).show();

		}
	};

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_social_rev2);

		socialListView = (ListView) findViewById(android.R.id.list);
		SetAdapter();

		activityImageView = (ImageView) findViewById(R.id.activity_feed_imageView);
		activityImageView.setOnClickListener(activityImageViewClick);

		discussionImageView = (ImageView) findViewById(R.id.discussion_board_imageView);
		discussionImageView.setOnClickListener(discussionImageViewClick);

		subMenuLefImageView = (ImageView) findViewById(R.id.sub_menu_left_imageView);
		subMenuLefImageView.setOnClickListener(subMenuLefImageViewClick);

		subMenuAddFriendImageView = (ImageView) findViewById(R.id.sub_menu_add_feriend);
		subMenuAddFriendImageView
				.setOnClickListener(subMenuAddFriendImageViewClick);
		activityTabIsPushed = true;

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
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tab_host, menu);
		return true;
	}

	private void SwapToDiscuss() {

		subMenuLefImageView.setImageResource(R.drawable.sub_menu_add_mybooks);
	}

	private void SwapToActivity() {
		
		subMenuLefImageView.setImageResource(R.drawable.sub_menu_add_favorites);
	}

	private void CleanAdapter() {

		int[] people = new int[] { 3, 1 };
		String[] emptySpaces = { "", "" };
		arrayadapter = new SocialArrayadapter_Rev2(this,
				R.layout.row_layout_social, people, emptySpaces);

		socialListView.setAdapter(arrayadapter);
	}

	private void SetAdapter() {
		int[] people = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		String[] emptySpaces = { "", "", "", "", "", "", "", "" };
		arrayadapter = new SocialArrayadapter_Rev2(this,
				R.layout.row_layout_social, people, emptySpaces);

		socialListView.setAdapter(arrayadapter);
	}
}
