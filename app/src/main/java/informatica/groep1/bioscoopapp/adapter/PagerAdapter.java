//================================================================================
// This class is made by:
// - Luka Brinkman
//================================================================================

package informatica.groep1.bioscoopapp.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.presentation.ShowTab1;
import informatica.groep1.bioscoopapp.presentation.ShowTab2;
import informatica.groep1.bioscoopapp.presentation.ShowTab3;

 /**
  * PagerAdapter.java - A adapter class that extends the FragmentPagerAdapter superclass.
        * @Author Luka Brinkman
        * @version 1.0
        */

public class PagerAdapter extends FragmentPagerAdapter {
    ShowTab1 tab1;
    ShowTab2 tab2;
    ShowTab3 tab3;
    int mNumOfTabs;
    Context context;

    public PagerAdapter(FragmentManager fm, int mNumOfTabs, Context context) {
        super(fm);
        this.mNumOfTabs = mNumOfTabs;
        this.context = context;


    }

     /**
      * Retrieve the number of tabs
      * @return A int data type
      */
     @Override
    public int getCount() {
        return mNumOfTabs;
    }


     /**
      * Method that decides which tab class the application is showing
      * @param position the position of the tab
      * @return the fragment that belongs to the tab
      */
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                tab1 = new ShowTab1();
                return tab1;
            case 1:
                tab2 = new ShowTab2();
                return tab2;

            case 2:
                tab3 = new ShowTab3();
                return tab3;

            default:
                return null;

        }

    }


     /**
      * Method that sets the title of a tab
      * @param position the position of the tab
      * @return the title that belongs to the tab
      */
     public CharSequence getPageTitle(int position){

        switch (position) {
            case 0:
                return context.getResources().getString(R.string.tab1_showActivity);
            case 1:
                return context.getResources().getString(R.string.tab2_showActivity);
            case 2:
                return context.getResources().getString(R.string.tab3_showActivity);

            default:
                return null;
        }
    }




}
