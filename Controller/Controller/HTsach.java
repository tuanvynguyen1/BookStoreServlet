package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.sachbean;
import bo.giohangbo;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class HTsach
 */
@WebServlet("/HTsach")
public class HTsach extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HTsach() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			HttpSession session = request.getSession();
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			loaibo lb = new loaibo();
			sachbo sb = new sachbo();
			giohangbo gh = new giohangbo();
			String ml = request.getParameter("ml");
			String q = request.getParameter("q");
			ArrayList<sachbean> sach = sb.getSach();
			if(ml!=null && ml!=""){
				sach = sb.timTheoLoai(sb.getSach(), ml);
			}
			else if(q!=null && q!=""){
				sach = sb.timTheoTen(sb.getSach(), q);
			}
			if(session.getAttribute("gh")==null){
				session.setAttribute("gh", gh);
			}
			gh = (giohangbo)session.getAttribute("gh");
			request.setAttribute("sl", gh.soluong());
			request.setAttribute("loaisach", lb.getLoai());
			request.setAttribute("sach", sach);
			request.setAttribute("gh", gh);
			request.setAttribute("link", "home");
			RequestDispatcher rd= request.getRequestDispatcher("HTSach.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			log(e.toString());
		}	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
