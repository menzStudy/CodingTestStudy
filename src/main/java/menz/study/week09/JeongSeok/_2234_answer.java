package menz.study.week09.JeongSeok;

import java.util.*;
import java.io.*;

class coordiante {
	int x;
	int y;

	coordiante(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class _2234_answer {
	static int n;
	static int m;
	static int map[][]; // 지도
	static int roomCount = 0; // 이 성에 있는 방의 개수
	static int maxRoom = 0; // 	가장 넓은 방의 넓이
	static int wallRoom = 0; // 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
	static int dx[] = {0,-1,0,1}; // 서 북 동 남
	static int dy[] = {-1,0,1,0}; // 서 북 동 남
	static boolean visited[][]; // 방문여부 체크
	static int wallCount[][][]; // [0] 방의 id 저장, [1] 이어진 방의 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		visited = new boolean[m][n];
		wallCount = new int[m][n][2];

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					bfs(i, j, roomCount);
					roomCount++;
				}
			}
		}

		MaxRoom();

		System.out.println(roomCount);
		System.out.println(maxRoom);
		System.out.println(wallRoom);
	}

	static void bfs(int x, int y, int id) {
		Queue<coordiante> q = new LinkedList<>();
		q.offer(new coordiante(x, y));
		int tempRoom = 0;
		ArrayList<coordiante> back = new ArrayList<>();
		visited[x][y] = true;

		while(!q.isEmpty()) {
			coordiante cur = q.poll();
			tempRoom++;
			back.add(new coordiante(cur.x, cur.y));

			for(int i = 0; i < 4; i++) {
				int tx = cur.x + dx[i];
				int ty = cur.y + dy[i];

				if((map[cur.x][cur.y] & (1 << i)) == 0) { // 벽이 없는 경우
					if(tx < 0 || m <= tx || ty < 0 || n <= ty) {
						continue;
					}

					if(visited[tx][ty]) {
						continue;
					}

					visited[tx][ty] = true;
					q.offer(new coordiante(tx, ty));
				}
			}
		}

		maxRoom = Math.max(maxRoom, tempRoom);

		for(coordiante c: back) {
			wallCount[c.x][c.y][1] = tempRoom;
			wallCount[c.x][c.y][0] = id;
		}
	}

	static void MaxRoom() {
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < 4; k++) {
					int tx = i + dx[k];
					int ty = j + dy[k];

					if(tx < 0 || m <= tx || ty < 0 || n <= ty) {
						continue;
					}

					if(wallCount[i][j][0] != wallCount[tx][ty][0]) {
						wallRoom = Math.max(wallRoom, wallCount[i][j][1]+wallCount[tx][ty][1]);
					}
				}
			}
		}
	}

}
