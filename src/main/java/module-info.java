module com.example.rpgjfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rpgjfx to javafx.fxml;
    exports com.example.rpgjfx;
    exports com.example.rpgjfx.Controllers;
    opens com.example.rpgjfx.Controllers to javafx.fxml;
}