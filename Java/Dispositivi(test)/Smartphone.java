public class Smartphone extends Dispositivo {
    private int numeroFotocaemre;

    public Smartphone() {
        super();
    }

    public Smartphone(String marca, int annoProd, int numeroFotocaemre) {
        super(marca, annoProd);
        this.numeroFotocaemre = numeroFotocaemre;
    }

    public int getNumeroFotocaemre() {
        return numeroFotocaemre;
    }

    public void setNumeroFotocaemre(int numeroFotocaemre) {
        this.numeroFotocaemre = numeroFotocaemre;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "numeroFotocaemre=" + numeroFotocaemre +
                ", marca='" + marca + '\'' +
                ", annoProd=" + annoProd +
                '}';
    }
}
