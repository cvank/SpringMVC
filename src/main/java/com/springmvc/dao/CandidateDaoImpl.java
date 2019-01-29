package com.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Candidate;

public class CandidateDaoImpl implements CandidateDao{
	
	@Autowired
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    

	public int save(Candidate candidate) {
		 String sql="insert into candidates(firstname, lastname, email, address, phone) values('"+candidate.getFirst_name()+"','"+candidate.getLast_name()+"','"+candidate.getEmail()+"','"+candidate.getAddress()+"','"+candidate.getPhone()+"')";    
		 return template.update(sql); 
	}

	public int update(Candidate candidate) {
		String sql="update candidates set name='"+candidate.getFirst_name()+"', salary="+candidate.getLast_name()+",designation='"+candidate.getEmail()+"' where id="+candidate.getId()+"";    
	    return template.update(sql); 
	}

	public int delete(int id) {
		String sql="delete from candidates where id="+id+"";    
	    return template.update(sql);  
	}

	public Candidate getCandidateById(int id) {
		 String sql="select * from candidates where id=?";    
		
		 return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Candidate>(Candidate.class)); 
	}

	public List<Candidate> getCandidates() {
		 return template.query("select * from candidates",new RowMapper<Candidate>(){    
		        public Candidate mapRow(ResultSet rs, int row) throws SQLException {    
		        	Candidate e=new Candidate();    
		            e.setId(rs.getInt(1));    
		            e.setFirst_name((rs.getString(2)));
		            e.setLast_name((rs.getString(3))); 
		            e.setEmail((rs.getString(4)));    
		               
		            return e;    
		        }    
		    });
	}

}
