package com.example.android.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;
import java.text.NumberFormat;
public class cart extends AppCompatActivity {
    int q =0;
    /**
     * Called when the activity is first created.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);
        q = getIntent().getIntExtra("q",0);

        Button next = (Button) findViewById(R.id.goback_button);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }

        });
        display(q);
        displayPrice(q*150);
    }
    public void submitOrder(View view) {

        displaySuccess();
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
        ImageView cart1ImageView = (ImageView) findViewById(R.id.cart1_image_view);
        cart1ImageView.setVisibility(View.VISIBLE);

    }
}