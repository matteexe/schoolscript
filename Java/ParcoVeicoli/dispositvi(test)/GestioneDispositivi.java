import java.util.Scanner;

public class GestioneDispositivi {
    public static void main(String[] args) {
        final int MAX=100;
        String marca;
        int annoProd;
        int numeroFotocamere;
        int dimensioneSchermo;
        int n,scelta;
        String scel;

        Scanner sc=new Scanner(System.in);
        Dispositivo[] info=new Dispositivo[MAX];

        do{
            System.out.println("Quanti dispositivi ci sono?");
            n=sc.nextInt();
        }while(n>MAX);

        for(int i=0;i<n;i++)
        {
            System.out.println("Scegliere se inserire uno smartphone oppure un laptop");
            scel=sc.next();

            if(scel.equalsIgnoreCase("smartphone"))
            {
                System.out.println("Inserire la marca:");
                marca=sc.next();
                System.out.println("Inserire l'anno di produzione:");
                annoProd=sc.nextInt();
                System.out.println("Inserire il numero di fotocamere:");
                numeroFotocamere=sc.nextInt();
                info[i]=new Smartphone(marca,annoProd,numeroFotocamere);
            }

            else if (scel.equalsIgnoreCase("laptop"))
            {
                System.out.println("Inserire la marca:");
                marca=sc.next();
                System.out.println("Inserire l'anno di produzione:");
                annoProd=sc.nextInt();
                System.out.println("Inserire la dimensione dello schermo:");
                dimensioneSchermo=sc.nextInt();
                info[i]=new Laptop(marca,annoProd,dimensioneSchermo);
            }
        }

        do{
            System.out.println("1)Output");
            System.out.println("2)Dispositivo piu vecchio");
            System.out.println("0)Esci dal programma");
            scelta=sc.nextInt();
            switch (scelta){
                case 1:
                    for(int i=0;i<n;i++)
                    {
                        System.out.println(info[i].toString());
                    }
                    break;
                case 2:
                    Dispositivo piuVecchio=info[0];
                    //facendo questo la variabile punta direttamente all'ogetto e non stiamo dando un vero valore alla variabile

                    for(int i=1;i<n;i++)
                    {
                        if(info[i].getAnnoProd()<piuVecchio.getAnnoProd())
                        {
                            piuVecchio=info[i];
                        }
                    }
                    System.out.println("Dispositivo più vecchio:"+piuVecchio);
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
