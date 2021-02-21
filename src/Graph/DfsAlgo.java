/*
4 6
0 1
0 2
1 2
2 0
2 3
3 3

 output:-- 
 2 0 1 3
 
 
*/
package Graph;
import java.util.*;
public class DfsAlgo {

	private static int V;
	private static int E;
	private static ArrayList<Integer>adj[];
	boolean[] visited;
	
	public DfsAlgo(int n, int e) {
		this.V=n;
		this.E=e;
		this.adj=new ArrayList[V];
		for(int i=0;i<V;i++) {
			adj[i]=new ArrayList<>();
		}
		visited=new boolean[V];
	}
	
	
	public void print() {
		for(int i=0;i<V;i++) {
			System.out.print(i+" ---> ");
			for(int x:adj[i]) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
	
	public void dfs(int src) {
		
		
		Stack<Integer>st=new Stack<>();
		st.push(src);
		
		while(!st.isEmpty()) {
			int u=st.pop();
			if(!visited[u]) {
				visited[u]=true;
				System.out.print(u+" ");
				for(int v:adj[u]) {
					if(!visited[v]) {
						st.push(v);
					}
				}
			}
		}
	}
	
	// recursion
	public void dfsRec(int src) {
		visited[src] = true;
        System.out.print(src + " ");
        for (int i = 0; i <adj[src].size() ; i++) {
            int v = adj[src].get(i);
            if(!visited[v])
                dfsRec(v);
        }
	}
	

	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int e=sc.nextInt();
		
		DfsAlgo obj = new DfsAlgo(n,e);
		for(int i=0;i<e;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			adj[x].add(y);
		}
		//obj.print();
		obj.dfsRec(2);
	}

}
