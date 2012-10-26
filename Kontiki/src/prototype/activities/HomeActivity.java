package prototype.activities;

import prototype.adapter.HomeListAdapter;
import prototype.adapter.KontikiArrayadapter;
import prototype.start.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		ListView homeListView = (ListView) findViewById(R.id.list);
		int[] books = new int[] { R.drawable.angels_and_deamons_button,
				R.drawable.hobbit,
				R.drawable.lotr_1,
				R.drawable.lotr_1,
				R.drawable.lotr_1,
				R.drawable.lotr_1};
		String[] emptySpaces = {"","","","","",""};
		ArrayAdapter<String> homeAdapter = new HomeListAdapter(this,
				R.layout.row_layout_home, books,emptySpaces);
		homeListView.setAdapter(homeAdapter);
		homeListView.setDivider(null);
		homeListView.setDividerHeight(0);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tab_host, menu);
		return true;
	}
	
	 @Override
	    public void onConfigurationChanged(Configuration  newConfig) {
	      super.onConfigurationChanged(newConfig);
	      Intent flipped = new Intent(this, HomeFlippedActivity.class);
	      startActivity(flipped);
	 }
}
