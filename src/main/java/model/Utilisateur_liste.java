package model;

public class Utilisateur_liste {
private int ref_utilisateur;
private int ref_liste;

    public int getRef_utilisateur() {
        return ref_utilisateur;
    }

    public void setRef_utilisateur(int ref_utilisateur) {
        this.ref_utilisateur = ref_utilisateur;
    }

    public int getRef_liste() {
        return ref_liste;
    }

    public void setRef_liste(int ref_liste) {
        this.ref_liste = ref_liste;
    }

    @Override
    public String toString() {
        return "Utilisateur_liste{" +
                "ref_utilisateur=" + ref_utilisateur +
                ", ref_liste=" + ref_liste +
                '}';
    }
}
