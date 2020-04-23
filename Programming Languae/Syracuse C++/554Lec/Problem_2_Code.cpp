//Problem_2
#include <iostream>
#include <vector>
#include <list>
#include <string>
using namespace std;
//Problem_2

//(A)Write code for function DB1_to_DB2 that will copy data from DB1 to DB2.

void DB1_to_DB2(list<vector<list<string>  > *> &DB1, list < list<list<string  *> * > > &DB2);
template <class T> ostream & operator<<(ostream &str, const vector<T> &t) { for (auto i : t) { str << i << " "; } str << endl; return str; }
template <class T> ostream & operator<<(ostream &str, const list<T> &t) { for (auto i : t) { str << i << " ";  } str << endl; return str;
}
template <class T> ostream & operator<<(ostream &str, const vector<T *> &t) { for (auto * i : t) { str << *i << " "; } str << endl; return str;
}
template <class T> ostream & operator<<(ostream &str, const list<T *> &t) { for (auto * i : t) { str << *i << " "; } str << endl; return str; }


int main() {

	list<vector<list<string>  > *> DB1 =
	{

		new vector<list<string>>
		({
			{ { "Dave" },{ "Dan" },{ "Mary" } },
			{ { "John" },{ "Jesse" } }
			}),
		new vector<list<string>>
		({
			{ { "Nancy" },{ "Bob" } },
			{ { "John" },{ "Jesse" },{ "Betty" } }

			})
	};
	cout << DB1;
	list < list<list<string  *> * > > DB2;
	DB1_to_DB2(DB1, DB2);
	cout << DB2;
	cout << endl;
	list < list<list<string  *> * > > DB3 =
	{
		{
			new list<string *>
			(
				{ new string("Dave"), new string("Nancy"), new string("Betty") }
				),
		new list<string *>
		(
			{ new string("John"), new string("Dan") }
			)
		},
		{
			new list<string *>
			(
				{ new string("Bob"), new string("Mary"), new string("Betty") }
				),
		new list<string *>
		(
			{ new string("Luke"), new string("Maria") }
			),
		new list<string *>
		(
			{ new string("Linda"), new string("Barbara"), new string("Victoria") }
			)

		}
	};
	cout << DB3;



	getchar();
	getchar();
	return 0;
}
/*

list<vector<list<string>  > *> DB1;
list < list<list<string  *> * > > DB2;


(B)Write code for all needed operator<< such that you can do cout << DB1; and cout << DB2.

(C)Give a meaningful example to show how you can initialize DB2;

list < list<list<string  *> * > > DB2; = { ... };
*/
void DB1_to_DB2(list<vector<list<string>  > *> &DB1, list < list<list<string  *> * > > &DB2) {
	for (auto *p1 : DB1) {
		list<list<string *> *> L1;// = new list<list<string *> *>;
		for (auto i : *p1) {
			list<string *> *pp1 = new list<string *>;
			for (auto j : i) {
				pp1->push_back(new string(j));
			}
			L1.push_back(pp1);
		}
		DB2.push_back(L1);
	}
}


