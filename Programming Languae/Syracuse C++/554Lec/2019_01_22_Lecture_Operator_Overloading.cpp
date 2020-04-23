//Operator Overloading
#include <iostream>
using namespace std;
class ThreeD {
public:
	int ht;
	int wid;
	int dep;
	//constructor: the standard initializing methods

	ThreeD(int i, int j, int k) {
		ht = i * i; wid = j * j; dep = k * k;
	}
	//ThreeD(int i, int j, int k):ht(i*i), wid(j*j), dep(k*k){}
	//This will work equally.



	ThreeD() { ht = wid = dep = 0; }

	int vol() { return ht * wid*dep; }//return this->ht * this->wid * this->dep;
	int area();
	ThreeD operator+(ThreeD T);
	ThreeD operator*(ThreeD T);
	bool operator<(ThreeD T);
	int & operator[](int k); //return object of int type
	ThreeD operator++();//pre-fix
	ThreeD operator++(int never_used);//post-fix
};
ThreeD ThreeD::operator++(int never_used) {//post-fex
	ThreeD temp = *this;
	ht++;
	wid++;
	dep++;
	return temp;
}
ThreeD ThreeD::operator++() { //pre-fix
	++ht;
	++wid;
	++dep;
	return *this;
}

int& ThreeD::operator[](int k) {
	switch (k) {
	case 0: return ht;
	case 1: return wid;
	case 2: return dep;
	}

}


bool ThreeD::operator<(ThreeD T) {
	return vol() < T.vol();
}



ThreeD ThreeD::operator*(ThreeD T) {
	ThreeD temp;
	temp.ht = ht * T.ht;
	temp.wid = wid * T.wid;
	temp.dep = dep * T.dep;
	return temp;
}



ThreeD ThreeD::operator+(ThreeD T) {
	ThreeD temp;
	temp.ht = ht + T.ht;
	temp.wid = wid + T.wid;
	temp.dep = dep + T.dep;
	return temp;
}

int ThreeD::area() { return 2 * (ht*wid + wid * dep + dep * ht); }


int main() {
	//default initializer_list
	ThreeD t1 = { 3,4,5 };//= is optinal
	cout << t1.ht << " " << t1.wid << " " << t1.dep << endl;
	//3 4 5 if no constructor
	//9 16 25 with constructor

	ThreeD t2; //t2 has no initial values
	cout << t2.ht << " " << t2.wid << " " << t2.dep << endl;

	ThreeD *p1 = new ThreeD(10, 20, 30);
	cout << (*p1).vol() << endl;
	cout << p1->vol() << endl;//-> is pronounced as select
	cout << p1->ht << " " << p1->wid << " " << p1->dep << endl;

	ThreeD t10(4, 5, 6), t11(10, 20, 30), t12;
	t12 = t10 + t11;
	//compiler will convert this into the following
	//t12 = t10.operator+(t11);
	if (t10 < t11) cout << "t10 is less than t11" << endl;
	cout << t10[2];
	t12 = ++t10;//prefix
	t12 = t10++;//postfix
	t10[2] = 100;
	getchar();
	getchar();
	return 0;
}
