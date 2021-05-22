package com.example.lettryapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Pro4 extends AppCompatActivity {
    static String fall;
    static String kill;
    static int gsf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro4);
        try {
            Intent hhh = getIntent();
            fall = hhh.getStringExtra("Ip");
            kill = hhh.getStringExtra("port");
            gsf = Integer.parseInt(kill);

        }catch(Exception e) {
            ;
        }

    }

    public void Noob(View view) {
        EditText lol = findViewById(R.id.Noop);
        String jj = lol.getText().toString();
        if(TextUtils.isEmpty(fall) || gsf == 0) {
            Toast.makeText(getApplicationContext(), "First connect to your computer!", Toast.LENGTH_SHORT).show();
        }else {
            Pooper thread = new Pooper(jj);
            thread.start();
        }

    }


    public void Pro(View view) {
        EditText drop = findViewById(R.id.porv);
        String ha = drop.getText().toString();
        if(TextUtils.isEmpty(fall) || gsf == 0) {
            Toast.makeText(getApplicationContext(), "First connect to your computer!", Toast.LENGTH_SHORT).show();
        }else{
            Poopesr jawdrop = new Poopesr(ha);
            jawdrop.start();
        }


    }

    public void Next_Page(View View) {
        Intent dawg = new Intent(Pro4.this , Pro5.class);
        dawg.putExtra("ip" , fall);
        dawg.putExtra("port" , kill);
        startActivity(dawg);
    }



    public void Last_Page(View view) {
        Intent lol = new Intent(Pro4.this , Pro3.class);
        lol.putExtra("Ip adress" ,fall);
        lol.putExtra("Port" , kill);
        startActivity(lol);
    }


}

class Pooper extends Thread {
    static Socket Karma;
    static PrintWriter pro;
    static String foo;

    Pooper(String foo) {
        this.foo = foo;
    }
    Pro4 slow = new Pro4();

    @Override
    public void run() {
        try {
            Karma = new Socket(slow.fall , slow.gsf);
            pro = new PrintWriter(Karma.getOutputStream());
            pro.println("maf" + foo);
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



class Poopesr extends Thread {
    static Socket Karma;
    static PrintWriter pro;
    static String foo;

    Poopesr(String foo) {
        this.foo = foo;
    }
    Pro4 slow = new Pro4();

    @Override
    public void run() {
        try {
            Karma = new Socket(slow.fall , slow.gsf);
            pro = new PrintWriter(Karma.getOutputStream());
            pro.println("mag" + foo);
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