package main.com.zane.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary
 * operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 * <p>
 * Examples:
 * "123", 6 -> ["1+2+3", "1*2*3"]
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 * <p>
 * <p>
 * Created by jinpiluo on 3/24/16.
 */
public class ExpressionAddOperators_282 {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if (num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }

    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval) {
                rst.add(path);
            }
            return;
        }

        // 搜索所有可能的拆分情况
        for (int i = pos; i < num.length(); i++) {
            // 对于前导为0的数予以排除
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }

            long cur = Long.parseLong(num.substring(pos, i + 1));


            if (pos == 0) {
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            } else {
                // 如果不是第一个字母时，可以加运算符，否则只加数字
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);

                helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);

                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}
