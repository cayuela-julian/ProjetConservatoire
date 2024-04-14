module sio.leo.projetconservatoire {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens sio.leo.projetconservatoire to javafx.fxml;
    exports sio.leo.projetconservatoire;
}
