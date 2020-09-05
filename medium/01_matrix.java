class Point {
    int x;
    int y;
    public Point(int row, int col){
        x = row;
        y = col;
    } 
}

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] = getDistanceFromNearestZero(matrix, new Point(i,j));   
                }
            }
        }
        return matrix;
    }
    
    public int getDistanceFromNearestZero(int[][] matrix, Point start){
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        int distance = 0;
    
        while(queue.size() > 0) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Point cell = queue.remove();
                if(cell == null || cell.x < 0 || cell.x >= matrix.length || cell.y < 0 || cell.y >= matrix[0].length) {
                    continue;
                }
                if(matrix[cell.x][cell.y] == 0) {
                    return distance;
                }
                queue.add(new Point(cell.x - 1, cell.y));
                queue.add(new Point(cell.x + 1, cell.y));
                queue.add(new Point(cell.x, cell.y - 1));
                queue.add(new Point(cell.x, cell.y + 1));
            }
            distance++;
        }
        return -1; // shouldn't get here
    }
}