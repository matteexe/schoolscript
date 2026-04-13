public class Moto extends Veicolo{
    private int cilindrata;
    private int annoImmatricolazione;

    public Moto() {
    }

    public Moto(String marca, int giorni, double costoGiornaliero, int cilindrata, int annoImmatricolazione) {
        super(marca, giorni, costoGiornaliero);
        this.cilindrata = cilindrata;
        this.annoImmatricolazione = annoImmatricolazione;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public int getAnnoImmatricolazione() {
        return annoImmatricolazione;
    }

    @Override
    public double calcolaCostoNoleggio(int giorni) {
        double costo=costoGiornaliero*giorni;

        if(cilindrata>500)
        {
            costo=costo*1.05;
        }

        return costo;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "cilindrata=" + cilindrata +
                ", annoImmatricolazione=" + annoImmatricolazione +
                ", marca='" + marca + '\'' +
                ", giorni=" + giorni +
                ", costoGiornaliero=" + costoGiornaliero + '\''+
                ", costoTotale=" +calcolaCostoNoleggio(giorni) +
                '}';
    }
}
