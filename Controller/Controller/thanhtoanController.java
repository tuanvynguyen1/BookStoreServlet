package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bean.khachHangbean;
import bo.giohangbo;
import bo.thanhtoanbo;

/**
 * Servlet implementation class thanhtoanController
 */
@WebServlet("/thanhtoanController")
public class thanhtoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thanhtoanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(session.getAttribute("dn")==null) {
			response.sendRedirect("login.jsp");
		}
		thanhtoanbo tt = new thanhtoanbo();
		if(request.getParameter("xacnhan")!=null) {
			tt.taoThanhToan((khachHangbean)session.getAttribute("dn"), (giohangbo)session.getAttribute("gh"));
			session.setAttribute("gh", new giohangbo());
		}
		else {
			request.setAttribute("thanhtoan", tt.getthanhtoan((khachHangbean)session.getAttribute("dn")));
		}
		RequestDispatcher rd= request.getRequestDispatcher("thanhtoan.jsp");
		rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			if(session.getAttribute("dn")==null) {
				response.sendRedirect("login.jsp");
			}
			thanhtoanbo tt = new thanhtoanbo();
			if(request.getParameter("confirm")!=null) {
				tt.hoantat((khachHangbean)session.getAttribute("dn"), request.getParameter("id"));
				String res;
				res = "{\"status\": \"ok\"}";
			out.print(res);
			out.flush();
			}
			
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

}
