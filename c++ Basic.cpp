// c++ Basic.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <vector>
using namespace std;


int sum(int a, int b) {
	cout << "The sum is " <<a + b<< endl;
	return a + b;
}

typedef int INT;
#define loop(a)for(int i=1;i<a;i++)
#define SUM sum

int main()
{
	INT x = 2;
	INT y = 3;
	cout << x + y << endl;
	int cnt = 0;
	loop(10) {
		cnt++;
		cout << cnt << endl;
	}
	SUM(10, 20);
    return 0;
}

