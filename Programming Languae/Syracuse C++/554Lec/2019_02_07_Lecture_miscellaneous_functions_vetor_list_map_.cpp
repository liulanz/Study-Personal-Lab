//map, list , vector
#include <iostream>
#include <map>
#include <list>
#include <vector>
#include <string>

using namespace std;

class ThreeD {
public:
	int ht;
	int wid;
	int dep;
	ThreeD() { ht = wid = dep = 0; }
	ThreeD(int i, int j, int k) { ht = 10 * i; wid = 10 * j; dep = 10 * k; }
	int vol() const { return ht * wid*dep; }
	bool operator<(const ThreeD &t) const  { return vol() < t.vol(); }
};
ostream & operator<<(ostream &str, const ThreeD t) {
	str << "(" << t.ht << ", " << t.wid << ", " << t.dep << ")";
	return str;
}

int main() {
	list<int> L1 = { 6,5,3,1 };
	L1.sort();
	for (int i : L1) { cout << i << " "; }
	cout << endl;

	ThreeD t1(3, 4, 5), t2(10, 11, 12), t3(5, 6, 7);

	list<ThreeD> L2 = { t3, t2, t1 };
	L2.sort();
	for (ThreeD i : L2) { cout << i << " "; }
	cout << endl;

	map<int, string> M1 = { { 7, "Dave" },{ 4, "pat" },{ 2, "Dan" } };
	M1[11] = "John";

	M1[11] = "Mary";

	auto ret = M1.insert({ 11, "Nancy" });//insert does not override
										  //Mary remains
										  //The return value is a pair <position, bool>
										  //bool will be false if insert does not succeed
										  //bool will be true if insert is successful

	cout << ret.first->first << " " << ret.first->second << endl;
	if (ret.second == false) { cout << "the value is already in map" << endl; }


	for (auto i : M1) { cout << i.first << " " << i.second << " "; }






	map<ThreeD, int> M2 = { { t2, 34 },{ t3, 56 },{ t1, 88 } };


	vector<int> V1(10);//vector of size 10
	vector<int> V2(10, 25); //vector size is 10, all elements are 25
	list<int> L3(5, 100); //size 5, values 100;
	map<int, int> M3;
	cout << endl;
	cout << M3[5] << endl;
	V2.assign(8, 200);//change size to 8 , all with values 200
	L2.assign(5, t1);
	vector<int> V4 = { 1, 2, 3, 4, 5 };
	V4.resize(6, 0);
	cout<<"***************";
	cout << endl;
	for (int i : V4) { cout << i << " "; }
	auto it5 = V4.insert(V4.begin() + 1, 100);
	cout << endl;
	cout << *it5 << endl;
	for (int i : V4) { cout << i << " "; }
	cout << endl;
	auto it6 = V4.insert(it5, 4, 888);//insert 888 4 times
	cout << endl;
	for (int i : V4) { cout << i << " "; }

	//insert applies to list as well
	V4.resize(3, 0);
	cout << endl;
	for (int i : V4) { cout << i << " "; }
	//Try list for resize yourself
	cout << V4.size() << endl;
	V4.clear();//size becomes zero
			   //all STL containers support this

//	int A[10][12];
	vector<vector<int>> AA(10, vector<int>(12, 100));
	cout << AA[2][4] << endl;

	vector<int> V9 = { 1,2,3,4,5 };
	V9.resize(6);
	for (int i : V9) { cout << i << " "; }

	getchar();
	getchar();
	return 0;
}
