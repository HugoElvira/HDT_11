/** 
* Clase: GraphDB.java
* @author Diego Soler, Hugo Elvira, Edgar Ramírez
* @version 09/11/16
*/


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.algorithm.PageRank;
import org.graphstream.algorithm.generator.DorogovtsevMendesGenerator;
import org.graphstream.graph.Node;


public class GraphDatabase {
    String[][] matriz = new String [15][15];
    Graph grafo1 = new SingleGraph("Comunicaciones");
    Graph grafo2 = new MultiGraph("6 o mas correos");
    int[][] correos = new int[14][14];
    ArrayList<String> datos = new ArrayList();
    ArrayList<Persona> datosPersonas = new ArrayList();
    
    /**
     * pre: Graph is empty
     * post: Graph is created after reading csv File
     */
    public void crearGrafo() {
    	
    	//Se creara el grafo
        String csvFile = "C:\\Users\\Diego\\Desktop\\Universidad\\Cuarto Semestre\\Algoritmos y Estructuras de Datos\\datos.csv"; //Aqui va la direccion donde se encuentra el archivo
        BufferedReader br = null;
        String line ="";
        
        int n = 0;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                
            	//Se separa por el punto y coma
                String[] fila = line.split(";");
                
                //Se agrega a la matriz del grafo
                matriz[0][n]=fila[1];
                matriz[1][n]=fila[2];
                matriz[2][n]=fila[3];
                matriz[3][n]=fila[4];
                matriz[4][n]=fila[5];
                matriz[5][n]=fila[6];
                matriz[6][n]=fila[7];
                matriz[7][n]=fila[8];
                matriz[8][n]=fila[9];
                matriz[9][n]=fila[10];
                matriz[10][n]=fila[11];
                matriz[11][n]=fila[12];
                matriz[12][n]=fila[13];
                matriz[13][n]=fila[14];
                n++;
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            //Se crea la conexion con neo4j, especificando usuario y contrasena
                    Connection con = DriverManager.getConnection("jdbc:neo4j:bolt://localhost/?user=neo4j,password=123,debug=true,noSsl,flatten=[-1,100,1000]"); 
                    try (Statement stmt = con.createStatement()) {
                stmt.executeQuery("match (n) detach \n delete n");
                
                //Se van agregando los nodos al grafo, provenientes de la matriz de adyacencia
                for (int m = 0; m<14 ; m++){
                grafo1.addNode(matriz[m][0]);
                String query = String.format("\"%s\"", matriz[m][0]);
                stmt.executeQuery("CREATE (n:Person {name: "+query+"})");
               
                        }
                
        for (int j = 0; j<14;j++){
            for (int i = 0; i<14; i++){
                correos[i][j]=Integer.parseInt(matriz[i][j+1]);
            }
        }
       
        
        for (int j = 0; j<14;j++){
            for (int i = 0; i<14; i++){
                if (correos[i][j]>0){
               
                    String nombreq1 = String.format("\"%s\"", matriz[j][0]);
                    String nombreq2 = String.format("\"%s\"", matriz[i][0]);
                  stmt.executeQuery("match (n: Person {name: "+nombreq1+"})" +
                                    "match (m: Person {name: "+nombreq2+"})" +
                                      "create (n)-[:WROTE {quantity: "+correos[i][j]+"}]->(m)");
                  grafo1.addEdge(""+matriz[j][0]+matriz[i][0], matriz[j][0], matriz[i][0], true);
                
                //Cuando los correos son mayores a 6
                if (correos[i][j]>6)
                {
                    if (grafo2.getNode(matriz[i][0])==null){
                    grafo2.addNode(matriz[i][0]);
                   
                    }
                    if (grafo2.getNode(matriz[j][0])==null){
                    grafo2.addNode(matriz[j][0]);
                    
                    }
                    grafo2.addEdge(""+matriz[j][0]+matriz[i][0], matriz[j][0], matriz[i][0], true);
                }
                  
            
                }
            }
        }
                
               
                    }
                    con.close();

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            
            }
    
    //LA VISUALIZACION DE LOS GRAFOS SE HACEN CON GRAPHSTREAM
    //Metodo para mostrar el grafo de todas las relaciones
    public void mostrarGrafo1(){
        grafo1.display();
    }

    //Metodo para mostrar el grafo donde hay relaciones de 6 o mas correos
    public void mostrarGrafo2(){
        grafo2.display();
    }

    //PageRank como Google
    public void pagerank() {
     datosPersonas.clear();
        /*
       ;
        */
        PageRank pageRank = new PageRank();
        pageRank.setVerbose(true);
	    pageRank.init(grafo1);
        
        for (Node node : grafo1){
            double rank = pageRank.getRank(node);
            rank = rank*100;
            datos.add(""+rank+"% "+node.getId());
            int r = (int) rank;
            Persona p = new Persona(r, node.getId());
            datosPersonas.add(p);
        }
        datos.sort(null);
        datosPersonas.sort(null);
        
    }

  
    public String getRankings () {
        String o = "";
        int i =0;
        for (Persona p: datosPersonas){
            o = o + datosPersonas.get(i).getName()+": "+datosPersonas.get(i).getNum()+"\n";
            i++;
        }
        return o;
    }
    
    
    //Metodo para obtener los mas comunicados
    public String masComunicados (){
        String s = "";
        ArrayList<Persona> comunicaciones = new ArrayList();
        for (Node node : grafo1){
            Persona p = new Persona(node.getDegree(), node.getId());
            comunicaciones.add(p);
        }
        comunicaciones.sort(null);
        s = comunicaciones.get(13).getName()+"\n "+comunicaciones.get(12).getName()+"\n "+comunicaciones.get(11).getName()+" ";
        return s;
    }
    
  //Metodo para obtener los menos comunicados
    public String menosComunicados (){
        String s = "";
        ArrayList<Persona> comunicaciones = new ArrayList();
        for (Node node : grafo1){
            Persona p = new Persona(node.getDegree(), node.getId());
            comunicaciones.add(p);
        }
        comunicaciones.sort(null);
        s = comunicaciones.get(0).getName()+"\n "+comunicaciones.get(1).getName()+"\n "+comunicaciones.get(2).getName()+" ";
        return s;
    }

  
  //Metodo para la cantidad minima de correos
    public String correos(String origen, String destino){
        String res = "";
        try {
                    Connection con = DriverManager.getConnection("jdbc:neo4j:bolt://localhost/?user=neo4j,password=123,debug=true,noSsl,flatten=[-1,100,1000]");
                    try (Statement stmt = con.createStatement()) {
        
        String queryo = String.format("\"%s\"",origen);
        String queryd = String.format("\"%s\"",destino);
        ResultSet rs = stmt.executeQuery("match (l {name: "+queryo+"})\n"+
                                         "match (m {name: "+queryd+"})\n"+
                                         "match path = shortestPath( (l)-[:WROTE*..3]-(m) ) \n"+
                                         "UNWIND nodes(path) as n\n" +
                                         "RETURN reduce(quantity=0, r in relationships(path) | quantity+r.quantity) AS totalWeight"); 
                                            //"RETURN n.name;");
        if (rs.next()){
            int minimoCorreos = rs.getInt("totalWeight");
            res ="Cantidad de correos de "+origen+" a "+destino+" es: "+minimoCorreos;
        
        } else {    res = "No hay correos entre "+origen + " y "+destino;
        } 
                    }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return res;
    }
}
