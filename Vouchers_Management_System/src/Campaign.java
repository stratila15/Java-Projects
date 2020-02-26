import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

public class Campaign {
	int ID;
	String NAME;
	String DESCR;
	LocalDateTime START_DATE;
	LocalDateTime END_DATE;
	float TOTAL_NUMBER;
	float DISP_NUMBER;
	CampaignStatusType STATUS ;
	String Strategy;
	enum CampaignStatusType {NEW, STARTED, EXPIRED, CANCELLED};
	CampaignVoucherMap<User,Voucher> Vouch = new CampaignVoucherMap<User,Voucher>();
	Vector<User> Observers = new Vector<User>();
	
	public Campaign() {
		
	}
	
	public Campaign(int ID, String NAME, String DESCR,LocalDateTime START_DATE, LocalDateTime END_DATE, int Number,String Strategy_Type) {
		this.ID = ID;
		this.NAME = NAME;
		this.DESCR = DESCR;
		this.TOTAL_NUMBER = Number;
		this.DISP_NUMBER = this.TOTAL_NUMBER;
		this.START_DATE = START_DATE;
		this.END_DATE = END_DATE;
		this.Strategy = Strategy_Type;
	}
	
	public ArrayMap getVouchers() {
		return Vouch;
	}

	public Voucher getVoucher(int code) {
		
		for(int i = 0;i<Vouch.V_Key.size();i++) {
			if(Vouch.V_Value.get(i).CODE == code) {
				return Vouch.V_Value.get(i);
			}
		}
		return null;
	}

	public void generateVoucher(String email,String voucherType,float value,User usr) {
		if(!this.STATUS.equals(Campaign.CampaignStatusType.CANCELLED)) {
			if(voucherType.equals("GiftVoucher")) {                 
				GiftVoucher neew = new GiftVoucher();
				neew.CODE = Vouch.V_Value.size() + 1 ;
				neew.ID = Vouch.V_Value.size() + 1;
				neew.EMAIL = email;
				neew.CAMPG_ID = this.ID;
				neew.DISP_SUM=value;
				neew.STATUS = Voucher.VoucherStatusType.UNUSED;
				usr.V_COD.add(neew.CODE);
				this.Vouch.addVoucher(neew);
				usr.Vouch1.addVoucher(neew);
				
			}
			
			if(voucherType.equals("LoyaltyVoucher")) {
				LoyalityVoucher neew = new LoyalityVoucher();  
				neew.CODE = Vouch.V_Value.size() + 1;
				neew.ID = Vouch.V_Value.size() + 1;
				neew.EMAIL = email;
				neew.CAMPG_ID = this.ID;
				neew.SALE=value;
				neew.STATUS = Voucher.VoucherStatusType.UNUSED;
				usr.V_COD.add(neew.CODE);
				this.Vouch.addVoucher(neew);
				usr.Vouch1.addVoucher(neew);
			}
		}    
}
	public String toString() {
		return this.NAME +" "+this.ID+" "+this.STATUS+" "+this.START_DATE+" "+this.END_DATE+" ";
	}

	public void redeemVoucher(int cODE,LocalDateTime date) {
		int i = 0;
		while(this.Vouch.V_Value.get(i).CODE != cODE) {
			i++;
		}
		this.Vouch.V_Value.get(i).STATUS=Voucher.VoucherStatusType.USED;
		this.Vouch.V_Value.get(i).DATE = date;
		
	}
	

	public Vector getObservers() {
		return Observers;
	}

	public void addObserver(User user) {
		Observers.add(user);
	}

	public void removeObserver(User user) {
		Observers.remove(user);
	}

	public void notifyAllObserver(Notification notification) {
		Vector <Notification> nn = new Vector<Notification>();
		for(int i=0;i<this.Observers.size();i++) {
			nn.add(new Notification(notification.DATE,notification.ID,notification.Status));
		}
		for(int i=0;i<this.Observers.size();i++) {
			this.Observers.get(i).NOTIFY.add(nn.get(i));
			this.Observers.get(i).NOTIFY.lastElement().CODES=this.Observers.get(i).V_COD;
			}
		}
}
