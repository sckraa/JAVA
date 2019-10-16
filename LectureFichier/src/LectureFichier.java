import java.io.*;
import java.util.ArrayList;

public class LectureFichier {
    private File fichier;
    private ArrayList<String> contenuFichier;

// Constructeurs
    public LectureFichier() {
        this.contenuFichier = new ArrayList<>();
    }
    public LectureFichier(String nomFichier) {
        this.fichier = new File(nomFichier);
        this.contenuFichier = new ArrayList<>();
    }

// Getters et Seters
    public File getFichier() { return this.fichier; }
    public void setFichier(File fichier) { this.fichier = fichier; }

    public ArrayList<String> getContenuFichier() { return contenuFichier; }
    public void setContenuFichier(ArrayList<String> contenuFichier) { this.contenuFichier = contenuFichier; }

// Méthodes
    public void lireFichier() {
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
    public void afficherContenu() {
        int tailleContenu = this.getContenuFichier().size();
        for(int i=0; i<tailleContenu; i++) {
            System.out.println(this.getContenuFichier().get(i));
        }
    }

/*
    File : exists() : Teste si le fichier ou le répertoire désigné par ce chemin abstrait existe.
 */
}
