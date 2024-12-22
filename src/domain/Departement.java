package domain;
import java.util.ArrayList;
import java.util.List;

public class Departement {
    private String code;
    private String nomDepartment;
    private List<Enseignant> enseignants = new ArrayList<Enseignant>();

    public Departement(String code, String nomDepartment) {
        this.code = code;
        this.nomDepartment = nomDepartment;
    }

    @Override
    public String toString() {
        return "Departement " + code +" - " + nomDepartment;
    }

    public List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(List<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }

    public void addEnseignants(Enseignant e) {
        this.enseignants.add(e);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNomDepartment() {
        return nomDepartment;
    }

    public void setNomDepartment(String nomDepartment) {
        this.nomDepartment = nomDepartment;
    }
}