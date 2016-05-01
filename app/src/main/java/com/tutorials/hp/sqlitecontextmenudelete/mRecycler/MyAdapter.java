package com.tutorials.hp.sqlitecontextmenudelete.mRecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tutorials.hp.sqlitecontextmenudelete.R;
import com.tutorials.hp.sqlitecontextmenudelete.mDataBase.DBAdapter;
import com.tutorials.hp.sqlitecontextmenudelete.mDataObject.Planet;

import java.util.ArrayList;

/**
 * Created by Oclemmy on 5/1/2016 for ProgrammingWizards Channel and http://www.Camposha.com.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Planet> planets;
    int selectedPos;

    public MyAdapter(Context c, ArrayList<Planet> planets) {
        this.c = c;
        this.planets = planets;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        MyHolder holder=new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
         holder.nameTxt.setText(planets.get(position).getName());

        holder.setLongClickListener(new MyLongClickListener() {
            @Override
            public void onLongClick(int pos) {
                selectedPos=pos;
            }
        });
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    //DELETE PLANET
    public void deletePlanet()
    {
        //GET ID
        Planet p=planets.get(selectedPos);
        int id=p.getId();

        //DELETE IT FROM DB
        DBAdapter db=new DBAdapter(c);
        db.openDB();
        if(db.delete(id))
        {
            //DELETE ALSO FROM ARRAYLIST
            planets.remove(selectedPos);
        }else {
            Toast.makeText(c,"Unable To Delete",Toast.LENGTH_SHORT).show();
        }

        db.closeDB();

        this.notifyItemRemoved(selectedPos);
    }

}








