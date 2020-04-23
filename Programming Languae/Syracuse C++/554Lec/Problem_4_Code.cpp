//Problem 4
//passing function as parameter and Lambda function

#include <iostream>
#include <list>
using namespace std;

int  first_or_last(list<int> & L) {
	return (L.front() > L.back()) ? L.front() : L.back();
}
//This function compares the first and last element of L, and returns the larger of the two.



int F1(int i, list<int> &V, int (* F2)(list<int> & V)) {
	return (i + F2(V));

	}


int main() {

	list<int> L1 = { 1,2,3,4,5 };
	cout << F1(2, L1, first_or_last) << endl; //This will print 7 to console
	cout << F1(2, L1, [](list<int> &L1) {int sum = 0; for (int i : L1) { sum += i; } return sum;  }) << endl; //This will print 17 to console
															//**********************************
	getchar();
	getchar();
	return 0;
}