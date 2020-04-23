// #include <iostream>
// #include <list>
// #include <vector>
// #include <map>
// using namespace std;
//
// // 1.DB conversion
// // 2.Lisked_list operation
// // 3.lamda function or passing function as function parameter
// // 4.cascaded STL structure: how to access, how to do <<, how to delete, how to compare==
// // 5. copy,move,destructor,L-R value operator=
// //
// // new() is global
//
//
//
//
// 	list<list<string>> testing2 ={{"cat"s,"dog"},{"fish", "tiger"}};
// 	// cout<<testing2<<endl;


//Problem_1 Midterm Exam

//HW2

#include <iostream>
#include <list>
#include <vector>
#include <string>
using namespace std;
//Write code for the following five functions
//In both DB1_print and DB2_print, you are required to use index function (i.e., []) for vector, rather than iterator
void DB1_print(vector<list<list<string>>> &DB1);

void DB1_to_DB2(vector<list<list<string>>> &DB1, list<vector<list<string> * > *> &DB2);

void DB2_print(list<vector<list<string> * > *> &DB2);

void DB2_to_DB3(list<vector<list<string> * > *> &DB2, list < list<list<string *> * > > &DB3);

void DB3_to_DB2(list < list<list<string *> * > > &DB3, list<vector<list<string> * > *> &DB2);

void DB3_print(list < list<list<string *> * > > &DB3);



int main() {
	vector<list<list<string>>> DB1 = {
		{ { "cat", "dog" },{ "duck", "chicken","pig" } },
	{ { "lion", "tiger", "hyena", "leopard" },{ "Zebra", "elephant" },{ "buffalo" } }
	};
	DB1_print(DB1);
	list<vector<list<string> * > *> DB2;
	DB1_to_DB2(DB1, DB2);
	DB2_print(DB2);

	list < list<list<string *> * > > DB3;

	DB2_to_DB3(DB2, DB3);

	DB3_print(DB3);

	DB3_to_DB2(DB3, DB2);

	DB2_print(DB2);

	getchar();

	getchar();

	return 0;

}

void DB1_print(vector<list<list<string>>> &DB1) {

	cout << endl;

	for (size_t i = 0; i < DB1.size(); i++) {

		auto it1 = DB1[i].begin();

		while (it1 != DB1[i].end()) {

			auto it2 = it1->begin();

			while (it2 != it1->end()) {

				cout << *it2 << " ";

				it2++;

			}

			cout << endl;

			it1++;

		}

		cout << endl;

	}

}



void DB1_to_DB2(vector<list<list<string>>> &DB1, list<vector<list<string> * > *> &DB2) {

	auto it1 = DB1.begin();

	while (it1 != DB1.end()) {

		vector<list<string> *> * p1 = new vector<list<string> *>;

		auto it2 = it1->begin();

		while (it2 != it1->end()) {

			auto it3 = it2->begin();

			list<string> * p2 = new list<string>;

			while (it3 != it2->end()) {

				p2->push_back(*it3);

				it3++;

			}

			p1->push_back(p2);

			it2++;

		}

		DB2.push_back(p1);

		it1++;

	}

}



void DB2_print(list<vector<list<string> * > *> &DB2) {

	auto it1 = DB2.begin();
	while (it1 != DB2.end()) {

		for (size_t i = 0; i < (*it1)->size(); i++) {

			auto it2 = (**it1)[i]->begin();
			while (it2 != (**it1)[i]->end()) {

				cout << *it2 << " ";

				it2++;
			}
			cout << endl;

		}

		cout << endl;
		it1++;

	}



	/* the implementation with iterator for vector

	cout << endl;

	auto it1 = DB2.begin();

	while (it1 != DB2.end()) {

	auto it2 = (*it1)->begin();

	while (it2 != (*it1)->end()) {

	auto it3 = (*it2)->begin();

	while (it3 != (*it2)->end()) {

	cout << *it3 << " ";

	it3++;

	}

	cout << endl;

	it2++;

	}

	cout << endl;

	it1++;

	}

	*/

}



void DB2_to_DB3(list<vector<list<string> * > *> &DB2, list < list<list<string *> * > > &DB3) {

	auto it1 = DB2.begin();

	while (it1 != DB2.end()) {

		auto it2 = (*it1)->begin();

		list<list<string *> *> L;

		while (it2 != (*it1)->end()) {

			auto it3 = (*it2)->begin();

			list<string *> * p1 = new list<string *>;



			while (it3 != (*it2)->end()) {

				string * p2 = new string(*it3);

				p1->push_back(p2);

				it3++;

			}

			L.push_back(p1);

			it2++;

			//	cout << endl;

		}

		DB3.push_back(L);

		it1++;

		//cout << endl;

	}

}

void DB3_print(list < list<list<string *> * > > &DB3) {

	cout << endl;

	auto it1 = DB3.begin();

	while (it1 != DB3.end()) {

		auto it2 = it1->begin();

		while (it2 != it1->end()) {

			auto it3 = (*it2)->begin();

			while (it3 != (*it2)->end()) {

				cout << **it3 << " ";

				it3++;

			}

			cout << endl;

			it2++;

		}

		cout << endl;

		it1++;

	}

}



void DB3_to_DB2(list < list<list<string *> * > > &DB3, list<vector<list<string> * > *> &DB2) {

	auto it1 = DB3.begin();

	while (it1 != DB3.end()) {

		auto it2 = it1->begin();

		vector<list<string> *> * p1 = new vector<list<string> *>;

		while (it2 != it1->end()) {

			auto it3 = (*it2)->begin();

			list<string> * p2 = new list<string>;

			while (it3 != (*it2)->end()) {

				p2->push_back(**it3);

				it3++;

			}

			p1->push_back(p2);

			it2++;

		}

		DB2.push_back(p1);

		it1++;

	}

}
