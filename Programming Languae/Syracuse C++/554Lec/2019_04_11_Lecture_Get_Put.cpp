//unique_lock and condition_variable and notify
#include <iostream>
#include <thread>
#include <vector>
#include <condition_variable>
#include <mutex> //mutually exclusive; a lock
#include <chrono> //time 

using namespace std;

mutex lock1;
mutex lock2;
condition_variable cv1, cv2; //a condition variable is
							 //similar to a message channel
vector<int> vec;
int num_putter_blocked_outside = 0;
int num_putter_blocked_inside = 0;
int num_getter_blocked_outside = 0;
int num_getter_blocked_inside = 0;
const int n_puts = 4;
const int n_gets = 2;
int max = 4;
int put_run = 4;
int get_run = 2;

void put(int i) {
	int run = put_run;;
	while (run > 0) {
		this_thread::sleep_for(chrono::milliseconds(rand() % 7 + 1));
		num_putter_blocked_outside++;
		unique_lock<mutex> ulock1(lock1);
		num_putter_blocked_outside--;
		//unique_lock allows multiple lock and unlock operations.
		//When declared, it will be automatically executed.
		lock2.lock();
		cout << "put i=  " << i << " is lock owner" << " run = " << run << endl;
		lock2.unlock();
		num_putter_blocked_inside++;
		while (vec.size() == max) cv1.wait(ulock1);
		num_putter_blocked_inside--;
		//If vec.size()== 10, this thread will go to sleep 
		//and release the ulock1.
		//It will be waiting for a wake-up message on cv1.
		//Once awakened, it will own the ulock1 again.

		vec.push_back(rand() % 100 * i);
		if (vec.size() == max) cv2.notify_one();
		//using cv2 to send a wake-up call.
		//notify_one will only randomly wake up one sleeping thread.
		//If notify_all is used, all threads waiting for cv2 will 
		//be awakened, and one will randomly selected to own the lock
		//and the rest of threads will be sent back to sleep, which
		//is not efficient, and thus we use notify_one.
		//this_thread::sleep_for(chrono::milliseconds(rand() % 7 + 1));
		run--;
	}
	lock2.lock();
	cout << "put i = " << i << " completes" << endl;
	lock2.unlock();
}

void get(int i) {
	int run = get_run;
	while (run > 0) {
		this_thread::sleep_for(chrono::milliseconds(rand() % 7 + 1));
		num_getter_blocked_outside++;
		unique_lock<mutex> ulock1(lock1);
		num_getter_blocked_outside--;
		lock2.lock();
		cout << "get i = " << i << " is lock owner" << " run = " << run << endl;
		lock2.unlock();
		num_getter_blocked_inside++;
		while (vec.size() < max) cv2.wait(ulock1);
		num_getter_blocked_inside--;
		int sum = 0;
		for (int j = 0; j < max; j++) { sum += vec[i]; }
		vec.clear();
		cv1.notify_one();
		//this_thread::sleep_for(chrono::milliseconds(rand() % 7 + 1));
		run--;
	}
	lock2.lock();
	cout << "get i = " << i << " completes" << endl;
	lock2.unlock();
}

int main() {

	thread putter[n_puts];
	thread getter[n_gets];
	for (int i = 0; i < n_puts; i++) {
		putter[i] = thread(put, i);
	}
	for (int i = 0; i < n_gets; i++) {
		getter[i] = thread(get, i);
	}
	for (int i = 0; i < n_puts; i++) {
		putter[i].join();
	}
	for (int i = 0; i < n_gets; i++) {
		getter[i].join();
	}

	cout << "finish!!" << endl;
	getchar();
	getchar();
	return 0;
}

