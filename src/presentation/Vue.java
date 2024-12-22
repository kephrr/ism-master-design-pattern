package presentation;

import dao.DataBase;
import domain.Departement;
import domain.Enseignant;
import domain.Permanent;
import domain.Vacataire;

import java.util.Scanner;

public class Vue {
    public static void main(String[] args) {
        DataBase db = new DataBase();
        Scanner sc = new Scanner(System.in);
        int choix = 0;
        int matricule, nh, tauxh;
        String nom, prenom, grade, nomDep, codeDep;
        String[] opts ={"Créer un Département","Afficher les départements", "Créer un Vacataire","Créer un Permanent",
                "Rattacher un permanent à un département","Rattacher un vacataire à un département","Voire statistiques"};
        String[] resume ={"Continuer", "Quitter"};
        do{
            choix = select(sc, opts);
            switch (choix) {
                case 1:
                    System.out.println("Entrez le nom du département");
                    nomDep = sc.nextLine();
                    System.out.println("Entrez le code du département");
                    codeDep = sc.nextLine();
                    Departement d = new Departement(nomDep, codeDep);
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
                    System.out.println("Nom du vacataire : ");
                    nom = sc.nextLine();
                    System.out.println("Prenom du vacataire :");
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
                case 5:
                    System.out.println("Entrez le code du département concerné");
                    codeDep = sc.nextLine();
                    d = db.rechercherDepartementByCode(codeDep);
                    if(d == null) {
                        System.out.println("Erreur : departement inexistant");
                        break;
                    }
                    System.out.println("Entrez le matricule de l'enseignant concerné");
                    matricule = sc.nextInt(); sc.nextLine();
                    Enseignant e = db.rechercherEnseignantByMatricule(matricule);
                    if(e == null) {
                        System.out.println("Erreur : enseignant inexistant");
                        break;
                    }
                    db.liaisonDepartementAEnseignant(e, d);
                    break;
            }
        }while(select(sc, resume)!=2);
    }

    public static int select(Scanner sc, String[] options){
        int choix;
        do {
            for (int i = 0; i < options.length; i++) {
                System.out.println((i+1)+". "+options[i]);
            }
            choix = sc.nextInt();
            sc.nextLine();
        }while(choix<1 || choix>options.length);
        return choix;
    }
}
