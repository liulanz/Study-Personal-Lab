//Problem 2: Implement destructor, copy constructor, move constructor,

//left value operator=, and right value operator= for the linked_list class



#include <iostream>
using namespace std;

class node {

public:
	int value;
	node * next;
	node(int i) { value = i; next = nullptr; }
	node() { next = nullptr; }
};



class linked_list {
public:
	node * head;
	linked_list() { head = nullptr; }
	~linked_list();//destructor
	linked_list(const linked_list & L); //copy constructor
	linked_list(linked_list &&L);//move constructor
	void operator= (const linked_list &L); //L-value operator=
	void operator=(linked_list &&L); //R-value operator=
	linked_list(const initializer_list<int> & I);
	friend ostream & operator<<(ostream & str, const linked_list &L);
};

linked_list::~linked_list() { //destructor
	if (head == nullptr) return;
	node * p = head;
	while (p != nullptr) {
		node * p1 = p;
		delete p;
		p = p1;
	}
}

linked_list::linked_list(const linked_list & L): linked_list(){//copy constructor
	node * p1 = L.head, *p2;
	while (p1 != nullptr) {
		p2 = new node();
		p2->next = head;
		head = p2;
		p1 = p1->next;
	}
	p1 = head;
	p2 = L.head;
	while (p2 != nullptr) {
		p1->value = p2->value;
		p1 = p1->next;
		p2 = p2->next;
	}
}



linked_list::linked_list(linked_list && L) {//move constructor

	head = L.head;

	L.head = nullptr;

}



void linked_list::operator=(const linked_list &L){ //L-value operator=

	while (head != nullptr) {

		node * p1 = head->next;

		delete head;

		head = p1;

	}

	node * p1 = L.head, *p2;

	while (p1 != nullptr) {

		p2 = new node();

		p2->next = head;

		head = p2;

		p1 = p1->next;

	}

	p1 = head;

	p2 = L.head;

	while (p2 != nullptr) {

		p1->value = p2->value;

		p1 = p1->next;

		p2 = p2->next;

	}

}



linked_list::linked_list(const initializer_list<int> & I): linked_list(){

	auto it1 = I.end()-1;

	while (it1 != I.begin()) {

		node * p1 = new node(*it1);

		p1->next = head;

		head = p1;

		it1--;

	}

	node *p2 = new node(*it1);

	p2->next = head;

	head = p2;

}





void linked_list::operator=(linked_list &&L) {

	while (head != nullptr) {

		node * p1 = head->next;

		delete head;

		head = p1;

	}

	head = L.head;

	L.head = nullptr;

}



ostream & operator<<(ostream & str, const linked_list &L) {

	node * p1 = L.head;

	while (p1 != nullptr) {

		str << p1->value<< " ";

		p1 = p1->next;

	}

	return str;

}



int main() {

	linked_list L1 = { 1,2,3,4,5 };

	cout << L1 << endl;

	linked_list L2(L1), L3;

	cout << L2 << endl;

	L3 = L2;

	cout << L3 << endl;

	getchar();

	getchar();

	return 0;

}
