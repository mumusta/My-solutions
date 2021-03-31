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
#define EPS 1e-9
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
//#define polar(r,t) ((LD)(r) * exp(point(0, (t))))
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
#define Dist(a,b) ((LD)hypot(b.X-a.X,b.Y-a.Y))
#define pbits(long,num) { bitset <long> TTT(num); cout << TTT.to_string() << endl; }
#define pvec(a) { for (int TTT = 0; TTT < a.size(); TTT++) cout << a[TTT] << "\n"; }
#define sqDist(p1,p2) ((ll)((ll)((p2.X-p1.X)*(p2.X-p1.X))+(ll)((p2.Y-p1.Y)*(p2.Y-p1.Y))))
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
//using namespace __gnu_pbds;
using namespace std;
typedef complex < LD > point; /*template <typename T> using ordered_set =
tree<T, null_type, less<T>, rb_tree_tag, tree_order_statistics_node_update>;*/
point read_point(){ LD x, y; cin >> x >> y; return point(x, y); }
int dcmp(LD a, LD b){ return fabs(a - b) < EPS ? 0 : a < b ? -1 : 1; }






            /*                                Listen!                                */



vector < point > s, e, m, p;

bool isCollinear(const point& a, const point& b, const point& p){
    return fabs(cross(vec(a,b),vec(a,p))) < EPS;
}

bool pointOnRay(const point& a, const point& b, const point& p){
    return dot(vec(a,p), vec(a,b)) > -EPS && isCollinear(a, b, p);
}

bool pointOnSegment(const point& a, const point& b, const point& p){
    return pointOnRay(a,b,p) && pointOnRay(b,a,p);
}

bool intersectLines(const point &a, const point &b,
               const point &c, const point &d, point &intersect){
    LD d1 = cross(a-b,d-c), d2 = cross(a-c,d-c); LD t1 = d2 / d1;
    if (fabs(d1) < EPS) return false; //parallel or identical or not line
    intersect = a + (b - a) * t1; return true;
}

map < LL, LL > nx;

#define gro (-1000000000)

int res;

void go(LL pr){ res = pr.fi; //cout << pr.fi << " " << pr.se << endl;
    auto it = nx.find(pr);
    if (it == nx.end() || pr.se == gro) return; go(nx[pr]);
}

int main() {
   // ______________________________________________________________________
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);


    int t; cin >> t;

    for (int tt = 0 ; tt < t; tt ++){
            if (tt != 0) cout << endl;

        int ns = 0, np = 0; s.clear();
        e.clear(); p.clear(); m.clear(); nx.clear();

        cin >> ns;

        for (int i = 0 ; i < ns; i ++){
            point p_ = read_point(); point p__ = read_point();
            s.pp(p_); e.pp(p__); m.pp((p_.Y < p__.Y) ? p_ : p__);
        }

        cin >> np;

        for (int i = 0 ; i < np ; i ++){
            point p_ = read_point(); p.pp(p_);
        }

        for (int i = 0 ; i < np; i ++){
            LD y = gro; int is = 0, who; LL nex;
            for (int ii = 0 ; ii < ns; ii ++){
                point in;
                intersectLines(s[ii], e[ii], p[i], p[i] + point(0,1), in);
                if (!pointOnSegment(s[ii], e[ii], in)) continue;
                if ((dcmp(in.Y, p[i].Y) == -1 || dcmp(in.Y, p[i].Y) == 0) &&
                    dcmp(in.Y, y) == 1) {
                        y = in.Y; is = 1; who = ii;
                    }
            }
            if (is) nex = mp(m[who].X, m[who].Y);
            else nex = mp(p[i].X, gro);
            nx[mp(p[i].X, p[i].Y)] = nex;
        }

        for (int i = 0 ; i < ns; i ++){
                LL now = mp(m[i].X, m[i].Y);
                auto it = nx.find(now);
                if (it != nx.end()) continue;
            LD y = gro; int is = 0, who; LL nex;
            for (int ii = 0 ; ii < ns; ii ++){
                if (i == ii) continue;
                point in;
                intersectLines(s[ii], e[ii], m[i], m[i] + point(0,1), in);
                if (!pointOnSegment(s[ii], e[ii], in)) continue;
                if (dcmp(in.Y, m[i].Y) == -1 && dcmp(in.Y, y) == 1) {
                        y = in.Y; is = 1; who = ii;
                    }
            }
            if (is) nex = mp(m[who].X, m[who].Y);
            else nex = mp(m[i].X, gro);
            nx[now] = nex;
        }

        for (int i = 0 ; i < np; i ++)
            go(mp(p[i].X, p[i].Y)), cout << res << endl;


    }

   // ___________________________________________________________________________
    return 0;
}
