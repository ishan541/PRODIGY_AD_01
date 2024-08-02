package com.example.internship_calculater;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    double result=0;
    boolean isOpenBracket = false;
    TextView viewe;
    private String operand1 = "";
    private String operand2 = "";
    private char operator = ' ';
    private boolean isOperand1Completed = false;
    double firstnum=0;
    double secondnum=0;
    String operation="";
    int len;
    double ans;
    Button bt_AC, bt7, bt1, bt2, bt3, bt4, bt5, bt6, bt8, bt9, bt0, bt_d, bt_b, bt_e, bt_p, bt_mi, bt_mu, bt_div, bt_colon, bt_modulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewe = findViewById(R.id.view);

        bt_AC = findViewById(R.id.AC_button);
        bt1 = findViewById(R.id.one_button);
        bt2 = findViewById(R.id.two_button);
        bt3 = findViewById(R.id.three_button);
        bt4 = findViewById(R.id.four_button);
        bt5 = findViewById(R.id.five_button);
        bt6 = findViewById(R.id.six_button);
        bt7 = findViewById(R.id.seven_button);
        bt8 = findViewById(R.id.eight_button);
        bt9 = findViewById(R.id.nine_button);
        bt0 = findViewById(R.id.zero_button);
        bt_d = findViewById(R.id.dot_button);
        bt_b = findViewById(R.id.back_button);
        bt_e = findViewById(R.id.equal_button);
        bt_p = findViewById(R.id.plus_button);
        bt_mi = findViewById(R.id.minus_button);
        bt_mu = findViewById(R.id.muulti_button);
        bt_div = findViewById(R.id.div_button);
        bt_colon = findViewById(R.id.colon_button);
        bt_modulo = findViewById(R.id.modulo_button);
        ArrayList<Button> number = new ArrayList<>();
        number.add(bt0);
        number.add(bt1);
        number.add(bt2);
        number.add(bt3);
        number.add(bt4);
        number.add(bt5);
        number.add(bt6);
        number.add(bt7);
        number.add(bt8);
        number.add(bt9);
        for (Button b : number) {
            b.setOnClickListener(view -> {
                if (!viewe.getText().toString().equals("0")) {
                    viewe.setText(viewe.getText().toString() + b.getText().toString());
                } else {
                    viewe.setText(b.getText().toString());
                }
            });
        }
        //opers
        ArrayList<Button> opers = new ArrayList<>();
        opers.add(bt_p);
        opers.add(bt_mi);
        opers.add(bt_mu);
        opers.add(bt_div);
        for (Button b : opers) {
            b.setOnClickListener(view -> {
                firstnum = Double.parseDouble(viewe.getText().toString());
                len=viewe.getText().length();
                operation = b.getText().toString();
                viewe.setText(viewe.getText().toString() + b.getText().toString());
            });
        }

        //for clear bt
        bt_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeLastCharacter();
            }

            private void removeLastCharacter() {
                String currentText = viewe.getText().toString();
                if (!currentText.isEmpty()) {
                    String newText = currentText.substring(0, currentText.length() - 1);
                    viewe.setText(newText);
                }
            }
        });
        //for all clear bt
        bt_AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearInput();
            }

            private void clearInput() {
                operand1 = "";
                operand2 = "";
                operator = ' ';
                isOperand1Completed = false;
                viewe.setText("0");

            }
        });
        bt_modulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstnum = Double.parseDouble(viewe.getText().toString());
                System.out.println(firstnum);
                result=(firstnum)/(100);
                System.out.println(result);
                viewe.setText(String.valueOf(result));
                firstnum = result;

            }
        });
        bt_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (!viewe.getText().toString().contains(".")){
//
                    viewe.setText(viewe.getText().toString()+".");
//                }else {
//                    viewe.setText(".");
//                }
            }
        });
        //for bracket
        bt_colon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOpenBracket) {
                    isOpenBracket = false;// Update state to closing bracket
                    viewe.setText(viewe.getText() + ")");

                } else {
                    isOpenBracket = true; // Update state to opening bracket
                    viewe.setText(viewe.getText() + "(");

                }
            }
        });

        //for equal button
        bt_e.setOnClickListener(view -> {
            String current=viewe.getText().toString();
            System.out.println(current.substring(len));
            secondnum = Double.parseDouble(current.substring(++len));

            switch (operation) {
                case "/":
                    System.out.println("div");
                    result = firstnum / secondnum;
                    break;
                case "+":
                    System.out.println("pluse");
                    result = firstnum + secondnum;
                    break;
                case "x":
                    System.out.println("multi");
                    result = firstnum * secondnum;
                    break;
                case "-":
                    System.out.println("minus");
                    System.out.println(firstnum);
                    System.out.println(secondnum);
                    result = firstnum - secondnum;
                    break;
               /* case "%":
                    System.out.println(firstnum);
                    result=(firstnum)*(1/100);
                    System.out.println(result);
                    break;*/
            }
            viewe.setText(String.valueOf(result));
            firstnum = result;
        });
    }
}