package treatment;

import dao.DataBase;
import domain.Enseignant;
import domain.Permanent;
import domain.Vacataire;

import java.util.ArrayList;
import java.util.Iterator;

public class Treatment {
     private final DataBase db;

     public Treatment(DataBase db) {
         this.db = db;
     }

     public void statistics(){
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











