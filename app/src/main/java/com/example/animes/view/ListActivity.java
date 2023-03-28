package com.example.animes.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.animes.R;
import com.example.animes.adapter.AdapterList;
import com.example.animes.model.Anime;
import com.example.animes.utils.Constants;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    private TextInputEditText textInputEditText;
    private RecyclerView recyclerView;
    private AdapterList adapterList;

    private List<Anime> animes;
    private List<Anime> busc;

    private String urlJSON;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        textInputEditText = findViewById(R.id.textSearchList);

        Intent intent = getIntent();
        String email = intent.getStringExtra(MainActivity.EMAIL_USER);
        urlJSON = Constants.LOGIN_USER_MAIL + email;

        textInputEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textInputEditText.getText().toString().isEmpty()) {
                    busc.addAll(animes);
                }
                for (int i = 0; i < animes.size(); i++) {
                    if (animes.get(i).getName().equals(textInputEditText.getText().toString().toLowerCase())) {
                        busc.add(animes.get(i));
                    }
                }
               getAnimes();
            }
        });
    }
    private void getAnimes() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                urlJSON,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray animesArray = response.getJSONArray("animes");
                            for (int i = 0; i < animesArray.length(); i++) {

                                JSONObject jsonObject = animesArray.getJSONObject(i);
                                Anime anime = new Anime();
                                if (anime.getActive() == true) {
                                    anime.setName(jsonObject.getString("name"));
                                    anime.setName(jsonObject.getString("originalname"));
                                    anime.setDescription(jsonObject.getString("description"));
                                    anime.setYear(jsonObject.getInt("year"));
                                    anime.setType(jsonObject.getString("type"));
                                    anime.setType(jsonObject.getString("genre"));
                                    anime.setDemography(jsonObject.getString("demography"));
                                    anime.setImage(jsonObject.getString("image"));
                                    anime.setImage2(jsonObject.getString("image2"));
                                    anime.setFavorite(jsonObject.getString("favorite"));

                                    animes.add(anime);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapterList = new AdapterList(getApplicationContext(), busc);
                        recyclerView.setAdapter(adapterList);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("tag", "onErrorResponse: " + error.getMessage());
                    }
                }
        );
        queue.add(jsonObjectRequest);
    }
}