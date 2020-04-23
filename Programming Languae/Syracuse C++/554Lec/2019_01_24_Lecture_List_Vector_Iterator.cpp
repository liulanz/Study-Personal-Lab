//STL (standard template library), library of containers
#include <iostream>
#include <vector>
#include <list>
#include <map>

using namespace std;
class ThreeD {
public:
	int ht;
	int wid;
	int dep;
	ThreeD(int i, int j, int k) : ht(i), wid(j), dep(k) {}
	ThreeD() { ht = wid = dep = 0; }
};

int main() {
	vector<int> V1 = { 0,1,2,3,4 };
	V1.push_back(5);
	V1.pop_back();
	for (size_t i = 0; i < V1.size(); i++) {
		//size_t is non-negative int
		cout << V1[i] << " ";
	}
	//iterator is a pointer that you have to use within STL scope
	vector<int>::iterator it1 = V1.begin();
	//auto it1 = V1.begin(); this statement will also work
	while (it1 != V1.end()) {
		cout << *it1 << "";
		it1++;
	}
	//begin() returns the address(position) of the first element of V1
	//end() returns the position after the last element
	ThreeD t1(3, 4, 5), t2(10, 20, 30), t3(5, 6, 7);
	vector<ThreeD> V2 = { t1,t2, t3 };
	auto it2 = V2.begin();
	cout << it2->ht << endl;

	vector<ThreeD> * p1;
	vector<ThreeD> * p2 = new vector<ThreeD>;
	vector<int>::iterator it3 = find(V1.begin(), V1.end(), 3);
	//find returns the address of match or end() if no match
	if (it3 != V1.end()) cout << *it3 << endl;

	list<int> L1 = { 0,1,2,3,4 };
	L1.push_back(5);
	L1.push_front(-1);
	L1.pop_back();
	L1.pop_front();
	cout << V1.front() << " " << V1.back() << " " << L1.front() << " " << L1.back();

	list<int>::iterator it4 = L1.begin();
	//auto it4 = L1.begin();
	while (it4 != L1.end()) {
		cout << *it4 << " ";
		it4++;
	}
	cout << endl;
	auto it5 = find(L1.begin(), L1.end(), 3);
	if (it5 != L1.end()) L1.erase(it5);
	L1.remove(3);//will do nothing is no match of 3
				 //only list allows remove

	L1.sort();//only list allows sort

	for (int i : L1) { cout << i << " "; }
	cout << endl;
	for (int i : V1) { cout << i << " "; }
	cout << endl;
	getchar();
	getchar();
	return 0;
}
