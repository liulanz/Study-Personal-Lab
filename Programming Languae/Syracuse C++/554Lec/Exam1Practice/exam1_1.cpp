//Mid-term, closed book   
//Write your answers directly on question sheets


//Problem 1
//Implement the two funcitons:   DB1_to_DB2 and print_DB2
#include <iostream>
#include <vector>
#include <list>


using namespace std;

void DB1_to_DB2(vector<list<int> *> &DB1, list< list< int *> *> &DB2);
void DB1_print(vector<list<int> *> &DB1);

void DB2_print(list<list<int *> *> &DB2);




int main() {

	vector<list<int> *> DB1 = { new list<int>({ 1,2,3 }), new list<int>({ 4,5 }) , new list<int>({ 8,9,10,11 }) };
	DB1_print(DB1);
	list< list<int *> *> DB2;
	DB1_to_DB2(DB1, DB2);
	DB2_print(DB2);
	getchar();
	getchar();
	return 0;
}

void DB1_print(vector<list<int> *> &DB1) {
	cout << endl;
	for (size_t i = 0; i < DB1.size(); i++) {
		auto it1 = DB1[i]->begin();
		while (it1 != DB1[i]->end()) {
			cout << *it1 << " ";
			it1++;
		}
		cout << endl;
	}
}


void DB2_print(list<list<int *> *> &DB2) {
	auto it1 = DB2.begin();
	while (it1 != DB2.end()) {
		auto it2 = (*it1)->begin();
		while (it2 != (*it1)->end()) {
			cout << **it2 << " ";
			it2++;
		}
		cout << endl;
		it1++;
	}


}

void DB1_to_DB2(vector<list<int> *> &DB1, list<list<int *> *> &DB2) {
	for (size_t i = 0; i < DB1.size(); i++) {
		auto it1 = DB1[i]->begin();
		list<int *> * Lp = new list<int *>;
		while (it1 != DB1[i]->end()) {
			Lp->push_back(new int(*it1));
			it1++;
		}
		DB2.push_back(Lp);
	}
}