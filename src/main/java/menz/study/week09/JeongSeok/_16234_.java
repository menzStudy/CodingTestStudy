package menz.study.week09.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16234_ {

	static int N, L, R, count;

	static int[] dx = new int[]{1, 0, -1, 0};
	static int[] dy = new int[]{0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visited;
	static boolean isMoved = false;
	static ArrayList<Pair> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 1. 입력
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 2. 인접한 국가들이 연합 가능 여부 판별
		union();
		System.out.println(count);
	}

	// 모든 좌표에 대해서 BFS 탐색을 진행해야함
	// 매번 돌떄마다 방문 배열을 초기화시켜줘야하고, isMoved가 false이면 bfs 탐색 결과는 더 이상 바꿀 것이 없다는 것을 의미한다.
	private static void union() {
		while (true) {
			isMoved = false;
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						bfs(i, j);
					}
				}
			}

			if (!isMoved) {
				break;
			} else {
				count++;
			}
		}
	}

	private static void bfs(int i, int j) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(i, j));
		visited[i][j] = true;
		list.add(new Pair(i, j));

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			for (int k = 0; k < 4; k++) {
				int nx = cur.x + dx[k];
				int ny = cur.y + dy [k];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				int range = Math.abs(map[cur.x][cur.y] - map[nx][ny]);

				if (L <= range && range <= R && !visited[nx][ny]) {
					isMoved = true;
					visited[nx][ny] = true;
					list.add(new Pair(nx, ny));
					queue.add(new Pair(nx, ny));
				}
			}
		}

		updatePopulation();
	}

	// 연합국가 인구수 갱신
	private static void updatePopulation() {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			Pair pair = list.get(i);
			sum += map[pair.x][pair.y];
		}

		for (int i = 0; i < list.size(); i++) {
			Pair pair = list.get(i);
			map[pair.x][pair.y] = sum / list.size();
		}

		list.clear();
	}

}

