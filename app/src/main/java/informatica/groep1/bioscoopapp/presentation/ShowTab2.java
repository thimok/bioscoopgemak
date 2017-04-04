//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.presentation;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import informatica.groep1.bioscoopapp.R;

public class ShowTab2 extends Fragment{



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {


        View rootView = inflater.inflate( R.layout.tab_show2, container, false);

        ImageView image =  (ImageView) rootView.findViewById(R.id.imageView2);
        return rootView;

    }
}
