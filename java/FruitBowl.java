#include <iostream>
#include <vector>
#include <queue>
#include <set>
#include <cmath>
#include <tuple>

using namespace std;

int simulate_gravity(int start_x, int start_y, const vector<vector<char>>& matrix, int N, int M) {
    while (start_x + 1 < N && matrix[start_x + 1][start_y] != 'B') {
        start_x++;
    }
    return start_x;
}

vector<tuple<int, int, int>> bfs(int start_x, int start_y, const vector<vector<char>>& matrix, int N, int M, int K) {
    queue<tuple<int, int, int>> q;
    q.push({start_x, start_y, 0});

    set<pair<int, int>> visited;
    visited.insert({start_x, start_y});

    vector<tuple<int, int, int>> reachable_cells;

    while (!q.empty()) {
        int x, y, moves;
        tie(x, y, moves) = q.front();
        q.pop();

        if (matrix[x][y] == 'E' && x != N - 1 && moves <= K) { // Check moves within K
            reachable_cells.push_back({x, y, moves});
        }

        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};

        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny < M && ny >=0 && visited.find({nx, ny}) == visited.end() && matrix[nx][ny] != 'B') {
                q.push({nx, ny, moves + 1});
                visited.insert({nx, ny});
            }
        }
    }

    return reachable_cells;
}

vector<pair<int, int>> find_farthest_cells(const vector<tuple<int, int, int>>& reachable_cells, int start_x, int start_y) {
    int farthest_distance = -1;
    vector<pair<int, int>> farthest_cells;

    for (const auto& cell : reachable_cells) {
        int x, y, moves;
        tie(x, y, moves) = cell;
        int manhattan_distance = abs(x - start_x) + abs(y - start_y);

        if (manhattan_distance > farthest_distance) {
            farthest_distance = manhattan_distance;
            farthest_cells.clear();
            farthest_cells.push_back({x, y});
        } else if (manhattan_distance == farthest_distance) {
            farthest_cells.push_back({x, y});
        }
    }

    return farthest_cells;
}

pair<vector<pair<int, int>>, pair<int,int>> farthest_reach(int N, int M, const vector<vector<char>>& matrix, int K) {
    int start_x = -1, start_y = -1;

    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            if (matrix[i][j] == 'S') {
                start_x = i;
                start_y = j;
                break;
            }
        }
        if (start_x != -1) break;
    }

    if (start_x == -1) {
        return {{}, {-1,-1}};
    }

    start_x = simulate_gravity(start_x, start_y, matrix, N, M);

    vector<tuple<int, int, int>> reachable_cells = bfs(start_x, start_y, matrix, N, M, K);
    vector<pair<int, int>> farthest_cells = find_farthest_cells(reachable_cells, start_x, start_y);

    return {farthest_cells, {start_x, start_y}};
}

int main() {
    int N, M, K;

    cout << "Enter the number of rows (N): ";
    cin >> N;
    cout << "Enter the number of columns (M): ";
    cin >> M;
    cout << "Enter the maximum number of moves (K): ";
    cin >> K;

    vector<vector<char>> matrix(N, vector<char>(M));
    cout << "Enter the matrix (each row on a new line, characters separated by spaces):" << endl;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            cin >> matrix[i][j];
        }
    }

    pair<vector<pair<int, int>>, pair<int, int>> result = farthest_reach(N, M, matrix, K);

    if (result.second.first != -1) {
        cout << "Start position after gravity: (" << result.second.first << ", " << result.second.second << ")" << endl;
        if (!result.first.empty()) {
            cout << "Farthest reachable cells:" << endl;
            for (const auto& cell : result.first) {
                cout << "(" << cell.first << ", " << cell.second << ")" << endl;
            }
        } else {
            cout << "No reachable stable cells found within K moves." << endl;
        }
    } else {
        cout << "No starting position 'S' found." << endl;
    }

    return 0;
}