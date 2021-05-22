package com.example.lettryapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.net.*;
import java.io.*;

public class Pro3 extends AppCompatActivity {

    static String ip;
    static String port;
    static String kol;
    static String lmao;
    static int gogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro3);
        try {
            Intent recv = getIntent();
            ip = recv.getStringExtra("Ip adress");
            port = recv.getStringExtra("Port");
            gogo = Integer.parseInt(port);
        }catch(Exception p) {
            ;
        }

    }

    public void kkkk(View view) {
        EditText kk = findViewById(R.id.FFFF);
        lmao = kk.getText().toString();
        if(TextUtils.isEmpty(ip) || gogo == 0) {
            Toast.makeText(getApplicationContext(), "First connect to your computer!", Toast.LENGTH_SHORT).show();
        }else {
            Nooper thread = new Nooper(lmao);
            thread.start();
        }

    }


    public void Next_Page(View view) {
        Intent lop = new Intent(Pro3.this , Pro4.class);
        lop.putExtra("Ip" , ip);
        lop.putExtra("port" , port);
        startActivity(lop);

    }

    public void Last_Pagepp(View view) {
        Intent lol = new Intent(Pro3.this , Page2.class);
        lol.putExtra("Ip adress" , ip);
        lol.putExtra("Port" , port);
        startActivity(lol);
    }

}


class Nooper extends Thread {
    static Socket Karma;
    static PrintWriter pro;
    static String foo;
    Pro3 kko = new Pro3();


    Nooper(String foo) {
        this.foo = foo;
    }

    @Override
    public void run() {
        try {
            Karma = new Socket(kko.ip , kko.gogo);
            pro = new PrintWriter(Karma.getOutputStream());
            pro.println("set" + foo);
            pro.flush();
            InputStream nooob = Karma.getInputStream();
            byte[] size_buff = new byte[1024];
            nooob.read(size_buff);
            String j = new String(size_buff);
            kko.kol = j;
            Karma.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            ;
        }
    }
}