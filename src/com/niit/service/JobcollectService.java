package com.niit.service; 
 
import java.util.List; 
 
import com.niit.common.database.DatabaseTransaction; 
import com.niit.common.service.BaseService; 
import com.niit.dao.JobcollectDao; 
import com.niit.model.Jobcollect; 
 
public class JobcollectService extends BaseService { 
	public JobcollectService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public JobcollectService() { 
		super(); 
	} 
 
	public int add(Jobcollect jobcollect) { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.add(jobcollect); 
	} 
 
	public int edit(Jobcollect jobcollect) { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.edit(jobcollect); 
	} 
 
	public int delete(int jobCollectID) { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.delete(jobCollectID); 
	} 
 
	public List<Jobcollect> findAll() { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Jobcollect> findWhere(String where) { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Jobcollect findById(int jobCollectID) { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.findById(jobCollectID); 
	} 
 
	public List<Jobcollect> findByRange(int start, int size) { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
	
	public List<Jobcollect> findByRange(int start, int size,int usersID) { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.findByRange(start,size,usersID); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
