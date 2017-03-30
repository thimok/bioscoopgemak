//================================================================================
// This class is made by:
// - Twan van Maastricht
//================================================================================

package informatica.groep1.bioscoopapp.api;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import informatica.groep1.bioscoopapp.domain.Movie;

public class MovieDBAPIConnector extends AsyncTask<String, Void, String> {


	MovieListener listener;
	public static final String TMDB_API_BASE = "https://api.themoviedb.org/3";
	public static final String API_KEY = "?api_key=f5432ebc636370b7954317a342043046";

	public MovieDBAPIConnector(MovieListener listener) {
		this.listener = listener;
	}

	@Override
	protected String doInBackground(String... params) {
		InputStream inputStream = null;
		BufferedReader reader = null;
		String urlString = "";
		String response = "";

		try {
			URL url = new URL(params[0]);
			URLConnection connection = url.openConnection();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ( (line = reader.readLine()) != null ) {
				response += line;
			}
		} catch (MalformedURLException e) {
			Log.e("Malformed URL", e.getLocalizedMessage());
			return null;
		} catch (IOException e) {
			Log.e("IO fout", e.getLocalizedMessage());
			return null;
		} catch (Exception e) {
			Log.e("Andere Exception", e.getLocalizedMessage());
			return null;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch(IOException e) {
					Log.e("connectie niet goed", e.getLocalizedMessage());
					return null;
				}
			}
		}


		return response;
	}


	@Override
	protected void onPostExecute(String response) {
		//Log.i("HALLO", response);
		
		if ((response == null) || (response.equalsIgnoreCase(""))) {
			return;
		}

		try {
			JSONObject jsonObject = new JSONObject(response);

			JSONArray results = jsonObject.getJSONArray("results");

			String title = "";
			String releaseDate = "";
			String rating = "";
			String id = "";
			String posterURL = "";



			for (int idx = 0; idx < results.length(); idx++) {

				JSONObject productObject = results.getJSONObject(idx);

				if (productObject.has("title")) {
					title = productObject.getString("title");
				} else {
					title = "Geen titel beschikbaar";
				}

				if (productObject.has("release_date")) {
					releaseDate = productObject.getString("release_date");
				} else {
					releaseDate = "Geen release date beschikbaar";
				}

				if (productObject.has("vote_average")) {
					rating = productObject.getString("vote_average");
				} else {
					rating = "Geen rating beschikbaar";
				}

				if (productObject.has("id")) {
					id = productObject.getString("id");
				} else {
					id = "Geen id beschikbaar";
				}

				if (productObject.has("backdrop_path")) {
					posterURL = productObject.getString("backdrop_path");
				} else {
					posterURL = "Geen afbeelding beschikbaar";
				}




				Movie movie = new Movie(title);
				movie.setRating(rating);
				movie.setReleaseYear(releaseDate);
				movie.setId(id);
				movie.setBackDropImage(posterURL);


				listener.onMovieAvailable(movie);
			}
		} catch (JSONException e) {
			Log.e("ERROR", e.getLocalizedMessage());
		}
	}

	public interface MovieListener {
		public void onMovieAvailable(Movie movie);
	}

}
