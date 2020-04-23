//HW4: Due Monday (10/15) at 11:59PM
//Implement functions of class linked_list and class bag
//All member functions listed in the two class needs implementation
//note that some are already done

//Need to implement the overloaded operator<< for all classes, including vector
//See the sample output for formats when implementing operator<< for all classes
#include <iostream>
#include <stdlib.h>
#include <string>
#include <vector>
using namespace std;

template<class T> class ThreeD {
public:
	T ht;
	T wid;
	T dep;
	ThreeD() {
		ht = wid = dep = 0;
	}
	ThreeD(T i) {
		ht = wid = dep = i;
	}
	ThreeD(const initializer_list<T> &V){
		auto it = V.begin();
		ht = *it;it++;
		wid = *it;it++;
		dep = *it;it++;
	}

	ThreeD(const ThreeD<T> &L){
		ht = L.ht;
		wid = L.wid;
		dep = L.dep;
	}

	void operator=(const ThreeD<T> &L){
		ht = L.ht;
		wid = L.wid;
		dep = L.dep;
	}

	ThreeD(T a, T b, T c) {
		ht = a;
		wid = b;
		dep = c;
	}
	bool operator==(ThreeD<T> &t) {
		return (ht == t.ht && wid = t.wid && dep == t.dep);
	}
	bool operator!=(ThreeD<T> &t) {
		return (ht != t.ht || wid != t.wid || dep != t.dep);
	}

	template<class X> friend ostream & operator<<(ostream &s,
			const ThreeD<X> &t);

	template<class X> friend ostream & operator<<(ostream &s,
			const vector<ThreeD<X>> V);


};

template<class T> ostream & operator<<(ostream &s, const ThreeD<T> &t) {
	// ( 5.6, 7.7, 2.987 )
	s << "( " << t.ht << ", " << t.wid << ", " << t.dep << " )";
	return s;
}

template<class X> ostream & operator<<(ostream &s,vector<ThreeD<X>> V){
	for(size_t i=0;i<V.size();i++){
		cout << V[i];
	}
	return s;
}

template<class T> class node {
public:
	T value;
	node<T> * next;
	node<T> * previous;
	node<T>() {
		next = nullptr;
		previous = nullptr;
	}
	node<T>(T v) {
		value = v;
		next = nullptr;
		previous = nullptr;
	}
};

template<class T> class linked_list {
public:
	int num_nodes;
	node<T> * head; //10/15
	node<T> * tail;
	linked_list() {
		num_nodes = 0;
		head = tail = nullptr;
	}
	linked_list(const initializer_list<T> &V);
	void push_front(T t);
	void push_back(T t);
	bool operator==(linked_list<T> &L);

	linked_list(const linked_list<T> &L);
	~linked_list();
	void operator=(const linked_list<T> &L);

	template<class X>
	friend ostream & operator<<(ostream &s, const linked_list<X> &L);

	template<class X>
	friend ostream & operator<<(ostream &s, vector<linked_list<ThreeD<X>>> &L);
};

template <class X> ostream & operator<<(ostream &s, vector<linked_list<ThreeD<X>>> &V){
	s << "[";
	for(size_t i=0;i<V.size();i++){
		s << V[i];

		if(i < V.size()-1){
			s << ", ";
		}
	}
	s << "]";
	return s;
}

template<class T>
ostream & operator<<(ostream &s, const linked_list<T> &L) {
	node<T> *it = L.head;
	while (it != nullptr) {
		s << it->value;
		it = it->next;

		if(it != nullptr){
			s << " ";
		}
	}

	return s;
}

template<class T> void linked_list<T>::push_front(T t) {
	node<T> * p = new node<T>(t);
	if (head == nullptr) {
		head = tail = p;
		num_nodes++;
	} else {
		p->next = head;
		head->previous = p;
		head = p;
		num_nodes++;
	}
}

template<class T>linked_list<T>::linked_list(const initializer_list<T>& V) {
	head = tail = nullptr;
	num_nodes = 0;

	auto it = V.begin();
	while (it != V.end()) {
		push_back(*it);
		it++;
	}
}

template<class T> void linked_list<T>::push_back(T t) {

	node<T> * p = new node<T>(t);
	if (head == nullptr) {
		head = tail = p;
		num_nodes++;
	}

	else {
		p->previous = tail;
		tail->next = p;
		tail = p;
		num_nodes++;
	}

}

template<class X>class item {
public:
	X value;
	item<X> *next;
	item<X> *previous;
	item<X>(X v) {
		value = v;
		next = nullptr;
		previous = nullptr;
	}
	bool operator==(item<X> I) {
		return value == I.value;
	}

	template<class T>
	friend ostream & operator<<(ostream &s, const item<T> &I);
};

template<class X> ostream & operator<<(ostream &s, const item<X> &I) {
	s << I.value;
	return s;
}

template<class X>class bag {
public:
	item<X> *last;
	item<X> *first;
	int num_items;
	int size() {
		return num_items;
	}
	//void show_bag();//Print all items in the bag
	bag() {
		last = nullptr;
		first = nullptr;
		num_items = 0;
	} //default constructor for bag class
	bag(const initializer_list<X> &V);
	~bag(); //destructor
	bag(const bag<X> & B); //copy constructor
	void operator=(const bag & B); //operator= ; left value reference
	void push_back(X v);  //insert an item with value v to the back of the bag
	void push_front(X v); //insert an item with value v to the front of the bag
	void pop_back(); //delete the last item in the bag
	void pop_front(); //delete the first item in the bag
	X &operator[](int i); //Access bag item with index.
	X front() {  //it returns the value of the first item in the bag.
				 //if (num_items == 0) cout << "Error! The bag is empty!\n";
				 //else
		return first->value;
	}
	X back() { //it returns the value of the last item in the bag
		/*
		 if (num_items == 0)
		 {
		 cout << "Error! The bag is empty!\n";

		 }
		 else
		 */

		return last->value;
	}
	void clear(); //Delete all items in the bag
	item<X> * find(X I);
	void erase(int index);
	void erase(item<X> * p);

	template<class T>
	friend ostream & operator<<(ostream &s, const bag<T> &B);

	template<class T>
	friend ostream & operator<<(ostream &s, vector<bag<ThreeD<T>>> &V);

	template<class T>
	friend ostream & operator<<(ostream &s, vector<bag<linked_list<T>>> &V);

	template<class T>
	friend ostream & operator<<(ostream &s, bag<ThreeD<T>> &B);

	template<class T>
	friend ostream & operator<<(ostream &s, bag<linked_list<T>> &B);

	template<class T>
	friend ostream & operator<<(ostream &s, bag<vector<linked_list<ThreeD<T>>> > &B);
};

template<class X> ostream & operator<<(ostream &s, bag<vector<linked_list<ThreeD<X>>> > &B){
	for(int i=0;i<B.size();i++){
		s << B[i];

		if(i < B.size()-1){
			s << " ";
		}
	}
	return s;
}

template<class X> ostream & operator<<(ostream &s, const bag<X> &B) {
	item<X> *it = B.first;
	while (it != nullptr) {
		s << it->value;
		it = it->next;
		if(it != nullptr){
			s << " ";
		}
	}

	return s;
}

template<class X>ostream & operator<<(ostream &s, vector<bag<ThreeD<X>>> &V){
	s << "[";
	for(size_t i=0;i<V.size();i++){
		s << V[i];

		if(i < V.size()-1){
			s << ", ";
		}
	}
	s << "]";
	return s;
}

template<class X> ostream & operator<<(ostream &s, bag<ThreeD<X>> &B){
	for(int i=0;i<B.size();i++){
		s << B[i];

		if(i<B.size()-1){
			s << " ";
		}
	}

	return s;
}

template<class X> ostream & operator<<(ostream &s, bag<linked_list<X>> &B){
	for(int i=0;i<B.size();i++){
		s << B[i];

		if(i < B.size()-1){
			s << "  ";
		}
	}

	return s;
}

template<class T> ostream & operator<<(ostream &s, vector<bag<linked_list<T>>> &V){
	s << "[";
	for(size_t i=0;i<V.size();i++){
		s << V[i];

		if(i < V.size()-1){
			s << ", ";
		}
	}
	s << "]";
	return s;
}

template<class X> void bag<X>::push_front(X v) {
	item<X> *p;
	p = new item<X>(v);
	if (num_items == 0) {
		first = last = p;
	} else {
		first->previous = p;
		p->next = first;
		first = p;
	}
	num_items++;
}

template<class X> void bag<X>::push_back(X v) {
	item<X> *p = new item<X>(v);
	if (num_items == 0) {
		first = last = p;
	} else {
		p->previous = last;
		last->next = p;
		last = p;
	}
	num_items++;
}

template<class X> void bag<X>::pop_back() {
	item<X> *p;
	if (num_items == 0)
		cout << "Error! The bag is empty!\n";
	else {
		p = last->previous;
		delete last;
		last = p;
		num_items--;
		if (num_items == 0)
			first = nullptr;
		else
			last->next = nullptr;
	}
}

template<class X>bag<X>::bag(const initializer_list<X>& V) {
	num_items = 0;

	auto it = V.begin();
	while (it != V.end()) {
		X x = *it;

		item<X> *p = new item<X>(x);

		if (num_items == 0) {
			first = last = p;
		} else {
			p->previous = last;
			last->next = p;
			last = p;
		}
		num_items++;

		it++;
	}
}

template<class X>bag<X>::~bag() {
	item<X> *it = first;
	while (it != nullptr) {
		item<X> *temp = it;
		it = it->next;
		delete temp;
	}
	num_items = 0;
	first = last = nullptr;
}

template<class X>
bag<X>::bag(const bag<X>& B) {
	num_items = 0;

	item<X> *it = B.first;
	while(it != nullptr){
		push_back(it->value);
		it = it->next;
	}
}

template<class X>
void bag<X>::operator =(const bag& B) {
	item<X> *it = first;
	while (it != nullptr) {
		item<X> *temp = it;
		it = it->next;
		delete temp;
	}
	num_items = 0;
	first = last = nullptr;

	it = B.first;
	while(it != nullptr){
		push_back(it->value);
		it = it->next;
	}
}

template<class X> void bag<X>::pop_front() {
	item<X> *p;
	if (num_items == 0) {
		return;
	} else {
		p = first->next;
		delete first;
		first = p;
		num_items--;
		if (num_items == 0)
			last = nullptr;
		else
			first->previous = nullptr;
	}
}


template<class T>
bool linked_list<T>::operator ==(linked_list<T>& L) {
	node<T> *it1 = head;
	node<T> *it2 = L.head;
	if (num_nodes == L.num_nodes) {
		while (it1 != nullptr) {
			if (it1->value != it2->value) {
				return false;
			}

			it1 = it1->next;
			it2 = it2->next;
		}
		return true;
	}
	return false;
}

template<class T>
linked_list<T>::linked_list(const linked_list<T>& L) {
	num_nodes = 0;
	head = tail = nullptr;

	if (L.num_nodes == 0) {
		head = tail = nullptr;
	} else {
		node<T> *it = L.head;
		while (it != nullptr) {
			node<T> *n = new node<T>(it->value);
			if (head == nullptr) {
				head = tail = n;
			} else {
				n->previous = tail;
				tail->next = n;
				tail = n;
			}

			num_nodes++;
			it = it->next;
		}
	}
}

template<class T>
linked_list<T>::~linked_list() {
	node<T> *it = head;
	while (it != nullptr) {
		node<T> *temp = it;
		it = it->next;
		delete temp;
	}
	num_nodes = 0;
	head = tail = nullptr;
}

template<class T>
void linked_list<T>::operator =(const linked_list<T>& L) {
	node<T> *it = head;
	while (it != nullptr) {
		node<T> *temp = it;
		it = it->next;
		delete temp;
	}
	num_nodes = 0;
	head = tail = nullptr;

	num_nodes = 0;
	if (L.num_nodes == 0) {
		head = tail = nullptr;
	} else {
		node<T> *it = L.head;
		while (it != nullptr) {
			node<T> *n = new node<T>(it->value);
			if (head == nullptr) {
				head = tail = n;
			} else {
				n->previous = tail;
				tail->next = n;
				tail = n;
			}

			num_nodes++;
			it = it->next;
		}
	}
}

template<class X>
X& bag<X>::operator [](int index) {
	item<X> *it = first;
	for (int i = 0; i < index; i++) {
		it = it->next;
	}
	return it->value;
}

template<class X>
void bag<X>::clear() {
	item<X> *it = first;
	while (it != nullptr) {
		item<X> *temp = it;
		it = it->next;
		delete temp;
	}

	first = last = nullptr;
	num_items = 0;
}

template<class X>
item<X>* bag<X>::find(X I) {
	item<X> *it = first;
	while (it != nullptr) {
		if (it->value == I) {
			return it;
		}
		it = it->next;
	}
	return nullptr;
}

template<class X>
void bag<X>::erase(int index) {
	if (index == 0) {
		item<X> *temp = first;
		first = first->next;
		first->previous = nullptr;
		delete temp;
		num_items--;
	} else if (index == num_items - 1) {
		item<X> *temp = last;
		last = last->previous;
		last->next = nullptr;
		delete temp;
		num_items--;
	} else {
		item<X> *pre = first;
		item<X> *it = first->next;
		for (int i = 1; i < index; i++) {
			pre = it;
			it = it->next;
		}

		item<X> *temp = it;
		pre->next = it->next;
		if (it->next != nullptr) {
			it->next->previous = pre;
		}
		delete temp;
		num_items--;
	}
}

template<class X>
void bag<X>::erase(item<X>* p) {
	if (p == first) {
		item<X> *temp = first;
		first = first->next;
		delete temp;
		num_items--;
	} else if (p == last) {
		item<X> *temp = last;
		last = last->previous;
		delete temp;
		num_items--;
	} else {
		item<X> *pre = first;
		item<X> *it = first->next;
		while (it < p) {
			pre = it;
			it = it->next;
		}

		item<X> *temp = it;
		pre->next = it->next;
		if (it->next != nullptr) {
			it->next->previous = pre;
		}
		delete temp;
		num_items--;
	}
}
//The following is a screenshot of a sample output



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
	cout << bag_3D << endl;;
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
	B10.first->value = 1000;
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

	//getchar();
	//getchar();
	return 0;

}


/*
 4.4 5.5
 4 5
 ( 4, 4, 4 ) ( 5, 5, 5 )
 ( 4, 4, 4 )( 5, 5, 5 )( 4, 4, 4 ) ( 5, 5, 5 )
 ( 4, 4, 4 ) ( 100, 200, 300 )

 0
 Jeff Ben Pat John David
 Jennifer Nancy Mary Wendy
 Jeff Ben Pat John David  Jennifer Nancy Mary Wendy
 Jennifer Nancy Mary Wendy
 ( 5.6, 7.7, 2.987 ) ( 3.2, 7.4, 8.9 )  ( 5.6, 7.7, 2.987 ) ( 3.2, 7.4, 8.9 ) ( 4.6, 7.5, 3.1416 ) ( 55.6, 66.8, 333.45 )
 ( 5.6, 7.7, 2.987 ) ( 3.2, 7.4, 8.9 ) ( 4.6, 7.5, 3.1416 ) ( 55.6, 66.8, 333.45 )
 ( 5.6, 7.7, 2.987 ) ( 3.2, 7.4, 8.9 ) ( 4.6, 7.5, 3.1416 ) ( 55.6, 66.8, 333.45 )  ( 5.6, 7.7, 2.987 ) ( 3.2, 7.4, 8.9 )
 ( 5.6, 7.7, 2.987 ) ( 3.2, 7.4, 8.9 )
 [( 1, 2, 3 ), ( 4, 5, 6 ), ( 7, 8, 9 )]
 [( 1, 2, 3 ) ( 4, 5, 6 ) ( 7, 8, 9 ) , ( 20, 30, 40 ) ( 11, 22, 33 ) ]
 [1 2 3  4 5  , 6 7  8 9 10  ]
 1 2 3 4 5
 1000 2 3 4 5
 1 2 3 4 5
 1 2 3 4 5
 [( 1, 2, 3 ) ( 4, 5, 6 ) , ( 7, 8, 9 ) ( 10, 11, 12 ) ( 13, 14, 15 ) ] [( 16, 17, 18 ) ( 19, 20, 21 ) ( 22, 23, 24 ) , ( 25, 26, 27 ) ( 28, 29, 30 ) , ( 31, 32, 33 ) ( 34, 35, 36 ) ( 37, 38, 39 ) ( 40, 41, 42 ) ]
 ( 1, 2, 3 ) ( 4, 5, 6 )  ( 7, 8, 9 ) ( 10, 11, 12 ) ( 13, 14, 15 )   ( 16, 17, 18 ) ( 19, 20, 21 ) ( 22, 23, 24 )  ( 25, 26, 27 ) ( 28, 29, 30 )  ( 31, 32, 33 ) ( 34, 35, 36 ) ( 37, 38, 39 ) ( 40, 41, 42 )
 1 2 3 4  5 6 7
 [( 1, 2, 3 ) ( 4, 5, 6 ) , ( 7, 8, 9 ) ( 10, 11, 12 ) ( 13, 14, 15 ) ] [( 16, 17, 18 ) ( 19, 20, 21 ) ( 22, 23, 24 ) , ( 25, 26, 27 ) ( 28, 29, 30 ) , ( 31, 32, 33 ) ( 34, 35, 36 ) ( 37, 38, 39 ) ( 40, 41, 42 ) ]
 [( 1, 2, 3 ) ( 4, 5, 6 ) , ( 7, 8, 9 ) ( 10, 11, 12 ) ( 13, 14, 15 ) ]


 */
