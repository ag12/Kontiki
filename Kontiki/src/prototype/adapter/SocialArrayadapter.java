package prototype.adapter;

import prototype.start.R;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class SocialArrayadapter extends ArrayAdapter<String> {

	private final Context context;
	private final int[] images;
	private final int layout;

	public SocialArrayadapter(Context context, int layout, int[] images,
			String[] values) {
		super(context, layout, values);
		this.context = context;
		this.images = images;
		this.layout = layout;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(this.layout, parent, false);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

		switch (images[position]) {
		case 1:
			imageView.setImageResource(R.drawable.person1);	
			break;
		case 2:
			imageView.setImageResource(R.drawable.person2);	
			break;
		case 3:
			imageView.setImageResource(R.drawable.person3);
			break;
		case 4:
			imageView.setImageResource(R.drawable.person4);
			break;
		case 5:
			imageView.setImageResource(R.drawable.person5);
			break;	
		case 6:
			imageView.setImageResource(R.drawable.person1);
			break;
		case 7:
			imageView.setImageResource(R.drawable.person2);
			break;
		case 8:
			imageView.setImageResource(R.drawable.person3);
			break;
		default:
		}

		return rowView;
	}
}
