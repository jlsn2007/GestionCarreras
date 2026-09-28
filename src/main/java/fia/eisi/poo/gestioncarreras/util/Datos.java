package fia.eisi.poo.gestioncarreras.util;

import fia.eisi.poo.gestioncarreras.model.Carrera;
import fia.eisi.poo.gestioncarreras.model.Facultad;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Datos {
    private static final ObservableList<Facultad> facultades =
FXCollections.observableArrayList();
    private static final ObservableList<Carrera> carreras = 
FXCollections.observableArrayList();
    
    static {
        facultades.addAll(
                new Facultad("I10", "Facultad de Ingeniería"),
                new Facultad("M01","Facultad de Medicina"),
                new Facultad("J02","Facultad de Jurisprudencia y Ciencias Sociales"),
                new Facultad("E05","Facultad de Ciencias Económicas"),
                new Facultad("H04","Facultad de Ciencias y Humanidades")
        );
        
        Facultad ingArq = facultades.get(0);
        
        Carrera sistemas = new Carrera("I10515", "Ingeniería de Sistemas Informáticos", "Ingeniero de Sistemas Informáticos", ingArq);
        ingArq.getCarreras().add(sistemas);
        
        Carrera arquitectura = new Carrera("I10507", "Arquitectura", "Arquitecto", ingArq);
        ingArq.getCarreras().add(arquitectura);
        
        Facultad facMedicina = facultades.get(1);
        
        Carrera medicina = new Carrera("M01001", "Medicina General", "Médico General", facMedicina);
        facMedicina.getCarreras().add(medicina);
        
        carreras.add(sistemas);
        carreras.add(arquitectura);
        carreras.add(medicina);
        
    }
    
    public static ObservableList<Facultad> getFacultades(){
        return facultades;
    }
    
    public static ObservableList<Carrera> getCarreras(){
        return carreras;
    }
    
    public static void agregarCarrera(Carrera carrera){
        carreras.add(carrera);
        if(carrera.getFacultad() != null && !carrera.getFacultad().getCarreras().contains(carrera)){
            carrera.getFacultad().getCarreras().add(carrera);
        }
    }
    
    public static void eliminarCarrera(Carrera carrera){
        carreras.remove(carrera);
        if(carrera.getFacultad() != null){
            carrera.getFacultad().getCarreras().remove(carrera);
        }
    }
}
