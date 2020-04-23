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
	ThreeD() { ht = wid = dep = 0; }
	int vol() { return ht * wid*dep; }//return this->ht * this->wid * this->dep;
	int area();
};
int ThreeD::area() { return 2 * (ht*wid + wid * dep + dep * ht); }

class node {
public:
	int value;
	node * next;
	node(int i) { value = i; next = nullptr; }//NULL
	node() { next = nullptr; }
};

class linked_list {
public:
	node * head;
	linked_list() { head = nullptr; }
	void make_random_list(int m, int n);
	void print();

};
void linked_list::print() {
	node * p1 = head;
	while (p1 != nullptr) {
		cout << p1->value << " ";
		p1 = p1->next;
	}
	cout << endl;
}

void linked_list::make_random_list(int m, int n) { //create n nodes with random value between 0 and m-1
	node * p1;
	for (int i = 0; i < n; i++) {
		 p1 = new node(rand() % m);
		 p1->next = head;
		 head = p1;
	}
}

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

	linked_list L1;
	L1.make_random_list(50, 10);
	L1.print();


	getchar();
	getchar();
	return 0;
}
