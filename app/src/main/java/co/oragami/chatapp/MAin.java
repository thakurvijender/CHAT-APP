package co.oragami.chatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MAin extends AppCompatActivity {
    Button bt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    bt1= findViewById(R.id.register);

    bt1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent new_intent = new Intent(MAin.this,registerActivity.class);
            startActivity(new_intent);
        }
    });
    }
}
