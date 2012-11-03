package prototype.activities;

import prototype.helper.Helper;
import prototype.start.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class ExtendedStatisticsActivity extends Activity {

	private ImageView backButton;
	private ImageView shareButton;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.statistics_hobbit_layout);

		backButton = (ImageView) findViewById(R.id.statistics_hobbit_back);
		shareButton = (ImageView) findViewById(R.id.statistics_hobbit_share);

		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(ExtendedStatisticsActivity.this,
						"Sharing is caring", 10).show();

			}
		});

		shareButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Helper.goToStatistics(ExtendedStatisticsActivity.this);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tab_host, menu);
		return true;
	}
}
