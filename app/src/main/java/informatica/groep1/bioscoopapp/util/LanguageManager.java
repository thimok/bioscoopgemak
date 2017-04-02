package informatica.groep1.bioscoopapp.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;

import java.util.Locale;

import informatica.groep1.bioscoopapp.data.DatabaseConnection;

public class LanguageManager {
	
	public static Locale getLocale(Context context) {
		Locale ret = null;
		
		DatabaseConnection dbc = new DatabaseConnection(context);
		String language = dbc.getCurrentSelectedLanguage();
		
		switch (language.toLowerCase()) {
			case "english":
				ret = new Locale("en");
				Log.i("Locale", "English: " + ret.getDisplayLanguage());
				break;
			
			case "nederlands":
				ret = new Locale("nl");
				Log.i("Locale", "Nederlands: " + ret.getDisplayLanguage());
				break;
			
			default:
				ret = new Locale("en");
				Log.i("Locale", "Default: " + ret.getDisplayLanguage());
				break;
		}
		
		return ret;
	}
	
	public static void setApplicationLocale(Context context, Locale locale) {
		Locale.setDefault(locale);
		Resources res = context.getResources();
		Configuration config = res.getConfiguration();
		config.setLocale(locale);
		context.createConfigurationContext(config);
	}
}
