#include <iostream>

#include <vector>

#include <string>

#include <map>

using namespace std;



template <class X> ostream & operator<<(ostream & str, const map<int, X> &M) {
	auto it1 = M.begin();
	while (it1 != M.end()) {
		str << it1->first << " ";
		str << it1->second;
		it1++;
	}
	return str;
}

template <class Y> ostream & operator<<(ostream &str, const vector<Y *> &V) {
	str << "[";
	for (size_t i = 0; i < V.size()-1; i++) {
		str << *(V[i]) << ", ";
	}
	str << *(V[V.size() - 1]) << "]" << endl;
	return str;
}


int main() {
	map<int, vector<int *>> M1 = { {4, {new int (7), new int(15), new int(12)}}, {2,{ new int(7), new int(15)}}};
	map<int, vector<string *>> M2 = { { 5,{ new string("Orange"), new string ("apple"), new string("banana") } },
	{ 3,{ new string("grape"), new string("peach") } } };
	
	cout << M1 << endl;
	cout << M2 << endl;
	getchar();
	getchar();
	return 0;

}

//The following is screenshot of the above code

/*

2 [7, 15]

4 [7, 15, 12]



3 [grape, peach]

5 [Orange, apple, banana]





*/
