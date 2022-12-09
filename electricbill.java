import java.util.*;
import javax.swing.*;
import java.sql.*;
import com.mysql.cj.exceptions.RSAException;
import java.awt.*;
import java.awt.event.*; 
class User{
    int id;  
    Frame f = new Frame();
    void screen(){
        f.setExtendedState(f.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);
    } 
    void update(){
        try{
            Connection conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","March@222004");
            Statement stmt1 = conn.createStatement();
            String query1 = "update customer set work = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(query1);
            ps.setString(1,"paid");
            ps.setInt(2,id);
            ps.executeUpdate();
            ps.close();
        }
        catch(Exception e5){
            System.out.print(e5);
        }
    }
    void id(int id){
        this.id=id;
    }
    void check(){
    f.setBackground(Color.white);
    f.removeAll();
    Button b = new Button("Next");   
    Label l = new Label("ENTER ID:");
    Label l1 = new Label(   "* Invalid Id");
    Label lt = new Label("ONLINE ELECTRIC BILLING");
    TextField t = new TextField();
    lt.setFont(new Font("Comic Sans MS ", Font.PLAIN, 28));
    lt.setBounds(500,230,400,50);
    l.setBounds(550,330,120,50);
    t.setBounds(700,340,75,30);
    t.setBackground(Color.BLACK);
    t.setForeground(Color.white);
    l1.setBounds(800,330,125,30);
    b.setBounds(640,385,75,30);
    l.setForeground(Color.black);
    l.setFont(new Font("Comic Sans MS ", Font.PLAIN, 23));
    l1.setFont(new Font("Comic Sans MS ", Font.PLAIN, 18));
    l1.setForeground(Color.red);
    b.setForeground(Color.BLACK);
    b.setBackground(Color.white);
    f.add(b); 
    f.add(t);
    f.add(lt);
    f.add(l);
    f.setSize(300,300);  
    f.setTitle("Electric Bill");   
    f.setLayout(null);    
    b.addActionListener(new ActionListener() {    
        public void actionPerformed (ActionEvent e) { 
            String s = t.getText();
            int  i = Integer.parseInt(s);
                try{
                    Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","March@222004");
                    Statement stmt = con.createStatement();
                    String query="Select * from customer ";
                    ResultSet rs = stmt.executeQuery(query);
                    boolean ans = false;
                    int id;
                    String name;
                    int unit;
                    String area;
                    String type;
                    String work;
                    while(rs.next()){
                        id = rs.getInt("id");
                        if(id==i){
                            ans = true;
                            f.removeAll();
                            f.setBackground(Color.black);
                                name= rs.getString("name").trim();
                                unit = rs.getInt("unit");
                                type = rs.getString("type").trim();
                                area = rs.getString("area").trim();
                                work = rs.getString("work").trim();  
                                if(work.equals("notpaid")){
                                    id(id);
                                    Label l2 = new Label();
                                    Label l3 = new Label();
                                    Label l4 = new Label();
                                    Label l5 = new Label();
                                    Label l6 = new Label();
                                    Label l7 = new Label();
                                    Label st = new Label();
                                    l2.setBounds(500,250,200,50);
                                    l3.setBounds(500,300,250,50);
                                    l4.setBounds(500,350,500,50);
                                    l5.setBounds(500,400,250,50);
                                    l6.setBounds(500,450,250,50);
                                    l7.setBounds(500,500,250,50);
                                    st.setBounds(500,500,250,50);
                                    l2.setText("NAME : "+name.toUpperCase());
                                    l3.setText("AREA : "+area.toUpperCase());
                                    l4.setText("TYPE(D OR C OR H) : "+type.toUpperCase());
                                    l5.setText("UNIT  : "+unit);
                                    st.setText("STATUS : "+work.toUpperCase());
                                    f.add(l2);
                                    f.add(l3);
                                    f.add(l4);
                                    f.add(l5);
                                    f.add(st);
                                    l7.setText("The LAST DATE IS  10/12/22");
                                    if(type=="Domestic" | type=="house"){
                                        if(unit<=100){
                                            l6.setText("THE UNIT IS LESS THAN 100 NO NEED TO PAY");
                                        }
                                        else if(unit>100 & unit<=200){
                                            l6.setText("THE AMOUNT IS :"+(unit*2));
                                        }
                                        else if(unit>200 & unit <=400){
                                            l6.setText("THE AMOUNT IS :"+(unit*4));
                                        }
                                        else if(unit>400 & unit <=600){
                                            l6.setText("THE AMOUNT IS :"+(unit*6));
                                        }
                                        else if(unit>600 & unit <=800){
                                            l6.setText("THE AMOUNT IS :"+(unit*8));
                                        } 
                                        else if(unit>800 & unit<=1000){
                                            l6.setText("THE AMOUNT IS :"+(unit*10));
                                        }
                                        else{
                                        l6.setText("THE AMOUNT IS :"+(unit*12));
                                        }
                                    }
                                    else{
                                        if(unit<=100){
                                            l6.setText("THE AMOUNT IS :"+(unit*8));
                                        }
                                        else if(unit>100 & unit<=200){
                                            l6.setText("THE AMOUNT IS :"+(unit*10));
                                        }
                                        else if(unit>200 & unit <=400){
                                            l6.setText("THE AMOUNT IS :"+(unit*12));
                                        }
                                        else if(unit>400 & unit <=600){
                                            l6.setText("THE AMOUNT IS :"+(unit*14));
                                        }
                                        else if(unit>600 & unit <=800){
                                            l6.setText("THE AMOUNT IS :"+(unit*16));
                                        } 
                                        else if(unit>800 & unit<=1000){
                                            l6.setText("THE AMOUNT IS :"+(unit*18));
                                        }
                                        else{
                                            l6.setText("THE AMOUNT IS :"+(unit*20));
                                        }
                                    }
                                    l2.setForeground(Color.white);
                                    l3.setForeground(Color.white);
                                    l4.setForeground(Color.white);
                                    l5.setForeground(Color.white);
                                    l6.setForeground(Color.white);
                                    st.setForeground(Color.white);
                                    st.setFont(new Font("Comic Sans MS ", Font.PLAIN, 20));
                                    l2.setFont(new Font("Comic Sans MS ", Font.PLAIN, 20));
                                    l4.setFont(new Font("Comic Sans MS ", Font.PLAIN, 20));
                                    l3.setFont(new Font("Comic Sans MS ", Font.PLAIN, 20));
                                    l5.setFont(new Font("Comic Sans MS ", Font.PLAIN, 20));
                                    l6.setFont(new Font("Comic Sans MS ", Font.PLAIN, 20));
                                    f.add(l6);
                                    f.add(l7);
                                    Button b7 = new Button("Back");
                                    b7.setBounds(500,575,50,25);
                                    b7.setForeground(Color.black);
                                    b7.setBackground(Color.white);
                                    b7.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent e3){
                                           check(); 
                                        }
                                    });
                                    f.add(b7);
                                    Button b1 = new Button("Next");
                                    b1.setBounds(700,575,50,25);
                                    b1.addActionListener(new ActionListener() {  
                                        public void actionPerformed(ActionEvent e1){  
                                            f.removeAll();
                                            Label l8 = new Label("Make Payment");
                                            l8.setBounds(400,200,400,50);
                                            l8.setFont(new Font("Comic Sans MS ", Font.PLAIN, 20));
                                            l8.setForeground(Color.white);
                                            f.add(l8);
                                            Label l9 = new Label("Enter Cerit/Debit card number");
                                            l9.setBounds(450,280,400,50);
                                            l9.setFont(new Font("Comic Sans MS ", Font.PLAIN, 20));
                                            l9.setForeground(Color.white);
                                            f.add(l9);
                                            Label l10 = new Label("CVV");
                                            l10.setBounds(450,360,100,50);
                                            l10.setFont(new Font("Comic Sans MS ", Font.PLAIN, 20));
                                            l10.setForeground(Color.white);
                                            f.add(l10);
                                            Label l11= new Label("EXP DATE");
                                            l11.setBounds(450,420,100,50);
                                            l11.setFont(new Font("Comic Sans MS ", Font.PLAIN, 20));
                                            l11.setForeground(Color.white);
                                            f.add(l11);     
                                            TextField t1 = new TextField();
                                            TextField t2 = new TextField();
                                            TextField t3 = new TextField();
                                            t1.setBounds(450,335,90,30);
                                            t2.setBounds(550,370,75,30);
                                            t3.setBounds(600,430,75,30);
                                            f.add(t1);
                                            f.add(t2);
                                            f.add(t3);
                                            Button b9 = new Button("Home");
                                            b9.setBounds(500,575,50,25);
                                            b9.setForeground(Color.black);
                                            b9.setBackground(Color.white);
                                            b9.addActionListener(new ActionListener()
                                            {
                                                public void actionPerformed(ActionEvent e3){
                                                check(); 
                                                }
                                            });
                                            f.add(b9);
                                            Button b2 = new Button("Next");
                                            b2.setForeground(Color.black);
                                            b2.setBounds(675,575,50,25);
                                            b2.addActionListener(new ActionListener(){  
                                                public void actionPerformed(ActionEvent e2){  
                                                    String s1 = t1.getText();
                                                    String s2 = t2.getText();
                                                    String s3 = t3.getText();
                                                    if(s1.length()==12){
                                                        if(s2.length()==3){
                                                            if(s3.length()==5){
                                                                Label l15= new Label("OTP");
                                                                l15.setBounds(450,480,100,50);
                                                                l15.setFont(new Font("Comic Sans MS ", Font.PLAIN, 20));
                                                                l15.setForeground(Color.white);
                                                                f.add(l15);  
                                                                TextField t4 = new TextField();
                                                                t4.setBounds(550,480,90,30);
                                                                f.add(t4);
                                                                f.remove(b2);
                                                                Button b3 = new Button("Pay");
                                                                b3.setForeground(Color.BLACK);
                                                                b3.setBackground(Color.white);
                                                                b3.setBounds(675,575,50,25);
                                                                b3.addActionListener(new ActionListener(){  
                                                                    public void actionPerformed(ActionEvent e3){   
                                                                        String s3 = t4.getText(); 
                                                                        if(s3.length()==6){
                                                                            update();
                                                                            f.removeAll();
                                                                            int ascii = 10003;      
                                                                            String sign = Character.toString((char)ascii);
                                                                            Label l16 = new Label("SUCESSFULLY PAID "+sign);
                                                                            l16.setBounds(550,300,300,50);
                                                                            l16.setFont(new Font("Comic Sans MS ", Font.PLAIN, 25));
                                                                            l16.setForeground(Color.white);
                                                                            f.add(l16); 
                                                                            Button b9 = new Button("Home");
                                                                            b9.setBounds(500,575,50,25);
                                                                            b9.setForeground(Color.black);
                                                                            b9.setBackground(Color.white);
                                                                            b9.addActionListener(new ActionListener()
                                                                            {
                                                                                public void actionPerformed(ActionEvent e3){
                                                                                    check(); 
                                                                                }
                                                                            });
                                                                            f.add(b9);
                                                                        }
                                                                    }  
                                                                });
                                                                f.add(b3);
                                                            }
                                                            else{
                                                                Label l14 = new Label("* Invalid");
                                                                l14.setBounds(680,425,400,50);
                                                                l14.setFont(new Font("Comic Sans MS ", Font.PLAIN, 18));
                                                                l14.setForeground(Color.red);
                                                                f.add(l14);
                                                            }
                                                        }
                                                        else{
                                                            Label l13 = new Label("* Invalid");
                                                            l13.setBounds(630,365,400,50);
                                                            l13.setFont(new Font("Comic Sans MS ", Font.PLAIN, 18));
                                                            l13.setForeground(Color.RED);
                                                            f.add(l13);
                                                        }
                                                    }
                                                    else{
                                                        Label l12 = new Label("* Invalid");
                                                        l12.setBounds(540,330,400,50);
                                                        l12.setFont(new Font("Comic Sans MS ", Font.PLAIN, 18));
                                                        l12.setForeground(Color.red);
                                                        f.add(l12);
                                                    }  
                                                }  
                                            }); 
                                            f.add(b2);
                                            b2.setBackground(Color.white);
                                        }  
                                    });
                                f.add(b1);
                                b1.setForeground(Color.BLACK);
                                b1.setBackground(Color.white);
                                rs.close();
                            }
                            else{
                                Label l2 = new Label();
                                Label l3 = new Label();
                                Label l4 = new Label();
                                Label l5 = new Label();
                                Label l6 = new Label();
                                Label l7 = new Label();
                                Label st = new Label();
                                l2.setBounds(500,250,200,50);
                                l3.setBounds(500,300,250,50);
                                l4.setBounds(500,350,500,50);
                                l5.setBounds(500,400,250,50);
                                l6.setBounds(500,450,250,50);
                                l7.setBounds(500,500,250,50);
                                st.setBounds(500,500,250,50);
                                l2.setText("NAME : "+name.toUpperCase());
                                l3.setText("AREA : "+area.toUpperCase());
                                l4.setText("TYPE(D OR C OR H) : "+type.toUpperCase());
                                l5.setText("STATUS  : "+work.toUpperCase());
                                l2.setForeground(Color.white);
                                l3.setForeground(Color.white);
                                l4.setForeground(Color.white);
                                l5.setForeground(Color.white);
                                l2.setFont(new Font("Comic Sans MS ", Font.PLAIN, 20));
                                l4.setFont(new Font("Comic Sans MS ", Font.PLAIN, 20));
                                l3.setFont(new Font("Comic Sans MS ", Font.PLAIN, 20));
                                l5.setFont(new Font("Comic Sans MS ", Font.PLAIN, 20));
                                f.add(l2);
                                f.add(l3);
                                f.add(l4);
                                f.add(l5);      
                                Button b6 = new Button("Back");
                                b6.setBounds(600,575,50,25);
                                b6.setForeground(Color.black);
                                b6.setBackground(Color.white);
                                b6.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e3){
                                       check(); 
                                    }
                                });
                                f.add(b6);
                            }
                        }
                        else{
                            continue;
                        }
                    }
                    if(ans){
                        System.out.print("Thank you");
                    }
                    else{
                        f.add(l1);
                    }
                }    
                catch(Exception e1){
                    System.out.print(e1);
                }
            }    
        });  
        screen();
    }
}
class electricbill
{
    public static void main(String[] args){
       User u = new User();
       u.check();
    }
}