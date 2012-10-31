package prototype.activities;

import prototype.start.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class ReadingActivity extends Activity {

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

			Toast.makeText(ReadingActivity.this, "Bookmark Push", 10).show();

		}
	};
	private OnClickListener finishBookImageClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Toast.makeText(ReadingActivity.this, "Finish book Push", 10).show();
			
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reading_new);

		topBarImage = (ImageView) findViewById(R.id.topBarImage);
		bookMarkImage = (ImageView) findViewById(R.id.bookMarkImage);

		finishBookImage = (ImageView)findViewById(R.id.finishBookImage);
		
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
