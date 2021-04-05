/**
 * Author: Per Austrin, Simon Lindholm
 * Date: 2004-02-08
 * License: CC0
 * Description: Solves $A * x = b$. If there are multiple solutions, an arbitrary one is returned.
 *  Returns rank, or -1 if no solutions. Data in $A$ and $b$ is lost.
 * Time: O(n^2 m)
 * Status: tested on kattis:equationsolver, and bruteforce-tested mod 3 and 5 for n,m <= 3
 */
#pragma once

typedef vector<double> vd;
const double eps = 1e-12;

int solveLinear(vector<vd>& A, vd& b, vd& x) {
	int n = A.size(), m = x.size(), rank = 0, br, bc;
	if (n) assert(A[0].size() == m);
	// FOR(i, 0, n) FOR(j, 0, m) A[i][j] %= MOD; also b[i]...
	vi col(m); iota(col.begin(), col.end(), 0);

	FOR(i,0,n) {
		double v, bv = 0;
		FOR(r,i,n) FOR(c,i,m)
			if ((v = fabs(A[r][c])) > bv)
				br = r, bc = c, bv = v;
		if (bv <= eps) {
			FOR(j,i,n) if (fabs(b[j]) > eps) return -1;
			break;
		}
		swap(A[i], A[br]);
		swap(b[i], b[br]);
		swap(col[i], col[bc]);
		FOR(j,0,n) swap(A[j][i], A[j][bc]);
		bv = 1/A[i][i];
		FOR(j,i+1,n) {
			double fac = A[j][i] * bv;
			b[j] -= fac * b[i];
			FOR(k,i,m) A[j][k] -= fac*A[i][k];
		}
		rank++;
	}

	x.assign(m, 0);
	for (int i = rank; i--;) {
		b[i] /= A[i][i];
		x[col[i]] = b[i];
		FOR(j,0,i) b[j] -= A[j][i] * b[i];
	}
	return rank; // (multiple solutions if rank < m)
}
