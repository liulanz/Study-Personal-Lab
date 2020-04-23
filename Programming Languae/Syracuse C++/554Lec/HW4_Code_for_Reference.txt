//HW4
#include <iostream>
#include <string>
#include <vector>
using namespace std;

template <class T> class ThreeD {
public:
	T ht;
	T wid;
	T dep;
	ThreeD() { ht = wid = dep = 0; }
	ThreeD(T i) { ht = wid = dep = i; }
	ThreeD(T a, T b, T c) { ht = a; wid = b; dep = c; }
	T vol() const { return ht * wid*dep; }
	bool operator==(const ThreeD<T> &t) const { return (vol() == t.vol()); }
	template <class T> friend	ostream & operator<<(ostream &s, const ThreeD<T> &t);
};

template <class T> class node {
public:
	T value;
	node<T> * next;
	node<T> * previous;
	node<T>() { next = nullptr; previous = nullptr; }
	node<T>(T v) { value = v; next = nullptr; previous = nullptr; }
	bool operator==(const node<T> &t) const { return value == t.value; }
};
template <class T> class linked_list {
public:
	node<T> * first;
	node<T> * last;
	linked_list() {first = last = nullptr; }
	linked_list(const initializer_list<T> &V);
	void push_front(T t);
	void push_back(T t);
	bool operator==(const linked_list<T> &L) const;
	linked_list(const linked_list<T> &L); //copy constructor
	~linked_list();//destructor
	void operator=(const linked_list<T> &L);//L-value operator=
	template <class T> friend ostream & operator<<(ostream &s, const linked_list<T> &L);
};
template <class T> linked_list<T>::linked_list(const initializer_list<T> &V) : linked_list() {
	auto it1 = V.begin();
	while (it1 != V.end()) {
		push_back(*it1);
		it1++;
	}
}

template <class T> linked_list<T>::~linked_list() {  //destructor										
	node<T> * p;
	while (first != nullptr) {
		p = first->next;
		delete first;
		first = p;
	}
}

template <class T> linked_list<T>::linked_list(const linked_list<T> &L) : linked_list() { //copy constructor																			  																		  //num_nodes = 0;
	node<T> * p1 = L.first;
	while (p1 != nullptr) {
		push_back(p1->value);
		p1 = p1->next;
	}
}

template <class T> void linked_list<T>::operator=(const linked_list<T> &L) { //operator= left ref
	node<T> * p;
	while (first != nullptr) {
		p = first->next;
		delete first;
		first = p;
	}
	p = L.first;
	while (p != nullptr) {
		push_back(p->value);
		p = p->next;
	}
}

template <class T> void linked_list<T>::push_front(T t) {
	node<T> * p = new node<T>(t);
	if (first == nullptr) { first = last = p; }
	else {
		p->next = first;
		first->previous = p;
		first = p;
	}
}

template <class T> void linked_list<T>::push_back(T t)
{
	node<T> * p = new node<T>(t);
	if (first == nullptr) { first = last = p; }

	else {
		p->previous = last;
		last->next = p;
		last = p;
	}
}

template <class T> bool linked_list<T>::operator==(const linked_list<T> &L) const {
	int n1 = 0, n2 = 0;
	node<T> * p;
	p = first;
	while (p != nullptr) {
		p = p->next;
		n1++;
	}
	p = L.first;
	while (p != nullptr) {
		p = p->next;
		n2++;
	}
	if (n1 != n2) return false;
	node<T> * p1 = first, *p2 = L.first;

	while (p1 != nullptr) {
		if (!(p1->value == p2->value)) { return false; }
		p1 = p1->next;
		p2 = p2->next;
	}
	return true;
}

template <class X>
class item {
public:
	X data;
	item<X> *next;
	item<X> *previous;
	item<X>(X d) { data = d; next = nullptr; previous = nullptr; }
	bool operator==(const item<X> &I) const { return data == I.data; }
	template <class T> friend ostream & operator<<(ostream &s, const item<T> &I);
};

template <class X>
class bag {
public:
	item<X> *head;
	item<X> *tail;
	int num_items;
	int size() { return num_items; }
	//void show_bag();//Print all items in the bag
	bag() { tail = nullptr; head = nullptr; num_items = 0; } //default constructor for bag class
	bag(const initializer_list<X> &V);
	~bag();//destructor
	bag(const bag<X> & B);//copy constructor
	void operator=(const bag<X> & B); //operator= ; left value operator=
	void push_back(X d);  
	void push_front(X d); 
	void pop_back(); 
	void pop_front(); 
	X &operator[](int i); //Access bag item with index. 
	X front() {  return head->data;}
	X back() {return tail->data;}
	void clear(); 
	item<X> * find(X d); //return nullptr if no match for find or if bag is empty.
	void erase(int index);
	void erase(item<X> * p);
	item<X> * insert(item<X> *p, X d); //insert data d to the position before p and return the position of the inserted item
	template <class X> friend ostream & operator<<(ostream &s, const bag<X> &B);
};

template <class X> item<X> * bag<X>::insert(item<X> *p, X d) {
	item<X> * p1 = new item<X>(d);
	p1->previous = p->previous;
	if (p->previous != nullptr) p->previous->next = p1;
	p1->next = p;
	p->previous = p1;
	if (p == head) head = p1;
	num_items++;
	return p1;
}

template <class X> bag<X>::bag(const initializer_list<X> &V) : bag() {
	auto it1 = V.begin();
	while (it1 != V.end()) {
		push_back(*it1);
		num_items++;
		it1++;
	}
}

template <class X> bag<X>::~bag() {//destructor
	item<X> * p1 = head, *p2;
	while (p1 != nullptr) {
		p2 = p1->next;
		delete p1;
		p1 = p2;
	}
}

template <class X> bag<X>::bag(const bag<X> & B) : bag() { //copy constructor
	if (B.num_items == 0) return;
	item<X> * p1 = B.head;
	while (p1 != nullptr) {
		push_back(p1->data);
		p1 = p1->next;
		num_items++;
	}
}

template <class X> void bag<X>::operator=(const bag<X> & B) {//operator= ; left value ref
	item<X> * p1 = head, *p2;
	while (p1 != nullptr) {
		p2 = p1->next;
		delete p1;
		p1 = p2;
	}
	num_items = 0;
	head = tail = nullptr;
	if (B.num_items == 0) return;
	p1 = B.head;
	while (p1 != nullptr) {
		push_back(p1->data);
		p1 = p1->next;
		num_items++;
	}
}

template <class X> void bag<X>::erase(int index) {
	if (index < 0 || index >= num_items) return;
	item<X> * p = head;
	while (index > 0) {
		p = p->next;
		index--;
	}
	if (p->next != nullptr) { p->next->previous = p->previous; }
	if (p->previous != nullptr) { p->previous->next = p->next; }
	if (head == p) { head = p->next; }
	if (tail == p) { tail = p->previous; }
	delete p;
	num_items--;
}

template <class X> void bag<X>::erase(item<X> * p) {
	if (p == nullptr) return;
	if (p->next != nullptr) { p->next->previous = p->previous; }
	if (p->previous != nullptr) { p->previous->next = p->next; }
	if (head == p) { head = p->next; }
	if (tail == p) { tail = p->previous; }
	delete p;
	num_items--;

}
template <class X> item<X> * bag<X>::find(X d) {
	item<X> * p1 = head;
	while (p1 != nullptr) {
		if (p1->data == d) { return p1; }
		p1 = p1->next;
	}
	return nullptr;
}

template<class X> void bag<X>::push_front(X d) {
	item<X> *p;
	p = new item<X>(d);
	if (num_items == 0) { head = tail = p; }
	else {
		head->previous = p;
		p->next = head;
		head = p;
	}
	num_items++;
}

template<class X> void bag<X>::push_back(X d) {
	item<X> *p = new item <X>(d);
	if (num_items == 0) { head = tail = p; }
	else {
		p->previous = tail;
		tail->next = p;
		tail = p;
	}
	num_items++;
}

template<class X> void bag<X>::pop_back() {
	item<X> *p;
	if (num_items == 0) return;
	else {
		p = tail->previous;
		delete tail;
		tail = p;
		num_items--;
		if (num_items == 0) head = nullptr;
		else tail->next = nullptr;
	}
}
template<class X> void bag<X>::pop_front() {
	item<X> *p;
	if (num_items == 0) return;
	else {
		p = head->next;
		delete head;
		head = p;
		num_items--;
		if (num_items == 0) tail = nullptr;
		else head->previous = nullptr;
	}
}

template<class X> X& bag<X>::operator[](int i) {
	//if (i>num_items - 1 || i<0) {cout << "Error! Index is out of range!\n"; return;}
	
	
	item<X> *p = head;
	while (i > 0) {
		p = p->next;
		i--;
	}
	return p->data;
}

template<class X> void bag<X>::clear() {
	item<X> *p1 = head, *p2;
	while (p1 != nullptr) {
		p2 = p1->next;
		delete p1;
		p1 = p2;
	}
	head = tail = nullptr;
	num_items = 0;
}


template <class T> ostream & operator<<(ostream &s, const ThreeD<T> &t) {//ostream & operator<<(ostream &s, ThreeD t) will also work.
	s << "( " << t.ht << ", " << t.wid << ", " << t.dep << " )";
	return s;
}


template <class T> ostream & operator<<(ostream &s, const item<T> &I) {
	s << I.data;
	return s;
}

template <class T> ostream & operator<<(ostream &s, const linked_list<T> &L) {
	node<T> * p = L.first;
	while (p != nullptr) {
		s << p->value << " ";
		p = p->next;
	}
	return s;
}
template <class T> ostream & operator<<(ostream &s, const bag<T> &B) {
	item<T> * p = B.head;
	while (p != nullptr) {
		s << p->data << " ";
		p = p->next;
	}
	return s;
}
template <class T> ostream & operator<< (ostream &s, const vector<T> & V) {
	s << "[";
	for (size_t i = 0; i < V.size() - 1; i++) {
		s << V[i] << ", ";
	}
	s << V[V.size() - 1] << "]";
	return s;
}


int main() {

	bag<double> bag_d;
	bag_d.push_back(5.5);
	bag_d.push_back(6.6);
	bag_d.push_front(4.4);
	bag_d.push_front(3.3);
	bag_d.pop_front();
	bag_d.pop_back();
	cout << bag_d << endl;;
	bag<int> bag_i;
	bag_i.push_back(5);
	bag_i.push_back(6);
	bag_i.push_front(4);
	bag_i.push_front(3);
	bag_i.pop_front();
	bag_i.pop_back();
	cout << bag_i << endl;

	ThreeD<int> td3(3), td4(4), td5(5), td6(6), td7(100, 200, 300);
	bag<ThreeD<int>> bag_3D;
	bag_3D.push_back(td5);
	bag_3D.push_back(td6);
	bag_3D.push_front(td4);
	bag_3D.push_front(td3);
	bag_3D.pop_front();
	bag_3D.pop_back();
	cout << bag_3D << endl;;
	cout << bag_3D.front() << bag_3D.back();
	cout << bag_3D[0] << " " << bag_3D[1] << endl;
	bag_3D[1] = td7;
	cout << bag_3D[0] << " " << bag_3D[1] << endl;
	bag_3D.clear();
	cout << bag_3D << endl;
	cout << bag_3D.size() << endl;
	linked_list<string>ls_1;
	ls_1.push_front("David");
	ls_1.push_front("John");
	ls_1.push_front("Pat");
	ls_1.push_front("Ben");
	ls_1.push_front("Jeff");
	cout << ls_1 << endl;

	linked_list<string>ls_2;
	ls_2.push_front("Wendy");
	ls_2.push_front("Mary");
	ls_2.push_front("Nancy");
	ls_2.push_front("Jennifer");
	cout << ls_2 << endl;

	bag<linked_list<string>> bag_string;

	bag_string.push_back(ls_1);

	bag_string.push_back(ls_2);

	cout << bag_string << endl;
	cout << bag_string[1] << endl;

	ThreeD<double> t10(3.2, 7.4, 8.9), t11(5.6, 7.7, 2.987), t12(4.6, 7.5, 3.1416), t13(55.6, 66.8, 333.45);
	linked_list<ThreeD<double>> LTD1;
	LTD1.push_front(t10);

	LTD1.push_front(t11);
	linked_list<ThreeD<double>> LTD2;
	LTD2.push_front(t13);
	LTD2.push_front(t12);
	LTD2.push_front(t10);
	LTD2.push_front(t11);

	bag<linked_list<ThreeD<double> > > BLTD;
	BLTD.push_back(LTD1);
	BLTD.push_back(LTD2);
	cout << BLTD << endl;

	item<linked_list<ThreeD<double>>> * p2;

	p2 = BLTD.find(LTD1);
	BLTD.erase(p2);
	cout << BLTD << endl;
	BLTD.push_back(LTD1);
	cout << BLTD << endl;
	BLTD.erase(0);
	cout << BLTD << endl;

	vector<ThreeD<int>> V1 = { { 1,2,3 },{ 4,5,6 },{ 7,8,9 } };
	cout << V1 << endl;
	//bag<bag<int>> V2 = { {1,2,3}, {4,5,6}, {7,8,9} };
	vector<bag<ThreeD<int>>> V2 = { { { 1,2,3 },{ 4,5,6 },{ 7,8,9 } },{ { 20,30,40 },{ 11,22, 33 } } };
	cout << V2 << endl;

	vector<bag<linked_list<int>>> V3 = { { { 1, 2, 3 },{ 4, 5 } },{ { 6,7 },{ 8, 9, 10 } } };
	cout << V3 << endl;

	bag<int> B10 = { 1,2,3,4,5 };
	bag<int> B11 = B10, B12;
	B12 = B10;
	cout << B10 << endl;
	B10.head->data = 1000;
	cout << B10 << endl;
	cout << B11 << endl;
	cout << B12 << endl;

	bag<vector<linked_list<ThreeD<int>>>> B13 = { { { { 1,2,3 },{ 4,5,6 } },{ { 7,8,9 },{ 10,11,12 },{ 13,14,15 } } },{ { { 16,17,18 },{ 19,20,21 },{ 22,23,24 } },{ { 25,26,27 },{ 28,29,30 } },{ { 31,32,33 },{ 34,35,36 },{ 37,38,39 },{ 40,41,42 } } } };
	cout << B13 << endl;

	bag<bag<bag<ThreeD<int>>>> B14 = { { { { 1,2,3 },{ 4,5,6 } },{ { 7,8,9 },{ 10,11,12 },{ 13,14,15 } } },{ { { 16,17,18 },{ 19,20,21 },{ 22,23,24 } },{ { 25,26,27 },{ 28,29,30 } },{ { 31,32,33 },{ 34,35,36 },{ 37,38,39 },{ 40,41,42 } } } };
	cout << B14 << endl;

	bag<linked_list<int>> * p10 = new bag<linked_list<int>>({ { 1,2,3,4 },{ 5,6,7 } });
	cout << *p10 << endl;
	delete p10;

	bag<vector<linked_list<ThreeD<int>>>> B15 = { { { { 1,2,3 },{ 4,5,6 } },{ { 7,8,9 },{ 10,11,12 },{ 13,14,15 } } },{ { { 16,17,18 },{ 19,20,21 },{ 22,23,24 } },{ { 25,26,27 },{ 28,29,30 } },{ { 31,32,33 },{ 34,35,36 },{ 37,38,39 },{ 40,41,42 } } } };
	cout << B15 << endl;
	B15.erase(1);
	cout << B15 << endl;

	
	bag<vector<linked_list<ThreeD<int>>>> B16 = { { { { 1,2,3 },{ 4,5,6 } },{ { 7,8,9 },{ 10,11,12 },{ 13,14,15 } } },{ { { 16,17,18 },{ 19,20,21 },{ 22,23,24 } },{ { 25,26,27 },{ 28,29,30 } },{ { 31,32,33 },{ 34,35,36 },{ 37,38,39 },{ 40,41,42 } } } };
	vector<linked_list<ThreeD<int>>> V4 = { { { 6,1,1 },{ 2,5,12 } },{ { 9,8,7 },{ 11,10,12 },{ 26,7,15 } } };
	vector<linked_list<ThreeD<int>>> V5 = { { { 6,1,1 },{ 2,5,12 } },{ { 9,8,7 },{ 11,10,12 },{ 26,7,5 } },{ { 6,1,1 },{ 2,5,12 } } };
	B16.insert(B16.head, V5);
	cout << B16.front().size() << endl;
	
	item<vector<linked_list<ThreeD<int>>> > * p20=  B16.find(V4);
	if (p20 != nullptr) cout << (p20->data).size() << endl;
	

	getchar();
	getchar();
	return 0;

}