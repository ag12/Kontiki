package prototype.activities;

import prototype.start.R;
import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class ReadingActivity extends Activity {

	private boolean bookMarkPushed, finishBookPushed;
	private ImageView topBarImage, bookMarkImage, finishBookImage;
	private OnClickListener topBarImageClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			Toast.makeText(ReadingActivity.this, "TopBar Push", 10).show();

		}
	};

	private OnClickListener bookMarkImageClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			if (bookMarkPushed) {
				bookMarkImage.setImageResource(R.drawable.bookmark);
				bookMarkPushed = false;

			} else if (!bookMarkPushed) {
				bookMarkImage.setImageResource(R.drawable.bookmark_pushed);
				bookMarkPushed = true;

			}

			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					goBackToHome();

				}
			}, 250);

		}
	};
	private OnClickListener finishBookImageClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			if (finishBookPushed) {
				finishBookImage.setImageResource(R.drawable.finish_book);
				finishBookPushed = false;
			} else if (!finishBookPushed) {
				finishBookImage.setImageResource(R.drawable.finish_book_pushed);
				finishBookPushed = true;
			}

			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					didFinishBook();

				}
			}, 250);

		}
	};

	public void didFinishBook() {

	}

	public void goBackToHome() {

		TabActivity tabActivity = (TabActivity) ReadingActivity.this
				.getParent();
		tabActivity.getTabHost().setCurrentTab(0);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reading_new);

		bookMarkPushed = false;
		finishBookPushed = false;
		topBarImage = (ImageView) findViewById(R.id.topBarImage);
		bookMarkImage = (ImageView) findViewById(R.id.bookMarkImage);

		finishBookImage = (ImageView) findViewById(R.id.finishBookImage);

		topBarImage.setOnClickListener(topBarImageClick);
		bookMarkImage.setOnClickListener(bookMarkImageClick);
		finishBookImage.setOnClickListener(finishBookImageClick);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tab_host, menu);
		return true;
	}

}
