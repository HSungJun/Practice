package Exam01;

public class Manager {
	//teachers_code ���� �����Ϳ� ���õ� ������ �� �����´�. 
	private Movie[] movie = new Movie[100];
	private int index = 0;
	
	public void addMovie(Movie movie) {
		this.movie[index++] = movie;
	}
	
	
	public Movie[] getMovie() {
		return this.movie;
	}
	
	public int getIndex() {
		return index;
	}
	
	
}