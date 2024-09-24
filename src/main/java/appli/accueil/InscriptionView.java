package appli.accueil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InscriptionView {

    @FXML
    private Button inscription;

    @FXML
    private Button retour;

    @FXML
    void OnActionInscription(ActionEvent event) {
        System.out.println("test");
    }

    @FXML
    void OnActionRetour(ActionEvent event) {

    }

}
