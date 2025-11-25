package rmiClient;

import java.util.Date;
import java.util.Properties; // Import nécessaire
import javax.naming.Context;
import javax.naming.InitialContext;

import metier.Compte;
import rmiService.IBanque;

public class BanqueClient {

    public static void main(String[] args) {
        try {
            System.out.println("Lancement du client via JNDI...");

            // SOLUTION : On définit les propriétés manuellement ici
            // au cas où le fichier jndi.properties n'est pas trouvé.
            Properties props = new Properties();
            props.put("java.naming.factory.initial", "com.sun.jndi.rmi.registry.RegistryContextFactory");
            props.put("java.naming.provider.url", "rmi://localhost:1099");

            // 1. Création du contexte initial avec les propriétés
            Context ctx = new InitialContext(props);

            // 2. Recherche de l'objet distant
            IBanque stub = (IBanque) ctx.lookup("BanqueService");

            // --- Tests ---
            
            // Test création
            Compte c1 = new Compte(20, 9000.0, new Date());
            String resCreation = stub.creerCompte(c1);
            System.out.println("Création : " + resCreation);

            // Test consultation
            String resInfo = stub.getInfoCompte(20);
            System.out.println("Consultation : " + resInfo);

        } catch (Exception e) {
            System.err.println("Erreur Client : " + e.toString());
            e.printStackTrace();
        }
    }
}