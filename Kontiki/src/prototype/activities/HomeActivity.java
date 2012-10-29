package prototype.activities;

import prototype.adapter.HomeListAdapter;
import prototype.start.R;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HomeActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		ListView homeListView = (ListView) findViewById(R.id.list);
		int[] books = new int[] { R.drawable.angels_and_deamons,
				R.drawable.hobbit, R.drawable.lotr };

		String[] emptySpaces = { "", "", ""};
		ArrayAdapter<String> homeAdapter = new HomeListAdapter(this,
				R.layout.new_row_layout_home, books, emptySpaces);
		
		
		homeListView.setAdapter(homeAdapter);

	}
	/*@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Toast.makeText(
				this,
				"OAS button.." +getListAdapter().getItem(position), 10).show();
	}*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tab_host, menu);
		return true;
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		Intent flipped = new Intent(this, HomeFlippedActivity.class);
		startActivity(flipped);
	}
}
