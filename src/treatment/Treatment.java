package treatment;

import dao.DataBase;
import domain.Enseignant;
import domain.Permanent;
import domain.Vacataire;

import java.util.ArrayList;
import java.util.Iterator;

public class Treatment {
     private DataBase db;

     public Treatment(DataBase db) {
         this.db = db;
     }
     public void statistics(){
         /*db.ajouterPermanent(new Permanent(123, "SONKO","Serigne","Principal", 128009,50000));
         db.ajouterVacataire(new Vacataire(133, "TALL","bll","Stage", 12809,50000));
         db.ajouterPermanent(new Permanent(243, "NIANG","rhoff","Bum", 12009,50000));*/
         ArrayList<Enseignant> enseignants = db.findAllEnseignants();
         int ctp=0, ctv=0;
         for(Enseignant e : enseignants){
             if (e instanceof Permanent) ctp++;
             else ctv++;
         }
         System.out.println("------------------------------------------------------------------");
         System.out.println("------------------------- STAISTIQUES ----------------------------");
         System.out.println("------------------------------------------------------------------");
         System.out.println("Le nombre de Vacataire : "+ctv+" ("+String.format("%.2f",((double) (ctv * 100) /enseignants.size()))+")%");
         System.out.println("Le nombre de Permanents : "+ctp+" ("+String.format("%.2f",((double) (ctp * 100) /enseignants.size()))+")%");
         System.out.println("Le nombre d'enseignants : "+enseignants.size());
         System.out.println("------------------------------------------------------------------");
     }
}











