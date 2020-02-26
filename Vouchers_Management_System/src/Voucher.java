import java.time.LocalDateTime;

public abstract class Voucher {
	int ID;
	int CODE;
	LocalDateTime DATE;
	String EMAIL;
	int CAMPG_ID;
	VoucherStatusType STATUS ;
	enum VoucherStatusType {USED,UNUSED}
	
}



class GiftVoucher extends Voucher {
	float DISP_SUM;
	public String toString() {
		return "["+ID+";"+STATUS+";"+EMAIL+";"+DISP_SUM+";"+CAMPG_ID+";"+DATE+"]";
	}
}

class LoyalityVoucher extends Voucher {
	float SALE;
	public String toString() {
		return "["+ID+";"+STATUS+";"+EMAIL+";"+SALE+";"+CAMPG_ID+";"+DATE+"]";
	}
}


