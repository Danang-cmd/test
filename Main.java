class Graph {
    class Node {
        String vertex;
        Node next;

        Node(String vertex) {
            this.vertex = vertex;
            this.next = null;
        }
    }

    class AdjList {
        String vertex;
        Node head;

        AdjList(String vertex) {
            this.vertex = vertex;
            this.head = null;
        }
    }

    private AdjList[] adjLists;
    private int size;

    public Graph(int size) {
        this.size = size;
        this.adjLists = new AdjList[size];
        for (int i = 0; i < size; i++) {
            adjLists[i] = null;
        }
    }

    public void addVertex(String vertex) {
        for (int i = 0; i < size; i++) {
            if (adjLists[i] == null) {
                adjLists[i] = new AdjList(vertex);
                return;
            }
        }
        System.out.println("Graph penuh");
    }

    public void addEdge(String source, String destination) {
        int srcIndex = findVertex(source);
        int destIndex = findVertex(destination);

        if (srcIndex == -1 || destIndex == -1) {
            System.out.println("Vertex tidak ditemukan");
            return;
        }

        Node newNode = new Node(destination);
        if (adjLists[srcIndex].head == null) {
            adjLists[srcIndex].head = newNode;
        } else {
            Node temp = adjLists[srcIndex].head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    private int findVertex(String vertex) {
        for (int i = 0; i < size; i++) {
            if (adjLists[i] != null && adjLists[i].vertex.equals(vertex)) {
                return i;
            }
        }
        return -1;
    }

    public void printGraph() {
        for (int i = 0; i < size; i++) {
            if (adjLists[i] != null) {
                System.out.print(adjLists[i].vertex + " -> ");
                Node temp = adjLists[i].head;
                while (temp != null) {
                    System.out.print(temp.vertex + " ");
                    temp = temp.next;
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(17);

        graph.addVertex("Alpha");
        graph.addVertex("Beta");
        graph.addVertex("Gamma");
        graph.addVertex("Delta");
        graph.addVertex("Epsilon");
        graph.addVertex("Zeta");
        graph.addVertex("Eta");
        graph.addVertex("Theta");
        graph.addVertex("Iota");
        graph.addVertex("Kappa");
        graph.addVertex("Lambda");
        graph.addVertex("Mu");
        graph.addVertex("Nu");
        graph.addVertex("Xi");
        graph.addVertex("Omnicron");
        graph.addVertex("Omega");
        graph.addVertex("Sigma");

        graph.addEdge("Theta", "Kappa");
        graph.addEdge("Theta", "Iota");
        graph.addEdge("Theta", "Mu");
        graph.addEdge("Theta", "Epsilon");
        graph.addEdge("Theta", "Delta");

        graph.printGraph();
    }
}

