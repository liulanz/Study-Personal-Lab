//more on map, list , vector
#include <iostream>
//#include <array>
#include <map>
#include <list>
#include <vector>
#include <string>
#include <algorithm>//sort

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
	bool operator==(const ThreeD &t) const  { return (ht+wid == t.ht + t.wid); }
};
ostream & operator<<(ostream &str, const ThreeD t) {
	str << "(" << t.ht << ", " << t.wid << ", " << t.dep << ")";
	return str;
}

bool comp1(int a, int b) { return (a % 3 < b % 3); }

int main() {
	list<int> L1 = { 6, 4,1,7,2 };
	L1.sort();
	for (int i : L1) { cout << i << " "; }
	cout << endl;
	L1.sort(comp1);
	for (int i : L1) { cout << i << " "; }
	cout << endl;

	vector<int> V1 = { 8, 4,1,7,2 };
	sort(V1.begin(), V1.end());
	for (int i : V1) { cout << i << " "; }
	cout << endl;
	sort(V1.begin(), V1.end(), comp1);
	for (int i : V1) { cout << i << " "; }
	cout << endl;
	int A[5]= { 8, 4,1,7,2 };
	sort(A, A + 5);
	for (int i : A) { cout << i << " "; }
	cout << endl;


	ThreeD t1(4, 5, 6), t2(9, 1, 1), t3(8, 2, 1);

	list<ThreeD> L2 = { t1, t2,t3 };
	L2.sort();
	cout<<"..........."<<endl;
	for (ThreeD i : L2) { cout << i << " "; }
	cout << endl;
	auto it1 = find(L2.begin(), L2.end(), t2);
	if (it1 != L2.end()) cout << *it1 << endl;


	map<ThreeD, int> M1 = { {t2, 8},{t1, 25},{t3,7} };
	for (auto i : M1) { cout << i.first << " " << i.second << endl; }
	auto it2 = M1.find(t1);
	if (it2 != M1.end()) cout << it2->first << " " << it2->second << endl;

	vector<map<int, list<int>>> L3 =
	{ {{7, {1,2,3}},{25,{4,5,6}},{12,{10,20,30}}} , {{77, {11,22,33}},{25,{4,5,6}},{122,{10,20,30}}} };
	auto it3 = L3[1][122].begin();
	it3++;
	cout << *it3 << endl;

	list<int> &K = L3[1][122];//k is a reference of L3[1][122]
	//which is basicaly a nickname
	cout << K.size() << endl;

	L3[0][25].push_back(100);
	vector<vector<int>> V2(10, vector<int>(10));
	//int A[10][10]; raw array is most efficient.


	auto it9 = V1.begin();
	it9 += 3;
	it9--;
	auto it10 = L1.begin();
	//it10 = it10 + 1; error
	it10++;
	it10--;
	++it10;
	--it10;
	//only the above 4 are allowed
	//The same for map


	getchar();
	getchar();

	return 0;
}
