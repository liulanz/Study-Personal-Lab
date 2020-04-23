#include <iostream>
#include <time.h>
using namespace std;

int main() {

	srand(time(nullptr));//time(0) or time(NULL);
	//use current system time as seed for rand()
//	for (int i = 0; i < 10; i++) cout << rand() << " ";
	cout<<rand()<<endl;

	cout<<endl;
	int a = 7/2;
	int b = 7-7/2;
	cout<<" 7/2 =  "<< a <<endl;
	cout<<" 7- 7/2 =  "<< b <<endl;

	getchar();
	getchar();
	return 0;


}
