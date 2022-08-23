package com.knubisoft.base.trees;

import com.sun.source.tree.Tree;
import lombok.SneakyThrows;

import java.util.*;

public class TreeTasksImpl implements TreeTasks {

    @Override
    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 != null && node2 != null) {

            return ((node1.val == node2.val) &&
                    (isSameTree(node1.left, node2.left)) &&
                    (isSameTree(node1.right, node2.right)));
        }
        return false;
        //return node1.equals(node2);
    }

    @Override
    public List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = node;
        while (t != null) {
            stack.push(t);
            t = t.left;
        }
        while (!stack.isEmpty()) {
            t = stack.pop();
            result.add(t.val);
            t = t.right;
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
        }
        return result;
    }

    @Override
    public boolean isSymmetric(TreeNode node) {
        if (node == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll(), q = queue.poll();

            if (p == null && q == null) {
                continue;
            }
            if ((p == null || q == null) || (p.val != q.val)) {
                return false;
            }
            queue.add(p.left);
            queue.add(q.right);
            queue.add(q.left);
            queue.add(p.right);
        }
        return true;
    }

    @Override
    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return Math.max(left, right) + 1;
    }

    @Override
    public boolean hasPathSum(TreeNode node, int targetSum) {
        if (node == null) {
            return false;
        }
        if ((node.val == targetSum) && (node.left == null) && node.right == null) {
            return true;
        }
        return hasPathSum(node.left, targetSum - node.val) || hasPathSum(node.right, targetSum - node.val);
    }

    @Override
    public TreeNode invertTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = invertTree(node.left);
        TreeNode right = invertTree(node.right);

        node.left = right;
        node.right = left;
        return node;
    }

    @Override
    public int sumOfLeftLeaves(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = 0;
        // RECURSIVE SOLUTION
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                sum += node.left.val;
            } else {
                sum += sumOfLeftLeaves(node.left);
            }
        }
        if (node.right != null) {
            if (node.right.left != null || node.right.right != null) {
                sum += sumOfLeftLeaves(node.right);
            }
        }
        // ITERATIVE SOLUTION
//        Stack<TreeNode> stack = new Stack<>();
//        stack.add(node);
//        while (!stack.isEmpty()){
//            TreeNode root = stack.pop();
//            if (root.left != null) {
//                if (root.left.left == null && root.left.right == null) {
//                    sum += root.left.val;
//                } else {
//                    stack.add(root.left);
//                }
//            }
//            if (root.right != null) {
//                if (root.right.left != null || root.right.right != null) {
//                    stack.add(root.right);
//                }
//            }
//        }
        return sum;
    }

    @Override
    public TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
        if (node1 == null ){
            return node2;
        }
        if (node2 == null){
            return node1;
        }
        node1.val += node2.val;
        node1.left = mergeTrees(node2.left, node1.left);
        node1.right = mergeTrees(node2.right, node1.right);
        return node1;
    }
}
