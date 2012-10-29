package prototype.activities;

import prototype.adapter.KontikiArrayadapter;
import prototype.start.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SocialActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_social);
		ListView socialListView = (ListView) findViewById(R.id.list2);
		String[] feeds = new String[] { "The Lord of the Rings",
				"Harry Potter and the Goblet of Fire",
				"The Leonardo da Vinci Code", "Teenage Mutant Ninja Turtles",
				"The Hitchhiker's Guide to the Galaxy",
				"The Restaurant at the End of the Galaxy",
				"So Long, and Thanks for the Fish",
				"Life, the Universe and Everything", "Mostly Harmless",
				"And Another Thing" };
		ArrayAdapter<String> socialAdapter = new KontikiArrayadapter(this,
				feeds, R.layout.row_layout_social, R.drawable.human);
		socialListView.setAdapter(socialAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tab_host, menu);
		return true;
	}

}
