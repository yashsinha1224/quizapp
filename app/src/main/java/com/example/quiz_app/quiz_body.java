package com.example.quiz_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class quiz_body extends AppCompatActivity {
    Button good_button ;
    TextView tnt;
    private RecyclerView recyclerView;
    Button good_button1;
    Button good_buttton2;
    Button good_button3;





    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz_body);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        good_button=findViewById(R.id.goodbut);
        good_button1=findViewById(R.id.button3);
        good_buttton2=findViewById(R.id.button4);
        good_button3=findViewById(R.id.button5);
        good_buttton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p =new Intent(quiz_body.this, quiz2.class);
                startActivity(p);
            }
        });
        good_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l=new Intent(quiz_body.this,quiz3.class);
                startActivity(l);
            }
        });
        good_button1.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(quiz_body.this, quiz1.class);
                startActivity(r);
            }
        }));
        good_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent o=new Intent(quiz_body.this, Login.class);
                startActivity(o);
            }
        });



    }
}