/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return buildQuadTree(grid, 0, 0, grid.length);
    }

    private Node buildQuadTree(int[][] grid, int row, int col, int size) {
        // Base Case: If all values in the sub-grid are the same, return a leaf node
        if (isUniform(grid, row, col, size)) {
            return new Node(grid[row][col] == 1, true);
        }

        // Recursive Case: Divide into four quadrants
        int half = size / 2;
        Node topLeft = buildQuadTree(grid, row, col, half);
        Node topRight = buildQuadTree(grid, row, col + half, half);
        Node bottomLeft = buildQuadTree(grid, row + half, col, half);
        Node bottomRight = buildQuadTree(grid, row + half, col + half, half);

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private boolean isUniform(int[][] grid, int row, int col, int size) {
        int value = grid[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }

     public void printQuadTree(Node root) {
    if (root == null) return;
    if (root.isLeaf) {
        System.out.println("Leaf Node: " + (root.val ? "1" : "0"));
    } else {
        System.out.println("Parent Node");
        printQuadTree(root.topLeft);
        printQuadTree(root.topRight);
        printQuadTree(root.bottomLeft);
        printQuadTree(root.bottomRight);
        }
}
}