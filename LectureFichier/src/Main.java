public class Main {
    public static void main(String[] args) {
        FichierTexte fichier = new FichierTexte("out/production/LectureFichier/FichierTest.txt");

        fichier.lireFichier();
        System.out.println(" ---- [Contenu du fichier] ----");
        fichier.afficherContenu();

        System.out.println(" ---- [Lecture inversée] ----");
        fichier.lectureInversee();

        System.out.println(" ---- [Lecture palindromique] ----");
        fichier.lecturePalindromique();
    }
}
