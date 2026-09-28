package fia.eisi.poo.gestioncarreras.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rudy
 */
public class Facultad {
    private String codigo;
    private String nombre;
    private List<Carrera> carreras;
    
    public Facultad(String codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
        this.carreras = new ArrayList<>();
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
     * @return the carreras
     */
    public List<Carrera> getCarreras() {
        return carreras;
    }

    /**
     * @param carreras the carreras to set
     */
    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }
    
    @Override
    public String toString(){
        return codigo + " - " + nombre;
    }
}
