import java.util.Scanner;

public class testSupermercato {
    public static void main(String[] args){
        final int MAX=50;
        int codice;
        String nome;
        float prezzo;
        int scelta,n;
        float maxprezzo,minprezzo,somma=0,media=0;
        String maxnome,minnome,nom;
        boolean trov=false;
        Scanner sc=new Scanner(System.in);
        Supermercato[] arraysuper=new Supermercato[MAX];

        do{
            System.out.println("Quanti prodotti ci sono?");
            n=sc.nextInt();
        }while(n<MAX);

        for(int i=0;i<n;i++)
        {
            System.out.println("INserire il codice del "+(i+1)+" prodotto:");
            codice=sc.nextInt();
            System.out.println("INserire il nome del "+(i+1)+" prodotto:");
            nome=sc.next();
            System.out.println("INserire il prezzo del "+(i+1)+" prodotto:");
            prezzo=sc.nextInt();

            arraysuper[i]=new Supermercato(prezzo,nome,codice);
        }

        do{
            System.out.println("1)Mostra i prodotti");
            System.out.println("2) Prodotto con prezzo maggiore");
            System.out.println("3) Prodotto con prezzo minore");
            System.out.println("4) Prezzo medio dei prodotti");
            System.out.println("5) Ricerca per nome del prodotto");
            scelta=sc.nextInt();

            switch (scelta)
            {
                case 1:
                    for(int i=0;i<n;i++)
                    {
                        System.out.println(arraysuper[i].toString());
                    }
                    break;

                case 2:
                    maxprezzo=arraysuper[0].getPrezzo();
                    maxnome=arraysuper[0].getNome();

                    for(int i=1;i<n;i++)
                    {
                        if(arraysuper[i].getPrezzo()>maxprezzo)
                        {
                            maxnome=arraysuper[i].getNome();
                            maxprezzo=arraysuper[i].getPrezzo();
                        }
                    }

                    System.out.println("Il prodotto con prezzo magggiore e':"+maxnome+" ("+maxprezzo+")");
                    break;

                case 3:
                    minprezzo=arraysuper[0].getPrezzo();
                    minnome=arraysuper[0].getNome();

                    for(int i=1;i<n;i++)
                    {
                        if(arraysuper[i].getPrezzo()<minprezzo)
                        {
                            minnome=arraysuper[i].getNome();
                            minprezzo=arraysuper[i].getPrezzo();
                        }
                    }

                    System.out.println("Il prodotto con prezzo minore e':"+minnome+" ("+minprezzo+")");
                    break;

                case 4:
                    for(int i=0;i<n;i++)
                    {
                        somma+=arraysuper[i].getPrezzo();
                    }
                    media=somma/n;

                    System.out.println("La media del prezzo e di:"+media);
                    break;

                case 5:
                    System.out.println("Inserire il nome del prodotto da cercare:");
                    nom=sc.next();

                    for(int i=0;i<n;i++)
                    {
                        if(arraysuper[i].getNome().equals(nom))
                        {
                            trov=true;
                        }
                        else
                        {
                            trov=false;
                        }
                    }

                    if(trov)
                    {
                        System.out.println("Il prodotto e presente");
                    }
                    else
                    {
                        System.out.println("Il prodotto non e presente");
                    }
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
