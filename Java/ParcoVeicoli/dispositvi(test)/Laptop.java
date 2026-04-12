public class Laptop extends Dispositivo{
    private int dimensioneSchermo;

    public Laptop() {
        super();
    }

    public Laptop(String marca, int annoProd, int dimensioneSchermo) {
        super(marca, annoProd);
        this.dimensioneSchermo = dimensioneSchermo;
    }

    public int getDimensioneSchermo() {
        return dimensioneSchermo;
    }

    public void setDimensioneSchermo(int dimensioneSchermo) {
        this.dimensioneSchermo = dimensioneSchermo;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "dimensioneSchermo=" + dimensioneSchermo +
                ", marca='" + marca + '\'' +
                ", annoProd=" + annoProd +
                '}';
    }
}
