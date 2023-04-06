class Solution {
    static class Node{
        int i;
        int j;
        public Node(int i , int j){
            this.i = i;
            this.j = j;
        }
    }
    public static int shortestXYDist(ArrayList<ArrayList<Character>> arr, int N,int M) {
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int rows = arr.size();
        int cols = arr.get(0).size();
        int[][] dis = new int[rows][cols];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                dis[i][j] = 1000000;
            }
        }
        Queue<Node> queue = new LinkedList<>();
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(arr.get(i).get(j) == 'X'){
                    queue.offer(new Node(i , j));
                    dis[i][j] = 0;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int i = curNode.i;
            int j = curNode.j;
            if(arr.get(i).get(j) == 'Y'){
                ans = Math.min(ans , dis[i][j]);
                continue;
            }
            for(int ptr = 0 ; ptr < 4 ; ptr++){
                int I = i + dir[ptr][0];
                int J = j + dir[ptr][1];
                if(I < rows && I >= 0 && J < cols && J >= 0 && dis[I][J] > dis[i][j] + 1){
                    dis[I][J] = dis[i][j] + 1;
                    queue.offer(new Node(I,J));
                }
            }
        }
        return ans;
    }
}
