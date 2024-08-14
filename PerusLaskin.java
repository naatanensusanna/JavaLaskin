public class PerusLaskin extends Laskin {

    public void summa() {
        tulos = luku1 + luku2;
    }

    public void erotus() {
        tulos = luku1 - luku2;
    }

    public void kertolasku() {
        tulos = luku1 * luku2;
    }

    public void jakolasku() {
        if (luku2 != 0) {
            tulos = luku1 / luku2;
        } else {
            System.out.println("Virhe: Nollalla jako ei ole sallittu.");
            tulos = 0;  // Tämän voisi muuttaa tekstiksi parsettamalla douple luvun stringiksi
        }
    }

    public double getTulos() {
        return tulos;
    }
}
