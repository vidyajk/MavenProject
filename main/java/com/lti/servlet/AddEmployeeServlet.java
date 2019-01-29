package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.dto.Employee5;

/**
 * Servlet implementation class Servlet
 */
public class AddEmployeeServlet extends HttpServlet {
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		String name= request.getParameter("name");
   		int empno = Integer.parseInt(request.getParameter("empno"));
   		double salary = Double.parseDouble(request.getParameter("salary"));
   		
        Employee5 emp = new Employee5();
        emp.setEmpno(empno);
        emp.setName(name);
        emp.setSalary(salary);
      
   		AddEmployeeDao ed = new AddEmployeeDao();
   		ed.insert(emp);
   		HttpSession session = request.getSession();
   		session.setAttribute("message", "Record has been added successfullyyyyy!!!!");
   		response.sendRedirect("addEmp.jsp");
   		
   	}
}
