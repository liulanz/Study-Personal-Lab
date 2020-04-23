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


template <class T> class node {
public:
	T value;
	node<T> * next;
	node(T i) { value = i; next = nullptr; }//NULL
	node() { next = nullptr; }
};

template <class T> class linked_list {
public:
	node<T> * head;
	linked_list() { head = nullptr; }
	void make_random_list(int m, T n);
	void reverse();
	void remove_one(T k); //remove the first occurance of node with value k
	void print();
	linked_list(const initializer_list<T> &V);
};
template <class T> linked_list<T>::linked_list(const initializer_list<T> &V) {
	auto it1 = V.end() - 1;

	while (it1 != V.begin() - 1) {
		node<T> * p1 = new node<T>(*it1);
		p1->next = head;
		head = p1;
		it1--;
	}
}



template <class T> void linked_list<T>::remove_one(T k) {
	if (head == nullptr) return;
	node<T> * p1, *p2;
	if (head->value == k) {
		p1 = head;
		head = head->next;
		delete p1;
		return;
	}
	p1 = head; p2 = p1->next;
	while (p2 != nullptr) {
		if (p2->value == k) {
			p1->next = p2->next;
			delete p2;
			return;
		}
		p1 = p2;
		p2 = p2->next;
	}
}
template <class T> void linked_list<T>::reverse() {
	if (head == nullptr || head->next == nullptr) return;
	//	if (head->next == nullptr || head == nullptr) return;  might lead to error
	//if (head = nullptr) return;
	node<T> * p1 = head, *p2, *p3;
	p2 = p1->next;
	while (p2 != nullptr) {
		p3 = p2->next;
		p2->next = p1;
		if (p1 == head) p1->next = nullptr;
		p1 = p2;
		p2 = p3;
	}
	head = p1;
}


template <class T> void linked_list<T>::print() {
	node<T> * p1 = head;
	while (p1 != nullptr) {
		cout << p1->value << " ";
		p1 = p1->next;
	}
	cout << endl;
}

template <class T> void linked_list<T>::make_random_list(int m, T n) { //create n nodes with random value between 0 and m-1
	node<T> * p1;
	for (int i = 0; i < n; i++) {
		p1 = new node<T>(rand() % m);
		p1->next = head;
		head = p1;
	}
}

template <class W> ostream & operator<<(ostream & str, const linked_list<W> L) {
	node<W> *p1 = L.head;
	str << "% ";
	while (p1 != nullptr) {
		str << p1->value << " ";
		p1 = p1->next;
	}
	str << "%" << endl;
	return str;
}


int main() {
	//default initializer_list
	/*
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
	*/
	linked_list<int> L1;
	L1.make_random_list(50, 10);
	L1.print();
	L1.reverse();
	L1.print();
	L1.remove_one(17);
	L1.print();
	linked_list<int> L2 = { 10,20,30,40,50 };
	L2.print();
	cout << L2 << endl;

	getchar();
	getchar();
	return 0;
}
