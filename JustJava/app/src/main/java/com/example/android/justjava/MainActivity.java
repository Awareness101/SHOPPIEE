package com.example.android.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {
    public int quantity=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next = (Button) findViewById(R.id.gotocart_button);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), cart.class);
                myIntent.putExtra("q",quantity);
                startActivityForResult(myIntent, 0);
            }
        });
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        displaySuccess();
    }


    public void increment(View view)  {
        hideSuccess();
        display(++quantity);
        displayPrice(quantity*150);
    }
    public void decrement(View view)  {
        if(quantity == 1) {
            hideSuccess();
            display(1);
        }
        else{
            hideSuccess();
            display(--quantity);
            displayPrice(quantity*150);}
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView variableQuantityTextView = (TextView) findViewById(R.id.variable_quantity_text_view);
        variableQuantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView variablePriceTextView = (TextView) findViewById(R.id.variable_price_text_view);
        variablePriceTextView.setText(" ₹ " + number);
    }
    private void displaySuccess(){
        TextView successTextView = (TextView) findViewById(R.id.success_text_view);
        successTextView.setVisibility(View.VISIBLE);
    }
    private void hideSuccess(){
        TextView successTextView = (TextView) findViewById(R.id.success_text_view);
        successTextView.setVisibility(View.INVISIBLE);
    }

}