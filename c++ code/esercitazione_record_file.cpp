#include <iostream>
#include <fstream>
#include <string>
using namespace std;

const int DMAX = 100;

struct LIBRO {
	string titolo;
	string autore;
	int anno;
	int pagine;
	string genere;
};

void caricamento(LIBRO lib[DMAX], int &numlib);
void outputfile(LIBRO lib[DMAX], int numlib, fstream &libri);
void libromaxpg(LIBRO lib[DMAX], int numlib, fstream& libri);
void riceaut(LIBRO lib[DMAX], int numlib, fstream& libri);
void medpag(LIBRO lib[DMAX], int numlib, fstream& libri);
void ricercann(LIBRO lib[DMAX], int numlib, fstream& libri);

int main()
{
	LIBRO lib[DMAX];

	int numlib, scelta;

	fstream libri;

	caricamento(lib, numlib);

	do {
		cout << "----MENU---- \n";
		cout << "1)Output su file \n";
		cout << "2)Libro con pagine maggiori \n";
		cout << "3)Ricerca per autore \n";
		cout << "4)Media pagine \n";
		cout << "5)Liribi pubblicati doopo un certo anno \n";
		cout << "Fai la tua scelta:";
		cin >> scelta;

		switch (scelta)
		{
		case 1:
			libri.open("c:/FILE/libreria.txt", ios::out);
			if (libri.is_open())
			{
				outputfile(lib, numlib, libri);
				libri.close();
			}
			else
				cout << "Impossibile creare file \n";
			break;
		case 2:
			libri.open("c:/FILE/libreria.txt", ios::app );
			if (libri.is_open())
			{
				libromaxpg(lib, numlib, libri);
				libri.close();
			}
			else
				cout << "Impossibile aprire file \n";
			break;
		case 3:
			libri.open("c:/FILE/libreria.txt", ios::app);
			if (libri.is_open())
			{
				riceaut(lib, numlib, libri);
				libri.close();
			}
			else
				cout << "Impossibile aprire file \n";
			break;
		case 4:
			libri.open("c:/FILE/libreria.txt", ios::app);
			if (libri.is_open())
			{
				medpag(lib, numlib, libri);
				libri.close();
			}
			else
				cout << "Impossibile aprire file \n";
			break;
		case 5:
			libri.open("c:/FILE/libreria.txt", ios::app);
			if (libri.is_open())
			{
				ricercann(lib, numlib, libri);
				libri.close();
			}
			else
				cout << "Impossibile aprire file \n";
			break;
		case 0:
			cout << "Sei uscito dal programma \n";
			break;
		default:
			cout << "Scelta errata \n";
			break;
		}
	} while (scelta != 0);

	return 0;
}

void caricamento(LIBRO lib[DMAX], int& numlib)
{
	do {
		cout << "Quanti libri ci sono?";
		cin >> numlib;
	} while (numlib > DMAX);

	for (int i = 0; i < numlib; i++)
	{
		cout << "Inserire titolo " << i + 1 << " libro:";
		cin >> lib[i].titolo;
		cout << "Inserire autore " << i + 1 << " libro:";
		cin >> lib[i].autore;
		cout << "Inserire anno " << i + 1 << " libro:";
		cin >> lib[i].anno;
		cout << "Inserire pagine " << i + 1 << " libro:";
		cin >> lib[i].pagine;
		cout << "Inserire genere " << i + 1 << " libro:";
		cin >> lib[i].genere;
	}
}

void outputfile(LIBRO lib[DMAX], int numlib, fstream& libri)
{
	libri << "Titolo" << "\t";
	libri << "Autore" << "\t";
	libri << "Anno" << "\t";
	libri << "Pagine" << "\t";
	libri << "Genere" << "\t";
	libri << "\n";

	for (int i = 0; i < numlib; i++)
	{
		libri << lib[i].titolo << "\t";
		libri << lib[i].autore << "\t";
		libri << lib[i].anno << "\t";
		libri << lib[i].pagine << "\t";
		libri << lib[i].genere << "\t";
		libri << "\n";
	}
}

void libromaxpg(LIBRO lib[DMAX], int numlib, fstream& libri)
{
	int max = lib[0].pagine;
	string maxnom = lib[0].titolo;

	for (int i = 1; i < numlib; i++)
	{
		if (max < lib[i].pagine)
		{
			max = lib[i].pagine;
			maxnom = lib[i].titolo;
		}
	}

	libri << "----Libro con pagine maggiori---- \n";
	libri << maxnom << " e' il libro con pagine maggiori (" << max << ") \n";

	cout << "Dato salvato con successo! \n";
}

void riceaut(LIBRO lib[DMAX], int numlib, fstream& libri)
{
	string cer;
	bool trov = false;
	int track = 0;

	cout << "Inserire il nomde dell'autore che si vuole cercare:";
	cin >> cer;

	for (int i = 0; i < numlib; i++)
	{
		if (cer == lib[i].autore)
		{
			trov = true;
			track += 1;
			if (track == 1)
				libri << "----Libri di " << cer << "---- \n";
			libri << lib[i].titolo << "\n";
		}
	}

	if (trov == true)
		cout << "Sono presenti del libri e sono stati correttamente salvati \n";
	else
		cout << "Non e' presente alcun libro di questo autore \n";
}

void medpag(LIBRO lib[DMAX], int numlib, fstream& libri)
{
	int somma = 0;
	float media = 0;

	for (int i = 0; i < numlib; i++)
	{
		somma += lib[i].pagine;
	}

	media = somma / numlib;

	libri << "----Media pagine---- \n";
	libri << "La media delle pagine e': " << media << "\n";

	cout << "Dato salvato con successo! \n";
}

void ricercann(LIBRO lib[DMAX], int numlib, fstream& libri)
{
	int cer, track = 0;
	bool trov = false;

	cout << "Inserire l'anno:";
	cin >> cer;

	for (int i = 0; i < numlib; i++)
	{
		if (cer < lib[i].anno)
		{
			trov = true;
			track += 1;
			if (track == 1)
				libri << "----Libri pubblicati dopo il " << cer << "---- \n";
			libri << lib[i].titolo << "-" << lib[i].anno << "\n";
		}
	}

	if (trov == false)
		cout << "Non sono presenti libri pubblicati dopo il " << cer << "\n";
	else
		cout << "Sono presenti dei libri e sono stati correttamente salvati \n";
}
