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
    private EditText editPrimo;
    private Button buttonCalc;
    private TextView textResult;
    private Primos primos = new Primos();
    private String cadBusca;
    private int numBusca;
    private String primoCad;

    public void comienzaBusqueda(View v) {
        cadBusca = String.valueOf(editPrimo.getText());         //Extraemos el texto para comprobar
        if (cadBusca.isEmpty()) {                               //si el campo está vacío
            textResult.setText("");
            Toast.makeText(this, t_invalid_value, Toast.LENGTH_SHORT).show();
        } else {
            numBusca = Integer.parseInt(cadBusca);              //Convertimos cadena en entero para
            if(numBusca != 0) {                                 //poder trabajar con él
                primoCad = String.valueOf(primos.consultaPrimo(numBusca));
                textResult.setText(primoCad);
                Toast.makeText(this, t_final_msg, Toast.LENGTH_SHORT).show();
            } else {                                            //Mostramos mensaje si el valor es 0
                textResult.setText("");
                Toast.makeText(this, t_invalid_value, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                                                                //Vinculamos nuestras variables con
        editPrimo = findViewById(R.id.editPrimo);               //los Views por su ID
        buttonCalc = findViewById(R.id.buttonCalc);
        textResult = findViewById(R.id.textResult);
    }
}
