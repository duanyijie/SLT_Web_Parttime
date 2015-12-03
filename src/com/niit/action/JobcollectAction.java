package com.niit.action; 
 
import java.util.ArrayList; 
import java.util.List; 

import com.niit.common.database.DatabaseTransaction; 
import com.niit.model.Jobcollect; 
import com.niit.model.Joblist;
import com.niit.service.JobcollectService; 
 
public class JobcollectAction { 
	public int add(Jobcollect jobcollect) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new JobcollectService(trans).add(jobcollect); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Jobcollect jobcollect) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new JobcollectService(trans).edit(jobcollect); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int jobCollectID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new JobcollectService(trans).delete(jobCollectID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Jobcollect> findAll() { 
		List<Jobcollect> lists = new ArrayList<Jobcollect>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new JobcollectService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Jobcollect> findWhere(String where) { 
		List<Jobcollect> lists = new ArrayList<Jobcollect>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new JobcollectService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Jobcollect findById(int jobCollectID) { 
		Jobcollect jobcollect = new Jobcollect(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			jobcollect = new JobcollectService(trans).findById(jobCollectID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return jobcollect; 
	} 
	 
	public List<Jobcollect> findByRange(int start, int size) { 
		List<Jobcollect> lists = new ArrayList<Jobcollect>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new JobcollectService(trans).findByRange(start, size); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	
	public List<Jobcollect> findByRange(int start, int size,int usersID) { 
		List<Jobcollect> lists = new ArrayList<Jobcollect>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new JobcollectService(trans).findByRange(start, size,usersID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Integer getCount() { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new JobcollectService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
