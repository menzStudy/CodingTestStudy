package menz.study.week09.JeongSeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206_time_error {

	static int N, M;
	static int min = Integer.MAX_VALUE;
	static int[] dx = new int[]{1, 0, -1, 0};
	static int[] dy = new int[]{0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Pair> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 1. 입력받는다.
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];


		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		// 2. 벽의 위치를 리스트에 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					list.add(new Pair(i, j));
				}
			}
		}

		// 3. 벽의 갯수만큼 bfs 반복 실행 후 최단 경로 구하기
		// 벽을 하나씩 허물고 bfs가 종료되면 허문 위치 원복
		for (int i = 0; i < list.size(); i++) {
			Pair wall = list.get(i);
			visited = new boolean[N][M];

			map[wall.x][wall.y] = 0;
			bfs(0, 0);
			map[wall.x][wall.y] = 1;
		}

		if (min == 0) {
			System.out.println(-1);
		} else {
			System.out.println(min + 1);
		}

	}

	private static void bfs(int i, int j) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(i, j));
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			Pair now = queue.poll();

			for (int k = 0; k < 4; k++) {
				int nx = now.x + dx[k];
				int ny = now.y + dy[k];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				if (map[nx][ny] == 1 || visited[nx][ny]) {
					continue;
				}

				queue.add(new Pair(nx, ny));
				visited[nx][ny] = true;
				map[nx][ny] = map[now.x][now.y] + 1;
			}
		}

		min = Math.min(min, map[N - 1][M - 1]);
	}

}
