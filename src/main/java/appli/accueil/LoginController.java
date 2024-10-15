package appli.accueil;

import appli.StartApplication;
import appli.repository.UtilisateurRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.paint.Color;

import java.sql.SQLException;

public class LoginController {


    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField emailField;

    @FXML
    private Label erreurText;
    @FXML
    private Button connexion;

    @FXML
    private Button inscription;

    @FXML
    private Button motDePasseOublie;

    @FXML
  protected  void OnActionConnexion(ActionEvent event) throws SQLException {
        if (!emailField.getText().isEmpty() || !passwordField.getText().isEmpty()) {
            if (UtilisateurRepository.connexion(emailField.getText(), passwordField.getText()) != null) {
                erreurText.setTextFill(Color.GREEN);
                erreurText.setText("Connexion réussie.");
                StartApplication.sceneConnexion("accueil/accueilview.fxml");
            } else {
                erreurText.setTextFill(javafx.scene.paint.Color.RED);
                erreurText.setText("Email ou mot de passe incorrect.");
            }
        } else {
            erreurText.setTextFill(javafx.scene.paint.Color.RED);
            erreurText.setText("Veuillez remplir tous les champs.");
        }
    }

    @FXML
    void OnActionInscription(ActionEvent event) {
        StartApplication.sceneConnexion("accueil/inscriptionView");

    }

    @FXML
    void OnActionMdpOublie(ActionEvent event) {

    }

}
