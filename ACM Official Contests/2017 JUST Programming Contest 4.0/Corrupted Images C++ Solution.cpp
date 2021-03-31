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
#define pvec(a) { for (int TTT = 0; TTT < a.size(); TTT++) cout << a[TTT] << "\n"; }
#define sqDist(p1,p2) ((ll)((ll)((p2.X-p1.X)*(p2.X-p1.X))+(ll)((p2.Y-p1.Y)*(p2.Y-p1.Y))))
#define _ cout << fixed << sp(5) << "Time: " << clock() / (CLOCKS_PER_SEC * 1.0) << '\n';


typedef long double LD;
typedef long long int ll;
typedef unsigned long long int ull; // &ret
using namespace __gnu_pbds; using namespace std;
typedef complex < LD > point; /*template <typename T> using ordered_set =
tree<T, null_type, less<T>, rb_tree_tag, tree_order_statistics_node_update>;*/
point read_point(){ LD x, y; cin >> x >> y; return point(x, y); }
int dcmp(LD a, LD b){ return fabs(a - b) < EPS ? 0 : a < b ? -1 : 1; }




int main() {

	
	int t; string grid[55]; scanf("%d", &t);

	for (int tt = 0; tt < t; tt ++){
		int n, m, b = 0, e = 0, c = 0; scanf("%d%d", &n, &m);

		for (int i = 0; i < n; i ++){
			cin >> grid[i];

			for (int ii = 0; ii < m; ii ++)
				if (grid[i][ii] == '1') b++;
		}

		for (int i = 0; i < n; i ++){
			if (grid[i][0] == '1') e++;
			else c ++;
		}

		for (int i = 0; i < n; i ++){
			if (grid[i][m - 1] == '1') e++;
			else c ++;
		}

		for (int ii = 1; ii < (m - 1); ii ++){
			if (grid[0][ii] == '1') e++;
			else c ++;
		}

		for (int ii = 1; ii < (m - 1); ii ++){
			if (grid[n - 1][ii] == '1') e++;
			else c ++;
		}

		if (c > 0){
			if ((b - e) >= c) printf("%d\n", c);
			else printf("-1\n");
		}
		else printf("0\n");
	}

//	_
	return 0;
}
