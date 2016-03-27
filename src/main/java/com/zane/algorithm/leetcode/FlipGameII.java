package main.com.zane.leetcode;

/**
 * You are playing the following Flip Game with your friend: Given a string that contains only these two
 * characters: + and -, you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * <p>
 * Write a function to determine if the starting player can guarantee a win
 * <p>
 * For example, given s = "++++", return true.
 * The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 * <p>
 * Created by jinpiluo on 3/23/16.
 */
public class FlipGameII {
    public boolean willWin(String s) {
        return existWinSolution(s, 1);
    }

    public boolean existWinSolution(String s, int step) {
        int findStart = 0;
        int index = s.indexOf("++", findStart);
        while (index >= 0) {
            String convertedStr = s.substring(0, index) + "--" + s.substring(index + 2);

            boolean existWinSolution = existWinSolution(convertedStr, step + 1);
            if (!existWinSolution && step % 2 == 1) {
                return true;
            }

            findStart = index + 1;
            index = s.indexOf("++", findStart);
        }

        return false;
    }

    public static void main(String[] args) {
        FlipGameII flipGameII = new FlipGameII();
        System.out.println(flipGameII.willWin("++--"));
        System.out.println(flipGameII.willWin("++++"));
        System.out.println(flipGameII.willWin("+--+"));
        System.out.println(flipGameII.willWin("++++++"));
    }
}
