    package Baekjoon;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class BJ1012 {

        private static int[][] board;
        private static boolean[][] visited;

        private static final String WHITE_SPACE = " ";
        private static final int LOCATE = 1;
        private static final int[] dx = { 1, 0, -1, 0 };
        private static final int[] dy = { 0, 1, 0, -1 };

        public static void main(String[] args) throws IOException {
            // 테스트 케이스의 수 입력 받기
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.valueOf(br.readLine());
            // 테스트 케이스의 수 만큼 반복
            for (int testCase = 0; testCase < T; testCase++) {
                // 배추밭의 가로길이 M, 세로길이 N 입력 받기
                StringTokenizer st = new StringTokenizer(br.readLine(), WHITE_SPACE);
                final int M = Integer.parseInt(st.nextToken());
                final int N = Integer.parseInt(st.nextToken());
                final int K = Integer.parseInt(st.nextToken());
                // 배추밭 지도 그리기
                board = new int[N][M];
                // 방문 여부 체크를 위한 지도 그리기
                visited = new boolean[N][M];
                // 배추가 심어져 있는 위치의 수 입력 받기
                for (int l = 0; l++ < K;) {
                    st = new StringTokenizer(br.readLine(), WHITE_SPACE);
                    while (st.hasMoreTokens()) {
                        // 배추의 위치 값 입력 받기\
                        int x = Integer.valueOf(st.nextToken());
                        int y = Integer.valueOf(st.nextToken());

                        board[y][x] = LOCATE;
                    }
                }
                // 순회한 수를 합산하기 위한 변수
                int cnt = 0;
                // 배추밭을 순회하면서 배추가 심어져 있는 곳을 발견하면 탐색 시작
                for (int y = 0; y < board.length; y++) {
                    for (int x = 0; x < board[y].length; x++) {
                        if (board[y][x] == LOCATE && !visited[y][x]) {
                            cnt += DFS(y, x, N, M);
                        }
                    }
                }
                System.out.println(cnt);
            }
        }

        private static int DFS(int y, int x, int boundY, int boundX) {
            // 방문 여부 체크
            visited[y][x] = true;

            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (!isOutOfBound(nextY, nextX, boundY, boundX) &&
                    board[nextY][nextX] == LOCATE &&
                    !visited[nextY][nextX]
                ) {
                    DFS(nextY, nextX, boundY, boundX);
                }
            }

            return 1;
        }

        private static boolean isOutOfBound(int nextY, int nextX, int boundY, int boundX) {
            return nextX < 0 || nextX >= boundX || nextY < 0 || nextY >= boundY ? true : false;
        }

    }
