package rmiService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import metier.Compte;

public interface IBanque extends Remote {
    // Méthode pour créer un compte
    public String creerCompte(Compte c) throws RemoteException;

    // Méthode pour consulter un compte
    public String getInfoCompte(int code) throws RemoteException;
}