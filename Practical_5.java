/* 5
Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not
*/

import java.util.*;

public class Practical_5 // CycleDetection 
{

    static boolean dfs(int node, int parent,
                       ArrayList<ArrayList<Integer>> adj,
                       boolean[] visited) {

        visited[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {

                if (dfs(neighbor, node, adj, visited))
                    return true;

            } else if (neighbor != parent) {

                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        System.out.println("Enter edges (u v):");

        for (int i = 0; i < E; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        boolean cycle = false;

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (dfs(i, -1, adj, visited)) {

                    cycle = true;
                    break;
                }
            }
        }

        if (cycle)
            System.out.println("Graph contains a cycle.");
        else
            System.out.println("Graph does not contain a cycle.");

        sc.close();
    }
}