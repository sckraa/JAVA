public class Main {
    public static void main(String[] args) {
        LectureFichier fichier = new LectureFichier("D:/Licence/JAVA/LectureFichier/src/FichierTest.txt");

        fichier.lireFichier();
        System.out.println(" ---- [Contenu du fichier] ----");
        fichier.afficherContenu();
    }
}
