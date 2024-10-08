package appli.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import appli.dataBase.dataBase;
import model.Utilisateur;
import org.springframework.security.crypto.bcrypt.BCrypt;
public class UtilisateurRepository {

    public static boolean inscription(String nom, String prenom, String email, String motDePasse) throws SQLException {
        dataBase db = new dataBase();
        Connection cnx = db.getConnection();

        String mdp = BCrypt.hashpw(motDePasse, BCrypt.gensalt());

        PreparedStatement statement = cnx.prepareStatement("INSERT INTO utilisateur (nom, prenom, email, mot_de_passe) VALUES (?, ?, ?, ?)");
        statement.setString(1, nom);
        statement.setString(2, prenom);
        statement.setString(3, email);
        statement.setString(4, mdp);

        if (statement.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }
    public static Utilisateur connexion(String email, String motDePasse) throws SQLException {
        dataBase db = new dataBase();
        Connection cnx = db.getConnection();

        PreparedStatement statement = cnx.prepareStatement("SELECT * FROM utilisateur WHERE email = ?");
        statement.setString(1, email);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            String nom = result.getString("nom");
            String prenom = result.getString("prenom");
            String mail = result.getString("email");
            String mdp = result.getString("mot_de_passe");

            if (BCrypt.checkpw(motDePasse, mdp)) {
                return new Utilisateur (nom, prenom, mail, mdp);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    public static Utilisateur getUtilisateurParEmail(String email) throws SQLException {
        dataBase db = new dataBase();
        Connection cnx = db.getConnection();

        PreparedStatement statement = cnx.prepareStatement("SELECT * FROM utilisateur WHERE email = ?");
        statement.setString(1, email);

        if (statement.executeQuery().next()) {
            ResultSet result = statement.executeQuery();

            String nom = result.getString("nom");
            String prenom = result.getString("prenom");
            String mail = result.getString("email");
            String mdp = result.getString("mot_de_passe");

            return new Utilisateur(nom, prenom, mail, mdp);
        } else {
            return null;
        }
    }
}
