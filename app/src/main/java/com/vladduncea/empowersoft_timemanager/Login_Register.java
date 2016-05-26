package com.vladduncea.empowersoft_timemanager;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Login_Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__register);
        final TextView tvSend_Register = (TextView) findViewById(R.id.tvRegister_Send);

        assert tvSend_Register != null;
        tvSend_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Go_to_register = new Intent(Login_Register.this,Register.class);
                Login_Register.this.startActivity(Go_to_register);
            }
        });
    }

    public void login(){
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final String Username = etUsername.getText().toString();
        final String Password = etPassword.getText().toString();
        Response.Listener<String> loginListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean logged = jsonResponse.getBoolean("success");
                    if(logged){
                        String FirstName = jsonResponse.getString("FirstName");
                        String LastName = jsonResponse.getString("LastName");
                        String Email = jsonResponse.getString("Email");
                        //String Username = jsonResponse.getString("Username");

                        Intent intent = new Intent(Login_Register.this,MainPage.class);
                        intent.putExtra("FirstName",FirstName);
                        intent.putExtra("LastName",LastName);
                        intent.putExtra("Email",Email);
                        //intent.putExtra("Username",Username);
                        Login_Register.this.startActivity(intent);
                    }
                    else{
                        AlertDialog.Builder alert = new AlertDialog.Builder(Login_Register.this);
                        alert.setMessage("Login Failed").setNegativeButton("Retry",null).create().show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

        LoginRequest loginRequest = new LoginRequest(Username,Password,loginListener);
        RequestQueue loginQueue = Volley.newRequestQueue(Login_Register.this);
        loginQueue.add(loginRequest);

    }
    public void Login_Button(View view) {
        login();
    }
}
