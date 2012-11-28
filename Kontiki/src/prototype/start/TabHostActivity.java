package prototype.start;

import prototype.activities.BookStoreActivity;
import prototype.activities.ExtendedStatisticsActivity;
import prototype.activities.FinishReadingActivity;
import prototype.activities.HomeActivity;
import prototype.activities.ReadingActivity;
import prototype.activities.SocialActivity_Rev2;
import prototype.activities.StatisticActivity_Rev2;
import prototype.helper.Helper;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class TabHostActivity extends TabActivity {

	private TabHost tabHost;
	private Intent intent;
	private Resources res;
	private TabHost.TabSpec spec;
	private int currentC;
	private View currentV;

	private OnTabChangeListener tabHostClick = new OnTabChangeListener() {

		@Override
		public void onTabChanged(String tabId) {

			View currentView = tabHost.getCurrentView();
			int c = tabHost.getCurrentTab();

			if ( tabId.equals("h") && (c-currentC==0)){
				Log.d("HHHHHHHHHHHHHHHHHHHHHHHHHH",  c + " C:" + currentC);
				return;
			}
			
			
			else	if (((currentC - c) == 4) /*|| ((currentC - c) == 6)*/) {

			
				/*tabHost.setCurrentTab(0);
				Helper.PlayAnim(currentV, getBaseContext(),
						R.anim.slide_out_down, 200);
				
			   Helper.PlayAnim(currentView, getBaseContext(),
						R.anim.slide_in_down, 200);*/
			}

			else if (c > currentC && c != 4) {

				Helper.PlayAnim(currentV, getBaseContext(),
						R.anim.slide_out_left, 200);
				Helper.PlayAnim(currentView, getBaseContext(),
						R.anim.slide_in_right, 200);
				Log.d("c > currentC && c != 4", "c: " + c + " C:" + currentC);

			} else if (c < currentC && c != 4) {

				Helper.PlayAnim(currentV, getBaseContext(),
						R.anim.slide_out_right, 200);
				Helper.PlayAnim(currentView, getBaseContext(),
						R.anim.slide_in_left, 200);
				Log.d("c < currentC && c != 4", "c: " + c + ", C" + currentC);

			} else if (c == 4) {

				/*tabHost.setCurrentTab(4);
				Helper.PlayAnim(currentV, getBaseContext(),
						R.anim.slide_out_to_up, 200);
				Helper.PlayAnim(currentView, getBaseContext(),
						R.anim.slide_in_form_down, 200);
				Log.d("C==4", "10" + "c: " + c + " C:" + currentC);*/

			} else if (c == currentC) {
				Log.d("c==C", "10" + "c: " + c + " C:" + currentC);
			}
			currentC = c;
			currentV = currentView;
		

		}
	};

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_host);

		res = getResources();
		tabHost = getTabHost();
		tabHost.setOnTabChangedListener(tabHostClick);

		intent = new Intent().setClass(this, HomeActivity.class);

		spec = tabHost.newTabSpec("h")
				.setIndicator("", res.getDrawable(R.drawable.icon_home_press))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, BookStoreActivity.class);
		spec = tabHost.newTabSpec("")
				.setIndicator("", res.getDrawable(R.drawable.icon_store_press))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent()

		// .setClass(this, SocialActivity.class);
				.setClass(this, SocialActivity_Rev2.class);

		spec = tabHost
				.newTabSpec("")
				.setIndicator("", res.getDrawable(R.drawable.icon_social_press))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent()

		// .setClass(this, StatisticActivity.class);
				.setClass(this, StatisticActivity_Rev2.class);

		spec = tabHost
				.newTabSpec("")
				.setIndicator("",
						res.getDrawable(R.drawable.icon_statistics_press))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, ReadingActivity.class);
		spec = tabHost
				.newTabSpec("")
				.setIndicator("",
						res.getDrawable(R.drawable.icon_statistics_press))
				.setContent(intent);
		tabHost.addTab(spec);

		tabHost.getTabWidget().getChildAt(4).setVisibility(View.GONE);

		intent = new Intent().setClass(this, ExtendedStatisticsActivity.class);
		spec = tabHost
				.newTabSpec("")
				.setIndicator("",
						res.getDrawable(R.drawable.icon_statistics_press))
				.setContent(intent);

		tabHost.addTab(spec);

		tabHost.getTabWidget().getChildAt(5).setVisibility(View.GONE);

		intent = new Intent().setClass(this, FinishReadingActivity.class);
		spec = tabHost
				.newTabSpec("")
				.setIndicator("",
						res.getDrawable(R.drawable.icon_statistics_press))
				.setContent(intent);
		tabHost.addTab(spec);

		tabHost.getTabWidget().getChildAt(6).setVisibility(View.GONE);

		for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
			tabHost.getTabWidget().getChildAt(i)
					.setBackgroundColor(Color.parseColor("#3BB9FF")); // unselected287EAC
																		// 329BD4
			// .setBackgroundResource(R.drawable.gradient2);
		}

		tabHost.setCurrentTab(tabHost.getCurrentTab());
		currentC = 0;
		currentV = tabHost.getCurrentView();

	}

	public Animation InFromRightAnimation() {

		Animation inFromRight = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, +1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		inFromRight.setDuration(10);
		inFromRight.setInterpolator(new AccelerateInterpolator());
		return inFromRight;
	}

	public Animation UutToLeftAnimation() {
		Animation outtoLeft = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, -1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoLeft.setDuration(10);
		outtoLeft.setInterpolator(new AccelerateInterpolator());
		return outtoLeft;
	}

	public Animation PlayAnim(View v, Context Con, int animationid,
			int StartOffset) {
		if (v != null) {
			Animation animation = AnimationUtils
					.loadAnimation(Con, animationid);
			animation.setStartOffset(StartOffset);
			v.startAnimation(animation);

			return animation;
		}
		return null;
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tab_host, menu);
		return true;
	}
	
}
