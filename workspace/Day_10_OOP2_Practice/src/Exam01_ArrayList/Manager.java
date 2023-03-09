package Exam01_ArrayList;

import java.util.ArrayList;

public class Manager {
	//teachers_code 에서 데이터와 관련된 명령을 다 가져온다. 
	private ArrayList<Movie> movies = new ArrayList<Movie>();

	
	public void addMovie(Movie movies) {
		this.movies.add(movies);
	}
	public int removeMovie(String title) {
		int index = this.getIndexByTitle(title);
		if(index==-1) {
			return index;
			}else {
				this.movies.remove(index);
				return 0;
			}
	}
	
	public ArrayList<Movie> seartchTitle(String title) {
		ArrayList<Movie> result = new ArrayList<>();
			
		for (Movie movie : movies) {
			if (movie.getTitle().contains(title)) {
				result.add(movie);
			}
		}
		return result;
	}
	
	public void updateByTitle(String title, Movie updMovie){
		for(Movie movie : movies) {
			if(movie.getTitle().equals(title)) {
				movie.setTitle(updMovie.getTitle());
				movie.setGenre(updMovie.getGenre());
				movie.setScore(updMovie.getScore());
			}
		}
		
	}
	
	public int getIndexByTitle(String title) {
		for(int i=0; i < movies.size(); i++) {
			if(movies.get(i).getTitle().equals(title)) {
				return i;
			}
		}
		return -1;
	}
	
	public void updateByIndex(int index, Movie dst) {
		movies.set(index, dst);
	
	}
	
	public ArrayList<Movie> getMovie() {
		return this.movies;
	}


	


	
	
	
	
	
}
