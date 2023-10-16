import java.util.*;

// https://www.acmicpc.net/problem/14499
public class Main_B_14499_주사위굴리기 {

    static int N, M;
    static int[] dr = {0, 0, 0, -1, 1};
    static int[] dc = {0, 1, -1, 0, 0};

    static Deque<Node> list1;
    static Deque<Node> list2;

    static class Node {
        int value;
        boolean active;

        public Node (int value, boolean active) {
            this.value = value;
            this.active = active;
        }
    }

    static int[][] map;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int r = sc.nextInt();
        int c = sc.nextInt();
        int K = sc.nextInt();

        map = new int[N][M];

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        list1 = new LinkedList<>(); // 세로
        list2 = new LinkedList<>(); // 가로 + 바닥

        list1.add(new Node(2, false));
        list1.add(new Node(1, false));
        list1.add(new Node(5, false));
        list1.add(new Node(6, false));

        list2.add(new Node(4, false));
        list2.add(new Node(1, false));
        list2.add(new Node(3, false));
        list2.add(new Node(6, false));

        for (int i=0; i<K; i++) {
            int d = sc.nextInt();

            int nr = r + dr[d];
            int nc = c + dc[d];

            // Out of index check
            if (nr<0 || nr>=N || nc<0 || nc>=M) continue;

            r = nr;
            c = nc;

            // 명령에 따라, 주사위 좌표값 변경
            update_dice(d);

            Node down = null;
            Node up = null;

            int idx = 1;
            for (Node node : list1) {
                if (idx==4) {
                    down = node;
                } else if (idx == 2) {
                    up = node;
                }
                idx++;
            }

            if (map[r][c] == 0) {
                if (down.active) {
                    map[r][c] = down.value; // 주사위 값 복사
                }
            } else {
                Deque<Node> temp = new LinkedList<>();
                idx = 1;
                for (Node node : list1) {
                    if (idx==4) { // 주사위 바닥
                        temp.add(new Node(map[r][c], true));
                        map[r][c] = 0;
                    } else {
                        temp.add(node);
                    }
                    idx++;
                }

                list1.clear();
                for (Node node : temp) {
                    list1.add(node);
                }

                // list2 업데이트
                temp = new LinkedList<>();
                idx = 1;
                Node x = null;
                Node y = null;
                for (Node p : list1)  {
                    if (idx==2) {
                        x = p;
                    } else if (idx==4) {
                        y = p;
                    }
                    idx++;
                }
                idx = 1;
                for (Node node : list2) {
                    if (idx == 2) {
                        temp.add(x);
                    } else if (idx == 4) {
                        temp.add(y);
                    } else {
                        temp.add(node);
                    }
                    idx++;
                }

                list2.clear();
                for (Node node : temp) {
                    list2.add(node);
                }
            }

            if (up.active) {
                sb.append(up.value).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void update_dice(int d) {
        switch(d) {
            case 1: // 우
                list2.addFirst(list2.pollLast());
                int idx = 1;
                Node x = null;
                Node y = null;

                for (Node node : list2) {
                    if (idx == 2) {
                        x = node;
                    } else if (idx == 4) {
                        y = node;
                    }
                    idx++;
                }

                // list1 업데이트
                Deque<Node> temp = new LinkedList<>();
                idx = 1;
                for (Node node : list1) {
                    if (idx == 2) {
                        temp.add(x);
                    } else if (idx == 4) {
                        temp.add(y);
                    } else {
                        temp.add(node);
                    }
                    idx++;
                }

                list1.clear();
                for (Node node : temp) {
                    list1.add(node);
                }

                break;
            case 2: // 좌
                list2.add(list2.pollFirst());

                idx = 1;
                x = null;
                y = null;

                for (Node node : list2) {
                    if (idx == 2) {
                        x = node;
                    } else if (idx == 4) {
                        y = node;
                    }
                    idx++;
                }

                // list1 업데이트
                temp = new LinkedList<>();
                idx = 1;
                for (Node node : list1) {

                    if (idx == 2) {
                        temp.add(x);
                    } else if (idx == 4) {
                        temp.add(y);
                    } else {
                        temp.add(node);
                    }

                    idx++;
                }

                list1.clear();
                for (Node node : temp) {
                    list1.add(node);
                }

                break;
            case 3: // 상
                list1.add(list1.pollFirst());
                idx = 1;
                x = null;
                y = null;
                for (Node node : list1) {
                    if (idx == 2) {
                        x = node;
                    } else if (idx == 4) {
                        y = node;
                    }
                    idx++;
                }
                // list2 업데이트
                temp = new LinkedList<>();
                idx = 1;
                for (Node node : list2) {

                    if (idx == 2) {
                        temp.add(x);
                    } else if (idx == 4) {
                        temp.add(y);
                    } else {
                        temp.add(node);
                    }

                    idx++;
                }

                list2.clear();
                for (Node node : temp) {
                    list2.add(node);
                }

                break;
            case 4: // 하
                list1.addFirst(list1.pollLast());

                idx = 1;
                x = null;
                y = null;
                for (Node node : list1) {
                    if (idx == 2) {
                        x = node;
                    } else if (idx == 4) {
                        y = node;
                    }
                    idx++;
                }
                // list2 업데이트
                temp = new LinkedList<>();
                idx = 1;
                for (Node node : list2) {

                    if (idx == 2) {
                        temp.add(x);
                    } else if (idx == 4) {
                        temp.add(y);
                    } else {
                        temp.add(node);
                    }

                    idx++;
                }

                list2.clear();
                for (Node node : temp) {
                    list2.add(node);
                }
                break;
        }
    }

}
