class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int fresh=0;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1) {
                    fresh++;
                } else if(grid[i][j]==2) {
                    q.offer(new int[]{i,j});
                }
            }
        }

        int dir[][] = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        int time = 0;
        while(!q.isEmpty() && fresh>0) {
            int size=q.size();
            for(int i=0;i<size;i++) {
                int c[] = q.poll();
                int r = c[0];
                int C = c[1];
                for(int d[] : dir) {
                    int rn = r + d[0];
                    int cn = C + d[1];
                    if(rn>=0 && cn>=0 && rn<=m-1 && cn<=n-1 && grid[rn][cn]==1) {
                        grid[rn][cn]=2;
                        fresh--;
                        q.offer(new int[]{rn,cn});
                    }
                }
            }
            time++;
        }
        return fresh==0 ? time : -1;
    }
}
