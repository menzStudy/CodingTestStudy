package menz.study.week08.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1991_ {
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.insertNode(parent, left, right);
        }

        tree.preOrder(tree.head);
        sb.append("\n");
        tree.inOrder(tree.head);
        sb.append("\n");
        tree.postOrder(tree.head);
        sb.append("\n");

        System.out.println(sb);
    }

    static class Tree {
        Node head;

        public void insertNode(char value, char left, char right) {
            if(head == null) {
                head = new Node(value, null, null);

                if(left != '.') {
                    this.head.left = new Node(left, null, null);
                }

                if(right != '.') {
                    this.head.right = new Node(right, null, null);
                }
            } else {
                searchNode(head, value, left, right);
            }
        }

        public void searchNode(Node head, char value, char left, char right) {
            if(head == null) return;

            if(head.value == value) {
                if(left != '.') {
                    head.left = new Node(left, null, null);
                }
                if(right != '.') {
                    head.right = new Node(right, null, null);
                }
            } else {
                searchNode(head.left, value, left, right);
                searchNode(head.right, value, left, right);
            }
        }

        public void preOrder(Node node){
            if (node != null) {
                sb.append(node.value);
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        public void inOrder(Node node) {
            if (node != null) {
                inOrder(node.left);
                sb.append(node.value);
                inOrder(node.right);
            }
        }

        public void postOrder(Node node) {
            if (node != null) {
                postOrder(node.left);
                postOrder(node.right);
                sb.append(node.value);
            }
        }
    }
}

class Node {
    char value;
    Node left;
    Node right;

    Node(char value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
