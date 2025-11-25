# TP : Application Bancaire Répartie (RMI & JNDI)

## 📋 Description du Projet
Ce projet est une application Java distribuée mettant en œuvre une architecture **Client-Serveur** via la technologie **RMI (Remote Method Invocation)**. L'objectif est de gérer des comptes bancaires à distance.

L'application a été développée en deux phases :
1.  **Phase RMI Standard** : Utilisation du registre RMI classique.
2.  **Phase JNDI** : Abstraction de l'enregistrement et de la recherche via **JNDI (Java Naming and Directory Interface)**.

## 🚀 Fonctionnalités
Le serveur offre les services distants suivants aux clients :
*   **Créer un compte** : Avec un code unique, un solde initial et une date de création.
*   **Consulter un compte** : Récupérer les informations d'un compte via son code.

## 📂 Structure des Dossiers

Le projet est séparé en deux modules distincts :

### 1. Projet Serveur (`RMIBanque_Server`)
*   `src/metier/` : Contient la classe `Compte.java` (Serializable).
*   `src/rmiService/` : Contient l'interface `IBanque.java` et l'implémentation `BanqueImpl.java`.
*   `src/rmiServer/` : Contient le programme principal `BanqueServer.java`.
*   `src/jndi.properties` : Fichier de configuration JNDI.

### 2. Projet Client (`RMIBanque_Client`)
*   `src/rmiClient/` : Contient le programme principal `BanqueClient.java`.
*   `libs/banqueClient.jar` : Archive contenant uniquement l'interface `IBanque` et la classe `Compte`.
*   `src/jndi.properties` : Fichier de configuration JNDI.

---

## ⚙️ Installation et Configuration

### Prérequis
*   **Java JDK 8** ou supérieur.
*   Un IDE (Eclipse, IntelliJ IDEA, NetBeans).

### Étape 1 : Le Fichier de Configuration JNDI
Créez un fichier nommé `jndi.properties` à la racine du dossier **`src`** dans **les deux projets** (Client et Serveur).

**Contenu du fichier `jndi.properties` :**
```properties
java.naming.factory.initial=com.sun.jndi.rmi.registry.RegistryContextFactory
java.naming.provider.url=rmi://localhost:1099
