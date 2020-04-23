//lecture on 1/22/2019
#include <iostream>
#include <memory>
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
	//node * next;
	shared_ptr<node> next;
	//node(int i) { value = i; next = nullptr; }//NULL
	node(int i) { value = i; }
	//node() { next = nullptr; }
	node(){}
};

class linked_list {
public:
	//node * head;
	shared_ptr<node> head;
	//linked_list() { head = nullptr; }
	linked_list(){}
	void make_random_list(int m, int n);
	void reverse();
	void remove_one(int k); //remove the first occurance of node with value k
	void print();

};
void linked_list::remove_one(int k) {
	//if (head == nullptr) return; //this line is also OK
	if (!head) return;
	//node * p1, *p2;
	shared_ptr<node> p1, p2;
	if (head->value == k) {
		p1 = head;
		head = head->next;
		//delete p1; //no more delete for smart pointers
		p1.reset(); //p1 = nullptr; is also OK
		return;
	}
	p1 = head; p2 = p1->next;
	//while (p2 != nullptr) { //still OK
	while (p2) {
		if (p2->value == k) {
			p1->next = p2->next;
			//delete p2;
			p2.reset();
			return;
		}
		p1 = p2;
		p2 = p2->next;
	}
}
void linked_list::reverse() {
	//if (head == nullptr || head->next == nullptr) return;//OK
	if (!head || !(head->next)) return;
	//	if (head->next == nullptr || head == nullptr) return;  might lead to error
	//if (head = nullptr) return;
	//node * p1 = head, *p2, *p3;
	shared_ptr<node> p1 = head, p2, p3;
	p2 = p1->next;
	//while (p2 != nullptr) { //ok
	while (p2) {
		p3 = p2->next;
		p2->next = p1;
		//if (p1 == head) p1->next = nullptr; ok
		if (p1 == head) p1->next.reset();

		p1 = p2;
		p2 = p3;
	}
	head = p1;
}


void linked_list::print() {
	//node * p1 = head;
	shared_ptr<node> p1 = head;
	while (p1) {
	//while (p1 != nullptr) {//OK
		cout << p1->value << " ";
		p1 = p1->next;
	}
	cout << endl;
}

void linked_list::make_random_list(int m, int n) { //create n nodes with random value between 0 and m-1
	//node * p1;
	shared_ptr<node> p1;
	for (int i = 0; i < n; i++) {
		//p1 = new node(rand() % m);
		p1 = make_shared<node>(rand() % m);
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
	L1.reverse();
	L1.print();
	L1.remove_one(17);
	L1.print();


	getchar();
	getchar();
	return 0;
}
