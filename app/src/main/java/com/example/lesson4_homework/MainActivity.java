package com.example.lesson4_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonC , buttonDel , buttonPorM , buttonPercent , buttonDevide , buttonMultiply , buttonMinus , buttonPlus , buttonDot ;
    Button buttonEqual , button0 , button1 , button2 , button3 , button4 , button5 , button6 , button7 , button8 , button9 ;
    TextView textV , textHistory;
    String symbol, firstNumber , secondNumber , strHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitViews();
        numberMethods();
        CleanPorM();
        allFunctions();//
    }
    public void InitViews() {
        buttonC = findViewById(R.id.btnC);
        buttonDel = findViewById(R.id.btnDel);
        buttonPorM = findViewById(R.id.btnPorM);
        buttonPercent = findViewById(R.id.btnPercent);
        buttonDevide = findViewById(R.id.btnDevide);
        buttonMultiply = findViewById(R.id.btnMultipy);
        buttonMinus = findViewById(R.id.btnMinus);
        buttonPlus = findViewById(R.id.btnPlus);
        buttonDot = findViewById(R.id.btnDot);
        buttonEqual = findViewById(R.id.btnEqual);

        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        textV = findViewById(R.id.textview);
        textHistory = findViewById(R.id.txtHistory);
    }

    public void numberMethods() {
        View.OnClickListener btnNumbers = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String prevNum = textV.getText().toString();
                String clickedNum = "";
                String resultNum = "";
                switch (view.getId()) {
                    case R.id.btnDot:
                        if (prevNum.contains(".")) {
                            clickedNum = "";
                        }
                        else {
                            clickedNum = ".";
                        }
                        break ;

                    case R.id.btn0 :
                        clickedNum = "0";
                        break ;

                    case R.id.btn1 :
                        clickedNum = "1";
                        break ;

                    case R.id.btn2 :
                        clickedNum = "2";
                        break ;

                    case R.id.btn3 :
                        clickedNum = "3";
                        break ;

                    case R.id.btn4 :
                        clickedNum = "4";
                        break ;

                    case R.id.btn5 :
                        clickedNum = "5";
                        break ;

                    case R.id.btn6 :
                        clickedNum = "6";
                        break ;

                    case R.id.btn7 :
                        clickedNum = "7";
                        break ;

                    case R.id.btn8 :
                        clickedNum = "8";
                        break ;

                    case R.id.btn9 :
                        clickedNum = "9";
                        break ;
                }
                if (!prevNum.equals("0")) resultNum = prevNum + clickedNum;
                else resultNum = clickedNum;
                textV.setText(resultNum);
            }
        };

        buttonDot.setOnClickListener(btnNumbers);
        button0.setOnClickListener(btnNumbers);
        button1.setOnClickListener(btnNumbers);
        button2.setOnClickListener(btnNumbers);
        button3.setOnClickListener(btnNumbers);
        button4.setOnClickListener(btnNumbers);
        button5.setOnClickListener(btnNumbers);
        button6.setOnClickListener(btnNumbers);
        button7.setOnClickListener(btnNumbers);
        button8.setOnClickListener(btnNumbers);
        button9.setOnClickListener(btnNumbers);
    }

    public void CleanPorM() {
        View.OnClickListener btnCleanPorM = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnC:
                        textV.setText("0");
                        textHistory.setText("0");
                        break;

                    case R.id.btnPorM:
                        String numText = textV.getText().toString();
                        int number = Integer.parseInt(numText);

                        if (number > 0) textV.setText("-" + numText);
                        else {
                            number = number * (-1);
                            textV.setText("" + number);
                        }
                        break;

                }
            }
        };

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = textV.getText().toString();
                s=s.substring(0 , s.length() - 1);
                textV.setText(s);
            }
        });

        buttonC.setOnClickListener(btnCleanPorM);
        buttonPorM.setOnClickListener(btnCleanPorM);
    }

    public void allFunctions() {
        View.OnClickListener btnFunctions = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNumber = textV.getText().toString();
                switch (view.getId()) {
                    case R.id.btnPlus:
                        symbol = " + " ;
                        break;
                    case R.id.btnMinus:
                        symbol = " - " ;
                        break;
                    case R.id.btnMultipy:
                        symbol = " * " ;
                        break;
                    case R.id.btnDevide:
                        symbol = " / " ;
                        break;
                    case R.id.btnPercent:
                        symbol = " % " ;
                        break;
                }
                strHistory = firstNumber + symbol;
                textHistory.setText(strHistory);
                textV.setText("0");
            }
        };

        buttonPlus.setOnClickListener(btnFunctions);
        buttonMinus.setOnClickListener(btnFunctions);
        buttonMultiply.setOnClickListener(btnFunctions);
        buttonDevide.setOnClickListener(btnFunctions);
        buttonPercent.setOnClickListener(btnFunctions);

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondNumber = textV.getText().toString();
                double result = 0;
                if (strHistory.contains(".")) {
                    double num1 = Double.parseDouble(firstNumber);
                    double num2 = Double.parseDouble(secondNumber);

                    if (symbol.equals(" + ")) {
                        result = num1 + num2 ;
                    }
                    else if (symbol.equals(" - ")){
                        result = num1 - num2 ;
                    }
                    else if (symbol.equals(" * ")){
                        result = num1 * num2 ;
                    }
                    else if (symbol.equals(" / ")){
                        result = num1 / num2 ;
                    }
                    else if (symbol.equals(" % ")){
                        result = num1 % num2 ;
                    }
                }
                else {
                    int num1 = Integer.parseInt(firstNumber);
                    int num2 = Integer.parseInt(secondNumber);
                    if (symbol.equals(" + ")) {
                        result = num1 + num2;
                    }
                    else if (symbol.equals(" - ")) {
                        result = num1 - num2;
                    }
                    else if (symbol.equals(" * ")) {
                        result = num1 * num2;
                    }
                    else if (symbol.equals(" / ")) {
                        result = num1 / num2;
                    }
                    else if (symbol.equals(" % ")){
                        result = num1 % num2 ;
                    }
                }
                strHistory = firstNumber + symbol + secondNumber + " = " + result;
                textHistory.setText(strHistory);
                textV.setText("" + result);
            }
        });
    }
}