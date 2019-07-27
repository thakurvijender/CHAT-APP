package co.oragami.chatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class loginactivity extends AppCompatActivity {

    EditText mail;
    EditText password;
    Button login, register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        mail= findViewById(R.id.mEmailView);
        password= findViewById(R.id.mPasswordField);
        login= findViewById(R.id.login);
        register= findViewById(R.id.register);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_Intent= new Intent(loginactivity.this,registerActivity.class);
                startActivity(new_Intent);
            }
        });


    }
}
