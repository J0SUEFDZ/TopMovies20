package com.example.josue.top20;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Top extends AppCompatActivity {

    ArrayList<Movie> pelis;
    ArrayList<ShellIUMovie> movies;
   // Drawable d;

    public static Drawable LoadImage(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }

    public class DownloadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            Document doc;

            int cont;

            try {
                movies = new ArrayList<ShellIUMovie>();
                getMovies();
                pelis = new ArrayList<Movie>();
                doc = Jsoup.connect(urls[0]).get();
                Elements names = doc.select("h3.lister-item-header > a");
                Elements stars = doc.select("span.global-sprite.rating-star.imdb-rating");
                Elements metas = doc.select("span.metascore.favorable");
                Elements imgs = doc.select("img.loadlate");

                for (int i=0;i<20;i++){
                    pelis.add(new Movie(LoadImage(imgs.get(i).attr("loadlate")),names.get(i).text(),metas.get(i).text(),stars.get(i).nextElementSibling().text()));
                }

                return names.first().text();
            }catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                for (int i=0;i<20;i++){
                    movies.get(i).setNombre(pelis.get(i).getTitulo());
                    movies.get(i).setMeta(pelis.get(i).getMeta());
                    movies.get(i).setRat(pelis.get(i).getRating());
                    movies.get(i).setPortada(pelis.get(i).getPortada());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        String url = "http://www.imdb.com/list/ls064079588/";
        DownloadTask downloadTask = new DownloadTask();
        downloadTask.execute(url);
    }

    public void getMovies(){
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img1),(TextView)findViewById(R.id.title1),(TextView)findViewById(R.id.meta1),(TextView)findViewById(R.id.rat1)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img2),(TextView)findViewById(R.id.title2),(TextView)findViewById(R.id.meta2),(TextView)findViewById(R.id.rat2)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img3),(TextView)findViewById(R.id.title3),(TextView)findViewById(R.id.meta3),(TextView)findViewById(R.id.rat3)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img4),(TextView)findViewById(R.id.title4),(TextView)findViewById(R.id.meta4),(TextView)findViewById(R.id.rat4)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img5),(TextView)findViewById(R.id.title5),(TextView)findViewById(R.id.meta5),(TextView)findViewById(R.id.rat5)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img6),(TextView)findViewById(R.id.title6),(TextView)findViewById(R.id.meta6),(TextView)findViewById(R.id.rat6)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img7),(TextView)findViewById(R.id.title7),(TextView)findViewById(R.id.meta7),(TextView)findViewById(R.id.rat7)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img8),(TextView)findViewById(R.id.title8),(TextView)findViewById(R.id.meta8),(TextView)findViewById(R.id.rat8)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img9),(TextView)findViewById(R.id.title9),(TextView)findViewById(R.id.meta9),(TextView)findViewById(R.id.rat9)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img10),(TextView)findViewById(R.id.title10),(TextView)findViewById(R.id.meta10),(TextView)findViewById(R.id.rat10)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img11),(TextView)findViewById(R.id.title11),(TextView)findViewById(R.id.meta11),(TextView)findViewById(R.id.rat11)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img12),(TextView)findViewById(R.id.title12),(TextView)findViewById(R.id.meta12),(TextView)findViewById(R.id.rat12)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img13),(TextView)findViewById(R.id.title13),(TextView)findViewById(R.id.meta13),(TextView)findViewById(R.id.rat13)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img13),(TextView)findViewById(R.id.title14),(TextView)findViewById(R.id.meta14),(TextView)findViewById(R.id.rat14)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img15),(TextView)findViewById(R.id.title15),(TextView)findViewById(R.id.meta15),(TextView)findViewById(R.id.rat15)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img16),(TextView)findViewById(R.id.title16),(TextView)findViewById(R.id.meta16),(TextView)findViewById(R.id.rat16)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img17),(TextView)findViewById(R.id.title17),(TextView)findViewById(R.id.meta17),(TextView)findViewById(R.id.rat17)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img18),(TextView)findViewById(R.id.title18),(TextView)findViewById(R.id.meta18),(TextView)findViewById(R.id.rat18)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img19),(TextView)findViewById(R.id.title19),(TextView)findViewById(R.id.meta19),(TextView)findViewById(R.id.rat19)));
        movies.add(new ShellIUMovie((ImageView) findViewById(R.id.img20),(TextView)findViewById(R.id.title20),(TextView)findViewById(R.id.meta20),(TextView)findViewById(R.id.rat20)));
    }
}
