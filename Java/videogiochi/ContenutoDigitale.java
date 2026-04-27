public class ContenutoDIgitale {
    protected String titolo;
    protected int dimensioneGb;
    protected int annoUscita;

    public ContenutoDIgitale() {
    }

    public ContenutoDIgitale(String titolo, int dimensioneGb, int annoUscita) {
        this.titolo = titolo;
        this.dimensioneGb = dimensioneGb;
        this.annoUscita = annoUscita;
    }

    @Override
    public String toString() {
        return "ContenutoDIgitaale{" +
                "titolo='" + titolo + '\'' +
                ", dimensioneGb=" + dimensioneGb +
                ", annoUscita=" + annoUscita +
                '}';
    }
}
