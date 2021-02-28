package town.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import town.dto.Circle;

/**
 * 新規登録の入力画面を表示する
 */
@WebServlet("/town/input")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("InputServlet.java_DoGet");
		//データを取得・格納する空のオブジェクトを作成
		Circle dto = new Circle();

		//サークル情報１件のDTOをリクエスト属性へバインド
		request.setAttribute("dto",dto);

		//詳細画面を表示する
		RequestDispatcher rd = request.getRequestDispatcher("/detail.jsp");
		rd.forward(request, response);

	}

}
