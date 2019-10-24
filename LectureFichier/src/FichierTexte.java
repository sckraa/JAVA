import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

abstract public class FichierTexte {
    protected File fichier;
    protected ArrayList<String> contenuFichier;

// Getters et Seters
    protected File getFichier() { return this.fichier; }
    protected void setFichier(File fichier) { this.fichier = fichier; }

    protected ArrayList<String> getContenuFichier() { return contenuFichier; }
    protected void setContenuFichier(ArrayList<String> contenuFichier) { this.contenuFichier = contenuFichier; }


// Méthodes
    protected void lireFichier() {
        boolean fichierExiste = this.getFichier().exists();
        File fichier = this.getFichier();
        if (fichierExiste) {
            try {
                FileInputStream fichierFlux = new FileInputStream(fichier);
                InputStreamReader lectureFichier = new InputStreamReader(fichierFlux);
                BufferedReader memoire = new BufferedReader(lectureFichier);
                String ligneFichier = "";
                while ((ligneFichier=memoire.readLine()) != null) {
                    this.getContenuFichier().add(ligneFichier);
                }
                memoire.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } else {
            System.out.println("Le fichier ["+ this.getFichier() +"] n'existe pas.");
        }
    }
    protected void afficherContenu() {
        int tailleContenu = this.getContenuFichier().size();
        for(int i=0; i<tailleContenu; i++) {
            System.out.println(this.getContenuFichier().get(i));
        }
    }
    protected ArrayList<String> lireFichierCaractere() {
        ArrayList<String> contenu = new ArrayList<String>();

        for(int i=this.getContenuFichier().size()-1; i>=0; i--) {
            for(int j=this.getContenuFichier().get(i).length()-1; j>=0; j--) {
                contenu.add(Character.toString(this.getContenuFichier().get(i).charAt(j)));
            }
        }

        return contenu;
    }
    abstract public void lectureInversee();
    abstract public void lecturePalindromique();
}
