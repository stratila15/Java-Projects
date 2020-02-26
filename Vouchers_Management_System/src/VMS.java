import java.util.List;
import java.util.Random;
import java.util.Vector;

public class VMS {
	
	private Vector<Campaign> Camp;
	private Vector<User> USR;
	
	private static VMS obj = null;
	
	private VMS() {
		this.setCamp(new Vector<Campaign>());
		this.setUSR(new Vector<User>());
	}
	public static VMS getInstance() {
	
		if(obj == null) {
			obj = new VMS();
		}
	return obj;	
	}
	
	public Vector<Campaign> getCampaigns() {
		return getCamp();
	}
	
	public Campaign getCampaign(Integer id) {
		Campaign aux = new Campaign();
		for(int i=0; i < getCamp().size(); i++) {
			if(getCamp().get(i).ID == id) {
				 aux = getCamp().get(i);
		}
	}
		return aux;
}		
	public void addCampaign(Campaign campan) {
		
		this.getCamp().add(campan);
	}
	
	public void updateCampaign(Integer id, Campaign Campaign) {
		int CMP_ID = Campaign.ID;
		VMS.getInstance().getCampaign(CMP_ID).NAME=Campaign.NAME;
		VMS.getInstance().getCampaign(CMP_ID).DESCR=Campaign.DESCR;
		VMS.getInstance().getCampaign(CMP_ID).TOTAL_NUMBER=Campaign.TOTAL_NUMBER;
		VMS.getInstance().getCampaign(CMP_ID).DISP_NUMBER=Campaign.DISP_NUMBER;
		VMS.getInstance().getCampaign(CMP_ID).START_DATE=Campaign.START_DATE;
		VMS.getInstance().getCampaign(CMP_ID).END_DATE=Campaign.END_DATE;
		
		
	}
	
	public void cancelCampaign(Integer id) {
		for(int i=0; i < getCamp().size(); i++) {
			if(getCamp().get(i).ID == id) {
				if(getCamp().get(i).STATUS.compareTo(Campaign.CampaignStatusType.NEW)==0 || getCamp().get(i).STATUS.compareTo(Campaign.CampaignStatusType.STARTED)==0)
					VMS.getInstance().getCamp().get(i).STATUS = Campaign.CampaignStatusType.CANCELLED;
			}
		}
	}
	
	public Vector<User> getUsers() {
		return USR;
	}
	
	public void addUser(User user) {
		getUsers().add(user);
	}
	public void setUSR(Vector<User> uSR) {
		USR = uSR;
	}
	public Vector<Campaign> getCamp() {
		return Camp;
	}
	public void setCamp(Vector<Campaign> camp) {
		Camp = camp;
	}
	public void executeA(int CMP_ID) {
		Random rand = new Random();
		int rand1 = rand.nextInt(VMS.getInstance().getCamp().get(CMP_ID-1).Observers.size());
		if(rand1 == 0) {
			rand1+=1;
		}
		VMS.getInstance().getCamp().get(CMP_ID-1).generateVoucher(VMS.getInstance().getUsers().get(rand1).EMAIL, "GiftVoucher", 100, VMS.getInstance().getUsers().get(rand1));
		System.out.println(VMS.getInstance().getCampaign(CMP_ID).Vouch.V_Value.get(VMS.getInstance().getCampaign(CMP_ID).Vouch.V_Value.size()-1));
	}
	
	public void executeB(int CMP_ID) {
		int max = 0;
		int number = 0;
		int id= 0;
		for(int j = 0;j<VMS.getInstance().getCampaign(CMP_ID).Observers.get(0).Vouch1.V_Value.size();j++) {
			if(VMS.getInstance().getCampaign(CMP_ID).Observers.get(0).Vouch1.V_Value.get(j).CAMPG_ID == CMP_ID && VMS.getInstance().getCampaign(CMP_ID).Observers.get(0).Vouch1.V_Value.get(j).STATUS.compareTo(Voucher.VoucherStatusType.USED)==0 ) {
				number = number + 1;
			}
			max = number;
			id = 0;
		}
		
		for(int i = 1;i<VMS.getInstance().getCampaign(CMP_ID).Observers.size();i++){
			for(int j = 0;j<VMS.getInstance().getCampaign(CMP_ID).Observers.get(i).Vouch1.V_Value.size();j++) {
				if(VMS.getInstance().getCampaign(CMP_ID).Observers.get(i).Vouch1.V_Value.get(j).CAMPG_ID == CMP_ID && VMS.getInstance().getCampaign(CMP_ID).Observers.get(i).Vouch1.V_Value.get(j).STATUS.compareTo(Voucher.VoucherStatusType.USED)==0 ) {
					number = number + 1;
				}
			}
			if(number > max) {
				max = number;
				id = i;
			}
		}
			
			
		VMS.getInstance().getCamp().get(CMP_ID-1).generateVoucher(VMS.getInstance().getUsers().get(id).EMAIL, "LoyaltyVoucher", 50, VMS.getInstance().getUsers().get(id));
		System.out.println(VMS.getInstance().getCampaign(CMP_ID).Vouch.V_Value.get(VMS.getInstance().getCampaign(CMP_ID).Vouch.V_Value.size()-1));
	}
	
	public void executeC(int CMP_ID) {
		int min=0;
		int number= 0;
		int id = 0;
		
		for(int j = 0;j<VMS.getInstance().getCampaign(CMP_ID).Observers.get(0).Vouch1.V_Value.size();j++) {
			if(VMS.getInstance().getCampaign(CMP_ID).Observers.get(0).Vouch1.V_Value.get(j).CAMPG_ID == CMP_ID) {
				number = number + 1;
			}
			
		}
		min = number;
		
		
		for(int i = 1;i<VMS.getInstance().getCampaign(CMP_ID).Observers.size();i++){
			for(int j = 0;j<VMS.getInstance().getCampaign(CMP_ID).Observers.get(i).Vouch1.V_Value.size();j++) {
				if(VMS.getInstance().getCampaign(CMP_ID).Observers.get(i).Vouch1.V_Value.get(j).CAMPG_ID == CMP_ID) {
					number = number + 1;
				}
			}
			if(number < min) {
				min = number;
				id = i;
			}
		}
		
		
		VMS.getInstance().getCamp().get(CMP_ID-1).generateVoucher(VMS.getInstance().getUsers().get(id).EMAIL, "GiftVoucher", 100, VMS.getInstance().getUsers().get(id));
		System.out.println(VMS.getInstance().getCampaign(CMP_ID).Vouch.V_Value.get(VMS.getInstance().getCampaign(CMP_ID).Vouch.V_Value.size()-1));
	}
	
}
