package com.vladduncea.empowersoft_timemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        final TextView tvUsername = (TextView) findViewById(R.id.tvUserName);
        final TextView tvEmail = (TextView) findViewById(R.id.tvEmail);

        Intent intent = getIntent();
        String name = intent.getStringExtra("FirstName")+ " " +intent.getStringExtra("LastName");
        String data = intent.getStringExtra("Email");
        tvUsername.setText("Welcome "+ name);
        tvEmail.setText("Email: "+data);
    }
}
