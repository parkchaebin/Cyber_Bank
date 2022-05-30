/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyber.bank.gui;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import user.User;

/**
 *
 * @author User
 */
public class User_Main extends javax.swing.JFrame {
    DefaultTableModel table;
    Connection conn =null;
    PreparedStatement pstmt =null;
    ResultSet rs = null;
    User user;
    /**
     * Creates new form test
     */
    public User_Main(User user) {
            initComponents();
            this.user = user;
            NAME.setText(user.getName());
            LEVEL.setText(user.getLevel());
            removeAll();
            MAIN_P.setVisible(true);
            createMain();
    }
    
    
    public void removeAll(){
        CREATE_P.setVisible(false);
        EVENT_P.setVisible(false);
        MAIN_P.setVisible(false);
        SEND_P.setVisible(false);
        PRODUCT_P.setVisible(false);
    }
    
    public void createMain(){ //메인 패널에 있는 보유 계좌 테이블 출력
        table = (DefaultTableModel) A_TABLE.getModel();
        table.setRowCount(0);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //접속 URL
            String jdbcDriver ="jdbc:mysql://118.67.129.235:3306/bank?serverTimezone=UTC"; 
            String dbUser ="banker"; //MySQL 접속 아이디
            String dbPass ="1234"; //비밀번호
            //Mysql bank 데이터베이스와 연결
            String sql = "select * from account where id=?";
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getId());
            rs = pstmt.executeQuery();
            while(rs.next()){
                Object[] list = {rs.getString("account_num"), rs.getString("balance"),rs.getString("kind") ,rs.getString("card") }; 
                table.addRow(list);
            }
            
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (rs !=null) try {rs.close();} catch (SQLException ex) {}
            if (pstmt !=null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        MAIN_P = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        A_TABLE = new javax.swing.JTable();
        SEND_P = new javax.swing.JPanel();
        TITLE_P = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        MENU_P = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        NAME = new javax.swing.JLabel();
        LEVEL = new javax.swing.JLabel();
        CREATE = new javax.swing.JButton();
        EVENT = new javax.swing.JButton();
        SEND = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        LOGOUT = new javax.swing.JButton();
        TOMAIN = new javax.swing.JButton();
        EVENT_P = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        E_TABLE = new javax.swing.JTable();
        CREATE_P = new javax.swing.JPanel();
        CREATE_N = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        C_NAME = new javax.swing.JTextField();
        C_ID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        C_PW = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        C_KIND = new javax.swing.JComboBox<>();
        PRODUCT_P = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("메론소다");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 500));

        jPanel4.setMinimumSize(new java.awt.Dimension(700, 200));
        jPanel4.setPreferredSize(new java.awt.Dimension(700, 500));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MAIN_P.setBackground(new java.awt.Color(255, 255, 255));

        A_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "계좌 번호", "잔액", "종류", "카드 개설"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(A_TABLE);

        javax.swing.GroupLayout MAIN_PLayout = new javax.swing.GroupLayout(MAIN_P);
        MAIN_P.setLayout(MAIN_PLayout);
        MAIN_PLayout.setHorizontalGroup(
            MAIN_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MAIN_PLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        MAIN_PLayout.setVerticalGroup(
            MAIN_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MAIN_PLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel4.add(MAIN_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 550, 400));

        SEND_P.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout SEND_PLayout = new javax.swing.GroupLayout(SEND_P);
        SEND_P.setLayout(SEND_PLayout);
        SEND_PLayout.setHorizontalGroup(
            SEND_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        SEND_PLayout.setVerticalGroup(
            SEND_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jPanel4.add(SEND_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 550, 400));

        TITLE_P.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("함초롬돋움", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MelonSoda Bank");

        javax.swing.GroupLayout TITLE_PLayout = new javax.swing.GroupLayout(TITLE_P);
        TITLE_P.setLayout(TITLE_PLayout);
        TITLE_PLayout.setHorizontalGroup(
            TITLE_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TITLE_PLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );
        TITLE_PLayout.setVerticalGroup(
            TITLE_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TITLE_PLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        jPanel4.add(TITLE_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, -1));

        MENU_P.setBackground(new java.awt.Color(204, 255, 204));
        MENU_P.setPreferredSize(new java.awt.Dimension(150, 400));

        jLabel2.setText("님");

        NAME.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NAME.setText("고객");

        LEVEL.setFont(new java.awt.Font("굴림", 1, 15)); // NOI18N
        LEVEL.setText("Normal");

        CREATE.setFont(new java.awt.Font("굴림", 0, 12)); // NOI18N
        CREATE.setText("계좌 개설하기");
        CREATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CREATEActionPerformed(evt);
            }
        });

        EVENT.setFont(new java.awt.Font("굴림", 0, 12)); // NOI18N
        EVENT.setText("공지사항확인");
        EVENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EVENTActionPerformed(evt);
            }
        });

        SEND.setFont(new java.awt.Font("굴림", 0, 12)); // NOI18N
        SEND.setText("송금하기");
        SEND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SENDActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N
        jLabel3.setText("메뉴");

        LOGOUT.setFont(new java.awt.Font("굴림", 0, 12)); // NOI18N
        LOGOUT.setText("로그아웃");
        LOGOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGOUTActionPerformed(evt);
            }
        });

        TOMAIN.setFont(new java.awt.Font("굴림", 0, 12)); // NOI18N
        TOMAIN.setText("메인으로");
        TOMAIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TOMAINActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MENU_PLayout = new javax.swing.GroupLayout(MENU_P);
        MENU_P.setLayout(MENU_PLayout);
        MENU_PLayout.setHorizontalGroup(
            MENU_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU_PLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(MENU_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MENU_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(LOGOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TOMAIN, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MENU_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(SEND, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EVENT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CREATE, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENU_PLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MENU_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MENU_PLayout.createSequentialGroup()
                        .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MENU_PLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(LEVEL)))
                .addGap(22, 22, 22))
        );
        MENU_PLayout.setVerticalGroup(
            MENU_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU_PLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(MENU_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LEVEL)
                .addGap(31, 31, 31)
                .addComponent(CREATE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EVENT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SEND)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(TOMAIN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LOGOUT)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel4.add(MENU_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        EVENT_P.setBackground(new java.awt.Color(255, 255, 255));
        EVENT_P.setPreferredSize(new java.awt.Dimension(550, 400));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 200));

        E_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "일시", "제목"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        E_TABLE.setGridColor(new java.awt.Color(204, 204, 204));
        E_TABLE.setRowSorter(null);
        E_TABLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E_TABLEMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(E_TABLE);

        javax.swing.GroupLayout EVENT_PLayout = new javax.swing.GroupLayout(EVENT_P);
        EVENT_P.setLayout(EVENT_PLayout);
        EVENT_PLayout.setHorizontalGroup(
            EVENT_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EVENT_PLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EVENT_PLayout.setVerticalGroup(
            EVENT_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EVENT_PLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel4.add(EVENT_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 550, -1));

        CREATE_P.setBackground(new java.awt.Color(255, 255, 255));
        CREATE_P.setPreferredSize(new java.awt.Dimension(550, 400));

        CREATE_N.setFont(new java.awt.Font("굴림", 0, 12)); // NOI18N
        CREATE_N.setText("다음");
        CREATE_N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CREATE_NActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 255, 204), 3, true));

        C_NAME.setEditable(false);

        C_ID.setEditable(false);

        jLabel5.setText("통장 종류");

        jLabel4.setText("계좌 비밀 번호");

        jLabel7.setText("이름");

        jLabel6.setText("ID ");

        C_KIND.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "입출금통장", "적금통장", "주택청약통장" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(C_PW, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(C_KIND, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(C_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(C_NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 249, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(C_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel7)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(C_NAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(C_PW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(C_KIND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout CREATE_PLayout = new javax.swing.GroupLayout(CREATE_P);
        CREATE_P.setLayout(CREATE_PLayout);
        CREATE_PLayout.setHorizontalGroup(
            CREATE_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CREATE_PLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(CREATE_N, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        CREATE_PLayout.setVerticalGroup(
            CREATE_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CREATE_PLayout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(CREATE_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CREATE_N)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        jPanel4.add(CREATE_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 550, -1));

        javax.swing.GroupLayout PRODUCT_PLayout = new javax.swing.GroupLayout(PRODUCT_P);
        PRODUCT_P.setLayout(PRODUCT_PLayout);
        PRODUCT_PLayout.setHorizontalGroup(
            PRODUCT_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        PRODUCT_PLayout.setVerticalGroup(
            PRODUCT_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jPanel4.add(PRODUCT_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 550, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //계좌 개설 메뉴 클릭시
    private void CREATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CREATEActionPerformed
        removeAll();
        CREATE_P.setVisible(true);
        C_ID.setText(user.getId());
        C_NAME.setText(user.getName());
    }//GEN-LAST:event_CREATEActionPerformed
    
    //공지사항 메뉴 클릭시
    private void EVENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EVENTActionPerformed
        removeAll();
        EVENT_P.setVisible(true);
        table = (DefaultTableModel) E_TABLE.getModel();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //접속 URL
            String jdbcDriver ="jdbc:mysql://118.67.129.235:3306/bank?serverTimezone=UTC";
            String dbUser ="banker"; //MySQL 접속 아이디
            String dbPass ="1234"; //비밀번호
            String sql = "select * from user_news"; 
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            table.setNumRows(0);
            while(rs.next()){
                Object[] list = {rs.getString("date"),rs.getString("title")};
                table.addRow(list);//행추가
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if (rs !=null) try {rs.close();} catch (SQLException ex) {}
            if (pstmt !=null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn !=null) try { conn.close(); } catch(SQLException ex) {}
        }
    }//GEN-LAST:event_EVENTActionPerformed
    
    //공지사항 테이블에서 공지사항 하나 클릭시
    private void E_TABLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E_TABLEMouseClicked
        int row = E_TABLE.getSelectedRow();
        String key = (String) E_TABLE.getValueAt(row, 1);
        Event_View v = new Event_View(key);
        v.setVisible(true);
    }//GEN-LAST:event_E_TABLEMouseClicked
    
    //로그아웃 버튼
    private void LOGOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGOUTActionPerformed
         Login_Frame login = new Login_Frame();
        login.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_LOGOUTActionPerformed
    
    //송금하기 버튼 클릭시
    private void SENDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SENDActionPerformed
        
    }//GEN-LAST:event_SENDActionPerformed

    //메인으로 한번에 가는 버튼
    private void TOMAINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TOMAINActionPerformed
        removeAll();
        MAIN_P.setVisible(true);
        createMain();
    }//GEN-LAST:event_TOMAINActionPerformed

    //계좌 정보 입력 후 상품 선택으로 넘어가는 버튼
    private void CREATE_NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CREATE_NActionPerformed
        String id = C_ID.getText(); //화면에 있는 아이디 값 받아오기
        String name = C_NAME.getText(); //화면에 있는 이름 값 받아오기
        String pw = C_PW.getText(); //화면에 있는 비밀번호 값 받아오기
        String kind = C_KIND.getSelectedItem().toString(); // 화면에 있는 통장 종류 값 받아오기
        
    }//GEN-LAST:event_CREATE_NActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable A_TABLE;
    private javax.swing.JButton CREATE;
    private javax.swing.JButton CREATE_N;
    private javax.swing.JPanel CREATE_P;
    private javax.swing.JTextField C_ID;
    private javax.swing.JComboBox<String> C_KIND;
    private javax.swing.JTextField C_NAME;
    private javax.swing.JTextField C_PW;
    private javax.swing.JButton EVENT;
    private javax.swing.JPanel EVENT_P;
    private javax.swing.JTable E_TABLE;
    private javax.swing.JLabel LEVEL;
    private javax.swing.JButton LOGOUT;
    private javax.swing.JPanel MAIN_P;
    private javax.swing.JPanel MENU_P;
    private javax.swing.JLabel NAME;
    private javax.swing.JPanel PRODUCT_P;
    private javax.swing.JButton SEND;
    private javax.swing.JPanel SEND_P;
    private javax.swing.JPanel TITLE_P;
    private javax.swing.JButton TOMAIN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
