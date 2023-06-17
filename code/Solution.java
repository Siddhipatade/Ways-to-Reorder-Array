import java.util.*;

class Solution {
    private static final long MOD = (long) 1e9 + 7;
    private long[][] table;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        int result = solution.numOfWays(nums);
        System.out.println("Number of ways to reorder nums: " + result);
    }

    public int numOfWays(int[] nums) {
        int m = nums.length;

        // Table of Pascal's triangle
        table = new long[m][m];
        for (int i = 0; i < m; ++i) {
            table[i][0] = table[i][i] = 1;
        }
        for (int i = 2; i < m; i++) {
            for (int j = 1; j < i; j++) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % MOD;
            }
        }
        List<Integer> arrList = new ArrayList<>();
        for (int num : nums) {
            arrList.add(num);
        }
        return (int) ((dfs(arrList) - 1) % MOD);
    }

    private long dfs(List<Integer> nums) {
        int m = nums.size();
        if (m < 3) {
            return 1;
        }

        List<Integer> leftNodes = new ArrayList<>();
        List<Integer> rightNodes = new ArrayList<>();
        for (int i = 1; i < m; ++i) {
            if (nums.get(i) < nums.get(0)) {
                leftNodes.add(nums.get(i));
            } else {
                rightNodes.add(nums.get(i));
            }
        }
        long leftWays = dfs(leftNodes) % MOD;
        long rightWays = dfs(rightNodes) % MOD;

        return (((leftWays * rightWays) % MOD) * table[m - 1][leftNodes.size()]) % MOD;
    }
}
