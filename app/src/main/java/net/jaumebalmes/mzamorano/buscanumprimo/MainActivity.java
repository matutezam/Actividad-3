package net.jaumebalmes.mzamorano.buscanumprimo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static net.jaumebalmes.mzamorano.buscanumprimo.R.string.toast_invalid_value;
import static net.jaumebalmes.mzamorano.buscanumprimo.R.string.toast_final_message;

public class MainActivity extends AppCompatActivity {
                                                                      //Definimos todas las variables
    private EditText editPrime;
    private Button buttonCalc;
    private TextView textResult;
    private Primes primes = new Primes();
    private String findString;
    private int findNumber;
    private String primeString;

    public void findPrime(View v) {
        findString = String.valueOf(editPrime.getText());             //Extraemos el texto para comprobar
        if (findString.isEmpty()) {                                   //si el campo está vacío
            textResult.setText("");
            Toast.makeText(this, toast_invalid_value, Toast.LENGTH_SHORT).show();
        } else {
            findNumber = Integer.parseInt(findString);                //Convertimos cadena en entero para
            if(findNumber != 0) {                                     //poder trabajar con él
                primeString = String.valueOf(primes.getPrime(findNumber));
                textResult.setText(primeString);
                Toast.makeText(this, toast_final_message, Toast.LENGTH_SHORT).show();
            } else {                                                  //Mostramos un mensaje si el valor es 0
                textResult.setText("");
                Toast.makeText(this, toast_invalid_value, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                                                                //Vinculamos nuestras variables con
        editPrime = findViewById(R.id.edit_prime);              //los Views por su ID
        buttonCalc = findViewById(R.id.button_calc);
        textResult = findViewById(R.id.text_result);
    }
}
