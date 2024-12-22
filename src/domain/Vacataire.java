package domain;

public class Vacataire extends Enseignant{
    private int nH;
    private int tauxH;
    public Vacataire(int matricule, String nom, String prenom, String grade, int nH, int tauxH) {
        super(matricule, nom, prenom, grade);
        this.nH = nH;
        this.tauxH = tauxH;
    }

    @Override
    public double salaireNet() {
        double brut = this.nH * this.tauxH;
        double impot = brut*0.05;
        return brut - impot;
    }

    @Override
    public String toString() {
        return "Vacataire " + getMatricule() +
                " " + getNom()+" "+getPrenom() +
                "\n Grade : " + getGrade() +
                "\n Salaire Net :" + salaireNet();
    }
}
