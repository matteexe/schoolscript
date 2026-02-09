public class Supermercato {
    /* caricare max 50 prodotti
    salvare codice,nome prodotti e prezzo
    calora il prodotto con prezzo maggiore, minore, e la media dei prezzi
    fai la ricerca dei prodotti per nome
    */

    private int codice;
    private String nome;
    private float prezzo;

    public Supermercato() {
    }

    public Supermercato(float prezzo, String nome, int codice) {
        this.prezzo = prezzo;
        this.nome = nome;
        this.codice = codice;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Supermercato{" +
                "codice=" + codice +
                ", nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }
}
