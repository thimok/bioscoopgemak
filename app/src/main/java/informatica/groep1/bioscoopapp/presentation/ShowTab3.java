package informatica.groep1.bioscoopapp.presentation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import informatica.groep1.bioscoopapp.R;

/**
 * Created by lukab on 30-3-2017.
 */

public class ShowTab3 extends Fragment {


    public View OnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {


        View rootView = inflater.inflate( R.layout.tab_show2, container, false);

        ImageView image =  (ImageView) rootView.findViewById(R.id.imageView2);
        return rootView;

    }
}
