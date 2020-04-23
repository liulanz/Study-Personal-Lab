#include <iostream>
#include <memory>

using namespace std;

class node {
public:
	int value;
	shared_ptr<node> next;
	node(){}
	node(int v) { value = v; }
};

class ring {
public:
	shared_ptr<node> head, tail;
	ring() {}
	ring(const initializer_list<int> &V) {
		auto it = V.begin();
		while (it != V.end()) {
			shared_ptr<node> p = make_shared<node>(*it);
			if (!head) { head = tail = p;  p->next = p; }
			else {
				tail->next = p;
				tail = p;
				p->next = head;

			}
			it++;
		}
	}
	~ring() { tail->next.reset(); }//delete is not allowed for smart pointers }

};

	ostream & operator<<(ostream &str, const ring &R) {
		shared_ptr<node> p = R.head;
		if (!R.head) { return str; }
		str << p->value<< " ";
		p = p->next;
		while (p !=  R.head) {
			str << p->value << " ";
			p = p->next;
		}
		return str;
	}


int main() {
	ring R = { 1,2,3,4,5 };
	cout << R << endl;
	shared_ptr<ring> p1 = make_shared<ring>(initializer_list<int>{5, 6, 7, 8});
	cout << *p1 << endl;
	getchar();
	getchar();
	return 0;
}
