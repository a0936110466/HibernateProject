package tw.edenHsieh.model;

import java.util.List;

import org.hibernate.Session;

public class HouseBeanService implements IHouseBeanService {

	private HouseBeanDao hDao;
	
	public HouseBeanService(Session session) {
		hDao = new HouseBeanDao(session);
	}
	
	@Override
	public HouseBean insert(HouseBean hBean) {
		return hDao.insert(hBean);
	}

	@Override
	public HouseBean selectById(int houseid) {
		return hDao.selectById(houseid);
	}

	@Override
	public List<HouseBean> selectAll() {
		return hDao.selectAll();
	}

	@Override
	public HouseBean update(int houseid, String housename) {
		return hDao.update(houseid, housename);
	}

	@Override
	public boolean deleteById(int houseid) {
		return hDao.deleteById(houseid);
	}

}
