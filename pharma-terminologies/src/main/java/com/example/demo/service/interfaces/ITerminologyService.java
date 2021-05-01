package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.model.Terminology;

public interface ITerminologyService {

	List<Terminology> getAllTerminologies();

	void createNewTerminology(Terminology terminologyBean);

	Terminology findById(Integer id);

	void deleteById(Integer id);

	void updateTerminology(Terminology terminologyBean);
}
