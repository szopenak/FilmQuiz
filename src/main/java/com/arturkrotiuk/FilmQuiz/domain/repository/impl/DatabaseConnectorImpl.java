package com.arturkrotiuk.FilmQuiz.domain.repository.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.arturkrotiuk.FilmQuiz.domain.Question;
import com.arturkrotiuk.FilmQuiz.domain.Quiz;
import com.arturkrotiuk.FilmQuiz.domain.repository.DatabaseConnector;

@Repository
public class DatabaseConnectorImpl implements DatabaseConnector{
		private static DatabaseConnectorImpl database;
		Properties props = new Properties();
		InputStream fis;
		Connection con;

		private DatabaseConnectorImpl() {
			
			fis = getClass().getClassLoader().getResourceAsStream("database.properties");

			try {
				props.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(("Could not load properties file!"));
			}
			try {
				Class.forName(props.getProperty("DB_DRIVER_CLASS"));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(("Could not find DB_DRIVER_CLASS property!"));
			}
		}
		
		@Override
		public String getRecord(String url) {
			// TODO Auto-generated method stub
			
			return null;
		}
		
		private static Connection getConnection() throws SQLException {
			if (database == null) {
				database = new DatabaseConnectorImpl();
			}
			
			database.con = DriverManager.getConnection(database.props.getProperty("DB_URL"),
					database.props.getProperty("DB_USERNAME"),
					database.props.getProperty("DB_PASSWORD"));

			return database.con;
			
		}

		@Override
		public Question getNewQuestion(Quiz quiz) {
			// TODO Auto-generated method stub
			String query = null;
			if (quiz.getName().equals("Famous actors") || quiz.getName().equals("Famous actresses")) {
				try {
					Connection con = getConnection();
					
					if (quiz.getName().equals("Famous actors")) {
						query = "SELECT DISTINCT Name, Url FROM actors_images WHERE SEX = 'M' ORDER BY RAND() LIMIT 4";
					} else {
						query = "SELECT DISTINCT Name, Url FROM actors_images WHERE SEX = 'F' ORDER BY RAND() LIMIT 4";
					}
					PreparedStatement statement = con.prepareStatement(query);
					ResultSet rs = statement.executeQuery(query);
					Question q = new Question();
					q.setSentence("Who's on the picture above?");
					int image = new Random().nextInt(4);
					for (int j = 0; j<4; j++) {
						rs.next();
						q.getResponses()[j] = rs.getString("Name");
						if (j == image) q.setUrl(rs.getString("Url"));
					}
					con.close();
					return q;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			} else {
				//standard user quiz
			}
			return null;
		}

		@Override
		public String getHint(String quizName, String key) {
			if (quizName.equals("actors") ||quizName.equals("actresses")) {
				try {
					Connection con = getConnection();
					String query = "SELECT Role, Film FROM actors_images WHERE Url ='"+key+"'";
					Statement statement = con.createStatement();
					ResultSet rs = statement.executeQuery(query);
					rs.next();
					String hint = "Played "+rs.getString("Role")+" in "+rs.getString("Film");
					con.close();
					return hint;
	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 		
			} else {
				//standard user quiz
			}
			return null;
		}

		@Override
		public String getResult(String quizName, String key) {
			// TODO Auto-generated method stub
			if (quizName.equals("actors") ||quizName.equals("actresses")) {
			try {
				Connection con = getConnection();
				String query = "SELECT Name FROM actors_images WHERE Url ='"+key+"'";
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery(query);
				rs.next();
				String result =  rs.getString("Name");
				con.close();
				return result;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			} else {
				//standard user quiz
			}
			return null;
		}

		


}
