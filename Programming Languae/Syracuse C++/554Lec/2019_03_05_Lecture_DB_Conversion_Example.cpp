#include <iostream>
#include <list>
#include <vector>
#include <map>
using namespace std;
template <class T> ostream & operator<<(ostream &str, const vector<T> & V) {
	for (T i : V) { str << i << " "; }
	return str;
}
template <class T> ostream & operator<<(ostream &str, const list<T> & L) {
	for (T i : L) { str << i << " "; }
	return str;
}

template <class T> ostream &operator<<(ostream &str, list<T *> L) {
	for (T *i : L) { str << *i << " "; }
	return str;
}
template <class T> ostream &operator<<(ostream &str, vector<T *> V) {
	for (T *i : V) { str << *i << " "; }
	return str;
}



void DB1_to_DB2(list<vector<int>> &DB1, vector<list<int>> &DB2);

void DB1_to_DB3(list<vector<int >> &DB1, list< vector<int> *> &DB3);
void DB1_to_DB4(list<vector<int>> &DB1, list<vector<int *> *> &DB4);



int main() {
	list<vector<int>> DB1 = { {1,2,3},{4,5},{6,7,8,9} };
	cout << DB1 << endl;
	vector<list<int>> DB2;
	DB1_to_DB2(DB1, DB2);
	cout << DB2 << endl;
	
	list< vector<int> *> DB3 = { new vector<int>({1,2}), new vector<int>({3,4,5}) };
	auto it1 = DB3.begin();
	for (vector<int> * i : DB3) { delete i; }
	DB3.clear();
	DB1_to_DB3(DB1, DB3);
	cout << DB3 << endl;

	//list  <list <list <int> *> * > L = ;

	list< vector<int *> *>  DB4;
	DB1_to_DB4(DB1, DB4);
	cout << DB4 << endl;
	getchar();
	getchar();
	return 0;
}

void DB1_to_DB2(list<vector<int>> &DB1, vector<list<int>> &DB2) {
	auto it1 = DB1.begin();

	while (it1 != DB1.end()) {
		list<int> L1;
		for (size_t i = 0; i < it1->size(); i++) {
			L1.push_back((*it1)[i]);
		}
		DB2.push_back(L1);
		it1++;
	}
}

void DB1_to_DB3(list<vector<int >> &DB1, list< vector<int> *> &DB3) {
	auto it1 = DB1.begin();
	while (it1 != DB1.end()) {
		vector<int> *p1 = new vector<int>;
		for (size_t i = 0; i < it1->size(); i++) {
			p1->push_back((*it1)[i]);
		}
		DB3.push_back(p1);
		it1++;
	}
}

void DB1_to_DB4(list<vector<int>> &DB1, list<vector<int *> *> &DB4) {
	auto it1 = DB1.begin();
	while (it1 != DB1.end()) {
		vector<int *> *p1 = new vector<int *>;
		for (size_t i = 0; i < it1->size(); i++) {
			int * p2 = new int((*it1)[i]);
			p1->push_back(p2);
		}
		DB4.push_back(p1);
		it1++;
	}
}