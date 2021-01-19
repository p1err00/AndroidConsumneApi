package com.example.applicoursandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //EditText editText = (EditText)findViewById(R.id.ediText);

    }

    public void clickFunction(View view) {

        EditText edit = (EditText)findViewById(R.id.ediTextEmail);
        String aze = "aze";
        if(edit.getText().toString().equals(aze)){


            //Launch other activity (Create new activity)
            startActivity(new Intent(this, IndexActivity.class));
        } else {
            Toast.makeText(MainActivity.this, "Connexion failed, retry",
                    Toast.LENGTH_LONG).show();
        }


        /*
        Intent myIntent = new Intent();
        myIntent.setClassName("com.example", "com.example.applicoursandroid.Index");
        startActivity(myIntent);


        AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Alert")
                .setMessage("ceci est une alert qui fonctionne");
        AlertDialog alert1 = build.create();
        alert1.show();


                */

    }
}