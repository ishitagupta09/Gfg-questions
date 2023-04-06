class Solution {
  public:
    int unvisitedLeaves(int N, int leaves, int frogs[]) {
        // Code here
        std::bitset<1000000> visited;
    for (int i = 0; i < N; i++) {
        int num = frogs[i];
        if (num <= leaves && !visited[num]) {
            for (int j = num; j <= leaves; j += num) {
                visited.set(j);
            }
        }
    }
    int unvisited =leaves - visited.count();
  
    return unvisited;
    }
};
