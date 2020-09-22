package com.example.totaltime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double value1 =5;
    double value2 = 10;
    double first,second;
    int i =0;
    int minuteFirstFromString;
    int hourFirstFromString,hourFirstFromString1,minuteFirstFromString1;
    EditText numberEntry;


    public static final String EXTRA_MESSAGE = "com.example.totaltime.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView resultView = findViewById(R.id.resultView);
        TextView Number1 = findViewById(R.id.hours1);
       // Number1.setText("" + value1);
        TextView Number2 = findViewById(R.id.hours2);
       // Number2.setText("" + value2);
        numberEntry = findViewById(R.id.numberEntry);

        numberEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberEntry.setText("");
            }

        });
    }









    /** called when user taps send button */

    public void sendMessage(View view){

        Intent intent = new Intent (this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity (intent);

    }
    // do something in response to button

    public void onSubmitClick (View view){
        TextView Answer = findViewById(R.id.resultView);
        //EditText Attempt = findViewById(R.id.numberEntry);
        TextView Result= findViewById(R.id.TotalMinutesView);
        String tester=numberEntry.getText().toString();
        if (tester.matches("")){
            return; //checks that there is data in the field
        }

       double userAnswer = Double.parseDouble(numberEntry.getText().toString());
       // int userAnswer = Integer.parseInt(Attempt.getText().toString());
        if(userAnswer == value1+value2) {
            Answer.setText("Correct!");

        } else {
           // Answer.setText("Wrong, the correct answer was: " + (value1+value2));
        }
        if(i==0) {
            first=userAnswer;
            String xHour = numberEntry.getText().toString();
            String[] separated = xHour.split("\\.");
             hourFirstFromString = Integer.parseInt(separated[0]);
             minuteFirstFromString = Integer.parseInt(separated[1]);

             if (minuteFirstFromString>59){
                numberEntry.setText("CHECK MINUTES!"); //capture error
                 return;
             }

            TextView firstHour = findViewById(R.id.hours1);
            TextView firstMinute = findViewById(R.id.minutes1);
            int infrontOfDecimal = ((int)first); // remove numbers after decimal
            double FirstHours=infrontOfDecimal; //convert to double

           double FirstMinutes = ((first - FirstHours)*100); //convert decimal minutes to minutes

           int IntFirstHour = (int)FirstHours; //convert double to int for display
            int IntFirstMinute = (int)FirstMinutes; //convert double to int for display
            firstHour.setText(String.valueOf(IntFirstHour));

            firstHour.setText(String.valueOf(hourFirstFromString)+" :");

            if (minuteFirstFromString <10){
                firstMinute.setText(String.valueOf("0"+minuteFirstFromString));// show first hours
            }
            else {
                firstMinute.setText(String.valueOf(minuteFirstFromString));// show first hours
            }
        } else {
            second=userAnswer;

            TextView firstHour = findViewById(R.id.hours2);
            TextView firstMinute = findViewById(R.id.minutes2);


            String xHour = numberEntry.getText().toString();
            String[] separated = xHour.split("\\.");
             hourFirstFromString1 = Integer.parseInt(separated[0]);
             minuteFirstFromString1 = Integer.parseInt(separated[1]);
            if (minuteFirstFromString1>59){
                numberEntry.setText("CHECK MINUTES!"); //capture error
                return;
            }
         //   TextView secondNumber = findViewById(R.id.hours2);
            String stringdouble= Double.toString(userAnswer);
        //    secondNumber.setText(stringdouble);
            firstHour.setText(String.valueOf(hourFirstFromString1)+" :");

            if (minuteFirstFromString1 <10){
                firstMinute.setText(String.valueOf("0"+minuteFirstFromString1));// show first hours
            }
            else {
                firstMinute.setText(String.valueOf(minuteFirstFromString1));// show first hours
                // firstMinute.setText(String.valueOf(minuteFirstFromString1));// show first hours
            }

                //do calculation
                double totalMinutes = ((minuteFirstFromString1 + minuteFirstFromString));
                double divideBySixty = (totalMinutes / 60);
                int addHour = (int) divideBySixty;
                double remainingMinutes = (divideBySixty - addHour);
                remainingMinutes = (remainingMinutes * 60);
                int a = (int) Math.round(remainingMinutes);
                // Answer.setText(String.valueOf(a));
                TextView finalHours = findViewById(R.id.TotalHoursView);
                int b = (int) addHour + hourFirstFromString + hourFirstFromString1;
                finalHours.setText(String.valueOf(b) + " :");
                TextView results=findViewById(R.id.resultView);
                 results.setVisibility(View.VISIBLE);
                TextView finalMinutes = findViewById(R.id.TotalMinutesView);
                if (a < 10) {
                    finalMinutes.setText(String.valueOf("0" + a));
                } else {
                    finalMinutes.setText(String.valueOf(a));
                }




        }
        i++;
       // String stringdouble= Double.toString(userAnswer);
       // Result.setText(stringdouble);
        numberEntry.setText("");
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        //TextView finalResult = findViewById(R.id.TotalMinutesView);
       // double finalResultDouble;

        //finalResultDouble=(first+second);
       // String stringdouble1= Double.toString(finalResultDouble);
       // finalResult.setText(stringdouble1);


        if (i>1) {
            i=0;}
        }


    }

