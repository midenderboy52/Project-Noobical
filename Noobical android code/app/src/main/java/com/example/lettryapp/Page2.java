package com.example.lettryapp;

import androidx.appcompat.app.AppCompatActivity;
import java.io.FileWriter;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;
import java.net.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;


public class Page2 extends AppCompatActivity {


    static String ip;
    static String porp;
    static int port;
    static String sfx;
    static TextView kko;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        try {
            Intent recv = getIntent();
            ip = recv.getStringExtra("Ip adress");
            porp = recv.getStringExtra("Port");
            port = Integer.parseInt(porp);
        } catch (Exception e) {
            ;
        }


    }

    public void Last_Page(View view) {
        Intent lmafao = new Intent(Page2.this, MainActivity.class);
        lmafao.putExtra("Ip adress", ip);
        lmafao.putExtra("Port", porp);
        startActivity(lmafao);
    }

    public void Next_Page(View view) {
        Intent lmaopro = new Intent(Page2.this, Pro3.class);
        lmaopro.putExtra("Ip adress", ip);
        lmaopro.putExtra("Port", porp);
        startActivity(lmaopro);

    }

    public void Pro(View view) throws IOException {
        EditText gg = findViewById(R.id.TxtInput_1000);
        String ss = gg.getText().toString();

        if(TextUtils.isEmpty(ip) || port < 100) {
            Toast.makeText(getApplicationContext(), "First Connect to your computer!", Toast.LENGTH_SHORT).show();
        }else{
            Godammit thread = new Godammit(ss);
            thread.start();
        }

        kko = findViewById(R.id.textView_9000);
        kko.setText(sfx);
    }





    }

    class Godammit extends Thread {

        static Socket Karma;
        static PrintWriter pro;
        static String foo;
        static byte size_buff[];

        Page2 n = new Page2();

        Godammit(String foo) {
            this.foo = foo;
        }

        @Override
        public void run() {
            try {


                    Karma = new Socket(n.ip, n.port);
                    pro = new PrintWriter(Karma.getOutputStream());
                    pro.println("lir" + foo);
                    pro.flush();
                    InputStream nooob = Karma.getInputStream();
                    size_buff = new byte[1024];
                    nooob.read(size_buff);
                    String j = new String(size_buff);
                    n.sfx = j;
                    Karma.close();



            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                ;
            }
        }


    }
