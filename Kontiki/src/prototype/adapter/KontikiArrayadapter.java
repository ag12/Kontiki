package prototype.adapter;

import prototype.start.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class KontikiArrayadapter extends ArrayAdapter<String> {

	private final Context context;
	private final String[] values;
	private final int image;
	private final int layout;

	public KontikiArrayadapter(Context context, String[] values, int layout,
			int image) {
		super(context, layout, values);
		this.context = context;
		this.values = values;
		this.image = image;
		this.layout = layout;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(layout, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		textView.setText(values[position]);
		imageView.setImageResource(image);

		return rowView;
	}
}
