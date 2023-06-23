package menz.study.week09.KwanHo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2234_ {

    private static int M,N;
    private static String[][] map;
    private static boolean[][] visited;
    private static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북동남서

    static int roomSize;
    static int brokenRoomSize;
    static HashMap<String, Integer> mergeRoom = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[M + 1][N + 1];
        visited = new boolean[M + 1][N + 1];
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = String.format("%04d", Integer.parseInt(Integer.toBinaryString(num)));
            }
        }

        int roomCnt = 0;
        int roomMax = 0;
        for(int i = 1; i <= M; i++) {
            for(int j = 1; j <= N; j++) {
                if(!visited[i][j]) {
                    roomCnt++;
                    roomSize = 1;
                    bfs(i, j, roomCnt);

                    mergeRoom.put(String.valueOf(roomCnt), roomSize);
                    roomMax = Math.max(roomMax, roomSize);
                }
            }
        }

        breakWall();
        System.out.println(roomCnt + "\n" + roomMax + "\n" + brokenRoomSize);
    }

    private static void bfs(int x, int y, int cnt) {
        Queue<Room> q = new LinkedList<>();

        q.add(new Room(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Room cur = q.poll();

            String direction = map[cur.x][cur.y];

            map[cur.x][cur.y] = String.valueOf(cnt);

            for(int i = 0; i < dirs.length; i++) {
                int nx = cur.x + dirs[i][0];
                int ny = cur.y + dirs[i][1];

                if(nx < 1 || ny < 1 || nx > M || ny > N || visited[nx][ny]) continue;

                // 동쪽으로 이동 가능
                if(direction.charAt(1) == '0' && i == 1) {
                    q.add(new Room(nx, ny));
                    visited[nx][ny] = true;
                    roomSize++;
                }
                // 남쪽으로 이동 가능
                if(direction.charAt(0) == '0' && i == 2) {
                    q.add(new Room(nx, ny));
                    visited[nx][ny] = true;
                    roomSize++;
                }
                // 북쪽으로 이동 가능
                if(direction.charAt(2) == '0' && i == 0) {
                    q.add(new Room(nx, ny));
                    visited[nx][ny] = true;
                    roomSize++;
                }
                // 서쪽으로 이동 가능
                if(direction.charAt(3) == '0' && i == 3) {
                    q.add(new Room(nx, ny));
                    visited[nx][ny] = true;
                    roomSize++;
                }
            }
        }
    }

    private static void breakWall() {
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                String room = map[i][j]; // A방 이름

                for (int k = 0; k < 4; k++) {
                    int nx = i + dirs[k][0];
                    int ny = j + dirs[k][1];

                    if (nx < 1 || ny < 1 || nx > M || ny > N) continue;

                    String bRoom = map[nx][ny];

                    if (room.equals(bRoom)) continue;

                    if (!room.equals(bRoom)) {
                        brokenRoomSize = Math.max(brokenRoomSize, mergeRoom.get(room) + mergeRoom.get(bRoom));
                    }
                }
            }
        }
    }
}

class Room {
    int x,y;

    public Room(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
