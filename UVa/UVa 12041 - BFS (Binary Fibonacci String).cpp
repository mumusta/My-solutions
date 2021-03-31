/*

    Author: Muhammad Mustafa
    
    Problem: 
                12041 - BFS (Binary Fibonacci String)
                https://uva.onlinejudge.org/external/120/12041.pdf

    - Let f[x] be the Fibonacci of x + 1.
    - Based on the fact that (I)th char in BFS(N) equal to (I - f[N - 2])th char in BFS(N - 1) if (I >= f[N - 2]) and
      equal to (I)th char in BFS(N - 2) otherwise, We can reduce significantly the given N to 
      an equivalent reasonable one, then we can compute the origin of each value in small range. 

*/

#include <bits/stdc++.h>

using namespace std;

typedef long double LD;
typedef long long int ll;
typedef complex < LD > point; //&r
typedef unsigned long long int ull;

#define X real()
#define Y imag()
#define EPS 1e-9
#define len size
#define pp push_back
#define mp make_pair

ll f[55] = { 0 }; //1,1,2,3,5,8,13,21,34,55,89,...

int main() {

    #ifndef ONLINE_JUDGE/*-|------------|--------------|*/
    /**/freopen("in.in", "r", stdin);/*-|--------------|*/
    #endif/*-|-------------|------------|--------------|*/
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    f[0] = 1; f[1] = 1;
    for (int i = 2; i <= 50; i ++)
        f[i] = f[i - 1] + f[i - 2];

    int T; cin >> T;

    while (T--){

        ll n, x, y; cin >> n >> x >> y;

        if (n & 1) n = 49;
        else n = 50;

        for (ll i = x, in; i <= y; i ++){

            ll N = n, I = i;

            while (N > 1){

                if (I >= f[N - 2]) I -= f[N - 2], N--;
                else N -= 2;
            }

            cout << N;
        }

        cout << '\n';
    }

    return 0;
}
