import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class GestioneParco {
    public static void main(String[] args)
    {
        final int MAX=100;
        String marca;
        String cilindrata;
        int anno;
        int NumeroPorta;
        int n,scelta=0;
        String t;

        Scanner sc=new Scanner(System.in);

        Veicolo[] parco=new Veicolo[MAX];

        do{
            System.out.println("Qunati veicoli ci sono?");
            n=sc.nextInt();
        }while(n>MAX);

        for(int i=0;i<n;i++)
        {
            System.out.println("Scegliere se inserira una moto oppure un'auto");
            t=sc.next();

            if(t.equalsIgnoreCase("moto"))
            {
                System.out.println("Inserisci la marca della moto");
                marca=sc.next();
                System.out.println("Inserisci l'anno della moto");
                anno=sc.nextInt();
                System.out.println("Inserisci la cilindrata della moto");
                cilindrata=sc.next();
                parco[i]=new Moto(marca,anno,cilindrata);
            }
            else if(t.equalsIgnoreCase("auto"))
            {
                System.out.println("Inserisci la marca della moto");
                marca=sc.next();
                System.out.println("Inserisci l'anno della moto");
                anno=sc.nextInt();
                System.out.println("Inserisci il numero delle porte");
                NumeroPorta=sc.nextInt();

                parco[i]=new Auto(marca,anno,NumeroPorta);
            }
        }

        do{
            System.out.println("1)Output");
            System.out.println("2)Massimo");
            System.out.println("3)Minimo");
            System.out.println("0)Esci dal programma");
            scelta=sc.nextInt();
            switch (scelta)
            {
                case 1:
                    for(int i=0;i<n;i++)
                    {
                        System.out.println(parco[i].toString());
                    }
                    break;

                case 2:
                    Veicolo piuVecchio = parco[0];

                    for (int i = 1; i < n; i++) {
                        if (parco[i].getAnno() < piuVecchio.getAnno()) {
                            piuVecchio = parco[i];
                        }
                    }
                    System.out.println("Veicolo piu vecchio: " + piuVecchio);

                break;
                case 0:
                    System.out.println("Sei uscito dal programma");
                    break;
                default:
                    System.err.println("Scelta errata");
                    break;
            }
        }while(scelta!=0);
    }
}
