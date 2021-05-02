package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Terminology;
import com.example.demo.repository.TerminologyRepository;
import com.example.demo.service.interfaces.ITerminologyService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TerminologyService implements ITerminologyService, UserDetailsService {

	TerminologyRepository terminologyRepository;

	static List<Terminology> terminologyList = new ArrayList<>();
	static {
		terminologyList.add(new Terminology(1, "ABC", "test", "this is a test"));
		terminologyList.add(new Terminology(2, "Rx", "prescription", "this is a test"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Terminology> getAllTerminologies() {
		return terminologyRepository.findAll();
//		return terminologyList;
	}

	@Override
	public void createNewTerminology(Terminology terminologyBean) {
//		terminologyList.add(termin ologyBean);
		terminologyRepository.save(terminologyBean);
	}

	@Override
	public Terminology findById(Integer id) {
		return terminologyRepository.findById(id).orElseThrow(() -> new IllegalStateException("Invalid id"));
	}

	@Override
	public void deleteById(Integer id) {
		terminologyRepository.deleteById(id);
	}

	@Override
	public void updateTerminology(Terminology terminologyBean) {
		terminologyRepository.updateTerminology(terminologyBean.getShortForm(), terminologyBean.getFullForm(),
				terminologyBean.getDescription(), terminologyBean.getId());
	}

	@Override
	public List<Terminology> getSearchResult(String searchKeyword) {

		return terminologyRepository.searchTerminologyIgnoreCase(searchKeyword.toLowerCase());
	}

}
