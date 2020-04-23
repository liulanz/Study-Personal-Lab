//Problem 4

#include <iostream>
#include <vector>
#include <list>
#include <map>

using namespace std;


class my_class {
public:
	list<list<int *> > * p_data1;
	map<int, list<list<int> *> > * p_data2;
	vector<list<map<int, list<int>>>> data3;
	my_class * next;
	my_class * previous;


	my_class() { p_data1 = nullptr; p_data2 = nullptr; next = nullptr; previous = nullptr; }

	//Write code to implement the following destructor

	~my_class() {
	
		list< list<int> *>::iterator it1 = p_data1->begin();
		while (it1 != p_data1->end()) {
			delete (*it1);
			it1++;
		}
		delete p_data1;
		map<int, list<list<int> *> >::iterator it2 = p_data2->begin();
		while (it2 != p_data2->end()) {
			list<list<int> *>::iterator it3 = (it2->second).begin();
			while (it3 != (it2->second).end()) {
				delete *it3;
				it3++;
			}
			it2++;
		}
		delete p_data2;


		//Let's not worry about updating head or tail
		//Assume that user's code has taken care of that.

		if (next == nullptr && previous == nullptr) {}
		else {
		if (next != nullptr) {next->previous = previous;}
		if (previous != nullptr) {previous->next = next;}
		}
	};

	//Other parts of the class details are not shown here.
};