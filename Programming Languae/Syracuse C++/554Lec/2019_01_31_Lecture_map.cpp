
//map -- STL container
#include <iostream>
#include <vector>
#include <list>
#include <map>
#include <string>

using namespace std;
int main() {

	map<int, string> M1 = { { 11, "Dave" },{ 4, "Pat" },{ 7, "John" } };
	M1[5] = "Mary";
	M1[11] = "Ben";
	auto it1 = M1.begin();
	while (it1 != M1.end()) {
		cout << it1->first << " " << it1->second << endl;
		it1++;
	}
	M1.insert(pair<int,string>(12,"Zinan"));
	//map will sort items based on key (i.e., first)

	auto it2 = M1.find(7);//find(V1.begin(), V1.end(), 7);
	if (it2 != M1.end()) M1.erase(it2);
	M1.erase(8); //Will simply do nothing, if 8 does not exist

	cout<<"????????"<<endl;

	auto it3 = M1.begin();
	while (it3 != M1.end()) {
		cout << it3->first << " " << it3->second << endl;
		it3++;
	}

	vector< map<int, list<int>> >  V1 = { { { 6,{ 1,2,3 } },{ 4,{ 3,3,3 } } } };
	//cout << V1 << endl;




	getchar();
	getchar();
	return 0;
}
