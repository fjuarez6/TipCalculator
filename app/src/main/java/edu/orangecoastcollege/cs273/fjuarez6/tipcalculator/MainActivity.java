package edu.orangecoastcollege.cs273.fjuarez6.tipcalculator;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static NumberFormat percent = NumberFormat.getPercentInstance();


    private EditText amountEditText;
    private TextView amountTextView;
    private TextView tipPercentTextView;
    private TextView tipAmountTextView;
    private TextView totalAmountTextView;
    private SeekBar percentSeekBar;

    //Associates the controller with the needed
    RestaurantBill currentBill = new RestaurantBill();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountEditText = (EditText) findViewById(R.id.amountEditText);
        amountTextView = (TextView) findViewById(R.id.amountTextView);
        tipPercentTextView = (TextView) findViewById(R.id.tipPercentTextView);
        tipAmountTextView = (TextView) findViewById(R.id.tipAmountTextView);
        totalAmountTextView = (TextView) findViewById(R.id.totalAmountTextView);
        percentSeekBar = (SeekBar) findViewById(R.id.percentSeekBar);

        amountEditText.addTextChangedListener(amountTextChangedListener);

        //Define a listener for the percentSeekBar (onProgressChanged)
        percentSeekBar.setOnSeekBarChangeListener(percentChangedListener);

        currentBill.setTipPercent(0.20);
    }

    TextWatcher amountTextChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try {
                double amount = Double.parseDouble(s.toString()) / 100.0;
                currentBill.setAmount(amount);
            }

            catch (NumberFormatException e)
            {
                amountEditText.setText("");
            }

            //No exception, input is valid:
            // 1) Set the bill amount (amountTextView)
            amountTextView.setText(currency.format(currentBill.getAmount()));
            updateViews();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private SeekBar.OnSeekBarChangeListener percentChangedListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            //Update the model with the new tip amount
            currentBill.setTipPercent(progress / 100.0);

            //Update the percentTextView
            tipPercentTextView.setText(percent.format(currentBill.getTipPercent()));

            //Update the views
            updateViews();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void updateViews()
    {
        // 2)  Set the tip amount (tipTextView)
        tipAmountTextView.setText(currency.format(currentBill.getTipAmount()));
        // 3) Set the total amount (totalAmountTextView)
        totalAmountTextView.setText(currency.format(currentBill.getTotalAmount()));
    }
}
