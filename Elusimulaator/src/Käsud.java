import java.util.*;

public class Käsud {

    private int Toit = 100;
    private int Tervis = 100;
    private int Sotsiaalne = 100;
    private int Lõbu = 100;
    private int Raha = 100;
    private String nimi;
    int elu = 1;


    Käsud(String nimi) {
        this.nimi = nimi;
    }

    public void start(Scanner skanner) {
        System.out.println("Tere tulemast, " + nimi + "!");
        while (elu == 1) {

            System.out.println("Kirjuta 'Abi', et näha käsklusi.");
            System.out.println("\n Sisesta käsk: ");
            String command = skanner.nextLine();
            käsud(command);
//mängu lõppemise juhud
            if (Toit <= 0) {
                System.out.println("Oh ei! Kõht on täiesti tühi! Magu seedis end ise ära. RIP " + nimi);
                elu = 0;
            }
            if (Tervis <= 0) {
                System.out.println("Tervis oli nullis, otsustasid end ravida MMSiga. Tõsiselt, " + nimi + "?");
                elu = 0;
            }
            if (Sotsiaalne <= 0) {
                System.out.println("Muutusid väga antisotsiaalseks, sotsiaaltöötaja viis su kloostrisse. Oled nüüd " + nimi + ", kloostri aednik.");
                elu = 0;
            }
            if (Lõbu <= 0) {
                System.out.println("Sul oli nii surmigav, et istusid võõra autosse ja kadusid. Tubli, " + nimi + ", tubli.");
                elu = 0;
            }
            if (Raha >= 0 && Raha < 20) {
                System.out.println("Ettevaatust! Rahaga on kitsas, kui lähed miinustesse, läheb halvasti!");
            }
            if (Raha < 0) {
                System.out.println("Oled võlgades! Maffiaboss pani su pagasiruumi ja viskas kaljult alla! Kaotasid 30 tervist.");
                Tervis -= 30;
                Raha = 0;
            }
        }
        System.out.println("Aitäh, et mängisid!");
    }

//meetodid random meetodis kasutamiseks
    private void Toitujuurde(int summa) {
        Toit += summa;
    }

    private void ToituVahemaks(int summa) {
        Toit -= summa;
    }

    private void Tervistjuurde(int summa) {
        Tervis += summa;
    }

    private void TervistVahemaks(int summa) {
        Tervis -= summa;
    }

    private void Sotsiaalijuurde(int summa) {
        Sotsiaalne += summa;
    }

    private void SotsiaaliVahemaks(int summa) {
        Sotsiaalne -= summa;
    }

    private void Lobujuurde(int summa) {
        Lõbu += summa;
    }

    private void LobuVahemaks(int summa) {
        Lõbu -= summa;
    }

    private void Rahajuurde(int summa) {
        Raha += summa;
    }

    private void RahaVahemaks(int summa) {
        Raha -= summa;
    }



//Siit tulevad käsud, mida kasutaja saab ise rakendada
    private void toitu() {
        if (Toit == 100)
            System.out.println("Kõht täis, kõik on hästi!");
        else {
            Toit += 20;
            System.out.println("Kutsusid vanaema pannkooke tegema :)");
        }
    }

    private void tervenda() {
        if (Tervis == 100)
            System.out.println("Ole õnnelik, koroona pole sind veel kätte saanud! Oled terve kui purikas!");
        else {
            if (Raha > 10) {
                Tervis += 20;
                Raha -= 10;
                System.out.println("Käisid kiirel haiglavisiidil, doktorid ravisid hingehaavad terveks. Maksid 10 eurot.");
            } else {
                System.out.println("Pole piisavalt raha, et ravida. Mine müü üks kops või midagi. Nali muidugi =).");
            }
        }
    }

    private void suhtle() {
        if (Sotsiaalne == 100)
            System.out.println("Sotsiaalne patarei on laetud, pole tuju suhelda.");
        else {
            Sotsiaalne += 20;
            System.out.println("Läksid sõpradega põgenemistuppa, pääsesite elusalt ja saite vahvalt suheldud!");
        }
    }

    private void mangi() {
        if (Lõbu == 100)
            System.out.println("Oled väga õnnelik ja ei vaja mängu.");
        else {
            Lõbu += 20;
            System.out.println("Panid pusle kokku. Lõbu oli laialt!");
        }
    }

    int tooraha = 0;
    int risk = 0;

    private void TootaLegaalselt() {
        tooraha = (int) (Math.random() * 50);
        System.out.println("Teenisid maasikaid korjates " + tooraha + " eurot.");
        Raha += tooraha;
    }

    private void TootaMaaaluselt() {
        tooraha = (int) (Math.random() * 2000);
        risk = (int) (Math.random() * 50 + 20);
        Tervis -= risk;
        Raha += tooraha;
        System.out.println("Müüsid maaaluses laboris oma organeid, said " + tooraha + " eurot, kuid kaotasid " + risk + " tervist. Tark otsus..");

    }

    int arv = 0;
    int summa = 0;
//suvalise tõenäosusega sündmus
    private String sundmus(int arv) {
        if (arv == 0) {
            summa = (int) (Math.random() * 100);
            Rahajuurde(summa);
            return "Võitsid lotoga " + summa + " eurot! Wohoo!";
        } else if (arv == 1) {
            summa = (int) (Math.random() * 50 + 1);
            Tervistjuurde(summa);
            if (Tervis > 100) {
                Tervis = 100;
            }
            return "Sõid võluseent ja said " + summa + " punkti tervisele juurde.";
        } else if (arv == 2) {
            summa = (int) (Math.random() * 50 + 1);
            Lobujuurde(summa);
            if (Lõbu > 100) {
                Lõbu = 100;
            }
            return "Leidsid tänavalt kriidid ja mängisid keksu! Lõbutase tõusis " + summa + " võrra.";
        } else if (arv == 3) {
            summa = (int) (Math.random() * 50 + 1);
            Sotsiaalijuurde(summa);
            if (Sotsiaalne > 100) {
                Sotsiaalne = 100;
            }
            return "Käisid vallaliste õhtul, said " + summa + " sotsiaaltaset juurde.";
        } else if (arv == 4) {
            summa = (int) (Math.random() * 50 + 1);
            LobuVahemaks(summa);
            return "Sõbra sünnipäeva tähistamine tsirkuses! Aga sa kardad kloune. Kaotasid " + summa + " lõbu.";
        } else if (arv == 5) {
            summa = (int) (Math.random() * 50 + 1);
            Toitujuurde(summa);
            if (Toit > 100) {
                Toit = 100;
            }
            return "Leidsid kõrvaltänavast väikse tacoputka ja tellisid koka soovitatu, kõht täitus " + summa + " võrra.";
        } else if (arv == 6) {
            summa = (int) (Math.random() * 50 + 1);
            SotsiaaliVahemaks(summa);
            return "Lähed magama, et end välja puhata. Magad üle ja tunned end üksikuna. Kaotad " + summa + " sotsiaalsust.";
        } else if (arv == 7) {
            summa = (int) (Math.random() * 50 + 1);
            TervistVahemaks(summa);
            return "Lõid varba ära ja tervisetase langes " + summa + " võrra.";
        } else if (arv == 8) {
            summa = (int) (Math.random() * 50 + 1);
            ToituVahemaks(summa);
            return "Õnnepäev! Võid nii palju magusat süüa kui soovid! Aga oh ei, magusast hakkas paha, kaotasid " + summa + " toiduruumi.";
        } else if (arv == 9) {
            summa = (int) (Math.random() * 50 + 1);
            RahaVahemaks(summa);
            return "Leidsid kullapaja, kust hüppas valja härjapolvlane ja röövis sult " + summa + " eurot.";
        } else
            return "Tuuleiil puhus. Midagi ei juhtunud...";
    }
    //Kõik käsud, mida kasutaja saab tööle panna.
    private void käskudeNimekiri() {
        System.out.println("Käsud: ");
        System.out.println("1. 'Statistika'");
        System.out.println("2. 'Toitu'");
        System.out.println("3. 'Mängi'");
        System.out.println("4. 'Ravi'");
        System.out.println("5. 'Suhtle'");
        System.out.println("6. 'Random Event'");
        System.out.println("7. 'Tööta legaalselt' (PS! riski pole ja tervist ei kaota, aga teenid vähe)");
        System.out.println("8. 'Tööta maaaluselt' (PS! risk on suur, võid tervist kaotada, aga teenid see-eest palju)");
        System.out.println("9. 'Lõpeta mäng'");

        System.out.println("");
    }
//Andmete printimine, kui kasutaja neid näha tahtma peaks
    private void TerviseAndmed() {
        System.out.println("Name: " + nimi);
        System.out.println("Tervis: " + Tervis);
        System.out.println("Kõhutäituvus: " + Toit);
        System.out.println("Sotsiaalne: " + Sotsiaalne);
        System.out.println("Lõbu: " + Lõbu);
        System.out.println("Raha: " + Raha);
        System.out.println("");
    }
//Õige käsu aktiveerimine.
    private void käsud(String käsk) {
        System.out.println();
        switch (käsk.toLowerCase()) {
            case "abi":
                käskudeNimekiri();
                break;
            case "statistika":
                TerviseAndmed();
                break;
            case "toitu":
                toitu();
                break;
            case "mängi":
                mangi();
                break;
            case "ravi":
                tervenda();
                break;
            case "suhtle":
                suhtle();
                break;
            case "lõpeta mäng":
                System.out.println("Aitäh mängimast!");
                System.exit(0);
                break;
            case "random event":
                int arv = (int) (Math.random() * 10 + 1);
                int summa = 0;
                System.out.println(sundmus(arv));
                break;
            case "tööta legaalselt":
                TootaLegaalselt();
                break;
            case "tööta maaaluselt":
                TootaMaaaluselt();
                break;
            default:
                System.out.println("Tundmatu käsk, käskude nägemiseks sisesta sõna 'abi'.");
                break;

        }
    }
}
