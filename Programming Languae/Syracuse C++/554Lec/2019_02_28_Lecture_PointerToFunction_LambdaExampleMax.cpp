
#include <iostream>
using namespace std;
int max(int a, int b, bool(*F)(int a, int b)) {
	cout << "Enter Max" << endl;
	if (F(a, b) == true) return a;
	else return b;
}
bool comp1(int a, int b) { return a > b; }
int main() {

	int a = 99, b = 44;

	cout << max(a, b, [](int a, int b) -> bool {return a <  b; }) << endl;
	cout << max(a, b, comp1) << endl;

	bool(*Q)(int a, int b); //Q is a pinter to function.
	Q = comp1;//Q points to the funciton for comp1.
	cout << max(a, b, comp1) << endl;

	int p;
	getchar();
	getchar();
	return 0;
}
