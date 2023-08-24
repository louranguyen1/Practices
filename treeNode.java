package com.company;

/*Description: print the nodes in a decreasing order and listed the leaves from right to left
    - when inserting the nodes, the first number is the root
    - the next number's position depends on if its smaller or bigger than the root (left = smaller, right = bigger)
    - repeat the same step

    - decreasing order would just go from right to left, starting with the right leaves -> root -> left leaves
    - leaves - the numbers that doesnt have any child
 */

public class treeNode {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(5);
        tree.insert(6);
        tree.insert(8);
        tree.printNodesDecreasing();
        System.out.println();
        tree.printLeaves();
    }
}
