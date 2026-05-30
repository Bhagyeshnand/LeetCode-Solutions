import java.util.*;

class Solution {
    class SegmentTreeNode {
        SegmentTreeNode leftChild;
        SegmentTreeNode rightChild;
        int start;
        int end;
        int maxFreeSpace = 0;
        int nearestObstacle = Integer.MAX_VALUE;

        SegmentTreeNode(int start, int end, int obstaclePosition) {
            this.start = start;
            this.end = end;
            this.nearestObstacle = obstaclePosition;
            this.maxFreeSpace = obstaclePosition == Integer.MAX_VALUE ? Integer.MAX_VALUE : obstaclePosition - start;
        }

        void printTree() {
            System.out.print("[" + start + "-" + end + ": " + nearestObstacle + ", " + maxFreeSpace);
            if (leftChild != null) {
                System.out.print(" -- ");
                leftChild.printTree();
                rightChild.printTree();
                System.out.print(" -- " + start + "-" + end);
            }
            System.out.print("]");
        }
    }
    
    public List<Boolean> getResults(int[][] queries) {
        int maxRange = 0;
        for (int[] query : queries) {
            if (query[0] == 1) {
                maxRange = Math.max(maxRange, query[1]);
            }
        }
        SegmentTreeNode root = new SegmentTreeNode(0, maxRange, Integer.MAX_VALUE);
        List<Boolean> results = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) {
                addObstacle(root, query[1]);
            } else {
                int blockStart = query[1] - query[2];
                if (blockStart >= root.end) {
                    results.add(true);
                } else {
                    results.add(isBlockPlaceable(root, blockStart, query[2]));
                }
            }
        }
        return results;
    }

    boolean isBlockPlaceable(SegmentTreeNode root, int blockStart, int blockSize) {
        if (root.leftChild == null && root.rightChild == null) {
            if (blockStart >= root.end) {
                return blockSize <= root.maxFreeSpace;
            } else if (blockStart < root.start) {
                return false;
            } else {
                return blockSize <= (root.nearestObstacle - root.start);
            }
        }

        if (root.rightChild.end <= blockStart) {
            if (root.rightChild.maxFreeSpace >= blockSize) {
                return true;
            }
        }
        if (root.leftChild.end <= blockStart) {
            if (root.leftChild.maxFreeSpace >= blockSize) {
                return true;
            }
        } else {
            return isBlockPlaceable(root.leftChild, blockStart, blockSize);
        }
        if (root.rightChild.start <= blockStart && root.rightChild.end >= blockStart) {
            return isBlockPlaceable(root.rightChild, blockStart, blockSize);
        }

        return false;
    }

    int addObstacle(SegmentTreeNode root, int obstaclePosition) {
        if (root.end == root.start) {
            root.nearestObstacle = (root.end < obstaclePosition && obstaclePosition < root.nearestObstacle) ? obstaclePosition : root.nearestObstacle;
            root.maxFreeSpace = root.nearestObstacle == Integer.MAX_VALUE ? root.nearestObstacle : root.nearestObstacle - root.start;
            return root.maxFreeSpace;
        }
        if (obstaclePosition <= root.start) return root.maxFreeSpace;
        if (obstaclePosition > root.end) {
            if (obstaclePosition < root.nearestObstacle) {
                root.nearestObstacle = obstaclePosition;
                if (root.leftChild == null && root.rightChild == null) {
                    root.maxFreeSpace = (obstaclePosition - root.start);
                } else {
                    root.maxFreeSpace = Math.max(addObstacle(root.leftChild, obstaclePosition), addObstacle(root.rightChild, obstaclePosition));
                }
            }
            return root.maxFreeSpace;
        }
        if (root.leftChild != null && root.rightChild != null) {
            root.maxFreeSpace = Math.max(addObstacle(root.leftChild, obstaclePosition), addObstacle(root.rightChild, obstaclePosition));
            return root.maxFreeSpace;
        }
        int mid = (root.end - root.start) / 2 + root.start;
        root.leftChild = new SegmentTreeNode(root.start, mid, root.nearestObstacle);
        root.rightChild = new SegmentTreeNode(mid + 1, root.end, root.nearestObstacle);
        root.maxFreeSpace = Math.max(addObstacle(root.leftChild, obstaclePosition), addObstacle(root.rightChild, obstaclePosition));
        return root.maxFreeSpace;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] queries = {{1, 5}, {2, 7, 2}, {2, 6, 2}};
        System.out.println(solution.getResults(queries));  // Output: [false, true]
    }
}