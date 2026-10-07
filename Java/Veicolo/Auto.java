public class Auto extends Veicolo {
    private int Cilindrata;

    public Auto() {
        super();
    }

    public Auto(String targa, String marca, Double tarrifaBase, int cilindrata) {
        super(targa, marca, tarrifaBase);
        Cilindrata = cilindrata;
    }

    public int getCilindrata() {
        return Cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        Cilindrata = cilindrata;
    }

    @Override
    public double CalcolaTariffa(int ore) {
        double supplemento = TarriffaBase * ore;
        if (this.Cilindrata > 2000) {
            supplemento = (TarriffaBase * ore) + 5;
        }
        return supplemento;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "Cilindrata=" + Cilindrata +
                ", Targa='" + Targa + '\'' +
                ", Marca='" + Marca + '\'' +
                ", TarriffaBase=" + TarriffaBase +
                ", Ore=" + Ore +
                '}';
    }
}
