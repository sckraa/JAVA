import java.io.File;
import java.util.ArrayList;

public class FichierTexte extends  LectureFichier implements LectureFichierTexte{

// Constructeurs
    public FichierTexte() {
        this.contenuFichier = new ArrayList<>();
    }
    public FichierTexte(String nomFichier) {
        this.fichier = new File(nomFichier);
        this.contenuFichier = new ArrayList<>();
    }

// Méthodes
    public void lectureInversee() {
        for(int i=this.getContenuFichier().size()-1; i>=0; i--) {
            System.out.println(this.getContenuFichier().get(i));
        }
    }
    public void lecturePalindromique() {
        for(int i=this.getContenuFichier().size()-1; i>=0; i--) {
            for(int j=this.getContenuFichier().get(i).length()-1; j>=0; j--) {
                this.getContenuFichier().add(Character.toString(this.getContenuFichier().get(i).charAt(j)));
            }
        }
        for(int i=0; i<this.getContenuFichier().size(); i++) {
            System.out.println(this.getContenuFichier().get(i));
        }
    }

/*
    File : exists() : Teste si le fichier ou le répertoire désigné par ce chemin abstrait existe.
 */
}
