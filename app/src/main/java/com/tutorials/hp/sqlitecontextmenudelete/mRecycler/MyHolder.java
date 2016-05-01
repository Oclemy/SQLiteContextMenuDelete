package com.tutorials.hp.sqlitecontextmenudelete.mRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

import com.tutorials.hp.sqlitecontextmenudelete.R;

/**
 * Created by Oclemmy on 5/1/2016 for ProgrammingWizards Channel and http://www.Camposha.com.
 */
public class MyHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnCreateContextMenuListener {

    TextView nameTxt;
    MyLongClickListener longClickListener;

    public MyHolder(View itemView) {
        super(itemView);

        this.nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);

        itemView.setOnLongClickListener(this);
        itemView.setOnCreateContextMenuListener(this);
    }

    public void setLongClickListener(MyLongClickListener longClickListener)
    {
        this.longClickListener=longClickListener;
    }

    @Override
    public boolean onLongClick(View v) {
        this.longClickListener.onLongClick(getLayoutPosition());
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        //OUR CONTEXT MENU
        menu.setHeaderTitle("ACTION : ");
        menu.add(0,0,0,"New");
        menu.add(0,1,0,"Delete");


    }
}
