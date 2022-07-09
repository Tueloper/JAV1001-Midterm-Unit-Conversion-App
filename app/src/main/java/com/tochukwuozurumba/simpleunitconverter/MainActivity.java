// * Name: Tochukwu Ozurumba
// * Student Id: A0023457787
// * Description: This is a basic conversion calculator that will help convert your various units. Its an assignment done by Tochukwu Ozurumba.
// *
// *

package com.tochukwuozurumba.simpleunitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    declare global variables
    private Spinner spinner;
    private List<String> conversionLists;
    private String selectedConversion;
    private Button button;
    private TextView displayResult;
    private EditText conversionInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        get spinner ref
        spinner = (Spinner) findViewById(R.id.spinner_selection);

//        get editText ref

//        start by creating conversion array list
        conversionLists = new ArrayList<>();
        conversionLists.add("kilometers - miles");
        conversionLists.add("miles - kilometers");
        conversionLists.add("centimeters - inches");
        conversionLists.add("inches - centimeters");
        conversionLists.add("kilograms - pounds");
        conversionLists.add("pounds - kilograms");
        conversionLists.add("grams - ooze");
        conversionLists.add("ooze - grams");
        conversionLists.add("CEL - FAH");
        conversionLists.add("FAH - CEL");
        conversionLists.add("litres - cups");
        conversionLists.add("cups - litres");

//        set spinner array for display
        spinner.setAdapter(new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, conversionLists));

//        if a conversion is selected, process spinner event
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selectedConversion = conversionLists.get(position);
                Log.d("spinner", selectedConversion);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

//        get button ref
        button = findViewById(R.id.convert_button);

//        get edit text ref
        conversionInput = findViewById(R.id.editTextNumberDecimal);

//        get display text view ref
        displayResult = findViewById(R.id.display_unit);

//        process button event
        button.setOnClickListener(v -> {
            String editTextValue = conversionInput.getText().toString();
            Double conversionInputValue = Double.parseDouble(editTextValue);
            String convertedValue = processConversionSelection(selectedConversion, conversionInputValue);

//            set result on display
            displayResult.setText(convertedValue);

//            reset edit text
            conversionInput.setText("");
        });
    }

    private String processConversionSelection(String conversionUnit, Double inputValue) {
        String result = null;

        if (conversionUnit == "kilometers - miles") {
            result = convertKilometerToMiles(inputValue);
        } else if (conversionUnit == "miles - kilometers") {
            result = convertMilesToKilometer(inputValue);
        } else if (conversionUnit == "centimeters - inches") {
            result = convertCentimeterToInches(inputValue);
        } else if (conversionUnit == "inches - centimeters") {
            result = convertInchesToCentimeter(inputValue);
        } else if (conversionUnit == "kilograms - pounds") {
            result = convertKilogramToPounds(inputValue);
        } else if (conversionUnit == "pounds - kilograms") {
            result = convertPoundsToKilogram(inputValue);
        } else if (conversionUnit == "grams - ooze") {
            result = convertGramsToOz(inputValue);
        } else if (conversionUnit == "ooze - grams") {
            result = convertOzToGrams(inputValue);
        } else if (conversionUnit == "CEL - FAH") {
            result = convertCelsiusToFahrenheit(inputValue);
        } else if (conversionUnit == "FAH - CEL") {
            result = convertFahrenheitToCelsius(inputValue);
        } else if (conversionUnit == "litres - cups") {
            result = convertLitreToCups(inputValue);
        } else if (conversionUnit == "cups - litres") {
            result = convertCupsToLitre(inputValue);
        }

        return  result;
    }

    private static String convertKilometerToMiles(double input) {
        return input * 0.62 + " miles";
    }

    private static String convertMilesToKilometer(double input) {
        return input * 1.61 + " kilometers";
    }

    private static String convertCentimeterToInches(double input) {
        return input * 0.39 + " inches";
    }

    private static String convertInchesToCentimeter(double input) {
        return input * 2.54 + " centimeters";
    }

    private static String convertKilogramToPounds(double input) {
        return input * 2.2 + " pounds";
    }

    private static String convertPoundsToKilogram(double input) {
        return input * 0.45 + " kilograms";
    }

    private static String convertGramsToOz(double input) {
        return input * 0.04 + " ooze";
    }

    private static String convertOzToGrams(double input) {
        return input * 28.35 + " grams";
    }

    private static String convertCelsiusToFahrenheit(double input) {
        return (input * 9 / 5) + 32 + " F";
    }

    private static String convertFahrenheitToCelsius(double input) {
        return (input - 32) * 5 / 9 + " C";
    }

    private static String convertLitreToCups(double input) {
        return input * 4.17 + " cups";
    }

    private static String convertCupsToLitre(double input) {
        return input * 0.24 + " litres";
    }
}