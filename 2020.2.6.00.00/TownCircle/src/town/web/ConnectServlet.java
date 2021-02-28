package town.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ConnectServlet
 */
@WebServlet("/ConnectServlet")
public class ConnectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ConnectServlet.java_DoGet");
		DataSource ds;
		try {
			InitialContext initCtx = new InitialContext();
			//Tomcatで管理されたデータベース接続をJNDI経由で取得。
			//java:comp/env/を必ずつける
			ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/localDB");
		} catch (NamingException e) {
			throw new ServletException(e);
		}

		try(Connection connection = ds.getConnection()){
			//接続が正しく完了するとコンソールにメッセージを出力
			log("接続を開きました");
		} catch(SQLException e) {
			//例外が発生したときにはサーブレット例外にしてエラーとする.
			throw new ServletException(e);
		}

		request.getRequestDispatcher("/complete.html").forward(request, response);

		//TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
