package prototype.helper;

import prototype.activities.HomeActivity;
import prototype.activities.ReadingActivity;
import android.app.Activity;
import android.app.TabActivity;
import android.view.View;

public class Helper {

	public static void GoToBookReadingView(Activity activity) {

		TabActivity tabActivity = (TabActivity) activity.getParent();
		tabActivity.getTabWidget().getChildAt(0).setVisibility(View.GONE);
		tabActivity.getTabWidget().getChildAt(1).setVisibility(View.GONE);
		tabActivity.getTabWidget().getChildAt(2).setVisibility(View.GONE);
		tabActivity.getTabWidget().getChildAt(3).setVisibility(View.GONE);
		tabActivity.getTabHost().setCurrentTab(4);

	}
	public static void ShowMainActivityAndSetCurrentTab(Activity activity, int currentTap) {

		TabActivity tabActivity = (TabActivity) activity
				.getParent();
		tabActivity.getTabWidget().getChildAt(0).setVisibility(View.VISIBLE);
		tabActivity.getTabWidget().getChildAt(1).setVisibility(View.VISIBLE);
		tabActivity.getTabWidget().getChildAt(2).setVisibility(View.VISIBLE);
		tabActivity.getTabWidget().getChildAt(3).setVisibility(View.VISIBLE);
		tabActivity.getTabWidget().getChildAt(4).setVisibility(View.GONE);
		tabActivity.getTabHost().setCurrentTab(currentTap);

	}

}
