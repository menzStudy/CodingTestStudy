package menz.study.week08.YongHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _1991_ {
  private static int maxIdx;
  private static final StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    Map<String, Integer> idxMap = new HashMap<>();
    idxMap.put("A", 1);

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      String parent = st.nextToken();
      String leftChild = st.nextToken();
      String rightChild = st.nextToken();

      int parentIdx = idxMap.get(parent);
      int leftIdx = parentIdx * 2;
      int rightIdx = parentIdx * 2 + 1;
      if (!".".equals(leftChild)) idxMap.put(leftChild, leftIdx);
      if (!".".equals(rightChild)) idxMap.put(rightChild, rightIdx);
      if (maxIdx < rightIdx) maxIdx = rightIdx;
    }

    char[] tree = new char[maxIdx + 1];

    for (Map.Entry<String, Integer> entry : idxMap.entrySet()) {
      tree[entry.getValue()] = entry.getKey().charAt(0);
    }

    // 전위
    printPreOrder(1, tree);
    sb.append("\n");

    // 중위
    printInOrder(1, tree);
    sb.append("\n");

    // 후위
    printPostOrder(1, tree);
    sb.append("\n");

    System.out.println(sb);
    br.close();
  }

  private static void printPreOrder(int idx, char[] tree) {
    if (idx > maxIdx) return;
    if (tree[idx] != '\u0000') sb.append(tree[idx]);
    printPreOrder(idx * 2, tree);
    printPreOrder(idx * 2 + 1, tree);
  }

  private static void printInOrder(int idx, char[] tree) {
    if (idx > maxIdx) return;
    printInOrder(idx * 2, tree);
    if (tree[idx] != '\u0000') sb.append(tree[idx]);
    printInOrder(idx * 2 + 1, tree);
  }

  private static void printPostOrder(int idx, char[] tree) {
    if (idx > maxIdx) return;
    printPostOrder(idx * 2, tree);
    printPostOrder(idx * 2 + 1, tree);
    if (tree[idx] != '\u0000') sb.append(tree[idx]);
  }
}
