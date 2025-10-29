#include <iostream>
#include <fstream>
using namespace std;

void scriviSuFile(fstream &agenda);
void leggiDaFile(fstream &agenda);

int main()
{
	fstream agenda;
	
	agenda.open("c:\\FILE\\agenda.txt",ios::out);
	if (agenda.is_open())
	{
		 scriviSuFile(agenda);
         agenda.close();
	}
	else
	  cout<<"Impossibile creare il file";
	  
    agenda.open("c:\\FILE\\agenda.txt",ios::in);
    
    if (agenda.is_open())
	{
		 leggiDaFile(agenda);
         agenda.close();
	}
	else
	  cout<<"Impossibile aprire il file";
    
	 
	
	return 0;
}

void scriviSuFile(fstream &agenda)
{
	 string nome,cognome,tel;
	 char risposta;
	 do{
		     cout<<"Inserisci il nome"<<endl;
		     cin>>nome;
		     cout<<"Inserisci il cognome"<<endl;
		     cin>>cognome;
		     cout<<"Inserisci il telefono"<<endl;
		     cin>>tel;
		     agenda<<nome<<" "<<cognome<<" "<<tel<<endl;
		     cout<<"Vuoi continuare (S/N)"<<endl;
		     cin>>risposta;
		
         }while(risposta!='N');
	
}

void leggiDaFile(fstream &agenda)
{
         string nome,cognome,tel;
		 agenda>>nome>>cognome>>tel;//prima lettura
         
		 while(!agenda.eof())
         {
         	cout<<"Nome: "<<nome<<" Cognome: "<<cognome<<" Telefono: "<<tel<<endl;
			  
	        agenda>>nome>>cognome>>tel;  
		 }
}
