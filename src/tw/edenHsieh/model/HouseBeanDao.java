package tw.edenHsieh.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class HouseBeanDao implements IHouseBeanDao {
	private Session session;

	public HouseBeanDao(Session session) {
        this.session = session;
	}
	
	//新增
	public HouseBean insert(HouseBean hBean) {
		HouseBean resultBean = session.get(HouseBean.class, hBean.getHouseid());
		
		if(resultBean==null) {
			session.save(hBean);
			return hBean;
		}
		
		return null;		
	}
	
	//查詢
	public HouseBean selectById(int houseid) {
		return session.get(HouseBean.class, houseid);
	}

	public List<HouseBean> selectAll(){
		Query<HouseBean> query = session.createQuery("from HouseBean", HouseBean.class);
		return query.list();
	}
	
	//更新
	public HouseBean update(int houseid, String housename) {
		HouseBean resultBean = session.get(HouseBean.class, houseid);
		
		if(resultBean!=null) {
			resultBean.setHousename(housename);
		}
		
		return resultBean;
	}
	
	//刪除
	public boolean deleteById(int houseid) {
	    HouseBean resultBean = session.get(HouseBean.class, houseid);
	    
	    if(resultBean!=null) {
	    	session.delete(resultBean);
	    	return true;
	    }
	    
	    return false;
	}
}