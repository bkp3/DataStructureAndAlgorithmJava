import java.util.*;

public class Prac {

    private static int N,E;
    private static ArrayList<Integer>adj[];
    private static boolean visited[];

    public Prac(int n, int e){
        this.N=n;
        this.E=e;
        adj = new ArrayList[N];
        for(int i=0;i<N;i++){
            adj[i]=new ArrayList<>();
        }
        visited = new boolean[N];
    }

    public void dfs(int src){
        visited[src]=true;
        System.out.println(src);
        for(int u:adj[src]){
            if(!visited[u]){
                dfs(u);
            }
        }
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int e=sc.nextInt();
        Prac obj = new Prac(n,e);
        for(int i=0;i<e;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            adj[x].add(y);
        }
        obj.dfs(2);


    }

}