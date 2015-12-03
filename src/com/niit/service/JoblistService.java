package com.niit.service; 
 
import java.util.List; 
 
import com.niit.common.database.DatabaseTransaction; 
import com.niit.common.service.BaseService; 
import com.niit.dao.JoblistDao; 
import com.niit.model.Joblist; 
 
public class JoblistService extends BaseService { 
	public JoblistService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public JoblistService() { 
		super(); 
	} 
 
	public int add(Joblist joblist) { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.add(joblist); 
	} 
 
	public int edit(Joblist joblist) { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.edit(joblist); 
	} 
 
	public int delete(int jobID) { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.delete(jobID); 
	} 
 
	public List<Joblist> findAll() { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Joblist> findWhere(String where) { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Joblist findById(int jobID) { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.findById(jobID); 
	} 
 
	public List<Joblist> findByRange(int start, int size) { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
