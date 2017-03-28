/*
//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.domain.Movie;

public class MovieListAdapter extends ArrayAdapter<Movie> {


	public MovieListAdapter(@NonNull Context context, @NonNull List<Movie> movies) {
		super(context, 0, movies);
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		Movie movie = (Movie) getItem(position);

		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);
		}

		ImageView thumbnail = (ImageView) convertView.findViewById(R.id.productThumbnail);
		Picasso.with(getContext())
				.load(product.getSmallImageUrl())
				.placeholder(R.drawable.imagenotfound)
				.error(R.drawable.imagenotfound)
				.fit()
				.into(thumbnail);

		TextView title = (TextView) convertView.findViewById(R.id.productTitel);
		if (product.getTitle() != null) {
			title.setText(product.getTitle());
		} else {
			title.setText("");
		}


		TextView specs = (TextView) convertView.findViewById(R.id.productSpecsTag);
		specs.setText(product.getSpecsTag());

		TextView summary = (TextView) convertView.findViewById(R.id.productSummary);
		summary.setText(product.getSummary());

		return convertView;
	}
}
*/
