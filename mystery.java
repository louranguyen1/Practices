//package com.company;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class mystery {
//    public static void main(String[] args) {
//        TreeNode<String> example =
//            new TreeNode<>("hat", Arrays.asList(
//                new TreeNode<>("lit", Arrays.asList(    //lit - 5, sun - 6, nap + sat - 7 + 8
//                    new TreeNode<>("sun", Arrays.asList(
//                        new TreeNode<>("nap"),
//                            new TreeNode<>("sat")
//                    ))
//                )),
//                new TreeNode<>("cap"),
//                new TreeNode<>("cat", Arrays.asList(    //cat - 2, pup - 3
//                    new TreeNode<>("pup")
//                ))
//            ));
//
////        Testing samples
////        System.out.println("cat = " + example.getChildren().get(2).getValue());
////        System.out.println("pup = " + example.getChildren().get(2).getChildren().get(0).getValue());
////
////        System.out.println("cap = " + example.getChildren().get(1).getValue());
////
////        System.out.println("lit = " + example.getChildren().get(0).getValue());
////        System.out.println("sun = " + example.getChildren().get(0).getChildren().get(0).getValue());
////        System.out.println("nap = " + example.getChildren().get(0).getChildren().get(0).getChildren().get(0).getValue());
////        System.out.println("sat = " + example.getChildren().get(0).getChildren().get(0).getChildren().get(1).getValue());
//
//        mystery(example);
//    }
//
//    public static void mystery(TreeNode<String> node) {
//        List<TreeNode<String>> children = node.getChildren();
//        for (int i = 1; i < children.size(); i++) {
//            TreeNode<String> child = children.get(i);
//            System.out.println(child.getValue());
//            mystery(child);
//        }
//    }
//}
