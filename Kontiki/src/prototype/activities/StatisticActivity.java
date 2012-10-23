package prototype.activities;



import prototype.start.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class StatisticActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_tab_host, menu);
        return true;
    }
}
