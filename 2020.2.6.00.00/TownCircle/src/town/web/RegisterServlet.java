package town.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import town.dao.UserDAO;
import town.dto.Circle;;
/**
 * 登録処理を行うサーブレット
 */
@WebServlet("/town/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("RegisterServlet.java");

		// リクエストパラメータを受け取り、DTOに格納する準備をする
		int id = Integer.parseInt(request.getParameter("id"));
		int place = Integer.parseInt(request.getParameter("place"));
		int category = Integer.parseInt(request.getParameter("category"));
		int menWomen = Integer.parseInt(request.getParameter("menWomen"));
		int frequency = Integer.parseInt(request.getParameter("frequency"));
		int event = Integer.parseInt(request.getParameter("event"));
		int love = Integer.parseInt(request.getParameter("love"));
		int fee = Integer.parseInt(request.getParameter("fee"));
		int smoker= Integer.parseInt(request.getParameter("smoker"));
		String priority = request.getParameter("priority");

		//DTOへ格納する。
		Circle dto = new Circle();
		dto.setId(id);
		dto.setPlace(place);
		dto.setCategory(category);
		dto.setMenWomen(menWomen);
		dto.setFrequency(frequency);
		dto.setEvent(event);
		dto.setLove(love);
		dto.setFee(fee);
		dto.setSmoker(smoker);
		dto.setPriority(priority);


		try(UserDAO dao = new UserDAO()){
			dao.registerInsert(dto);
			String message = "ユーザーの新規登録が完了しました。";
			setMessage(request, message);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		//if文で入力値を見比べて、検索用サーブレットを分岐する
		//登録処理->マッチング結果の画面を表示する
		if(priority.contentEquals("Nothing")) {
			System.out.println("priority is " + priority);
			RequestDispatcher rd = request.getRequestDispatcher("/town/search");
			rd.forward(request, response);
		}else if(priority.contentEquals("menWomen")) {
			System.out.println("priority is " + priority);
			RequestDispatcher rd = request.getRequestDispatcher("/town/search_menWomen");
			rd.forward(request, response);
		}else if(priority.contentEquals("frequency")) {
			System.out.println("priority is " + priority);
			RequestDispatcher rd = request.getRequestDispatcher("/town/search_frequency");
			rd.forward(request, response);
		}else if(priority.contentEquals("event")) {
			System.out.println("priority is " + priority);
			RequestDispatcher rd = request.getRequestDispatcher("/town/search_event");
			rd.forward(request, response);
		}else if(priority.contentEquals("fee")) {
			System.out.println("priority is " + priority);
			RequestDispatcher rd = request.getRequestDispatcher("/town/search_fee");
			rd.forward(request, response);
		}else if(priority.contentEquals("smoker")) {
			System.out.println("priority is " + priority);
			RequestDispatcher rd = request.getRequestDispatcher("/town/search_smoker");
			rd.forward(request, response);
		}else if(priority.contentEquals("love")) {
			System.out.println("priority is " + priority);
			RequestDispatcher rd = request.getRequestDispatcher("/town/search_love");
			rd.forward(request, response);
		}
	}

	/*
	 * JSPで表示するメッセージを設定する
	 *
	 * @param request
	 *
	 * @param message
	 *
	 * */
	protected void setMessage(HttpServletRequest request, String message) {
		request.setAttribute("message", message);
	}

}
