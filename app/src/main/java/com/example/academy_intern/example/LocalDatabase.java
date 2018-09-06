package com.example.academy_intern.example;


import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocalDatabase {


    public static ArrayList<User> list= new ArrayList<>();
   // public static User uza = new User();


    public LocalDatabase() {
    }

    // User users =new User(name,surname,email,password);
        public static void addUser( User u){

            list.add(u);


}
        public ArrayList<User> getAll(){

            if(!list.isEmpty()){
                return (list);
            }
            return (null);
        }
        public boolean vali(String email,String password){

            for (User u:list){

        if (email.equals(u.getEmail()) && password.equals(u.getPassword())){
            return true;
        }


    }



            return false;}


             public String display() {
                String all= "";

                    for (User u : list){

                        all+= String.format("Name :" + u.getName()+"\n"+
                        "Surname :" + u.getSurname()+"\n"+ "Email :"+ u.getEmail());
                    // all+= String.format(u.toString());

                            }
                            return all;
    }

        public String OneDisp(String email){
        String all="";

        for (User u : list){
            if(u.getEmail().equalsIgnoreCase(email)){
                all+= String.format("Name :" + u.getName()+"\n"+
                        "Surname :" + u.getSurname()+"\n"+ "Email :"+ u.getEmail());

            }



        }
        return  all;
        }

    public static boolean isValidEmail(String valemail) {
        /*if (valemail == null) {
            return false;
        } else {*/

            //return (!TextUtils.isEmpty(valemail) && Patterns.EMAIL_ADDRESS.matcher(valemail).matches());
            return android.util.Patterns.EMAIL_ADDRESS.matcher(valemail).matches();
        //}
    }

    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }

}
