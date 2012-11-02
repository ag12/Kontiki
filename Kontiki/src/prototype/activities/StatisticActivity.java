package prototype.activities;

import prototype.adapter.KontikiArrayadapter;
import prototype.helper.Helper;
import prototype.start.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class StatisticActivity extends Activity {

	private Button overAllStatisticButton;
	private OnClickListener oasButtonListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Helper.goToHobbitStatistics(StatisticActivity.this);
		}
	};

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_statistic);

		ListView statisticsListView = (ListView) findViewById(R.id.statistics_list);
		String[] books = new String[] { "The Lord of the Rings",
				"Harry Potter and the Goblet of Fire",
				"The Leonardo da Vinci Code", "Teenage Mutant Ninja Turtles",
				"The Hitchhiker's Guide to the Galaxy",
				"The Restaurant at the End of the Galaxy",
				"So Long, and Thanks for the Fish",
				"Life, the Universe and Everything", "Mostly Harmless",
				"And Another Thing" };
		ArrayAdapter<String> statisticsAdapter = new KontikiArrayadapter(this,
				books, R.layout.row_layout_statistics, R.drawable.human);
		statisticsListView.setAdapter(statisticsAdapter);

		overAllStatisticButton = (Button) findViewById(R.id.button_statistics);
		overAllStatisticButton.setOnClickListener(oasButtonListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tab_host, menu);
		return true;
	}
}
