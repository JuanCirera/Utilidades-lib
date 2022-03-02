package utilidades;

import java.util.Random;

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


    /**
     * Devuelve un nombre almacenado en un array de tipo cadena.
     * @return String
     * */
    public static String devolverNombre(){
        Random r1=new Random();
        int indice=r1.nextInt(nombres.length);
        return nombres[indice];
    }

    /**
     * Devuelve un apellido almacenado en un array de tipo cadena.
     * @return String
     * */
    public static String devolverApellidos(){
        Random r2=new Random();
        int indice=r2.nextInt(apellidos.length);
        return apellidos[indice];
    }

    /**
     * Devuelve el nombre de una provincia almacenada en un array de tipo cadena.
     * @return String
     * */
    public static String devolverProvincias(){
        Random r3=new Random();
        int indice=r3.nextInt(provincias.length);
        return provincias[indice];
    }

    /**
     * Devuelve un puesto/posicion aleatoria que escoge del array puestosBaloncesto.
     * @return String
     * */
    public static String devolverPuestosBaloncesto(){
        Random r4=new Random();
        int indice=r4.nextInt(puestosBaloncesto.length);
        return puestosBaloncesto[indice];
    }

    /**
     * Devuelve un puesto/posicion aleatoria que escoge del array puestosBalonmano.
     * @return String
     * */
    public static String devolverPuestosBalomano(){
        Random r5=new Random();
        int indice=r5.nextInt(puestosBalonmano.length);
        return puestosBalonmano[indice];
    }

    /**
     * Devuelve un puesto/posicion aleatoria que escoge del array puestosFutbol.
     * @return String
     * */
    public static String devolverPuestosFutbol(){
        Random r4=new Random();
        int indice=r4.nextInt(puestosFutbol.length);
        return puestosFutbol[indice];
    }


    /**
     * Devuelve el nombre de un equipo aleatorio que escoje del array nombreEquipos.
     * @return String
     * */
    public static String devolverNombresEquipos(){
        Random r7=new Random();
        int indice=r7.nextInt(nombresEquipos.length);
        return nombresEquipos[indice];
    }


    /**
     * Devuelve un entero positivo aleatorio
     * @param cero - true si se permite el cero, false si no se permite el cero
     * @param limite - entero hasta el que se pueden generar aleatorios
     * @return int
     * */
    public static int devolverEnteros(boolean cero, int limite){
        Random r5=new Random();
        if(cero) {
            return r5.nextInt(0, limite);
        }else{
            return r5.nextInt(1, limite);
        }
    }



}
