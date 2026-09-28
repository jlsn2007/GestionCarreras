package fia.eisi.poo.gestioncarreras.controller;

import fia.eisi.poo.gestioncarreras.model.Carrera;
import fia.eisi.poo.gestioncarreras.util.Datos;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Rudy
 */
public class ConsultarCarrerasController {

    @FXML
    private TextField buscarField;
    @FXML
    private TableView<Carrera> tablaCarreras;
    @FXML
    private TableColumn<Carrera, String> colCodigo;
    @FXML
    private TableColumn<Carrera, String> colNombre;
    @FXML
    private TableColumn<Carrera, String> colTitulo;
    @FXML
    private TableColumn<Carrera, String> colFacultad;
    @FXML
    private Label lblInfo;

    private ObservableList<Carrera> datosCompletos;
    private ObservableList<Carrera> datosFiltrados;

    @FXML
    public void initialize() {
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("título"));
        
        colFacultad.setCellValueFactory(cellData -> {
            Carrera c = cellData.getValue();
            String texto = (c.getFacultad() != null)
                    ? c.getFacultad().getNombre()
                    : "";
            return new SimpleStringProperty(texto);
        });
        
        //Obtenemos las carreras
        datosCompletos = Datos.getCarreras();
        
        //Se cre una segunda lista para filtrar las carreras
        //Inicialmente ambas listas tienen todas las carreras
        datosFiltrados = FXCollections.observableArrayList();
        datosFiltrados.setAll(datosCompletos);
        
        //Se asignn los datos filtrados a la tabla
        //Los datos en la tabla se actualizarán automáticamente cuando se actualice la lista en datosFiltrados
        tablaCarreras.setItems(datosFiltrados);
        
        //Doble clic abre la ventna modal de mantenimiento
        tablaCarreras.setRowFactory(tv -> {
            TableRow<Carrera> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(event.getClickCount() == 2 && !row.isEmpty()){
                    abrirMantenimiento(row.getItem());
                }
            });
            return row;
        });
    }

    @FXML
    private void filtrar() {
        
        String texto = buscarField.getText();
        
        datosFiltrados.clear();
        
        if(texto == null || texto.trim().isEmpty()){
            datosFiltrados.setAll(datosCompletos);
            return;
        }
        
        String t = texto.toLowerCase().trim();
        for( Carrera c : datosCompletos){
            if(c.getCodigo().toLowerCase().contains(t)
                || c.getNombre().toLowerCase().contains(t)){
                datosFiltrados.add(c);
            }
        }
     
    }

    @FXML
    private void nuevaCarrera() {
        
    }

    @FXML
    private void limpiarFiltro() {
    }

    @FXML
    private void salir() {
        
    }

    private void abrirMantenimiento(Carrera carrera) {
        
    }

}
