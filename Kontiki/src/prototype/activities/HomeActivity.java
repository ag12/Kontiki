package prototype.activities;

import prototype.adapter.HomeListAdapter;
import prototype.start.R;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class HomeActivity extends ListActivity {

	private ImageView lastImage;
	private int lastInt;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		ListView homeListView = (ListView) findViewById(android.R.id.list);
		/*
		 * int[] books = new int[] { R.drawable.angels_and_deamons,
		 * R.drawable.hobbit, R.drawable.lotr };
		 */

		int[] books = new int[] { 0, 1, 2 };

		String[] emptySpaces = { "", "", "" };
		ArrayAdapter<String> homeAdapter = new HomeListAdapter(this,
				R.layout.new_row_layout_home, books, emptySpaces);

		homeListView.setAdapter(homeAdapter);

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		ImageView imageView = (ImageView) v.findViewById(R.id.image_icon);
		if (lastImage != null && !lastImage.equals(imageView)) {

			Toast.makeText(this, "Second?", 10).show();
			switch (lastInt) {
			case 0:
				Toast.makeText(this, "1?", 10).show();
				lastImage.setImageResource(R.drawable.angels_and_deamons);
				break;
			case 1:
				Toast.makeText(this, "2?", 10).show();
				lastImage.setImageResource(R.drawable.hobbit);
				break;
			case 2:
				Toast.makeText(this, "3?", 10).show();
				lastImage.setImageResource(R.drawable.lotr);
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
		default:
			break;
		}
		lastImage = imageView;

		/*
		 * if (l.isPressed()) {
		 * 
		 * showView(position, v);
		 * 
		 * } else if (l.isFocused()) {
		 * 
		 * cleanView(position, v); }
		 */

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
		default:
			break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tab_host, menu);
		return true;
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		Intent flipped = new Intent(this, HomeFlippedActivity.class);
		flipped.putExtra("flipped", true);
		startActivity(flipped);
	}
}
