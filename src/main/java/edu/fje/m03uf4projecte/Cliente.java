package edu.fje.m03uf4projecte;

/**
 * Clase Cliente con subclases CPrivado y CMusica
 */
public class Cliente {
    /**
     * Propiedades para el nombre, correo electronico y direccion del Cliente
     */
    protected String nombre, email, direccion;
    /**
     * Propiedad integer que asigna el numero de puntos que tiene el Cliente
     */
    protected int carnet;

    /**
     * Contructor de la clase Cliente
     * @param nombre Nombre del Cliente
     * @param email Correo electronico del Cliente
     * @param direccion Direccion Fisica del Cliente
     */
    public Cliente(String nombre, String email, String direccion) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.carnet = 50;
    }
    public Cliente(String nombre, String email, String direccion, int carnet) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.carnet = carnet;
    }

    /**
     * Getter de la propiedad Nombre
     * @return String nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter de la propiedad Nombre
     * @param nombre Establece el nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de la propiedad Email
     * @return String email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Setter de la propiedad Email
     * @param email Establece el correo electronico del cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter de la propiedad Direccion
     * @return String direccion
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * Setter de la propiedad Direccion
     * @param direccion Establece la direccion fisica del cliente
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Getter de la propiedad puntos del Carnet
     * @return int carnet
     */
    public int getCarnet() {
        return carnet;
    }
    /**
     * Setter de la propiedad Carnet
     * @param carnet Establece el numero de puntos que tiene el cliente
     */
    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    /**
     * Funcion para restar puntos si el usuario devuelve un libro con retraso
     * @param resta numero de dias fuera del plazo de devuelta
     */
    public void restarPuntos(int resta){
        this.carnet -= resta;
        System.out.println("Disco devuelto con " + resta + " días de retraso. Has perdido " + resta + " puntos. Actualmente te quedan " + this.carnet + " puntos en tu carnet");
    }
}
