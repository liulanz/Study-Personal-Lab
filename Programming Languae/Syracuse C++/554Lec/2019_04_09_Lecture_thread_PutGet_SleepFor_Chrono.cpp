//unique_lock and condition_variable and notify
#include <iostream>
#include <thread>
#include <vector>
#include <condition_variable>
#include <mutex> //mutually exclusive; a lock
#include <chrono> //time

using namespace std;

mutex lock1;
condition_variable cv1, cv2; //a condition variable is
							 //similar to a message channel
vector<int> vec;
int num_putter_blocked_outside = 0;
int num_putter_blocked_inside = 0;
int num_getter_blocked_outside = 0;
int num_getter_blocked_inside = 0;

void put(int i) {
	int run = 10;
	while (run > 0) {
		this_thread::sleep_for(chrono::milliseconds(rand() % 7 + 1));
		num_putter_blocked_outside++;
		unique_lock<mutex> ulock1(lock1);
		num_putter_blocked_outside--;
		//unique_lock allows multiple lock and unlock operations.
		//When declared, it will be automatically executed.

		cout << "put thread " << i << " is lock owner"<<endl;
		num_putter_blocked_inside++;
		while (vec.size() == 10) cv1.wait(ulock1);
		num_putter_blocked_inside--;
		//If vec.size()== 10, this thread will go to sleep
		//and release the ulock1.
		//It will be waiting for a wake-up message on cv1.
		//Once awakened, it will own the ulock1 again.

		vec.push_back(rand() % 100 * i);
		if (vec.size() == 10) cv2.notify_one();
		//using cv2 to send a wake-up call.
		//notify_one will only randomly wake up one sleeping thread.
		//If notify_all is used, all threads waiting for cv2 will
		//be awakened, and one will randomly selected to own the lock
		//and the rest of threads will be sent back to sleep, which
		//is not efficient, and thus we use notify_one.
		//this_thread::sleep_for(chrono::milliseconds(rand() % 7 + 1));
		run--;
	}
}

void get(int i) {
	int run = 10;
	while (run > 0) {
		this_thread::sleep_for(chrono::milliseconds(rand() % 7 + 1));
		num_getter_blocked_outside++;
		unique_lock<mutex> ulock1(lock1);
		num_getter_blocked_outside--;
		cout << "get thread " << i << " is lock owner"<<endl;
		num_getter_blocked_inside++;
		while (vec.size() < 10) cv2.wait(ulock1);
		num_getter_blocked_inside--;
		int sum = 0;
		for (int j = 0; j < 10; j++) { sum += vec[i]; }
		vec.clear();
		cv1.notify_one();
		//this_thread::sleep_for(chrono::milliseconds(rand() % 7 + 1));
		run--;
	}
}


int main() {

	thread putter[10];
	thread getter[2];
	for (int i = 0; i < 10; i++) {
		putter[i] = thread(put, i);
	}
	for (int i = 0; i < 2; i++) {
		getter[i] = thread(get, i);
	}
	for (int i = 0; i < 10; i++) {
		putter[i].join();
	}
	for (int i = 0; i < 2; i++) {
		getter[i].join();
	}

	cout << "finish!!" << endl;
	getchar();
	getchar();
	return 0;
}
