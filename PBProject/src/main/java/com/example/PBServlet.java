package com.example;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class PBServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		//	DAO에서 목록을 받아서 jsp로 전달

		String actionName = req.getParameter("a");

		if ("form".equals(actionName)) {
			// a=form이면
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/address/add.jsp");
			// 전달
			rd.forward(req, resp);
		} else {
			// DAO에서 목록을 받아서 jsp로 전달
			PBDAO dao = new PBDAOImpl();
			List<PBVO> list = dao.getList();

			// 요청에 list를 추가
			// list 객체를 list 키로 추가
			req.setAttribute("list", list);
			// JSP로 요청을 전달(FORWARD)

			// Dispatcher 확보
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/address/index.jsp");
			// FORWARD
			rd.forward(req, resp);
		}
	}
	
	
	
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String actionName = req.getParameter("a");

			
	if ("add".equals(actionName)) {//	a=add
		
		String name = req.getParameter("name");
		String hp = req.getParameter("hp");
		String tel = req.getParameter("tel");

		//	VO 객체 생성
		PBVO vo = new PBVO();
		vo.setName(name);
		vo.setHp(hp);
		vo.setTel(tel);
		
		//	INSERT 처리
		PBDAO dao = new PBDAOImpl();
		int insertedCount = dao.insert(vo);

		//	처리 후 list페이지로 리다이렉트
		resp.sendRedirect(req.getContextPath() + "/el");
	} else if ("delete".equals(actionName)) {
		//	a=delete면
		Long id = Long.valueOf(req.getParameter("id"));

		PBDAO dao = new PBDAOImpl();
		int deletedCount = dao.delete(id);

		//	리스트 페이지로 리다이렉트
		resp.sendRedirect(req.getContextPath() + "/el");
	} else {
		doGet(req, resp);
	}
}

}
