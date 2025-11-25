package rmiServer;

import java.rmi.registry.LocateRegistry;
import javax.naming.Context;
import javax.naming.InitialContext;
import rmiService.BanqueImpl;

public class BanqueServer {

    public static void main(String[] args) {
        try {
            System.out.println("Configuring JNDI RMI Server...");

            // 1. IMPORTANT : Démarrer le registre RMI en mémoire sur le port 1099.
            // JNDI (RegistryContextFactory) a besoin que ce registre existe pour s'y connecter.
            LocateRegistry.createRegistry(1099);

            // 2. Création du contexte JNDI.
            // Cela va lire automatiquement le fichier jndi.properties situé dans le dossier 'src'.
            Context ctx = new InitialContext();

            // 3. Instanciation de l'objet distant (l'implémentation du service)
            BanqueImpl od = new BanqueImpl();

            // 4. Enregistrement (Binding) de l'objet via JNDI
            // Le nom "BanqueService" doit être identique à celui utilisé dans le lookup du Client
            ctx.rebind("BanqueService", od);

            System.out.println("Serveur Banque prêt (Enregistré via JNDI) !");

        } catch (Exception e) {
            System.err.println("Erreur Serveur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}