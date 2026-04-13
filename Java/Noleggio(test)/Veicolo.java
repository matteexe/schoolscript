public class Veicolo {
    protected String marca;
    protected int giorni;
    protected double costoGiornaliero;

    public Veicolo() {
    }

    public Veicolo(String marca, int giorni, double costoGiornaliero) {
        this.marca = marca;
        this.giorni = giorni;
        this.costoGiornaliero = costoGiornaliero;
    }

    public String getMarca() {
        return marca;
    }

    public int getGiorni() {
        return giorni;
    }

    public double getCostoGiornaliero() {
        return costoGiornaliero;
    }

    public double calcolaCostoNoleggio(int giorni){
        return costoGiornaliero*giorni;
    }

    @Override
    public String toString() {
        return "Veicolo{" +
                "marca='" + marca + '\'' +
                ", costoGiornaliero=" + costoGiornaliero + '\''+
                ", costoTotale=" +calcolaCostoNoleggio(giorni) +
                '}';
    }
}
