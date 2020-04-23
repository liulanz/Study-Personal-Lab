#include <iostream>
using namespace std;
template <class T> class ThreeD {
public:
	T ht;
	T wid;
	T dep;
	ThreeD() { ht = wid = dep = (T)0; }
	ThreeD(T i, T j, T k) { ht = 10 * i; wid = 10 * j; dep = 10 * k; }
	T vol() { return ht * wid*dep; }
	template <class T> friend ostream & operator<<(ostream & str, const ThreeD<T> &t);
	template <class T> friend istream & operator>>(istream &str, ThreeD<T> &t);
};

template <class T> ostream & operator<<(ostream & str, const ThreeD<T> &t) {
	str << "(" << t.ht << ", " << t.wid << ", " << t.dep << ")";
	return str;
}

template <class T> istream & operator>>(istream &str, ThreeD<T> &t) {
	str >> t.ht >> t.wid >> t.dep;
	return str;
}



int main() {
	ThreeD<int> t1;
	cin >> t1;
	cout << t1 << endl;

	getchar();
	getchar();
	return 0;
}
