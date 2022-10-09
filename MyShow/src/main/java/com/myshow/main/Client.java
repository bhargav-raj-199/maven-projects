package com.myshow.main;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.myshow.model.Genre;
import com.myshow.model.Language;
import com.myshow.model.Movie;
import com.myshow.model.User;
import com.myshow.service.BookingServiceImpl;
import com.myshow.service.IBookingService;
import com.myshow.service.IMyShowService;
import com.myshow.service.IUserService;
import com.myshow.service.MyShowServiceImpl;
import com.myshow.service.UserServiceImpl;

/**
 * @author BhargavRajJinka
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
			// TODO Auto-generated method stub
			List<Movie> movies = new ArrayList<>();
			IMyShowService myShowService = new MyShowServiceImpl();
			IUserService userService=new UserServiceImpl();
			IBookingService bookingService=new BookingServiceImpl();
			Scanner s = new Scanner(System.in);
			boolean flag=false;
			System.out.println("WELCOME TO MYSHOW");
			System.out.println("WE OFFER HASSEL FREE MOVIE BOOKING");
			do {
				System.out.println();
				System.out.println("please enter \n1.admin\n2.user");
				int choose=s.nextInt();
				s.nextLine();
				if(choose==1) {
					String type="admin";
					System.out.println("please enter username");
					String username=s.nextLine();
					System.out.println("please enter your password");
					String password=s.nextLine();
					userService.login(username, password,type);
					
					System.out.println("WELCOME TO ADMIN PORTAL\nPLEASE SELECT THE BELOW OPTION");
					System.out.println("1.add movie\n2.updateMovie\n3.Delete Movie\n4.Get Movie By Id\n5.change password");
					int choice = s.nextInt();
					s.nextLine();
					switch(choice)
					{
					case 1:
						
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						Movie movie=new Movie();
						System.out.println("enter movie title");
						movie.setTitle(s.nextLine());
						System.out.println("enter language\nselect\n0.TELUGU\n1.HINDI\n2.ENGLISH\n3.TAMIL\n4.KANNADA\n5.MALAYALAM");
						int lan = s.nextInt();
						s.nextLine();
						movie.setLanguage(Language.values()[lan].type);
						
						System.out.println("enter genre\n0.ACTION\n1.ROMANCE\n2.THRILLER\n3.DRAMA\n4.HORROR\n5.SCIENCE FICTION\n6.ADVENTURE\n7.ANIMATION");
						int gen = s.nextInt();
						s.nextLine();
						movie.setGenre(Genre.values()[gen].type);
						System.out.println("enter location of movie");
						movie.setLocation(s.nextLine());
						System.out.println("enter ReleaseDate in \"yyyy-MM-dd\"");
						movie.setReleaseDate(LocalDateTime.parse(s.nextLine(),formatter));
						System.out.println("enter rating");
						movie.setRating(s.nextInt());
						s.nextLine();
						System.out.println("enter duration");
						movie.setDuration(s.nextInt());
						s.nextLine();
						System.out.println("enter availableSeats");
						movie.setAvailableSeats(s.nextInt());
						s.nextLine();
						System.out.println("enter price");
						movie.setPrice(s.nextInt());
						s.nextLine();
						
						break;
						
						
					case 2:
						System.out.println("enter movie id");
						Integer movieId=s.nextInt();
						s.nextLine();
						System.out.println("enter movie language");
						String language=s.nextLine();
						myShowService.updateMovie(movieId, language);
							
					
						
						
						break;
						
						
					case 3:
						System.out.println("enter movie id");
						movieId=s.nextInt();
						s.nextLine();
						myShowService.deleteMovie(movieId);
						
						break;
						
						
					case 4:
						System.out.println("enter movie id");
						movieId=s.nextInt();
						s.nextLine();
						System.out.println(myShowService.getById(movieId));
						
						break;
					case 5:
						System.out.println("enter username");
						username=s.nextLine();
						System.out.println("enter new password");
						password=s.nextLine();
						userService.changePassword(username, password);
						break;
						
						
					default:System.out.println("WRONG INPUT PLEASE TRY AGAIN");
					}
				}
					
				else
				{
					System.out.println("please enter \n1.registration\n2.login");
					int select=s.nextInt();
					s.nextLine();
					if(select==1)
					{
						User user=new User();
						System.out.println("enter username");
						user.setUsername(s.nextLine());
						System.out.println("enter name");
						user.setName(s.nextLine());
						System.out.println("enter city");
						user.setCity(s.nextLine());
						System.out.println("enter email");
						user.setEmail(s.nextLine());
						System.out.println("enter mobile");
						user.setMobile(s.nextLong());
						user.setType("user");
						String password=userService.register(user);
						System.out.println("please note your password");  
						System.out.println(password);
						
						
						}
					else {
						String type="user";
						System.out.println("please enter username");
						String username=s.nextLine();
						System.out.println("please enter your password");
						String password=s.nextLine();
						userService.login(username, password,type);
					}
					System.out.println("WELCOME TO USER PORTAL\nPLEASE SELECT THE BELOW OPTION");
					System.out.println("1.Get All Movies\n2.Movie By Language\n3.Movie By Genre\n4.Movie By Genre and Language\n5.Movie By Rating\n6.Movie by Title\n7.change password\n8.BookShow");
					int choice = s.nextInt();
					s.nextLine();
					switch (choice) {
					case 1:
						movies = myShowService.getAllMovies();
						movies.forEach(System.out::println);
						break;
						

					case 2:
						System.out.println(
								"enter language\nselect\n0.TELUGU\n1.HINDI\n2.ENGLISH\n3.TAMIL\n4.KANNADA\n5.MALAYALAM");
						int lan = s.nextInt();
						s.nextLine();
						String language = Language.values()[lan].type;
						movies = myShowService.getMoviesByLanguage(language);
						movies.forEach(System.out::println);
						break;

					case 3:
						System.out.println("enter genre\n0.ACTION\n1.ROMANCE\n2.THRILLER\n3.DRAMA\n4.HORROR\n5.SCIENCE FICTION\n6.ADVENTURE\n7.ANIMATION");
						int gen = s.nextInt();
						s.nextLine();
						String genre = Genre.values()[gen].type;
						movies = myShowService.getMoviesByGenre(genre);
						movies.forEach(System.out::println);
						break;

					case 4:
						System.out.println(
								"enter language\nselect\n0.TELUGU\n1.HINDI\n2.ENGLISH\n3.TAMIL\n4.KANNADA\n5.MALAYALAM");
						lan = s.nextInt();
						s.nextLine();
						language = Language.values()[lan].type;
						System.out.println("enter genre\n0.ACTION\n1.ROMANCE\n2.THRILLER\n3.DRAMA\n4.HORROR\n5.SCIENCE FICTION\n6.ADVENTURE\n7.ANIMATION");
						gen = s.nextInt();
						s.nextLine();
						genre = Genre.values()[gen].type;
						movies = myShowService.getMoviesByGenreAndLan(genre,language);
						movies.forEach(System.out::println);
						break;
						
						

						
					case 5:
						System.out.println("enter rating");
						int rating=s.nextInt();
						s.nextLine();
						movies=myShowService.getMoviesByRating(rating);
						movies.forEach(System.out::println);
						break;
						

					case 6:
						System.out.println("enter title");
						String title=s.nextLine();
						movies=myShowService.getMovieByNameStarting(title+"%");
						movies.forEach(System.out::println);
						break;
						
					case 7:
						System.out.println("enter username");
						String username=s.nextLine();
						System.out.println("enter new password");
						String password=s.nextLine();
						userService.changePassword(username, password);
						break;
						
					case 8:
						//Map<Integer,Movie> movieMap=new TreeMap<>();
						System.out.println("enter movie name");
						title=s.nextLine();
						movies=myShowService.getMovieByNameStarting(title+"%");
						for(int i=0;i<movies.size();i++)
						{
							System.out.println("press "+(i+1)+" for "+movies.get(i).getTitle()+" available seats "+movies.get(i).getAvailableSeats());
							
						}
						int result=s.nextInt();
						s.nextLine();
						Movie movie=movies.get(result-1);
						System.out.println("enter no.of seats");
						int seats=s.nextInt();
						s.nextLine();
						double price=bookingService.bookShow(movie, seats);
						
						System.out.println(price);
						
						break;
						
						
						
						

					

					default:
						System.out.println("YOU HAVE ENTERED WRONG OUTPUT\nPLEASE TRY AGAIN");

					}
				}
					System.out.println();
					System.out.println("DO YOU WANT TO CONTINUE\n1.CONTINUE\n2.TO EXIT");
					int select = s.nextInt();
					s.nextLine();
					if (select == 1)
						flag = true;
					else
						flag = false;
					
				

				} while (flag);

				System.out.println(" THANK YOU \n VISIT AGAIN ");
				s.close();
			}

	}
	
								