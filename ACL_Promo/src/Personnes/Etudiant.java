package Personnes;

public class Etudiant extends Personne {
    private static int PROCHAIN_NUM = 1;
    private int num;
    private int age;

    public Etudiant(String nom, String prenom, int age) {
        super(nom, prenom);
        this.age = age;
        this.num = PROCHAIN_NUM++;
    }

    @Override
    public String toString() {
        return "Etudiant " + super.toString() + " (noEt=" + num + ") " + age + " ans";
    }
}
