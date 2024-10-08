package model;

public class Liste {
    private int id_liste;
    private String nom;

    public Liste(String nom) {
    }

    public int getId_liste() {
        return id_liste;
    }

    public void setId_liste(int id_liste) {
        this.id_liste = id_liste;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Liste{" +
                "id_liste=" + id_liste +
                ", nom='" + nom + '\'' +
                '}';
    }
}
