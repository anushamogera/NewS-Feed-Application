/**
 * 
 */
/**
 * @author Deepak
 *
 */
package com.project.dbwt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dbwt.model.NewsAggregatorModel;
import com.project.dbwt.repository.NewsAggregatorRepository;

@RestController
@RequestMapping("/news")
public class NewsController{
	
	@Autowired
	private NewsAggregatorRepository newsAggregatorRepository;
	
	@GetMapping
	public List<NewsAggregatorModel> getAllNews(){
		return newsAggregatorRepository.findAll();
	}
	
	
}