import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Käyttäjän syöttämät luvut
            System.out.print("Anna ensimmäinen luku: ");
            double luku1 = scanner.nextDouble();

            System.out.print("Anna toinen luku: ");
            double luku2 = scanner.nextDouble();

            // Kysytään käyttäjältä, mitä laskutoimitusta halutaan suorittaa
            System.out.println("Valitse toiminto:");
            System.out.println("1 - Yhteenlasku");
            System.out.println("2 - Vähennyslasku");
            System.out.println("3 - Kertolasku");
            System.out.println("4 - Jakolasku");
            System.out.println("5 - Pinta-alan laskeminen");
            System.out.println("6 - Hypotenuusan laskeminen");

            int valinta = scanner.nextInt();

            if (valinta >= 1 && valinta <= 4) {
                // Käytetään PerusLaskin-oliota peruslaskutoimituksiin
                PerusLaskin peruslaskin = new PerusLaskin();
                peruslaskin.setluku1(luku1);
                peruslaskin.setluku2(luku2);

                switch (valinta) {
                    case 1:
                        peruslaskin.summa();
                        System.out.println("Summa: " + peruslaskin.getTulos());
                        break;
                    case 2:
                        peruslaskin.erotus();
                        System.out.println("Erotus: " + peruslaskin.getTulos());
                        break;
                    case 3:
                        peruslaskin.kertolasku();
                        System.out.println("Kertolasku: " + peruslaskin.getTulos());
                        break;
                    case 4:
                        peruslaskin.jakolasku();
                        if (Double.isNaN(peruslaskin.getTulos())) {
                            System.out.println("Virhe: Nollalla jako ei ole sallittu.");
                        } else {
                            System.out.println("Jakolaskua ei pystytty suorittaa ");
                        }
                        break;
                }
            } else if (valinta == 5 || valinta == 6) {
                // Käytetään EdistynytLaskin-oliota edistyneempiin laskuihin
                EdistynytLaskin edistynytlaskin = new EdistynytLaskin();
                edistynytlaskin.setluku1(luku1);
                edistynytlaskin.setluku2(luku2);

                if (valinta == 5) {
                    // Pinta-alan laskeminen: tässä käytetään luku1 ja luku2 pituuksina
                    edistynytlaskin.laskePintaAla(luku1, luku2);
                    System.out.println("Pinta-ala: " + edistynytlaskin.getTulos());
                } else if (valinta == 6) {
                    // Hypotenuusan laskeminen: luku1 ja luku2 ovat kateetteja
                    edistynytlaskin.laskeHypotenuusa(luku1, luku2);
                    System.out.println("Kolmion kolmannen sivun pituus on: " + edistynytlaskin.getTulosFormatted());
                }
            } else {
                System.out.println("Virheellinen valinta. Valitse numero 1-6.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Virheellinen syöte. Varmista, että syötät numerot oikein.");
        } catch (Exception e) {
            System.out.println("Tapahtui odottamaton virhe: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
