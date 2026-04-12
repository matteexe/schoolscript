public class Dispositivo {
    protected String marca;
    protected int annoProd;

    public Dispositivo() {
    }

    public Dispositivo(String marca, int annoProd) {
        this.marca = marca;
        this.annoProd = annoProd;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnnoProd() {
        return annoProd;
    }

    public void setAnnoProd(int annoProd) {
        this.annoProd = annoProd;
    }

    @Override
    public String toString() {
        return "Dispositivo{" +
                "marca='" + marca + '\'' +
                ", annoProd=" + annoProd +
                '}';
    }
}
