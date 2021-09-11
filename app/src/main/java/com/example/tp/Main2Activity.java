package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class Main2Activity extends AppCompatActivity {


    ImageButton ib;
    EditText name;
    EditText phone;
    TextView text;
    Button button;
    Contacts c;
    DataBase db ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        db=new DataBase(this);
        ib=(ImageButton)findViewById(R.id.imageButton);
        button =(Button)findViewById(R.id.button);
        name=(EditText) findViewById(R.id.editText);
        phone=(EditText) findViewById(R.id.editText2);
        text=(TextView)findViewById(R.id.textView3) ;
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
                SharedPreferences.Editor editor=sp.edit();
                c=new Contacts(name.getText().toString(),phone.getText().toString());
                db.ADD(c);
                editor.putString("Name",name.getText().toString());
                editor.putString("Phone",phone.getText().toString());
                editor.apply();
                name.clearComposingText();
                phone.clearComposingText();
                text.setText("Saved successfully");
            }
        });

    }
}
