package com.example.lettryapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.*;
import java.net.*;


public class Pro5 extends AppCompatActivity {
    static String hot_sauce;
    static String white_sauce;
    static int lowe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro5);
        try {
            Intent sauce = getIntent();
            hot_sauce = sauce.getStringExtra("ip");
            white_sauce = sauce.getStringExtra("port");
            lowe = Integer.parseInt(white_sauce);
        }catch(Exception e) {
            ;
        }


    }

   public void Next_Pe(View view) {
        Intent burger = new Intent(Pro5.this , Pro6.class);
        burger.putExtra("ip" , hot_sauce);
        burger.putExtra("port" , white_sauce);
        startActivity(burger);
   }


   public void Last_Pae(View view) {
        Intent lmafao = new Intent(Pro5.this , Pro4.class);
        lmafao.putExtra("Ip" , hot_sauce);
        lmafao.putExtra("port" , white_sauce);
        startActivity(lmafao);
   }

   public void Mor(View view) {
        EditText carrot = findViewById(R.id.lmao_90);
        String onion = carrot.getText().toString();
        if(TextUtils.isEmpty(hot_sauce) && lowe == 0) {
            Toast.makeText(getApplicationContext(), "First connect to your computer!", Toast.LENGTH_SHORT).show();
        }else{
            Poosr thread = new Poosr(onion);
            thread.start();
        }

   }

   public void jol(View view) {
        EditText ginger = findViewById(R.id.shaplagnag_90);
        String chilli = ginger.getText().toString();
        if(TextUtils.isEmpty(hot_sauce) && lowe == 0) {
            Toast.makeText(getApplicationContext(), "First connect to your computer!", Toast.LENGTH_SHORT).show();
        }else{
            Posr potato = new Posr(chilli);
            potato.start();
        }

   }



}





class Poosr extends Thread {
    static Socket Karma;
    static PrintWriter pro;
    static String foo;

    Poosr(String foo) {
        this.foo = foo;
    }
    Pro5 slow = new Pro5();

    @Override
    public void run() {
        try {

            Karma = new Socket(slow.hot_sauce, slow.lowe);
            pro = new PrintWriter(Karma.getOutputStream());
            pro.println("def" + foo);
            pro.flush();
            InputStream nooob = Karma.getInputStream();
            byte[] size_buff = new byte[1024];
            nooob.read(size_buff);
            String j = new String(size_buff);
            Karma.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {

        }
    }

}


class Posr extends Thread {
    static Socket Karma;
    static PrintWriter pro;
    static String foo;

    Posr(String foo) {
        this.foo = foo;
    }
    Pro5 slow = new Pro5();

    @Override
    public void run() {
        try {
            Karma = new Socket(slow.hot_sauce , slow.lowe);
            pro = new PrintWriter(Karma.getOutputStream());
            pro.println("del" + foo);
            pro.flush();
            InputStream nooob = Karma.getInputStream();
            byte[] size_buff = new byte[1024];
            nooob.read(size_buff);
            String j = new String(size_buff);
            Karma.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            ;
        }
    }

}