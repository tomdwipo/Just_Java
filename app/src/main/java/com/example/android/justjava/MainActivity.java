package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */

    public void increment (View view) {

        quantity = quantity+1;

        displayQuantity(quantity);
       // displayPrice(quantity * 3);
    }
    /**
     * This method is called when the minus button is clicked.
     */

    public void decrement (View view) {

        quantity=quantity-1;

        displayQuantity(quantity);
        //displayPrice(quantity * 3);
    }
    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {
        //int price = quantity*5;
      createOrderSummary();
      //  displayPrice(quantity * 5);
    }
    private void createOrderSummary(){
        int price = calculatePrice(quantity);
        String priceMessage = "Name: Kaptain Kunal"+ "\nQuantity: "+ quantity+"\nTotal: $ "+price+"\nThank You !";

        displayMessage(priceMessage);

    }
    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity) {
        int price = quantity * 5;
        return price;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);

        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given price on the screen.
     */
   // private void displayPrice(int number) {
  //      TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
  //      priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
  //  }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}