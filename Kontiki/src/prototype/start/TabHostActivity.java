package prototype.start;

import prototype.activities.BookStoreActivity;
import prototype.activities.HomeActivity;
import prototype.activities.SocialActivity;
import prototype.activities.StatisticActivity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class TabHostActivity extends TabActivity {

	private TabHost tabHost;
	private Intent intent;
	private Resources res;
	private TabHost.TabSpec spec;

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_host);

		res = getResources();
		tabHost = getTabHost();

		intent = new Intent().setClass(this, HomeActivity.class);

		spec = tabHost.newTabSpec("main")
				.setIndicator("", res.getDrawable(R.drawable.home))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, BookStoreActivity.class);
		spec = tabHost.newTabSpec("peoples")
				.setIndicator("", res.getDrawable(R.drawable.home))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, StatisticActivity.class);
		spec = tabHost.newTabSpec("everbody")
				.setIndicator("", res.getDrawable(R.drawable.home))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, SocialActivity.class);
		spec = tabHost.newTabSpec("everbody")
				.setIndicator("", res.getDrawable(R.drawable.home))
				.setContent(intent);
		tabHost.addTab(spec);

		// tabHost.getTabWidget().getChildAt(3).setVisibility(View.GONE);

		tabHost.setCurrentTab(tabHost.getCurrentTab());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tab_host, menu);
		return true;
	}
}
