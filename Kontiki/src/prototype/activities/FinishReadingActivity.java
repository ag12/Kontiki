package prototype.activities;

import prototype.helper.Helper;
import prototype.start.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class FinishReadingActivity extends Activity {

	private ImageView likeImageButton, dislikeImageButton, skipImageButton,
			submitImageButton;
	private boolean isChosen;
	private OnClickListener likeImageButtonClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			DidLiked();

		}
	};
	private OnClickListener dislikeImageButtonClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			DidDisliked();

		}
	};
	private OnClickListener skipImageButtonClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			DidSkip();
		}
	};
	private OnClickListener submitImageButtonClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			submitImageButton.setImageResource(R.drawable.submit_pushed);
			if (!isChosen) {

				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {

						Toast.makeText(
								FinishReadingActivity.this,
								"You must choose one of \nthe options above to continue.",
								15).show();
						submitImageButton.setImageResource(R.drawable.submit);

					}
				}, 250);

				return;
			}

			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {

					DidSubmit();

				}
			}, 250);

		}
	};

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_reading_finish_book);

		
		likeImageButton = (ImageView) findViewById(R.id.likeImageButton);
		likeImageButton.setOnClickListener(likeImageButtonClick);

		dislikeImageButton = (ImageView) findViewById(R.id.dislikeImageButton);
		dislikeImageButton.setOnClickListener(dislikeImageButtonClick);

		skipImageButton = (ImageView) findViewById(R.id.skipImageButton);
		skipImageButton.setOnClickListener(skipImageButtonClick);

		submitImageButton = (ImageView) findViewById(R.id.submitImageButton);
		submitImageButton.setOnClickListener(submitImageButtonClick);
		isChosen = false;

	}

	private void DidSubmit() {

		Helper.goToHome(this);
	}

	private void DidLiked() {

		likeImageButton.setImageResource(R.drawable.like_pushed);
		dislikeImageButton.setImageResource(R.drawable.dislike);
		skipImageButton.setImageResource(R.drawable.skip);
		isChosen = true;

	}

	private void DidDisliked() {

		dislikeImageButton.setImageResource(R.drawable.dislike_pushed);
		likeImageButton.setImageResource(R.drawable.like);
		skipImageButton.setImageResource(R.drawable.skip);
		isChosen = true;
	}

	private void DidSkip() {

		skipImageButton.setImageResource(R.drawable.skip_pushed);
		likeImageButton.setImageResource(R.drawable.like);
		dislikeImageButton.setImageResource(R.drawable.dislike);
		isChosen = true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tab_host, menu);
		return true;
	}
}
