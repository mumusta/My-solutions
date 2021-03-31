/*

    Author: Muhammad Mustafa
    
    Problem: 
                B. Right Triangles
                Codeforces Testing Round #1
                https://codeforces.com/contest/52/problem/B

    - With the help of some preprocessing we can compute for any cell the number of stars in any direction in O(1).
	- The answer is, for any cell i that is star, (stars above * stars right) + (stars above * stars left) + 
	  (stars under * stars right) + (stars under * stars left). 

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

int grid[1111][1111] = { 0 }, u[1111][1111] = { 0 };
int d[1111][1111] = { 0 }, l[1111][1111] = { 0 }, r[1111][1111] = { 0 };

int main() {

    #ifndef ONLINE_JUDGE/*-|------------|--------------|*/
    /**/freopen("in.in", "r", stdin);/*-|--------------|*/
    #endif/*-|-------------|------------|--------------|*/
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    ll n, m; cin >> n >> m;

    for (int i = 1; i <= n ; i ++){

        for (int ii = 1; ii <= m; ii ++){

            char c; cin >> c;

            if (c == '*')
                grid[i][ii] = 1;
        }
    }

    for (int ii = 1; ii <= m ; ii ++){

        for (int i = 1; i <= n; i ++){

            u[i][ii] += u[i - 1][ii] + grid[i][ii];
        }
    }

    for (int ii = 1; ii <= m ; ii ++){

        for (int i = n; i >= 1; i --){

            d[i][ii] += d[i + 1][ii] + grid[i][ii];
        }
    }

    for (int i = 1; i <= n ; i ++){

        for (int ii = 1; ii <= m; ii ++){

            l[i][ii] += l[i][ii - 1] + grid[i][ii];
        }
    }

    for (int i = 1; i <= n ; i ++){

        for (int ii = m; ii >= 1; ii --){

            r[i][ii] += r[i][ii + 1] + grid[i][ii];
        }
    }

    ll res = 0;

    for (int i = 1; i <= n ; i ++){

        for (int ii = 1; ii <= m; ii ++){

            if (!grid[i][ii]) continue;

            res += ((ll)(u[i][ii] - 1) * (ll)(r[i][ii] - 1));
            res += ((ll)(u[i][ii] - 1) * (ll)(l[i][ii] - 1));
            res += ((ll)(d[i][ii] - 1) * (ll)(r[i][ii] - 1));
            res += ((ll)(d[i][ii] - 1) * (ll)(l[i][ii] - 1));
        }
    }

    cout << res << '\n';

    return 0;
}