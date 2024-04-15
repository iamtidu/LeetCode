class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int n = matrix.length;
        
        // Traverse each layer from outer to inner
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            
            // Rotate each element in the current layer
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                
                // Move left to top
                matrix[first][i] = matrix[last - offset][first];
                
                // Move bottom to left
                matrix[last - offset][first] = matrix[last][last - offset];
                
                // Move right to bottom
                matrix[last][last - offset] = matrix[i][last];
                
                // Move top to right
                matrix[i][last] = top;
            }
        }
    }
}
