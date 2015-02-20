import java.io.*;
import java.util.*;

/**
 * https://class.coursera.org/algo/quiz/attempt?quiz_id=52
 */
public class MinCut {

    private static class Graph {
        
        private final Map<Integer, Vertex> vertices = new TreeMap<Integer, Vertex>( new Comparator<Integer>() {
            //for pretty printing
            @Override
            public int compare( Integer arg0, Integer arg1 ) {
                return arg0.compareTo( arg1 );
            }
        });
        
        private final List<Edge> edges = new ArrayList<Edge>();
        
        public void addVertex( Vertex v ) {
            vertices.put( v.lbl, v );
        }
        
        public Vertex getVertex( int lbl ) {
            Vertex v;
            if( ( v = vertices.get( lbl )) == null ) {
                v = new Vertex( lbl );
                addVertex( v );
            }
            return v;
        }
    }
    
    private static class Vertex {
        
        private final int lbl;
        private final Set<Edge> edges = new HashSet<Edge>();
        
        public Vertex( int lbl ) {
            this.lbl = lbl;
        }
        
        public void addEdge( Edge edge ) {
            edges.add( edge );
        }
        
        public Edge getEdgeTo( Vertex v2 ) {
            for ( Edge edge : edges ) {
                if( edge.contains( this, v2 ) )
                    return edge;
            }
            return null;
        }
        
    }
    
    private static class Edge {
        
        private final List<Vertex> ends = new ArrayList<Vertex>();
        
        public Edge( Vertex fst, Vertex snd ) {
            if( fst == null || snd == null ) {
                throw new IllegalArgumentException( "Both vertices are required" );
            }
            ends.add( fst );
            ends.add( snd );
        }
        
        public boolean contains( Vertex v1, Vertex v2 ) {
            return ends.contains( v1 ) && ends.contains( v2 );
        }
        
        public Vertex getOppositeVertex( Vertex v ) {
            if( !ends.contains( v ) ) {
                throw new IllegalArgumentException( "Vertex " + v.lbl );
            }
            return ends.get( 1 - ends.indexOf( v ) );
        }
        
        public void replaceVertex( Vertex oldV, Vertex newV ) {
            if( !ends.contains( oldV ) ) {
                throw new IllegalArgumentException( "Vertex " + oldV.lbl );
            }
            ends.remove( oldV );
            ends.add( newV );
        }
    }
    
    public static int minCut( Graph gr ) {
        
        Random rnd = new Random();
        
        while( gr.vertices.size() > 2 ) {
            Edge edge = gr.edges.remove( rnd.nextInt( gr.edges.size() ) );
            Vertex v1 = cleanVertex( gr, edge.ends.get( 0 ), edge );
            Vertex v2 = cleanVertex( gr, edge.ends.get( 1 ), edge );
            //contract
            Vertex mergedVertex = new Vertex( v1.lbl );
            redirectEdges( gr, v1, mergedVertex );
            redirectEdges( gr, v2, mergedVertex );
            
            gr.addVertex( mergedVertex );
        }
        return gr.edges.size();
    }
    
    private static Vertex cleanVertex( Graph gr, Vertex v, Edge e ) {
        gr.vertices.remove( v.lbl );
        v.edges.remove( e );
        return v;
    }
    
    private static void redirectEdges( Graph gr, Vertex fromV, Vertex toV ) {
        for ( Iterator<Edge> it = fromV.edges.iterator(); it.hasNext(); ) {
            Edge edge = it.next();
            it.remove();
            if( edge.getOppositeVertex( fromV ) == toV ) {
                //remove self-loop
                toV.edges.remove( edge );
                gr.edges.remove( edge );
            } else {
                edge.replaceVertex( fromV, toV );
                toV.addEdge( edge );
            }
        }
    }
    
    public static int[][] getArray( String relPath ) {
        
        Map<Integer, List<Integer>> vertices = new LinkedHashMap<Integer, List<Integer>>();
        
        FileReader fr;
        try {
            fr = new FileReader( relPath );
            BufferedReader br = new BufferedReader( fr );
            String line;
            while( ( line = br.readLine() ) != null ) {
                String[] split = line.trim().split( "(\\s)+" );
                List<Integer> adjList = new ArrayList<Integer>();
                for(int i = 1; i < split.length; i++) {
                    adjList.add( Integer.parseInt( split[i] )-1 );
                }
                vertices.put( Integer.parseInt( split[0] )-1, adjList );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        int[][] array = new int[vertices.size()][];
        for ( Map.Entry<Integer, List<Integer>> entry : vertices.entrySet() ) {
            List<Integer> adjList = entry.getValue();
            int[] adj = new int[adjList.size()];
            for( int i = 0; i < adj.length; i++ ) {
                adj[i] = adjList.get( i );
            }
            array[entry.getKey()] = adj;
        }
        return array;
    }

    private static Graph createGraph(int[][] array) {
        Graph gr = new Graph();
        for ( int i = 0; i < array.length; i++ ) {
            Vertex v = gr.getVertex( i );
            for ( int edgeTo : array[i] ) {
                Vertex v2 = gr.getVertex( edgeTo );
                Edge e;
                if( (e = v2.getEdgeTo( v )) == null ) {
                    e = new Edge( v, v2 );
                    gr.edges.add( e );
                    v.addEdge( e );
                    v2.addEdge( e );
                }
            }
        }
        return gr;
    }
    
    /**
     * @param args
     */
    public static void main( String[] args ) {
        int[][] arr = getArray( "/Users/kartik/dev/code/algo1/week3/src/test/resources/kargerMinCut.txt" );
        Map<Integer, Integer> statistics = new LinkedHashMap<Integer, Integer>();
        
        int min = arr.length;
        int iter = arr.length*arr.length;
        
        for( int i = 0; i < iter; i++ ) {
            Graph gr = createGraph( arr );
            //printGraph( gr );
            int currMin = minCut( gr );
            min = Math.min( min, currMin );
            
            Integer counter;
            if( ( counter = statistics.get( currMin ) ) == null ) {
                counter = 0;
            }
            statistics.put( currMin, counter+1 );
        }
        System.out.println( "Min: " + min + " stat: " + (statistics.get( min )*100/iter) + "%" );
    }
    
    private static void printGraph( Graph gr ) {
        System.out.println("Printing graph");
        for ( Vertex v : gr.vertices.values() ) {
            System.out.print( v.lbl + ":");
            for ( Edge edge : v.edges ) {
                System.out.print( " " + edge.getOppositeVertex( v ).lbl );
            }
            System.out.println();
        }
    }

    //Adj format to visualize in 
    //http://www.cs.rpi.edu/research/groups/pb/graphdraw/headpage.html
    private static void toAdjFormat(int[][] arr) {
        System.out.println(arr.length);
        for ( int[] adj : arr ) {
            System.out.print(adj.length);
            for ( int i : adj ) {
                System.out.print( " " + i );
            }
            System.out.println();
        }
    }
}