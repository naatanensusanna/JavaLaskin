import java.text.DecimalFormat;

public class EdistynytLaskin extends PerusLaskin {

    private DecimalFormat df = new DecimalFormat("#.0");  // Muodostaa yhden desimaalin tarkkuuden

    public void laskePintaAla(double leveys, double korkeus) {
        tulos = leveys * korkeus;
    }

    public void laskeHypotenuusa(double kateetti1, double kateetti2) {
        tulos = Math.sqrt(kateetti1 * kateetti1 + kateetti2 * kateetti2);
    }

    public String getTulosFormatted() {
        return df.format(tulos);  // Palauttaa tuloksen pyöristettynä ja muotoiltuna
    }
}
