package presentation;

import java.util.Scanner;

public class Vue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choix = 0;
        int matricule, nh, tauxh;
        String nom, prenom, grade;

        String[] opts ={"Créer un Département", "Créer un Permanent","Créer un Vacataire",
                "Rattacher un permanent à un département","Rattacher un vacataire à un département","Voire statistiques"};
        String[] resume ={"Continuer", "Quitter"};
        do{
            choix = select(sc, opts);
            switch (choix) {
                case 1:
                    System.out.println(opts[0]);
                    break;
                case 2:
                    System.out.println(opts[1]);
                    break;
                case 3:
                    System.out.println(opts[2]);
                    break;
                case 4:
                    System.out.println(opts[3]);
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
        }while(choix<1 || choix>options.length);
        return choix;
    }
}
