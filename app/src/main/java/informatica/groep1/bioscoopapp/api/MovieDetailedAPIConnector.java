package informatica.groep1.bioscoopapp.api;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.devspark.robototextview.widget.RobotoTextView;

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
import informatica.groep1.bioscoopapp.R;
import informatica.groep1.bioscoopapp.domain.Actor;
import informatica.groep1.bioscoopapp.domain.Director;
import informatica.groep1.bioscoopapp.domain.Genre;
import informatica.groep1.bioscoopapp.domain.Movie;

/**
 * Created by twanv on 30-3-2017.
 */

public class MovieDetailedAPIConnector extends AsyncTask<String, Void, String> {

    private View mdView;
    private MovieListener listener;

    public MovieDetailedAPIConnector(MovieListener listener, View mdView) {
        this.mdView = mdView;
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
        Log.i("HALLO", response);



        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray genres = jsonObject.getJSONArray("genres");
            JSONObject credits = jsonObject.getJSONObject("credits");
            JSONArray cast = credits.getJSONArray("cast");
            JSONArray crew = credits.getJSONArray("crew");

            Movie movie = new Movie();

            int mID = 0;
            int length = 0;
            boolean adult = false;
            int dID = 0;
            String dName = "";

            StringBuilder builder = new StringBuilder();
            String delim = "";


            if (jsonObject.has("id")) {
                mID = jsonObject.getInt("id");
            }

            if (jsonObject.has("runtime")) {
                length = jsonObject.getInt("runtime");
            }

            if (jsonObject.has("adult")) {
                adult = jsonObject.getBoolean("adult");
            }


            for (int i = 0; i < genres.length(); i++) {
                if (genres.getJSONObject(i).has("name") && genres.getJSONObject(i).has("id")) {

                    int genreID = genres.getJSONObject(i).getInt("id");
                    String genreNaam = genres.getJSONObject(i).getString("name");
                    movie.addGenre(new Genre(genreID, genreNaam));

                    builder.append(delim).append(genreNaam);
                    delim = ", ";

                }
            }

            for (int i = 0; i < crew.length(); i++) {
                if (crew.getJSONObject(i).has("name") && crew.getJSONObject(i).has("id")
                        && crew.getJSONObject(i).has("job")) {
                    if (crew.getJSONObject(i).getString("job").equals("Director")) {
                        dID = crew.getJSONObject(i).getInt("id");
                        dName = crew.getJSONObject(i).getString("name");
                    }
                }
            }

            int x = 0;
            // loop through the cast, but never loop more than 6 times or the cast length.
            while (x < cast.length() && x < 6) {
                if (cast.getJSONObject(x).has("name") && cast.getJSONObject(x).has("id")
                        && cast.getJSONObject(x).has("character")) {
                    int aID = cast.getJSONObject(x).getInt("id");
                    String character = cast.getJSONObject(x).getString("character");
                    String aName = cast.getJSONObject(x).getString("name");

                    movie.addActor(new Actor(aName, aID, character));

                    x++;
                }
            }



            TextView adultTV = (RobotoTextView) mdView.findViewById(R.id.movieDetailedActivity_TV_adultAge);
            TextView lengthTV = (RobotoTextView) mdView.findViewById(R.id.movieDetailedActivity_TV_movieLength);
            TextView genre = (RobotoTextView) mdView.findViewById(R.id.movieDetailedActivity_TV_genre_value);

//            Initiate textviews for director here and pass dID and dName to the textviews.

            if(adult) {
                adultTV.setText("18+");
            } else {
                adultTV.setText("18-");
            }

            lengthTV.setText("" + length + " min");
            genre.setText(builder.toString());

            movie.setMovieID(mID);
            movie.setDirector(new Director(dID, dName));

            listener.onMovieAvailable(movie);


        } catch (JSONException e) {
            Log.e("ERROR", e.getLocalizedMessage());
        }
    }


}