package com.example.ikeak.charactersynopsis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.startbutton);

    }

    public void nextpage(View view) {

         Intent intent = new Intent(MainActivity.this, simpsonActivity.class);
         startActivity(intent);

    }
}
