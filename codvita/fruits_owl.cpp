#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
#include <iomanip>

using namespace std;

double distance(int x1, int y1, int x2, int y2) {
    return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
}

int crossProduct(const vector<int>& a, const vector<int>& b, const vector<int>& c) {
    return (b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0]);
}

int main() { 
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    int N;
    cin >> N;

    vector<vector<int>> points(N, vector<int>(2));
    for (int i = 0; i < N; i++) {
        cin >> points[i][0] >> points[i][1];
    }

    sort(points.begin(), points.end(), [](const vector<int>& a, const vector<int>& b) {
        return (a[0] == b[0]) ? a[1] < b[1] : a[0] < b[0];
    });

    vector<vector<int>> lowerHull;
    for (const auto& point : points) {
        while (lowerHull.size() >= 2 &&
               crossProduct(lowerHull[lowerHull.size() - 2],
                            lowerHull[lowerHull.size() - 1], point) <= 0) {
            lowerHull.pop_back();
        }
        lowerHull.push_back(point);
    }

    double perimeter = 0.0;
    for (size_t i = 0; i < lowerHull.size() - 1; i++) {
        perimeter += distance(lowerHull[i][0], lowerHull[i][1],
                               lowerHull[i + 1][0], lowerHull[i + 1][1]);
    }

    cout << fixed << setprecision(0) << round(perimeter) << endl;

    return 0;
}