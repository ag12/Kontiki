package prototype.activities;

import prototype.adapter.HomeListAdapter;
import prototype.helper.Helper;
import prototype.start.R;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class HomeActivity extends ListActivity {

	private ImageView lastImage;
	private int lastInt;
	private ListView homeListView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		homeListView = (ListView) findViewById(android.R.id.list);
		/*
		 * int[] books = new int[] { R.drawable.angels_and_deamons,
		 * R.drawable.hobbit, R.drawable.lotr };
		 */

		int[] books = new int[] { 0, 1, 2, 3, 4 };

		String[] emptySpaces = { "", "", "", "", "" };
		ArrayAdapter<String> homeAdapter = new HomeListAdapter(this,
				R.layout.new_row_layout_home, books, emptySpaces);

		homeListView.setAdapter(homeAdapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		ImageView imageView = (ImageView) v.findViewById(R.id.image_icon);
		if (lastImage != null && !lastImage.equals(imageView)) {

			switch (lastInt) {
			case 0:

				lastImage.setImageResource(R.drawable.angels_and_deamons);
				break;
			case 1:

				lastImage.setImageResource(R.drawable.hobbit);
				break;
			case 2:

				lastImage.setImageResource(R.drawable.lotr);
				break;
			case 3:

				lastImage.setImageResource(R.drawable.lotr2);
				break;
			case 4:
				lastImage.setImageResource(R.drawable.hobbit);
				break;
			default:
				break;
			}
		}

		switch (position) {
		case 0:
			lastInt = 0;
			imageView.setImageResource(R.drawable.angels_and_deamons_pushed);
			break;
		case 1:
			lastInt = 1;
			imageView.setImageResource(R.drawable.hobbit_push);
			break;
		case 2:
			lastInt = 2;
			imageView.setImageResource(R.drawable.lotr_pushed_1);
			break;
		case 3:
			lastInt = 3;
			imageView.setImageResource(R.drawable.lotr2_pushed);
			break;
		case 4:
			lastInt = 4;
			imageView.setImageResource(R.drawable.hobbit_push);
			break;

		default:
			break;
		}
		lastImage = imageView;

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				SharedPreferences myPrefs = HomeActivity.this
						.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
				SharedPreferences.Editor prefsEditor = myPrefs.edit();
				prefsEditor.putInt("curentTab", 0);
				prefsEditor.putInt("lastInt", lastInt);
				prefsEditor.commit();
				new Helper().GoToBookReadingView(HomeActivity.this);

			}
		}, 250);

	}

	public void cleanView(int position, View v) {

		ImageView imageView = (ImageView) v.findViewById(R.id.image_icon);

		switch (position) {
		case 0:
			imageView.setImageResource(R.drawable.angels_and_deamons);
			break;
		case 1:
			imageView.setImageResource(R.drawable.hobbit);
			break;
		case 2:
			imageView.setImageResource(R.drawable.lotr);
			break;
		case 3:
			imageView.setImageResource(R.drawable.lotr);
			break;
		case 4:
			imageView.setImageResource(R.drawable.hobbit);
			break;
		default:
			break;
		}

	}

	public void showView(int position, View v) {
		ImageView imageView = (ImageView) v.findViewById(R.id.image_icon);

		switch (position) {
		case 0:
			imageView.setImageResource(R.drawable.angels_and_deamons_pushed);
			break;
		case 1:
			imageView.setImageResource(R.drawable.hobbit_push);
			break;
		case 2:
			imageView.setImageResource(R.drawable.lotr_pushed_1);
			break;
		case 3:
			imageView.setImageResource(R.drawable.lotr_pushed_1);
			break;
		case 4:
			imageView.setImageResource(R.drawable.hobbit_push);
			break;
		default:
			break;
		}

	}

	@Override
	public ListAdapter getListAdapter() {
		// TODO Auto-generated method stub
		return super.getListAdapter();
	}

	@Override
	public ListView getListView() {
		// TODO Auto-generated method stub
		return super.getListView();
	}

	@Override
	public long getSelectedItemId() {
		// TODO Auto-generated method stub
		return super.getSelectedItemId();
	}

	@Override
	public int getSelectedItemPosition() {
		// TODO Auto-generated method stub
		return super.getSelectedItemPosition();
	}

	@Override
	public void onContentChanged() {
		// TODO Auto-generated method stub
		super.onContentChanged();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	protected void onRestoreInstanceState(Bundle state) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(state);
	}

	@Override
	public void setListAdapter(ListAdapter adapter) {
		// TODO Auto-generated method stub
		super.setListAdapter(adapter);
	}

	@Override
	public void setSelection(int position) {
		// TODO Auto-generated method stub
		super.setSelection(position);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tab_host, menu);
		return true;
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);

//		Intent flipped = new Intent(this, HomeFlippedActivity.class);
//		flipped.putExtra("flipped", true);
//		startActivity(flipped);

	}
}
