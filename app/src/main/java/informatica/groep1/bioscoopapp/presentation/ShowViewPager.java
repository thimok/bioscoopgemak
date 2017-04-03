package informatica.groep1.bioscoopapp.presentation;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import informatica.groep1.bioscoopapp.R;

/**
 * Created by lukab on 31-3-2017.
 */

public class ShowViewPager extends AppCompatActivity {

ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewPager = (ViewPager) findViewById(R.id.containerTab);

        setContentView(R.layout.content_show);

    }

    public android.support.v4.view.ViewPager getViewPager() {


        return viewPager;

    }
}

