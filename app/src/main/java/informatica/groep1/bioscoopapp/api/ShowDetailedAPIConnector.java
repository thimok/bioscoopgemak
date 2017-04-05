//================================================================================
// This class is made by:
// - Twan van Maastricht
//================================================================================

package informatica.groep1.bioscoopapp.api;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.devspark.robototextview.widget.RobotoTextView;
import com.squareup.picasso.Picasso;

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

public class ShowDetailedAPIConnector  extends AsyncTask<String, Void, String> {

        private View mdView;
        private MovieListener listener;
        private static final String TMDB_POSTER_URL_BASE = "http://image.tmdb.org/t/p/w1000/";
        private Context context;

        public ShowDetailedAPIConnector(View mdView, Context context, MovieListener listener) {
            this.mdView = mdView;
            this.context = context;
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

                int id = 0;
                int length = 0;
                boolean adult = false;
                String rating = "";
                String title = "";
                String year = "";
                String posterPath = jsonObject.getString("poster_path");
                String backdrawPath = jsonObject.getString("backdrop_path");
                String longDescription = "";


                if (jsonObject.has("runtime")) {
                    if (!jsonObject.isNull("runtime")) {
                        length = jsonObject.getInt("runtime");
                    }
                }

                if (jsonObject.has("adult")) {
                    adult = jsonObject.getBoolean("adult");
                }

                if (jsonObject.has("vote_average")) {
                    rating = jsonObject.getString("vote_average");
                }

                if (jsonObject.has("title")) {
                    title = jsonObject.getString("title");
                }

                if (jsonObject.has("release_date")) {
                    String releaseDate = jsonObject.getString("release_date");
                    String [] dateParts = releaseDate.split("-");
                    year = dateParts[0];
                }

                if (jsonObject.has("overview")) {
                    longDescription = jsonObject.getString("overview");
                }



                if (mdView != null) {
                    TextView adultTV = (RobotoTextView) mdView.findViewById(R.id.showDetailedActivity_TV_adultAge);
                    TextView lengthTV = (RobotoTextView) mdView.findViewById(R.id.showDetailedActivity_TV_movieLength);
                    TextView ratingTV = (RobotoTextView) mdView.findViewById(R.id.showDetailedActivity_TV_rating);
                    TextView titleTV = (RobotoTextView) mdView.findViewById(R.id.showDetailedActivity_TV_title);
                    TextView dateTV = (RobotoTextView) mdView.findViewById(R.id.showDetailedActivity_TV_date);
                    ImageView backDrawIV = (ImageView) mdView.findViewById(R.id.showDetailedActivity_IV_headerImage);
                    ImageView posterIV = (ImageView) mdView.findViewById(R.id.showDetailedActivity_IV_posterImage);

                    if (jsonObject.has("id")) {
                        id = jsonObject.getInt("id");
                    }

                    if(adult) {
                        adultTV.setText("18+");
                    } else {
                        adultTV.setText("18-");
                    }

                    if (length != 0) {
                        lengthTV.setText("" + length + " min");
                    } else {
                        String sLengthPlaceholder = mdView.getResources().getString(R.string.placeholder_activity_movie_detailed_length);
                        lengthTV.setText(sLengthPlaceholder);
                    }

                    if (!rating.equals("")) {
                        ratingTV.setText(rating);
                    } else {
                        String sRatingPlaceholder = mdView.getResources().getString(R.string.placeholder_activity_movie_detailed_rating);
                        ratingTV.setText(sRatingPlaceholder);
                    }

                    if (!title.equals("")) {
                        titleTV.setText(title);
                    } else {
                        String sTitlePlaceholder = mdView.getResources().getString(R.string.placeholder_activity_movie_detailed_title);
                        titleTV.setText(sTitlePlaceholder);
                    }

                    if (!year.equals("")) {
                        dateTV.setText(year);
                    } else {
                        String sDatePlaceholder = mdView.getResources().getString(R.string.placeholder_activity_movie_detailed_date);
                        dateTV.setText(sDatePlaceholder);
                    }

                    if (longDescription.equals("")) {
                        longDescription = mdView.getResources().getString(R.string.placeholder_activity_movie_detailed_longDescription);
                    }

                    Picasso.with(context).load(TMDB_POSTER_URL_BASE + backdrawPath).error(R.drawable.missingimage).into(backDrawIV);
                    Picasso.with(context).load(TMDB_POSTER_URL_BASE + posterPath).error(R.drawable.missingimage).into(posterIV);

                    Movie movie = new Movie(title);
                    movie.setRating(rating);
                    movie.setReleaseYear(year);
                    movie.setMovieID(id);
                    movie.setBackDropImage(backdrawPath);
                    movie.setPosterImage(posterPath);
                    movie.setLongDescription(longDescription);

                    listener.onMovieAvailable(movie);



                }

            } catch (JSONException e) {
                Log.e("ERROR", e.getLocalizedMessage());
            }
        }



}
