import com.sun.source.tree.OpensTree;

import java.util.Scanner;

public class GestioneVeicoli {
    public static void main(String[] args){
        final int MAX=100;

        String Targa;
        String Marca;
        Double TarriffaBase;
        int Ore;
        int Cilindrata;

        int scelta,n;
        int cilindrataMax,ricercaCil,contatore;
        double media,somma;
        String targaMax,ricercaTarga;
        Boolean statusRicercaCil,trovato;
        double tariffa;

        Scanner sc=new Scanner(System.in);

        Auto[] arrayAuto=new Auto[MAX];

        do{
            System.out.println("Quanti veicoli ci sono?");
            n=sc.nextInt();
        }while(n>MAX||n<0);

        for(int i=0;i<n;i++)
        {
            System.out.println("Inserire la targa del veicolo:");
            Targa=sc.next();
            System.out.println("Inscerisci la marca del veicolo");
            Marca=sc.next();
            System.out.println("Inserisci la tariffa base:");
            TarriffaBase=sc.nextDouble();
            System.out.println("Inserisci la cilindrata del motore:");
            Cilindrata=sc.nextInt();
            arrayAuto[i]=new Auto(Targa,Marca,TarriffaBase,Cilindrata);
        }

        do{
            System.out.println("1)Vettura con cilindrata maggiore");
            System.out.println("2)Visualizzare le marche con cilindrata maggiore di quella inserita");
            System.out.println("3)Conteggio auto Fiat");
            System.out.println("4)Calcolo cilindrata media auto Renault");
            System.out.println("5)Calcolo ore di sosta");
            System.out.println("0)Esci dal programma");
            scelta=sc.nextInt();

            switch(scelta)
            {
                case 1:
                    cilindrataMax=arrayAuto[0].getCilindrata();
                    targaMax=arrayAuto[0].Targa;

                    for(int i=1;i<n;i++)
                    {
                        if(cilindrataMax<arrayAuto[i].getCilindrata())
                        {
                            cilindrataMax=arrayAuto[i].getCilindrata();
                            targaMax=arrayAuto[i].Targa;
                        }
                    }

                    System.out.println("Il veicolo con cilindrata maggiore ha targa "+targaMax+" cilindrata: "+cilindrataMax);
                    break;

                case 2:
                    statusRicercaCil=false;
                    System.out.println("Inserire la cilindrata");
                    ricercaCil=sc.nextInt();

                    for(int i=0;i<n;i++)
                    {
                        if(arrayAuto[i].getCilindrata()>ricercaCil)
                        {
                            System.out.println(arrayAuto[i].toString());
                            statusRicercaCil=true;
                        }
                    }

                    if(!statusRicercaCil)
                    {
                        System.out.println("Non ci sono veicoli con cilindrata superiore a quella inserita");
                    }
                    break;

                case 3:
                    contatore=0;
                    for(int i=0;i<n;i++)
                    {
                        if(arrayAuto[i].Marca.equalsIgnoreCase("fiat")){
                            contatore++;
                        }
                    }

                    if(contatore==0)
                    {
                        System.out.println("Non ci sono auto Fiat");
                    }
                    else
                    {
                        System.out.println("Ci sono "+contatore+" auto Fiat");
                    }
                    break;

                case 4:
                   media=0;
                   somma=0;
                   contatore=0;

                   for(int i=0;i<n;i++)
                   {
                       if(arrayAuto[i].Marca.equalsIgnoreCase("Renault"))
                       {
                           somma=somma+arrayAuto[i].getCilindrata();
                           contatore++;
                       }
                   }

                   if(contatore==0)
                   {
                       System.out.println("Non ci sono auto Renault");
                   }
                   else if(contatore>0)
                   {
                       media=somma/contatore;
                       System.out.println("La cilindrata media delle auto Renault e di "+media);
                   }
                   break;

                case 5:
                    System.out.println("Inserire le ore:");
                    Ore=sc.nextInt();
                    System.out.println("Inserire il numero di targa");
                    ricercaTarga=sc.next();
                    tariffa=0;
                    trovato=false;

                    for(int i=0;i<n;i++)
                    {
                        if(arrayAuto[i].Targa.equalsIgnoreCase(ricercaTarga))
                        {
                            tariffa=arrayAuto[i].CalcolaTariffa(Ore);
                            trovato=true;
                        }
                    }


                    if(!trovato)
                    {
                        System.out.println("Non e stata trovata nessuna targa uguale a quella inserita");
                    }
                    else if(trovato)
                    {
                        System.out.println("La tariffa da pagare e di:"+tariffa);
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
