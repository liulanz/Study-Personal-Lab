#include <iostream>
#include <string>
using namespace std;


void test(double x) {

	cout << "Enter test" << endl;
	if (x == 0) throw "Error";


}

int main() {
	char C[] = "ABCD";
	const char * C2 = "ABCD";
	char const *C3 = "EFGH";



	try {
		int dadsage = 35, sonsage = 40;
		if (dadsage < sonsage) throw 99;
		else cout << "OK" << endl;

		double i = 32.5, j = 0;
		if (j == 0) throw "Error";
		cout << i / j;


	}
	catch (int x) {
	//catch all int message thrown in the try block
		cout << "Son can't be older than Dad!" << "Error code : " << x << endl;
	}
	catch (char const * s) { cout << "cannot divide by 0" << endl; }
	//Catch all string message thrown

	catch (...) {}; //Catch all messages not caught by earlier catch blocks.



	try {
		double jj = 45.2, k = 0;
		test(k);
		cout << "OK";
	}
	catch (const char *   s) { cout << "New cannot divide by 0" << endl; }

	getchar();
	getchar();
}