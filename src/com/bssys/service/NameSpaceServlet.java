package com.bssys.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtilsBean;

import com.bssys.bo.NameSpaceBO;
import com.bssys.bo.Model;


/**
 * Servlet implementation class NameSpaceServlet
 */
public class NameSpaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameSpaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Model model = (Model)session.getAttribute("model");
		if (model==null){
			model = new Model();
			model.setXpathTab("");
			model.setNamespaceTab("active");
		}
		NameSpaceBO nameSpaceBO = new NameSpaceBO();
		Map nameSpaceMap = request.getParameterMap();
		BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
		try {
			beanUtilsBean.populate(nameSpaceBO, nameSpaceMap);
			session = request.getSession();
			model.addNameSpace(nameSpaceBO);
			session.setAttribute("model", model);
			response.sendRedirect("home.jsp");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
