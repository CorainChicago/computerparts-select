package com.cooksys.assessment;

import java.util.*;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * creates a ComputerListSelected object with the attributes of list 
 * and items in the list
 * The object is an ArrayList of strings and has a method to return the list
 */
@XmlRootElement
public class ComputerListSelected {
	private ArrayList<String> list = new ArrayList<String>();
	
	@XmlElementWrapper
	@XmlElement(name="item")
	public ArrayList<String> getList() {
		return list;
	}
	
}
