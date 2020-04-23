//srand()
//const

#include <iostream>
#include <time.h> //for time()

using namespace std;

int main() {
	
	srand(time(NULL)); //srand creates seed for rand();
	//time(NULL) returns current system time counting more than 100 years ago
	for (int i = 0; i < 10; i++) {
		cout << rand() % 10 << " ";
	}
	cout << endl;



	int i = 10, j = 20, k = 30;

	const int * p1 = &i; //int const * p1 = &i; is equivalent
	//*p1 = 100;  Error!  The object pointed by p1 is const

	int * const p2 = &j;
	//p2 = &k; Error!  p2 is const

	const int * const p3 = &k; 
	//both object pointed by p3 and p3 are const.

	/*
	Other examples of const
	void f1(const int & i) const {...}

	...

	const_iterator
	*/

	getchar();
	getchar();
	return 0;
}