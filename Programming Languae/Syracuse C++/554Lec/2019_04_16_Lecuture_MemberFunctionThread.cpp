#include <iostream>
#include <thread>
#include <string>

using namespace std;

class my_class {
public:
	void f1(string s, int i) {
		for (int j = 0; j < i; j++) {
			cout << s << " j = " << j << endl;
		}
	}
	static void f2(string s, int i) {
		for (int j = 0; j < i; j++) {
			cout << s << " j = " << j << endl;
		}
	}
	
};

int main() {
	//my_class m1;
	//m1.f1("this is good", 5);

	my_class * p = new my_class();
	thread T1(&my_class::f1, p, "Regular", 5);
	T1.join();
	delete p;
	thread T2(&my_class::f2, "Static", 10);
	T2.join();


	getchar();
	getchar();
	return 0;
}