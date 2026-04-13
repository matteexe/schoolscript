public class Auto extends Veicolo{
    private int numeroPorte;
    private String Alimentazione;

    public Auto() {
    }

    public Auto(String marca, int giorni, double costoGiornaliero, int numeroPorte, String alimentazione) {
        super(marca, giorni, costoGiornaliero);
        this.numeroPorte = numeroPorte;
        Alimentazione = alimentazione;
    }

    public int getNumeroPorte() {
        return numeroPorte;
    }

    public String getAlimentazione() {
        return Alimentazione;
    }

    @Override
    public double calcolaCostoNoleggio(int giorni) {
        double costo=costoGiornaliero*giorni;

        if(Alimentazione.equalsIgnoreCase("elettrica"))
        {
            costo=costo*0.90;
        }

        return costo;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "numeroPorte=" + numeroPorte +
                ", Alimentazione='" + Alimentazione + '\'' +
                ", marca='" + marca + '\'' +
                ", giorni=" + giorni +
                ", costoGiornaliero=" + costoGiornaliero + '\''+
                ", costoTotale=" +calcolaCostoNoleggio(giorni) +
                '}';
    }
}
