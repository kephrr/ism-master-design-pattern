package domain;

public class Permanent extends Enseignant{
    private double salaireBase;
    private double prime;
    public Permanent(int matricule, String nom, String prenom, String grade, double salaireBase, double prime) {
        super(matricule, nom, prenom, grade);
        this.salaireBase = salaireBase;
        this.prime = prime;
    }

    public double getSalaireBase() {
        return salaireBase;
    }
    public void setSalaireBase(double salaireBase) {
        this.salaireBase = salaireBase;
    }
    public double getPrime() {
        return prime;
    }
    public void setPrime(double prime) {
        this.prime = prime;
    }

    @Override
    public double salaireNet() {
        double brut = salaireBase+prime;
        double impots = brut*0.1;
        return brut - impots;
    }

    @Override
    public String toString() {
        return "Permanent " + getMatricule() +
                " " + getNom()+" "+getPrenom() +
                "\n Grade : " + getGrade() +
                "\n Salaire Net :" + salaireNet();
    }
}
