package converter.seclass.gatech.edu.converter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ConverterActivity extends AppCompatActivity {
    private EditText distValue;
    private EditText distResult;
    private Spinner fromSpinner;
    private Spinner toSpinner;
    private int fromIndex = 0;
    private int toIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        distValue = (EditText) findViewById(R.id.distValue);
        distResult = (EditText) findViewById(R.id.distResult);

        fromSpinner = (Spinner) findViewById(R.id.spinner);
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromIndex = position;
//                Log.d("converter from", "" + fromIndex);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        fromSpinner.setAdapter(adapter);

        toSpinner = (Spinner) findViewById(R.id.spinner2);
        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toIndex = position;
//                Log.d("converter to", "" + toIndex);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        toSpinner.setAdapter(adapter2);

    }

    public void handleClick (View view) {
//        String strInCm = null;
        switch (view.getId()) {
            case R.id.buttonConvert:
                String value = distValue.getText().toString();
                if (value.length() > 0) {
                    if (fromIndex == toIndex) {
                        distResult.setText(value);
                    }
                    else {
                       double fromValueInCm = 0.00;
                       switch (fromIndex) {
                           case 0:
                               fromValueInCm = milesToCm(value);
                               break;
                           case 1:
                               fromValueInCm = feetToCm(value);
                               break;
                           case 2:
                               fromValueInCm = inchToCm(value);
                               break;
                           case 3:
                               fromValueInCm = kmToCm(value);
                               break;
                           case 4:
                               fromValueInCm = meterToCm(value);
                               break;
                           case 5:
                               fromValueInCm = Double.parseDouble(value);
                               break;
                       }
                        switch (toIndex) {
                            case 0:
                                distResult.setText(cmToMile(fromValueInCm));
                                break;
                            case 1:
                                distResult.setText(cmToFeet(fromValueInCm));
                                break;
                            case 2:
                                distResult.setText(cmToInch(fromValueInCm));
                                break;
                            case 3:
                                distResult.setText(cmToKm(fromValueInCm));
                                break;
                            case 4:
                                distResult.setText(cmToMeter(fromValueInCm));
                                break;
                            case 5:
                                DecimalFormat format = new DecimalFormat("0.00");
                                distResult.setText(String.valueOf(format.format(fromValueInCm)));
                                break;
                        }
                    }
                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = "Empty value!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                break;

            case R.id.buttonReset:
                distValue.setText("");
                distResult.setText("");
                break;
        }

    }

    public double milesToCm (String strMiles) {
        double miles = Double.parseDouble(strMiles);
        return miles * 160934;
    }
    public double feetToCm (String strFeet) {
        double feet = Double.parseDouble(strFeet);
        return feet * 30.48;
    }
    public double inchToCm (String strInch) {
        double inch = Double.parseDouble(strInch);
        return inch * 2.54;
    }
    public double kmToCm (String strKm) {
        double km = Double.parseDouble(strKm);
        return km * 100000;
    }
    public double meterToCm (String strMeter) {
        double meter = Double.parseDouble(strMeter);
        return meter * 100;
    }

    public String cmToMile (double cm) {
        double miles = cm / 160934;
        DecimalFormat format = new DecimalFormat("0.00");
        return String.valueOf(format.format(miles));
    }
    public String cmToFeet (double cm) {
        double feet = cm / 30.48;
        DecimalFormat format = new DecimalFormat("0.00");
        return String.valueOf(format.format(feet));
    }
    public String cmToInch (double cm) {
        double inch = cm /2.54;
        DecimalFormat format = new DecimalFormat("0.00");
        return String.valueOf(format.format(inch));
    }
    public String cmToKm (double cm) {
        double km = cm / 100000;
        DecimalFormat format = new DecimalFormat("0.00");
        return String.valueOf(format.format(km));
    }
    public String cmToMeter (double cm) {
        double  meter = cm /100;
        DecimalFormat format = new DecimalFormat("0.00");
        return String.valueOf(format.format(meter));
    }
}

