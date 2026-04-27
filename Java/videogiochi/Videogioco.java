public class Videogioco extends ContenutoDIgitale{
    private String piattaforma;
    private String genere;
    private boolean multiplayer;

    public Videogioco() {
    }



    public Videogioco(String titolo, int dimensioneGb, int annoUscita, String piattaforma, String genere, boolean multiplayer) {
        super(titolo, dimensioneGb, annoUscita);
        this.piattaforma = piattaforma;
        this.genere = genere;
        this.multiplayer = multiplayer;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public String getGenere() {
        return genere;
    }

    public boolean isMultiplayer() {
        return multiplayer;
    }

    @Override
    public String toString() {
        return "Videogioco{" +
                "piattaforma='" + piattaforma + '\'' +
                ", genere='" + genere + '\'' +
                ", multiplayer=" + multiplayer +
                ", titolo='" + titolo + '\'' +
                ", dimensioneGb=" + dimensioneGb +
                ", annoUscita=" + annoUscita +
                '}';
    }
}
