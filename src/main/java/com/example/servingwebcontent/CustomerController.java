package com.example.servingwebcontent;

import java.util.List;

import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.servingwebcontent.entity.Customer;
import com.example.servingwebcontent.repository.CustomerMapper;
import com.google.gson.Gson;

/**
 * This class represents a controller for managing customers. It handles HTTP requests and responses related to customers.
 * The class includes methods for displaying a list of customers, displaying a table of customers, and returning a JSON formatted string representation of the list of customers.
 */
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerMapper mapper;

	/**
	 * Represents a sequence of characters. In this case, it is used to store a list of customer names.
	 */
	@GetMapping("/customer")
	@ResponseBody
	public String hello() {
		String names = "";
		for(Customer item:mapper.select(SelectDSLCompleter.allRows())) {
			names += item.getUsername().concat("</br>");
		}
		return names;
	}

	/**
	 * The String class represents character strings.
	 */
	@GetMapping("/list")
	public String list(Model model) {
		String names = "users";
		List<Customer> list = mapper.select(SelectDSLCompleter.allRows());
		
		model.addAttribute(names, list);
		return "list";
	}

	/**
	 * Returns a string representation of an object.
	 *
	 * @return a string representation of an object.
	 */
	@GetMapping("/table")
	public String initTable(Model model) {
	
		return "table";
	}

	/**
	 * Returns a JSON formatted string representation of the list of customers.
	 *
	 * @return a JSON formatted string representation of the list of customers.
	 */
	@GetMapping("/showTable")
	@ResponseBody
	public String showTable() {
		Gson gson = new Gson(); 
		/**
		 * List of customers retrieved from the database.
		 */
		List<Customer> list = mapper.select(SelectDSLCompleter.allRows());
		
		// 将list以json格式返回
		return gson.toJson(list);
	}
}
