/*

    Author: Muhammad Mustafa
    
    Problem: 
                E. Packmen
                2017-2018 ACM-ICPC, NEERC, Southern Subregional Contest, qualification stage (Online Mirror, ACM-ICPC Rules)
                https://codeforces.com/contest/847/problem/E

    - We can binary search on time to get the minimum possible time, and this is possible because of the fact that
      in O(n) we can determine if it is possible for all Ps to get all *s in the given time, so the order is nlogC,
      we can determine this greedly by eating for each P from left to right, all possible *s (starting with the first available *) 
      in the range of this P (before and after it without exceeding other Ps), and if we left no *s behind, then this time is possible.

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


string str; int n;

int possible(int x){

    int l = -1, m = -1;

    for (int i = 0; i < n; i ++){

        if (str[i] == 'P'){

            if (m == -1){

                m = i;

                if (l == -1){

                    l = i;
                }
            }

            else {

                m = l = i;
            }
        }

        else if (str[i] == '*'){

            if (l == -1){

                l = i;
            }
        }

        if (l == -1) { continue; }

        else {

            if (m == -1){

                if ((abs(i - l) + 1) > x){

                    return 0;
                }
            }

            else {

                if (( min(abs(m - l), abs(m - i)) + abs(m - l) + abs(m - i) ) == x){

                    l = m = -1;
                }

                else if (( min(abs(m - l), abs(m - i)) + abs(m - l) + abs(m - i) ) > x){

                    if (str[i] == '.') l = m = -1;
                    if (str[i] == '*') m = -1, l = i;
                }
            }
        }
    }

    if ((l != -1) && (m == -1)) return 0;

    return 1;
}

int main() {

    //freopen("in.in", "r", stdin);
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    cin >> n >> str;

    int start = 1, end = 1e8, mid;

    while (end - start > 10){

        mid = start + (end - start) / 2;
        if (possible(mid)) end = mid;
        else start = mid + 1;
    }

    for (mid = start; mid <= end; mid++){

        if (possible(mid)){
            start = mid;
            break;
        }
    }

    cout << start << '\n';

    return 0;
}
