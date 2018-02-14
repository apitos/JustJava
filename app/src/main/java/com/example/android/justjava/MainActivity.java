package com.example.android.justjava;
/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

import java.text.NumberFormat;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }


    /**
     * Create order Summury
     */
    private String createOrderSummuty(int price, boolean isWhippedCreamChecked) {
        String priceMessage = "Name:Lyla the labyrinth";
        priceMessage += "\nAdd whipped cream ? " + isWhippedCreamChecked;
        priceMessage += "\nQuantity : " + quantity;
        priceMessage += "\nTotal $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        /*int price = quantity * 5;*/

        int price = calculatePrice();
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();
        Log.v("MainActivity","Whipped is : " + hasWhippedCream );
        /*if (whippedCreamCheckbox.isChecked())
            // do something
            isClicked = true;

        else
            isClicked = false;*/
        // do something else
        //Log.i("MainActivity", "Value of isClicked : " + isClicked);
        /*String priceMessage = "Total : $" + price + "\nThank you";*/
        /*priceMessage = priceMessage + "thank you";*/

        displayMessage(createOrderSummuty(price,hasWhippedCream));
        //displayPrice(price);

    }


    /**
     * Calculates the price of the order.
     *
     * @param quantity    is the number of cups of coffee ordered
     * @param pricePerCup is the price of per cup
     *                    Return calculate price of cups
     */
    private int calculatePrice() {
        /*int price = quantity * 5;
        return price;*/
        return quantity * 5;
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    /*private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }*/
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}