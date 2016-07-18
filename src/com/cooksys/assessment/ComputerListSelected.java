package com.cooksys.assessment;

import java.util.*;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ComputerListSelected {
	private ArrayList<String> list = new ArrayList<String>();
	
	@XmlElementWrapper
	@XmlElement(name="item")
	public ArrayList<String> getList() {
		return list;
	}
	
}
