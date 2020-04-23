 //HW1  Polynomial Operations using linked lists

//Due 11:59 pm, 1/31 (Wednesday)
//
//A polynomial is implemented using a linked list.  Only non-zero coefficients are included in linked list.
//Implment member functions operator+ , operator* , and add term
//
//You have to use the main function and print_linked_list provided to you.

#include <iostream>

using namespace std;

class term {
public:
	int power;
	int coef;
	term * next;
	term() { next = nullptr; }
	term(int c, int p) { power = p; coef = c; next = nullptr; }
};

class polynomial {
public:
	int num_terms;
	term * head;
	polynomial() { num_terms = 0; head = nullptr; }
	polynomial(const polynomial &P);
	~polynomial();
	polynomial(polynomial &&P);
	void operator= (polynomial &P);
	void operator= (polynomial &&P);



	void add_term(int p, int c);
	polynomial operator+(polynomial &P);
	polynomial operator*(polynomial &P);
	void print_polynomial();
};

void polynomial::operator= (polynomial &&P) {
	num_terms = P.num_terms;
	while (head != nullptr) {
		term * p = head->next;
		delete head;
		head = p;
	}
	head = P.head;
	P.head = nullptr;
}

void polynomial::operator= (polynomial &P) {
	num_terms = P.num_terms;
	while (head != nullptr) {
		term * p = head->next;
		delete head;
		head = p;
	}
	term * p1 = P.head;
	while (p1 != nullptr) {
		term * p2 = new term;
		p2->next = head;
		head = p2;
		p1 = p1->next;
	}
	p1 = P.head;
	term * p2 = head;
	while (p1 != nullptr) {
		p2->coef = p1->coef;
		p2->power = p1->power;
		p1 = p1->next;
		p2 = p2->next;
	}
}
polynomial::polynomial(polynomial &&P) {
	num_terms = P.num_terms;
	head = P.head;
	P.head = nullptr;
}
polynomial::polynomial(const polynomial &P) {
	num_terms = P.num_terms;
	term * p1 = P.head;
	while (p1 != nullptr) {
		term * p2 = new term;
		p2->next = head;
		head = p2;
		p1 = p1->next;
	}
	p1 = P.head;
	term * p2 = head;
	while (p1 != nullptr) {
		p2->coef = p1->coef;
		p2->power = p1->power;
		p1 = p1->next;
		p2 = p2->next;
	}
}

polynomial::~polynomial() {
	while (head != nullptr) {
		term * p = head->next;
		delete head;
		head = p;
	}
}

void polynomial::print_polynomial() {
	cout << endl;
	term * p = head;
	while (p != nullptr) {
		cout << p->coef << " " << p->power << "   ";
		p = p->next;
	}
}
void polynomial::add_term(int c, int p) {

	term * p1 = new term(c, p);

	if (num_terms == 0) {
		head = p1; num_terms++;

		return;
	}
	if (p > head->power) {

		p1->next = head;
		head = p1;
		num_terms++;
		return;
	}
	term * p2 = head, *p3 = p2->next;

	while (p3 != nullptr && p < p3->power) {
		p2 = p3; p3 = p3->next;
	}

	if (p3 == nullptr) { p2->next = p1; num_terms++; return; }
	//if (p == p3->power) { p3->coef += c; return; }
	if (p == p3->power) {
		if (c + p3->coef == 0) {
			p2->next = p3->next;
			delete p3;
			delete p1;
			return;
		}
		p3->coef += c;
		delete p1;
		return;
	}
	p2->next = p1;
	p1->next = p3;
	return;
}


polynomial polynomial::operator+(polynomial &P) {
	polynomial temp_p;
	term * p1 = head, *p2 = P.head;
	while (p1 != nullptr || p2 != nullptr) {
		if (p1 == nullptr) { temp_p.add_term(p2->coef, p2->power); p2 = p2->next; }
		else if (p2 == nullptr) { temp_p.add_term(p1->coef, p1->power); p1 = p1->next; }
		else if (p1->power < p2->power) { temp_p.add_term(p2->coef, p2->power); p2 = p2->next; }
		else if (p1->power > p2->power) { temp_p.add_term(p1->coef, p1->power); p1 = p1->next; }
		else if (p1->power == p2->power) {
			if ((p1->coef + p2->coef) != 0) {
				temp_p.add_term(p1->coef + p2->coef, p1->power);
			}
			p1 = p1->next;
			p2 = p2->next;
		}
	}
	return temp_p;
}

polynomial polynomial::operator*(polynomial &P) {
	polynomial temp_p;
	term * p1 = head, *p2;
	for (int i = 0; i < num_terms; i++) {
		p2 = P.head;
		for (int j = 0; j < P.num_terms; j++) {
			temp_p.add_term(p1->coef * p2->coef, p1->power + p2->power);
			p2 = p2->next;
		}
		p1 = p1->next;
	}
	return temp_p;
}


int main() {
	polynomial p1, p2, p3, p4, p5, p6;
	int num_t;
	cout << "Enter numer of terms" << endl;
	cin >> num_t;
	cout << "Enter all terms" << endl;
	for (int i = 0; i < num_t; i++) { //You don't need to check for input error
		int c, p;
		cin >> c >> p;
		p1.add_term(c, p);
	}
	p1.print_polynomial();
	cout << endl;
	cout << "Enter numer of terms" << endl;
	cin >> num_t;
	cout << "Enter all terms" << endl;
	for (int i = 0; i < num_t; i++) { //You don't need to check for input error
		int c, p;
		cin >> c >> p;
		p2.add_term(c, p);
	}
	p2.print_polynomial();
	p3 = p1 + p2;
	p3.print_polynomial();
	p4 = p1 * p2;
	p4.print_polynomial();
	getchar();
	getchar();
	return 0;
}
/*
//An example screenshot is given below:
//Different cases may be used during grading

Enter numer of terms
3
Enter all terms
2 2 1 1 4 0

2 2   1 1   4 0
Enter numer of terms
2
Enter all terms
-6 1 3 0

-6 1   3 0
2 2   -5 1   7 0
-12 3   -21 1   12 0
*/
