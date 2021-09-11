package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class Main3Activity extends AppCompatActivity {

    TextView name;
    TextView phone;
    TextView text;
    Button button;
    ImageButton ib;
    DataBase db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        name=(TextView)findViewById(R.id.textView);
        phone=(TextView)findViewById(R.id.textView2);
        text=(TextView)findViewById(R.id.textView4);
        db=new DataBase(this);
        ib=(ImageButton)findViewById(R.id.imageButton) ;
        button=(Button) findViewById(R.id.button2);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("File",MODE_PRIVATE);
                String Name=sp.getString("Name","None").toString();
                String Phone=sp.getString("Phone","None").toString();

                if(Name.compareTo("None")!=0 & Phone.compareTo("None")!=0 || Name.compareTo("")!=0 & Phone.compareTo("")!=0 )
                {
                    name.setText(Name);
                    phone.setText(Phone);
                }
                else
                {
                    text.setText("Not Saved ");
                }
                List<Contacts> l=db.getCon();
                for(Contacts c :l)
                {
                    Log.d("db",c.getName());
                }

            }
        });

    }
}
