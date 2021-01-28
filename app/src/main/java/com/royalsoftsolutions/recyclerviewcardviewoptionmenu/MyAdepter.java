package com.royalsoftsolutions.recyclerviewcardviewoptionmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MyAdepter extends RecyclerView.Adapter<MyAdepter.ViewHolder> {
    private List<Recycleritem> listItems;
    private Context mcontext;

    public MyAdepter(List<Recycleritem> listItems, Context mcontext) {
        this.listItems = listItems;
        this.mcontext = mcontext;
    }

    public void updateList(List<Recycleritem> list) {
        this.listItems = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from ( mcontext ).inflate ( R.layout.recycleritem ,
                parent,false);
        return new ViewHolder ( v );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Recycleritem item = listItems.get(position);
        holder.txtTile.setText ( item.getTitle () );
        holder.txtDiscription.setText ( item.getDescription () );
        holder.txtOptionDigit.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                //display option menu
                PopupMenu popupMenu = new PopupMenu ( mcontext,holder.txtOptionDigit);
                popupMenu.inflate ( R.menu.menu);
                popupMenu.setOnMenuItemClickListener ( new PopupMenu.OnMenuItemClickListener ( ) {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId ()){
                            case  R.id.menu_item_edit:
                                Toast.makeText ( mcontext,"Edit",Toast.LENGTH_SHORT ).show ();
                                break;
                            case  R.id.menu_item_delete:
                                Toast.makeText ( mcontext,"Delete",Toast.LENGTH_SHORT ).show ();
                               /* listItems.remove ( position );
                                notifyDataSetChanged ();*/
                                break;
                            default:break;
                        }
                        return false;
                    }
                } );
                popupMenu.show ();
            }
        } );



    }

    @Override
    public int getItemCount() {
        return listItems.size ();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtTile;
        public TextView txtDiscription;
        public  TextView txtOptionDigit;
        public ViewHolder(@NonNull View itemView) {
            super ( itemView );
            txtTile = itemView.findViewById ( R.id.txtTile );
            txtDiscription = itemView.findViewById ( R.id.txtDiscription );
            txtOptionDigit = itemView.findViewById ( R.id.txtOptionDigit );

        }
    }
}
