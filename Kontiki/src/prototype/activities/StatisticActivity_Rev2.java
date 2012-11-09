package prototype.activities;

import prototype.adapter.HomeListAdapter;
import prototype.start.R;
import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class StatisticActivity_Rev2 extends ListActivity {

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
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tab_host, menu);
		return true;
	}
}
