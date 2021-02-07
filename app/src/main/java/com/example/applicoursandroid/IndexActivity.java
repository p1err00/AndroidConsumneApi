package com.example.applicoursandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.app.ListActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IndexActivity extends ListActivity {

    private ListView mListView;
    private List<String> prenom = new ArrayList<String>();
    private List<String> nom = new ArrayList<String>();
    private GameDataSource datasource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index2);

        Toast.makeText(IndexActivity.this, "Connexion successful",
                Toast.LENGTH_LONG).show();

        datasource = new GameDataSource(this);
        datasource.open();

        List<Game> values = datasource.getAllGames();
        ArrayAdapter<Game> adapter = new ArrayAdapter<Game>(this, android.R.layout.simple_list_item_1, values);
        ListView lv = (ListView)findViewById(R.id.list);
        lv.setAdapter(adapter);

    }

    public void onClick(View view){
        @SuppressWarnings("unchecked")
        ArrayAdapter<Game> adapter = (ArrayAdapter<Game>) getListAdapter();
        Game game = null;
        switch(view.getId()){
            case R.id.add:
                String[] games = new String[] {"Game1", "Game2", "Game3", "Game4"};
                int nextInt = new Random().nextInt(4);
                game = datasource.createGame(games[nextInt]);
                adapter.add(game);
            break;
            case R.id.delete:
                if(getListAdapter().getCount() > 0){
                    game = (Game) getListAdapter().getItem(0);
                    datasource.deleteGame(game);
                    adapter.remove(game);
                }
            break;
        }
        adapter.notifyDataSetChanged();
        startActivity(new Intent(this, AddActivity.class));
    }

    protected void onResume(){
        datasource.open();
        super.onResume();
    }

    protected void onPause(){
        datasource.close();
        super.onPause();
    }
}