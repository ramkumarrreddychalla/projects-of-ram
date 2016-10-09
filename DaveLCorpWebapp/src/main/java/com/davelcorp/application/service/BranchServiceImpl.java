package com.davelcorp.application.service;

import com.davelcorp.application.model.Branch;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service("branchService")
public class BranchServiceImpl implements BranchService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Branch> branches;
	
	static{
		branches= populateDummyBranches();
	}

	public List<Branch> findAllBranches() {
		return branches;
	}
	
	public Branch findByBranchId(long id) {
		for(Branch branch : branches){
			if(branch.getId() == id){
				return branch;
			}
		}
		return null;
	}
	
	public Branch findByBranchName(String name) {
		for(Branch branch : branches){
			if(branch.getHost().equalsIgnoreCase(name)){
				return branch;
			}
		}
		return null;
	}
	
	public void saveBranch(Branch branch) {
		branch.setId(counter.incrementAndGet());
		branches.add(branch);
	}

	public void updateBranch(Branch branch) {
		int index = branches.indexOf(branch);
		branches.set(index, branch);
	}

	public void deleteBranchById(long id) {
		
		for (Iterator<Branch> iterator = branches.iterator(); iterator.hasNext(); ) {
		    Branch branch = iterator.next();
		    if (branch.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isBranchExist(Branch branch) {
		return findByBranchName(branch.getHost())!=null;
	}
	
	public void deleteAllBranches(){
		branches.clear();
	}

	private static List<Branch> populateDummyBranches(){
		List<Branch> branches = new ArrayList<Branch>();
		branches.add(new Branch(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com","OK"));
		branches.add(new Branch(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com","Good"));
		branches.add(new Branch(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com","Excellent"));
		return branches;
	}

}
