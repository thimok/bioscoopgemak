//================================================================================
// This class is made by:
// - Luka Brinkman
//================================================================================

package informatica.groep1.bioscoopapp.presentation;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.FragmentStatePagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.view.ViewPager;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import android.widget.TextView;

import java.util.List;
import java.util.Vector;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.adapter.PagerAdapter;

public class ShowActivity extends MenuActivity {

    //================================================================================
    // Properties
    //================================================================================
    
    private PagerAdapter adapter;
    private ViewPager viewPager;

	//================================================================================
	// Mutators
	//================================================================================
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show2);
	    
	    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        super.onCreateDrawer(toolbar, this);

        viewPager = (ViewPager) findViewById(R.id.containerTab);
	    
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
	    
        PagerAdapter mSectionsPagerAdapter = new PagerAdapter(getSupportFragmentManager(), 3, getApplicationContext());
        viewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }
	
    //================================================================================
    // Accessors
    //================================================================================
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
