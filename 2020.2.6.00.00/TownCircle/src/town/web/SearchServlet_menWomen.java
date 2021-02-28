package town.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import town.dao.UserDAO;
import town.dto.Circle;
/**
 * Servlet implementation class SearchServlet
 */
@WebServlet(urlPatterns="/town/search_menWomen")
public class SearchServlet_menWomen extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 *　検索機能。サークル一覧を取得し、一覧結果へフォワードする
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("SearchServlet_menWomen.java_DoGet()");
		//DAOの取得
		try(UserDAO dao = new UserDAO()) {
			//サークルのリストを一覧で取得し、リクエスト属性へ格納する
			List<Circle> list = dao.circleList_menWomen();

			//検索結果をリクエスト属性へ格納
			request.setAttribute("resultList", list);//-(2)

			//検索結果を表示するlist.jspへフォワード
	//		request.getRequestDispatcher("/list.jsp").forward(request,response);//-(3)
		} catch (Exception e) {
			throw new ServletException(e);
		}

		//検索一覧を表示する
		RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
		rd.forward(request, response);

		System.out.println("request.getRequestDispatcher(\"/search.jsp\")");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

