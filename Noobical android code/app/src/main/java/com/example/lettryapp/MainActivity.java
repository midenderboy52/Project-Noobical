package com.example.lettryapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


//Main project!


public class MainActivity extends AppCompatActivity {

    static Socket s;
    static EditText l;
    static String kda;
    static EditText kooo;
    static String kpa;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent g = getIntent();
        kda = g.getStringExtra("Ip adress");
        kpa = g.getStringExtra("Port");

        }



    public void pro(View view) {
        sends sendcode = new sends();
        //Id of text input has to be given here!
        l = findViewById(R.id.getinput1);
        kooo = findViewById(R.id.pass1);
        kda = l.getText().toString();
        kpa = kooo.getText().toString();
        if(TextUtils.isEmpty(kda) && TextUtils.isEmpty(kpa)) {
            Toast.makeText(getApplicationContext(), "Please input IP or port!", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(kda) && TextUtils.isEmpty(kpa) == false){
            Toast.makeText(getApplicationContext(), "Please input IP or port!", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(kda) == false && TextUtils.isEmpty(kpa)){
            Toast.makeText(getApplicationContext(), "Please input IP or port!", Toast.LENGTH_SHORT).show();
        }else{
            sendcode.start();
            Toast.makeText(getApplicationContext(), "If connected the IP address of your device will be shown on the PC application.", Toast.LENGTH_SHORT).show();
        }

    }


    public void Next_Page(View view) {
            //Have to send data from here by Intent!
            Intent lmao = new Intent(MainActivity.this , Page2.class);
            lmao.putExtra("Ip adress" , kda);
            lmao.putExtra("Port" , kpa);
            startActivity(lmao);


    }

}

class sends extends Thread {
    MainActivity pp = new MainActivity();
    @Override
    public void run() {
        int i = Integer.parseInt(pp.kpa);
        try {
            pp.s = new Socket(pp.kda, i);
            pp.s.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            ;
        }
    }
}