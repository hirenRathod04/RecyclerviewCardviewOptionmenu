package com.royalsoftsolutions.recyclerviewcardviewoptionmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private MyAdepter myAdepter;
private List<Recycleritem> listItems = new ArrayList<> (  );
private EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        recyclerView = findViewById ( R.id.recyclerview );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );
        recyclerView.setHasFixedSize ( true );
        myAdepter = new MyAdepter ( listItems,MainActivity.this );
        recyclerView.setAdapter ( myAdepter );


        Button button =findViewById ( R.id.button );
        button.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                etText = findViewById ( R.id.etTextr);
                String text = etText.getText ().toString ().trim ();
                listItems.add ( new Recycleritem ( text  , "welcome" ) );
                myAdepter.updateList ( listItems );
                //myAdepter.notifyDataSetChanged ();
                recyclerView.setAdapter ( myAdepter );

                Toast.makeText ( MainActivity.this,"ok",Toast.LENGTH_SHORT ).show ();
            }
        } );

    }
}