package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachHangbean;
import bo.khachHangbo;

/**
 * Servlet implementation class authenticationController
 */
@WebServlet("/authenticationController")
public class authenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authenticationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String method = request.getParameter("g");
		khachHangbo khb = new khachHangbo();
		if(method.equalsIgnoreCase("login")) {
			try {
				PrintWriter out = response.getWriter();
				String uname=request.getParameter("uname");
				String upass=request.getParameter("password");
				khachHangbean user = khb.ktdn(uname, upass);
				String res;
				if(user!=null){
					session.setAttribute("dn", user);
					res = "{\"status\": \"ok\"}";
				}
				else{
					res = "{\"status\": \"wrong\"}";
				}
				out.print(res);
				out.flush();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(method.equalsIgnoreCase("register")) {
			try {
			PrintWriter out = response.getWriter();
			String uname=request.getParameter("uname");
			String upass=request.getParameter("password");
			String hoten = request.getParameter("name");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String sdt = request.getParameter("sdt");
			khachHangbean user = khb.dangky(hoten, address, sdt, email, uname, upass);
			String res;
			if(user!=null){
				session.setAttribute("dn", user);
				res = "{\"status\": \"ok\"}";
			}
			else{
				res = "{\"status\": \"wrong\"}";
			}
			out.print(res);
			out.flush();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
