/**
 * @author grupo: Hugo Elvira 15249, Edgar Ramírez 15236 y Diego Soler 15415
 * @version 02/10/2016
 * @Description: Ordena la agenda de la clinica en general, por nivel de emergencia
 */

import java.io.File;

import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class pruebaN4J{
	private static final String pruebaN4j = "C:\\Users\\Hugo Elvira\\Documents\\Neo4j\\DataBase";
	
	Node uvg;
	Node estudiante1;
	Relationship relation;
	GraphDatabaseService graphDataService;
	
	public enum NodeType implements Label{
		Estudiante,Universidad;
	}
	
	public enum RelTypes implements RelationshipType{
		STUDY;
	}
	
	public static void main(String[] args){
		pruebaN4J hello = new pruebaN4J();
		hello.createDatabase();
		//hello.removeData();
		hello.shutDown();
	}
	
	void createDatabase(){
		File archivo = new File(pruebaN4j);
		graphDataService = new GraphDatabaseFactory().newEmbeddedDatabase(archivo);
		Transaction transaction = graphDataService.beginTx();
		try {
			uvg = graphDataService.createNode(NodeType.Universidad);
			uvg.setProperty("Nombre", "Universidad del Valle de Guatemala");
			estudiante1 = graphDataService.createNode(NodeType.Estudiante);
			estudiante1.setProperty("Nombre", "Edgar Ramírez");
			
			relation = uvg.createRelationshipTo(estudiante1, RelTypes.STUDY);
			relation.setProperty("relationship-type", "estuia en ");
			System.out.println(estudiante1.getProperty("Nombre")+" " + relation.getProperty("relationship-type")+" "+uvg.getProperty("Nombre"));
			
			//Transacción
			transaction.success();
		}
		finally{
			transaction.close();
		}
	}
	
	void removeData(){
		Transaction transaction = graphDataService.beginTx();
		
		try{
			
			//Eliminar
			uvg.getSingleRelationship(RelTypes.STUDY, Direction.OUTGOING).delete();
			System.out.println("Se remueven los nodos");
			
			//Eliminar Nodos
			uvg.delete();
			estudiante1.delete();
			transaction.success();
		}
		finally{
			//Elimanar transacción
			transaction.close();
		}
	}
	
	void shutDown(){
		//Apagar Base de Datos
		graphDataService.shutdown();
		System.out.println("Se ha cerreado la base de datos");
	}
	
}
