import java.util.*;

class Solution {
    
    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
    
    public int solution(int[][] maps) {
        int answer = -1;
        int N = maps.length;
        int M = maps[0].length;
        
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new Point(0, 0, 1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.x == M - 1 && cur.y == N - 1) {
                answer = cur.t;
                break;
            }
            
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (maps[ny][nx] == 0 || visited[ny][nx]) continue;
                queue.offer(new Point(nx, ny, cur.t + 1));
                visited[ny][nx] = true;
            }
            
        }
        
        return answer;
    }
    
    public class Point {
        int x, y, t;
        
        Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
}import java.util.*;

class Solution {
	    
	    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
			    
			    public int solution(int[][] maps) {
						        int answer = -1;
										        int N = maps.length;
														        int M = maps[0].length;
																		        
																		        Queue<Point> queue = new LinkedList<>();
																						        boolean[][] visited = new boolean[N][M];
																										        queue.offer(new Point(0, 0, 1));
																														        visited[0][0] = true;
																																		        
																																		        while(!queue.isEmpty()) {
																																							            Point cur = queue.poll();
																																													            if (cur.x == M - 1 && cur.y == N - 1) {
																																																				                answer = cur.t;
																																																												                break;
																																																																				            }
																																																			            
																																																			            for (int d = 0; d < 4; d++) {
																																																										                int nx = cur.x + dx[d];
																																																																		                int ny = cur.y + dy[d];
																																																																										                
																																																																										                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
																																																																																		                if (maps[ny][nx] == 0 || visited[ny][nx]) continue;
																																																																																										                queue.offer(new Point(nx, ny, cur.t + 1));
																																																																																																		                visited[ny][nx] = true;
																																																																																																										            }
																																																									            
																																																									        }
																																						        
																																						        return answer;
																																										    }
					    
					    public class Point {
								        int x, y, t;
												        
												        Point(int x, int y, int t) {
																	            this.x = x;
																							            this.y = y;
																													            this.t = t;
																																			        }
																    }
}import java.util.*;

class Solution {
	    
	    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
			    
			    public int solution(int[][] maps) {
						        int answer = -1;
										        int N = maps.length;
														        int M = maps[0].length;
																		        
																		        Queue<Point> queue = new LinkedList<>();
																						        boolean[][] visited = new boolean[N][M];
																										        queue.offer(new Point(0, 0, 1));
																														        visited[0][0] = true;
																																		        
																																		        while(!queue.isEmpty()) {
																																							            Point cur = queue.poll();
																																													            if (cur.x == M - 1 && cur.y == N - 1) {
																																																				                answer = cur.t;
																																																												                break;
																																																																				            }
																																																			            
																																																			            for (int d = 0; d < 4; d++) {
																																																										                int nx = cur.x + dx[d];
																																																																		                int ny = cur.y + dy[d];
																																																																										                
																																																																										                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
																																																																																		                if (maps[ny][nx] == 0 || visited[ny][nx]) continue;
																																																																																										                queue.offer(new Point(nx, ny, cur.t + 1));
																																																																																																		                visited[ny][nx] = true;
																																																																																																										            }
																																																									            
																																																									        }
																																						        
																																						        return answer;
																																										    }
					    
					    public class Point {
								        int x, y, t;
												        
												        Point(int x, int y, int t) {
																	            this.x = x;
																							            this.y = y;
																													            this.t = t;
																																			        }
																    }
}import java.util.*;

class Solution {
	    
	    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
			    
			    public int solution(int[][] maps) {
						        int answer = -1;
										        int N = maps.length;
														        int M = maps[0].length;
																		        
																		        Queue<Point> queue = new LinkedList<>();
																						        boolean[][] visited = new boolean[N][M];
																										        queue.offer(new Point(0, 0, 1));
																														        visited[0][0] = true;
																																		        
																																		        while(!queue.isEmpty()) {
																																							            Point cur = queue.poll();
																																													            if (cur.x == M - 1 && cur.y == N - 1) {
																																																				                answer = cur.t;
																																																												                break;
																																																																				            }
																																																			            
																																																			            for (int d = 0; d < 4; d++) {
																																																										                int nx = cur.x + dx[d];
																																																																		                int ny = cur.y + dy[d];
																																																																										                
																																																																										                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
																																																																																		                if (maps[ny][nx] == 0 || visited[ny][nx]) continue;
																																																																																										                queue.offer(new Point(nx, ny, cur.t + 1));
																																																																																																		                visited[ny][nx] = true;
																																																																																																										            }
																																																									            
																																																									        }
																																						        
																																						        return answer;
																																										    }
					    
					    public class Point {
								        int x, y, t;
												        
												        Point(int x, int y, int t) {
																	            this.x = x;
																							            this.y = y;
																													            this.t = t;
																																			        }
																    }
}import java.util.*;

class Solution {
	    
	    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
			    
			    public int solution(int[][] maps) {
						        int answer = -1;
										        int N = maps.length;
														        int M = maps[0].length;
																		        
																		        Queue<Point> queue = new LinkedList<>();
																						        boolean[][] visited = new boolean[N][M];
																										        queue.offer(new Point(0, 0, 1));
																														        visited[0][0] = true;
																																		        
																																		        while(!queue.isEmpty()) {
																																							            Point cur = queue.poll();
																																													            if (cur.x == M - 1 && cur.y == N - 1) {
																																																				                answer = cur.t;
																																																												                break;
																																																																				            }
																																																			            
																																																			            for (int d = 0; d < 4; d++) {
																																																										                int nx = cur.x + dx[d];
																																																																		                int ny = cur.y + dy[d];
																																																																										                
																																																																										                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
																																																																																		                if (maps[ny][nx] == 0 || visited[ny][nx]) continue;
																																																																																										                queue.offer(new Point(nx, ny, cur.t + 1));
																																																																																																		                visited[ny][nx] = true;
																																																																																																										            }
																																																									            
																																																									        }
																																						        
																																						        return answer;
																																										    }
					    
					    public class Point {
								        int x, y, t;
												        
												        Point(int x, int y, int t) {
																	            this.x = x;
																							            this.y = y;
																													            this.t = t;
																																			        }
																    }
}import java.util.*;

class Solution {
	    
	    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
			    
			    public int solution(int[][] maps) {
						        int answer = -1;
										        int N = maps.length;
														        int M = maps[0].length;
																		        
																		        Queue<Point> queue = new LinkedList<>();
																						        boolean[][] visited = new boolean[N][M];
																										        queue.offer(new Point(0, 0, 1));
																														        visited[0][0] = true;
																																		        
																																		        while(!queue.isEmpty()) {
																																							            Point cur = queue.poll();
																																													            if (cur.x == M - 1 && cur.y == N - 1) {
																																																				                answer = cur.t;
																																																												                break;
																																																																				            }
																																																			            
																																																			            for (int d = 0; d < 4; d++) {
																																																										                int nx = cur.x + dx[d];
																																																																		                int ny = cur.y + dy[d];
																																																																										                
																																																																										                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
																																																																																		                if (maps[ny][nx] == 0 || visited[ny][nx]) continue;
																																																																																										                queue.offer(new Point(nx, ny, cur.t + 1));
																																																																																																		                visited[ny][nx] = true;
																																																																																																										            }
																																																									            
																																																									        }
																																						        
																																						        return answer;
																																										    }
					    
					    public class Point {
								        int x, y, t;
												        
												        Point(int x, int y, int t) {
																	            this.x = x;
																							            this.y = y;
																													            this.t = t;
																																			        }
																    }
}import java.util.*;

class Solution {
	    
	    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
			    
			    public int solution(int[][] maps) {
						        int answer = -1;
										        int N = maps.length;
														        int M = maps[0].length;
																		        
																		        Queue<Point> queue = new LinkedList<>();
																						        boolean[][] visited = new boolean[N][M];
																										        queue.offer(new Point(0, 0, 1));
																														        visited[0][0] = true;
																																		        
																																		        while(!queue.isEmpty()) {
																																							            Point cur = queue.poll();
																																													            if (cur.x == M - 1 && cur.y == N - 1) {
																																																				                answer = cur.t;
																																																												                break;
																																																																				            }
																																																			            
																																																			            for (int d = 0; d < 4; d++) {
																																																										                int nx = cur.x + dx[d];
																																																																		                int ny = cur.y + dy[d];
																																																																										                
																																																																										                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
																																																																																		                if (maps[ny][nx] == 0 || visited[ny][nx]) continue;
																																																																																										                queue.offer(new Point(nx, ny, cur.t + 1));
																																																																																																		                visited[ny][nx] = true;
																																																																																																										            }
																																																									            
																																																									        }
																																						        
																																						        return answer;
																																										    }
					    
					    public class Point {
								        int x, y, t;
												        
												        Point(int x, int y, int t) {
																	            this.x = x;
																							            this.y = y;
																													            this.t = t;
																																			        }
																    }
}import java.util.*;

class Solution {
	    
	    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
			    
			    public int solution(int[][] maps) {
						        int answer = -1;
										        int N = maps.length;
														        int M = maps[0].length;
																		        
																		        Queue<Point> queue = new LinkedList<>();
																						        boolean[][] visited = new boolean[N][M];
																										        queue.offer(new Point(0, 0, 1));
																														        visited[0][0] = true;
																																		        
																																		        while(!queue.isEmpty()) {
																																							            Point cur = queue.poll();
																																													            if (cur.x == M - 1 && cur.y == N - 1) {
																																																				                answer = cur.t;
																																																												                break;
																																																																				            }
																																																			            
																																																			            for (int d = 0; d < 4; d++) {
																																																										                int nx = cur.x + dx[d];
																																																																		                int ny = cur.y + dy[d];
																																																																										                
																																																																										                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
																																																																																		                if (maps[ny][nx] == 0 || visited[ny][nx]) continue;
																																																																																										                queue.offer(new Point(nx, ny, cur.t + 1));
																																																																																																		                visited[ny][nx] = true;
																																																																																																										            }
																																																									            
																																																									        }
																																						        
																																						        return answer;
																																										    }
					    
					    public class Point {
								        int x, y, t;
												        
												        Point(int x, int y, int t) {
																	            this.x = x;
																							            this.y = y;
																													            this.t = t;
																																			        }
																    }
}import java.util.*;

class Solution {
	    
	    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
			    
			    public int solution(int[][] maps) {
						        int answer = -1;
										        int N = maps.length;
														        int M = maps[0].length;
																		        
																		        Queue<Point> queue = new LinkedList<>();
																						        boolean[][] visited = new boolean[N][M];
																										        queue.offer(new Point(0, 0, 1));
																														        visited[0][0] = true;
																																		        
																																		        while(!queue.isEmpty()) {
																																							            Point cur = queue.poll();
																																													            if (cur.x == M - 1 && cur.y == N - 1) {
																																																				                answer = cur.t;
																																																												                break;
																																																																				            }
																																																			            
																																																			            for (int d = 0; d < 4; d++) {
																																																										                int nx = cur.x + dx[d];
																																																																		                int ny = cur.y + dy[d];
																																																																										                
																																																																										                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
																																																																																		                if (maps[ny][nx] == 0 || visited[ny][nx]) continue;
																																																																																										                queue.offer(new Point(nx, ny, cur.t + 1));
																																																																																																		                visited[ny][nx] = true;
																																																																																																										            }
																																																									            
																																																									        }
																																						        
																																						        return answer;
																																										    }
					    
					    public class Point {
								        int x, y, t;
												        
												        Point(int x, int y, int t) {
																	            this.x = x;
																							            this.y = y;
																													            this.t = t;
																																			        }
																    }
}
