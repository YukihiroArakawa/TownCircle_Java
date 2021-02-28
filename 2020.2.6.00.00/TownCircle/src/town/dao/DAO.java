package town.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAO implements AutoCloseable {
	protected Connection connection = null; // ------------------------ ①

	public DAO() {

	}

	/**
	 * データベースとの接続を取得する。 もし取得していた場合には既存の接続を利用し、 取得していない場合は新たにコンテナから取得する。
	 *
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {

		System.out.println("DAO.java_getConnection()");

		// NamingException, SQLExceptionがスローされる
		try {
			if (connection == null || connection.isClosed()) {
				InitialContext initCtx = new InitialContext();
				DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/localDB");
				// データベース接続を取得する
				connection = ds.getConnection();
			}
		} catch (NamingException|SQLException e) {
			// もし接続取得で例外が出た場合はconnection=nullにし、
			// 発生した例外はそのまま送出する。
			e.printStackTrace();
			connection = null;
			throw e;
		}

		return connection;
	}

	/**
	 * 接続を閉じる。
	 */
	public void closeConnection() {

		System.out.println("DAO.java_closeConnection()");
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection = null;
		}
	}

	/**
	 * PreparedStatementを返す
	 *
	 * @param sql
	 * @return
	 * @throws Exception
	 * */

	public PreparedStatement getPreparedStatement(String sql) throws Exception{
		return getConnection().prepareStatement(sql);
	}
	/*
	 * トランザクションのコミットを行う
	 *
	 * @throws SQLException
	 * */

	public void commit() throws SQLException{
		System.out.println("DAO.java_commit()");
		connection.commit();
	}

	/*
	 * トランザクションのロールバックを行う
	 *
	 * @throws SQLException
	 * */

	public void rollback() throws SQLException{
		System.out.println("DAO.java_rollback()");
		connection.rollback();
	}

	/*
	 * 接続を閉じる
	 * */

	public void close() {
		System.out.println("close()");
		System.out.println("close connection ------------------------>");

		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connection = null;
		}
	}
}

