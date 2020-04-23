//static
//for_each
#include <iostream>
#include <algorithm> //for_each
#include <vector>
#include <list>
#include <map>
#include <string>
using namespace std;

class my_class {
public:
	static int num_objects;//static members are associated with class, rather than objects
	my_class() { num_objects++; }
	static void get_num_objects() { cout << num_objects << endl; }
};
	int my_class::num_objects = 0;

	void func1() {
		static int num_calls = 1;//persistent local variable
		//=1 will only be performed during the first
		//time this function is invoked
		cout << "num_calls = " << num_calls++ << endl;
	}


int main() {

	my_class m1, m2, m3;
	cout << my_class::num_objects << endl;//more "correct"
	my_class::get_num_objects(); //more "correct"

	cout << m1.num_objects << endl;//compiler won't complain
	m1.get_num_objects();//compiler won't complain

	func1();
	func1();
	func1();
	func1();
	cout << endl;
	vector<int> V1 = { 1,2,3,4,5 };
	for_each(V1.begin(), V1.end(), [](int &i) {i++; } );
	for_each(V1.begin(), V1.end(), [](int i) {cout << i << " "; });

	for (auto &i : V1) { i++; };

	cout << endl;
	list<int> L1 = { 11,2,3,4,55 };
	for_each(L1.begin(), L1.end(), [](int &i) {i++; });
	for_each(L1.begin(), L1.end(), [](int i) {cout << i << " "; });
	cout << endl;
	int AA[] = { 10,20,30,40,50 };
	for_each(AA, AA + 5, [](int &i) {i++; });
	for_each(AA, AA + 5, [](int i) {cout << i << " "; });
	cout << endl;
	for (int i : AA) { cout << i << " "; }

	cout << endl;
	map<int, string> M1 = { {3, "Chen"}, {2, "Dave"}, {1, "Sanjay"} };
	for_each(M1.begin(), M1.end(), [](pair<int, string> p) {cout << p.first << " " << p.second << " "; });



	getchar();
	getchar();
	return 0;
}