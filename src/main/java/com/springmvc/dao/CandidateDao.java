package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Candidate;

public interface CandidateDao {
	
	public int save(Candidate candidate);
	public int update(Candidate candidate);
	public int delete(int id);
	public Candidate getCandidateById(int id);
	public List<Candidate> getCandidates();
	

}
