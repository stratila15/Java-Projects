import java.time.LocalDateTime;
import java.util.Vector;

public class Notification {
	LocalDateTime DATE;
	int ID;
	Vector<Integer> CODES = new Vector<Integer>();
	String Status;
	enum NotificationType {EDIT, CANCEL}
	
	
	
	public Notification(LocalDateTime curr_date, int cMP_ID, String status2) {
		this.DATE = curr_date;
		this.ID = cMP_ID;
		this.Status = status2;
	}
	
	
	

	public String toString() {
		return ID +";"+CODES+";"+DATE+";"+Status;
	}
}
