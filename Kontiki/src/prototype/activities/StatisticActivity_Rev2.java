package prototype.activities;

import prototype.start.R;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;

public class StatisticActivity_Rev2 extends ListActivity {

	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_social_rev2);
	    }

	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        getMenuInflater().inflate(R.menu.activity_tab_host, menu);
	        return true;
	    }
}
