package edu.fje.m03uf4projecte;

/**
 * Clase Abstracta Material con Herencia Multiple
 */
public abstract class Material implements Equals {
    /**
     * Atributos String para el titulo y el Autor de los Materiales
     */
    protected String titulo, autor;
    /**
     * Propiedad integer para el año de Publicacion
     */
    int anoPublicacion;

    /**
     * Constructor de la Clase
     * @param titulo Titulo del Material
     * @param autor Autor del Material
     * @param anoPublicacion Año de publicacion del Material
     */
    public Material(String titulo, String autor, int anoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
    }

    /**
     * Getter de la propiedad titulo
     * @return String titulo
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * Getter de la propiedad autor
     * @return String autor
     */
    public String getAutor() {
        return autor;
    }
    /**
     * Getter de la propiedad Año Publicacion
     * @return int anoPublicacion
     */
    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    /**
     *Setter de la propiedad Titulo
     * @param titulo Establece el titulo del Material
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *Setter de la propiedad Autor
     * @param autor Establece el Autor del Material
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Setter de la propiedad Año Publicacion
     * @param anoPublicacion Establece el año de publicacion
     */
    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    @Override
    public String toString() {
        return  "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoPublicacion=" + anoPublicacion;
    }
}
