package main.com.zane.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * [LeetCode] Flip Game
 * <p>
 * Problem Description:
 * <p>
 * You are playing the following Flip Game with your friend:  Given a string that contains only these two
 * characters: + and -, you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * <p>
 * Write a function to compute all possible states of the string after one valid move.
 * <p>
 * For example, given s = "++++", after one move, it may become one of the following states:
 * <p>
 * [
 * "--++",
 * "+--+",
 * "++--"
 * ]
 * Created by jinpiluo on 3/23/16.
 */
public class FlipGame {

    // only can convert "++" to "--"
    public List<String> solution(String s) {
        List<String> result = new ArrayList<>();

        int findStart = 0;
        int index = s.indexOf("++", findStart);
        while (index >= 0) {
            result.add(s.substring(0, index) + "--" + s.substring(index + 2));
            findStart = index + 1;
            index = s.indexOf("++", findStart);
        }

        return result;
    }

    public static void main(String[] args) {
        FlipGame flipGame = new FlipGame();
        System.out.println(flipGame.solution("++--"));
        System.out.println(flipGame.solution("++++"));
    }
}
