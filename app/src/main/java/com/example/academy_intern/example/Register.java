package com.example.academy_intern.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {


    Button btnRegister;
    EditText etName;
    EditText etSurname;
    EditText etEmail;
    EditText etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       btnRegister = findViewById(R.id.btnRegister);
        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

    //btnRegister.setOnClickListener(View v);

    }

     public void btnReg(View v) {


                String name = etName.getText().toString();
                String surname = etSurname.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
               // LocalDatabase db = new  LocalDatabase();

                if(name.isEmpty()) {
                    Toast.makeText(this, "Enter name!",
                            Toast.LENGTH_LONG).show();

                }else if(surname.isEmpty()){
                    Toast.makeText(this, " Enter surname!",
                            Toast.LENGTH_LONG).show();
                }else if(!LocalDatabase.isValidEmail(email)){

                    Toast.makeText(this, "Check email!",
                            Toast.LENGTH_LONG).show();
                }else if (!LocalDatabase.isValidPassword(password)){

                    Toast.makeText(this, "Check Password!",
                            Toast.LENGTH_LONG).show();
                    Toast.makeText(this, "Password should contain numbers,cap and character!",
                            Toast.LENGTH_LONG).show();
                }
                else {

                    User register = new User(name, surname, email, password);

                   // LocalDatabase db =new LocalDatabase();
                    LocalDatabase.addUser(register);

                    Toast.makeText(this, "Succefully Registered!",
                            Toast.LENGTH_LONG).show();

                    Intent intent = new Intent( Register.this,MainActivity.class);
                    startActivity(intent);
                }





        }




}


