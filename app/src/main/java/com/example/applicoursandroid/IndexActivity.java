package com.example.applicoursandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class IndexActivity extends AppCompatActivity {

    private ListView mListView;
    private List<String> prenom = new ArrayList<String>();
    private List<String> nom = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index2);

        Toast.makeText(IndexActivity.this, "Connexion successful",
                Toast.LENGTH_LONG).show();


        //Create value to put in table

        ArrayList<String> title = new ArrayList<String>();
        title.add("Titre1");
        title.add("Titre2");
        title.add("Titre3");
        title.add("Titre4");

        ArrayList<String> imageUrl = new ArrayList<String>();
        imageUrl.add("http://lorempixel.com/180/241/");
        imageUrl.add("http://lorempixel.com/180/242/");
        imageUrl.add("http://lorempixel.com/180/243/");
        imageUrl.add("http://lorempixel.com/180/244/");

        ArrayList<Integer> valeur = new ArrayList<Integer>();
        valeur.add(12);
        valeur.add(12);
        valeur.add(12);
        valeur.add(12);

        ArrayList<Integer> valeurPromo = new ArrayList<Integer>();
        valeurPromo.add(5);
        valeurPromo.add(5);
        valeurPromo.add(5);
        valeurPromo.add(5);

        //Create adaptater
        Adapter listAdaptater = new Adaptater(this, title, imageUrl, valeur, valeurPromo);
        ListView list = ((ListView) findViewById (R.id.list_panel));
        list.setAdapter((ListAdapter) listAdaptater);


    }
}