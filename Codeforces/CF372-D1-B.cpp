/*

	Author: Muhammad Mustafa
	
	Problem: 
                B. Counting Rectangles is Fun
                Codeforces Round #219 (Div. 1)
                https://codeforces.com/contest/372/problem/B

	- Let near[i][ii] be the column of the nearest 1 from the right to cell (i, ii).
	- Let store[i][ii][x][xx] be the number of all possible good rectangles 
	  in rectangel i ii x xx that all of them have the same upper left cell which is cell (i, ii).
	- The answer is the sum of all store[i][ii][c][d] where (a <= i <= c) and (b <= ii <= d) for each query. 

*/


#include <bits/stdc++.h>

using namespace std;

typedef long double LD;
typedef long long int ll;
typedef complex < LD > point;
typedef unsigned long long int ull;

#define X real()
#define Y imag()
#define EPS 1e-9
#define len size
#define pp push_back
#define mp make_pair


ll near[44][44] = { 0 };
ll store[44][44][44][44] = { 0 };
ll n, m, q, grid[44][44] = { 0 }, a, b, c, d;

int main() {

    //freopen("in.in", "r", stdin);
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    cin >> n >> m >> q;

    for (int i = 1; i <= n; i ++){
        for (int ii = 1; ii <= m; ii ++){
            char c; cin >> c;
            if (c == '0') grid[i][ii] = 1;
        }
    }

    for (int i = 1; i <= n; i ++){
        near[i][m + 1] = (m + 1);
        for (int ii = m; ii >= 1; ii --){
            if (!grid[i][ii]) near[i][ii] = ii;
            else near[i][ii] = near[i][ii + 1];
        }
    }

    for (int i = 1; i <= n; i ++){
        for (int ii = 1; ii <= m; ii ++){
            for (int x = i; x <= n; x ++){
                for (int xx = ii; xx <= m; xx ++){
                    ll minima = xx + 1;
                    for (int z = i; z <= x; z ++){
                        if (!grid[z][ii]) break;
                        minima = min(minima, near[z][ii]);
                        store[i][ii][x][xx] += (minima - ii);
                    }
                }
            }
        }
    }

    for (int x = 0; x < q; x ++){

        cin >> a >> b >> c >> d;

        ll res = 0;
        for (int i = a; i <= c; i ++){
            for (int ii = b; ii <= d; ii ++){
                res += store[i][ii][c][d];
            }
        }

        cout << res << '\n';
    }

    return 0;
}
