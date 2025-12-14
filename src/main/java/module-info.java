module com.datasoft.proyectoestudiantefx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.datasoft.proyectoestudiantefx to javafx.fxml;
    opens com.datasoft.proyectoestudiantefx.modelo to javafx.base;

    exports com.datasoft.proyectoestudiantefx;
}
