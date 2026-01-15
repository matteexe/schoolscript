//importiamo scanner per leggere i dati da tastiera
import java.util.Scanner;

public class testRettangolo {
    public static void main(String[] args){
        //creazione di un ogetto scanner chiamato tastiera
        Scanner tastiera=new Scanner(System.in);
        float base=0;
        float altezza=0;
        //Creiamo un oggetto rettangolo usando il costruttore senza paramentri
        Rettangolo q1=new Rettangolo();
        //Facciamo inserire i dati tramite scanner
        System.out.println("Inserisci il valore dalla base:");
        base=tastiera.nextFloat();
        q1.setBase(base);
        System.out.println("Inserisci l'atezza:");
        altezza=tastiera.nextFloat();
        q1.setAltezza(altezza);

        //print in console
        System.out.println("Il valore della base e:"+q1.getBase());
        System.out.println("Il valore dell'altezza di r1 e:"+q1.getAltezza());
        System.out.println("Il valore del perimetro di r1 e':"+q1.caloloPerimentro());
        System.out.println("Il valore dell'area di r1 e':"+q1.calcoloArea());

        //creaiamo un oggetto usando il costruttore paramentrico
        Rettangolo q2=new Rettangolo(30,20);

        System.out.println("Il valore della base e:"+q2.getBase());
        System.out.println("Il valore dell'altezza di r1 e:"+q2.getAltezza());
        System.out.println("Il valore del perimetro di r1 e':"+q2.caloloPerimentro());
        System.out.println("Il valore dell'area di r1 e':"+q2.calcoloArea());

    }
}
