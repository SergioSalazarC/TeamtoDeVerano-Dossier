/**
 * Author: Isaac
 * Date:
 * Description: Return true if two quadrangles intersect
 * Time: O(1)
 */
int hasIntersectQuadrangles(int lx, int ly, int rx, int ry, int la, int lb, int ra, int rb) {
    lx = lxsol = max(lx, la);
    ly = lysol = max(ly, lb);
    rx = rxsol = min(rx, ra);
    ry = rysol = min(ry, rb);
    return lx < rx && ly < ry;
}