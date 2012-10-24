package prototype.activities;

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
		String[] books = new String[] { "The Lord of the Rings",
				"Harry Potter and the Goblet of Fire",
				"The Leonardo da Vinci Code", "Teenage Mutant Ninja Turtles",
				"The Hitchhiker's Guide to the Galaxy",
				"The Restaurant at the End of the Galaxy",
				"So Long, and Thanks for the Fish",
				"Life, the Universe and Everything", "Mostly Harmless",
				"And Another Thing" };
		ArrayAdapter<String> homeAdapter = new KontikiArrayadapter(this, books,
				R.layout.row_layout_home, R.drawable.open_book_big);
		homeListView.setAdapter(homeAdapter);

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
