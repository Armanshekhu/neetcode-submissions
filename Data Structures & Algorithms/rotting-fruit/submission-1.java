class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        Queue<int[]> q= new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1) {
                    fresh++;
                } else if(grid[i][j]==2) {
                    q.offer(new int[]{i,j});
                }
            }
        }

        int neighbour[][] = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };
        int time=0;
        while(!q.isEmpty() && fresh>0) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int ng[] : neighbour) {
                    int rn = r + ng[0];
                    int cn = c + ng[1];
                    if(rn>=0 && cn>=0 && rn<=m-1 && cn<=n-1 && grid[rn][cn]==1) {
                        fresh--;
                        grid[rn][cn]=2;
                        q.offer(new int[]{rn,cn});
                    }
                }
            }
            time++;
        }
        return fresh==0 ? time : -1;
    }
}
