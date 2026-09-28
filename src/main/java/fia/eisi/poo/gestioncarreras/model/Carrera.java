package fia.eisi.poo.gestioncarreras.model;

import fia.eisi.poo.gestioncarreras.util.Datos;

/**
 *
 * @author Rudy
 */
public class Carrera {
    private String codigo;
    private String nombre;
    private String titulo;
    private Facultad facultad;
    
    public Carrera(String codigo, String nombre, String titulo, Facultad facultad){
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulo = titulo;
        this.facultad = facultad;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the facultad
     */
    public Facultad getFacultad() {
        return facultad;
    }

    /**
     * @param facultad the facultad to set
     */
    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }
}
