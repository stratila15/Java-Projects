import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class ArrayMap<K, V> extends AbstractMap<K, V> {
	 Vector<K> V_Key = new Vector<K>();
	 Vector<V> V_Value = new Vector<V>();;

 public ArrayMap() {
	 
 }
 public V put(K key,V value) {
	 V_Key.add(key);
	 V_Value.add(value);
	 return value;
 }
	
 public boolean containsKey(Object key) {
	if (V_Key.contains(key)) {
		return true;
	}
	return false;
 }
	
 public V get(Object key) {
	int pos = V_Key.indexOf(key);
	if(pos != -1)  {
		return V_Value.get(pos);
	}
	 return null;
 }
	
 public int size() {
	return V_Key.size();
 }
	
 public Set<Entry<K,V>>entrySet() {
	Iterator<K> it_key = V_Key.iterator();
	Iterator<V> it_value = V_Value.iterator();
	HashSet<Map.Entry<K, V>> h = new HashSet();
	while(it_key.hasNext()) {
		h.add(new ArrayMapEntry(it_key.next(),it_value.next()));
	}
	return h;
 }


	

 class ArrayMapEntry<K,V> implements Map.Entry<K, V> {

	private K key;
	private V value;
	
	private ArrayMapEntry(K key,V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}

	
	public V getValue() {
		return value;
	}

	
	public V setValue(V value) {
		this.value = value;
		return value;
	}
	
	public String toString() {
		return "Key" +" "+key+" "+ "Value"+" "+value;  
	}
	
	public boolean equals(Object o) {
		ArrayMapEntry<K, V> o2 = (ArrayMapEntry<K, V>)o;
		ArrayMapEntry<K, V> n = o2;
		if(this.equals(n)) {
			return true;
		}
		
		return false;
	}
	
	public int hashCode() {
		return this.getKey().hashCode();
	}
	
}
}


class UserVoucherMap<K,V> extends ArrayMap<K, V> {
	
	
	public boolean addVoucher(Voucher v) {
		int ID_USR = Integer.parseInt(v.EMAIL.substring(5, v.EMAIL.lastIndexOf("_")));
		int ID_CAMP = v.CAMPG_ID;
		if(VMS.getInstance().getUsers().get(ID_USR -1).Vouch1.V_Value.contains(v)) {
			return false;
		}
		VMS.getInstance().getUsers().get(ID_USR-1).Vouch1.put(VMS.getInstance().getCamp().get(ID_CAMP-1), v);
		return true;
}
}

class CampaignVoucherMap<K, V> extends ArrayMap<K, V>{
	
	public boolean addVoucher(Voucher v) {
		int ID_USR = Integer.parseInt(v.EMAIL.substring(5, v.EMAIL.lastIndexOf("_")));
		
		int ID_CAMP = v.CAMPG_ID;
		if(VMS.getInstance().getCamp().get(ID_CAMP-1).Vouch.V_Value.contains(v)) {
			return false;
		}
		VMS.getInstance().getCamp().get(ID_CAMP-1).Vouch.put(VMS.getInstance().getUsers().get(ID_USR-1), v);
		return true;
	}
}
