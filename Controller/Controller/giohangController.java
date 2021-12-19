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

import bean.sachbean;
import bo.giohangbo;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class giohangController
 */
@WebServlet("/giohangController")
public class giohangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohangController() {
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
		request.setAttribute("link", "giohang");
		loaibo lb = new loaibo();
		giohangbo gh = new giohangbo();
		if(session.getAttribute("gh")==null){
			session.setAttribute("gh", gh);
		}
		gh = (giohangbo)session.getAttribute("gh");
		request.setAttribute("gh", gh);
		
			request.setAttribute("loaisach", lb.getLoai());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd= request.getRequestDispatcher("giohang.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		giohangbo gh = new giohangbo();
		String ajax = request.getParameter("g");
		String id = request.getParameter("id");
		String squantity = request.getParameter("quantity");
		String method = request.getParameter("method");
		if(ajax.equalsIgnoreCase("updateItem") && id != null && squantity != null){
			if(session.getAttribute("gh")==null){
				session.setAttribute("gh", gh);
			}
			gh = (giohangbo)session.getAttribute("gh");
			sachbo sbo = new sachbo();
			ArrayList<sachbean> sb = sbo.getSach();
			for(sachbean s:sb){
				
				if(id.equals(s.getMaSach())){
					gh.update(id, (Long.parseLong(squantity)));
				}
			}
			session.setAttribute("gh", gh);
			String res;
			res = "{\"tongtien\": \""+gh.TongTien()+"\"}";
			out.print(res);
			out.flush();
		}
		else{
		if (ajax.equalsIgnoreCase("addItem") && id != null && squantity != null) {
			if(session.getAttribute("gh")==null){
				session.setAttribute("gh", gh);
			}
			gh = (giohangbo)session.getAttribute("gh");
			sachbo sbo = new sachbo();
			ArrayList<sachbean> sb = sbo.getSach();
			for(sachbean s:sb){
				if(id.equals(s.getMaSach())){
					gh.Them(s.getMaSach(), s.getTenSach(), s.getTacGia(),s.getAnh(), s.getGia(), (Long.parseLong(squantity)));
				}
			}
			session.setAttribute("gh", gh);
			response.setContentType("text/html;charset=UTF-8");
	        response.getWriter().write(String.valueOf(gh.soluong()));
		}else{
			if(session.getAttribute("gh")==null){
				session.setAttribute("gh", gh);
			}
			gh = (giohangbo)session.getAttribute("gh");
			sachbo sbo = new sachbo();
			ArrayList<sachbean> sb = sbo.getSach();
			for(sachbean s:sb){
				if(id.equals(s.getMaSach())){
					gh.delete(id);
				}
			}
			session.setAttribute("gh", gh);
			String res;
			res = "{\"daxoa\": \"OK\"}";
			out.print(res);
			out.flush();
		}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
