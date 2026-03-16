public class Auto extends Veicolo {
    private int NumeroPorta;

    public Auto() {
    }

    public Auto(String marca, int anno, int numeroPorta) {
        super(marca, anno);
        NumeroPorta = numeroPorta;
    }

    public int getNumeroPorta() {
        return NumeroPorta;
    }

    public void setNumeroPorta(int numeroPorta) {
        NumeroPorta = numeroPorta;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "NumeroPorta=" + NumeroPorta +
                ", marca='" + marca + '\'' +
                ", anno=" + anno +
                '}';
    }
}
