
//Problem 3:
//For the class linked_list Implement initializer_list, destructor, copy constructor, move constructor, L - value operator=, R - value operator=.
#include <iostream>
using namespace std;
class node {
public:
	int value;
	node * next;
	node() { next = nullptr; }
	node(int i) { value = i; next = nullptr; }
};

class linked_list {
public:
	node * head;
	int num_nodes;
	linked_list() { num_nodes = 0; head = nullptr; }
	void make_linked_list(int m, int n) {
		for (int i = 0; i < m; i++) {
			node * p1 = new node(rand() % n);
			p1->next = head;
			head = p1;
		}
		num_nodes = m;
	}
	void print_linked_list() {
		node * p1 = head;
		while (p1 != nullptr) { cout << p1->value<< " "; p1 = p1->next; }
	}
	linked_list(const initializer_list<int> &I);//initializer_list
	~linked_list();//destructor
	linked_list(const linked_list &L);//copy constructor
	linked_list(linked_list &&L); //move constructor
	void operator=(const linked_list &L);//L-value operator=
	void operator=(linked_list &&L);//R-value operator=

	linked_list add_1() {
		linked_list temp;
		temp = *this;
		node * p = temp.head;
		while (p != nullptr) {
			p->value++;
			p = p->next;
		}
		return temp;
	}
	friend ostream & operator<<(ostream & str, const linked_list &L);
};
linked_list::linked_list(const initializer_list<int> &I): linked_list() {//initializer_list
	auto it1 = I.end() - 1;
	while (it1 != I.begin() - 1) {
		node * p1 = new node(*it1);
		p1->next = head;
		head = p1;
		num_nodes++;
		it1--;
	}
	cout << "Leaving Initializer_List" << endl;
}
linked_list::~linked_list() {//destructor
	node * p1;
	while (head != nullptr) {
		p1 = head->next;
		delete head;
		head = p1;
	}
	cout << "Leaving Destructor" << endl;
}
linked_list::linked_list(const linked_list &L): linked_list() {//copy constructor
	node * p1;
	for (int i = 0; i < L.num_nodes; i++) {
		p1 = new node();
		p1->next = head;
		head = p1;
	}
	num_nodes = L.num_nodes;
	p1 = head;
	node * p2 = L.head;
	for (int i = 0; i < num_nodes; i++) {
		p1->value = p2->value;
		p1 = p1->next;
		p2 = p2->next;
	}
	cout << "Leaving Copy Constructor" << endl;
}
linked_list::linked_list(linked_list &&L): linked_list() { //move constructor
	num_nodes = L.num_nodes;
	head = L.head;
	L.num_nodes = 0;//This statement is optional
	L.head = nullptr;
	cout << "Leaving Move Constructor" << endl;
}


void linked_list::operator=(const linked_list &L) {//L-value operator=
	node * p1;
	while (head != nullptr) {
		p1 = head->next;
		delete head;
		head = p1;
	}
	head = nullptr;
	num_nodes = 0;
	for (int i = 0; i < L.num_nodes; i++) {
		p1 = new node();
		p1->next = head;
		head = p1;
	}
	num_nodes = L.num_nodes;
	p1 = head;
	node * p2 = L.head;
	for (int i = 0; i < num_nodes; i++) {
		p1->value = p2->value;
		p1 = p1->next;
		p2 = p2->next;
	}
	cout << "Leaving L-value Operator=" << endl;
}


void linked_list::operator=(linked_list &&L) {//R-value operator=
	node * p1;
	while (head != nullptr) {
		p1 = head->next;
		delete head;
		head = p1;
	}
	head = nullptr;
	num_nodes = L.num_nodes;
	head = L.head;
	L.head = nullptr;
	L.num_nodes = 0;
	cout << "Leaving R-value Operator=" << endl;
}

ostream & operator<<(ostream & str, const linked_list &L) {
	node * p = L.head;
	while (p != nullptr) {
		str << p->value << " ";
		p = p->next;
	}
	return str;
}

int main() {
	linked_list L1 = { 1,2,3,4,5 };
	//L.print_linked_list();
	cout << L1 << endl;
	linked_list L2 = L1, L3, L4;
	cout << L2 << endl;
	L3 = L2;
	cout << L3<<endl;
	L4 = L1.add_1();
	cout << L4;

	getchar();
	getchar();
	return 0;
}
