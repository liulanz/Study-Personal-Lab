#include <iostream>
using namespace std;
void f1(int i) { //call by value
	//a new copy of i is created and used inside the function
	i++;
}
void f2(int &i) { //vall by reference
	//only one copy of i
	i++;
}

void f3(int B[]) { //array parameter alwasy use call by reference
	for (int i = 0; i < 5; i++) {
		B[i]++;
	}
	//for (int i : B) { i++; } will cause error because the range is not specified
}
//f4 is identical to f3
void f4(int *B) { //array parameter alwasy use call by reference
	for (int i = 0; i < 5; i++) {
		B[i]++;
	}
}


int main() {
	int A[5] = { 0,1,2,3,4 };//= is optional
	for (int i = 0; i < 5; i++) {
		cout << A[i] << " ";
	}
	cout << endl;
	for (int i : A) { cout << i << " "; }//for each
	cout << endl;

	for (int i : A) { i++; cout << i << " "; } //call by value
	cout << endl;
	for (int &i : A) { i++; cout << i << " "; } //call by reference
	cout << endl;
	for (int i : A) { cout << i << " "; }//for each
	cout << endl;

	int i = 1;
	f1(i);
	cout << i << endl;
	f2(i);
	cout << i << endl;

	for (int i : A) { cout << i << " "; }//for each
	cout << endl;
	f3(A);
	for (int i : A) { cout << i << " "; }//for each
	cout << endl;


	getchar();
	getchar();
	return 0;
}
