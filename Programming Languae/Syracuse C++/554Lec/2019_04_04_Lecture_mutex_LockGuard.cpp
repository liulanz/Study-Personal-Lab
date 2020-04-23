//synchronization between threads
#include <iostream>
#include <thread>
#include <mutex> //mutually exclusive; a lock

using namespace std;

mutex lock1;



void f1() {
	for (int i = 0; i < 50; i++) {
		{
			//lock1.lock();


		//	lock_guard<mutex> lguard(lock1);
			//When declared, it will be automatically execute.
			//lock_guard can only be unlocked once.
			cout << endl;
			for (int j = 0; j < 20; j++)
				cout << "f1";
			//	lock1.unlock();
			//When using a mutex lock, you need to remember to unlock it;
			//otherwise, the program will hang.
			//On the other hand, lock_guard will unlock itself when going out of scope.
			//


		}
	}
}
void f2() {
	for (int i = 0; i < 50; i++) {
		//lock1.lock();
		{
	//		lock_guard<mutex> lguard(lock1);
			cout << endl;
			for (int j = 0; j < 20; j++)
				cout << "f2";
			//lock1.unlock();
		}
	}
}

int main() {

	thread t1(f1);
	thread t2(f2);

;


	getchar();
	getchar();
	return 0;
}
