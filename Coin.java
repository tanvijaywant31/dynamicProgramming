
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


//A Naive recursive JAVA program to find minimum of coins
//to make a given change V
class Coin {

    // m is size of coins array (number of different coins)
    // m is size of coins array (number of different coins)
    public static int minCoins(int[] coins, int m, int V) {
        // table[i] will be storing the minimum number of coins
        // required for i value.  So table[V] will have result
        int[] table = new int[V+1];

        table[0] = 0;

        for (int i=1; i <= V; i++)
            table[i] = Integer.MAX_VALUE;

        for (int i = 1; i <= V; i++)  {
            // Go through all coins smaller than i
            for (int j = 0; j < m && coins[j] <= i; j++)  {
                int sub_res = table[i - coins[j]];
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
                    table[i] = sub_res + 1;
            }
        }
        return table[V];
    }

    public static void main(String args[]) {
        int coins[] = { 9, 6, 5, 1 };
        int m = coins.length;
        int V = 11;
        assertEquals(3, minCoins(coins, m, V));
    }
}
