//initializer_list, template, overloading<<
#include <iostream>
#include <vector>
#include <list>
using namespace std;

template <class T> class THREED {
public:
	T ht;
	T wid;
	T dep;
	THREED() { ht = wid = dep = (T)0; }
	THREED(T i, T j, T k) { ht = (T)10 * i; wid = (T)10 * j; dep = (T)10 * k; }
	T vol() { return ht * wid* dep; }
	THREED(const initializer_list<T> &V);
	template <class T> friend ostream & operator<<(ostream &str, const THREED<T> &t);
};
template <class T> THREED<T>::THREED(const initializer_list<T> &V) {
	auto it1 = V.begin();
	ht = (T)100 * *it1;
	
	it1++;
	wid = (T)100 * *it1;
	it1++;
	dep = (T)100 * *it1;
}

class ThreeD {
public:
	int ht;
	int wid;
	int dep;
	ThreeD() { ht = wid = dep = 0; }
	ThreeD(int i, int j, int k) { ht = 10 * i; wid = 10 * j; dep = 10 * k; }
	ThreeD(const initializer_list<int> &V);
	friend ostream & operator<<(ostream &str, const ThreeD &T);
};
ThreeD::ThreeD(const initializer_list<int> &V) {
	auto it1 = V.begin();
	ht = 100 * *it1;
	it1++;
	wid = 100 * *it1;
	it1++;
	dep = 100 * *it1;
}
template <class T> ostream & operator<<(ostream &str, const THREED<T> &t) {
	str << "(" << t.ht << ", " << t.wid << ", " << t.dep << ")";
	return str;
}

ostream & operator<<(ostream &str, const ThreeD &T) {
	str << "(" << T.ht << ", " << T.wid << ", " << T.dep << ")";
	return str;
}
template <class T> ostream & operator<< (ostream &str, const vector<T> &V) {
	for (size_t i = 0; i < V.size(); i++) {
		str << V[i] << " ";
	}
	str << endl;
	return str;
}
ostream & operator<< (ostream &str, const vector<int> &V) {
	for (size_t i = 0; i < V.size(); i++) {
		str << V[i] << " ";
	}
	str << endl;
	return str;
}

template <class T> ostream & operator<< (ostream &str, const list<T> &L) {
	auto it1 = L.begin();
	while (it1 != L.end()) {
		str << *it1 << " ";
		it1++;
	}
	str << endl;
	return str;
}

ostream & operator<< (ostream &str, const list<int> &L) {
	auto it1 = L.begin();
	while (it1 != L.end()) {
		str << *it1 << " ";
		it1++;
	}
	str << endl;
	return str;
}

int main() {
	ThreeD t1 = { 1,2,3 };
	cout << t1 << endl;
	ThreeD t2(2, 3, 4);
	cout << t2 << endl;
	THREED<double> t3 = { 1.1, 2.2, 3.3 };
	cout << t3 << endl;


	vector<int> V1 = { 1,2,3,4,5 };
	cout << V1 << endl;
	list<int> L1 = { 2,3,4,5,6 };
	cout << L1 << endl;
	vector<list<vector<int>>> V = { { {1,2,3,4},{3,6}}, {{1,2,1},{3,4,5,6},{3,3,3}} };
	cout << V << endl;

	list<vector<THREED<int>>> L5 = { {{1,2,3}, {2,3,4}}, {{6,7,8}}, {{4,4,4}, {5,5,5}, {6,6,6}} };
	cout << L5 << endl;
	getchar();
	getchar();
	return 0;
}
//linked_list L1= {4,5,6,7,8};
