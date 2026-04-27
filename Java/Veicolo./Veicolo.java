public class Veicolo {
    protected String Targa;
    protected String Marca;
    protected Double TarriffaBase;
    protected int Ore;

    public Veicolo() {
    }

    public Veicolo(String targa, String marca, Double tarrifaBase) {
        Targa = targa;
        Marca = marca;
        TarriffaBase = tarrifaBase;
    }

    public double CalcolaTariffa(int ore)
    {
        return TarriffaBase*ore;
    }

    @Override
    public String toString() {
        return "Veicolo{" +
                "Targa='" + Targa + '\'' +
                ", Marca='" + Marca + '\'' +
                ", TarrifaBase=" + TarriffaBase +
                '}';
    }
}
