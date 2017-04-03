//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import informatica.groep1.bioscoopapp.R;

public class HistoryImageAdapter extends BaseAdapter {
	
	//================================================================================
	// Properties
	//================================================================================
	
	private Context context;
	
	//================================================================================
	// Constructors
	//================================================================================
	
	public HistoryImageAdapter(Context context) {
		this.context = context;
	}
	
	//================================================================================
	// Accessors
	//================================================================================
	
	public int getCount() {
		return 12; //TODO Change count
	}
	
	public Object getItem(int position) {
		return null;
	}
	
	public long getItemId(int position) {
		return 0;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		
		if (convertView == null) {
			imageView = new ImageView(context);
			imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		} else {
			imageView = (ImageView) convertView;
		}
		
		imageView.setImageResource(thumbs[position]);
		return imageView;
	}
	
	//Temp test
	private Integer[] thumbs = {
			R.drawable.testposter, R.drawable.testposter,
			R.drawable.testposter, R.drawable.testposter,
			R.drawable.testposter, R.drawable.testposter,
			R.drawable.testposter, R.drawable.testposter,
			R.drawable.testposter, R.drawable.testposter,
			R.drawable.testposter, R.drawable.testposter,
	};
}
