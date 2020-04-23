#include <iostream>
#include <memory>
#include <tuple>

using namespace std;

int AA[3][2] = { {3,4},{30,40},{300,400} };

void f1(pair<int, int> p) {
	cout << p.first << " " << p.second << endl;
}

void f2(tuple<int, int, int> t) {

	cout << get<0>(t) << " " << get<1>(t) << " " << get<2>(t) << endl;
}

class my_class {
public:
	int & operator[](pair<int, int> p) {
		return AA[p.first][p.second];
	}
};


int main() {
	
	pair<int, int> p1 = { 2,4 };
	f1(p1);
	f1({ 3,5 });
	my_class m1;
	cout << m1[{2, 1}] <<endl;

	f2({ 10,20,30 });
	getchar();
	getchar();
	return 0;
}