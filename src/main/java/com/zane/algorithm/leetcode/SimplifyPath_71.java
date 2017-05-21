package com.zane.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: luojinping
 * Date: 17/4/16 下午3:33
 */
public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        if (path == null) {
            return "";
        }

        List<String> pathList = new ArrayList<>();

        for (String item : path.split("/")) {
            if (item.equals(".")) {
                continue;
            } else if (item.equals("..")) {
                if (pathList.size() > 0) {
                    pathList.remove(pathList.size() - 1);
                }
            } else if (item.equals("")) {
                continue;
            } else {
                pathList.add(item);
            }
        }

        if (pathList.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (String item : pathList) {
            sb.append("/").append(item);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        SimplifyPath_71 simplifyPath_71 = new SimplifyPath_71();
        System.out.println(simplifyPath_71.simplifyPath("/"));
        System.out.println(simplifyPath_71.simplifyPath("/home/"));
        System.out.println(simplifyPath_71.simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath_71.simplifyPath("/abc/..."));
    }
}
