package com.example.quiz_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    TextView login_text;
    TextView Sign_text;
    Button login_btn;
    Button sign_btn;
    EditText user_name;
    EditText password;
    FirebaseAuth fauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        sign_btn=findViewById(R.id.button);
        login_text=findViewById(R.id.textView);
        login_btn=findViewById(R.id.button2);
        Sign_text=findViewById(R.id.textView2);
        user_name=findViewById(R.id.editText);
        password=findViewById(R.id.editText2);
        fauth=FirebaseAuth.getInstance();
        sign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(Login.this,Sign_up.class);
                startActivity(j);
            }
        });
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=user_name.getText().toString().trim();
                String Password=password.getText().toString().trim();
                Toast.makeText(Login.this,"username is   ",
                Toast.LENGTH_SHORT).show();
                Toast.makeText(Login.this,"password is   ",
                        Toast.LENGTH_SHORT).show();
                fauth.signInWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this,"login successful",
                                    Toast.LENGTH_SHORT).show();
                            Intent l=new Intent(Login.this,quiz_body.class);
                            startActivity(l);

                        }
                        else{
                            Toast.makeText(Login.this,"erorr either email or password is wrong",
                                    Toast.LENGTH_SHORT).show();


                        }

                    }
                });
            }
        });

    }
}