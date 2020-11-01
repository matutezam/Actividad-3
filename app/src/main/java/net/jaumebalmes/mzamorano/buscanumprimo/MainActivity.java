package net.jaumebalmes.mzamorano.buscanumprimo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static net.jaumebalmes.mzamorano.buscanumprimo.R.string.t_invalid_value;
import static net.jaumebalmes.mzamorano.buscanumprimo.R.string.t_final_msg;

public class MainActivity extends AppCompatActivity {
                                                                      //Definimos todas las variables
    private EditText edit_prime;
    private Button button_calc;
    private TextView text_result;
    private Primes primes = new Primes();
    private String find_string;
    private int find_number;
    private String prime_string;

    public void findPrime(View v) {
        find_string = String.valueOf(edit_prime.getText());           //Extraemos el texto para comprobar
        if (find_string.isEmpty()) {                                  //si el campo está vacío
            text_result.setText("");
            Toast.makeText(this, t_invalid_value, Toast.LENGTH_SHORT).show();
        } else {
            find_number = Integer.parseInt(find_string);              //Convertimos cadena en entero para
            if(find_number != 0) {                                    //poder trabajar con él
                prime_string = String.valueOf(primes.getPrime(find_number));
                text_result.setText(prime_string);
                Toast.makeText(this, t_final_msg, Toast.LENGTH_SHORT).show();
            } else {                                                  //Mostramos un mensaje si el valor es 0
                text_result.setText("");
                Toast.makeText(this, t_invalid_value, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                                                                //Vinculamos nuestras variables con
        edit_prime = findViewById(R.id.edit_prime);             //los Views por su ID
        button_calc = findViewById(R.id.button_calc);
        text_result = findViewById(R.id.text_result);
    }
}
