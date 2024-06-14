package himedia.dao;

import java.util.List;

public interface GuestbookDao {
	public List<GuestbookVo> getList();
	public boolean insert(GuestbookVo vo);
	public boolean delete(Long no);

}
