#include <iostream>
#include <iostream>
#include <vector>
using namespace std;
const int MAX = 1e5+5;
typedef long long int64;
vector<pair<int,int>> graph[MAX];

long long solve(int n,int cost){
    vector<bool> visited(n+1, false);
    int64 ans=0;
    for(int i=1;i<=n;i++){
        if(visited[i])continue;
        vector<int> queue = {i};
        visited[i] = true;
        int64 q_size = 1;
        while (queue.size()) {
            int node = queue.back();
            queue.pop_back();
            for (auto edge : graph[node]) {
                if (edge.second > cost) {
                    continue;
                }
                int child = edge.first;
                if (visited[child]) {
                    continue;
                } else {
                    queue.push_back(child);
                    visited[child] = true;
                    q_size += 1;
                }
            }
        }
        ans +=q_size * (q_size - 1) / 2;
    }
    return ans;
}

int main() {
    int N,M,X;
    cin>>N>>M>>X;
    for(int i=0;i<M;i++){
        int v1,v2,w;
        cin>>v1>>v2>>w;
        graph[v1].push_back({v2,w});
        graph[v2].push_back({v1,w});
    }
    int64 small = solve(N, X - 1);
    int64 big = solve(N, X);
    cout << big - small << '\n';
    return 0;
}

