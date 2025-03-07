import java.util.Scanner;

public class Mäng {

    public static void main(String[] args) {
        System.out.println("See on elusimulaator, langeta otsuseid ja vaata mida tulevik toob!");
        Scanner skanner = new Scanner(System.in);

        System.out.println("Sisesta nimi: ");

        String nimi = skanner.nextLine();


        Käsud isik = new Käsud(nimi);
        isik.start(skanner);

    }

}
