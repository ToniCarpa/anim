package com.example.animes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.animes.R;
import com.example.animes.model.User;
import com.example.animes.utils.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView txtpass;
    private TextView txtmail;
    private Button butLog;
    private Button butSig;

    private String pass;
    private String mail;

    ArrayList<User> userlist = new ArrayList<>();

    private String urlJSON;
    public static String EMAIL_USER = "com.example.animeJSON.EMAIL_USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtpass = findViewById(R.id.loginPassTxt);
        txtmail = findViewById(R.id.loginEmailTxt);
        butLog = findViewById(R.id.loginButLog);
        butSig = findViewById(R.id.loginButSig);

        butLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtpass.getText().toString().isEmpty()) {
                    txtpass.setError("Required");
                } else if (txtmail.getText().toString().isEmpty()) {
                    txtmail.setError("Required");
                } else {
                    pass = txtpass.getText().toString();
                    mail = txtmail.getText().toString();
                    urlJSON = Constants.LOGIN_USER_URL + mail + "&password=" + pass;
                    //loginUser();
                }
            }
        });
        butSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginUser() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.POST,
                urlJSON,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                            try {
                                JSONArray userArray = response.getJSONArray("user");
                                for (int i = 0; i < userArray.length(); i++) {
                                    JSONObject jsonObject = userArray.getJSONObject(i);
                                    User user = new User();
                                    user.setId(jsonObject.getInt("id"));
                                    user.setName(jsonObject.getString("name"));
                                    user.setEmail(jsonObject.getString("email"));
                                    user.setPassword(jsonObject.getString("password"));
                                    user.setPhone(jsonObject.getString("phone"));
                                    userlist.add(user);
                                }
                                for (int j = 0; j < userlist.size(); j++) {
                                    if (mail.equals(userlist.get(j).getEmail()) && pass.equals(userlist.get(j).getPassword())) {
                                        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                                        intent.putExtra(EMAIL_USER, mail);
                                        startActivity(intent);
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Sign Up, please", error.getMessage());
                        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                        startActivity(intent);
                    }
                }
        );
        queue.add(objectRequest);
    }
}