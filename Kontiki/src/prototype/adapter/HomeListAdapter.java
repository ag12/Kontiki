package prototype.adapter;

import prototype.start.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeListAdapter extends ArrayAdapter<String> {

	private final Context context;
	private final int[] images;
	private final int layout;

	public HomeListAdapter(Context context, int layout, int[] images,
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
		ImageView imageView = (ImageView) rowView.findViewById(R.id.image_icon);
		/*int[] books = new int[] { R.drawable.angels_and_deamons,
		R.drawable.hobbit, R.drawable.lotr };*/
		switch (images[position]) {
		case 0:
			imageView.setImageResource(R.drawable.angels_and_deamons);
			break;
		case 1:
			imageView.setImageResource(R.drawable.hobbit);
			break;
		case 2:
			imageView.setImageResource(R.drawable.lotr);
			break;
		default:
			break;
		}
	

		return rowView;
	}
}
