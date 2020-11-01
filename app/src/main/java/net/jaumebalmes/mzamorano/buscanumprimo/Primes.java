package net.jaumebalmes.mzamorano.buscanumprimo;

import java.util.Arrays;

/**
 * @author MatuteZam
 */
public class Primes {

    private int[] primes_array;
    private boolean array_ini = false;

    protected int[] ini(int prime_pos) {   //Este método se ejecuta una única vez para crear un vector que luego tomaremos como referencia

        if (prime_pos == 1) {
            primes_array = new int[prime_pos + 1];        //Para que no desborde el vector cuando definimos los primos iniciales
        } else {
            primes_array = new int[prime_pos];
        }

        primes_array[0] = 2;                              //Definimos los primeros números primos del vector
        primes_array[1] = 3;
        int array_pos = 2;

        for (int i = 5; array_pos < prime_pos; i += 2) {  //Saltamos los números pares
            int div_count = 0;

            for (int j = 0; primes_array[j] * primes_array[j] <= i; j++) {  //Mientras no rebace la raiz (multiplica factores)
                if (i % primes_array[j] == 0) {
                    div_count++;
                    break;                                                  //Rompe bucle cuando encuentra un divisor
                }
            }
            if (div_count < 1) {                                            //Comprueba el contador que sólo tenga dos divisores
                primes_array[array_pos] = i;
                array_pos++;
            }
        }
        return primes_array;
    }

    public int getPrime(int prime_pos) {             //Método principal
        if (prime_pos < 1) {
            return 0;                                //Evitamos que falle retornando 0.
        }
        if (!array_ini) {
            if (prime_pos == 1) {                    //Creamos vector de dos posiciones para evitar que falle la función
                ini(prime_pos + 1);        //ini pues necesita establecer dos números primos básicos para
                array_ini = true;                    //poder calcular el resto del vector
            } else {
                ini(prime_pos);
                array_ini = true;
            }
        }
        if (prime_pos <= primes_array.length) {     //Si la posición del número primo ya ha sido calculada, devolvemos
            return primes_array[prime_pos - 1];     //dicho número por pantalla
        } else {
            update(prime_pos);                       //Si la búsqueda rebasa el vector, reutilizamos la información y
            return primes_array[prime_pos - 1];      //actualizamos sus datos a partir del último primo encontrado
        }
    }

    protected void update(int prime_pos) {           //Si el usuario pide un primo que no hayamos calculado
        int last_prime = primes_array[primes_array.length - 1] + 2;    //Copiamos el último primo obtenido y sumamos dos para evitar duplicación
        int array_pos = primes_array.length;                           //Especificamos posición donde guardar los nuevos primos encontrados
        primes_array = Arrays.copyOf(primes_array, prime_pos);         //Sobreescribimos el vector agregando una nueva longitud

        for (int i = last_prime; array_pos < prime_pos; i += 2) {      //Saltamos los números pares
            int div_count = 0;

            for (int j = 0; primes_array[j] * primes_array[j] <= i; j++) {  //Mientras no rebace la raiz (multiplica factores)
                if (i % primes_array[j] == 0) {
                    div_count++;
                    break;                                                  //Rompe bucle cuando encuentra un divisor
                }
            }
            if (div_count < 1) {                                            //Comprueba que sólo tenga dos divisores
                primes_array[array_pos] = i;
                array_pos++;
            }
        }
    }
}
