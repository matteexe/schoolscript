import java.util.Scanner;

public class GestioneNoleggio {
    public static void main(String[] args){
        final int DMAX=100;

        String marca;
        int giorni;
        double costoGiornaliero;
        int numeroPorte;
        String Alimentazione;
        int cilindrata;
        int annoImmatricolazione;

        int n,scelta,r;
        String ricerca;
        boolean status;


        Scanner sc=new Scanner(System.in);
        Veicolo[] arrayVeicolo=new Veicolo[DMAX];

        do{
            System.out.println("Quante veicoli ci sono?");
            n=sc.nextInt();
        }while(n>DMAX);

        for(int i=0;i<n;i++)
        {
            do{
                System.out.println("Selezionare il veicolo: 1)Auto,2)Moto");
                r=sc.nextInt();
            }while(r!=1 && r!=2);
            if(r==1)
            {
                System.out.println("Inserire la marca:");
                marca=sc.next();
                System.out.println("Inserire i giorni di noleggio:");
                giorni=sc.nextInt();
                System.out.println("Inseire il costo giornaliero:");
                costoGiornaliero=sc.nextDouble();
                System.out.println("Inserire il numero di porte:");
                numeroPorte=sc.nextInt();
                System.out.println("Scrivere il tipo di aliemntazione del veicolo:");
                Alimentazione=sc.next();
                arrayVeicolo[i]=new Auto(marca,giorni,costoGiornaliero,numeroPorte,Alimentazione);
            }
            else if(r==2)
            {
                System.out.println("Inserire la marca:");
                marca=sc.next();
                System.out.println("Inserire i giorni di noleggio:");
                giorni=sc.nextInt();
                System.out.println("Inseire il costo giornaliero:");
                costoGiornaliero=sc.nextDouble();
                System.out.println("Inserire la cilindrata:");
                cilindrata=sc.nextInt();
                System.out.println("Inserire l'anno di immatricolazione:");
                annoImmatricolazione=sc.nextInt();
                arrayVeicolo[i]=new Moto(marca,giorni,costoGiornaliero,cilindrata,annoImmatricolazione);
            }
        }

        do{
            System.out.println("1)output");
            System.out.println("2)Ricerca per marca");
            //System.out.println("3)veicolo piu vecchio");
            System.out.println("0)esci dal programma");
            System.out.println("Fai la tua scelta:");
            scelta=sc.nextInt();
            switch (scelta)
            {
                case 1:
                    for(int i=0;i<n;i++)
                    {
                        System.out.println(arrayVeicolo[i].toString());
                    }
                    break;
                case 2:
                    status=false;

                    System.out.println("Inserire la marca del veicolo da voler cercare:");
                    ricerca=sc.next();

                    for(int i=0;i<n;i++)
                    {
                        if(ricerca.equalsIgnoreCase(arrayVeicolo[i].getMarca()))
                        {
                            System.out.println(arrayVeicolo[i].toString());
                            status=true;
                        }
                    }

                    if(!status)
                    {
                        System.out.println("Non ci sono Veicolo con la marca inserita,riprovare.");
                    }
                    break;
                case 0:
                    System.out.println("Sei uscito dal programma");
                    break;

                default:
                    System.err.println("Scelta errarta.");
                    break;

            }
        }while(scelta!=0);

    }


}
