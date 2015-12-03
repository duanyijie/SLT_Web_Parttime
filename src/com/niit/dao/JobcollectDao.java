package com.niit.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.niit.common.database.access.DataAccess; 
import com.niit.common.database.convert.IntegerConverter; 
import com.niit.convert.JobcollectConvert; 
import com.niit.model.Jobcollect; 
 
public class JobcollectDao extends DataAccess { 
 
	public JobcollectDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Jobcollect jobcollect) { 
		String sql = "INSERT INTO jobcollect (JobCollectDate,UsersID,JobID) VALUES (?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), jobcollect.jobCollectDate,jobcollect.usersID,jobcollect.jobID				); 
	} 
 
	public int edit(Jobcollect jobcollect) { 
		String sql = "UPDATE jobcollect SET JobCollectDate=?,UsersID=?,JobID=? WHERE JobCollectID=?"; 
		return super.update(sql,
jobcollect.jobCollectDate,jobcollect.usersID,jobcollect.jobID,				 jobcollect.jobCollectID); 
	} 
 
	public int delete(int jobCollectID) { 
		String sql = "DELETE FROM jobcollect WHERE JobCollectID=?"; 
		return super.update(sql, jobCollectID); 
	} 
 
	public List<Jobcollect> findAll() { 
		String sql = "SELECT * FROM jobcollect"; 
		return super.queryForList(sql, new JobcollectConvert()); 
	} 
 
	public List<Jobcollect> findWhere(String where) { 
		String sql = "SELECT * FROM jobcollect WHERE 1=1 " + where; 
		return super.queryForList(sql, new JobcollectConvert()); 
	} 
 
	public Jobcollect findById(int jobCollectID) { 
		String sql = "SELECT * FROM jobcollect WHERE  JobCollectID=?"; 
		return super.queryForObject(sql, new JobcollectConvert(), jobCollectID); 
	} 
 
	public List<Jobcollect> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM jobcollect limit ?,?", 
				new JobcollectConvert(), start, size); 
	} 
	
	public List<Jobcollect> findByRange(int start, int size,int usersID) { 
		return super.queryForList("SELECT * FROM jobcollect WHERE UsersID = ? limit ?,?", 
				new JobcollectConvert(), usersID, start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM jobcollect", 
				new IntegerConverter()); 
	} 
 
} 
