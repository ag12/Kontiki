package prototype.activities;

import prototype.adapter.HomeListAdapter;
import prototype.start.R;
import android.app.Dialog;
import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class StatisticActivity_Rev2 extends ListActivity {

	final private int PUSH_LIST_ELEMENT = 1;
	private Dialog dialog;
	private int lastInt;
	private ImageView lastImage, closeImageView;
	private ListView statisticListView;
	private ScrollView scrollView;
	private RelativeLayout relativeLayout;
	private boolean booksTabIsPushed, totalTabIsPushed = false;
	private ImageView booksImageView, totalImageView;
	private OnClickListener booksImageViewClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			if (!booksTabIsPushed) {

				booksImageView.setImageResource(R.drawable.books_pushed);
				totalImageView.setImageResource(R.drawable.total);
				booksTabIsPushed = true;
				totalTabIsPushed = false;
				SwapToBooks();
				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {

					}
				}, 250);

			}

		}
	};
	private OnClickListener totalImageViewClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			if (!totalTabIsPushed) {

				totalImageView.setImageResource(R.drawable.total_pushed);
				booksImageView.setImageResource(R.drawable.books);
				totalTabIsPushed = true;
				booksTabIsPushed = false;
				SwapToTotal();
				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {

					}
				}, 250);

			}
		}
	};
	private OnClickListener closeImageViewClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			handler.sendEmptyMessage(0);

		}
	};

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_statistic_rev2);
		scrollView = (ScrollView) findViewById(R.id.mainScroll);
		relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayoutStat);

		booksImageView = (ImageView) findViewById(R.id.books_imageView);
		booksImageView.setOnClickListener(booksImageViewClick);

		totalImageView = (ImageView) findViewById(R.id.total_imageView);
		totalImageView.setOnClickListener(totalImageViewClick);
		totalTabIsPushed = true;

		FixAdapter();
	}

	private void FixAdapter() {

		statisticListView = (ListView) findViewById(android.R.id.list);
		int[] books = new int[] { 0, 1, 2, 3, 4 };

		String[] emptySpaces = { "", "", "", "", "" };
		ArrayAdapter<String> homeAdapter = new HomeListAdapter(this,
				R.layout.new_row_layout_home, books, emptySpaces);

		statisticListView.setAdapter(homeAdapter);
	}

	private void SwapToBooks() {
		scrollView.setVisibility(View.GONE);
		relativeLayout.setVisibility(View.VISIBLE);
	}

	private void SwapToTotal() {
		scrollView.setVisibility(View.VISIBLE);
		relativeLayout.setVisibility(View.GONE);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		ImageView imageView = (ImageView) v.findViewById(R.id.image_icon);
		if (lastImage != null && !lastImage.equals(imageView)) {

			switch (lastInt) {
			case 0:

				lastImage.setImageResource(R.drawable.angels_and_deamons);
				break;
			case 1:

				lastImage.setImageResource(R.drawable.hobbit);
				break;
			case 2:

				lastImage.setImageResource(R.drawable.lotr);
				break;
			case 3:

				lastImage.setImageResource(R.drawable.lotr2);
				break;
			case 4:
				lastImage.setImageResource(R.drawable.hobbit);
				break;
			default:
				break;
			}
		}

		switch (position) {
		case 0:
			lastInt = 0;
			imageView.setImageResource(R.drawable.angels_and_deamons_pushed);
			break;
		case 1:
			lastInt = 1;
			imageView.setImageResource(R.drawable.hobbit_push);
			break;
		case 2:
			lastInt = 2;
			imageView.setImageResource(R.drawable.lotr_pushed_1);
			break;
		case 3:
			lastInt = 3;
			imageView.setImageResource(R.drawable.lotr2_pushed);
			break;
		case 4:
			lastInt = 4;
			imageView.setImageResource(R.drawable.hobbit_push);
			break;

		default:
			break;
		}
		lastImage = imageView;

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {

				showDialog(PUSH_LIST_ELEMENT);

			}
		}, 250);

	}

	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {

		dialog = new Dialog(this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.staistic_popup_activity_window_rev2);
		closeImageView = (ImageView) dialog
				.findViewById(R.id.statistic_popup_close_imageView);
		closeImageView.setOnClickListener(closeImageViewClick);

		return dialog;
	}

	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {

			super.handleMessage(msg);
			dialog.dismiss();
			switch (lastInt) {
			case 0:

				lastImage.setImageResource(R.drawable.angels_and_deamons);
				break;
			case 1:

				lastImage.setImageResource(R.drawable.hobbit);
				break;
			case 2:

				lastImage.setImageResource(R.drawable.lotr);
				break;
			case 3:

				lastImage.setImageResource(R.drawable.lotr2);
				break;
			case 4:
				lastImage.setImageResource(R.drawable.hobbit);
				break;
			default:
				break;
			}
		}

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tab_host, menu);
		return true;
	}

}
