package com.bssys.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtilsBean;

import com.bssys.bo.Model;
import com.bssys.bo.NameSpaceBO;
import com.bssys.bo.XPathBO;

/**
 * Servlet implementation class XPathServlet
 */
public class XPathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  XPathService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XPathServlet() {
        super();
        service = new XPathServiceImpl();
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
			model.setXpathTab("active");
			model.setNamespaceTab("");
		}
		XPathBO xpathBO = new XPathBO();
		Map xpathMap = request.getParameterMap();
		BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
		try {
			beanUtilsBean.populate(xpathBO, xpathMap);
			model.setXpathBO(xpathBO);
			PersonalNamespaceContext context = new PersonalNamespaceContext();
			List<NameSpaceBO> namespaces = model.getNamespaces();
			for (NameSpaceBO bo: namespaces){
				context.setPrefix(bo.getPrefix(),bo.getNamespace());
			}
			List<String> xpathResult = service.process(xpathBO, context);
			model.setXpathResult(xpathResult);
			session.setAttribute("model", model);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("home.jsp");
	}

}
