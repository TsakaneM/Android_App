package com.example.academy_intern.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText surname;
    EditText email;
    EditText password;

    LocalDatabase ds = new LocalDatabase();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ImageView pic = findViewById(R.id.firstImage);
        int ImageSource= getResources().getIdentifier("@drawable/Overview_002-12",null,this.getPackageName());
        pic.setImageResource(ImageSource);*/
    }

    public void regg(View v){

        Intent intt = new Intent(MainActivity.this,Register.class);
        startActivity(intt);
    }

    public void goReg(View v) {

        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);

    }

    public void btnPers(View v) {



        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        Button log = findViewById(R.id.btnLogIn);

        String uemail = email.getText().toString();
        String pass = password.getText().toString();

        if (uemail.isEmpty() && pass.isEmpty()) {
            Toast.makeText(this, "Email or Password cannot be empty", Toast.LENGTH_LONG).show();

        }
          else if
            (ds.vali(uemail, pass)) {

                Intent intent = new Intent(MainActivity.this, PersonActivity.class);
                startActivity(intent);
            } else if

         (!uemail.equals(email) && !pass.equals(password)) {
            Toast.makeText(this, "User Does Not Exist", Toast.LENGTH_LONG).show();
        }




    }
}
