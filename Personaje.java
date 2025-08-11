public class Personaje {
    String nombre;
    String poder;
    Boolean arma;
    Boolean bueno;
    Integer vida;
    Integer ataque;
    Integer curar;

    //Constructor
    public Personaje(String nombre, String poder, Boolean arma, Boolean bueno, Integer vida, Integer ataque, Integer curar){
        // Referenciar atributos de la clase con los parametros del constructor: this
        this.nombre = nombre;
        this.poder = poder;
        this.arma = arma;
        this.bueno = bueno;
        this.vida = vida;
        this.ataque = ataque;
        this.curar = curar;
    }

    // Método mostrar personaje
    public void mostrarPersonaje() {
        System.out.println("El superheroe es: " + nombre);
        System.out.println("El poder es: " + poder);
        System.out.println("Su arma es: " + arma);
        System.out.println("Es bueno: " + bueno);
        System.out.println("Vida: " + vida);
        System.out.println("El ataque es " + ataque);
        System.out.println("Curar: " + curar);
    }

    // Metodo de ataque
    public void atacar(String nombre1, String nombre2, Integer vida, Integer ataque){
        if (vida > 0){
            vida -= ataque;
            System.out.println(nombre1 + " recibió un ataque " + ataque+ " del personaje " + nombre2);
            System.out.println("La vida del personaje " + nombre1 + " ahora es de "+ vida);
        }else{
            System.out.print("El personaje " + nombre1 + " ha muerto");
        }
    }

    public void curar(String nombre, Integer vida){
        if (vida > 0){
            vida += curar;
            System.out.println("");
        }
    }

    //Método principal
    public static void main(String[] args) {
        //Desde la clase Personaje crear ironman. igual a decir: ironman de tipo Personaje
        Personaje iroman = new Personaje("Ironman", "Plata", true, true, 100, 90, 0);
        Personaje spiderman = new Personaje("Spiderman", "Sentido aracnido", true, true, 100, 80, 0);
        Personaje doctorStrange = new Personaje("Doctor Strange", "Magia", true, true, 100, 90, 60);

        iroman.mostrarPersonaje();
        System.out.println();
        spiderman.atacar(spiderman.nombre, iroman.nombre, spiderman.vida, iroman.ataque);
        doctorStrange.curar("", null);
    }
}