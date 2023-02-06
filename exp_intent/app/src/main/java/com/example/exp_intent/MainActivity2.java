package com.example.exp_intent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle extras = getIntent().getExtras();
        int sum = extras.getInt("ans");
        Toast.makeText(this, "The sum is "+sum, Toast.LENGTH_SHORT).show();
        TextView t1 = (TextView) findViewById(R.id.textView6);
        t1.setText("The sum is "+sum);
    }
}