package com.example.animes.view;

import static com.example.animes.view.MainActivity.EMAIL_USER;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.animes.R;
import com.example.animes.model.User;
import com.example.animes.utils.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    private Context context;
    private TextView textName;
    private TextView textMail;
    private TextView textPassword;
    private TextView textPhone;
    private Button butSign;
    private Button butLog;

    private String nameV;
    private String emailV;
    private String passwordV;
    private String phoneV;

    ArrayList<User> userlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        textName = findViewById(R.id.signupNameTxt);
        textMail = findViewById(R.id.signUpMailTxt);
        textPassword = findViewById(R.id.sigUpPaswdTxt);
        textPhone = findViewById(R.id.sigUpPhoneTxt);
        butSign = findViewById(R.id.sigUpbuttonSign);
        butLog = findViewById(R.id.signUpbuttonLogin);

        butLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        butSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textName.getText().toString().isEmpty()) {
                    textName.setError("Required");
                } else if (textMail.getText().toString().isEmpty()) {
                    textMail.setError("Required");
                } else if (textPassword.getText().toString().isEmpty()) {
                    textPassword.setError("Required");
                } else if (textPhone.getText().toString().isEmpty()) {
                    textPhone.setError("Required");
                } else {
                    nameV = textName.getText().toString().trim();
                    emailV = textMail.getText().toString().trim();
                    passwordV = textPassword.getText().toString().trim();
                    phoneV = textPhone.getText().toString().trim();
                    createUser();
                }
            }
        });
    }

    private void createUser() {
        RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.CREATE_USER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            if (response.equals("User created")) {
                                JSONObject obj = new JSONObject(response);
                                JSONObject userJson = obj.getJSONObject("user");
                                User user = new User(
                                        userJson.getInt("id"),
                                        userJson.getString("name"),
                                        userJson.getString("email"),
                                        userJson.getString("password"),
                                        userJson.getString("phone")
                                );
                                userlist.add(user);

                                Intent intent = new Intent(SignUpActivity.this, ListActivity.class);
                                intent.putExtra(EMAIL_USER, emailV);
                                startActivity(intent);
                            } else {
                                Toast.makeText(SignUpActivity.this, "Fatal error, Not Signed Up", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error", error.getMessage());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", nameV);
                params.put("email", emailV);
                params.put("password", passwordV);
                params.put("phone", phoneV);
                return params;
            }
        };
        queue.add(stringRequest);
    }
}