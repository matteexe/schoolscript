#include <iostream>
#include <string>
#include <fstream>

using namespace std;

const int PRODMAX = 20;

//dichiarazione del recod
struct PRODOTTI
{
	string codice;
	string nome;
	float prezzo;
};

void caricamento(PRODOTTI tabprod[PRODMAX],int &numprod);
void outputcmd(PRODOTTI tabprod[PRODMAX], int numprod);
void outputfile(PRODOTTI tabprod[PRODMAX], int numprod, fstream& prodotti);
void prezzomaggiore(PRODOTTI tabprod[PRODMAX], int numprod, fstream& prodotti);


int main()
{
	PRODOTTI tabprod[PRODMAX]; //dichiarazione tabella nei record
	int numprod = 0, scelta;

	fstream prodotti;//dichirazione file 

	caricamento(tabprod, numprod);

	do {
		cout << "----MENU---- \n";
		cout << "1)Output nel terminale \n";
		cout << "2)Output nel file \n";
		cout << "3)Diagonale\n";
		cout << "0)Esci dal programma \n";
		cout << "Fai la tua scelta:";
		cin >> scelta;

		switch (scelta)
		{
		case 1:
			outputcmd(tabprod, numprod);
			break;
		case 2:
			prodotti.open("D:/FILE/prodotti.txt", ios::out);//creazione e scrittura in un file
			if (prodotti.is_open())
			{
				outputfile(tabprod, numprod, prodotti);
				prodotti.close();
			}
			else
				cout << "Impossibile creare il file \n";
			break;
		case 3:
			prodotti.open("D:/FILE/prodotti.txt", ios::app);//scrittura in file già esistente
			if (prodotti.is_open())
			{
				prezzomaggiore(tabprod, numprod, prodotti);
				prodotti.close();
			}
			else
				cout << "Impossibile aprire il file \n";
			break;
		}
	} while (scelta != 0);
	
	return 0;
}

void caricamento(PRODOTTI tabprod[PRODMAX], int& numprod)
{
	do {
		cout << "Quanti prodotti ci sono?";
		cin >> numprod;
	} while (numprod > PRODMAX);

	for (int i = 0; i < numprod; i++)
	{
		cout << "Inserire il codice del prodotto:";
		cin >> tabprod[i].codice;
		cout << "Inserire il nome del prodotto:";
		cin >> tabprod[i].nome;
		cout << "Inserire il prezzo del prodotto:";
		cin >> tabprod[i].prezzo;
	}
}

void outputcmd(PRODOTTI tabprod[PRODMAX], int numprod)
{
	cout << "Codice" << "\t";
	cout << "Nome" << "\t";
	cout << "Prezzo" << "\t";
	cout << endl;

	for (int i = 0; i < numprod; i++)
	{
		cout << tabprod[i].codice << "\t";
		cout << tabprod[i].nome << "\t";
		cout << tabprod[i].prezzo << "\t";
		cout << endl;
	}
}

void outputfile(PRODOTTI tabprod[PRODMAX], int numprod, fstream& prodotti)
{
	prodotti << "--------MATRICE-------" << "\n";
	prodotti << "Codice" << "\t";
	prodotti << "Nome" << "\t";
	prodotti << "Prezzo" << "\t";
	prodotti << endl;

	for (int i = 0; i < numprod; i++)
	{
		prodotti << tabprod[i].codice << "\t";
		prodotti << tabprod[i].nome << "\t";
		prodotti << tabprod[i].prezzo << "€" << "\t";
		prodotti << endl;
	}

	cout << "I dati sono stati correttamenti scritti all'interno del file \n";
}

void prezzomaggiore(PRODOTTI tabprod[PRODMAX], int numprod, fstream& prodotti)
{
	int prezzomax = tabprod[0].prezzo;
	string codmax = tabprod[0].codice, nommax = tabprod[0].nome, scelta;

	for (int i = 0; i < numprod; i++)
	{
		if (tabprod[i].prezzo > prezzomax)
		{
			prezzomax = tabprod[i].prezzo;
			codmax = tabprod[i].codice;
			nommax = tabprod[i].nome;
		}
	}

	cout << nommax << " con codice " << codmax << " e' il prodotto con prezzo maggiore: " << prezzomax << endl;

	cout << "Vuoi scrivere il dato su file (Si o No):";
	cin >> scelta;

	if (scelta == "Si")
	{
		prodotti << "--------PREZZO MAGGIORE-------" << "\n";
		prodotti << nommax << " con codice " << codmax << " e' il prodotto con prezzo maggiore: " << prezzomax << "€" << endl;
		cout << "L'output e'stato correttamente salvato \n";
	}
}
