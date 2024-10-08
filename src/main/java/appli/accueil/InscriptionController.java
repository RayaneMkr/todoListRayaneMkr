package appli.accueil;

import appli.StartApplication;
import appli.repository.UtilisateurRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Utilisateur;

import java.io.IOException;
import java.sql.SQLException;

public class InscriptionController {
    private Label errorLabel;

    @FXML
    private TextField emailField;

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private PasswordField mdpField;

    @FXML
    private PasswordField mdpConfirmField;
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
    protected void  onConnexionButtonClick() throws IOException {
        StartApplication.sceneConnexion("accueil/loginview.fxml");
    }

    @FXML
    protected void onInscriptionButtonClick() throws SQLException {
        String email = emailField.getText();
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String mdp = mdpField.getText();
        String mdpConfirm = mdpConfirmField.getText();

        if (!email.isEmpty() && !nom.isEmpty() && !prenom.isEmpty() && !mdp.isEmpty() && !mdpConfirm.isEmpty()) {
            if (mdp.equals(mdpConfirm)) {
                if (UtilisateurRepository.getUtilisateurParEmail(email) != null) {
                    errorLabel.setTextFill(javafx.scene.paint.Color.RED);
                    errorLabel.setText("Cet email est déjà utilisé.");
                } else {
                    if (UtilisateurRepository.inscription(nom, prenom, email, mdp)) {
                        Utilisateur user = new Utilisateur(nom, prenom, email, mdp);
                        errorLabel.setTextFill(javafx.scene.paint.Color.GREEN);
                        errorLabel.setText("Inscription réussie.");
                        emailField.setText("");
                        nomField.setText("");
                        prenomField.setText("");
                        mdpField.setText("");
                        mdpConfirmField.setText("");
                    } else {
                        errorLabel.setTextFill(javafx.scene.paint.Color.RED);
                        errorLabel.setText("Erreur lors de l'inscription.");
                    }
                }
            } else {
                errorLabel.setTextFill(javafx.scene.paint.Color.RED);
                errorLabel.setText("Les mots de passe ne correspondent pas.");
            }
        } else {
            errorLabel.setTextFill(javafx.scene.paint.Color.RED);
            errorLabel.setText("Veuillez remplir tous les champs.");
        }
    }

}
