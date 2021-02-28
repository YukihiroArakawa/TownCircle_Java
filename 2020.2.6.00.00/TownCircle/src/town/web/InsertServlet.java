package town.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			InitialContext context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/localDB");
			insert(dataSource);
		} catch (NamingException e) {
			throw new ServletException(e);
		}
		request.getRequestDispatcher("/complete.html").forward(request, response);
	}

	private void insert(DataSource dataSource) throws ServletException {
		// 実行するSQLを作成
		String sql = "INSERT INTO `user_list` ( `name`,`place`"
				+ ",`category`,`menWomen`, `frequency` ,`event`,"
				+ "`love`,`indoorOutdoor`,`fee`,`smoker`) "
				+ "VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? );"; // -----------------------	 ②
		try (Connection connection = dataSource.getConnection()) {
				PreparedStatement statement = connection.prepareStatement(sql);

			// PreparedStatementのプレースホルダーに変数を順番に格納する。 //--------------------- ④
			statement.setString(1, "荒川幸寛");
			statement.setInt(2, 1);
			statement.setInt(3, 3);
			statement.setInt(4, 3);
			statement.setInt(5, 3);
			statement.setInt(6, 3);
			statement.setInt(7, 3);
			statement.setInt(8, 3);
			statement.setInt(9, 3);
			statement.setInt(10, 3);// -------------------- ④

			// 更新系操作はexecuteUpdate()を利用し、その対象件数を取得することができる。
			int count = statement.executeUpdate(); // ------------------------ ⑤
			log("1つ目の追加:" + count);

			boolean forceStop = false;

			if ( forceStop ) {
				throw new ServletException("強制停止");
			}

			connection.commit(); // --------------------------- ⑧
		} catch(SQLException e) {
			throw new ServletException(e);
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
