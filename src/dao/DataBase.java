package dao;

import domain.Departement;
import domain.Enseignant;
import domain.Permanent;
import domain.Vacataire;

import java.util.ArrayList;

public class DataBase {
    private ArrayList<Departement> departements = new ArrayList<>();
    private ArrayList<Enseignant> enseignants = new ArrayList<>();

    public void ajouterPermanent(Permanent permanent) {
        enseignants.add(permanent);
    }

    public void ajouterVacataire(Vacataire vacataire) {
        enseignants.add(vacataire);
    }

    public void ajouterDepartement(Departement departement) {
        departements.add(departement);
    }

    public ArrayList<Enseignant> findAllEnseignants() {
        return enseignants;
    }

    public void afficherDepartements() {
        for (Departement departement : departements) {
            System.out.println("--------------------------------------------");
            System.out.println(departement);
        }
        System.out.println("--------------------------------------------");
    }

    public void afficherPermanents() {
        for (Enseignant enseignant : enseignants) if (enseignant instanceof Permanent) System.out.println(enseignant);
    }

    public void afficherVacataires() {
        for (Enseignant enseignant : enseignants) if (enseignant instanceof Vacataire) System.out.println(enseignant);
    }

    public Enseignant rechercherEnseignantByMatricule(int matricule) {
        for (Enseignant enseignant : enseignants) if (enseignant.getMatricule() == matricule) return enseignant;
        return null;
    }

    public Departement rechercherDepartementByCode(String code) {
        for (Departement departement : departements) if (departement.getCode().equals(code)) return departement;
        return null;
    }

    public void liaisonDepartementAEnseignant(Enseignant e, Departement d) {
        e.setAffectation(d);
        d.addEnseignants(e);
    }
}
