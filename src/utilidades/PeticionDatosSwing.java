package utilidades;

import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase para comprobar datos introducidos en JTextFields o JTextAreas desde Swing
 * @author Juan Fco Cirera Rosa
 */
public class PeticionDatosSwing {

    //Aquí uso variables para guardar el color ANSI (color de texto de la terminal) para poder diferenciar mejor el texto.
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";

    /*
    He decidio poner las funciones static para poder llamarlas sin necesidad de instanciar ningun objeto, ya que no es, creo yo, la
    finalidad de esta clase. Además encima de cada funcion está copiada la descripcion de lo que hacen para no confundirlas.
    Cada función va acompañada de su descripcion que se muestra pasando el raton por encima de la llamada.
    */

    //**FUNCIONES**

    private static void InputMismatchException(){
        System.out.println(ANSI_RED+"Error: Tipo de dato introducido incorrecto."+ANSI_RESET);
    }


    /**
     * Función que pide un número entero por teclado y lo devuelve.
     * @return Entero válido introducido por teclado.
     */
    public static int pedirEntero() throws InputMismatchException{
        Scanner sc=new Scanner(System.in);  //Instancia del objeto tipo Scanner
        int n=0;
        boolean control=false;  //Variable de control

        do {

            try {
                System.out.print("Introduce un numero entero: ");
                n = sc.nextInt();
                control=true; //Cuando se introduzca un entero el control se vuelve true para que no siga pidiendo datos.

            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED+"Error: Tipo de dato introducido incorrecto."+ANSI_RESET);
                control=false;   //Este booleano de control sirve para que se repita la peticion de datos en caso de capturar una excepción
                sc.nextLine(); //Se limpia el "buffer" de Scanner para que no haga un bucle infinito, siempre leyendo el mismo dato.
            } catch (Exception e){  //Meto un catch generico por si acaso hay alguna otra forma de que falle.
                System.out.println(ANSI_RED+"Error: Desconocido."+ANSI_RESET);
                control=false;
                sc.nextLine();
            }

        }while (!control);   //Mientras la variable de control sea false se volvera a repetir el proceso de peticion y comprobación.

        return n;   //Se devuelve el número introducido si es correcto.
    }


    /**
     * Función que comprueba si un número entero es mayor o igual a 0.
     * @return int - 0->OK, 1->Negative(e), 3->Unknown(e).
     */
    public static int checkEnteroPositivo(int n){
        int m=0;

        try {
            if (n>=0){
                m=0;   //Si el número introducido es válido y mayor o igual a 0 control valdrá true y se guardara el dato
            }else{
                m=1;
            }

        } catch (InputMismatchException e) {
            m=3;
        } catch (Exception e){
            m=3;
        }
        return m;
    }


    /**
     * Función que comprueba si un número entero es mayor o igual a 0.
     * @return int - 0->OK, 1->Negative(e), 3->Unknown(e).
     */
    public static int checkEnteroPositivo(String cadena){
        int m=0;

        try {
            int n=Integer.parseInt(cadena);

            if (n>=0){
                m=0;   //Si el número introducido es válido y mayor o igual a 0 control valdrá true y se guardara el dato
            }else{
                m=1;
            }

        } catch (InputMismatchException e) {
            m=3;
        } catch (Exception e){
            m=3;
        }
        return m;
    }

    /**
     * Función que pide un número entero mayor o igual a 0 según el parámetro de entrada.
     * @param cero true si acepta el cero y false si no lo acepta.
     * @return Entero mayor o igual a 0 introducido por teclado según el parámetro de entrada.
     */
    public static int pedirEnteroPositivo(boolean cero){
        Scanner sc=new Scanner(System.in);
        int n=0;
        boolean control=false;

        do {
            try {
                System.out.print("Introduce un entero positivo: ");
                n = sc.nextInt();
                if (cero==true) {    //Admite el cero
                    if (n >= 0) {
                        control = true;   //Si el número introducido es válido y mayor o igual a 0 control valdrá true y se guardara el dato
                    } else {
                        System.out.println(ANSI_RED + "Error: se debe introducir un positivo." + ANSI_RESET);
                    }
                }else if (cero==false){  //No admite el cero, solo cambia el igual en el comparador del if
                    if (n > 0) {
                        control = true;
                    } else if(n==0){
                        //En caso de introducir el cero se mostrará esto y se volvera a pedir
                        System.out.println(ANSI_RED + "Error: no se admite 0." + ANSI_RESET);
                    }else {
                        //En caso de introducir un numero negativo.
                        System.out.println(ANSI_RED + "Error: se debe introducir un positivo." + ANSI_RESET);
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED+"Error: tipo de dato introducido incorrecto."+ANSI_RESET);
                control=false;
                sc.nextLine();
            } catch (Exception e){
                System.out.println(ANSI_RED+"Error: Desconocido."+ANSI_RESET);
                control=false;
                sc.nextLine();
            }
        }while (!control);

        return n;
    }


    /**
     * Función que pide un número entero menor a 0.
     * @return Entero menor a 0 introducido por teclado.
     */
    public static int pedirEnteroNegativo(){
        Scanner sc=new Scanner(System.in);
        int n=0;
        boolean control=false;

        do {
            try {
                System.out.print("Introduce un entero negativo: ");
                n = sc.nextInt();
                if (n < 0) {
                    control = true;   //Si el número introducido es válido y menor que 0, control valdrá true y se guardara el dato
                } else {
                    System.out.println(ANSI_RED + "Error: se debe introducir un negativo." + ANSI_RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED+"Error: tipo de dato introducido incorrecto."+ANSI_RESET);
                control=false;
                sc.nextLine();
            } catch (Exception e){
                System.out.println(ANSI_RED+"Error: Desconocido."+ANSI_RESET);
                control=false;
                sc.nextLine();
            }
        }while (!control);

        return n;
    }

    //******************************************************************************************************************

    /**
     * Función que pide un número decimal.
     * @return Decimal válido introducido por teclado.
     */
    public static double pedirDecimal(){
        Scanner sc=new Scanner(System.in);  //Instancia del objeto tipo Scanner
        double n=0;
        boolean control=false;  //Variable de control

        do {
            try {
                System.out.print("Introduce un decimal: ");
                n = sc.nextDouble();
                control=true;

            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED+"Error: Tipo de dato introducido incorrecto."+ANSI_RESET);
                control=false;
                sc.nextLine();
            } catch (Exception e){
                System.out.println(ANSI_RED+"Error: Desconocido."+ANSI_RESET);
                control=false;
                sc.nextLine();
            }
        }while (!control);

        return n;

    }


    /**
     * Función que pide un número decimal mayor o igual a 0.
     * @return Decimal mayor o igual a 0 válido introducido por teclado.
     */
    public static double pedirDecimalPositivo() {
        Scanner sc = new Scanner(System.in);  //Instancia del objeto tipo Scanner
        double n = 0;
        boolean control = false;  //Variable de control

        do {
            try {
                System.out.print("Introduce un decimal positivo: ");
                n = sc.nextDouble();
                if (n>=0){
                    control = true;
                }else{
                    System.out.println(ANSI_RED + "Error: debe ser un decimal positivo." + ANSI_RESET);
                    control = false;
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Error: Tipo de dato introducido incorrecto." + ANSI_RESET);
                control = false;
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Error: Desconocido." + ANSI_RESET);
                control = false;
                sc.nextLine();
            }
        } while (!control);

        return n;
    }

    /**
     * Función que pide un número decimal mayor o igual a 0.
     * @param cero Se pasará true si acepta el cero y false si no lo acepta.
     * @return Decimal mayor o igual a 0 válido introducido por teclado según el parámetro de entrada.
     */
    public static double pedirDecimalPositivo(boolean cero) {
        Scanner sc = new Scanner(System.in);  //Instancia del objeto tipo Scanner
        double n = 0;
        boolean control = false;  //Variable de control

        do {
            try {
                System.out.print("Introduce un decimal positivo: ");
                n = sc.nextDouble();
                if (cero==true) {
                    if (n >= 0) {
                        control = true;
                    } else {
                        System.out.println(ANSI_RED + "Error: debe ser un decimal positivo." + ANSI_RESET);
                        control = false;
                    }
                }else{
                    if (n > 0) {
                        control = true;
                    }else if(n==0){
                        System.out.println(ANSI_RED + "Error: no se permite el 0." + ANSI_RESET);
                        control = false;
                    }else {
                        System.out.println(ANSI_RED + "Error: debe ser un decimal positivo." + ANSI_RESET);
                        control = false;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Error: Tipo de dato introducido incorrecto." + ANSI_RESET);
                control = false;
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Error: Desconocido." + ANSI_RESET);
                control = false;
                sc.nextLine();
            }
        } while (!control);

        return n;
    }


    /**
     * Función que pide un número decimal menor a 0.
     * @return Decimal menor a 0 válido introducido por teclado.
     */
    public static double pedirDecimalNegativo() {
        Scanner sc = new Scanner(System.in);  //Instancia del objeto tipo Scanner
        double n = 0;
        boolean control = false;  //Variable de control

        do {
            try {
                System.out.print("Introduce un decimal negativo: ");
                n = sc.nextDouble();
                if (n<0){
                    control = true;
                }else{
                    System.out.println(ANSI_RED + "Error: debe ser un decimal negativo." + ANSI_RESET);
                    control = false;
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Error: Tipo de dato introducido incorrecto." + ANSI_RESET);
                control = false;
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Error: Desconocido." + ANSI_RESET);
                control = false;
                sc.nextLine();
            }
        } while (!control);

        return n;
    }


    /**
     * Función que pide un número decimal por teclado dentro del rango indicado por los parámetros incluyendo ambos límites
     * @param limite1 Indica uno de los límites (superior/inferior).
     * @param limite2 Indica el otro límite (superior/inferior).
     * @return Decimal válido introducido por teclado dentro del rango de los límites indicados, pudiendo ser uno de los límites.
     */
    public static double pedirDecimalRango(double limite1, double limite2){
        Scanner sc=new Scanner(System.in);
        double n=0;
        boolean control=false;

        do {
            try {
                System.out.print("Introduce un numero entre "+limite1+" y "+limite2+": ");
                n = sc.nextDouble();
                if (n > limite1 && n < limite2) { //Si el número es mayor que limite1 y menor que limite2, se guarda.
                    control = true;   //Si el número introducido es válido y menor que 0, control valdrá true y se guardara el dato
                } else {
                    System.out.println(ANSI_RED + "Error: el numero debe estar dentro del rango, ambos excluidos." + ANSI_RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED+"Error: tipo de dato introducido incorrecto."+ANSI_RESET);
                control=false;
                sc.nextLine();
            } catch (Exception e){
                System.out.println(ANSI_RED+"Error: Desconocido."+ANSI_RESET);
                control=false;
                sc.nextLine();
            }
        }while (!control);

        return n;
    }


    /**
     * Función que pide un número decimal por teclado dentro del rango indicado por los parámetros incluyendo ambos límites
     * @param limite1 Indica uno de los límites (superior/inferior).
     * @param limite2 Indica el otro límite (superior/inferior).
     * @param incluido Valdrá 0 si no está incluido ninguno de los limites, 1 si está incluido limite1 pero no limite2, 2 si está incluido limite2 pero no limite1, 3 si ambos limites estan incluidos. Si vale cualquier otra cosa se considerará como si fuera 0.
     * @return Decimal válido introducido por teclado dentro del rango de los límites indicados, incluidos estos o no según parámetro.
     */
    public static double pedirDecimalRango(double limite1, double limite2, int incluido){
        Scanner sc=new Scanner(System.in);
        double n=0;
        boolean control=false;

        do {
            try {
                switch (incluido) {
                    case 0:
                        System.out.print("Introduce un numero entre " + limite1 + " y " + limite2 + ": ");
                        n = sc.nextDouble();
                        if (n > limite1 && n < limite2) { //Si el número es mayor que limite1 y menor que limite2, se guarda.
                            control = true;   //Si el número introducido es válido y menor que 0, control valdrá true y se guardara el dato
                        } else {
                            System.out.println(ANSI_RED + "Error: el numero debe estar dentro del rango, ambos excluidos." + ANSI_RESET);
                        }
                        break;
                    case 1:
                        System.out.print("Introduce un numero entre " + limite1 + " y " + limite2 + ": ");
                        n = sc.nextDouble();
                        if (n >= limite1 && n < limite2) { //Si el número es mayor o igual que limite1 y menor que limite2.
                            control = true;
                        } else {
                            System.out.println(ANSI_RED + "Error: el numero debe estar dentro del rango." + ANSI_RESET);
                        }
                        break;
                    case 2:
                        System.out.print("Introduce un numero entre " + limite1 + " y " + limite2 + ": ");
                        n = sc.nextDouble();
                        if (n > limite1 && n <= limite2) { //Si el número es mayor que limite1 y menor o igual que limite2.
                            control = true;
                        } else {
                            System.out.println(ANSI_RED + "Error: el numero debe estar dentro del rango." + ANSI_RESET);
                        }
                        break;
                    case 3:
                        System.out.print("Introduce un numero entre " + limite1 + " y " + limite2 + ": ");
                        n = sc.nextDouble();
                        if (n >= limite1 && n <= limite2) { //Si el número es mayor que limite1 y menor que limite2, se guarda.
                            control = true;   //Si el número introducido es válido y menor que 0, control valdrá true y se guardara el dato
                        } else {
                            System.out.println(ANSI_RED + "Error: el numero debe estar dentro del rango, ambos incluidos." + ANSI_RESET);
                        }
                        break;
                    default:
                        System.out.println(ANSI_RED + "Error: el límite que se ha introducido es incorrecto." + ANSI_RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED+"Error: tipo de dato introducido incorrecto."+ANSI_RESET);
                control=false;
                sc.nextLine();
            } catch (Exception e){
                System.out.println(ANSI_RED+"Error: Desconocido."+ANSI_RESET);
                control=false;
                sc.nextLine();
            }
        }while (!control);

        return n;
    }


    /**
     * Función que comprueba que una cadena de caracteres no tenga números ni símbolos de puntuación.
     * @return int - 0->OK, 1->Number(E), 2->Special char(E), 3->Unknown(E).
     */
    public static int checkCadena(String cadena){
        try {
            if (cadena.matches(".*\\d.*")) { //No se aceptan numeros en el String
                return 1;
            } else if (!cadena.matches("[a-zA-Z0-9]*")) { //NO se aceptan caracteres especiales
                return 2;
            }

        } catch (InputMismatchException e) {
            return 3;
        } catch (Exception e){
            return 3;
        }
        return 0;
    }


    /**
     * Función que pide una cadena de caracteres por teclado que tendrá números y/o símbolos de puntuación y una longitud determinada según los parámetros de entrada.
     * @param numero true si se aceptan números en la cadena y false si no se aceptan.
     * @param simbolo true si se aceptan símbolos y false si no se aceptan.
     * @param limite Indica el número máximo de caracteres que se quieren.
     * @param cadena - String a comprobar.
     * @return int - 0->OK, 1->Number(E), 2->Special char(E), 3->Unknown(E).
     */
    public static int checkCadenaLimite(boolean numero, boolean simbolo, int limite, String cadena) {
        int m=0, caso=0;
//        try {
        if (cadena.length()<=limite) { //Se limita la longitud máxima de la cadena segun el valor pasado por parametro.

            if(numero && !simbolo){
                caso=1;
            }else if(!numero && simbolo){
                caso=2;
            }else if(numero && simbolo){
                caso=3;
            }else if(!numero && !simbolo){
                caso=4;
            }


            try {
                switch (caso) {
                    case 1:
                        if (cadena.matches("[a-zA-Z0-9]*")) {
                            m = 0;
                        } else {
                            m = 1;
                        }
                        break;
                    case 2:
                        if (!cadena.matches("[a-zA-Z0-9]*") && cadena.matches("[a-zA-Z]*")) {
                            m = 0;
                        } else if(!cadena.matches("[a-zA-Z0-9]*") && !cadena.matches(".*\\d.*")){
                            m = 0;
                        } else if(cadena.matches("[a-zA-Z]*") && !cadena.matches(".*\\d.*")){
                            m = 0;
                        }else{
                            m=1;
                        }
                        break;
                    case 3:
                        if (!cadena.matches("[a-zA-Z0-9]*") || cadena.matches("[a-zA-Z]*") || cadena.matches(".*\\d.*")) {
                            m = 0;
                        } else{
                            m=1;
                        }
                        break;
                    case 4:
                        if (cadena.matches("[a-zA-Z]*")) {
                            m = 0;
                        } else {
                            m = 1;
                        }
                        break;
                    default: //Esto para saber que ha fallado el switch mas que nada
                        m=1;
                        break;
                }
            }catch (InputMismatchException e) {
                m=3;
            } catch (Exception e){
                m=3;
            }
        }
        return m;
    }


    /**
     * Función que pide una cadena de caracteres por teclado con el formato de NIF/NIE, lo chequea y lo devuelve.
     * @return Cadena de caracteres introducida por teclado que sea un NIE o un NIF válido.
     */
    public static String pedirNIF_NIE(){
        Scanner sc=new Scanner(System.in);  //Instancia del objeto tipo Scanner
        int n, div; //Variables para el cálculo del dígito de control
        String dni="";  //Variable donde se almacenara el dni introducido y en caso de ser válido será el dato a devolver.
        String nie="", letraDni="", letraNie="";
        boolean control=false;  //true=Para el bucle, false=Sigue el bucle

        /*Array para las letras que corresponden a cada dígito de control. Decido inicializar manualmente el array,
        ya que las letras no siguen el orden habitual. No encuentro otra forma de hacerlo.*/
        String letras[]={"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};


        do {
            System.out.print("Introduce un NIF/NIE: "); //Se pide el dni al usuario mediante un String pasado por parametro.
            dni = sc.next();

            //Si la longitud del dni introducido es igual a 9 posiciones se comprobara si es válido.
            if (dni.length() == 9) { //La longitud es la misma para todos los formatos

                //NIE - Comprobación de que se ha introducido un NIE. Si la cadena empieza por alguna de esas tres letras.
                if (dni.matches("^(X|Y|Z).*$")) {

                    if (dni.matches("^(X).*$")) {
                        nie = "0" + dni.substring(1, 9); //Como para la letra de control X su digito es 0, se concatena al string inicial omitiendo la posicion 0.
                    } else if (dni.matches("^(Y).*$")) {
                        nie = "1" + dni.substring(1, 9); //Como para la letra de control X su digito es 0, se concatena al string inicial omitiendo la posicion 0.
                    } else if (dni.matches("^(Z).*$")) {
                        nie = "2" + dni.substring(1, 9); //Como para la letra de control X su digito es 0, se concatena al string inicial omitiendo la posicion 0.
                    }

                    String letraControl = nie.substring(0, 8);
                    n = Integer.parseInt(letraControl);
                    letraNie = nie.substring(8);
                    div=n%23;
                }else {

                    /*Para poder calcular el dígito de control necesito solo los numeros, por lo que se guarda en digitos lo que hay hasta la
                    posicion 8, que es ya la letra.*/
                    String digitos = dni.substring(0, 8);
                    //Para comprobar si es válido también necesito la letra por separado.
                    letraDni = dni.substring(8);
                    //Una vez separados los digitos de la letra hay que convertirlos a enteros para poder operar con ellos.
                    n = Integer.parseInt(digitos);
                    //Se divide la variable n que guarda los digitos recien convertidos entre 23 para sacar su resto.
                    div = n % 23;
                }

                //Mediante este for se va comprobando todas las posiciones hasta que alguna coincida con el resto de la division anterior.
                for (int i=0;i<letras.length;i++){
                    if (letras[i]==letras[div]) {
                        String resultado=letras[i]; //Una vez encontrada la coincidencia se guarda en "resultado" la letra que contiene esa posicion del array.

                        if (resultado.equals(letraDni) | resultado.equals(letraNie)){   /*Si la letra que contiene "resultado" es igual a la que el usuario ha introducido
                                                         se para el do-while y se devuelve el dni completo*/
                            control = true;
                        }else{
                            //Si no es válido se informa al usuario y se vuelve a pedir el dato.
                            System.out.println(ANSI_RED + "Error: este documento de identidad no existe." + ANSI_RESET);
                            control = false;
                        }
                    }
                }
            } else {
                System.out.println(ANSI_RED + "Error: (DNI: debe constar de 8 dígitos + letra), (NIE: debe constar de X,Y,Z + 7 dígitos + letra)." + ANSI_RESET);
                control=false;
            }

        }while (!control);  //Mientras control sea falso el bucle seguirá pidiendo dni válidos.

        return dni; //Se devuelve el dni completo
    }


//Funcion main, la he usado para las pruebas, la dejo comentada.
//    public static void main(String[] args) {
//        pedirEntero();
//        pedirEntero("Introduce un entero: ");
//        pedirEnteroPositivo();
//        pedirEnteroPositivo(false, "Introduce un positivo: ");
//        pedirEnteroNegativo("Introduce un negativo: ");
//        pedirEnteroRango(5,10, 3);
//        pedirEnteroRango(5,10);
//        pedirDecimalPositivo(false, "Introduce un decimal: ");
//        pedirDecimalRango(5.7,10.6, 3);
//        String cadena=pedirCadenaLimite(true, true, 70, "Cadena: ");
//        System.out.println(cadena);
//        pedirCadenaLimite(false, false, 10, "Introduce una cadena: ");
//        pedirNIF_NIE("Introduce un NIF/NIE: ");
//    }

}
