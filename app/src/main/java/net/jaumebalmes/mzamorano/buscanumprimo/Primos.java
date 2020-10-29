package net.jaumebalmes.mzamorano.buscanumprimo;

import java.util.Arrays;

/**
 * @author MatuteZam
 */
public class Primos {

    private int[] vectorPrimos;
    private boolean vectorIniciado = false;

    public int[] iniciaPrimos(int posPrimo) {   //Este método se ejecuta una única vez para crear un vector que luego tomaremos como referencia

        vectorPrimos = new int[posPrimo];
        vectorPrimos[0] = 2;                            //Definimos los primeros números primos del vector
        vectorPrimos[1] = 3;
        int posVec = 2;

        for (int i = 5; posVec < posPrimo; i += 2) {    //Saltamos los números pares
            int numDivisores = 0;

            for (int j = 0; vectorPrimos[j] * vectorPrimos[j] <= i; j++) {  //Mientras no rebace la raiz (multiplica factores)
                if (i % vectorPrimos[j] == 0) {
                    numDivisores++;
                    break;                                                  //Rompe bucle cuando encuentra un divisor
                }
            }
            if (numDivisores < 1) {                                         //Comprueba el contador que sólo tenga dos divisores
                vectorPrimos[posVec] = i;
                posVec++;
            }
        }
        return vectorPrimos;
    }

    public int consultaPrimo(int numPrimo) {         //Método principal
        if (!vectorIniciado) {
            if (numPrimo == 1) {                     //Creamos vector de dos posiciones para evitar que falle la función
                iniciaPrimos(numPrimo + 1);   //iniciaPrimos pues necesita establecer dos números primos básicos
                vectorIniciado = true;               //para poder calcular el resto del vector
            } else {
                iniciaPrimos(numPrimo);
                vectorIniciado = true;
            }
        }
        if (numPrimo <= vectorPrimos.length) {       //Si la posición del número primo ya ha sido calculada, devolvemos
            return vectorPrimos[numPrimo - 1];       //dicho número por pantalla
        } else {
            actualizaPrimos(numPrimo);               //Si la búsqueda rebasa el vector, reutilizamos la información y
            return vectorPrimos[numPrimo - 1];       //actualizamos sus datos a partir del último primo encontrado
        }
    }

    public void actualizaPrimos(int posPrimo) {      //Si el usuario pide un primo que no hayamos calculado
        int ultimoPrimo = vectorPrimos[vectorPrimos.length - 1] + 2;    //Copiamos el último primo obtenido y sumamos dos para evitar duplicación
        int posVec = vectorPrimos.length;                               //Especificamos posición donde guardar los nuevos primos encontrados
        vectorPrimos = Arrays.copyOf(vectorPrimos, posPrimo);           //Sobreescribimos el vector agregando una nueva longitud

        for (int i = ultimoPrimo; posVec < posPrimo; i += 2) {          //Saltamos los números pares
            int numDivisores = 0;

            for (int j = 0; vectorPrimos[j] * vectorPrimos[j] <= i; j++) {      //Mientras no rebace la raiz (multiplica factores)
                if (i % vectorPrimos[j] == 0) {
                    numDivisores++;
                    break;                                                      //Rompe bucle cuando encuentra un divisor
                }
            }
            if (numDivisores < 1) {                                             //Comprueba que sólo tenga dos divisores
                vectorPrimos[posVec] = i;
                posVec++;
            }
        }
    }
}
