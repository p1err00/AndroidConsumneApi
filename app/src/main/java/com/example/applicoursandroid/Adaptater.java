package com.example.applicoursandroid;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class Adaptater extends BaseAdapter{

    Context context;
    List<String> title;
    List<String> imageUrl;
    List<Integer> valeur;
    List<Integer> valeurPromo;
    //constructor
    public Adaptater(Context context, ArrayList<String> title, ArrayList<String> imageUrl, ArrayList<Integer> valeur, ArrayList<Integer> valeurPromo){

        this.context = context;
        this.title = title;
        this.imageUrl = imageUrl;
        this.valeur = valeur;
        this.valeurPromo = valeurPromo;
    }


    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return (long)position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View cv = convertView;
        if(cv == null){
            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            cv = inf.inflate(R.layout.cardview_slide_panel, parent, false);

        }

        //set elements
        ((TextView)cv.findViewById(R.id.title)).setText(title.get(position));
        ((TextView)cv.findViewById(R.id.value)).setText(valeur.get(position).toString());
        ((TextView)cv.findViewById(R.id.valuePromo)).setText(valeurPromo.get(position).toString());

        return cv;
    }
}
