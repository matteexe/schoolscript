import java.util.Scanner;

public class GestioneVideogiochi {
    public static void main(String[] args) {
        final int DMAX=100;

        String titolo;
        int dimensioneGb;
        int annoUscita;
        String piattaforma;
        String genere;
        boolean multiplayer=false;

        int n,scelta,r,contatore=0;
        int minPeso,ricercaPeso,sommaRPG;
        String minNome,ricerca;
        float sommaMultiplayer,mediaMultiplayer;
        boolean ricercaPesoStatus,riceercaRPGstatus,mediaMutiplayerStatus,ricercaStatus;

        Scanner sc=new Scanner(System.in);
        Videogioco[] arrayVideogiochi=new Videogioco[DMAX];

        do{
            System.out.println("Quanti videogiochi ci sono?");
            n=sc.nextInt();
        }while(n>DMAX);

        for(int i=0;i<n;i++)
        {
            System.out.println("Inserire il titolo:");
            titolo=sc.next();
            System.out.println("Inserire la dimensione in GB:");
            dimensioneGb=sc.nextInt();
            System.out.println("Inserire l'anno di uscita:");
            annoUscita=sc.nextInt();
            System.out.println("Inserire la piattaforma:");
            piattaforma=sc.next();
            System.out.println("Inserire il genere del gioco:");
            genere=sc.next();
            System.out.println("E' multiplayer? 1)Si 2)No");
            r=sc.nextInt();
            if(r==1)
            {
                multiplayer=true;
            }
            else if(r==2)
            {
                multiplayer=false;
            }
            arrayVideogiochi[i]=new Videogioco(titolo,dimensioneGb,annoUscita,piattaforma,genere,multiplayer);
        }

        do{
            System.out.println("1)Output");
            System.out.println("2)Peso maggiore");
            System.out.println("3)Output gioco con dimensione maggiore a quella inserita dall'utente");
            System.out.println("4)Verificare la quantita di appartentneza al genere RPG");
            System.out.println("5)Dimensione media giochi multiplyer");
            System.out.println("6)Ricerca gioco per piattaforma");
            System.out.println("Fai la tua scelta:");
            scelta=sc.nextInt();
            switch (scelta) {
                case 1:
                    for (int i = 0; i < n; i++) {
                        System.out.println(arrayVideogiochi[i].toString());
                    }
                    break;
                case 2:
                    minPeso = arrayVideogiochi[0].getDimensioneGb();
                    minNome = arrayVideogiochi[0].getTitolo();

                    for (int i = 0; i < n; i++) {
                        if (minPeso < arrayVideogiochi[i].getDimensioneGb()) {
                            minPeso = arrayVideogiochi[i].getDimensioneGb();
                            minNome = arrayVideogiochi[i].getTitolo();
                        }
                    }

                    System.out.println("Il gioco con peso maggiore e:" + minNome + " con il peso di: " + minPeso);
                    break;

                case 3:
                    ricercaPesoStatus = false;


                    System.out.println("Inserire il peso da voler cercare:");
                    ricercaPeso = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        if (arrayVideogiochi[i].getDimensioneGb() > ricercaPeso) {
                            ricercaPesoStatus = true;
                            System.out.println(arrayVideogiochi[i].toString());
                        }
                    }
                    if (!ricercaPesoStatus) {
                        System.out.println("Non ci sono videogiochi con preso superiore a quello inserito");
                    }
                    break;

                case 4:
                    riceercaRPGstatus = false;
                    sommaRPG = 0;

                    for (int i = 0; i < n; i++) {
                        if (arrayVideogiochi[i].getGenere().equalsIgnoreCase("RPG")) {
                            riceercaRPGstatus = true;
                            sommaRPG += 1;
                        }
                    }

                    if (riceercaRPGstatus) {
                        System.out.println("CI sono" + sommaRPG + " videogiochi RPG");
                    } else if (!riceercaRPGstatus) {
                        System.out.println("Non ci sono videogiochi RPG");
                    }
                    break;

                case 5:
                    contatore=0;
                    mediaMultiplayer=0;
                    sommaMultiplayer=0;
                    mediaMutiplayerStatus=false;
                    for(int i=0;i<n;i++)
                    {
                        if(arrayVideogiochi[i].isMultiplayer()==true)
                        {
                            mediaMutiplayerStatus=true;
                            sommaMultiplayer=sommaMultiplayer+arrayVideogiochi[i].getDimensioneGb();
                            contatore+=1;
                        }
                    }

                    if(mediaMutiplayerStatus)
                    {
                        mediaMultiplayer=sommaMultiplayer/contatore;
                        System.out.println("La media dei giochi multiplayer e:"+mediaMultiplayer);
                    }
                    else if(!mediaMutiplayerStatus)
                    {
                        System.out.println("Non ci sonno giochi multiplayer");
                    }
                    break;

                case 6:
                    contatore=0;
                    ricercaStatus=false;
                    System.out.println("Inserire la piattaforma:");
                    ricerca=sc.next();

                    for(int i=0;i<n;i++)
                    {
                        if(arrayVideogiochi[i].getPiattaforma().equalsIgnoreCase(ricerca))
                        {
                            contatore+=1;
                            ricercaStatus=true;
                            System.out.println(arrayVideogiochi[i].toString());
                        }
                    }

                    if(ricercaStatus)
                    {
                        System.out.println("Ci sono "+contatore+" videogiochi per la piattaforma "+ricerca);
                    }
                    else if(!ricercaStatus)
                    {
                        System.out.println("Non ci sono videogiochi disponibioli per questa piattaforma");
                    }
                    break;

                case 0:
                    System.out.println("Sei uscito dal programma!");
                    break;
                default:
                    System.err.println("Scelta errata!");
                    break;
            }
        }while(scelta!=0);
    }
}
