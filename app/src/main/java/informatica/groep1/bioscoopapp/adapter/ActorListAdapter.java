package informatica.groep1.bioscoopapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.domain.Actor;

/**
 * Created by Sven Westerlaken on 31-3-2017.
 */

public class ActorListAdapter extends BaseAdapter{
    private ArrayList<Actor> actors;
    private LayoutInflater inflater;
    private Context context;



    public ActorListAdapter(Context context, LayoutInflater inflater, ArrayList<Actor> actors) {
        this.actors = actors;
        this.inflater = inflater;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (actors != null) {
            return actors.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return actors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_movie_actor_list, null);

            viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) convertView.findViewById(R.id.detailedMovieActivity_IV_ActorImage);
            viewHolder.name = (TextView) convertView.findViewById(R.id.detailedMovieActivity_TV_actorName);
            viewHolder.role = (TextView) convertView.findViewById(R.id.detailedMovieActivity_TV_roleName);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Actor actor = actors.get(position);

        viewHolder.name.setText(actor.getName());
        viewHolder.role.setText(actor.getCharacter());
        Picasso.with(context).load(actor.getImageUrl()).into(viewHolder.image);

        return convertView;
    }

    private static class ViewHolder {
        ImageView image;
        TextView name, role;
    }
}
