package fia.eisi.poo.gestioncarreras.controller;

import fia.eisi.poo.gestioncarreras.model.Carrera;
import fia.eisi.poo.gestioncarreras.model.Facultad;
import fia.eisi.poo.gestioncarreras.util.Datos;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Rudy
 */
public class MantenimientoCarreraController {

    @FXML
    private TextField codigoField;
    @FXML
    private TextField nombreField;
    @FXML
    private TextField tituloField;
    @FXML
    private ComboBox<Facultad> facultadCombo;
    @FXML
    private Label errorLabel;
    @FXML
    private Label tituloVentana;
    @FXML
    private Button eliminarButton;

    private Carrera carrera;       // null = insertar, no null = editar
    private Runnable onClose;

    public void setOnClose(Runnable onClose) {
        this.onClose = onClose;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
        
        if(carrera == null){
            tituloVentana.setText("Nueva Carrrera");
            eliminarButton.setVisible(false);
            eliminarButton.setManaged(false);
        } else{
            tituloVentana.setText("Editar Carrera");
            codigoField.setText(carrera.getCodigo());
            codigoField.setDisable(true);
            nombreField.setText(carrera.getNombre());
            tituloField.setText(carrera.getTitulo());
            
            facultadCombo.getSelectionModel().select(carrera.getFacultad());
        }
    }

    @FXML
    public void initialize() {
            facultadCombo.setItems(Datos.getFacultades());
            facultadCombo.setConverter(new StringConverter<>(){
        
            @Override
            public String toString(Facultad f){
                return f == null ? "" : f.toString();
            }
            
            @Override
            public Facultad fromString(String s){
                return null;
            }
        });
            
            //CÓDIGO FALTANTE
    }

    @FXML
    private void guardar() {

    }

    @FXML
    private void eliminar() {
//FALTA ESTE APARTADO DE CÓDIGO
    }

    @FXML
    private void cancelar() {
        cerrar();
    }

    private void cerrar() {
        if (onClose != null){
            onClose.run();
        }
        ((Stage) codigoField.getScene().getWindow()).close();
    }

}
