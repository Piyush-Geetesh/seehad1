package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button zero,one, two, three, four, five, six, seven, eight,nine;
    Button add,subtract,equal;
    WebView wv;

    EditText result;
    String operatorPressed="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "lol", Toast.LENGTH_SHORT).show();

        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        equal = findViewById(R.id.equal);
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);

        result = findViewById(R.id.result);
//wv=findViewById(R.id.web);
//wv.loadUrl("https://stackoverflow.com/questions/30637654/android-webview-gives-neterr-cache-miss-message");

        // Buttons
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        equal.setOnClickListener(this);
// operators
        add.setOnClickListener(this);
        subtract.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        double finalResult=0;

        switch (view.getId()){
            case R.id.one :
                result.append("1");
                break;

            case R.id.two: result.append("2");
                break;

// case for rest of the button 3-9 here
            case R.id.add:
                result.append("+");
                operatorPressed="+";
                break;
            case R.id.subtract: result.append("-");
                operatorPressed="-";
                break;
            case R.id.equal: finalResult=
                    evaluateExpression(result.getText().toString(),operatorPressed);
                result.setText(String.valueOf(finalResult));
                break;
// evaluateExpression function is the function we use to compute the
            //expression it takes the expression and operatorpressed as input and
            //returns a string
            default:return;
        }
    }

    private double evaluateExpression(String res, String operatorPressed) {

        String[] tokens = res.split("\\+|-|\\*|\\/"); // split for +, -, *,/ operator
// After split tokens[0] = first half of the string, tokens[1] = second half
        //of the string
        double firstOperand = Double.parseDouble(tokens[0]); //convert string to double
        double secondOperand = Double.parseDouble(tokens[1]);
        switch(operatorPressed)
        {
            case "+": return firstOperand + secondOperand;
            case "-": return firstOperand - secondOperand;
            case "*": return firstOperand * secondOperand;
            case "/": return firstOperand / secondOperand;
            default: return 0;
        }

    }
}