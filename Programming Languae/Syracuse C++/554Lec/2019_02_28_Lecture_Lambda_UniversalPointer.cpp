#include <iostream>
#include <vector>
#include <list>
#include <algorithm> //sort

bool comp1(int i, int j) { return i > j; }
bool comp2(int * p1, int * p2) { return *p1 < *p2; }

using namespace std;
int main() {

	vector<int> V1 = { 7,3,11,1,5 };
	sort(V1.begin(), V1.end());//sort applies to array as well
	for (auto i : V1) { cout << i << " "; }
	cout << endl;
	sort(V1.begin(), V1.end(), comp1);
	for (auto i : V1) { cout << i << " "; }
	cout << endl;
	auto it1 = find(begin(V1), V1.end(), 7);
	cout << *it1 << endl;
	list<int> L1 = { 6,2,11,8,3 };
	L1.sort();
	for (auto i : L1) { cout << i << " "; }
	cout << endl;
	L1.sort(comp1);
	for (auto i : L1) { cout << i << " "; }
	cout << endl;
	auto it2 = find(begin(L1), L1.end(), 8);//end(L1), L1.end(), size(L1)
	cout << *it2 << endl;
	list<int *> L2 = { new int(22), new int(11), new int(6), new int(4), new int(2) };
	L2.sort(comp2);
	for (int * p : L2) { cout << *p << " "; }
	cout << endl;
	//find(L2.begin()), L2.end(), 11);
	//find_if : return the position of the first element that meets a condition F
	//find_if(L2.begin(), L2.end(), F);
	//F is a unary function that returns bool
	int i = 10, j = 20, k = 30, m = 40;

	//You are discouraged to use it in the following way; use regular function definiton instead.
	auto Func1 = [i, &j](int a, int &b) ->int { //[...] is called capture clause
		//i: read only;  j: allows both read and write
		//->int return type is optional
		j++;
		//i++; error
		b++;
		return i + j + a + b;
	};


	//......j = 1000;
	cout << Func1(6, k) << endl;

	//You are recommended to use lambda function for in-line definition.
	sort(V1.begin(), V1.end(), [](int a, int b) {return a > b;});
	for (auto i : V1) { cout << i << " "; }
	cout << endl;
	auto it3 = find_if(begin(L2), end(L2), [](int * p) {return *p == 11; });
	cout << **it3 << endl;

	/*
	capture clause
	[&] : access all variables with both read and write
	[=] : access all variables with read only
	[&, i]: i read only and all others both read and write
	[=, &i, &j]  i and j both read and write, all others read only
	[=, i] : error
	*/



	//universal pointer
	void * p10;
	int i10 = 200;
	char c10 = 'W';
	p10 = &i10;
	//cout << *p10; Error
	cout << *(int *)p10 << endl;
	p10 = &c10;
	//cout << *p10; Error
	cout << *(char *)p10 << endl;




	getchar();
	getchar();
	return 0;
}
