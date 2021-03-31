#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <cstring>
#include <vector>
#include <deque>
#include <cctype>
#include <algorithm>
#include <map>
#include <set>
#include <stack>
#include <queue>
#include <iomanip>
#include <sstream>
#include <cmath>
#include <bitset>
#include <unordered_map>
#include <unordered_set>
#include <functional>
#include <fstream>
#include <utility>
#include <cmath>
#include <complex>
#include <bits/stdc++.h>
#include<ext/pb_ds/assoc_container.hpp>
#include<ext/pb_ds/tree_policy.hpp>
#include <time.h>


#define fi first
#define X real()
#define Y imag()
#define EPS 1e-10
#define se second
#define len length
#define cinn scanf
#define mp make_pair
#define pp push_back
#define coutt printf
#define pf push_front
#define LL pair <ll, ll>
#define II pair <int, int>
#define PI ((LD)(acos(-1.0)))
#define sp(a) setprecision(a)
#define at(a) find_by_order(a)
#define ALL(a) a.begin(), a.end()
#define less_than(a) order_of_key(a)
#define mm(a,b) memset(a, b, sizeof a)
#define cwbits(a) __builtin_popcountll(a)
#define Rad(deg) ((LD)(deg * PI / (180.0)))
#define vec(a,b) ((b) - (a))
#define polar(r,t) ((r) * exp(point(0, (t))))
#define angle(v) (atan2((v).Y, (v).X))
//#define length(v) ((LD)hypot((v).Y, (v).X))
#define lengthSqr(v) (dot(v, v))
#define dot(a,b) ((conj(a) * (b)).real())
#define cross(a,b) ((conj(a) * (b)).imag())
#define rotate(v,t) (polar(v, t))
#define rotateabout(v,t,a) (rotate(vec(a, v), t) + (a))
#define reflect(p,m) ((conj((p) / (m))) * (m))
#define normalize(p) ((p) / length(p))
#define same(a,b) (lengthSqr(vec(a, b)) < EPS)
#define mid(a,b) (((a) + (b)) / point(2, 0))
#define perp(a) (point(-(a).Y, (a).X))
#define distE(a,b) ((LD)hypot(b.X-a.X,b.Y-a.Y))
#define pbits(long,num) { bitset <long> TTT(num); cout << TTT.to_string() << endl; }
#define pvec(a) { for (int TTT = 0; TTT < a.size(); TTT++) cout << a[TTT] << " "; cout << '\n'; }
#define sqdistE(p1,p2) ((ll)((ll)((p2.X-p1.X)*(p2.X-p1.X))+(ll)((p2.Y-p1.Y)*(p2.Y-p1.Y))))
#define DBG1(a)           cout<<#a<<"="<<(a)<<"\n"
#define DBG2(a,b)         cout<<#a<<"="<<(a)<<", "<<#b<<"="<<(b)<<"\n"
#define DBG3(a,b,c)       cout<<#a<<"="<<(a)<<", "<<#b<<"="<<(b)<<", "<<#c<<"="<<(c)<<"\n"
#define DBG4(a,b,c,d)     cout<<#a<<"="<<(a)<<", "<<#b<<"="<<(b)<<", "<<#c<<"="<<(c)<<", "<<#d<<"="<<(d)<<"\n"
#define DBG5(a,b,c,d,e)   cout<<#a<<"="<<(a)<<", "<<#b<<"="<<(b)<<", "<<#c<<"="<<(c)<<", "<<#d<<"="<<(d)<<", "<<#e<<"="<<(e)<<"\n"
#define DBG6(a,b,c,d,e,f) cout<<#a<<"="<<(a)<<", "<<#b<<"="<<(b)<<", "<<#c<<"="<<(c)<<", "<<#d<<"="<<(d)<<", "<<#e<<"="<<(e)<<", "<<#f<<"="<<(f)<<"\n"
#define ______________________________________________________________________ freopen("in.in", "r", stdin); freopen("out.out", "w", stdout);
#define ___________________________________________________________________________ cout << fixed << sp(5) << "Time: " << clock() / (CLOCKS_PER_SEC * 1.0);


typedef long double LD;
typedef long long int ll;
typedef unsigned long long int ull; // &ret
using namespace __gnu_pbds; using namespace std;
typedef complex < LD > point; template <typename T> using ordered_set =
tree<T, null_type, less<T>, rb_tree_tag, tree_order_statistics_node_update>;
int dcmp(LD a, LD b){ return fabs(a - b) <= EPS ? 0 : a < b ? -1 : 1; }





            /*                                Listen!                                */


struct p3d {
    int x, y, z; p3d() { x = y = z = 0; }
    p3d(LD _x, LD _y, LD _z) : x(_x), y(_y), z(_z) {}
};

LD dist(p3d p1, p3d p2){
    return sqrt( (p2.x - p1.x) * (p2.x - p1.x) +
                 (p2.y - p1.y) * (p2.y - p1.y) +
                 (p2.z - p1.z) * (p2.z - p1.z) );
}

int main() {
    //______________________________________________________________________
    //ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);


    int x, y, z;

    vector < p3d > seq;

    while (cin >> x >> y >> z){
        if (x + y + z == 0) break;
        seq.pp(p3d(x, y, z));
    }

    int n = seq.size(), res[10] = { 0 };

    for (int i = 0 ; i < n; i ++){
        LD minima = 1e9;
        for (int ii = 0 ; ii < n ; ii ++){
            if (i == ii) continue;
            LD d = dist(seq[i], seq[ii]);
            minima = min(minima, d);
        }
        int mini = minima;
        if (mini < 10) res[mini]++;
    }

    for (int i = 0 ; i < 10 ; i ++)
        coutt("%4d", res[i]); cout << endl;

    //___________________________________________________________________________
    return 0;
}
