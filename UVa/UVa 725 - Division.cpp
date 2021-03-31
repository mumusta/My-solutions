/*

    Author: Muhammad Mustafa
    
    Problem: 
                725 - Division
                https://uva.onlinejudge.org/external/7/725.pdf

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


int main() {

    //freopen("in.in", "r", stdin);
    //ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    int n, t = 0;

    while (cin >> n){

        if (n == 0)
            break;

        t++;

        if (t != 1)
            cout << '\n';

        int cw = 0;

        for (int b = 1234; b <= (98765 / n); b ++){

            bitset < 10 > x(0);
            int a_ = b * n, a, b_ = b, go = 0; a = a_;

            if (a_ > 98765)
                break;

            if (a_ < 1234)
                continue;

            if (b < 10000){

                if (a < 10000)
                    continue;

                else
                    x[0] = 1;
            }

            else {

                if (a < 10000)
                    x[0] = 1;
            }

            while (a_ > 0){

                if (x[a_ % 10]){

                    go = 1; break;
                }

                x[a_ % 10] = 1; a_ /= 10;
            }

            while ((b_ > 0) & !go){

                if (x[b_ % 10]){

                    go = 1; break;
                }

                x[b_ % 10] = 1; b_ /= 10;
            }

            if (go) continue;

            cw++;
            printf("%0.5d / %0.5d = %d\n", a, b, n);
        }

        if (cw == 0)
            printf("There are no solutions for %d.\n", n);
    }

    return 0;
}

