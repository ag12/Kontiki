package prototype.helper;

import android.app.Activity;
import android.app.TabActivity;
import android.view.View;

public class Helper {

	public static void GoToBookReadingView(Activity activity) {

		TabActivity tabActivity = (TabActivity) activity.getParent();
		HideTabs(tabActivity);
		tabActivity.getTabHost().setCurrentTab(4);

	}
	public static void GoToStoreView(Activity activity) {

		TabActivity tabActivity = (TabActivity) activity.getParent();
		tabActivity.getTabHost().setCurrentTab(1);

	}

	public static void ShowMainActivityAndSetCurrentTab(Activity activity,
			int currentTab) {

		TabActivity tabActivity = (TabActivity) activity.getParent();
		ShowTabs(tabActivity);
		tabActivity.getTabWidget().getChildAt(4).setVisibility(View.GONE);
		tabActivity.getTabHost().setCurrentTab(currentTab);

	}

	public static void goToExtendedStatistics(Activity activity) {
		TabActivity tabActivity = (TabActivity) activity.getParent();
		tabActivity.getTabHost().setCurrentTab(5);
	}

	public static void goToHome(Activity activity) {
		TabActivity tabActivity = (TabActivity) activity.getParent();
		ShowTabs(tabActivity);
		tabActivity.getTabHost().setCurrentTab(0);
	}

	public static void goToStatistics(Activity activity) {
		TabActivity tabActivity = (TabActivity) activity.getParent();
		tabActivity.getTabHost().setCurrentTab(3);
	}

	public static void GoToFinishReadingActivity(Activity activity) {

		TabActivity tabActivity = (TabActivity) activity.getParent();
		HideTabs(tabActivity);
		tabActivity.getTabHost().setCurrentTab(6);
	}

	private static void HideTabs(TabActivity tabActivity) {
		tabActivity.getTabWidget().getChildAt(0).setVisibility(View.GONE);
		tabActivity.getTabWidget().getChildAt(1).setVisibility(View.GONE);
		tabActivity.getTabWidget().getChildAt(2).setVisibility(View.GONE);
		tabActivity.getTabWidget().getChildAt(3).setVisibility(View.GONE);
	}

	private static void ShowTabs(TabActivity tabActivity) {
		tabActivity.getTabWidget().getChildAt(0).setVisibility(View.VISIBLE);
		tabActivity.getTabWidget().getChildAt(1).setVisibility(View.VISIBLE);
		tabActivity.getTabWidget().getChildAt(2).setVisibility(View.VISIBLE);
		tabActivity.getTabWidget().getChildAt(3).setVisibility(View.VISIBLE);
	}

}
