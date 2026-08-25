/* 6
There are n servers numbered from 0 to n -1 connected by undirected server-to-server connections forming a network
where connections[i] = [ai, bi] representsa connection between servers ai and bi. Any server can reach other servers
directly or indirectly through the network.A critical connection is a connection that, if removed, will make some servers
unable to reach some other servers. Return all critical connections in the network in any order.
*/


import java.util.*;

public class Practical_6 // CriticalConnections 
{

    static int timer;
    static List<List<Integer>> adj;
    static int[] disc;
    static int[] low;
    static List<List<Integer>> bridges;

    static void dfs(int u, int parent) {

        disc[u] = low[u] = timer++;

        for (int v : adj.get(u)) {

            // Ignore the edge back to the parent
            if (v == parent)
                continue;

            // If v is not visited
            if (disc[v] == -1) {

                dfs(v, u);

                // Update low value
                low[u] = Math.min(low[u], low[v]);

                // Bridge condition
                if (low[v] > disc[u]) {
                    bridges.add(Arrays.asList(u, v));
                }
            }
            else {
                // Back edge
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    static List<List<Integer>> criticalConnections(
            int n,
            List<List<Integer>> connections) {

        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list
        for (List<Integer> edge : connections) {

            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        disc = new int[n];
        low = new int[n];

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        bridges = new ArrayList<>();

        timer = 0;

        // Handle disconnected graphs
        for (int i = 0; i < n; i++) {

            if (disc[i] == -1) {
                dfs(i, -1);
            }
        }

        return bridges;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of servers: ");
        int n = sc.nextInt();

        System.out.print("Enter number of connections: ");
        int e = sc.nextInt();

        List<List<Integer>> connections = new ArrayList<>();

        System.out.println("Enter connections (u v):");

        for (int i = 0; i < e; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            connections.add(Arrays.asList(u, v));
        }

        List<List<Integer>> result =
                criticalConnections(n, connections);

        System.out.println("\nCritical Connections:");

        if (result.isEmpty()) {
            System.out.println("No critical connections found.");
        }
        else {
            for (List<Integer> edge : result) {
                System.out.println(
                    edge.get(0) + " - " + edge.get(1)
                );
            }
        }

        sc.close();
    }
}