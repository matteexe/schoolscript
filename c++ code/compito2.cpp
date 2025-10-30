#include <iostream>
using namespace std;
const int DMAX=5;

void caricamento(float mat[DMAX][DMAX],string nome[DMAX],string mesi[DMAX+1]);
void output(float mat[DMAX][DMAX],string nome[DMAX],string mesi[DMAX+1]);
void mediapri(float mat[DMAX][DMAX],string nome[DMAX],string mesi[DMAX+1]);
void min(float mat[DMAX][DMAX],string nome[DMAX],string mesi[DMAX+1]);
void diagonale(float mat[DMAX][DMAX],string nome[DMAX],string mesi[DMAX+1]);
void ricerca(float mat[DMAX][DMAX],string nome[DMAX],string mesi[DMAX+1]);

int main()
{
	int scelta;
	float mat[DMAX][DMAX];
	string nome[DMAX],mesi[DMAX+1];
	
	caricamento(mat,nome,mesi);
	
	do{
		cout<<"-----MENU-----"<<endl;
		cout<<"1)Output"<<endl;
		cout<<"2)Media di aprile"<<endl;
		cout<<"3)Tasso minimo"<<endl;
		cout<<"4)Stampare diagonale"<<endl;
		cout<<"5)Ricerca tasso di mese per una citta"<<endl;
		cout
		<<"0)Esci dal programma"<<endl;
		cout<<"Fai la tua scelta:";
		cin>>scelta;
		
		switch(scelta)
		{
			case 1:
				output(mat,nome,mesi);
				break;
			case 2:
				mediapri(mat,nome,mesi);
				break;
			case 3:
				min(mat,nome,mesi);
				break;
			case 4:
				diagonale(mat,nome,mesi);
				break;
			case 5:
				ricerca(mat,nome,mesi);
				break;
			case 0:
				cout<<"Esci dal programma"<<endl;
				break;
			default:
				cout<<"Scelta errata"<<endl;
		}
	}while(scelta!=0);
	
	return 0;
}

void caricamento(float mat[DMAX][DMAX],string nome[DMAX],string mesi[DMAX+1])
{
	for(int i=0;i<DMAX+1;i++)
		{
			switch(i)
			{
				case 0:
					mesi[i]="citta";
					break;
				case 1:
					mesi[i]="Gen";
					break;
				case 2:
					mesi[i]="Feb";
					break;
				case 3:
					mesi[i]="Mar";
					break;
				case 4:
					mesi[i]="Apr";
					break;
				case 5:
					mesi[i]="Mag";
					break;
			}
		}
	
	for(int i=0;i<DMAX;i++)
	{
		cout<<"Inserire il nome della "<<i+1<<" citta:";
		cin>>nome[i];
		for(int j=0;j<DMAX;j++)
		{
			switch(j)
			{
				case 0:
					cout<<"Inseire il dato di Gennaio:";
					cin>>mat[i][j];
					break;
				case 1:
					cout<<"Inserire il dato di Febbraio:";
					cin>>mat[i][j];
					break;
				case 2:
					cout<<"Inserire il dato di Marzo:";
					cin>>mat[i][j];
					break;
				case 3:
					cout<<"Inseire il dato di Aprile:";
					cin>>mat[i][j];
					break;
				case 4:
					cout<<"Inserire il dato di MAggio:";
					cin>>mat[i][j];
					break;
			}
		}
	}
}


void output(float mat[DMAX][DMAX],string nome[DMAX],string mesi[DMAX+1])
{
	for(int i=0;i<DMAX;i++)
	{
		cout<<mesi[i]<<"\t";
	}
	cout<<endl;
	
	for(int i=0;i<DMAX;i++)
	{
		cout<<nome[i]<<"\t";
		for(int j=0;j<DMAX;j++)
		{
			cout<<mat[i][j]<<"\t";
		}
		cout<<endl;
	}
}

void mediapri(float mat[DMAX][DMAX],string nome[DMAX],string mesi[DMAX+1])
{
	float media,somma;
	
	for(int i=0;i<DMAX;i++)
	{
		somma+=mat[i][3];
	}
	media=somma/DMAX;
	cout<<"La media del tasso di natalita di aprile e':"<<media<<endl;
}

void min(float mat[DMAX][DMAX],string nome[DMAX],string mesi[DMAX+1])
{
	int min=mat[0][0];
	string nomemin=nome[0],mesemin=mesi[1];
	
	for(int i=0;i<DMAX;i++)
	{
		for(int j=0;j<DMAX;j++)
		{
			if(min>mat[i][j])
			{
				min=mat[i][j];
				nomemin=nome[i];
				mesemin=mesi[i+1];
			}
		}
	}
	
	cout<<"A "<<nomemin<<" ad "<<mesemin<<" si e' registrato il tasso di natalita minimo: "<<min<<endl;
}

void diagonale(float mat[DMAX][DMAX],string nome[DMAX],string mesi[DMAX+1])
{
	cout<<"Il tasso di natalita' presente sulla diagonale principale e': ";
	
	for(int i=0;i<DMAX;i++)
	{
		cout<<mat[i][i]<<"\t";
	}
	
	cout<<endl;
}

void ricerca(float mat[DMAX][DMAX],string nome[DMAX],string mesi[DMAX+1])
{
	int nomecit,nomemes;
	
	do{
		cout<<"Scegli la citta:"<<endl;
		for(int i=0;i<DMAX;i++)
		{
			cout<<i+1<<")"<<nome[i]<<endl;
		}
		cin>>nomecit;
	}while(nomecit<1||nomecit>5);
	
	do{
		cout<<"Scegli il mese:"<<endl;
		for(int i=0;i<DMAX;i++)
		{
			cout<<i+1<<")"<<mesi[i+1]<<endl;
		}
		cin>>nomemes;
	}while(nomemes<1||nomemes>5);
	
	cout<<"A "<<mesi[nomemes]<<" il tasso di natalita di "<<nome[nomecit-1]<<" era di "<<mat[nomecit-1][nomemes-1]<<endl;
}