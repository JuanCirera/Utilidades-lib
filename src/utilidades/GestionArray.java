package utilidades;

import java.util.Arrays;

/**
 * @author Juan Fco Cirera Rosa
 */
public class GestionArray implements Comparable{

    /*
    Función que crea un array unidimensional según el parámetro e inicializarlo según el otro parámetro.
    In: int filas será un valor mayor de cero que indicará de cuantas filas será el array; int valor indica que valor ha de tener cada una de las posiciones del array
    Out: Devuelve el array unidimensional de enteros inicializado o null si hay algun problema.
    */
    public static int[] InicializarVectorEnteros(int filas, int valor){

        int arr[] = new int[filas];

        if (filas>0) {  //Si el valor de filas es mayor a 0 se inicializa el array.
            for (int i=0; i<arr.length;i++){  //Bucle for para inicializar todas las posiciones del array con el valor pasado por parametro
                arr[i]=valor;
            }

        }else{  //Si no, la funcion devuelve null, es decir, nada...
            return null;
        }
        return arr;
    }

    /*
    Función que crea un array unidimensional según el parámetro e inicializarlo según el otro parámetro.
    In: int filas será un valor mayor de cero que indicará de cuantas filas será el array; double valor
    indica que valor ha de tener cada una de las posiciones del array
    Out: Devuelve el array unidimensional de decimales inicializado o null si hay algun problema.
    */
    public static double[] InicializarVectorDecimal(int filas, double valor){

        double arr[] = new double[filas];

        if (filas>0) {  //Si el valor de filas es mayor a 0 se inicializa el array.
            for (int i=0; i<arr.length;i++){  //Bucle for para inicializar todas las posiciones del array con el valor pasado por parametro
                arr[i]=valor;
            }

        }else{  //Si no, la funcion devuelve null, es decir, nada...
            return null;
        }
        return arr;
    }

    /*
    Función que crea un array bidimensional según los parámetros e inicializarlo según el otro parámetro.
    In: int filas será un valor mayor de cero que indicará de cuantas filas será el array; int columnas será
    un valor mayor de cero que indicará de cuantas columnas será el array; int valor indica que valor ha de tener cada una de las posiciones del array
    Out: Devuelve el array bidimensional de enteros inicializado o null si hay algun problema.
    */
    public static int[][] InicializarMatrizEnteros(int filas, int columnas, int valor){

        int arr[][] = new int[filas][columnas];

        if (filas>0 && columnas>0) {  //Si el valor de filas es mayor a 0 se inicializa el array.
            for (int f=0; f<arr.length;f++){  //Bucle for para inicializar todas las posiciones del array con el valor pasado por parametro
                for(int c=0;c<arr[f].length;c++){
                    arr[f][c]=valor;
                }
            }
        }else{  //Si ocurre cualquier otro problema, la funcion devuelve null, es decir, nada...
            return null;
        }
        return arr;
    }

    /*
    Función que crea un array bidimensional según el parámetro e inicializarlo según el otro parámetro.
    In: int filas será un valor mayor de cero que indicará de cuantas filas será el array; int columnas será un valor mayor de cero que indicará de cuantas columnas será el array; double valor indica que valor ha de tener cada una de las posiciones del array
    Out: Devuelve el array bidimensional de decimales inicializado o null si hay algun problema.
    */
    public static double[][] InicializarMatrizDecimal(int filas, int columnas, double valor) {
        double arr[][] = new double[filas][columnas];

        if (filas>0 && columnas>0) {  //Si el valor de filas es mayor a 0 se inicializa el array.
            for (int f=0; f<arr.length;f++){  //Bucle for para inicializar todas las posiciones del array con el valor pasado por parametro
                for(int c=0;c<arr[f].length;c++){
                    arr[f][c]=valor;
                }
            }
        }else{  //Si ocurre cualquier otro problema, la funcion devuelve null, es decir, nada...
            return null;
        }
        return arr;
    }

    /*
    Función que crea un array bidimensional según el parámetro e inicializarlo según el otro parámetro.
    In: int filas será un valor mayor de cero que indicará de cuantas filas será el array; int columnas será un valor mayor de cero que indicará de cuantas columnas será el array; char valor indica que valor ha de tener cada una de las posiciones del array
    Out: Devuelve el array bidimensional de caracteres inicializado o null si hay algun problema.
    **Esta la añado yo porque también me hace falta**
    */
    public static char[][] InicializarMatrizCaracter(int filas, int columnas, char valor) {
        char arr[][] = new char[filas][columnas];

        if (filas>0 && columnas>0) {  //Si el valor de filas es mayor a 0 se inicializa el array.
            for (int f=0; f<arr.length;f++){  //Bucle for para inicializar todas las posiciones del array con el valor pasado por parametro
                for(int c=0;c<arr[f].length;c++){
                    arr[f][c]=valor;
                }
            }
        }else{  //Si ocurre cualquier otro problema, la funcion devuelve null, es decir, nada...
            return null;
        }
        return arr;
    }

    /**
    *Función que muestra por pantalla los valores de un array unidimensional de enteros.
    *@param vector de enteros.
    */
    public static void mostrarVectorEnteros(int [] vector) {
        for(int i=0;i<vector.length;i++){
            System.out.println(vector[i]);
        }
    }

    /**
     *Función que muestra por pantalla los valores de un array unidimensional de tipo cadena.
     *@param vector de tipo cadena.
     */
    public static void mostrarVectorCadena(String [] vector) {
        for(int i=0;i<vector.length;i++){
            System.out.println(vector[i]);
        }
    }

    /**
    *Función que muestra por pantalla los valores de un array unidimensional de decimales.
    *@param vector decimal
    */
    public static void mostrarVectorDecimal(double [] vector) { //Para los arrays unidimensionales uso "vector", para poder diferenciarlas mejor.
        for(int i=0;i<vector.length;i++){
            System.out.println(vector[i]);
        }
    }

    /*
    Función que muestra por pantalla los valores de un array bidimensional de enteros.
    In: int [] matriz es el array a mostrar
    Out: No devuelve nada.
    */
    public static void mostrarMatrizEnteros(int [][] matriz) {  //Para los arrays bidimensionales uso "matriz"
        for(int i=0;i<matriz.length;i++){
            for (int x=0;x<matriz.length;x++) {
                System.out.print(matriz[i][x]+" ");
            }
            System.out.println(); //Imprimo en la siguiente línea cada vez que se imprime una fila para que aparezca en formato de matriz.
        }
    }

    /**
    * Función que muestra por pantalla los valores de un array bidimensional de decimales.
    * In: int [] matriz es el array a mostrar
    * Out: No devuelve nada.
    */
    public static void mostrarMatrizDecimal(double [][] matriz) {
        for(int i=0;i<matriz.length;i++){
            for (int x=0;x<matriz.length;x++) {
                System.out.println(matriz[i][x]+" ");
            }
            System.out.println(); //Imprimo en la siguiente línea cada vez que se imprime una fila para que aparezca en formato de matriz.
        }
    }

    /**
    * Función que muestra por pantalla los valores de un array bidimensional de caracteres.
    * In: int [] matriz es el array a mostrar
    * Out: No devuelve nada.
    */
    //**Añado también esta, ya que acompaña a la anterior.**
    public static void mostrarMatrizCaracter(char [][] matriz) {
        for(int i=0;i<matriz.length;i++){
            for (int x=0;x<matriz.length;x++) {
                System.out.print(matriz[i][x]+" ");
            }
            System.out.println(); //Imprimo en la siguiente línea cada vez que se imprime una fila para que aparezca en formato de matriz.
        }
    }

    //------------------- FUNCIONES PARA BÚSQUEDA EN ARRAYS --------------------

    // ** ALGORITMO BÚSQUEDA SECUENCIAL **

    /**
     * Función de búsqueda secuencial.
     * @param v vector de reales.
     * @param ele real a buscar en el vector.
     * @return pos - posición en la que se encuentra el elemento buscado.
     * */
    public static int buscar_secuencial (float v[], float ele) {
        int i, pos = -1;
        boolean encontrado = false;
        /* !encontrado es igual que encontrado == false */
        for (i=0; i < v.length && !encontrado; i++)
            if (v[i] == ele) {
            // se ha encontrado el elemento ele en el vector
                encontrado = true;
                pos = i;
            }
        return pos;
    } /* fin buscar_secuencial */


    /**
     * Función de búsqueda secuencial.
     * @param v vector de enteros.
     * @param ele entero a buscar en el vector.
     * @return pos - posición en la que se encuentra el elemento buscado.
     * */
    public static int buscar_secuencial (int v[], int ele) {
        int i, pos = -1;
        boolean encontrado = false;

        /* !encontrado es igual que encontrado == false */
        for (i=0; i < v.length && !encontrado; i++)
            if (v[i] == ele) {
            // se ha encontrado el elemento ele en el vector
                encontrado = true;
                pos = i;
            }
        return pos;
    } /* fin buscar_secuencial */


    /**
     * Función de búsqueda secuencial.
     * @param cadenas vector de cadenas de texto.
     * @param cad cadena a buscar en el vector.
     * @return pos - posición en la que se encuentra el elemento buscado.
     * */
    public static int buscar_secuencial (String cadenas[], String cad)
    {
        int i, pos = -1;
        boolean encontrado = false;
        for (i=0; i < cadenas.length && !encontrado; i++)
            if (cadenas[i].equals(cad)) {
                encontrado = true;
                pos = i;
            }
        return pos;
    } /* fin buscar_secuencial */

    // ** FIN ALGORITMO BÚSQUEDA SECUENCIAL **

    // ** ALGORITMO BÚSQUEDA BINARIA

    /**
     * Función de búsqueda binaria.
     * @param v vector de reales ordenado ascendentemente, de menor a mayor.
     * @param ele real a buscar en el vector.
     * @return posicion - posición en la que se encuentra el elemento buscado.
     * */
    public static int b_binaria_asc (float v[], float ele) {
        // colocar la izquierda al principio y la derecha al final
        int izquierda=0, derecha=v.length-1, posicion, mitad;
        // calcular la mitad
        mitad = (izquierda + derecha) / 2;

        /* realizar la búsqueda mientras no encontremos el elemento y el rango de búsqueda sea correcto*/
        while (v[mitad] != ele && izquierda <= derecha) {
            if (ele > v[mitad])
                /* buscar en la parte derecha */
                izquierda = mitad +1;
            else
                /* buscar en la parte izquierda */
                derecha = mitad -1;
            // calcular de nuevo la mitad
            mitad = (izquierda + derecha) / 2;
        } /* fin while */
        if (v[mitad] == ele)
        // se ha encontrado el elemento
            posicion = mitad;
        else
        // no se ha encontrado
            posicion = -1;
        return posicion;
    } /* fin b_binaria_asc */


    /**
     * Funcion de búsqueda binaria.
     * @param v vector de cadenas ordenado de forma ascendente.
     * @param ele cadena a buscar en v.
     * @return posicion - posición en la que se encuentra el elemento buscado.
     * */
    // sobrecarga del método b_binaria_asc
    public static int b_binaria_asc (String v[], String ele)
    {
        // colocar la izquierda al principio y la derecha al final
        int izquierda=0, derecha=v.length-1, posicion, mitad;
        // calcular la mitad
        mitad = (izquierda + derecha) / 2;
        /* realizar la búsqueda mientras no encontremos el elemento y el rango de búsqueda sea correcto*/
        while (v[mitad].equals(ele) == false && izquierda <= derecha) {
        // comprueba si la cadena ele es mayor que la cadena v[mitad]
            if (ele.compareTo (v[mitad]) > 0)
                /* buscar en la parte derecha */
                izquierda = mitad +1;
            else
                /* buscar en la parte izquierda */
                derecha = mitad -1;
            // calcular de nuevo la mitad
            mitad = (izquierda + derecha) / 2;
        } /* fin while */
        if ( v[mitad].equals(ele) )
        // se ha encontrado el elemento
            posicion = mitad;
        else
        // no se ha encontrado
            posicion = -1;
        return posicion;
    } /* fin b_binaria_asc */

    // ** FIN ALGORITMO BÚSQUEDA BINARIA **


    //----------------- FUNCIONES DE ORDENACIÓN ----------------

    // ** ALGORITMO BURBUJA **

    /**
     * Funcion de ordenación de arrays. BURBUJA
     * @param v vector de enteros
     * @return ordena ascendentemente el vector.
     * */
    public static void burbuja_asc (int v[])
    {
        int i, j;
        int temp;
        int num_ele = v.length; // número de elementos del vector

        /* El bucle i controla el número de pasadas */
        for (i=1; i < num_ele; i++)
        /* El bucle j controla el número de comparaciones entre elementos del vector */
            for (j=0; j < num_ele - i; j++)
            /*Comparar el elemento j con el j+1 y si están desordenados los intercambia*/
                if (v[j] > v[j+1]) {
                    temp = v[j];
                    v[j] = v[j+1];
                    v[j+1] = temp;
                } /* fin if */
    } /* fin burbuja_asc */

    /**
     * Muestra por pantalla el vector de enteros
     * @param v vector de enteros
     * */
    public static void muestra_burbuja (int v[]) {
        System.out.printf("\n El vector de enteros es:\n");
        for (int f=0; f < v.length; f++)
            System.out.print (v[f]+" ");
    } // fin muestra

    /**
     * Genera un número aleatorio para cada elemento del vector de enteros
     * @param v vector de enteros
     * */
    public static void aleatorio (int v[]) {
        for (int f=0; f < v.length; f++)
            v[f] = (int) Math.round (Math.random()*1000);
    } // fin aleatorio


    /**
     * Función de ordenación de arrays de tipo cadena. BURBUJA
     * @param v vector de Strings
     * @return ordena ascendentemente el vector.
     * */
    public static void burbuja_asc (String v[]) {
        int i, j;
        String temp;
        int num_ele = v.length; // número de elementos del vector

        /* El bucle i controla el número de pasadas */
        for (i=1; i < num_ele; i++)
            /* El bucle j controla el número de comparaciones entre elementos del vector */
            for (j=0; j < num_ele - i; j++)
                /*Comparar el elemento j con el j+1 y si están desordenados los intercambia*/
                //Hay que usar compareTo al ser datos de tipo String
                if (v[j].compareTo(v[j+1]) > 0) {
                    temp = v[j];
                    v[j] = v[j+1];
                    v[j+1] = temp;
                } /* fin if */
    } /* fin burbuja_asc */

    // ** FIN ALGORITMO BURBUJA **


    // ** ALGORITMO SHELL **

    /**
     * Funcion de ordenacion de arrays. SHELL
     * @param v vector de enteros
     * @return ordena ascendentemente el vector.
     * */
    public static void shell_asc (int v[])
    {
        int d, i, ele;
        boolean ordenado;
        int num_ele = v.length; // número de elementos
        d = num_ele/2; // distancia de comparación

        /* La ordenación se realiza mientras la distancia de comparación sea menor igual que 1 */
        while (d >= 1) {
            ordenado = false;
            /* ordena el vector para la distancia d */
            while (!ordenado) { // !ordenado es como poner ordenado == false
                ordenado = true;
                for (i=0; i < num_ele-d; i++)
                    // si el elemento i es mayor que i+d los intercambia
                    if (v[i] > v[i+d]) {
                        ele = v[i];
                        v[i] = v[i+d];
                        v[i+d] = ele;
                        ordenado = false; // el vector no estaba ordenado
                    } /* fin if */
            } /* fin while !ordenado */
            /* calcula la nueva distancia de comparación d */
            d = d/2;
        } /* fin while d */
    } /* fin shell_asc */

    /**
     * Funcion de ordenacion de arrays. SHELL
     * @param v vector de enteros
     * @return ordena ascendentemente el vector.
     * */
    public static void shell_desc (int v[])
    {
        int d, i, ele;
        boolean ordenado;
        int num_ele = v.length; // número de elementos
        d = num_ele/2; // distancia de comparación

        /* La ordenación se realiza mientras la distancia de comparación sea menor igual que 1 */
        while (d >= 1) {
            ordenado = false;
            /* ordena el vector para la distancia d */
            while (!ordenado) { // !ordenado es como poner ordenado == false
                ordenado = true;
                for (i=0; i < num_ele-d; i++)
                    // si el elemento i es mayor que i+d los intercambia
                    if (v[i] < v[i+d]) {
                        ele = v[i];
                        v[i] = v[i+d];
                        v[i+d] = ele;
                        ordenado = false; // el vector no estaba ordenado
                    } /* fin if */
            } /* fin while !ordenado */
            /* calcula la nueva distancia de comparación d */
            d = d/2;
        } /* fin while d */
    } /* fin shell_asc */


    /**
     * Funcion de ordenación de arrays. SHELL
     * @param v vector de tipo cadena
     * @return ordena ascendentemente el vector.
     * */
    public static void shell_asc (String v[])
    {
        int d, i;
        String ele;
        boolean ordenado;
        int num_ele = v.length; // número de elementos
        d = num_ele/2; // distancia de comparación

        /* La ordenación se realiza mientras la distancia de comparación sea menor igual que 1 */
        while (d >= 1) {
            ordenado = false;
            /* ordena el vector para la distancia d */
            while (!ordenado) { // !ordenado es como poner ordenado == false
                ordenado = true;
                for (i=0; i < num_ele-d; i++)
                    // si el elemento i es mayor que i+d los intercambia
                    if (v[i].compareTo(v[i+d]) > 0) {
                        ele = v[i];
                        v[i] = v[i+d];
                        v[i+d] = ele;
                        ordenado = false; // el vector no estaba ordenado
                    } /* fin if */
            } /* fin while !ordenado */
            /* calcula la nueva distancia de comparación d */
            d = d/2;
        } /* fin while d */
    } /* fin shell_asc */

    // ** FIN ALGORITMO SHELL


    // ** ALGORITMO QUICK SORT **

    /* E: v => vector de enteros
    S: nada, ordena ascendentemente por quicksort el vector */
    public static void quicksort_asc (int v[]) {
        quicksort_asc(v, 0, v.length-1);
    }
    // Se sobrecarga el método para evitar llamarlo la primera vez
    /**
     * Funcion de ordenacion de arrays. QUICK SORT
     * @param v vector de enteros (Pivote)
     * @param izq
     * @param der
     * @return ordena ascendentemente el vector.
     * */
    public static void quicksort_asc (int v[], int izq, int der) {
        int pivote=v[izq]; // tomamos primer elemento como pivote
        int i=izq; // i realiza la búsqueda de izquierda a derecha
        int j=der; // j realiza la búsqueda de derecha a izquierda
        int aux;
        while(i<j){ // mientras no se crucen las búsquedas
            while(v[i]<=pivote && i<j)
                i++; // busca elemento mayor que pivote
            while(v[j]>pivote)
                j--; // busca elemento menor que pivote
            if (i<j) { // si no se han cruzado
                aux= v[i]; // los intercambia
                v[i]=v[j];
                v[j]=aux;
            }
        }
        v[izq]=v[j]; // se coloca el pivote en su lugar de forma que tendremos
        v[j]=pivote; // los menores a su izquierda y los mayores a su derecha
        if(izq<j-1)
            quicksort_asc(v,izq,j-1); // ordenamos subarray izquierdo
        if(j+1 <der)
            quicksort_asc(v,j+1,der); // ordenamos subarray derecho
    }


    // Se sobrecarga el método para evitar llamarlo la primera vez
    public static void quicksort_asc (String v[]) {
        quicksort_asc(v, 0, v.length-1);
    }
    /**
     * Funcion de ordenación de arrays. QUICK SORT
     * @param v vector de tipo cadena
     * @param izq
     * @param der
     * @return ordena ascendentemente el vector.
     * */
    public static void quicksort_asc (String v[], int izq, int der) {
        String pivote=v[izq]; // tomamos primer elemento como pivote
        int i=izq; // i realiza la búsqueda de izquierda a derecha
        int j=der; // j realiza la búsqueda de derecha a izquierda
        String aux;
        while(i<j){ // mientras no se crucen las búsquedas
            while(v[i].compareTo(pivote) <= 0 && i<j)
                i++; // busca elemento mayor que pivote
            while(v[j].compareTo(pivote) > 0)
                j--; // busca elemento menor que pivote
            if (i<j) { // si no se han cruzado
                aux= v[i]; // los intercambia
                v[i]=v[j];
                v[j]=aux;
            }
        }
        v[izq]=v[j]; // se coloca el pivote en su lugar de forma que tendremos
        v[j]=pivote; // los menores a su izquierda y los mayores a su derecha
        if(izq<j-1)
            quicksort_asc(v,izq,j-1); // ordenamos subarray izquierdo
        if(j+1 <der)
            quicksort_asc(v,j+1,der); // ordenamos subarray derecho
    }

    // ** FIN QUICK SORT**


    // ** ALGORITMO MERGE SORT **

    /**
     * Ordenación de array de enteros. MERGE SORT
     * @param arr vector de enteros
     * @param left
     * @param right
     * */
    public static void sort(int arr[], int left, int right){
        if(left < right){
            //Encuentra el punto medio del vector
            int pivote = (left + right) / 2;

            //Divide la primera y segunda mitad (llamada recursiva)
            sort(arr, left, pivote);
            sort(arr, pivote+1, right);

            //Une las mitades
            merge(arr, left, pivote, right);
        }
    }
    public static void merge(int arr[], int izq, int pivote, int der){
        //Encuentra el tamaño de los sub-vectores para unirlos.
        int n1 = pivote - izq + 1;
        int n2 = der - pivote;

        //Vectores temporales.
        int leftArray[] = new int [n1];
        int rightArray[] = new int [n2];

        //Copia los datos a los arrays temporales.
        for (int i=0; i < n1; i++) {
            leftArray[i] = arr[izq +i];
        }
        for (int j=0; j < n2; j++) {
            rightArray[j] = arr[pivote + j + 1];
        }
        /* Une los vectores temporales. */

        //Índices inicial del primer y segundo sub-vector.
        int i = 0, j = 0;

        //Índice inicial del sub-vector arr[].
        int k = izq;

        //Ordenamiento.
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }//Fin del while.

        /* Si quedan elementos por ordenar */
        //Copiar los elementos restantes de leftArray[].
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        //Copiar los elementos restantes de rightArray[].
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    /**
     * Ordenación de array de tipo cadena. MERGE SORT
     * @param arr vector de tipo cadena
     * @param left
     * @param right
     * */
    public static void sort(String arr[], int left, int right){
        if(left < right){
            //Encuentra el punto medio del vector
            int pivote = (left + right) / 2;

            //Divide la primera y segunda mitad (llamada recursiva)
            sort(arr, left, pivote);
            sort(arr, pivote+1, right);

            //Une las mitades
            merge(arr, left, pivote, right);
        }
    }

    public static void merge(String[] a, int izq, int pivote, int der) {
        int n = der - izq + 1;       // size of the range to be merged
        String[] b = new String[n];   // merge both halves into a temporary array b
        int i1 = izq;               // next element to consider in the first range
        int i2 = pivote + 1;            // next element to consider in the second range
        int j = 0;                   // next open position in b

        // as long as neither i1 nor i2 past the end, move the smaller into b
        while (i1 <= pivote && i2 <= der) {
            if (a[i1].compareTo(a[i2]) < 0) {
                b[j] = a[i1];
                i1++;
            } else {
                b[j] = a[i2];
                i2++;
            }
            j++;
        }
        // note that only one of the two while loops below is executed
        // copy any remaining entries of the first half
        while (i1 <= pivote) {
            b[j] = a[i1];
            i1++;
            j++;
        }
        // copy any remaining entries of the second half
        while (i2 <= der) {
            b[j] = a[i2];
            i2++;
            j++;
        }
        // copy back from the temporary array
        for (j = 0; j < n; j++) {
            a[izq + j] = b[j];
        }
    }

    //** FIN MERGE SORT **


    //** ORDENACIÓN DE OBJETOS **

    @Override
    public int compareTo(Object o) {
        return 0;
    }


//    public static void main(String[] args) {
//        int arr[]={3,5,1,2,4,8,7};
////        shell_asc(arr);
//        shell_desc(arr);
//        mostrarVectorEnteros(arr);
//    }
}
