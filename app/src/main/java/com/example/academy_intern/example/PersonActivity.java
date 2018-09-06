package com.example.academy_intern.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class PersonActivity extends AppCompatActivity {

    LocalDatabase ds =new LocalDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        TextView list = findViewById(R.id.tvlistPer);
        LocalDatabase sd = new LocalDatabase();

        list.setText(sd.display());
    }

    public void btnSearch(View v){

       EditText se = findViewById(R.id.etSearch);
       TextView display = findViewById(R.id.tvSearch);

       String ss = se.getText().toString();

        display.setText(ds.OneDisp(ss));

        TextView t = findViewById(R.id.tvlistPer);
        t.setVisibility(View.INVISIBLE);

       }

       public void btnLog(View v){

           Intent intent = new Intent(PersonActivity.this,MainActivity.class);
           startActivity(intent);
       }
}
