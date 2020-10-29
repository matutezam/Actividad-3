package net.jaumebalmes.mzamorano.buscanumprimo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static net.jaumebalmes.mzamorano.buscanumprimo.R.string.invalid_value;

public class MainActivity extends AppCompatActivity {

    private EditText editPrimo;
    private Button buttonCalc;
    private TextView textResult;
    private Primos primos = new Primos();
    private String cadBusca;
    private int numBusca;

    public void comienzaBusqueda(View v) {
        cadBusca = String.valueOf(editPrimo.getText());
        if (cadBusca.isEmpty()) {
            textResult.setText(invalid_value);
        } else if (cadBusca.length() > 4) {
            textResult.setText(invalid_value);
        } else {
            numBusca = Integer.parseInt(cadBusca);
            String primoCad = String.valueOf(primos.consultaPrimo(numBusca));
            textResult.setText(primoCad);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrimo = findViewById(R.id.editPrimo);
        buttonCalc = findViewById(R.id.buttonCalc);
        textResult = findViewById(R.id.textResult);
    }
}
