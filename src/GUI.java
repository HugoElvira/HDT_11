
package Hoja10;


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
        verGrafo = new javax.swing.JButton();
        grafo2 = new javax.swing.JButton();
        verPagerank = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        pEmisor = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        pReceptor = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        //Se inicializa la interfaz grafica
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Correos"));

        verGrafo.setText("Ver grafo");
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

        jButton2.setText("Ver mas comunicados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Ver menos comunicados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        pEmisor.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  "Per 1", "Per 2", "Per 3", "Per 4", "Per 5", "Per 6", "Per 7", "Per 8", "Per 9", "Per 10", "Per 11", "Per 12", "Per 13", "Per 14", "Todos"}));

        jLabel1.setText("Emisor");

        pReceptor.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  "Per 1", "Per 2", "Per 3", "Per 4", "Per 5", "Per 6", "Per 7", "Per 8", "Per 9", "Per 10", "Per 11", "Per 12", "Per 13", "Per 14" }));

        jLabel2.setText("Receptor");

        jButton3.setText("Ver correos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        
        //Componentes arrojados por NetBeans
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(verGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(grafo2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(45, Short.MAX_VALUE)
                                .addComponent(verPagerank)
                                .addGap(23, 23, 23))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton3))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verGrafo)
                    .addComponent(grafo2))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(verPagerank)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2)
                        .addGap(35, 35, 35)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pEmisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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
