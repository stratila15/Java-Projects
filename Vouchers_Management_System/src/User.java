import java.util.Vector;

public class User {
	int ID;
	String NAME;
	String EMAIL;
	String PASSWORD;
	Vector<Notification> NOTIFY = new Vector<Notification>();
	UserType TYPE;
	Vector<Integer> V_COD = new Vector<Integer>();
	UserVoucherMap <Campaign,Voucher> Vouch1 = new UserVoucherMap <Campaign,Voucher>();
	enum UserType {ADMIN, GUEST}
	
	public User() {
		
	}
	
	public User(int ID, String Name, String Email,String Password) {
		
		this.ID = ID;
		this.NAME = Name;
		this.EMAIL = Email;
		this.PASSWORD = Password;
		
	}
	
	public String toString() {
		return "["+ID + ";" + NAME + ";" + EMAIL + ";" + TYPE+"]";
	}
}
