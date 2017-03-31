package informatica.groep1.bioscoopapp.util;

import android.app.Activity;
import android.content.res.Configuration;

import java.util.ArrayList;
import java.util.Locale;

public class Language {
	
	private static Locale SELECTED_LOCALE;
	private static ArrayList<LocaleChangeListener> LISTENERS;
	
	public static void setLocale(String language) {
		initMembers();
		
		String lang = language;
		Locale locale = new Locale(lang);
		
		SELECTED_LOCALE = locale;
		
		for (LocaleChangeListener list : LISTENERS) {
			list.onLocaleChanged(SELECTED_LOCALE);
		}
	}
	
	public static void addListener(LocaleChangeListener listener) {
		initMembers();
		
		LISTENERS.add(listener);
	}
	
	private static void initMembers() {
		if (LISTENERS == null) {
			LISTENERS = new ArrayList<>();
		}
	}
	
	public interface LocaleChangeListener {
		void onLocaleChanged(Locale locale);
	}
}
