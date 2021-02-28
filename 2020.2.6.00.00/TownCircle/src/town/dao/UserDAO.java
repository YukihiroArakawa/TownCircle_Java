package town.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import town.dto.Circle;

public class UserDAO extends DAO {

	/*
	 * サークル抽出SQL(優先項目指定なし)
	 * */
	public List<Circle> circleList() throws Exception {
		List<Circle> returnList = new ArrayList<Circle>();

	System.out.println("UserDAO.java_circleList()");
		// 実行するSQLを作成
	String sql = "SELECT A.name , place_list.placeText , category_list.categoryText , menWomen_list.menWomenText,"
			+ " frequency_list.frequencyText , event_list.eventText , love_list.loveText "
			+ ", fee_list.feeText , smoker_list.smokerText ,A.link , A.intro FROM circle_list AS A "
			+ "INNER JOIN place_list USING(place) "
			+ "INNER JOIN category_list USING(category) "
			+ "INNER JOIN menWomen_list USING(menWomen) "
			+ "INNER JOIN frequency_list USING(frequency) "
			+ "INNER JOIN event_list USING(event) "
			+ "INNER JOIN love_list USING(love) "
			+ "INNER JOIN fee_list USING(fee) "
			+ "INNER JOIN smoker_list USING(smoker) "
			+ "WHERE "
			+ "A.place = (SELECT B.place FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C))"
			+ "AND A.category = (SELECT B.category FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C))"
			+ "ORDER BY "
	 		+ "(ABS(A.menWomen - (SELECT B.menWomen FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C)))"
	 		+ "+ (A.frequency - (SELECT B.frequency FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.event - (SELECT B.event FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.love - (SELECT B.love FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.fee - (SELECT B.fee FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.smoker - (SELECT B.smoker FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ ") ";


/*	String sql = "SELECT A.name , place_list.placeText , category_list.categoryText , menWomen_list.menWomenText,"
			+ " frequency_list.frequencyText , event_list.eventText , love_list.loveText "
			+ ", fee_list.feeText , smoker_list.smokerText ,A.link ,A.intro FROM circle_list AS A "
			+ "INNER JOIN place_list USING(place) "
			+ "INNER JOIN category_list USING(category) "
			+ "INNER JOIN menWomen_list USING(menWomen) "
			+ "INNER JOIN frequency_list USING(frequency) "
			+ "INNER JOIN event_list USING(event) "
			+ "INNER JOIN love_list USING(love) "
			+ "INNER JOIN fee_list USING(fee) "
			+ "INNER JOIN smoker_list USING(smoker) ";
*/
		// ステートメント(SQLを格納・実行するコンテナ)を取得。
		PreparedStatement statement = getPreparedStatement(sql);
		// SQLを実行し、結果を変数に格納する
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Circle dto = new Circle();

			// 検索結果1レコードの内容を取得する
			dto.setName(rs.getString("name"));
			dto.setPlaceText(rs.getString("placeText"));
			dto.setCategoryText(rs.getString("categoryText"));
			dto.setMenWomenText(rs.getString("menWomenText"));
			dto.setFrequencyText(rs.getString("frequencyText"));
			dto.setEventText(rs.getString("eventText"));
			dto.setLoveText(rs.getString("loveText"));
			dto.setFeeText(rs.getString("feeText"));
			dto.setSmokerText(rs.getString("smokerText"));
			dto.setLink(rs.getString("link"));
			dto.setIntro(rs.getString("intro"));
			// 検索結果をListへ格納
			returnList.add(dto);
		}

		return returnList;
	}

	/*
	 * サークル抽出SQL(男女比率)
	 * */

	public List<Circle> circleList_menWomen() throws Exception {
		List<Circle> returnList = new ArrayList<Circle>();

	System.out.println("UserDAO.java_circleList_memWomen()");
		// 実行するSQLを作成

	String sql = "SELECT A.name , place_list.placeText , category_list.categoryText , menWomen_list.menWomenText,"
			+ " frequency_list.frequencyText , event_list.eventText , love_list.loveText "
			+ ", fee_list.feeText , smoker_list.smokerText ,A.link , A.intro FROM circle_list AS A "
			+ "INNER JOIN place_list USING(place) "
			+ "INNER JOIN category_list USING(category) "
			+ "INNER JOIN menWomen_list USING(menWomen) "
			+ "INNER JOIN frequency_list USING(frequency) "
			+ "INNER JOIN event_list USING(event) "
			+ "INNER JOIN love_list USING(love) "
			+ "INNER JOIN fee_list USING(fee) "
			+ "INNER JOIN smoker_list USING(smoker) "
			+ "WHERE "
			+ "A.place = (SELECT B.place FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C))"
			+ "AND A.category = (SELECT B.category FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C))"
			+ "AND (ABS(A.menWomen - (SELECT B.menWomen FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C)))) BETWEEN 0 AND 1 "
			+ "ORDER BY "
	 		+ "(ABS(A.menWomen - (SELECT B.menWomen FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C)))"
	 		+ "+ (A.frequency - (SELECT B.frequency FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.event - (SELECT B.event FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.love - (SELECT B.love FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.fee - (SELECT B.fee FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.smoker - (SELECT B.smoker FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ ") ";

		// ステートメント(SQLを格納・実行するコンテナ)を取得。
		PreparedStatement statement = getPreparedStatement(sql);
		// SQLを実行し、結果を変数に格納する
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Circle dto = new Circle();

			// 検索結果1レコードの内容を取得する
			dto.setName(rs.getString("name"));
			dto.setPlaceText(rs.getString("placeText"));
			dto.setCategoryText(rs.getString("categoryText"));
			dto.setMenWomenText(rs.getString("menWomenText"));
			dto.setFrequencyText(rs.getString("frequencyText"));
			dto.setEventText(rs.getString("eventText"));
			dto.setLoveText(rs.getString("loveText"));
			dto.setFeeText(rs.getString("feeText"));
			dto.setSmokerText(rs.getString("smokerText"));
			dto.setLink(rs.getString("link"));
			dto.setIntro(rs.getString("intro"));
			// 検索結果をListへ格納
			returnList.add(dto);
		}

		return returnList;
	}

	/*
	 * サークル抽出SQL(活動頻度)
	 * */

	public List<Circle> circleList_frequency() throws Exception {
		List<Circle> returnList = new ArrayList<Circle>();

	System.out.println("UserDAO.java_circleList_frequency()");
		// 実行するSQLを作成

	String sql = "SELECT A.name , place_list.placeText , category_list.categoryText , menWomen_list.menWomenText,"
			+ " frequency_list.frequencyText , event_list.eventText , love_list.loveText "
			+ ", fee_list.feeText , smoker_list.smokerText ,A.link ,A.intro FROM circle_list AS A "
			+ "INNER JOIN place_list USING(place) "
			+ "INNER JOIN category_list USING(category) "
			+ "INNER JOIN menWomen_list USING(menWomen) "
			+ "INNER JOIN frequency_list USING(frequency) "
			+ "INNER JOIN event_list USING(event) "
			+ "INNER JOIN love_list USING(love) "
			+ "INNER JOIN fee_list USING(fee) "
			+ "INNER JOIN smoker_list USING(smoker) "
			+ "WHERE "
			+ "A.place = (SELECT B.place FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C))"
			+ "AND A.category = (SELECT B.category FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C))"
			+ "AND (ABS(A.frequency - (SELECT B.frequency FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C)))) BETWEEN 0 AND 1 "
			+ "ORDER BY "
	 		+ "(ABS(A.menWomen - (SELECT B.menWomen FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C)))"
	 		+ "+ (A.frequency - (SELECT B.frequency FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.event - (SELECT B.event FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.love - (SELECT B.love FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.fee - (SELECT B.fee FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.smoker - (SELECT B.smoker FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ ") ";

		// ステートメント(SQLを格納・実行するコンテナ)を取得。
		PreparedStatement statement = getPreparedStatement(sql);
		// SQLを実行し、結果を変数に格納する
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Circle dto = new Circle();

			// 検索結果1レコードの内容を取得する
			dto.setName(rs.getString("name"));
			dto.setPlaceText(rs.getString("placeText"));
			dto.setCategoryText(rs.getString("categoryText"));
			dto.setMenWomenText(rs.getString("menWomenText"));
			dto.setFrequencyText(rs.getString("frequencyText"));
			dto.setEventText(rs.getString("eventText"));
			dto.setLoveText(rs.getString("loveText"));
			dto.setFeeText(rs.getString("feeText"));
			dto.setSmokerText(rs.getString("smokerText"));
			dto.setLink(rs.getString("link"));
			dto.setIntro(rs.getString("intro"));
			// 検索結果をListへ格納
			returnList.add(dto);
		}

		return returnList;
	}
	/*
	 * サークル抽出SQL(イベント頻度)
	 * */
	public List<Circle> circleList_event() throws Exception {
		List<Circle> returnList = new ArrayList<Circle>();

	System.out.println("UserDAO.java_circleList_event()");
		// 実行するSQLを作成

	String sql = "SELECT A.name , place_list.placeText , category_list.categoryText , menWomen_list.menWomenText,"
			+ " frequency_list.frequencyText , event_list.eventText , love_list.loveText "
			+ ", fee_list.feeText , smoker_list.smokerText ,A.link , A.intro FROM circle_list AS A "
			+ "INNER JOIN place_list USING(place) "
			+ "INNER JOIN category_list USING(category) "
			+ "INNER JOIN menWomen_list USING(menWomen) "
			+ "INNER JOIN frequency_list USING(frequency) "
			+ "INNER JOIN event_list USING(event) "
			+ "INNER JOIN love_list USING(love) "
			+ "INNER JOIN fee_list USING(fee) "
			+ "INNER JOIN smoker_list USING(smoker) "
			+ "WHERE "
			+ "A.place = (SELECT B.place FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C))"
			+ "AND A.category = (SELECT B.category FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C))"
			+ "AND (ABS(A.event - (SELECT B.event FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C)))) BETWEEN 0 AND 1 "
			+ "ORDER BY "
	 		+ "(ABS(A.menWomen - (SELECT B.menWomen FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C)))"
	 		+ "+ (A.frequency - (SELECT B.frequency FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.event - (SELECT B.event FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.love - (SELECT B.love FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.fee - (SELECT B.fee FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.smoker - (SELECT B.smoker FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ ") ";


		// ステートメント(SQLを格納・実行するコンテナ)を取得。
		PreparedStatement statement = getPreparedStatement(sql);
		// SQLを実行し、結果を変数に格納する
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Circle dto = new Circle();

			// 検索結果1レコードの内容を取得する
			dto.setName(rs.getString("name"));
			dto.setPlaceText(rs.getString("placeText"));
			dto.setCategoryText(rs.getString("categoryText"));
			dto.setMenWomenText(rs.getString("menWomenText"));
			dto.setFrequencyText(rs.getString("frequencyText"));
			dto.setEventText(rs.getString("eventText"));
			dto.setLoveText(rs.getString("loveText"));
			dto.setFeeText(rs.getString("feeText"));
			dto.setSmokerText(rs.getString("smokerText"));
			dto.setLink(rs.getString("link"));
			dto.setIntro(rs.getString("intro"));
			// 検索結果をListへ格納
			returnList.add(dto);
		}

		return returnList;
	}

	/*
	 * サークル抽出SQL(カップル率)
	 * */
	public List<Circle> circleList_love() throws Exception {
		List<Circle> returnList = new ArrayList<Circle>();

	System.out.println("UserDAO.java_circleList_love()");
		// 実行するSQLを作成

	String sql = "SELECT A.name , place_list.placeText , category_list.categoryText , menWomen_list.menWomenText,"
			+ " frequency_list.frequencyText , event_list.eventText , love_list.loveText "
			+ ", fee_list.feeText , smoker_list.smokerText ,A.link ,A.intro FROM circle_list AS A "
			+ "INNER JOIN place_list USING(place) "
			+ "INNER JOIN category_list USING(category) "
			+ "INNER JOIN menWomen_list USING(menWomen) "
			+ "INNER JOIN frequency_list USING(frequency) "
			+ "INNER JOIN event_list USING(event) "
			+ "INNER JOIN love_list USING(love) "
			+ "INNER JOIN fee_list USING(fee) "
			+ "INNER JOIN smoker_list USING(smoker) "
			+ "WHERE "
			+ "A.place = (SELECT B.place FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C))"
			+ "AND A.category = (SELECT B.category FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C))"
			+ "AND (ABS(A.love - (SELECT B.love FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C)))) BETWEEN 0 AND 1 "
			+ "ORDER BY "
	 		+ "(ABS(A.menWomen - (SELECT B.menWomen FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C)))"
	 		+ "+ (A.frequency - (SELECT B.frequency FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.event - (SELECT B.event FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.love - (SELECT B.love FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.fee - (SELECT B.fee FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.smoker - (SELECT B.smoker FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ ") ";



		// ステートメント(SQLを格納・実行するコンテナ)を取得。
		PreparedStatement statement = getPreparedStatement(sql);
		// SQLを実行し、結果を変数に格納する
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Circle dto = new Circle();

			// 検索結果1レコードの内容を取得する
			dto.setName(rs.getString("name"));
			dto.setPlaceText(rs.getString("placeText"));
			dto.setCategoryText(rs.getString("categoryText"));
			dto.setMenWomenText(rs.getString("menWomenText"));
			dto.setFrequencyText(rs.getString("frequencyText"));
			dto.setEventText(rs.getString("eventText"));
			dto.setLoveText(rs.getString("loveText"));
			dto.setFeeText(rs.getString("feeText"));
			dto.setSmokerText(rs.getString("smokerText"));
			dto.setLink(rs.getString("link"));
			dto.setIntro(rs.getString("intro"));
			// 検索結果をListへ格納
			returnList.add(dto);
		}

		return returnList;
	}

	/*
	 * サークル抽出SQL(年会費)
	 * */
	public List<Circle> circleList_fee() throws Exception {
		List<Circle> returnList = new ArrayList<Circle>();

	System.out.println("UserDAO.java_circleList_fee()");
		// 実行するSQLを作成

	String sql = "SELECT A.name , place_list.placeText , category_list.categoryText , menWomen_list.menWomenText,"
			+ " frequency_list.frequencyText , event_list.eventText , love_list.loveText "
			+ ", fee_list.feeText , smoker_list.smokerText ,A.link ,A.intro FROM circle_list AS A "
			+ "INNER JOIN place_list USING(place) "
			+ "INNER JOIN category_list USING(category) "
			+ "INNER JOIN menWomen_list USING(menWomen) "
			+ "INNER JOIN frequency_list USING(frequency) "
			+ "INNER JOIN event_list USING(event) "
			+ "INNER JOIN love_list USING(love) "
			+ "INNER JOIN fee_list USING(fee) "
			+ "INNER JOIN smoker_list USING(smoker) "
			+ "WHERE "
			+ "A.place = (SELECT B.place FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C))"
			+ "AND A.category = (SELECT B.category FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C))"
			+ "AND (ABS(A.fee - (SELECT B.fee FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C)))) BETWEEN 0 AND 1 "
			+ "ORDER BY "
	 		+ "(ABS(A.menWomen - (SELECT B.menWomen FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C)))"
	 		+ "+ (A.frequency - (SELECT B.frequency FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.event - (SELECT B.event FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.love - (SELECT B.love FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.fee - (SELECT B.fee FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.smoker - (SELECT B.smoker FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ ") ";



		// ステートメント(SQLを格納・実行するコンテナ)を取得。
		PreparedStatement statement = getPreparedStatement(sql);
		// SQLを実行し、結果を変数に格納する
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Circle dto = new Circle();

			// 検索結果1レコードの内容を取得する
			dto.setName(rs.getString("name"));
			dto.setPlaceText(rs.getString("placeText"));
			dto.setCategoryText(rs.getString("categoryText"));
			dto.setMenWomenText(rs.getString("menWomenText"));
			dto.setFrequencyText(rs.getString("frequencyText"));
			dto.setEventText(rs.getString("eventText"));
			dto.setLoveText(rs.getString("loveText"));
			dto.setFeeText(rs.getString("feeText"));
			dto.setSmokerText(rs.getString("smokerText"));
			dto.setLink(rs.getString("link"));
			dto.setIntro(rs.getString("intro"));
			// 検索結果をListへ格納
			returnList.add(dto);
		}

		return returnList;
	}
	/*
	 * サークル抽出SQL(喫煙者比率)
	 * */
	public List<Circle> circleList_smoker() throws Exception {
		List<Circle> returnList = new ArrayList<Circle>();

	System.out.println("UserDAO.java_circleList_smoker()");
		// 実行するSQLを作成

	String sql = "SELECT A.name , place_list.placeText , category_list.categoryText , menWomen_list.menWomenText,"
			+ " frequency_list.frequencyText , event_list.eventText , love_list.loveText "
			+ ", fee_list.feeText , smoker_list.smokerText ,A.link ,A.intro FROM circle_list AS A "
			+ "INNER JOIN place_list USING(place) "
			+ "INNER JOIN category_list USING(category) "
			+ "INNER JOIN menWomen_list USING(menWomen) "
			+ "INNER JOIN frequency_list USING(frequency) "
			+ "INNER JOIN event_list USING(event) "
			+ "INNER JOIN love_list USING(love) "
			+ "INNER JOIN fee_list USING(fee) "
			+ "INNER JOIN smoker_list USING(smoker) "
			+ "WHERE "
			+ "A.place = (SELECT B.place FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C))"
			+ "AND A.category = (SELECT B.category FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C))"
			+ "AND (ABS(A.smoker - (SELECT B.smoker FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C)))) BETWEEN 0 AND 1 "
			+ "ORDER BY "
	 		+ "(ABS(A.menWomen - (SELECT B.menWomen FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C)))"
	 		+ "+ (A.frequency - (SELECT B.frequency FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.event - (SELECT B.event FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.love - (SELECT B.love FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.fee - (SELECT B.fee FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ "+ (A.smoker - (SELECT B.smoker FROM user_list AS B WHERE B.id = (SELECT MAX(C.id) FROM user_list AS C  )))"
	 		+ ") ";


		// ステートメント(SQLを格納・実行するコンテナ)を取得。
		PreparedStatement statement = getPreparedStatement(sql);
		// SQLを実行し、結果を変数に格納する
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Circle dto = new Circle();

			// 検索結果1レコードの内容を取得する
			dto.setName(rs.getString("name"));
			dto.setPlaceText(rs.getString("placeText"));
			dto.setCategoryText(rs.getString("categoryText"));
			dto.setMenWomenText(rs.getString("menWomenText"));
			dto.setFrequencyText(rs.getString("frequencyText"));
			dto.setEventText(rs.getString("eventText"));
			dto.setLoveText(rs.getString("loveText"));
			dto.setFeeText(rs.getString("feeText"));
			dto.setSmokerText(rs.getString("smokerText"));
			dto.setLink(rs.getString("link"));
			dto.setIntro(rs.getString("intro"));
			// 検索結果をListへ格納
			returnList.add(dto);
		}

		return returnList;
	}
	/*
	 * 新規登録SQL。
	 * @param dto 入力されたタスク内容
	 * @return　通過された件数
	 * @throws Exception
	 * */

	public int registerInsert(Circle dto) throws Exception {

		System.out.println("UserDAO_registerInsert()");

		String sql = "INSERT INTO user_list (place , "
				+ "category ,menWomen , frequency , event , "
				+ "love ,fee , smoker , priority)  "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";


		int result = 0;
		//プリペアーステートメントを取得し、実行するSQLを渡す
		try {
			PreparedStatement statement = getPreparedStatement(sql);
			statement.setInt(1,dto.getPlace());
			statement.setInt(2,dto.getCategory());
			statement.setInt(3,dto.getMenWomen());
			statement.setInt(4,dto.getFrequency());
			statement.setInt(5,dto.getEvent());
			statement.setInt(6,dto.getLove());
			statement.setInt(7,dto.getFee());
			statement.setInt(8,dto.getSmoker());
			statement.setString(9,dto.getPriority());

			result = statement.executeUpdate();

			//コミットを行う
			super.commit();
		} catch (Exception e) {
			//ロールバックを行い、スローした例外は呼び元のクラスへ渡す
			super.rollback();
			throw e;
		}
		return result;
	}


}
