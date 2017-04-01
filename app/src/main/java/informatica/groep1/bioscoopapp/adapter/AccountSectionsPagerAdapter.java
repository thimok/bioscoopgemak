package informatica.groep1.bioscoopapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import informatica.groep1.bioscoopapp.presentation.fragment.HistoryFragment;
import informatica.groep1.bioscoopapp.presentation.fragment.TicketsFragment;
import informatica.groep1.bioscoopapp.presentation.fragment.WatchlistFragment;

public class AccountSectionsPagerAdapter extends FragmentPagerAdapter {
	
	public AccountSectionsPagerAdapter(FragmentManager fm) {
		super(fm);
	}
	
	@Override
	public Fragment getItem(int position) {
		switch (position) {
			case 0:
				TicketsFragment tab1 = new TicketsFragment();
				return tab1;
			
			case 1:
				HistoryFragment tab2 = new HistoryFragment();
				return tab2;
			
			case 2:
				WatchlistFragment tab3 = new WatchlistFragment();
				return tab3;
			
			default:
				return null;
		}
	}
	
	@Override
	public int getCount() {
		return 3;
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		switch (position) {
			case 0:
				return "Tickets";
			case 1:
				return "History";
			case 2:
				return "Watchlist";
		}
		return null;
	}
}
