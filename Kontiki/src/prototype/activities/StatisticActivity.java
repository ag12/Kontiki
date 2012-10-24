package prototype.activities;



import prototype.adapter.KontikiArrayadapter;
import prototype.start.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StatisticActivity extends Activity {

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_tab_host, menu);
        return true;
    }
}
