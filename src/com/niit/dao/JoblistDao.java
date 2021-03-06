package com.niit.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.niit.common.database.access.DataAccess; 
import com.niit.common.database.convert.IntegerConverter; 
import com.niit.convert.JoblistConvert; 
import com.niit.model.Joblist; 
 
public class JoblistDao extends DataAccess { 
 
	public JoblistDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Joblist joblist) { 
		String sql = "INSERT INTO joblist (JobTitle,JobLat,JobLon,JobPostAddress,JobPayFee,JobPostDate,JobPostCompany,JobJSRQ,JobZPRS,JobGZRQ,JobGZDZ,JobMSSJ,JobMSDZ,JobZWMS,JobPhone,JobContactUser,JobCity) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), joblist.jobTitle,joblist.jobLat,joblist.jobLon,joblist.jobPostAddress,joblist.jobPayFee,joblist.jobPostDate,joblist.jobPostCompany,joblist.jobJSRQ,joblist.jobZPRS,joblist.jobGZRQ,joblist.jobGZDZ,joblist.jobMSSJ,joblist.jobMSDZ,joblist.jobZWMS,joblist.jobPhone,joblist.jobContactUser,joblist.jobCity				); 
	} 
 
	public int edit(Joblist joblist) { 
		String sql = "UPDATE joblist SET JobTitle=?,JobLat=?,JobLon=?,JobPostAddress=?,JobPayFee=?,JobPostDate=?,JobPostCompany=?,JobJSRQ=?,JobZPRS=?,JobGZRQ=?,JobGZDZ=?,JobMSSJ=?,JobMSDZ=?,JobZWMS=?,JobPhone=?,JobContactUser=?,JobCity=? WHERE JobID=?"; 
		return super.update(sql,
joblist.jobTitle,joblist.jobLat,joblist.jobLon,joblist.jobPostAddress,joblist.jobPayFee,joblist.jobPostDate,joblist.jobPostCompany,joblist.jobJSRQ,joblist.jobZPRS,joblist.jobGZRQ,joblist.jobGZDZ,joblist.jobMSSJ,joblist.jobMSDZ,joblist.jobZWMS,joblist.jobPhone,joblist.jobContactUser,joblist.jobCity,				 joblist.jobID); 
	} 
 
	public int delete(int jobID) { 
		String sql = "DELETE FROM joblist WHERE JobID=?"; 
		return super.update(sql, jobID); 
	} 
 
	public List<Joblist> findAll() { 
		String sql = "SELECT * FROM joblist"; 
		return super.queryForList(sql, new JoblistConvert()); 
	} 
 
	public List<Joblist> findWhere(String where) { 
		String sql = "SELECT * FROM joblist WHERE 1=1 " + where; 
		return super.queryForList(sql, new JoblistConvert()); 
	} 
 
	public Joblist findById(int jobID) { 
		String sql = "SELECT * FROM joblist WHERE  JobID=?"; 
		return super.queryForObject(sql, new JoblistConvert(), jobID); 
	} 
 
	public List<Joblist> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM joblist limit ?,?", 
				new JoblistConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM joblist", 
				new IntegerConverter()); 
	} 
 
} 
