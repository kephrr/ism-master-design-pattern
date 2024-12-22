package domain;

public abstract class Enseignant {
    private int matricule;
    private String nom;
    private String prenom;
    private String grade;
    private Departement affectation;

    public Enseignant(int matricule, String nom, String prenom, String grade) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Enseignant {" +
                "grade='" + grade + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", matricule=" + matricule +
                '}';
    }

    public abstract double salaireNet();
    public int getMatricule() {
        return matricule;
    }
    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public Departement getAffectation() {
        return affectation;
    }
    public void setAffectation(Departement affectation) {
        this.affectation = affectation;
    }

}
