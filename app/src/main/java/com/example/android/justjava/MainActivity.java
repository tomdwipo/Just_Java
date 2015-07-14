package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private EditText inputText;
    private CheckBox check1;
    private CheckBox check2;
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
        if (quantity >100){
            quantity=100;
            Toast.makeText(getApplicationContext(),"You cannot have more than 100 coffee",Toast.LENGTH_LONG).show();
        }
        displayQuantity(quantity);
       // displayPrice(quantity * 3);
    }
    /**
     * This method is called when the minus button is clicked.
     */

    public void decrement (View view) {

        quantity=quantity-1;
        if (quantity < 0 ){
            quantity = 0;
           // Toast.makeText(getApplicationContext(),"You Cannot have less than 0 coffee",Toast.LENGTH_LONG).show();
        }

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
        inputText = (EditText)findViewById(R.id.editText);
        String name1= inputText.getText().toString();

        check1 = (CheckBox)findViewById(R.id.checkbox1);
        boolean cream1 = check1.isChecked();
        check2 = (CheckBox)findViewById(R.id.checkbox2);
        boolean chocolate1= check2.isChecked();
        int price = calculatePrice(cream1, chocolate1);
        String message= submitOrderSummary(price, cream1, chocolate1, name1);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava order for " + name1);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


        }



    private String submitOrderSummary(int price , boolean cream, boolean chocolate, String name){

        String priceMessage = "Name: "+ name;
        priceMessage += "\nadd whipped cream? " + cream;
        priceMessage += "\nadd Chocolate? " + chocolate;
        priceMessage += "\nQuantity: ";
        priceMessage +=  quantity+"\nTotal: $ "+ price;
        priceMessage += "\nThank You !";
       return priceMessage;

    }
    /**
     * Calculates the price of the order.
     *
     * @param addChocolate1 is the number of cups of coffee ordered
     */
    private int calculatePrice(boolean addCream1, boolean addChocolate1) {
        int basePrice = 5;
        if (addCream1){
            basePrice = basePrice+1;
        }
        if (addChocolate1){
            basePrice=basePrice+2;
        }
        return quantity * basePrice;
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


}