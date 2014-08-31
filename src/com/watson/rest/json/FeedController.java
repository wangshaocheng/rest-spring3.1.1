//FINAL 
package com.watson.rest.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.watson.rest.entity.Person;
import com.watson.rest.feeds.TournamentContent;


@Controller
public class FeedController {
    @RequestMapping("/jsonfeed")
    public String getJSON(Model model) {
        List<TournamentContent> tournamentList = new ArrayList<TournamentContent>();
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "World Cup", "www.fifa.com/worldcup/"));
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "U-20 World Cup", "www.fifa.com/u20worldcup/"));
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "U-17 World Cup", "www.fifa.com/u17worldcup/"));
        tournamentList.add(TournamentContent.generateContent("FIFA", new Date(), "Confederations Cup", "www.fifa.com/confederationscup/"));
        model.addAttribute("items", tournamentList);
        model.addAttribute("status", 0);
        return "jsontournamenttemplate";
    }
    
	@RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.GET)
	public String getPerson(@PathVariable("id") int id, Model model) {
		Person person = new Person();
		person.setName("张三");
		person.setSex("男");
		person.setAge(30);
		person.setId(id);
		model.addAttribute("person", person);
		return null;
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String getPersons(Model model) {
		List<Person> personList = new ArrayList<Person>();
		Person person1 = new Person();
		person1.setName("张三");
		person1.setSex("男");
		person1.setAge(30);
		person1.setId(1);
		
		Person person2 = new Person();
		person2.setName("李四");
		person2.setSex("男");
		person2.setAge(33);
		person2.setId(22);
		
		personList.add(person1);
		personList.add(person2);
		
		model.addAttribute("persons", personList);
		return null;
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public String  addPerson(Person person, Model model) {
		//TODO
		model.addAttribute("ret", 1);
		return null;
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.PUT)
	public String  updatePerson(Person person, Model model) {
		//TODO
		model.addAttribute("ret", 1);
		return null;
	}
	
	@RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.DELETE)
	public String deletePerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("ret", 1);
		return null;
	}
}
