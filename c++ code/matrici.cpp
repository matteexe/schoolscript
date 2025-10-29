#include <iostream>
using namespace std;
const int MAX = 3;

void caricamento(int mat[MAX][MAX]);
void output(int mat[MAX][MAX]);
void sommarighe(int mat[MAX][MAX]);
void sommacolonne(int mat[MAX][MAX]);
void sommatot(int mat[MAX][MAX]);
void mediacolonne(int mat[MAX][MAX]);
void mediarighe(int mat[MAX][MAX]);
void mediatot(int mat[MAX][MAX]);
void massimorig(int mat[MAX][MAX]);
void massimocolo(int mat[MAX][MAX]);
void massimotot(int mat[MAX][MAX]);
void minimorighe(int mat[MAX][MAX]);
void minimocolonne(int mat[MAX][MAX]);
void minimotot(int mat[MAX][MAX]);
void traslazione(int mat[MAX][MAX], int mat1[MAX][MAX]);
void diagonale(int mat[MAX][MAX]);
void diagonale2(int mat[MAX][MAX]);


int main()
{
	int mat[MAX][MAX], mat1[MAX][MAX], scelta;
	cout << MAX;
	caricamento(mat);

	do {
		cout << "----MENU----" << endl;
		cout << "1)Output" << endl;
		cout << "2)Somma righe" << endl;
		cout << "3)Somma colonne" << endl;
		cout << "4)Somma totale" << endl;
		cout << "5)Media colonne" << endl;
		cout << "6)Media righe" << endl;
		cout << "7)Media totale" << endl;
		cout << "8)Massimo righe" << endl;
		cout << "9)Massimo colonne" << endl;
		cout << "10)Massimo totale" << endl;
		cout << "11)Minimo righe" << endl;
		cout << "12)Minimo colonne" << endl;
		cout << "13)Minimo totale" << endl;
		cout << "14)Traslazione" << endl;
		cout << "15)Diagonale principale" << endl;
		cout << "16)Diagonale secondaria" << endl;
		cout << "Fai la tua sclelta:";
		cin >> scelta;

		switch (scelta)
		{
		case 1:
			output(mat);
			break;
		case 2:
			sommarighe(mat);
			break;
		case 3:
			sommacolonne(mat);
			break;
		case 4:
			sommatot(mat);
			break;
		case 5:
			mediacolonne(mat);
			break;
		case 6:
			mediarighe(mat);
			break;
		case 7:
			mediatot(mat);
			break;
		case 8:
			massimorig(mat);
			break;
		case 9:
			massimocolo(mat);
			break;
		case 10:
			massimotot(mat);
			break;
		case 11:
			minimorighe(mat);
			break;
		case 12:
			minimocolonne(mat);
			break;
		case 13:
			minimotot(mat);
			break;
		case 14:
			traslazione(mat, mat1);
			output(mat1);
			break;
		case 15:
			diagonale(mat);
			break;
		case 16:
			diagonale2(mat);
			break;
		case 0:
			cout << "Sei uscito dal programma" << endl;
			break;
		default:
			cout << "Selezione errata" << endl;
			break;
		}

	} while (scelta != 0);

	return 0;
}

void caricamento(int mat[MAX][MAX])
{
	for (int i = 0; i < MAX; i++)
	{
		for (int j = 0; j < MAX; j++)
		{
			cout << "Elemento [" << i << " " << j << "]" << endl;
			cin >> mat[i][j];
		}
		;
	}
}

void output(int mat[MAX][MAX])
{
	for (int i = 0; i < MAX; i++)
	{
		for (int j = 0; j < MAX; j++)
		{
			cout << mat[i][j] << "\t";
		}
		cout << endl;
	}
}

void sommarighe(int mat[MAX][MAX])
{
	int tot = 0;

	for (int i = 0; i < MAX; i++)
	{
		tot = 0;
		for (int j = 0; j < MAX; j++)
		{
			tot += mat[i][j];
		}
		cout << "La somma della " << i << " riga e':" << tot << endl;
	}
}

void sommacolonne(int mat[MAX][MAX])
{
	int tot = 0;

	for (int j = 0; j < MAX; j++)
	{
		tot = 0;
		for (int i = 0; i < MAX; i++)
		{
			tot += mat[i][j];
		}
		cout << "La somma della " << j << " colonna e':" << tot << endl;
	}
}

void sommatot(int mat[MAX][MAX])
{
	int tot = 0;

	for (int i = 0; i < MAX; i++)
	{
		for (int j = 0; j < MAX; j++)
		{
			tot += mat[i][j];
		}
	}
	cout << "La somma della matrice e':" << tot << endl;
}

void mediacolonne(int mat[MAX][MAX])
{
	int tot = 0, media = 0;

	for (int j = 0; j < MAX; j++)
	{
		tot = 0;
		media = 0;
		for (int i = 0; i < MAX; i++)
		{
			tot += mat[i][j];
		}
		media = tot / MAX;
		cout << "La media della " << j << " colonna e':" << media << endl;
	}
}
void mediarighe(int mat[MAX][MAX])
{
	int tot = 0, media = 0;

	for (int i = 0; i < MAX; i++)
	{
		tot = 0;
		media = 0;
		for (int j = 0; j < MAX; j++)
		{
			tot += mat[i][j];
		}
		media = tot / MAX;
		cout << "La media della " << i << " riga e':" << media << endl;
	}
}

void mediatot(int mat[MAX][MAX])
{
	int tot = 0, media = 0;

	for (int j = 0; j < MAX; j++)
	{
		for (int i = 0; i < MAX; i++)
		{
			tot += mat[i][j];
		}
	}
	media = tot / (MAX * MAX);
	cout << "La media della matrice e':" << media << endl;
}

void massimorig(int mat[MAX][MAX])
{
	int max;

	for (int i = 0; i < MAX; i++)
	{
		max = mat[i][0];
		for (int j = 1; j < MAX; j++)
		{
			if (mat[i][j] > max)
				max = mat[i][j];
		}
		cout << "Il valore massimo della " << i << " riga e':" << max << endl;
	}
}

void massimocolo(int mat[MAX][MAX])
{
	int max;

	for (int j = 0; j < MAX; j++)
	{
		max = mat[0][j];
		for (int i = 1; i < MAX; i++)
		{
			if (mat[i][j] > max)
				max = mat[i][j];
		}
		cout << "Il valore massimo della " << j << " colonna e':" << max << endl;
	}
}

void massimotot(int mat[MAX][MAX])
{
	int max = mat[0][0];

	for (int i = 0; i < MAX; i++)
	{
		for (int j = 0; j < MAX; j++)
		{
			if (mat[i][j] > max)
				max = mat[i][j];
		}
	}
	cout << "Il valore massimo della matrice e':" << max << endl;
}

void minimorighe(int mat[MAX][MAX])
{
	int min;

	for (int i = 0; i < MAX; i++)
	{
		min = mat[i][0];
		for (int j = 1; j < MAX; j++)
		{
			if (min > mat[i][j])
				min = mat[i][j];
		}
		cout << "Il valore minimo della " << i << " riga e':" << min << endl;
	}
}

void minimocolonne(int mat[MAX][MAX])
{
	int min;

	for (int j = 0; j < MAX; j++)
	{
		min = mat[0][j];
		for (int i = 1; i < MAX; i++)
		{
			if (min > mat[i][j])
				min = mat[i][j];
		}
		cout << "Il valore minimo della " << j << " colonna e':" << min << endl;
	}
}

void minimotot(int mat[MAX][MAX])
{
	int min = mat[0][0];

	for (int i = 0; i < MAX; i++)
	{
		for (int j = 0; j < MAX; j++)
		{
			if (min > mat[i][j])
				min = mat[i][j];
		}
	}
	cout << "Il valore minimo della matrice e':" << min << endl;
}

void traslazione(int mat[MAX][MAX], int mat1[MAX][MAX])
{
	for (int i = 0; i < MAX; i++)
	{
		for (int j = 0; j < MAX; j++)
		{
			mat1[j][i] = mat[i][j];
		}
	}
}

void diagonale(int mat[MAX][MAX])
{
	cout << "La diagonale principale e' composta da: ";
	for (int i = 0; i < MAX; i++)
	{
		cout << mat[i][i] << "\t";
	}
	cout << endl;
}

void diagonale2(int mat[MAX][MAX])
{
	cout << "La diagonale secondaria e' composta da: ";
	for (int i = 0; i < MAX; i++)
	{
		cout << mat[i][MAX-1-i] << "\t";
	}
	cout << endl;
}
