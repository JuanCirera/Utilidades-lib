package utilidades;

import java.util.Calendar;
import java.util.Date;

/**
 * Gestiona fechas, almacenando dia, mes y año siguiendo unas comprobaciones para que sean válidos.
 * */
public class Fecha {

    //CONSTANTES
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    //ATRIBUTOS
    protected int day;
    protected int month;
    protected int year;

//    private static int minYear;
//    private static int maxYear;

    //CONSTRUCTOR VACIO
    public Fecha(){
        //Valores por defecto
        this.day=0000;
        this.month=00;
        this.year=00;
    }

    //CONSTRUCTOR CON PARAMETROS
    public Fecha(int day, int month, int year){
        if(checkYear() && checkMonth() && checkDay()) {
            //Si se cumplen la condicion triple se guardaran los valores en cada atributo
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    //GETTERS
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    //SETTERS

    /**
     * Set único para los tres atributos de la fecha
     * @param year
     * @param month
     * @param day
     * @return boolean
     * */
    public boolean setDate(int year, int month, int day) {
        //Se llaman a las tres funciones
        checkYear();
        checkMonth();
        checkDay();

        if(checkYear() && checkMonth() && checkDay()) {
            //Si se cumplen la condicion triple se guardaran los valores en cada atributo
            this.year = year;
            this.month = month;
            this.day = day;
            //Devuelve true si se han podido almacenar los valores
            return true;
        }else{
            //Si no, devuelve false
            return false;
        }
    }

//    public static void setMinYear(int year) {
//        minYear = year;
//    }
//
//    public static void setMaxYear(int year) {
//        maxYear = year;
//    }

    //FUNCIONES
    /**
     * Comprueba si el año es bisiesto, además de que esté entre el 0 y el actual.
     * @return boolean
     * */
    private boolean checkYear(){
        boolean control=false; //He tenido que usar una variable de control porque en el if anidado no podía hacer el return.
        //Instancio un objeto de la API Calendar para obtener el año actual.
        Calendar calendar = Calendar.getInstance();
        int actual=calendar.get(Calendar.YEAR);

        //La diferencia de tiempo no deberá exceder los 105 años y no será menor de 1 año.
//        if (actual - year >= 1 && actual - year <= 200){ Este if solo servía para el proyecto de federacion (practica 4)
        if (actual - year >= 1 && year > 0){
            int division=year%4;
            int division2=year%100;

            if(division==0 || division2==0){
                //Devuelve true si el año es bisiesto
                control=true;

            }else if(division!=0 && division2!=0){
                //Devuelve false si no es bisiesto
                control=false;
            }
        }else{
            System.out.println(ANSI_RED+"Introduce un valor válido (1-"+actual+")"+ANSI_RESET);
        }
        return control;
    }


    /**
     * Comprueba si el año es bisiesto, además de que esté entre el 0 y el actual.
     * @param year - año a comprobar, dato ajeno a la clase Fecha.
     * @return boolean
     * */
    public static boolean checkYear(int year){
        boolean control=false; //He tenido que usar una variable de control porque en el if anidado no podía hacer el return.
        //Instancio un objeto de la API Calendar para obtener el año actual.
        Calendar calendar = Calendar.getInstance();
        int actual=calendar.get(Calendar.YEAR);

        //La diferencia de tiempo no deberá exceder los 105 años y no será menor de 1 año.
//        if (actual - year >= 1 && actual - year <= 200){ Este if solo servía para el proyecto de federacion (practica 4)
        if (actual - year >= 1 && year > 0){
            int division=year%4;
            int division2=year%100;

            if(division==0 || division2==0){
                //Devuelve true si el año es bisiesto
                control=true;

            }else if(division!=0 && division2!=0){
                //Devuelve false si no es bisiesto
                control=false;
            }
        }else{
            System.out.println(ANSI_RED+"Introduce un valor válido (1-"+actual+")"+ANSI_RESET);
        }
        return control;
    }


    /**
     * Comprueba si el valor del mes está entre 1 y 12.
     * @return boolean
     * */
    private boolean checkMonth(){
//        boolean control=false;
        if(month>0 && month<=12){
            return true;
        }else{
            System.out.println(ANSI_RED+"Introduce un valor válido (1-12)"+ANSI_RESET);
            return false;
        }
    }


    /**
     * Comprueba si el valor del mes está entre 1 y 12.
     * @param month - mes que se quiere comprobar, ajeno a la clase Fecha.
     * @return boolean
     * */
    public static boolean checkMonth(int month){
//        boolean control=false;
        if(month>0 && month<=12){
            return true;
        }else{
            System.out.println(ANSI_RED+"Introduce un valor válido (1-12)"+ANSI_RESET);
            return false;
        }
    }


    /**
     * Comprueba si el dia está entre 1 y 31, 1-28 si el mes es febrero y el año NO bisiesto, 1-29 si es febrero y año bisiesto.
     * @return boolean
     * */
    private boolean checkDay(){
        boolean control=false;
        if(!checkYear() && month!=2){
            if(day>0 && day<=31) { //Vamos a pensar que todos los meses tienen 31 para no complicar mucho la funcion
                control = true;
            }
        }else if(!checkYear() && month==2){
            if(day>0 && day<=28) {
                control = true;
            }
        }else if(checkYear() && month==2){
            if(day>0 && day<=29) {
                control = true;
            }
        }else{
            System.out.println(ANSI_RED+"Error. El dia introducido no existe."+ANSI_RESET);
            control=false;
        }
        return control;
    }


//    /**
//     * Comprueba si el dia está entre 1 y 31, 1-28 si el mes es febrero y el año NO bisiesto, 1-29 si es febrero y año bisiesto.
//     * @param day - día que se quiere comprobar, externo de la clase Fecha.
//     * @return boolean
//     * */
//    public static boolean checkDay(int day){
//        boolean control=false;
//        if(!checkYear() && month!=2){
//            if(day>0 && day<=31) { //Vamos a pensar que todos los meses tienen 31 para no complicar mucho la funcion
//                control = true;
//            }
//        }else if(!checkYear() && month==2){
//            if(day>0 && day<=28) {
//                control = true;
//            }
//        }else if(checkYear() && month==2){
//            if(day>0 && day<=29) {
//                control = true;
//            }
//        }else{
//            System.out.println(ANSI_RED+"Error. El dia introducido no existe."+ANSI_RESET);
//            control=false;
//        }
//        return control;
//    }


    /**
     * Funcion que comprueba si la fecha pasada por parámetro cae en fin de semana
     * @return boolean - true si el dia coincide con sábado o domingo, false si no.
     * */
    public static boolean isWeekend(int day, int month, int year){
        Calendar cal=Calendar.getInstance(); //se crea un objeto calendar
        //despues usando el objeto Fecha del parametro se hace este apaño para convertirlo en un objeto calendar
        //metiendole con su setter los valores del objeto fecha, año, mes, dia.
        cal.set(year,month,day);
        //Se "transforma" el numero de dia a "cadena" por asi decirlo
        int dia= cal.get(Calendar.DAY_OF_WEEK); //Se hace un get al atributo DAY_Of_WEEK que coje valores con el nombre de los 7 dias

        if(dia==Calendar.SATURDAY || dia==Calendar.SUNDAY){
            return true;    //Si el dia coincide con sábado o domingo
        }else{
            return false;
        }
    }


    /**
     * Funcion que comprueba si el dia del objeto fecha cae en fin de semana
     * @return boolean - true si el dia coincide con sábado o domingo, false si no.
     * */
    public boolean isWeekend(){
        Calendar cal=Calendar.getInstance(); //se crea un objeto calendar
        //despues usando el objeto Fecha del parametro se hace este apaño para convertirlo en un objeto calendar
        //metiendole con su setter los valores del objeto fecha, año, mes, dia.
        cal.set(year,month,day);
        //Se "transforma" el numero de dia a "cadena" por asi decirlo
        int dia= cal.get(Calendar.DAY_OF_WEEK); //Se hace un get al atributo DAY_Of_WEEK que coje valores con el nombre de los 7 dias

        if(dia==Calendar.SATURDAY || dia==Calendar.SUNDAY){
            return true;    //Si el dia coincide con sábado o domingo
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
