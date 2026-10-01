package fia.eisi.poo.gestioncarreras.controller;
import fia.eisi.poo.gestioncarreras.model.Carrera;
import fia.eisi.poo.gestioncarreras.model.Facultad;
import fia.eisi.poo.gestioncarreras.util.Datos;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
    }

    //APARTADO DEL MÉTODO O FUNCIÓN "GUARDAR" APARECE INCOMPLETO EN LA GUÍA, POR ENDE COMPLETÉ EL CÓDIGO.
    
    @FXML
    private void guardar() {
        
        //Limpiar mensaje de error previo
        errorLabel.setText("");

        //Obtener valores de la interfaz
        String codigo = codigoField.getText() != null ? codigoField.getText().trim() : "";
        String nombre = nombreField.getText() != null ? nombreField.getText().trim() : "";
        String titulo = tituloField.getText() != null ? tituloField.getText().trim() : "";
        Facultad facultad = facultadCombo.getValue();

        if (codigo.isEmpty() || nombre.isEmpty() || titulo.isEmpty() || facultad == null) {
            errorLabel.setText("Por favor complete todos los campos.");
            return;
        }

        //Crear nuevo objeto de tipo carrera
        if (carrera == null) {
            boolean existe = Datos.getCarreras().stream()
                    .anyMatch(c -> c.getCodigo().equalsIgnoreCase(codigo));

            if (existe) {
                errorLabel.setText("Ya existe una carrera con ese código.");
            } else {
                Carrera nuevaCarrera = new Carrera(codigo, nombre, titulo, facultad);
                Datos.agregarCarrera(nuevaCarrera);
                cerrar();
            }
        } 
        //Actulizar datos
        else {
            carrera.setNombre(nombre);
            carrera.setTitulo(titulo);
            carrera.setFacultad(facultad);
            cerrar();
        }
    }

    @FXML
    private void eliminar() {
        if (carrera == null){
            return;
        }
        
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
            "¿Está seguro de eliminar la carrera \"" + carrera.getNombre() + "\"?",
            ButtonType.YES, ButtonType.NO);
        confirm.setTitle("Confirmar eliminacion");
        confirm.setHeaderText(null);
        confirm.showAndWait().ifPresent(bt-> {
            if (bt == ButtonType.YES){
                Datos.eliminarCarrera(carrera);
                cerrar();
            }
        });
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
