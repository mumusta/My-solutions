#include <bits/stdc++.h>

using namespace std;

typedef long double LD;
typedef long long int ll;
typedef unsigned long long int ull;


int main() {

    //freopen("in.in", "r", stdin);
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    ull n, k;

    while (cin >> n >> k){

        LD a = 0, b = 0;

        for (int i = n; i >= (n - k + 1); i --)
            a += log10(i);

        for (int i = 1 ; i <= k; i ++)
            b += log10(i);

        cout << floor( a - b ) + 1 << '\n';
    }

    return 0;
}
