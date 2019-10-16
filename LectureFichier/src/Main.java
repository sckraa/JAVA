public class Main {
    public static void main(String[] args) {
        LectureFichier fichier = new LectureFichier("out/production/LectureFichier/FichierTest.txt");

        fichier.lireFichier();
        System.out.println(" ---- [Contenu du fichier] ----");
        fichier.afficherContenu();
    }
}
