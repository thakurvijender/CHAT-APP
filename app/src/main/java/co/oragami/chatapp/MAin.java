package co.oragami.chatapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MAin extends AppCompatActivity {
    Button sign_in,log_in;
    EditText mPassword,m_Email;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    sign_in= findViewById(R.id.register);
    log_in=findViewById(R.id.login);
    m_Email=findViewById(R.id.E_mail);
    mPassword=findViewById(R.id.mPasswordField_1);
    mAuth=FirebaseAuth.getInstance();

    sign_in.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent new_intent = new Intent(MAin.this,registerActivity.class);
            startActivity(new_intent);
        }
    });
    }
    public void enter(View V){
        sign_in();
    }


    public void sign_in(){
        String Email=m_Email.getText().toString();
        String password=mPassword.getText().toString();
        mAuth.signInWithEmailAndPassword(Email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent new_intent= new Intent(MAin.this,MainChat.class);
                    finish();
                    startActivity(new_intent);
                }else{
                    Log.d("chatapp","failed to sigh in");
                    Log.d("chatapp","error "+task.getException().toString());
                }
            }
        });


    }
}
