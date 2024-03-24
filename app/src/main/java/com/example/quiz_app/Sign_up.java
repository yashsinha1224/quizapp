package com.example.quiz_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
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

public class Sign_up extends AppCompatActivity {
    TextView login_text;
    TextView Sign_text;
    Button login_btn;
    Button sign_btn;
    EditText user_name;
    EditText password;
    EditText name;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        sign_btn=findViewById(R.id.button2);
        login_text=findViewById(R.id.textView);
        login_btn=findViewById(R.id.button);
        fauth=FirebaseAuth.getInstance();
        name=findViewById(R.id.editText);
        Sign_text=findViewById(R.id.textView2);
        user_name=findViewById(R.id.editText2);
        password=findViewById(R.id.editText3);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(Sign_up.this,Login.class);
                startActivity(j);
            }
        });
        sign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=name.getText().toString();
                String b=user_name.getText().toString();
                String c=password.getText().toString();
                if (TextUtils.isEmpty(b) || TextUtils.isEmpty(c)) {
                    Toast.makeText(Sign_up.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(b).matches()) {
                    Toast.makeText(Sign_up.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                    return;
                }
                fauth.createUserWithEmailAndPassword(b,c).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Sign_up.this,"sign up successful",
                                    Toast.LENGTH_SHORT).show();
                            Intent k=new Intent(Sign_up.this,quiz_body.class);
                            startActivity(k);
                        }
                        else{Toast.makeText(Sign_up.this,"Please check the provided info and try again",
                                Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}