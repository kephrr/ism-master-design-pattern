package treatment;

import dao.DataBase;
import domain.Enseignant;
import domain.Permanent;
import domain.Vacataire;

import java.util.ArrayList;

public class Treatment {
     private DataBase db = new DataBase();

     public void statistics(){
         db.addPermanent(new Permanent(123, "SONKO","Serigne","Principal", 128009,50000));
         db.addVacataire(new Vacataire(133, "TALL","bll","Stage", 12809,50000));
         db.addPermanent(new Permanent(243, "NIANG","rhoff","Bum", 12009,50000));
         ArrayList<Enseignant> enseignants = db.findAllEnseignants();
         int ctp=0, ctv=0;
         for(Enseignant e : enseignants){
             if (e instanceof Permanent) ctp++;
             else ctv++;
         }
         System.out.println("Le nombre de Vacataire : "+ctv+" ("+((double) (ctv * 100) /enseignants.size())+")%");
         System.out.println("Le nombre de Permanents : "+ctp+" ("+((double) (ctp * 100) /enseignants.size())+")%");
         System.out.println("Le nombre d'enseignants : "+enseignants.size());
     }
}











