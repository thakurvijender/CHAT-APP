package co.oragami.chatapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.ExportedUserRecord;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.ListUsersPage;

public class MainChat extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseOptions options;
    EditText message_field;
    ImageButton send;
    private String mSisplay_name,message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chat);
        mAuth = FirebaseAuth.getInstance();
        message_field= findViewById(R.id.messageInput);
        send=  findViewById(R.id.sendButton);

         message= message_field.getText().toString();


    }
    public void get_user()
    {
        SharedPreferences prefs= getSharedPreferences(registerActivity.CHAT_PREFS,MODE_PRIVATE);
        mSisplay_name=prefs.getString(registerActivity.DIAPLAY_NAME_KEY,null);

        if(mSisplay_name==null){
            mSisplay_name="anonymous";
        }
    }

}
