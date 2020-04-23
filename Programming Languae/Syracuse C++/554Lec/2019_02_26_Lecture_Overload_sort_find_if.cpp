#include <iostream>
#include <list>
#include <vector>
#include <map>
#include <string>
#include <algorithm> //find_if
using namespace std;

bool comp1(int i) {return  (i % 10 == 3); }

bool comp2(int * p1, int * p2) { return *p1 < *p2; }

int main() {
	vector<int> V1 = { 1,2,3,4,5 };
	auto it1 = find(V1.begin(), V1.end(), 4);
	cout << *it1 << endl;
	auto it2 = find_if(V1.begin(), V1.end(), comp1);//find_if: find the first element that
				//satisties a condition
	cout << *it2 << endl;

	list<int *> L1 = { new int(30), new int(6), new int(11), new int(3) };
	L1.sort(comp2); //sorting list of pointers to int.
	for (int *i : L1) { cout << *i << " "; }
	cout << endl;

	//list<vector<int *> *> L2 = {}  How do we initialize L2?
	//L2.sort(f1000); ??? how should f1000 looks like?
	//Are these right topics for midterm exam?

	//auto it3 = find(L1.begin(), L1.end(), 6, f2000);
	//the above is not currently supported in C++





	getchar();
	getchar();
	return 0;
}