package net.jaumebalmes.mzamorano.buscanumprimo;

import java.util.Arrays;

/**
 * @author MatuteZam
 */
public class Primes {

    private int[] primesArray;
    private boolean arrayIni = false;

    protected int[] ini(int primePos) {   //Este método se ejecuta una única vez para crear un vector que luego tomaremos como referencia

        if (primePos == 1) {
            primesArray = new int[primePos + 1];         //Para que no desborde el vector cuando definimos los primos iniciales
        } else {
            primesArray = new int[primePos];
        }

        primesArray[0] = 2;                              //Definimos los primeros números primos del vector
        primesArray[1] = 3;
        int arrayPos = 2;

        for (int i = 5; arrayPos < primePos; i += 2) {   //Saltamos los números pares
            int divCount = 0;

            for (int j = 0; primesArray[j] * primesArray[j] <= i; j++) {  //Mientras no rebace la raiz (multiplica factores)
                if (i % primesArray[j] == 0) {
                    divCount++;
                    break;                                                //Rompe bucle cuando encuentra un divisor
                }
            }
            if (divCount < 1) {                                           //Comprueba el contador que sólo tenga dos divisores
                primesArray[arrayPos] = i;
                arrayPos++;
            }
        }
        return primesArray;
    }

    public int getPrime(int primePos) {              //Método principal
        if (primePos < 1) {
            return 0;                                //Evitamos que falle retornando 0.
        }
        if (!arrayIni) {
            if (primePos == 1) {                    //Creamos vector de dos posiciones para evitar que falle la función
                ini(primePos + 1);         //ini pues necesita establecer dos números primos básicos para
                arrayIni = true;                    //poder calcular el resto del vector
            } else {
                ini(primePos);
                arrayIni = true;
            }
        }
        if (primePos <= primesArray.length) {       //Si la posición del número primo ya ha sido calculada, devolvemos
            return primesArray[primePos - 1];       //dicho número por pantalla
        } else {
            update(primePos);                       //Si la búsqueda rebasa el vector, reutilizamos la información y
            return primesArray[primePos - 1];       //actualizamos sus datos a partir del último primo encontrado
        }
    }

    protected void update(int primePos) {           //Si el usuario pide un primo que no hayamos calculado
        int lastPrime = primesArray[primesArray.length - 1] + 2;    //Copiamos el último primo obtenido y sumamos dos para evitar duplicación
        int arrayPos = primesArray.length;                          //Especificamos posición donde guardar los nuevos primos encontrados
        primesArray = Arrays.copyOf(primesArray, primePos);         //Sobreescribimos el vector agregando una nueva longitud

        for (int i = lastPrime; arrayPos < primePos; i += 2) {      //Saltamos los números pares
            int divCount = 0;

            for (int j = 0; primesArray[j] * primesArray[j] <= i; j++) {    //Mientras no rebace la raiz (multiplica factores)
                if (i % primesArray[j] == 0) {
                    divCount++;
                    break;                                                  //Rompe bucle cuando encuentra un divisor
                }
            }
            if (divCount < 1) {                                             //Comprueba que sólo tenga dos divisores
                primesArray[arrayPos] = i;
                arrayPos++;
            }
        }
    }
}
