class Solution {
    int m,n;
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                boolean visited[][] = new boolean[m][n];
                boolean pacific = dfs(heights,i,j,visited,true);

                visited = new boolean[m][n];
                boolean atlantic = dfs(heights,i,j,visited,false);
                if(pacific && atlantic) {
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        return list;
    }
    public boolean dfs(int heights[][], int i, int j, boolean visited[][], boolean pacific) {
        if(pacific && (i==0 || j==0)) {
            return true;
        } 

        if(!pacific && (i==m-1 || j==n-1)) {
            return true;
        }

        visited[i][j] = true;

        int dir[][] = {
            {0,-1},
            {0,1},
            {-1,0},
            {1,0}
        };

        for(int d[] : dir) {
            int r = d[0] + i;
            int c = d[1] + j;
if(r>=0 && c>=0 && r<m && c<n && !visited[r][c] && heights[r][c]<=heights[i][j]) {
                if(dfs(heights,r,c,visited,pacific)) {
                    return true;
                }
            }
        }
        return false;
    }
}
