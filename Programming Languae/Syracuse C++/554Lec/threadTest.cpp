#include <iostream>
#include <thread>

using namespace std;

void f1(int i, int k) { for (int j = 0; j < i; j++) cout << k <<endl; }
void f2(int i) { cout<< i<<endl; }

int main() {
	thread t1(f1, 3, 7);
	thread t2(f1, 4, 2);
	t1.join();//for main thread to pause and wait until t1 completes.
	t2.join();


	getchar();
	getchar();
	return 0;
}
