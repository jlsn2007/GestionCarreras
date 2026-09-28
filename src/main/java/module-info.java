module fia.eisi.poo.gestioncarreras {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    // Paquete raíz donde está App
    exports fia.eisi.poo.gestioncarreras;

    // JavaFX necesita reflexión para inyectar @FXML en los controladores
    opens fia.eisi.poo.gestioncarreras.controller to javafx.fxml;

    // PropertyValueFactory necesita reflexión sobre las propiedades del modelo
    opens fia.eisi.poo.gestioncarreras.model to javafx.base, javafx.fxml;

    // Si usas FXMLLoader con recursos dentro del paquete view
    opens fia.eisi.poo.gestioncarreras.view to javafx.fxml;
}
