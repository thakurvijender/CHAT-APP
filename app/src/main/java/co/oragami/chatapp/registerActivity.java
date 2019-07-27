package co.oragami.chatapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registerActivity extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTextView1,autoCompleteTextView2;
    private EditText editText,editText1;
    private Button button1;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        autoCompleteTextView1= findViewById(R.id.mUsername);
        autoCompleteTextView2= findViewById(R.id.mEmailView);
        editText= findViewById(R.id.mPasswordField);
        editText1= findViewById(R.id.mConfirm_Password);
        button1= findViewById(R.id.register);

        editText1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
               if(i==200||i== EditorInfo.IME_NULL){
                   register();
                   return  true;
               }

                return false;
            }
        });

       firebaseAuth= FirebaseAuth.getInstance();


    }


    public void call(View V){
        register();
    }

    public void register(){

        String mail= autoCompleteTextView2.getText().toString();
        String password=editText.getText().toString();

    autoCompleteTextView2.setError(null);
    editText1.setError(null);

    boolean cancel = false;
        View focus_View=null;

    if(TextUtils.isEmpty(password)|| !isPassword_correct(password)){
        editText1.setError("password either too short or does not match");
        focus_View=editText1;
        cancel=true;
    }

    if(TextUtils.isEmpty(mail)){
        autoCompleteTextView2.setError("this field is required");
        focus_View=autoCompleteTextView2;
        cancel=true;

        }
    if(!isEmail_corerct(mail)){
        autoCompleteTextView2.setError("enter a valid E-mail");
        focus_View=autoCompleteTextView2;
        cancel=true;
    }

    if(cancel){
        focus_View.requestFocus();

    }else{
        new_acount();
    }

    }
    public boolean isEmail_corerct(String mail){

        return mail.contains("@");

    }

    public boolean isPassword_correct(String password){

        String ConfirmPassword= editText1.getText().toString();

        return ConfirmPassword.equals(password)&&password.length()>7;



    }

    public   void new_acount(){
        String mail= autoCompleteTextView2.getText().toString();
        String password=editText.getText().toString();


        firebaseAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                }
            }
        });
    }
}
