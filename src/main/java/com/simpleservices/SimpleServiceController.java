package com.simpleservices;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/applications")
public class SimpleServiceController {
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method=RequestMethod.GET)
	public List<Applications> listAll() {
		List<Applications> appResponses = new ArrayList<Applications>();
		applicationRepository.findAll().forEach(appResponses::add);
		logger.info("LIST applications={}", appResponses);
		return appResponses;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void add(@RequestBody Applications application) {
		logger.info("ADDING application={}", application);
		applicationRepository.save(application);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void update(@RequestBody Applications application) {
		logger.info("UPDATING application={}", application);
		applicationRepository.save(application);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public void delete(String id) {
		logger.info("DELETING id={}", id);
		applicationRepository.delete(id);
	}
}
