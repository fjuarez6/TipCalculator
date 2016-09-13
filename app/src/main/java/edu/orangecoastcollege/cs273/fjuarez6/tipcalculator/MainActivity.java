package edu.orangecoastcollege.cs273.fjuarez6.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText amountEdittext;
    private TextView amountTextView;
    private TextView tipTextView;
    private TextView tipAmountTextView;
    private TextView totalTextView;
    private TextView totalAmountTextView;
    private SeekBar percentSeekBar;

    //Associates the controller with the needed


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountEdittext = (EditText) findViewById(R.id.amountEditText);
        amountTextView = (TextView) findViewById(R.id.amountTextView);
        tipTextView = (TextView) findViewById(R.id.tipTextView);
        tipAmountTextView = (TextView) findViewById(R.id.tipAmountTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextview);
        totalAmountTextView = (TextView) findViewById(R.id.totalAmountTextView);
        percentSeekBar = (SeekBar) findViewById(R.id.percentSeekBar);

        amountEdittext.addTextChangedListener(amountTextChangedListener);
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
                amountEdittext.setText("");
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
