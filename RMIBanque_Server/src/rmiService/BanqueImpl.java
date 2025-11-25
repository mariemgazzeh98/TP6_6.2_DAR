package rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import metier.Compte;

public class BanqueImpl extends UnicastRemoteObject implements IBanque {

    // Liste pour stocker les comptes bancaires (simule une base de données)
    private List<Compte> comptes;

    // Constructeur : doit lancer RemoteException car il hérite de UnicastRemoteObject
    public BanqueImpl() throws RemoteException {
        super();
        this.comptes = new ArrayList<>();
    }

    @Override
    public String creerCompte(Compte c) throws RemoteException {
        // Vérifier si le code existe déjà
        for (Compte compteExistant : comptes) {
            if (compteExistant.getCode() == c.getCode()) {
                return "Erreur : Un compte avec le code " + c.getCode() + " existe déjà.";
            }
        }
        
        // Si le code n'existe pas, on ajoute le compte
        comptes.add(c);
        return "Succès : Compte créé avec succès ! " + c.toString();
    }

    @Override
    public String getInfoCompte(int code) throws RemoteException {
        // Recherche du compte par son code
        for (Compte c : comptes) {
            if (c.getCode() == code) {
                // On retourne les infos du compte (via toString ou formatage manuel)
                return "Informations : " + c.toString();
            }
        }
        return "Erreur : Aucun compte trouvé avec le code " + code;
    }
}