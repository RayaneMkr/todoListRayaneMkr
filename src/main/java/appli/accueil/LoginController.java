package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController {

    @FXML
    private Button connexion;

    @FXML
    private Button inscription;

    @FXML
    private Button motDePasseOublie;

    @FXML
    void OnActionConnexion(ActionEvent event) {
        StartApplication.sceneConnexion("accueil/inscriptionView");
    }

    @FXML
    void OnActionInscription(ActionEvent event) {
        StartApplication.sceneConnexion("accueil/inscriptionView");

    }

    @FXML
    void OnActionMdpOublie(ActionEvent event) {

    }

}
