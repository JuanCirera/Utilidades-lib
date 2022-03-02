package utilidades;

import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Juan Fco Cirera Rosa
 */
public class PeticionDatos {

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

    /**
     * Función que pide un número entero por teclado y lo devuelve.
     * @return Entero válido introducido por teclado.
     */
    public static int pedirEntero(){
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
     * Función que pide un número entero por teclado y lo devuelve.
     * @param texto String que se va a mostrar en la petición.
     * @return Entero válido introducido por teclado
     */
    public static int pedirEntero(String texto){    //Es exactamente igual que la anterior, solo cambia el parametro.
        Scanner sc=new Scanner(System.in);
        int n=0;
        boolean control=false;

        do {
            try {
                System.out.print(texto);  //Mostrará el texto que se le pase por parametro para pedir el dato.
                n = sc.nextInt();
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
     * Función que pide un número entero mayor o igual a 0 por teclado y lo devuelve.
     * @return Entero mayor o igual a 0 válido introducido por teclado.
     */
    public static int pedirEnteroPositivo(){
        Scanner sc=new Scanner(System.in);
        int n=0;
        boolean control=false;

        do {
            try {
                System.out.print("Introduce un entero positivo: ");
                n = sc.nextInt();
                if (n>=0){
                    control=true;   //Si el número introducido es válido y mayor o igual a 0 control valdrá true y se guardara el dato
                }else{
                    System.out.println(ANSI_RED+"Error: se debe introducir un positivo."+ANSI_RESET);
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
     * Función que pide un número entero mayor o igual a 0 según el parámetro de entrada.
     * @param cero true si acepta el cero y false si no lo acepta.
     * @param texto String a mostrar en la petición.
     * @return Entero mayor o igual a 0 introducido por teclado según el parámetro de entrada.
     */
    public static int pedirEnteroPositivo(boolean cero, String texto){
        Scanner sc=new Scanner(System.in);
        int n=0;
        boolean control=false;

        do {
            try {
                System.out.print(texto);  //Texto a mostrar introducido por parametro para pedir el dato.
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

    /**
     * Función que pide un número entero menor a 0.
     * @param texto String a mostrar en la petición.
     * @return Entero menor a 0 introducido por teclado.
     */
    public static int pedirEnteroNegativo(String texto){
        Scanner sc=new Scanner(System.in);
        int n=0;
        boolean control=false;

        do {
            try {
                System.out.print(texto); //String que se pasa por parametro para mostrar en pantalla y pedir el dato.
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

    /**
     * Función que pide un número entero dentro del rango indicado por los parámetros incluyendo ambos límites.
     * @param limite1 Indica uno de los limites (superior/inferior).
     * @param limite2 Indica uno de los limites (superior/inferior).
     * @return Entero válido introducido por teclado dentro del rango de los límites indicados, pudiendo ser uno de los límites.
     */
    public static int pedirEnteroRango(int limite1, int limite2, String texto){
        Scanner sc=new Scanner(System.in);
        int n=0;
        boolean control=false;

        do {
            try {
//                System.out.print("Introduce un numero entre "+limite1+" y "+limite2+": ");
                System.out.print(texto);
                n = sc.nextInt();
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
     * Función que pide un número entero por teclado dentro del rango indicado por los parámetros incluyendo los límites según el tercer parámetro y lo devuelve.
     * @param limite1 Indica uno de los límites (superior/inferior).
     * @param limite2 Indica el otro límite (inferior/superior).
     * @param incluido 0 si no está incluido ninguno de los límites, 1 si está incluido limite1, pero no limite2, 2 si está incluido limite2 pero no limite1,
     * 3 si ambos límites están incluidos. Si vale cualquier otra cosa se considerará como 0.
     * @return Entero válido introducido por teclado dentro del rango de los límites indicados, incluidos estos o no según parámetro.
     */
    public static int pedirEnteroRango(int limite1, int limite2, int incluido, String texto){
        Scanner sc=new Scanner(System.in);
        int n=0;
        boolean control=false;

        do {
            try {
                switch (incluido) {
                    case 0:
//                        System.out.print("Introduce un numero entre " + limite1 + " y " + limite2 + ": ");
                        System.out.print(texto);
                        n = sc.nextInt();
                        if (n > limite1 && n < limite2) { //Si el número es mayor que limite1 y menor que limite2, se guarda.
                            control = true;   //Si el número introducido es válido y menor que 0, control valdrá true y se guardara el dato
                        } else {
                            System.out.println(ANSI_RED + "Error: el numero debe estar dentro del rango, ambos excluidos." + ANSI_RESET);
                        }
                        break;
                    case 1:
                        System.out.print(texto);
                        n = sc.nextInt();
                        if (n >= limite1 && n < limite2) { //Si el número es mayor o igual que limite1 y menor que limite2.
                            control = true;
                        } else {
                            System.out.println(ANSI_RED + "Error: el numero debe estar dentro del rango." + ANSI_RESET);
                        }
                        break;
                    case 2:
                        System.out.print(texto);
                        n = sc.nextInt();
                        if (n > limite1 && n <= limite2) { //Si el número es mayor que limite1 y menor o igual que limite2.
                            control = true;
                        } else {
                            System.out.println(ANSI_RED + "Error: el numero debe estar dentro del rango." + ANSI_RESET);
                        }
                        break;
                    case 3:
                        System.out.print(texto);
                        n = sc.nextInt();
                        if (n >= limite1 && n <= limite2) { //Si el número es mayor que limite1 y menor o igual que limite2, se guarda.
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
     * Función que pide un número decimal.
     * @param texto String a mostrar en la petición.
     * @return Decimal válido introducido por teclado.
     */
    public static double pedirDecimal(String texto) {
        Scanner sc = new Scanner(System.in);  //Instancia del objeto tipo Scanner
        double n = 0;
        boolean control = false;  //Variable de control

        do {
            try {
                System.out.print(texto);
                n = sc.nextDouble();
                control = true;

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
     * Función que pide un número decimal mayor o igual a 0.
     * @param cero Se pasará true si acepta el cero y false si no lo acepta.
     * @param texto String a mostrar en la petición.
     * @return Decimal mayor o igual a 0 válido introducido por teclado según el parámetro de entrada.
     */
    public static double pedirDecimalPositivo(boolean cero, String texto) {
        Scanner sc = new Scanner(System.in);  //Instancia del objeto tipo Scanner
        double n = 0;
        boolean control = false;  //Variable de control

        do {
            try {
                System.out.print(texto);
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
     * Función que pide un número decimal menor a 0.
     * @param texto String a mostrar en la petición.
     * @return Decimal menor a 0 válido introducido por teclado.
     */
    public static double pedirDecimalNegativo(String texto) {
        Scanner sc = new Scanner(System.in);  //Instancia del objeto tipo Scanner
        double n = 0;
        boolean control = false;  //Variable de control

        do {
            try {
                System.out.print(texto);
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
     * @param texto String a mostrar en la petición.
     * @return Decimal válido introducido por teclado dentro del rango de los límites indicados, pudiendo ser uno de los límites.
     */
    public static double pedirDecimalRango(double limite1, double limite2, String texto){
        Scanner sc=new Scanner(System.in);
        double n=0;
        boolean control=false;

        do {
            try {
                System.out.print(texto);
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
     * Función que pide un número decimal por teclado dentro del rango indicado por los parámetros incluyendo los límites según el tercer parámetro.
     * @param limite1 Indica uno de los límites (superior/inferior).
     * @param limite2 Indica el otro límite (superior/inferior).
     * @param incluido Valdrá 0 si no está incluido ninguno de los limites, 1 si está incluido limite1 pero no limite2, 2 si está incluido limite2 pero no limite1, 3 si ambos limites estan incluidos. Si vale cualquier otra cosa se considerará como si fuera 0.
     * @param texto String a mostrar en la peticion.
     * @return Decimal válido introducido por teclado dentro del rango de los límites indicados, incluidos estos o no según parámetro.
     */
    public static double pedirDecimalRango(double limite1, double limite2, double incluido, String texto){
        Scanner sc=new Scanner(System.in);
        double n=0;
        boolean control=false;

        if (incluido!=limite1 && incluido!=limite2){   //Ambos límites excluidos
            incluido=0;
        }else if(incluido==limite1 && incluido!=limite2){   //Limite1 incluido
            incluido=1;
        }else if(incluido==limite2 && incluido!=limite1){   //Limite2 incluido
            incluido=2;
        }else if(incluido==limite1 && incluido==limite2){   //Ambos límites incluidos
            incluido=3;
        }

        do {
            try {
                if (incluido==0) {
                    System.out.print(texto);
                    n = sc.nextDouble();
                    if (n > limite1 && n < limite2) { //Si el número es mayor que limite1 y menor que limite2, se guarda.
                        control = true;   //Si el número introducido es válido y menor que 0, control valdrá true y se guardara el dato
                    } else {
                        System.out.println(ANSI_RED + "Error: el numero debe estar dentro del rango, ambos excluidos." + ANSI_RESET);
                    }
                }else if(incluido==1) {
                    System.out.print(texto);
                    n = sc.nextDouble();
                    if (n >= limite1 && n < limite2) { //Si el número es mayor o igual que limite1 y menor que limite2.
                        control = true;
                    } else {
                        System.out.println(ANSI_RED + "Error: el numero debe estar dentro del rango." + ANSI_RESET);
                    }
                }else if(incluido==2) {
                    System.out.print(texto);
                    n = sc.nextDouble();
                    if (n > limite1 && n <= limite2) { //Si el número es mayor que limite1 y menor o igual que limite2.
                        control = true;
                    } else {
                        System.out.println(ANSI_RED + "Error: el numero debe estar dentro del rango." + ANSI_RESET);
                    }
                }else if(incluido==3) {
                    System.out.print(texto);
                    n = sc.nextDouble();
                    if (n >= limite1 && n <= limite2) { //Si el número es mayor que limite1 y menor que limite2, se guarda.
                        control = true;   //Si el número introducido es válido y menor que 0, control valdrá true y se guardara el dato
                    } else {
                        System.out.println(ANSI_RED + "Error: el numero debe estar dentro del rango, ambos incluidos." + ANSI_RESET);
                    }
                }else{
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
     * Función que pide una cadena de caracteres por teclado en la que no haya números ni símbolos de puntuación.
     * @return Cadena de caracteres introducida por teclado en la que no haya números ni símbolos de puntuación.
     */
    public static String pedirCadena(){
        Scanner sc=new Scanner(System.in);  //Instancia del objeto tipo Scanner
        String cadena="";
        boolean control=false;  //Variable de control

        do {
            try {
                System.out.print("Introduce una cadena de caracteres: ");
                cadena = sc.next();

                if (cadena.matches(".*\\d.*")) { //No se aceptan numeros en el String
                    System.out.println(ANSI_RED + "Error: No se admiten numeros." + ANSI_RESET);
                    control = false;
                } else if (!cadena.matches("[a-zA-Z0-9]*")) { //NO se aceptan caracteres especiales
                    System.out.println(ANSI_RED + "Error: No se admiten caracteres especiales." + ANSI_RESET);
                    control = false;
                } else {
                    control = true; //En caso de escribir una cadena normal sin numeros y sin simbolos, control para el bucle y la devuelve.
                }

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

        return cadena;
    }

    /**
     * Función que pide una cadena de caracteres por teclado en la que no haya números ni símbolos de puntuación.
     * @param texto String a mostrar en la petición.
     * @return Cadena de caracteres introducida por teclado en la que no haya números ni símbolos de puntuación.
     */
    public static String pedirCadena(String texto){
        Scanner sc=new Scanner(System.in);  //Instancia del objeto tipo Scanner
        String cadena="";
        boolean control=false;  //Variable de control

        do {
            try {
                System.out.print(texto);
                cadena = sc.next();

                if (cadena.matches(".*\\d.*")) { //No se aceptan numeros en el String
                    System.out.println(ANSI_RED + "Error: No se admiten numeros." + ANSI_RESET);
                    control = false;
                } else if (!cadena.matches("[a-zA-Z0-9]*")) { //NO se aceptan caracteres especiales
                    System.out.println(ANSI_RED + "Error: No se admiten caracteres especiales." + ANSI_RESET);
                    control = false;
                } else {
                    control = true; //En caso de escribir una cadena normal sin numeros y sin simbolos, control para el bucle y la devuelve.
                }

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

        return cadena;
    }

    /**
     * Función que pide un carácter por teclado.
     * @param texto String a mostrar en la petición.
     * @return Carácter introducido por teclado.
     */
    public static char pedirCaracter(String texto){
        Scanner sc=new Scanner(System.in);  //Instancia del objeto tipo Scanner
        char cadena=' ';
        boolean control=false;  //Variable de control

        do {
            try {
                System.out.print(texto);
                cadena = sc.next().charAt(0);
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

        return cadena;
    }

    /**
     * Función que pide una cadena de caracteres por teclado que tendrá números y/o símbolos de puntuación y una longitud determinada según los parámetros de entrada.
     * @param numero true si se aceptan números en la cadena y false si no se aceptan.
     * @param simbolo true si se aceptan símbolos y false si no se aceptan.
     * @param limite Indica el número máximo de caracteres que se quieren.
     * @return Cadena de caracteres introducida por teclado que cumple las condiciones indicadas por parámetros.
     */
    public static String pedirCadenaLimite(boolean numero, boolean simbolo, int limite) {
        Scanner sc=new Scanner(System.in);  //Instancia del objeto tipo Scanner
        String cadena="";
        boolean control=false;  //true=Para el bucle, false=Sigue el bucle

        do {
            try {
                System.out.print("Introduce una cadena de caracteres: ");
                cadena = sc.next();
                if (cadena.length()<=limite) { //Se limita la longitud máxima de la cadena segun el valor pasado por parametro.
                                                //Si la longitud supera el límite no se hara nada más, se volverá a pedir la cadena.

                    //Usando expresiones regulares se busca si la cadena contiene algun numero o algun simbolo.
                    if (numero == true && cadena.matches(".*\\d.*")) { //Se aceptan numeros en el String

                        control = true; //En caso de cumplir la condicion no se muestra nada porque el valor se devuelve al final de la funcion.

                    } else if (numero == false && cadena.matches(".*\\d.*")) { //No se aceptan numeros en el String
                        System.out.println(ANSI_RED + "Error: No se admiten numeros." + ANSI_RESET);
                        control = false;
                    } else {
                        control = true; //En caso de escribir una cadena normal sin numeros y sin simbolos, control para el bucle y la devuelve.
                    }

                    if (simbolo == true && !cadena.matches("[a-zA-Z0-9]*")) {  //Se aceptan caracteres especiales en el String

                        control = true;

                    } else if (simbolo == false && !cadena.matches("[a-zA-Z0-9]*")) { //NO se aceptan caracteres especiales
                        System.out.println(ANSI_RED + "Error: No se admiten caracteres especiales." + ANSI_RESET);
                        control = false;
                    } else {
                        control = true;
                    }
                }else{  //Se informa al usuario de que ha pasado el limite
                    System.out.println(ANSI_RED+"Error: se ha excedido la longitud máxima especificada."+ANSI_RESET);
                    control=false;
                }
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

        return cadena;

    }

    /**
     * Función que pide una cadena de caracteres por teclado que tendrá números y/o símbolos de puntuación y una longitud determinada según los parámetros de entrada.
     * @param numero true si se aceptan números en la cadena y false si no se aceptan.
     * @param simbolo true si se aceptan símbolos y false si no se aceptan.
     * @param limite Indica el número máximo de caracteres que se quieren.
     * @param texto String a mostrar en la peticion.
     * @return Cadena de caracteres introducida por teclado que cumple las condiciones indicadas por parámetros.
     */
    public static String pedirCadenaLimite(boolean numero, boolean simbolo, int limite, String texto) {
        Scanner sc=new Scanner(System.in);  //Instancia del objeto tipo Scanner
        String cadena="";
        boolean control=false;  //true=Para el bucle, false=Sigue el bucle

        do {
            try {
                System.out.print(texto);
                cadena =sc.nextLine();  /*Para esta funcion en concreto NO se puede usar next() porque NO cuenta los espacios en blanco,
                                        por eso he decido usar nextLine().*/

                if (cadena.length()<=limite) { //Se limita la longitud máxima de la cadena segun el valor pasado por parametro.
                    //Si la longitud supera el límite no se hara nada más, se volverá a pedir la cadena.

                    //Usando expresiones regulares se busca si la cadena contiene algun numero o algun simbolo.
                    if (numero == true && cadena.matches(".*\\d.*")) { //Se aceptan numeros en el String

                        control = true; //En caso de cumplir la condicion no se muestra nada porque el valor se devuelve al final de la funcion.

                    } else if (numero == false && cadena.matches(".*\\d.*")) { //No se aceptan numeros en el String
                        System.out.println(ANSI_RED + "Error: No se admiten numeros." + ANSI_RESET);
                        control = false;
                    } else if (simbolo == true && !cadena.matches("[a-zA-Z0-9]*")) {  //Se aceptan caracteres especiales en el String

                        control = true;

                    } else if (simbolo == false && !cadena.matches("[a-zA-Z0-9]*")) { //NO se aceptan caracteres especiales
                        System.out.println(ANSI_RED + "Error: No se admiten caracteres especiales." + ANSI_RESET);
                        control = false;
                    } else {
                        control = true; //En caso de escribir una cadena normal sin numeros y sin simbolos, control para el bucle y la devuelve.
                    }


                }else{  //Se informa al usuario de que ha pasado el limite
                    System.out.println(ANSI_RED+"Error: se ha excedido la longitud máxima especificada."+ANSI_RESET);
                    control=false;
                }
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

        return cadena;

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

    /**
     * Función que pide una cadena de caracteres por teclado con el formato de NIF/NIE, lo chequea y lo devuelve.
     * @param texto String a mostrar en la peticion.
     * @return Cadena de caracteres introducida por teclado que sea un NIE o un NIF válido.
     */
    public static String pedirNIF_NIE(String texto){
        Scanner sc=new Scanner(System.in);  //Instancia del objeto tipo Scanner
        int n, div; //Variables para el cálculo del dígito de control
        String dni="";  //Variable donde se almacenara el dni introducido y en caso de ser válido será el dato a devolver.
        String nie="", letraDni="", letraNie="";
        boolean control=false;  //true=Para el bucle, false=Sigue el bucle

        /*Array para las letras que corresponden a cada dígito de control. Decido inicializar manualmente el array,
        ya que las letras no siguen el orden habitual. No encuentro otra forma de hacerlo.*/
        String letras[]={"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};


        do {
            System.out.print(texto); //Se pide el dni al usuario mediante un String pasado por parametro.
            dni = sc.next();

            //Si la longitud del dni introducido es igual a 9 posiciones se comprobara si es válido.
            if (dni.length() == 9) { //La longitud es la misma para todos los formatos

                /*NIE - Comprobación de que se ha introducido un NIE. Si la cadena empieza por alguna de esas tres letras
                se realizaran las operaciones relacionadas con el nie, si no, se harán las del nif.*/
                if (dni.matches("^(X|Y|Z).*$")) {
                    //**Operaciones para el NIE**

                    //Se "cambia" dicha letra por su dígito de control correspondiente, siendo aun un String.
                    if (dni.matches("^(X).*$")) {
                        //En nie se guarda un string con el nie original pero con digito de control.
                        nie = "0" + dni.substring(1, 9); //Como para la letra de control X su digito es 0, se concatena al string inicial omitiendo la posicion 0.
                    } else if (dni.matches("^(Y).*$")) {
                        nie = "1" + dni.substring(1, 9);
                    } else if (dni.matches("^(Z).*$")) {
                        nie = "2" + dni.substring(1, 9);
                    }

                    String letraControl = nie.substring(0, 8);
                    //Despues se pasan las posiciones de la 0 a la 8 a enteros para poder realizar la division.
                    n = Integer.parseInt(letraControl);
                    //La posicion 8, la letra, se guarda en letraNie para poder compararla luego en el for con la letra que contenga la casilla del array.
                    letraNie = nie.substring(8);
                    //Se divide entre 23 como si fuera un dni normal.
                    div=n%23;

                }else { //**Operaciones para el NIF**

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
//        pedirCadena("Introduce una cadena: ");
//        pedirCadenaLimite(false, false, 10, "Introduce una cadena: ");
//        pedirNIF_NIE("Introduce un NIF/NIE: ");
//    }

}
