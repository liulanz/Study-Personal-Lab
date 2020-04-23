//HW5 Due: April 7 (Sunday) at 11:59PM
#include <iostream>
#include <memory>

using namespace std;

class node {
public:
	shared_ptr<node> east;
	shared_ptr<node> south;
	int value;
	node() {}
	node(int i) { value = i; }
};

class ring {
public:
	//Implement all functions described below
	//funciton operator[] can be invoked by other functions


	shared_ptr<node> head;
	int num_rows;
	int num_cols;
	ring() {}
	ring(int i, int j);//constructor
					   //i rows and j cols
					   //values from 0 to i*j-1
					   //See the photo for ring structures.

	~ring();//destructor; do as little work as possible
	ring(const ring &r); //copy constructor
	ring(ring &&r); //move constructor
	void operator=(ring &&r);//R-value operator=
	void operator=(const ring &r); //L-value operator=
	ring(const initializer_list<int> &V);//see the explanation in main function
	int & operator[](int a);
	int & operator[](pair<int, int> p); //first is row number and second is col number

	void DelCol(int i);//delete col i of *this
	ring Threetimes();
	//return a ring with the same dimenstion as *this, and the value of every node is three times of that of *this.

	friend ostream & operator<<(ostream & str, const ring &R);

};


ring::ring(int i, int j) {//constructor
	num_rows = i;
	num_cols = j;
	shared_ptr<node> p1, p2, p3;
	for (int k = 0; k < i*j; k++) {
		p1 = make_shared<node>(i*j-1 -k);
		if (k == 0) p2 = p1;
		p1->east = head;
		head = p1;
	}
	p2->east = head;

	p1 = p2 = head;
	p3 = p1->east;
	for (int k = 0; k < j; k++) p2 = p2->east;
	for (int i1 = 0; i1 < i; i1++) {
		for (int j1 = 0; j1 < j; j1++) {
			if (i1 < i - 1) {
				p1->south = p2;
				p1 = p1->east;
				p2 = p2->east;
			}
			else {
				if (j1 < j - 1) {
					p1->south = p3;
					p1 = p1->east;
					p3 = p3->east;
				}
				else { p1->south = head; }
			}
		}
	}
	
}

ring::~ring() { //destructor
	if (head) {
	int i = num_rows, j = num_cols;
	shared_ptr<node> p = head;
	for (int i = 0; i < num_rows - 1; i++) p = p->south;
	for (int i = 0; i < num_cols - 1; i++) {
		p->south.reset();
		p = p->east;
	}
	p->south.reset();
	p->east.reset();
	}
	head.reset();//this statement is optional
}

ring::ring(const ring &r): ring(r.num_rows, r.num_cols) { //copy constructor
	shared_ptr<node> p1 = head, p2 = r.head;
	for (int i = 0; i < num_rows *num_cols; i++) {
		p1->value = p2->value;
		p1 = p1->east;
		p2 = p2->east;
	}
}

ring::ring(ring &&r) { //move constructor
	num_rows = r.num_rows;
	num_cols = r.num_cols;
	head = r.head;
	r.head.reset();
}


//initializer_list
ring::ring(const initializer_list<int> &V): ring(*V.begin(), *(V.begin() +1)) {
	auto it = V.begin() + 2;
	shared_ptr<node> p = head;
	for (int i = 0; i < num_rows*num_cols; i++) {
		p->value = *it;
		p = p->east;
		it++;
	}
}

//L-value operator=
void ring::operator=(const ring &r) {
	if (head) {
		int i = num_rows, j = num_cols;
		shared_ptr<node> p = head;
		for (int i = 0; i < num_rows - 1; i++) p = p->south;
		for (int i = 0; i < num_cols - 1; i++) {
			p->south.reset();
			p = p->east;
		}
		p->south.reset();
		p->east.reset();
		head.reset();
	}
	ring r1(r);
	head = r1.head;
	num_rows = r.num_rows;
	num_cols = r.num_cols;
	r1.head.reset();
}

//R-value operator=
void ring::operator=(ring &&r) {
	if (head) {
		int i = num_rows, j = num_cols;
		shared_ptr<node> p = head;
		for (int i = 0; i < num_rows - 1; i++) p = p->south;
		for (int i = 0; i < num_cols - 1; i++) {
			p->south.reset();
			p = p->east;
		}
		p->south.reset();
		p->east.reset();
		head.reset();
	}
	num_rows = r.num_rows;
	num_cols = r.num_cols;
	head = r.head;
	r.head.reset();
}

ring ring::Threetimes() {
	ring r1(*this);
	shared_ptr<node> p1 = r1.head, p2 = head;
	for (int i = 0; i < num_rows * num_cols; i++)  {
		p1->value = 3*p2->value;
		p1 = p1->east;
		p2 = p2->east;
	}
	return move(r1);//or return r1;
}
void ring::DelCol(int i) {
	int col;
	if (i == 0) col = num_cols;
	else col = i;
	shared_ptr<node> p1 = head;
	for (int i1 = 0; i1 < col - 1; i1++) {
		p1 = p1->east;
	}
	
	for (int j = 0; j < num_rows; j++) {
		p1->east = p1->east->east;
		if (j != num_rows -1) p1 = p1->south;
	}
	if (i != num_cols -1) p1->south = p1->south->east;
	else p1->south = head;
	num_cols--;
	if (i == 0) head = head->east;
}

int & ring::operator[](int a) {
	shared_ptr<node> p = head;
	for (int i = 0; i < a; i++) p = p->east;
	return p->value;

}
int & ring::operator[](pair<int, int> p) {
	int i = p.first, j = p.second;
	shared_ptr<node> p1 = head;
	for (int i1 = 0; i1 < i; i1++) p1 = p1->south;
	for (int j1 = 0; j1 < j; j1++) p1 = p1->east;
	return p1->value;
}


//overload operator<<

ostream & operator<<(ostream & str, const ring &R) {
	shared_ptr<node> p = R.head;
	for (int i = 0; i < R.num_rows; i++) {
		for (int j = 0; j < R.num_cols; j++) {
			str << p->value << " ";
			p = p->east;
		}
		str << endl;
	}
	return str;
}




int main() {
	
	ring R1(4, 6);//24 numbers from 0 to 23 will be initialized to nodes.
	cout << R1 << endl;
	R1[14] = 1000;
	R1[{2, 4}] = 2000;
	cout << R1[14] << " " << R1[{2, 4}] << endl;
	R1.DelCol(3);
	cout << R1 << endl;
	R1.DelCol(4);
	cout << R1 << endl;
	R1.DelCol(0);
	cout << R1 << endl;
	shared_ptr<ring> p1 = make_shared<ring>(3, 5);
	cout << *p1 << endl;
	p1.reset();
	ring R2 = { 3, 5, 10,20,30,40,50, 100, 200, 300, 400, 500, 1000, 2000, 3000, 4000, 5000 };//
																							  //first two numbers are num_rows and num_cols; followed by values of nodes of ring
	cout << R2 << endl;
	ring R3(R2);
	cout << R3 << endl;
	ring R4;
	R4 = R3;
	cout << R4 << endl;
	ring R5;
	R5 = R4.Threetimes();
	cout << R5 << endl;

	getchar();
	getchar();
	return 0;
}