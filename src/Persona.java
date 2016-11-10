/** 
* Clase: GraphDB.java
* @author Diego Soler, Hugo Elvira, Edgar Ramírez
* @version 09/11/16
*/


public class Persona implements Comparable<Persona>{
    private Integer num;
    private String name;

    public Persona(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }
    public String getName(){
        return name;
    }
    
    
    @Override
    public int compareTo(Persona p){
        return num.compareTo(p.getNum());
    }
    
    
    
}
