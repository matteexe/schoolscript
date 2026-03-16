public class Veicolo {
    protected String marca;
    protected int anno;

    public Veicolo() {
    }

    public Veicolo(String marca, int anno) {
        this.marca = marca;
        this.anno = anno;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    @Override
    public String toString() {
        return "Veicolo{" +
                "marca='" + marca + '\'' +
                ", anno=" + anno +
                '}';
    }
}
