import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;

public class Voucher_Management_Service {

	private JFrame frame;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voucher_Management_Service window = new Voucher_Management_Service();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
private static Voucher_Management_Service obj = null;
	
	
	public static Voucher_Management_Service getInstance() throws IOException {
	
		if(obj == null) {
			obj = new Voucher_Management_Service();
		}
	return obj;	
	}
	
	private Voucher_Management_Service() throws IOException {
		initialize();
		frame.getContentPane().setLayout(null);
		
	
		
		JButton b=new JButton("Incarcati fisierele"); 
		b.setLocation(180, 350);
		b.setSize(257, 38);
		frame.getContentPane().add(b);
		b.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				Test nnew = new Test();
				JFileChooser j = new JFileChooser();
				j.showSaveDialog(null);	
				String s =j.getSelectedFile().toString();
				
				if(s.equals("C:\\Users\\Vlad\\eclipse-workspace\\PROJECT\\src\\test01\\input\\campaigns.txt")) {
					try {
						nnew.CAMP_READ(s);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}	
					}
				
				if(s.equals("C:\\Users\\Vlad\\eclipse-workspace\\PROJECT\\src\\test01\\input\\users.txt")) {
					try {
						nnew.USR_READ(s);;
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					
					}
				
				
				}  
	});
		
		JTextField t1 = new JTextField();
		JTextField t2 = new JTextField();
		JTextField t3 = new JTextField("Login");
		JTextField t4 = new JTextField("Parola");
		
		t1.setSize(150, 30);
		t1.setLocation(120, 50);
		t2.setSize(150,30);
		t2.setLocation(400, 50);
		t3.setSize(80,30);
		t3.setEditable(false);
		t3.setLocation(50, 50);
		t4.setSize(80,30);
		t4.setEditable(false);
		t4.setLocation(320, 50);
		frame.getContentPane().add(t1);
		frame.getContentPane().add(t2);
		frame.getContentPane().add(t3);
		frame.getContentPane().add(t4);
		BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\Vlad\\eclipse-workspace\\PROJECT\\src\\log1.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setSize(283,268);
		picLabel.setLocation(163, 94);
		frame.getContentPane().add(picLabel);
		
		BufferedImage myPicture1 = ImageIO.read(new File("C:\\Users\\Vlad\\eclipse-workspace\\PROJECT\\src\\admin.png"));
		JLabel picLabel1 = new JLabel(new ImageIcon(myPicture1));
		picLabel1.setSize(100,30);
		picLabel1.setLocation(180, 3);
		frame.getContentPane().add(picLabel1);
		picLabel1.setVisible(false);
		
		ImageIcon img = new ImageIcon("C:\\Users\\Vlad\\eclipse-workspace\\PROJECT\\src\\vms.png");
		frame.setIconImage(img.getImage());
		
		
		JButton b1 = new JButton("Logare");
		b1.setSize(100, 30);
		b1.setLocation(233, 91);
		frame.getContentPane().add(b1);
		
		JButton b2 = new JButton("Colectie Campanii");
		b2.setSize(403,58);
		b2.setLocation(100, 192);
		frame.getContentPane().add(b2);
		b2.setVisible(false);
		
		JButton b3 = new JButton("Inapoi");
		b3.setSize(140,58);
		b3.setLocation(44, 26);
		frame.getContentPane().add(b3);
		b3.setVisible(false);
		
		JButton b4 = new JButton("Vouchere Persoanale");
		b4.setLocation(100, 330);
		b4.setSize(403,58);
		frame.getContentPane().add(b4);
		b4.setVisible(false);
		
		JButton b5 = new JButton("Administrarea voucherelor");
		b5.setLocation(100, 77);
		b5.setSize(403,58);
		frame.getContentPane().add(b5);
		b5.setVisible(false);
		
		JButton b6 = new JButton("Administrarea campaniilor");
		b6.setLocation(110, 218);
		b6.setSize(403,58);
		frame.getContentPane().add(b6);
		b6.setVisible(false);
		
		JButton b7 = new JButton("Delogare");
		b7.setLocation(512, 11);
		b7.setSize(100,38);
		frame.getContentPane().add(b7);
		b7.setVisible(false);
		
		JList l = new JList();
        l.setSize(446,264);
        l.setLocation(104,150);
        frame.getContentPane().add(l);
        l.setVisible(false);
        
        JList l1 = new JList();
        l1.setSize(446,264);
        l1.setLocation(100,150);
        frame.getContentPane().add(l1); 
        l1.setVisible(false);
        
        JTextField t5 = new JTextField();
        t5.setSize(113,30);
		t5.setLocation(245, 150);
		frame.getContentPane().add(t5);
		t5.setVisible(false);
		
		JButton b8 = new JButton("Vouchere existente");
		b8.setLocation(100, 38);
		b8.setSize(421,55);
		frame.getContentPane().add(b8);
		b8.setVisible(false);
		
		JButton b15 = new JButton("Afisare Campanii");
		b15.setLocation(100, 79);
		b15.setSize(421,55);
		frame.getContentPane().add(b15);
		b15.setVisible(false);
		
		
		
		JButton b17 = new JButton("Inapoi");
		b17.setLocation(0, 3);
		b17.setSize(80,55);
		frame.getContentPane().add(b17);
		b17.setVisible(false);
		
		
		
		
		b1.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e){
				String log = t1.getText();
				String pass = t2.getText();
				int i = 0;
				while(!VMS.getInstance().getUsers().get(i).NAME.equals(log) && VMS.getInstance().getUsers().size() > i){
					i++;	
				}
				if(VMS.getInstance().getUsers().get(i).PASSWORD.equals(pass)) {
					if(VMS.getInstance().getUsers().get(i).TYPE.equals(User.UserType.GUEST)) {
						b2.setVisible(true);
						b1.setVisible(false);
						b1.setEnabled(false);
						b.setEnabled(false);
						b.setVisible(false);
						t1.setVisible(false);
						t2.setVisible(false);
						t3.setVisible(false);
						t4.setVisible(false);
						picLabel.setVisible(false);
						b4.setVisible(true);
						b7.setVisible(true);
					}else if(VMS.getInstance().getUsers().get(i).TYPE.equals(User.UserType.ADMIN)){
						b1.setVisible(false);
						b1.setEnabled(false);
						b.setEnabled(false);
						b.setVisible(false);
						t1.setVisible(false);
						t2.setVisible(false);
						t3.setVisible(false);
						t4.setVisible(false);
						picLabel.setVisible(false);
						picLabel1.setVisible(true);
						b6.setVisible(true);
						b5.setVisible(true);
						b7.setVisible(true);
						t5.setVisible(true);
					}
					
				}else {
					
					System.out.println("Date introduse gresit");
				}
			}
			
			
			
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector v = new Vector();
				for(int i =0;i<VMS.getInstance().getCamp().size();i++) {
					v.add(VMS.getInstance().getCamp().get(i).toString());
				}
				l.setListData(v);
		        l.setVisible(true);
		        b2.setVisible(false);
		        b2.setEnabled(false);
		        b3.setVisible(true);
		        b4.setVisible(false);
		        
			}
			
			
			
		});
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l.setVisible(false);
				b3.setVisible(false);
				b2.setVisible(true);
				b2.setEnabled(true);
				b4.setVisible(true);
				b4.setEnabled(true);
				l1.setVisible(false);
				
			}
			
			
			
		});
		
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b2.setVisible(false);
				b2.setEnabled(false);
				b3.setVisible(true);
				b4.setVisible(false);
				
				String user = t1.getText();
				int id = Integer.parseInt(user.substring(user.indexOf("_")+1));
				Vector v1  = new Vector();
				for(int i = 0 ;i<VMS.getInstance().getUsers().get(id-1).Vouch1.V_Value.size();i++) {
					v1.add(VMS.getInstance().getUsers().get(id-1).Vouch1.V_Value.get(i));
				}
				
				l1.setListData(v1);
				l1.setVisible(true);
				
			}
			
			
			
		});
		String row[][] = {{"               ","               ","                ","                ","               ","                "},
				{"               ","               ","                ","                ","               ","                "},
				{"               ","               ","                ","                ","               ","                "},
				{"               ","               ","                ","                ","               ","                "},
				{"               ","               ","                ","                ","               ","                "},
				{"               ","               ","                ","                ","               ","                "},
				{"               ","               ","                ","                ","               ","                "},
				{"               ","               ","                ","                ","               ","                "},
				{"               ","               ","                ","                ","               ","                "},
				{"               ","               ","                ","                ","               ","                "},
				{"               ","               ","                ","                ","               ","                "},
				{"               ","               ","                ","                ","               ","                "},
				{"               ","               ","                ","                ","               ","                "},
				{"               ","               ","                ","                ","               ","                "},
				
				{"               ","               ","                ","                ","               ","                "}
						};
		String column[]  = {" "," "," "," "," "};
		JTable tb = new JTable(row,column);
		frame.getContentPane().add(tb);
		tb.setSize(525,237);
		tb.setLocation(50, 164);
		tb.setVisible(false);
		tb.setEnabled(false);
		
		JTextField t6 = new JTextField("Introducere USER_EMAIL");
		t6.setSize(152,30);
		t6.setLocation(71, 91);
		frame.getContentPane().add(t6);
		t6.setVisible(false);
        
        JTextField t7 = new JTextField("Introducere Voucher_Type");
        t7.setSize(150,30);
		t7.setLocation(400, 91);
		frame.getContentPane().add(t7);
		t7.setVisible(false);
        
        JTextField t8 = new JTextField("Introducere valoare");
        t8.setSize(161,30);
        t8.setLocation(72, 213);
		frame.getContentPane().add(t8);
		t8.setVisible(false);
        
        JTextField t9 = new JTextField("Introducere USER_ID");
        t9.setSize(150,30);
        t9.setLocation(400, 213);
		frame.getContentPane().add(t9);
		t9.setVisible(false);
		
		JButton b10 = new JButton("Generare Voucher");
		b10.setLocation(100, 190);
		b10.setSize(421,63);
		frame.getContentPane().add(b10);
		b10.setVisible(false);
		
		JButton b11 = new JButton("Genereaza");
		b11.setLocation(100,350);
		b11.setSize(421,63);
		frame.getContentPane().add(b11);
		b11.setVisible(false);
		
		 JButton b12 = new JButton("Marcheaza utilizat");
		 b12.setLocation(100, 276);
		 b12.setSize(421,63);
		 frame.getContentPane().add(b12);
		 b12.setVisible(false);
		
		 JButton b9 = new JButton("Inapoi");
		 b9.setLocation(27, 26);
		 b9.setSize(132,37);
		 frame.getContentPane().add(b9);
		 b9.setVisible(false);
		
		 JTextField t10 = new JTextField();
	     t10.setSize(182,30);
	     t10.setLocation(202, 399);
	     frame.getContentPane().add(t10);
		 t10.setVisible(false);
		
		 JButton b13 = new JButton("Observatori si vouchere utilizate");
		 b13.setLocation(100, 117);
		 b13.setSize(419,58);
		 frame.getContentPane().add(b13);
		 b13.setVisible(false);
		 
		 JTextField t11 = new JTextField("Vouchere utilizate");
		 t11.setSize(113,30);
		 t11.setLocation(287, 26);
		 frame.getContentPane().add(t11);
		 t11.setVisible(false);
		 t11.setEnabled(false);
		
		 JTextField t12 = new JTextField();
		 t12.setSize(113,30);
		 t12.setLocation(400, 26);
		 frame.getContentPane().add(t12);
		 t12.setVisible(false);
		 t12.setEnabled(false);
		 
		 JButton b16 = new JButton("Inchide o campanie");
		 b16.setLocation(100, 164);
		 b16.setSize(419,58);
		 frame.getContentPane().add(b16);
		 b16.setVisible(false);
		 
		 JTextField t13 = new JTextField();
		 t13.setSize(113,30);
		 t13.setLocation(233, 232);
		 frame.getContentPane().add(t13);
		 t13.setVisible(false);
		 
		 JButton b18 = new JButton("Vizualizare detalii Campanie");
		 b18.setLocation(84, 281);
		 b18.setSize(419,58);
		 frame.getContentPane().add(b18);
		 b18.setVisible(false);
		 
		 JTextField t14 = new JTextField();
		 t14.setSize(113,30);
		 t14.setLocation(233, 344);
		 frame.getContentPane().add(t14);
		 t14.setVisible(false);
		 
		 b18.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					b18.setVisible(false);
					Vector v = new Vector();
					int id = Integer.parseInt(t14.getText());
					v.add("ID:"+VMS.getInstance().getCamp().get(id-1).ID);
					v.add("NAME:"+VMS.getInstance().getCamp().get(id-1).NAME);
					v.add("DISP_NUMBER:"+VMS.getInstance().getCamp().get(id-1).DISP_NUMBER);
					v.add("Status:"+VMS.getInstance().getCamp().get(id-1).STATUS.toString());
					v.add("START_DATE:"+VMS.getInstance().getCamp().get(id-1).START_DATE);
					v.add("END_DATE:"+VMS.getInstance().getCamp().get(id-1).END_DATE);
					v.add("Strategy:"+VMS.getInstance().getCamp().get(id-1).Strategy);
					t14.setVisible(false);
					b16.setVisible(false);
					l.setListData(v);
					l.setVisible(true);
					t13.setVisible(false);
					b15.setVisible(false);
					
				}
			});
		 
		 
		 
		 b17.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					b17.setVisible(false);
					b8.setVisible(false);
					b7.setVisible(true);
					b5.setVisible(true);
					b6.setVisible(true);
					b10.setVisible(false);
					b12.setVisible(false);
					b13.setVisible(false);
					t10.setVisible(false);
					t5.setVisible(true);
					b16.setVisible(false);
					b15.setVisible(false);
					t13.setVisible(false);
					b18.setVisible(false);
					t14.setVisible(false);
					l.setVisible(false);
					
				}
			});
		 
		 
		 b16.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e){
					int id = Integer.parseInt(t13.getText());
					VMS.getInstance().cancelCampaign(id);
					
				}
				
				
				
			});
		 
		 
		 b6.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e){
					b6.setVisible(false);
					b5.setVisible(false);
					b15.setVisible(true);
					b16.setVisible(true);
					t13.setVisible(true);
					t5.setVisible(false);
					b17.setVisible(true);
					b18.setVisible(true);
					t14.setVisible(true);
					
				}
				
				
				
			});
			
			
		 	
		 
			b15.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e){
					b15.setVisible(false);
					tb.setValueAt("ID",0,0);
					tb.setValueAt("STATUS",0,1);
					tb.setValueAt("NAME",0,2);
					tb.setValueAt("START_DATE",0,3);
					tb.setValueAt("END_DATE",0,4);
					
					
					for(int j = 0;j<VMS.getInstance().getCamp().size();j++) {
						tb.setValueAt(Integer.toString(VMS.getInstance().getCamp().get(j).ID), j+1, 0);
						tb.setValueAt(VMS.getInstance().getCamp().get(j).STATUS.toString(), j+1, 1);
						tb.setValueAt(VMS.getInstance().getCamp().get(j).NAME, j+1, 2);
						tb.setValueAt(VMS.getInstance().getCamp().get(j).START_DATE.toString(), j+1, 3);
						tb.setValueAt(VMS.getInstance().getCamp().get(j).END_DATE.toString(), j+1, 4);
					}
			        tb.setVisible(true);
			        t8.setVisible(false);
			        b9.setVisible(true);
			        t5.setVisible(false);
			        b16.setVisible(false);
			        b17.setVisible(false);
				}
				
				
				
			});
		 
		 
		 
		 
		 b13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int id = Integer.parseInt(t5.getText());
					Vector v = new Vector();
					for(int i = 0;i<VMS.getInstance().getCamp().get(id-1).Observers.size();i++) {
						v.add(VMS.getInstance().getCamp().get(id-1).Observers.get(i).toString());
					}
					
					l.setListData(v);
					l.setVisible(true);
					b9.setVisible(true);
					b12.setVisible(false);
					b8.setVisible(false);
					t10.setVisible(false);
					t5.setVisible(false);
					b13.setVisible(false);
					b10.setVisible(false);
					t11.setVisible(true);
					t12.setVisible(true);
					b17.setVisible(false);
					int num_use = 0;
					for(int i = 0;i<VMS.getInstance().getCamp().get(id-1).Vouch.V_Value.size();i++) {
						if(VMS.getInstance().getCamp().get(id-1).Vouch.V_Value.get(i).STATUS.compareTo(Voucher.VoucherStatusType.USED) == 0) {
							num_use = num_use + 1;
						}
					}
					
					t12.setText(Integer.toString(num_use));
					
				}
			});
		 
		 
		 
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tb.setVisible(false);
				b9.setVisible(false);
				b7.setVisible(true);
				b5.setVisible(true);
				b6.setVisible(true);
				t5.setText(null);
				t5.setVisible(true);
				t6.setVisible(false);
				t7.setVisible(false);
				t8.setVisible(false);
				t9.setVisible(false);
				b10.setVisible(false);
				b11.setVisible(false);
				t6.setText(null);
				t7.setText(null);
				t8.setText(null);
				t9.setText(null);
				b13.setVisible(false);
				l.setVisible(false);
				t11.setVisible(false);
				t12.setVisible(false);
				t12.setText(null);
				b17.setVisible(false);
				b18.setVisible(false);
				t14.setVisible(false);
				
				
			}
		});
		
		
		
		
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b6.setVisible(false);
				b7.setVisible(false);
				b5.setVisible(false);
				t5.setVisible(false);
				t10.setVisible(true);
				b12.setVisible(true);
				b13.setVisible(true);
				int id = Integer.parseInt(t5.getText());
				b8.setVisible(true);
				b10.setVisible(true);
				for(int j = 1;j<13;j++) {
				tb.setValueAt(null, j, 0);
				tb.setValueAt(null, j, 1);
				tb.setValueAt(null, j, 2);
				tb.setValueAt(null, j, 3);
				tb.setValueAt(null, j, 4);
				b17.setVisible(false);
				t13.setVisible(false);
				t14.setVisible(false);
				
				
				}
				
			}
		});
		
		
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			        t5.setVisible(false);
			        
			        b9.setVisible(true);
			        b8.setVisible(false);
			        b10.setVisible(false);
			        t6.setVisible(true);
			        t7.setVisible(true);
			        t8.setVisible(true);
			        t9.setVisible(true);
			        b12.setVisible(false);
			        b11.setVisible(true);
			        t10.setVisible(false);
			        b13.setVisible(false);
			        b17.setVisible(false);
			        
			      }
		});
		
		
		
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(t5.getText());
				if(VMS.getInstance().getCamp().get(id-1).DISP_NUMBER - 1>=0){
					VMS.getInstance().getCamp().get(id-1).generateVoucher(t6.getText(), t7.getText(), Float.parseFloat(t8.getText()), VMS.getInstance().getUsers().get(Integer.parseInt(t9.getText())-1));
					if(!VMS.getInstance().getCamp().get(id-1).Observers.contains(VMS.getInstance().getUsers().get(Integer.parseInt(t9.getText())-1))) {
						VMS.getInstance().getCamp().get(id-1).addObserver(VMS.getInstance().getUsers().get(Integer.parseInt(t9.getText())-1));
						VMS.getInstance().getCamp().get(id-1).DISP_NUMBER = VMS.getInstance().getCamp().get(id-1).DISP_NUMBER - 1;
						
					}
			}
			        
			        
			}
		});
		
		
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tb.setValueAt("ID",0,0);
				tb.setValueAt("STATUS",0,1);
				tb.setValueAt("EMAIL",0,2);
				tb.setValueAt("CAMPG_ID",0,3);
				tb.setValueAt("REEDEEM_DATE",0,4);
				int id = Integer.parseInt(t5.getText());
			
				
				
				for(int i =0;i<VMS.getInstance().getCamp().get(id-1).Vouch.V_Value.size();i++) {
					
					tb.setValueAt(Integer.toString(VMS.getInstance().getCamp().get(id-1).Vouch.V_Value.get(i).ID),i+1,0);
					tb.setValueAt(VMS.getInstance().getCamp().get(id-1).Vouch.V_Value.get(i).STATUS.toString(),i+1,1);
					tb.setValueAt(VMS.getInstance().getCamp().get(id-1).Vouch.V_Value.get(i).EMAIL,i+1,2);
					tb.setValueAt(Integer.toString(VMS.getInstance().getCamp().get(id-1).Vouch.V_Value.get(i).CAMPG_ID),i+1,3);
					if(VMS.getInstance().getCamp().get(id-1).Vouch.V_Value.get(i).DATE !=null) {
					tb.setValueAt(VMS.getInstance().getCamp().get(id-1).Vouch.V_Value.get(i).DATE.toString(),i+1,4);
					}
				}
				
				
		        tb.setVisible(true);
		        t5.setVisible(false);
		        t5.setText(null);
		        b9.setVisible(true);
		        b8.setVisible(false);
		        b10.setVisible(false);
		        t10.setVisible(false);
		        b12.setVisible(false);
		        b13.setVisible(false);
		        b17.setVisible(false);
			}
		});
		
		
	
	
		
		b12.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(t5.getText()); 
				int code = Integer.parseInt(t10.getText());
				 VMS.getInstance().getCamp().get(id-1).redeemVoucher(code, LocalDateTime.now());
				 
				
			}
			
			
			
		});
		
		
		
		
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				b3.setVisible(false);
				b1.setVisible(true);
				b2.setVisible(false);
				b7.setVisible(false);
				b4.setVisible(false);
				b5.setVisible(false);
				b6.setVisible(false);
				b.setVisible(true);
				t1.setVisible(true);
				t2.setVisible(true);
				t3.setVisible(true);
				t4.setVisible(true);
				t1.setText(null);
				t2.setText(null);
				b1.setEnabled(true);
				t5.setVisible(false);
				tb.setVisible(false);
				l.setVisible(false);
				l1.setVisible(false);
				b15.setVisible(false);
				b16.setVisible(false);
				t13.setVisible(false);
				b17.setVisible(false);
				picLabel.setVisible(true);
				picLabel1.setVisible(false);
			}
			
			
			
		});
		
		
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("VMS");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	      
	}

}
