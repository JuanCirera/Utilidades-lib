package utilidades;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Juan Fco Cirera Rosa
 */
public class Faker {

    //Nombres
    private static String nombres[]={"Juan", "María", "Pedro", "Jose", "Rafael", "Francisco", "Carlos", "Luis", "David", "Marina", "Sonia", "Sebastian", "Ramon", "Raul", "Sergio", "Antonio", "Manuel", "Javier",
                                    "Daniel", "Jesus", "Francisco Javier", "Jose Antonio", "Jose Luis", "Alejandro", "Miguel", "Pablo", "Angel", "Jose Maria", "Fernando", "Alberto", "Jorge", "Alvaro", "Adrian",
                                    "Ivan", "Jose Manuel", "Ruben", "Enrique", "Oscar", "Vicente", "Diego", "Juan Jose", "Andres", "Joaquin", "Roberto"};
    //Apellidos
    private static String apellidos[]={"Lopez", "Cirera", "Ureña", "Rosa", "Fernández", "Herrada", "Amate", "Montoro", "Lopera", "Diaz", "Salinas", "Pérez", "Domene", "González", "Ruano", "García", "González",
                                        "Rodriguez", "Fernández", "Martínez", "Aguilar", "Sánchez", "Pérez", "Gómez", "Martin", "Jiménez", "Ruiz", "Diaz", "Moreno", "Muñoz", "Álvarez", "Romero",
                                        "Gutierrez", "Navarro", "Torres", "Domínguez", "Vázquez", "Ramos", "Gil", "Ramírez", "Serrano", "Blanco", "Molina"};
    //Provincias
    private static String provincias[]={"Almería", "Córdoba", "Granada", "Murcia", "Madrid", "Cádiz", "Sevilla", "Málaga", "Huelva", "Segovia", "Zaragoza", "Teruel", "Vizcaya", "Zamora", "Valencia", "Navarra",
                                        "Toledo", "Soria", "Tarragona", "Palencia", "Salamanca", "Pontevedra", "Lugo", "León", "Cuenca", "Guadalajara", "Burgos", "Cáceres", "Albacete", "Asturias", "Badajoz",
                                        "Baleares", "Barcelona", "Ávila", "Álava", "A Coruña", "Gipuzkoa", "Lérida", "La Rioja", "Girona", "Castellón", "Ourense"};

    //Equipos
    private static String nombresEquipos[]={"Real Madrid CF", "FC Barcelona", "Club Atlético de Madrid", "Real Sociedad de Fútbol", "Real Betis Balompié", "Sevilla FC", "Villareal CF", "Valencia CF", "Getafe CF",
                                            "Rayo Vallecano", "Real Madrid Baloncesto", "Los Angeles Lakers", "Real Betis Baloncesto", "Atlanta Hawks", "Barcelona Baloncesto", "Chicago Bulls", "Selección de balonmano de España",
                                            "Club Balonmano Ciudad Real", "Club Balonmano Cantabria", "Club Balonmano Logroño"};

    //Puestos
    private static String puestosBaloncesto[]={"base","alero","pivot","escolta","alta-pivot"};

    private static String puestosBalonmano[]={"portero","central","extremo","lateral","pivot"};

    private static String puestosFutbol[]={"delantero","defensa","portero","centrocampista"};

    //Nombres hospitales
    private static String hospitales[]={"Torrecárdenas","Hospital de Poniente","Hospital de Guadix", "El Toyo", "Virgen de las Nieves", "Comarcal Santa Ana de Motril", "Comarcal de Baza", "Comarcal la Inmaculada",
                                        "Comarcal de la Axarquia", "Virgen de la Victoria", "Hospital Costa del Sol", "Reina Sofía", "Universitario Virgen Macarena", "Mediterráneo"};
    //Nombres clinicas
    private static String clinicas[]={"HLA Mediterráneo","Ginealmeria","Policlínica del Poniente","Clínica El Sur","Clínicas Esquivel Málaga", "CelluMed Clinic","Clínica Médica Hiperbárica de Estepona"};

    //Especialidades médicas
    private static String especialidades[]={"traumatologia","dermatologia","oftalmologia","neurologia"};

    //Areas hospital
    private static String areas[]={"traumatologia","dermatologia","oftalmologia","neurologia","urgencias","quirofano","administracion"};

    //Sexo
    private static String sexo[]={"hombre","mujer"};


    /**
     * Devuelve un nombre almacenado en un array de tipo cadena.
     * @return String
     * */
    public static String devolverNombre(){
        Random r=new Random();
        int indice=r.nextInt(nombres.length);
        return nombres[indice];
    }

    /**
     * Devuelve un apellido almacenado en un array de tipo cadena.
     * @return String
     * */
    public static String devolverApellidos(){
        Random r=new Random();
        int indice=r.nextInt(apellidos.length);
        return apellidos[indice];
    }

    /**
     * Devuelve el nombre de una provincia almacenada en un array de tipo cadena.
     * @return String
     * */
    public static String devolverProvincias(){
        Random r=new Random();
        int indice=r.nextInt(provincias.length);
        return provincias[indice];
    }

    /**
     * Devuelve un puesto/posicion aleatoria que escoge del array puestosBaloncesto.
     * @return String
     * */
    public static String devolverPuestosBaloncesto(){
        Random r=new Random();
        int indice=r.nextInt(puestosBaloncesto.length);
        return puestosBaloncesto[indice];
    }

    /**
     * Devuelve un puesto/posicion aleatoria que escoge del array puestosBalonmano.
     * @return String
     * */
    public static String devolverPuestosBalomano(){
        Random r=new Random();
        int indice=r.nextInt(puestosBalonmano.length);
        return puestosBalonmano[indice];
    }

    /**
     * Devuelve un puesto/posicion aleatoria que escoge del array puestosFutbol.
     * @return String
     * */
    public static String devolverPuestosFutbol(){
        Random r=new Random();
        int indice=r.nextInt(puestosFutbol.length);
        return puestosFutbol[indice];
    }


    /**
     * Devuelve el nombre de un equipo aleatorio que escoje del array nombreEquipos.
     * @return String
     * */
    public static String devolverNombresEquipos(){
        Random r=new Random();
        int indice=r.nextInt(nombresEquipos.length);
        return nombresEquipos[indice];
    }


    /**
     * Devuelve un entero positivo aleatorio
     * @param cero - true si se permite el cero, false si no se permite el cero
     * @param limite - entero hasta el que se pueden generar aleatorios
     * @return int
     * */
    public static int devolverEnteros(boolean cero, int limite){
        Random r=new Random();
        if(cero) {
            return r.nextInt(0, limite);
        }else{
            return r.nextInt(1, limite);
        }
    }

    /**
     * Devuelve el nombre de un hospital aleatorio.
     * @return String
     * */
    public static String devolverHospitales(){
        Random r=new Random();
        int indice=r.nextInt(hospitales.length);
        return hospitales[indice];
    }

    /**
     * Devuelve el nombre de una clinica aleatoria.
     * @return String
     * */
    public static String devolverClinicas(){
        Random r=new Random();
        int indice=r.nextInt(clinicas.length);
        return clinicas[indice];
    }

    /**
     * Devuelve una especialidad aleatoria.
     * @return String
     * */
    public static String devolverEspecialidad(){
        Random r=new Random();
        int indice=r.nextInt(especialidades.length);
        return especialidades[indice];
    }

    /**
     * Devuelve un area medica aleatoria.
     * @return String
     * */
    public static String devolverArea(){
        Random r=new Random();
        int indice=r.nextInt(areas.length);
        return areas[indice];
    }


    /**
     * Devuelve hombre/mujer.
     * @return String
     * */
    public static String devolverSexo(){
        Random r=new Random();
        int indice=r.nextInt(sexo.length);
        return sexo[indice];
    }


    /**
     * Función que genera un NIF/NIE, lo chequea y lo devuelve.
     * @return NIE o NIF válido.
     */
    public static String generarNIF_NIE(){

        String nie = "", letraDni = "", letraNie = "";
        String dni = "";
        int n, div; //Variables para el cálculo del dígito de control
        boolean control = false;  //true=Para el bucle, false=Sigue el bucle

        /*Array para las letras que corresponden a cada dígito de control. Decido inicializar manualmente el array,
        ya que las letras no siguen el orden habitual. No encuentro otra forma de hacerlo.*/
        String letras[]={"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};


        do {
            //Este bloque inicial genera los 8 numeros de forma aleatoria y los concatena con una letra de control aleatoria
            Random r = new Random();
            int nDni = 0;
            String numeros="";
            //Se generan 8 numeros uno a uno, concatenándose con el anterior.
            for (int i = 0; i < 8; i++) {
                nDni = r.nextInt(9);
                numeros = numeros + Integer.toString(nDni); //Convierto el entero en un String para poder concatenar, para que no se sumen.
            }

            //Se genera un nº aleatorio que será una posicion del array letras[]
            Random r1 = new Random();
            int indice = r1.nextInt(letras.length);
            String letraC = letras[indice];

            //Se concatenan los 8 numeros con la letra de control
            dni=numeros+letraC;

            //Y todo esto para tener que dividir de nuevo el dni para comprobarlo aquí abajo...


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
                            control = false;
                        }
                    }
                }
            } else {
                control=false;
            }

        }while (!control);  //Mientras control sea falso el bucle seguirá pidiendo dni válidos.

        return dni; //Se devuelve el dni completo
    }

//    public static void main(String[] args) {
//        System.out.println(generarNIF_NIE());
//    }

}
