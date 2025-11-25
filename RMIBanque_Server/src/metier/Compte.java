package metier;

import java.io.Serializable;
import java.util.Date;

public class Compte implements Serializable {
    // Identifiant de version pour la sérialisation (bonne pratique)
    private static final long serialVersionUID = 1L;

    private int code;
    private double solde;
    private Date dateCreation;

    // Constructeur sans paramètre (souvent requis pour la sérialisation)
    public Compte() {
    }

    // Constructeur avec paramètres
    public Compte(int code, double solde, Date dateCreation) {
        this.code = code;
        this.solde = solde;
        this.dateCreation = dateCreation;
    }

    // Getters et Setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    // Méthode toString pour faciliter l'affichage
    @Override
    public String toString() {
        return "Compte [Code=" + code + ", Solde=" + solde + ", Date=" + dateCreation + "]";
    }
}