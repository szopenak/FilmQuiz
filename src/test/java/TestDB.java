
import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arturkrotiuk.FilmQuiz.domain.Movie;
import com.arturkrotiuk.FilmQuiz.domain.MovieDAO;

public class TestDB {

	public static void main(String[] args) {
		String path = null;
		try {
			path = new File(".").getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(path);
		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("DefaultServlet-context.xml");
		
		//Get the EmployeeDAO Bean
		MovieDAO movieDAO = ctx.getBean("movieDAO", MovieDAO.class);
		
		//Run some tests for JDBC CRUD operations
		Movie movie = new Movie();
		int rand = new Random().nextInt(1000);
		movie.setId(rand);
		movie.setTitle("Alien");
		movie.setYear(1989);
		movie.setPosterUrl("some http url");
		
		//Create
		movieDAO.save(movie);
		
		//Read
		Movie movieRead = movieDAO.getById(rand);
		System.out.println("Employee Retrieved::"+movieRead);
		
		
		//Close Spring Context
		ctx.close();
		
		System.out.println("DONE");
	}


}
