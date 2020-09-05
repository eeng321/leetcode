class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int numFresh = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(grid[i][j] == 1){
                    numFresh++;
                }
                if(grid[i][j] == 2){
                    queue.add(new int[] {i,j});
                }
            }
        }
        int minutes = 0;
        while(queue.size() > 0 && numFresh > 0){
            int size = queue.size();
            minutes++;
            for(int i = 0; i < size; i++){
                int[] rotten = queue.poll();
                for(int[] dir : directions) {
                    int row = rotten[0] + dir[0];
                    int col = rotten[1] + dir[1];
                    
                    if(row < 0 || row >= rowLen || col < 0 || col >= colLen || grid[row][col] == 0 || grid[row][col] == 2){
                        continue;
                    }
                    queue.add(new int[] {row, col});
                    numFresh--;
                    grid[row][col] = 2;
                }
            }
        }
        return numFresh == 0 ? minutes : -1;
    }
}