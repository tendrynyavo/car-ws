#include "stdio.h"
#include "stdlib.h"

typedef struct Olona
{
	char* nom;
	struct Olona* RAD;
	struct Olona* zanaka;
} Olona;

void traverser( Olona* membre ){
	Olona* zanaka = membre;
	while( zanaka != NULL ){
		printf("Mon nom est %s\n", zanaka[0].nom );
		zanaka = zanaka[0].zanaka;
	}
}

void ajouter( int index, Olona* olona, Olona olona_1 ){
	Olona* aloha;
	Olona* afara;
	Olona* zanaka = olona;
	int i = 0;
	while( zanaka != NULL ){
		if( i == index ){
			aloha = zanaka[0].RAD;
			afara = zanaka[0].zanaka;
		}
	}
}

void main()
{
	Olona olona;
	olona.nom = "Anarana 1";

	Olona olona2;
	olona2.nom = "Anarana 2";

	Olona olona3;
	olona3.nom = "Anarana 3";

	olona.zanaka = &olona2;

	olona2.zanaka = &olona3;

	Olona olona4;
	olona4.nom = "Test Faha 4";

	traverser(&olona);

	// return 0;
}