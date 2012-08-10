package com.bssys.service;

import java.util.List;

import com.bssys.bo.XPathBO;

public interface XPathService {
	
	public List<String> process(XPathBO xpathBO, PersonalNamespaceContext context);

}
