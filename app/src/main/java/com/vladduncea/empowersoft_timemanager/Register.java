package com.vladduncea.empowersoft_timemanager;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etFirstName = (EditText) findViewById(R.id.etFirstName);
        final EditText etLastName = (EditText) findViewById(R.id.etLastName);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etUsername = (EditText) findViewById(R.id.etUsernamereg);
        final EditText etPassword = (EditText) findViewById(R.id.etPasswordreg);

        final Button btRegister = (Button) findViewById(R.id.btRegister);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String FirstName = etFirstName.getText().toString();
                final String LastName = etLastName.getText().toString();
                final String Email = etEmail.getText().toString();
                final String Username = etUsername.getText().toString();
                final String Password = etPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonresponse = new JSONObject(response);
                            boolean success = jsonresponse.getBoolean("success");
                            if(success){
                                Intent intent = new Intent(Register.this,Login_Register.class);
                                Register.this.startActivity(intent);
                            }
                            else {
                                AlertDialog.Builder alert = new AlertDialog.Builder(Register.this);
                                alert.setMessage("Register Failed").setNegativeButton("Retry",null).create().show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(FirstName,LastName,Username,Password,Email,responseListener);
                RequestQueue registerQueue = Volley.newRequestQueue(Register.this);
                registerQueue.add(registerRequest);
            }
        });

    }
}
