/*Scrivere un programma che permetta di caricare i dati relativi
a una serie di prodotti(codice del prodotto,descrizione e prezzo)in una tabella
Successivamente visualizzare il contenuto della tabella su video */

#include <iostream>
#include <string>
using namespace std;

const int MAXPROD=20;

struct PRODOTTI
{
	string codice;
	string descrizione;
	float prezzo;
};

void carica(PRODOTTI tabprod[MAXPROD],int &numprod);
void output(PRODOTTI tabprod[MAXPROD],int numprod);
	
int main()
{
	PRODOTTI tabprod[MAXPROD];
	int numprod=0;
	
	carica(tabprod,numprod);
	output(tabprod,numprod);
	
	return 0;
}

void carica(PRODOTTI tabprod[MAXPROD],int &numprod)
{
	do{
		cout<<"Quanti prodotti ci sono?";
		cin>>numprod;
	}while(numprod>MAXPROD);
	
	for(int i=0;i<numprod;i++)
	{
		cout<<"Inserisci il codice prodotto:";
		cin>>tabprod[i].codice;
		cout<<"Inserisci il nome:";
		cin>>tabprod[i].descrizione;
		cout<<"Inserisci il prezzo:";
		cin>>tabprod[i].prezzo;
	}
}

void output(PRODOTTI tabprod[MAXPROD],int numprod)
{
	cout<<"Codice"<<"\t";
	cout<<"Nome"<<"\t";
	cout<<"Prezzo"<<"\t";
	cout<<endl;
	
	for(int i=0;i<numprod;i++)
	{
		cout<<tabprod[i].codice<<"\t";
		cout<<tabprod[i].descrizione<<"\t";
		cout<<tabprod[i].prezzo<<"\t";
		cout<<endl;
	}
}
