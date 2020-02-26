import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;



public class Test {

	public void CAMP_READ(String file) throws FileNotFoundException {	
		
		File myobj = new File(file);
		Scanner myreader = new Scanner(myobj);
		
			String camp_data = myreader.nextLine();
			
			DateTimeFormatter formatter7 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime APPDATA = LocalDateTime.parse(myreader.nextLine(),formatter7);
			
			
			
		while(myreader.hasNextLine()) {
			String data1 = myreader.nextLine();
			int index = data1.indexOf(";");
			int ID = Integer.parseInt(data1.substring(0,index));
			
			
			data1 = data1.substring(index + 1) ;
			index = data1.indexOf(";");
			String NAME = data1.substring(0,index);
			
			
			data1 = data1.substring(index + 1);
			index = data1.indexOf(";");
			String Descr = data1.substring(0,index);
			
			
			data1 = data1.substring(index + 1);
			index = data1.indexOf(";");
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime Start_Date = LocalDateTime.parse(data1.substring(0,index),formatter2);
			
			
			data1 = data1.substring(index + 1);
			index = data1.indexOf(";");
			LocalDateTime END_Date = LocalDateTime.parse(data1.substring(0,index),formatter2);
			
			
			data1 = data1.substring(index + 1);
			index = data1.indexOf(";");
			int Budget = Integer.parseInt(data1.substring(0,index));
			
			
			data1 = data1.substring(index + 1);
			String Type= data1.substring(0);
			
			Campaign nn = new Campaign(ID,NAME,Descr,Start_Date,END_Date,Budget,Type);
			if(Start_Date.compareTo(APPDATA) < 0 && END_Date.compareTo(APPDATA)>0) {
				nn.STATUS =Campaign.CampaignStatusType.STARTED;
			}else if (Start_Date.compareTo(APPDATA)>0) {
				nn.STATUS=Campaign.CampaignStatusType.NEW;
			}
			VMS.getInstance().addCampaign(nn);
			
		}
		myreader.close();
	}		
	
	
	
	public void USR_READ(String file) throws FileNotFoundException {
		File myobj2 = new File(file);
		Scanner myreader1 = new Scanner(myobj2);
		
		String usr_number = myreader1.nextLine();
		
		while(myreader1.hasNextLine()) {
			String data_usr = myreader1.nextLine();
			int index = data_usr.indexOf(";");
			int ID = Integer.parseInt(data_usr.substring(0,index));
			
			
			data_usr = data_usr.substring(index + 1) ;
			index = data_usr.indexOf(";");
			String NAME = data_usr.substring(0,index);
			
			
			data_usr = data_usr.substring(index + 1);
			index = data_usr.indexOf(";");
			String PASS = data_usr.substring(0,index);
			
			
			data_usr = data_usr.substring(index + 1);
			index = data_usr.indexOf(";");
			String EMAIL = data_usr.substring(0,index);
		
			data_usr = data_usr.substring(index + 1);
			String Type= data_usr.substring(0);
			
			User nu = new User(ID,NAME,EMAIL,PASS);
			if(Type.equals("ADMIN")) {
				nu.TYPE = User.UserType.ADMIN;
			}else {
				nu.TYPE = User.UserType.GUEST;
			}
			VMS.getInstance().addUser(nu);
			
		}
			myreader1.close();
	}
	
public void read_event(String file) throws FileNotFoundException {	
	File myobj3 = new File(file);
	Scanner myreader2 = new Scanner(myobj3);
	
	
	DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	LocalDateTime curr_date = LocalDateTime.parse(myreader2.nextLine(),formatter1);
	String num_line = myreader2.nextLine();
	
	while(myreader2.hasNextLine()) {
		
		String line = myreader2.nextLine();
		int USR_ID = Integer.parseInt(line.substring(0,line.indexOf(";")));
		line = line.substring(line.indexOf(";")+1); 
		String action;
		int CMP_ID;
		
		if(line.indexOf(";") != -1) {
		 action = line.substring(0,line.indexOf(";"));
		
		
		} else{
		 action = line.substring(0);
		
		
		}
		
		
		
		if(action.equals("generateVoucher")) {
			line = line.substring(line.indexOf(";")+1);
			CMP_ID = Integer.parseInt(line.substring(0,line.indexOf(";")));
			line = line.substring(line.indexOf(";")+1);
			String email = line.substring(0,line.indexOf(";"));
		
			line = line.substring(line.indexOf(";")+1);
			String voucherType = line.substring(0,line.indexOf(";"));
			
			line = line.substring(line.indexOf(";")+1);
			float value = Float.parseFloat(line.substring(0));
			int indx=0;
			
			while(!VMS.getInstance().getUsers().get(indx).EMAIL.equals(email)) {
				indx = indx + 1;
				
			}
			
			if(VMS.getInstance().getUsers().get(USR_ID-1).TYPE.compareTo(User.UserType.ADMIN)==0 && ((VMS.getInstance().getCamp().get(CMP_ID-1).DISP_NUMBER - 1)>=0)) {
				VMS.getInstance().getCamp().get(CMP_ID-1).generateVoucher(email, voucherType, value, VMS.getInstance().getUsers().get(indx));
				if(!VMS.getInstance().getCamp().get(CMP_ID-1).Observers.contains(VMS.getInstance().getUsers().get(indx))) {
				VMS.getInstance().getCamp().get(CMP_ID-1).addObserver(VMS.getInstance().getUsers().get(indx));
				VMS.getInstance().getCamp().get(CMP_ID-1).DISP_NUMBER = VMS.getInstance().getCamp().get(CMP_ID-1).DISP_NUMBER - 1;
				
		}
	
		}		
		}
		
		if(action.equals("redeemVoucher")) {
			line = line.substring(line.indexOf(";")+1);
			CMP_ID = Integer.parseInt(line.substring(0,line.indexOf(";")));
			line = line.substring(line.indexOf(";")+1);
			int Voucher_ID = Integer.parseInt(line.substring(0,line.indexOf(";")));
			line = line.substring(line.indexOf(";")+1);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime localDate = LocalDateTime.parse(line.substring(0),formatter);
			
			if(VMS.getInstance().getUsers().get(USR_ID-1).TYPE.compareTo(User.UserType.ADMIN) == 0) {
				if(VMS.getInstance().getCamp().get(CMP_ID-1).END_DATE.compareTo(localDate)>0) {
				VMS.getInstance().getCamp().get(CMP_ID-1).redeemVoucher(Voucher_ID, localDate);
				
			}
			}
		}
		
		if(action.equals("cancelCampaign")) {
			line = line.substring(line.indexOf(";")+1);
			if(line.indexOf(";") == -1) {
			CMP_ID = Integer.parseInt(line.substring(0));
			}else {
			CMP_ID = Integer.parseInt(line.substring(0,line.indexOf(";")));
			line = line.substring(line.indexOf(";")+1);
			DateTimeFormatter formatter6 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime Time = LocalDateTime.parse(line.substring(0),formatter6); 
			}		
			if(VMS.getInstance().getUsers().get(USR_ID-1).TYPE.equals(User.UserType.ADMIN)) {
				VMS.getInstance().cancelCampaign(CMP_ID);
				VMS.getInstance().getCamp().get(CMP_ID-1).notifyAllObserver(new Notification(curr_date,CMP_ID,"CANCEL"));
		}
		}
		
		if(action.equals("getNotifications")) {
			if(VMS.getInstance().getUsers().get(USR_ID-1).TYPE.equals(User.UserType.GUEST)) {
				System.out.println(VMS.getInstance().getUsers().get(USR_ID-1).NOTIFY);
			}
		}
		
		if(action.equals("getVouchers")) {
			if(VMS.getInstance().getUsers().get(USR_ID-1).TYPE.equals(User.UserType.GUEST)) {
				System.out.println(VMS.getInstance().getUsers().get(USR_ID-1).Vouch1.V_Value);
				
			}	
		}
		
		if(action.equals("getVoucher")) {
			line = line.substring(line.indexOf(";")+1);
			CMP_ID = Integer.parseInt(line.substring(0));
			if(VMS.getInstance().getUsers().get(USR_ID-1).TYPE.equals(User.UserType.ADMIN)) {
				if(VMS.getInstance().getCamp().get(CMP_ID-1).Strategy.equals("C")) {
					VMS.getInstance().executeC(CMP_ID);
				}
				
				if(VMS.getInstance().getCamp().get(CMP_ID-1).Strategy.equals("B")) {
					VMS.getInstance().executeB(CMP_ID);
				}
				if(VMS.getInstance().getCamp().get(CMP_ID-1).Strategy.equals("A")) {
					VMS.getInstance().executeA(CMP_ID);
					
					}
			}
			
			
		}
		
		if(action.equals("addCampaign")) {
			line = line.substring(line.indexOf(";")+1);
			CMP_ID = Integer.parseInt(line.substring(0,line.indexOf(";")));
			line = line.substring(line.indexOf(";")+1);
			String NAME = line.substring(0,line.indexOf(";"));
			line = line.substring(line.indexOf(";")+1);
			String DESCR = line.substring(0,line.indexOf(";"));
			line = line.substring(line.indexOf(";")+1);
			DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime START_DATE = LocalDateTime.parse(line.substring(0,line.indexOf(";")),formatter4);
			line = line.substring(line.indexOf(";")+1);
			LocalDateTime END_DATE = LocalDateTime.parse(line.substring(0,line.indexOf(";")),formatter4);
			line = line.substring(line.indexOf(";")+1);
			int BUDGET = Integer.parseInt(line.substring(0,line.indexOf(";")));
			line = line.substring(line.indexOf(";")+1);
			String Strategy = line.substring(0);
			
			if(VMS.getInstance().getUsers().get(USR_ID-1).TYPE.equals(User.UserType.ADMIN)) {
				Campaign nc = new Campaign(CMP_ID,NAME,DESCR,START_DATE,END_DATE,BUDGET,Strategy);
				if(START_DATE.compareTo(curr_date) < 0 && END_DATE.compareTo(curr_date)>0) {
					nc.STATUS =Campaign.CampaignStatusType.STARTED;
				}else if (START_DATE.compareTo(curr_date)>0) {
					nc.STATUS=Campaign.CampaignStatusType.NEW;
				}
				VMS.getInstance().addCampaign(nc);
			}
	}
		
		if(action.equals("editCampaign")) {
			line = line.substring(line.indexOf(";")+1);
			CMP_ID = Integer.parseInt(line.substring(0,line.indexOf(";")));
			line = line.substring(line.indexOf(";")+1);
			String NAME = line.substring(0,line.indexOf(";"));
			line = line.substring(line.indexOf(";")+1);
			String DESCR = line.substring(0,line.indexOf(";"));
			line = line.substring(line.indexOf(";")+1);
			DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime START_DATE = LocalDateTime.parse(line.substring(0,line.indexOf(";")),formatter5);
			line = line.substring(line.indexOf(";")+1);
			LocalDateTime END_DATE = LocalDateTime.parse(line.substring(0,line.indexOf(";")),formatter5);
			line = line.substring(line.indexOf(";")+1);
			int BUDGET = Integer.parseInt(line.substring(0));
			
		if(VMS.getInstance().getUsers().get(USR_ID-1).TYPE.equals(User.UserType.ADMIN))	{
			Campaign aux = new Campaign();
			aux.NAME=NAME;
			aux.DESCR=DESCR;
			aux.TOTAL_NUMBER=BUDGET;
			aux.DISP_NUMBER=BUDGET;
			aux.START_DATE=START_DATE;
			aux.END_DATE=END_DATE;
			VMS.getInstance().updateCampaign(CMP_ID, aux);
			VMS.getInstance().getCamp().get(CMP_ID-1).notifyAllObserver(new Notification(curr_date,CMP_ID,"EDIT"));
		}
		
		}
		if(action.equals("getObservers")) {
			line = line.substring(line.indexOf(";")+1);
			CMP_ID = Integer.parseInt(line.substring(0));
			if(VMS.getInstance().getUsers().get(USR_ID-1).TYPE.equals(User.UserType.ADMIN)) {
				
				System.out.println(VMS.getInstance().getCamp().get(CMP_ID - 1).getObservers());
			}
		}
	
	
		
	

}
}	
	
public void multiple_distribute(String file) throws FileNotFoundException {	
	File myobj4 = new File(file);
	Scanner myreader3 = new Scanner(myobj4);
	int number = Integer.parseInt(myreader3.nextLine());               //Bonus
	
	while(myreader3.hasNextLine()) {
		String line = myreader3.nextLine();
		String email = line.substring(0,line.indexOf(";"));
		line = line.substring(line.indexOf(";")+1);
		int CMP_ID = Integer.parseInt(line.substring(0,line.indexOf(";")));
		line = line.substring(line.indexOf(";")+1);
		String VoucherType = line.substring(0,line.indexOf(";"));
		line = line.substring(line.indexOf(";")+1);
		float value = Float.parseFloat(line.substring(0));
		int USER_ID = 0;
		
		while(!VMS.getInstance().getUsers().get(USER_ID).EMAIL.equals(email)) {
			USER_ID = USER_ID + 1;
			
		}
		
		if((VMS.getInstance().getCamp().get(CMP_ID-1).DISP_NUMBER - 1)>=0 ){
			
				VMS.getInstance().getCamp().get(CMP_ID-1).generateVoucher(email, VoucherType, value, VMS.getInstance().getUsers().get(USER_ID));
			}
		}
	
	System.out.println();
		
	}
	
	
	

	
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\Vlad\\eclipse-workspace\\PROJECT\\src\\out.txt")));
		Test b = new Test();
		String file = "C:\\Users\\Vlad\\eclipse-workspace\\PROJECT\\src\\test01\\input\\campaigns.txt";
		b.CAMP_READ(file);
		 file = "C:\\Users\\Vlad\\eclipse-workspace\\PROJECT\\src\\test01\\input\\users.txt";
		b.USR_READ(file);
		file="C:\\Users\\Vlad\\eclipse-workspace\\PROJECT\\src\\test01\\input\\events.txt";
		b.read_event(file);
		file ="C:\\Users\\Vlad\\eclipse-workspace\\PROJECT\\src\\emails.txt"; 
		//b.multiple_distribute(file);
		//System.out.println(VMS.getInstance().getUsers().get(3).Vouch1.V_Value);
	
	
		
		
	}

}
