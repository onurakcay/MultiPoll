package com.onurakcay.multipoll;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class Poll extends AppCompatActivity {
    ListView listView;
    String name;

    ArrayList<JsonModel>list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);
        Intent intent = getIntent();
      //  RadioButton r1=findViewById(R.id.radioButton1);
         name = intent.getStringExtra("name");
        listView = (ListView) findViewById(R.id.listView);
        getJSON("http://onurakcay.000webhostapp.com/multipoll/viewQuestions.php");
        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
        findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
    }


    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }


    private void loadIntoListView(String json) throws JSONException {
        int i = 0,counter=0;
        JSONArray jsonArray = new JSONArray(json);

    Log.d("PollActivity ","loadIntoListView :"+json);
        while (i<jsonArray.length()) {
            JSONObject obj = jsonArray.getJSONObject(i);
            String titlee = obj.getString("title");
            String content = obj.getString("question");
            if(name.equals(titlee)) {
                JsonModel model=new JsonModel(titlee,content,counter);
                list.add(model);
                counter++;
            }

          i++;
        }

        listView.setAdapter(null);
        ListContentAdapter adapter=new ListContentAdapter(Poll.this,list,counter,this);
        listView.setAdapter(adapter);
        findViewById(R.id.loadingPanel).setVisibility(View.GONE);


    }



}






