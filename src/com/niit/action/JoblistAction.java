package com.niit.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.niit.common.database.DatabaseTransaction; 
import com.niit.model.Joblist; 
import com.niit.service.JoblistService; 
 
public class JoblistAction { 
	public int add(Joblist joblist) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new JoblistService(trans).add(joblist); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Joblist joblist) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new JoblistService(trans).edit(joblist); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int jobID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new JoblistService(trans).delete(jobID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Joblist> findAll() { 
		List<Joblist> lists = new ArrayList<Joblist>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new JoblistService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Joblist> findWhere(String where) { 
		List<Joblist> lists = new ArrayList<Joblist>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new JoblistService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Joblist findById(int jobID) { 
		Joblist joblist = new Joblist(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			joblist = new JoblistService(trans).findById(jobID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return joblist; 
	} 
	 
	public List<Joblist> findByRange(int start, int size) { 
		List<Joblist> lists = new ArrayList<Joblist>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new JoblistService(trans).findByRange(start, size); 
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
			id = new JoblistService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
