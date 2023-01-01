package com.mumusta.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public static void dfs(Node curr, List<String> list){

            if (curr == null) return;

            list.add(curr.name);

            for (Node x : curr.children)
                dfs(x, list);
        }

        public List<String> depthFirstSearch(List<String> array) {

            dfs(this, array);
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
