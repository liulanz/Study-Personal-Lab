// 13C.cpp : Defines the entry point for the console application.
//

//解法：dp 滚动数值

#include "stdafx.h"
#include <iostream>
#include <vector>
#include <unordered_set> 
#include <algorithm> 
#include<math.h>
using namespace std;

/*Little Petya likes to play very much. And most of all he likes to play the following game:

He is given a sequence of N integer numbers. At each step it is allowed to increase the value of any number by 1 or to decrease it by 1. 
The goal of the game is to make the sequence non-decreasing with the smallest number of steps. Petya is not good at math, so he asks for your help.

The sequence a is called non-decreasing if a 1 ≤ a 2 ≤ ... ≤ a N holds, where N is the length of the sequence.*/

long long dp[2][5001];
void solve(vector<int>&nums) {
	int n = nums.size();
	vector<int>sorted;
	for (int i = 0; i < n; i++)sorted.push_back(nums[i]);
	sort(sorted.begin(), sorted.end());
	for (int i = 1; i <= n; i++) {
		int num = nums[i - 1];
		for (int j = 1; j <= n; j++) {
			int sortnum = sorted[j - 1];
			int dif = abs(num- sortnum);
			long long cost = dp[0][j] + dif;
			if (j == 1) {
				dp[1][j] = cost;
			}
			else {
				dp[1][j] = min(cost, dp[1][j - 1]);
			}
			dp[0][j] = dp[1][j];
		}
	}
	cout << dp[1][n] << endl;
}

int main()
{
	int n;
	cin >> n;
	vector<int>nums;
	for (int i = 0; i < n; i++) {
		int e;
		cin >> e;
		nums.push_back(e);
	}
	solve(nums);
    return 0;
}

