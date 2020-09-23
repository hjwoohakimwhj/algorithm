package greedy;

import java.util.Arrays;

public class Substring {
    //392
    public boolean isSubsequence(String s, String t) {
        int sNum = s.length();
        int tNum = t.length();
        int sIndex = 0;
        int tIndex = 0;
        while((sIndex < sNum) && (tIndex < tNum)){
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == sNum;
    }

    //455
    public static int findContentChildren(int[] grid, int[] size) {
        if (grid == null || size == null) return 0;
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0, si = 0;
        while (gi < grid.length && si < size.length) {
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(findContentChildren(g, s));
    }
}
