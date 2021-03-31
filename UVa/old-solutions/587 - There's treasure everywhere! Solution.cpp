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
#define pvec(a) { for (int TTT = 0; TTT < a.size(); TTT++) cout << a[TTT] << " "; cout << '\n'; }
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
using namespace __gnu_pbds; using namespace std;
typedef complex < LD > point; template <typename T> using ordered_set =
tree<T, null_type, less<T>, rb_tree_tag, tree_order_statistics_node_update>;
point read_point(){ LD x, y; cin >> x >> y; return point(x, y); }
int dcmp(LD a, LD b){ return fabs(a - b) < EPS ? 0 : a < b ? -1 : 1; }







            /*                                Listen!                                */


LD toRadians(LD degree){ return (degree * PI / 180.0); }

LD toDegree(LD radian){ if (radian < 0) radian += 2 * PI;
    return (radian * 180.0 / PI); }


int main() {
  //  ______________________________________________________________________
   // ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);


    int tt = 1; string str;

    while (cin >> str){
        if (str == "END") break;

        int n = str.length(); LD sq2 = sqrt(2);
        cout << "Map #" << tt++ << '\n';

        ll ln = 0; string dr = ""; point cr(0, 0);

        for (int i = 0 ; i < n ; i ++){
            if ('0' <= str[i] && str[i] <= '9'){
                ln *= 10; ln += ( (int)(str[i] - '0') );
            }
            else {
                if ('A' <= str[i] && str[i] <= 'Z'){
                    dr.pp(str[i]);
                }
                else {
                    if (str[i] == '.' || str[i] == ','){
                        if (dr == "N"){
                            cr += ( ((LD)ln * point(0, 1))  );
                        }
                        if (dr == "NE"){
                            cr += ( ((LD)ln * point(1, 1)) / sq2 );
                        }
                        if (dr == "E"){
                            cr += ( ((LD)ln * point(1, 0))  );
                        }
                        if (dr == "SE"){
                            cr += ( ((LD)ln * point(1, -1)) / sq2 );
                        }
                        if (dr == "S"){
                            cr += ( ((LD)ln * point(0, -1))  );
                        }
                        if (dr == "SW"){
                            cr += ( ((LD)ln * point(-1, -1)) / sq2 );
                        }
                        if (dr == "W"){
                            cr += ( ((LD)ln * point(-1, 0))  );
                        }
                        if (dr == "NW"){
                            cr += ( ((LD)ln * point(-1, 1)) / sq2 );
                        }
                        ln = 0; dr = "";
                    }
                    else continue;
                }
            }
        }

        cout << fixed << sp(3) << "The treasure is located at ("
             << cr.X << "," << cr.Y << ").\nThe distance to the treasure is "
             << Dist(point(0,0), cr) << ".\n\n";
    }


   // ___________________________________________________________________________
    return 0;
}
