import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/** 
* Clase: GUI.java
* Se maneja el main y la interfaz grafica
* @author Diego Soler, Hugo Elvira, Edgar Ramírez
* @version 09/11/16
*/


public class GUI extends javax.swing.JFrame {
	
	//Nueva base de datos basada en grafos 
    GraphDatabase graphdb = new GraphDatabase();
    
    //Atributos de la base de datos creada
    private javax.swing.JButton grafo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox pReceptor;
    private javax.swing.JComboBox pEmisor;
    private javax.swing.JTextArea textArea;
    private javax.swing.JButton verGrafo;
    private javax.swing.JButton verPagerank;
   
   
    public GUI() {
        iniciarInterfaz();
        graphdb.crearGrafo(); //Creamos grafo
    }

   
    private void iniciarInterfaz() {

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setToolTipText("");
        verGrafo = new javax.swing.JButton();
        verGrafo.setBounds(42, 27, 143, 23);
        grafo2 = new javax.swing.JButton();
        grafo2.setBounds(207, 27, 250, 23);
        verPagerank = new javax.swing.JButton();
        verPagerank.setBounds(475, 27, 155, 23);
        jButton2 = new javax.swing.JButton();
        jButton2.setBounds(78, 61, 243, 23);
        jButton1 = new javax.swing.JButton();
        jButton1.setBounds(331, 61, 259, 23);
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setBounds(147, 188, 342, 143);
        pEmisor = new javax.swing.JComboBox();
        pEmisor.setBounds(304, 119, 56, 20);
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBounds(119, 122, 150, 14);
        pReceptor = new javax.swing.JComboBox();
        pReceptor.setBounds(304, 150, 56, 20);
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setBounds(119, 153, 150, 14);
        jButton3 = new javax.swing.JButton();
        jButton3.setBounds(388, 132, 115, 23);

        //Se inicializa la interfaz grafica
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Comunicaciones"));

        verGrafo.setText("Visualizar grafo");
        verGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verGrafoActionPerformed(evt);
            }
        });

        grafo2.setText("Visualizar grafo de 6 o mas correos");
        grafo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grafo2ActionPerformed(evt);
            }
        });

        verPagerank.setText("Visualizar PageRank");
        verPagerank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verPagerankActionPerformed(evt);
            }
        });

        jButton2.setText("Trabajadores mas comunicados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Trabajadores menos comunicados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        pEmisor.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  "Per 1", "Per 2", "Per 3", "Per 4", "Per 5", "Per 6", "Per 7", "Per 8", "Per 9", "Per 10", "Per 11", "Per 12", "Per 13", "Per 14", "Todos"}));

        jLabel1.setText("Persona que env\u00EDa");

        pReceptor.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  "Per 1", "Per 2", "Per 3", "Per 4", "Per 5", "Per 6", "Per 7", "Per 8", "Per 9", "Per 10", "Per 11", "Per 12", "Per 13", "Per 14" }));

        jLabel2.setText("Persona que recibe");

        jButton3.setText("Ver correos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        textArea = new javax.swing.JTextArea();
        jScrollPane1.setViewportView(textArea);
        
                textArea.setColumns(20);
                textArea.setRows(5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(45)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel1.setLayout(null);
        jPanel1.add(jScrollPane1);
        jPanel1.add(jButton2);
        jPanel1.add(grafo2);
        jPanel1.add(verGrafo);
        jPanel1.add(jButton1);
        jPanel1.add(jButton3);
        jPanel1.add(verPagerank);
        jPanel1.add(jLabel1);
        jPanel1.add(jLabel2);
        jPanel1.add(pReceptor);
        jPanel1.add(pEmisor);
        getContentPane().setLayout(layout);

        pack();
    }

    //Metodo para ver grafo
    private void verGrafoActionPerformed(java.awt.event.ActionEvent evt) {
        graphdb.mostrarGrafo1();

    }

    //Metodo para ver grafo de 6 o mas relaciones
    private void grafo2ActionPerformed(java.awt.event.ActionEvent evt) {
        graphdb.mostrarGrafo2();
    }

    //Metodo para ver PageRank
    private void verPagerankActionPerformed(java.awt.event.ActionEvent evt) {
        
        textArea.setText("");
        graphdb.pagerank();
        textArea.setText(graphdb.getRankings());
    }

    //Metodo para ver datos sobre las comunicaciones
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        textArea.setText("");
        textArea.setText(graphdb.masComunicados());
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
       
        textArea.setText("");
        textArea.setText(graphdb.menosComunicados());
    }

    //Metodo para ver los correos
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
       
        textArea.setText("");
        
        String origen = pEmisor.getSelectedItem().toString();
        String destino = pReceptor.getSelectedItem().toString();
        if (!destino.equals("Todos")){
        textArea.setText(graphdb.correos(origen, destino));
        } else {
            String[] destinos = new String[14];
            for (int i = 0; i<14; i++){
                destinos[i] = "Per "+(i+1);
            }
            String res = "";
            for (String str : destinos){
                res = res + graphdb.correos(origen, str) +"\n";
            }
            textArea.setText(res);
        }
    }

    //Main
    public static void main(String args[]) {
      
    			//Mostramos la GUI y sucede la MAGIA
                new GUI().setVisible(true);
            
       
    }
    
}
