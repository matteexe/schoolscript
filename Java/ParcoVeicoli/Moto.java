public class Moto extends Veicolo {
    private String Cilindrata;

    public Moto(){
    }

    public Moto(String marca, int anno, String cilindrata) {
        super(marca, anno);
        Cilindrata = cilindrata;
    }

    public String getCilindrata() {
        return Cilindrata;
    }

    public void setCilindrata(String cilindrata) {
        Cilindrata = cilindrata;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "Cilindrata='" + Cilindrata + '\'' +
                ", marca='" + marca + '\'' +
                ", anno=" + anno +
                '}';
    }
}
