package com.onurakcay.multipoll;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText eName = findViewById(R.id.eName);

        final EditText ePassword = findViewById(R.id.ePassword);
        final EditText ePassword2 = findViewById(R.id.ePassword2);
        final Button register = findViewById(R.id.register);
        final String name = eName.getText().toString();
        final String password = ePassword.getText().toString();
        final String password2 = ePassword2.getText().toString();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Response.Listener<String> responselistener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);

                            Boolean success = jsonResponse.getBoolean("success");



                            if (success) {
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                RegisterActivity.this.startActivity(intent);
                                finish();

                            }
                    else  {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("This mail already in use or passwords are not same").setNegativeButton("Retry", null).create().show();

                            }




                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
            RegisterRequest registerRequest = new RegisterRequest(name,password,password2,responselistener);
                RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);
                requestQueue.add(registerRequest);



            }
        });

    }

    public void login (View v)
    {
        super.onBackPressed();
    }
}
