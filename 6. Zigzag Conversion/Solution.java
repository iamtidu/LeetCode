class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s; // If numRows is 1, return the original string
        }
        
        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }
        
        int currRow = 0;
        boolean goingDown = false;
        
        for (char c : s.toCharArray()) {
            rows[currRow].append(c); // Append the character to the current row
            
            // Change direction if reaching the top or bottom row
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            // Move to the next row based on the direction
            currRow += goingDown ? 1 : -1;
        }
        
        // Concatenate all rows to form the final converted string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }
}
