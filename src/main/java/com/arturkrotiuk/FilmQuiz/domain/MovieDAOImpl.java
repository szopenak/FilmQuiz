package com.arturkrotiuk.FilmQuiz.domain;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MovieDAOImpl implements MovieDAO {
	
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Movie movie) {
		// TODO Auto-generated method stub
		String query = "insert into Movies (id, title, year, posterUrl) values (?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, movie.getId());
			ps.setString(2, movie.getTitle());
			ps.setInt(3, movie.getYear());
			ps.setString(4, movie.getPosterUrl());
			int out = ps.executeUpdate();
			
			if(out !=0){
				System.out.println("Employee saved with id="+movie.getId());
			}else System.out.println("Employee save failed with id="+movie.getId());
		}catch(SQLException e){
			e.printStackTrace();
		} finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Movie getById(int id) {
		// TODO Auto-generated method stub
		String query = "select title, year, posterUrl from Movies where id = ?";
		Movie movie = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()){
				movie = new Movie();
				movie.setId(id);
				movie.setTitle(rs.getString("title"));
				movie.setPosterUrl(rs.getString("posterUrl"));
				movie.setYear(rs.getInt("year"));
				System.out.println("Movie Found::"+movie);
			}else{
				System.out.println("No movie found with id="+id);
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movie;
	}

	@Override
	public List<Movie> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
