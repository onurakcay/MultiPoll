package com.onurakcay.multipoll;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    Button bLogin ;
    EditText eName;
    EditText ePassword ;
    TextView bRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bLogin = findViewById(R.id.login);
        eName =  findViewById(R.id.eName);
        ePassword = findViewById(R.id.ePassword);
        bRegister = findViewById(R.id.register);
        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = eName.getText().toString();
                final String password = ePassword.getText().toString();
                findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                String name = jsonResponse.getString("name");


                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                intent.putExtra("name",name);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                LoginActivity.this.startActivity(intent);
                                finish();
                            }
                            else
                            {
                                 AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Your name or password is wrong. Please try again.").setNegativeButton("Retry",null).create().show();

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(name,password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(intent);

            }
        });
    }
}
