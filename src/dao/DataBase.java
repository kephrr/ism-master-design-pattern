package dao;

import domain.Departement;
import domain.Enseignant;
import domain.Permanent;
import domain.Vacataire;

import java.util.ArrayList;

public class DataBase {
    private ArrayList<Departement> departements = new ArrayList<>();
    private ArrayList<Enseignant> enseignants = new ArrayList<>();

    public void addPermanent(Permanent permanent) {
        enseignants.add(permanent);
    }

    public void addVacataire(Vacataire vacataire) {
        enseignants.add(vacataire);
    }

    public void addDepartement(Departement departement) {
        departements.add(departement);
    }

    public ArrayList<Enseignant> findAllEnseignants() {
        return enseignants;
    }

    public void showdAllDepartements() {
        for (Departement departement : departements) System.out.println(departement);
    }

    public void showAllPermanents() {
        for (Enseignant enseignant : enseignants) if (enseignant instanceof Permanent) System.out.println(enseignant);
    }

    public void showAllVacataires() {
        for (Enseignant enseignant : enseignants) if (enseignant instanceof Vacataire) System.out.println(enseignant);
    }

    public Enseignant findEnseignantByMatricule(int matricule) {
        for (Enseignant enseignant : enseignants) if (enseignant.getMatricule() == matricule) return enseignant;
        return null;
    }

    public Departement findDepartementByCode(String code) {
        for (Departement departement : departements) if (departement.getCode().equals(code)) return departement;
        return null;
    }

    public void bindDepartementToEnseignant(Enseignant e, Departement d) {
        e.setAffectation(d);
        d.addEnseignants(e);
    }
}
