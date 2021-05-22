package com.example.lettryapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Pro6 extends AppCompatActivity {

    static String murder;
    static String life;
    static String return_code;
    static int gfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro6);
        try {
            Intent kill = getIntent();
            murder = kill.getStringExtra("ip");
            life = kill.getStringExtra("port");
            gfx = Integer.parseInt(life);
        }catch(Exception ew)  {
            ;
        }

        }




    public void good(View view) {
        EditText grave = findViewById(R.id.spsc3);
        String graveyard = grave.getText().toString();
        if(TextUtils.isEmpty(murder) && gfx == 0 ) {
            Toast.makeText(getApplicationContext(), "First connect to your computer!", Toast.LENGTH_SHORT).show();
        }else{
            hell thread = new hell(graveyard);
            thread.start();
        }
        TextView kol = findViewById(R.id.Holy1);
        kol.setText(return_code);

    }

    public void Last_Noob(View view) {
        Intent bad = new Intent(Pro6.this , Pro5.class);
        bad.putExtra("ip" , murder);
        bad.putExtra("port" , life);
        startActivity(bad);
    }

    public void sleep(View view) {
        if(TextUtils.isEmpty(murder) && gfx == 0 ) {
            Toast.makeText(getApplicationContext(), "First connect to your computer!", Toast.LENGTH_SHORT).show();
        }else{
            heaven soul = new heaven();
            soul.start();
        }

        TextView kk = findViewById(R.id.Holy1);
        kk.setText(return_code);
    }

}



class hell extends Thread {
    static Socket Karma;
    static PrintWriter pro;
    static String foo;

    hell(String foo) {
        this.foo = foo;
    }
    Pro6 slow = new Pro6();

    @Override
    public void run() {
        try {
            Karma = new Socket(slow.murder, slow.gfx);
            pro = new PrintWriter(Karma.getOutputStream());
            pro.println("cmd" + foo);
            pro.flush();
            InputStream nooob = Karma.getInputStream();
            byte[] size_buff = new byte[4024];
            nooob.read(size_buff);
            String j = new String(size_buff);
            slow.return_code = j;
            Karma.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {

        }
    }

}

class heaven extends Thread {
    static Socket Karma;
    static PrintWriter pro;
    static String foo;


    Pro6 slow = new Pro6();

    @Override
    public void run() {
        try {
            Karma = new Socket(slow.murder , slow.gfx);
            pro = new PrintWriter(Karma.getOutputStream());
            pro.println("shutdown");
            pro.flush();
            Karma.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            ;
        }
    }

}