package menz.study.week10.JeongSeok;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 3 4
 * 1 2 1
 * 3 2 1
 * 1 3 5
 * 2 3 2
 */

public class _1956_ {
	static final int INF = 987654321;
	static int V, E, ans;
	static int arr[][];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		arr = new int[V + 1][V + 1];

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				arr[i][j] = INF;

				if (i == j) {
					arr[i][j] = 0;
				}
			}
		}


		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			arr[a][b] = c;
		}

		floydWarshall();

		ans = INF;
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i == j) {
					continue;
				}

				// 자기 자신을 제외한 두 정점이
				// 서로에게 가는 경로가 있다면, 사이클이 존재한다는 뜻.
				if (arr[i][j] != INF && arr[j][i] != INF) {
					ans = Math.min(ans, arr[i][j] + arr[j][i]);
				}
			}
		}

		System.out.println((ans == INF) ? -1 : ans);
	}

	private static void floydWarshall() {
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if (i == j) {
						continue;
					}
					// 최단경로 초기화
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
	}


}
