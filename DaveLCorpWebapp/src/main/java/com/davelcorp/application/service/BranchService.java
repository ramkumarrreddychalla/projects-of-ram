package com.davelcorp.application.service;

import com.davelcorp.application.model.Branch;
import com.davelcorp.application.model.User;

import java.util.List;


public interface BranchService {

	Branch findByBranchId(long id);

	Branch findByBranchName(String name);

	void saveBranch(Branch user);

	void updateBranch(Branch user);

	void deleteBranchById(long id);

	List<Branch> findAllBranches();

	void deleteAllBranches();

	public boolean isBranchExist(Branch branch);

}
