package com.example.androidlabs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    EditText typeField;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_main_grid);
        //setContentView(R.layout.activity_main_linear);
        //setContentView(R.layout.activity_main_relative);
        setContentView(R.layout.activity_main_linear_layout);
        typeField=(EditText)findViewById(R.id.editText);

        preferences = getSharedPreferences("email", Context.MODE_PRIVATE);

        String savedValue = preferences.getString("ReserveName","");
        typeField.setText(savedValue);

       Button login = (Button)findViewById(R.id.button);

        login.setOnClickListener( c->{
            Intent nextPage = new Intent(MainActivity.this, ProfileActivity.class);
            editText = findViewById(R.id.editText);
            nextPage.putExtra("typed",editText.getText().toString());

            startActivity(nextPage);
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor =preferences.edit();
        String reservation = editText.getText().toString();
        editor.putString("ReserveName", reservation);
         editor.commit();


    }

}

