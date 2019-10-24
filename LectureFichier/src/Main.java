import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FichierTexte fichier = new FichierTexte("out/production/LectureFichier/FichierTexte/FichierTest1.txt");
        FichierTexte fichierCompare1 = new FichierTexte("out/production/LectureFichier/FichierTexte/FichierTest1.txt");
        FichierTexte fichierCompare2 = new FichierTexte("out/production/LectureFichier/FichierTexte/FichierTest2.txt");

        fichier.lireFichier();
        System.out.println(" ---- [Contenu du fichier] ----");
        fichier.afficherContenu();

        System.out.println("\n ---- [Lecture inversée] ----");
        fichier.lectureInversee();

        System.out.println("\n ---- [Lecture palindromique] ----");
        fichier.lecturePalindromique();
        System.out.println("\n\033[3m - Alain Damasio - La Horde du Contrevent\033[0m");

        System.out.println("\n ---- [Comparaison des fichiers] ----");
        fichierCompare1.lireFichier();
        fichierCompare2.lireFichier();
        ArrayList<String> fichier1 = fichierCompare1.lireFichierCaractere();
        ArrayList<String> fichier2 = fichierCompare2.lireFichierCaractere();

        if(fichier1.equals(fichier2)) {
            System.out.println("Les fichiers sont identiques");
        } else {
            System.out.println("Les fichiers ne sont pas identiques");
        }

        System.out.print("[Contenu fichierCompare1] : ");
        fichierCompare1.afficherContenu();
        System.out.print("[Contenu fichierCompare2] : ");
        fichierCompare2.afficherContenu();

    }
}
