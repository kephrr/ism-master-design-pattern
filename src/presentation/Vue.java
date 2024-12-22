package presentation;

import dao.DataBase;
import domain.*;
import treatment.Treatment;
import java.util.Scanner;

public class Vue {
    public static void main(String[] args) {
        DataBase db = new DataBase();
        Treatment treatment = new Treatment(db);
        Scanner sc = new Scanner(System.in);
        int choix;
        Departement d;
        int matricule, nh, tauxh;
        String nom, prenom, grade, nomDep, codeDep;
        String[] options ={
            "Créer un Département","Afficher les départements", "Créer un Vacataire",
            "Créer un Permanent", "Rattacher un permanent à un département",
            "Rattacher un vacataire à un département","Afficher les vacataires","Afficher les permanents",
            "Voire statistiques","Quitter"
        };
        do{
            for (int i = 0; i < options.length; i++) System.out.println((i+1)+". "+options[i]);
            choix = sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                    System.out.println("Entrez le nom du département");
                    nomDep = sc.nextLine();
                    System.out.println("Entrez le code du département");
                    codeDep = sc.nextLine();
                    d = new Departement(codeDep, nomDep);
                    db.ajouterDepartement(d);
                    break;
                case 2:
                    db.afficherDepartements();
                    break;
                case 3:
                    System.out.println("Matricule :");
                    matricule = sc.nextInt(); sc.nextLine();
                    System.out.println("Nom du vacataire : ");
                    nom = sc.nextLine();
                    System.out.println("Prenom du vacataire :");
                    prenom = sc.nextLine();
                    System.out.println("Grade du vacataire :");
                    grade = sc.nextLine();
                    System.out.println("Nombre d'heures effectuées :");
                    nh = sc.nextInt(); sc.nextLine();
                    System.out.println("Taux horaire à payer :");
                    tauxh = sc.nextInt(); sc.nextLine();
                    Vacataire v = new Vacataire(matricule, nom, prenom, grade, nh, tauxh);
                    db.ajouterVacataire(v);
                    break;
                case 4:
                    System.out.println("Matricule :");
                    matricule = sc.nextInt(); sc.nextLine();
                    System.out.println("Nom du permanent : ");
                    nom = sc.nextLine();
                    System.out.println("Prenom du permanent :");
                    prenom = sc.nextLine();
                    System.out.println("Grade du permanent :");
                    grade = sc.nextLine();
                    System.out.println("Salaire de base :");
                    double salaire = sc.nextDouble();
                    System.out.println("Prime :");
                    double prime = sc.nextDouble();
                    Permanent p = new Permanent(matricule, nom, prenom, grade, salaire, prime);
                    db.ajouterPermanent(p);
                    break;
                case 5, 6:
                    if (liaisonDepartementEnseignant(sc, db)) System.out.println("\nRattachement effectué avec succès");;
                    break;
                case 7 :
                    System.out.println("Vacataires :");
                    db.afficherVacataires();
                    break;
                case 8 :
                    db.afficherPermanents();
                    break;
                case 9 :
                    treatment.statistics();
                    break;
            }
        }while(choix!=options.length+1);
    }

    public static boolean liaisonDepartementEnseignant(Scanner sc, DataBase db){
        System.out.println("Entrez le code du département concerné");
        String codeDep = sc.nextLine();
        Departement d = db.rechercherDepartementByCode(codeDep);
        if(d == null) {
            System.out.println("Erreur : departement inexistant");
            return false;
        }
        System.out.println("Entrez le matricule de l'enseignant concerné");
        int matricule = sc.nextInt(); sc.nextLine();
        Enseignant e = db.rechercherEnseignantByMatricule(matricule);
        if(e == null) {
            System.out.println("Erreur : enseignant inexistant");
            return false;
        }
        db.liaisonDepartementAEnseignant(e, d);
        return true;
    }
}
