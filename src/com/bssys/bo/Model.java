package com.bssys.bo;

import java.util.ArrayList;
import java.util.List;

public class Model {
	private String xpathTab;
	private String namespaceTab;
	private XPathBO xpathBO;
	private NameSpaceBO nameSpaceBO;
	private List<String> xpathResult;
	private List<NameSpaceBO> namespaces;
	
	public Model(){
		xpathResult = new ArrayList<String>();
		namespaces = new ArrayList<NameSpaceBO>();
		xpathTab = "active";
		namespaceTab = "";
	}
	
	public String getXpathTab() {
		return xpathTab;
	}

	public void setXpathTab(String xpathTab) {
		this.xpathTab = xpathTab;
	}

	public String getNamespaceTab() {
		return namespaceTab;
	}

	public void setNamespaceTab(String namespaceTab) {
		this.namespaceTab = namespaceTab;
	}

	public NameSpaceBO getNameSpaceBO() {
		return nameSpaceBO;
	}
	public void setNameSpaceBO(NameSpaceBO nameSpaceBO) {
		this.nameSpaceBO = nameSpaceBO;
	}
	public XPathBO getXpathBO() {
		return xpathBO;
	}
	public void setXpathBO(XPathBO xpathBO) {
		this.xpathBO = xpathBO;
	}
	public List<NameSpaceBO> getNamespaces() {
		return namespaces;
	}
	public void setNamespaces(List<NameSpaceBO> namespaces) {
		this.namespaces = namespaces;
	}
	public List<String> getXpathResult() {
		return xpathResult;
	}
	public void setXpathResult(List<String> xpathResult) {
		this.xpathResult = xpathResult;
	}
	public void addNameSpace(NameSpaceBO nameSpaceBO) {
		// TODO Auto-generated method stub
		if (namespaces==null ){
			namespaces = new ArrayList<NameSpaceBO>();
		}
		namespaces.add(nameSpaceBO);
	} 
}
