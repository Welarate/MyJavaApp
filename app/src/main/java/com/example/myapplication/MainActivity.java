package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOError;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextView result;
    Double operand = null;
    String last_opertaion = "=";
    Integer first_two = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);
    }



    public void onNumberClick(View v) {
        Button button = (Button) v;
        result.append(button.getText());

    }

    public void onButtonClickRem(View v) {
        result = (TextView) findViewById(R.id.result);
        if (result.length() > 0) {
            String s = result.getText().toString();
            s = s.substring(0, s.length() - 1);
            result.setText(s);
        }
    }

    String button_char = "";

    int num_one = 0;
    int num_two = 0;
    String operation = "";
    int k = 0;
    int sum = 0;
    int kol_vo_chifr = 0;
    public void operation(View v) {

        if (((Button) v).getText().toString().contains("AC")) {
            result.setText("");
        } else {
            result = (TextView) findViewById(R.id.result);
            String text = result.getText().toString();
            Button b = (Button) v;


            if(k == 0 && text.length()>0){
                if(b.getText().toString().equals("=")){
                } else {
                        num_one = Integer.parseInt(text);
                        operation = b.getText().toString();
                        result.append(" "  + operation + " ");
                        k = 1;
                        kol_vo_chifr = result.getText().length();
                }

            }
            else {
                if(text.length()>0) {
                    if(text.length() == kol_vo_chifr){

                    } else {
                        String[] q = text.split(" ");
                        num_two = Integer.parseInt(q[2]);
                        switch (operation) {
                            case "+":
                                sum = num_one + num_two;
                                break;
                            case "-":
                                sum = num_one - num_two;
                                break;
                            case "*":
                                sum = num_one * num_two;
                                break;
                            default:
                                break;
                        }
                        String w = Integer.toString(sum);
                        result.setText(w);
                        sum = 0;
                        num_one = 0;
                        num_two = 0;
                        operation = "";
                        k = 0;
                        kol_vo_chifr = 0;
                    }
                }

            }
        }

        /*if (text == "") {

        } else {
            System.out.println(text.length());
            if (((Button) v).getText().toString().contains("AC")) {
                result.setText("");
            } else {
                if (button_char == "") {
                    button_char = b.getText().toString();
                    result.setText(text + " " + button_char + " ");
                } else {
                    String[] q = text.split(" ");

                    int num_one = Integer.parseInt(q[0]);
                    int num_two = Integer.parseInt(q[2]);
                    int sum = 0;
                    switch (button_char) {
                        case "+":
                            sum = num_one + num_two;
                            break;
                        case "-":
                            sum = num_one - num_two;
                            break;
                        case "*":
                            sum = num_one * num_two;
                            break;
                        default:
                            break;
                    }
                    String w = Integer.toString(sum);
                    result.setText(w);
                    button_char = "";
                }
            }
        }*/

    }
    

}