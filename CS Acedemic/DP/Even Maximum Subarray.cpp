#include <iostream>
#include <vector>
typedef long long int64;
using namespace std;
int64 getmax(int64 n1,int64 n2){
    if(n1>n2)return n1;
    return n2;
}
int main() {
    int n;
    cin>>n;
    vector<int64>v;
    vector<int64>dp;
    int64 res=-2000000000;
    for(int i=0;i<n;i++){
        int64 a;
        cin>>a;
        v.push_back(a);
    }
    dp.push_back(0);
    dp.push_back(v[1]+v[0]);
    for(std::vector<long long int>::size_type i=2;i<v.size();i++){
        int64 M=getmax(v[i]+v[i-1],v[i]+v[i-1]+dp[i-2]);
        //M=getmax(M,v[i]+v[i-1]);
        res=getmax(res,M);
        dp.push_back(M);
    }
    cout<<res;
}