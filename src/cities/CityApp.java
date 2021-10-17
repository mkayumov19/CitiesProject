/******************************************************************************
 *       1000 largest US Cities
 *       Each city has name, population, latitude, longitude, rank, and state
 *       You implement the method to find the given city's population, rank, state, and
 *       calculate the distance between two cities.
 ******************************************************************************
/**
 * This course project is copyright of CyberTek ©CyberTek[2017]. All rights reserved.
 * Any redistribution or reproduction of part or all of the contents in any form is
 * prohibited without the express consent of CyberTek.
 */

package cities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CityApp {

	private City[] cityList; //This array holds all City objects
	private int N = 1000;  // number of cities
	
	public CityApp(){
		cityList = new City[N];
		String path = System.getProperty("user.dir");
		loadCities(path+"/data/cities.txt");	
	}
	/**
	 * This method loads the words from a given file
	 * @param fileName	input file name
	 * DO NOT CHANGE THIS METHOD
	 */
	private void loadCities(String fileName){	
		// This will reference one line at a time
        String line = null;
        int count = 0;
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =  new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
            	if(line.startsWith("#")) continue;
            	String[] c = line.split(",");
            	String name = c[0];
            	double latitude = Double.parseDouble(c[2]);
            	double longitude = Double.parseDouble(c[3]);
            	int population = Integer.parseInt(c[4]);
            	int rank = Integer.parseInt(c[5]);
            	String state = c[6];
            	City ct = new City(name, latitude,longitude, population, rank,state);
            	cityList[count++] = ct;
            }   
            // Always close files.
            bufferedReader.close(); 
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'"); 
        }
	}
	
	public static void main(String[] args) {

		// Sample run in main method
		CityApp c = new CityApp();
		int p = c.population("chicago");
		System.out.println("Population of Chicago: " + p);
		int d = (int) c.distance("Chicago", "New York");
		System.out.println("Distance between Chicago and New York: " + d + " km");
		String city = c.cityByRank(4);
		System.out.println("The 4th largest city in USA is " + city);
		int count = c.citiesInState("california");
		System.out.println("Number of large cities in California:" + count);
	}
	/**
	 * Convert the first letter of each word in a string to upper case.
	 * words are delimited by a space.
	 * Leading and trailing space must be deleted.
	 * All city names in our list are camel cased.
	 * For example:
	 * 	input: my name is alice.
	 *  output: My Name Is Alice.
	 * camelCase("java is fun") -> "Java Is Fun"
	 * @param in: input string
	 * @return a string in which the first letter of each word is converted to upper-case.
	 */

	public String camelCase(String in){
		//TODO

		String camelCaseWord = "";
		String[] words = in.split(" ");
		for (String each : words) {
				String firstPart = each.substring(0,1).toUpperCase();
				camelCaseWord += firstPart + each.substring(1) + " ";
				}
				return camelCaseWord.trim();
//		return null;
	}

	/**
	 * Get the population of a given city.
	 * PLEASE USE cityList ARRAY. It is already declared and already holds all the city objects.
	 * For example:  
	 * 		City c = citiList[0];  //c is first city in the array.
	 *  	c.population   // population of this city
	 *  	c.rank			// rank of the city
	 *  	c.state        //state of the city
	 * population("New York") -> 8405837
	 * population("Chicago") -> 2718782
	 * population("Invalid City") -> -1
	 * @param city: name of the city
	 * @return population of the city. -1 if the city does not exist
	 */

	public int population(String city){
		//TODO
		for(City each:cityList){
			if(each.name.equalsIgnoreCase(city)){
				return each.population;
			}
		}
		return -1;  
	}

	/**
	 * Get the State of a given city belongs to
	 * PLEASE USE cityList ARRAY. It is already declared and already holds all the city objects.
	 * @param city: name of the city
	 * @return the state, to which the city belongs to. 
	 * Returns null if the city does not exist.
	 * For example:
	 * 	input: Alexandria
	 *  Output: Virginia
	 *  state("Alexandria") -> "Virginia"
	 *  state("Chicago") -> "Illinois"
	 *  state("Invalid City") -> null
	 */

	public String state(String city){
		//TODO
		for (City each: cityList) {
			if (each.name.equalsIgnoreCase(city)){
				return each.state;
		}
	}
		return null;
	}

	/**
	 * Find the city based on its rank
	 * @param rank: rank n represents it is nth largest city in US 
	 * @return the city name
	 * cityByRank(3) -> "Chicago"
	 */

	public String cityByRank(int rank){
		//TODO
		for (City city : cityList) {
			if (city.rank == rank){
				return city.name;
			}
		}
		return null;
	}

	/**
	 * Count the cities in a given state
	 * @param state
	 * @return: number of large cities in this state
	 * CitiesInState("maryland") -> 7
	 * CitiesInState("maine") -> 1
	 */

	public int citiesInState(String state) {
		//TODO
		int count = 0;
		for (City eachState : cityList) {
			if (eachState.state.equalsIgnoreCase(state))
			count++;

		}return count;
//		return 0;
	}
	/**
	 * Get the latitude of a given city
	 * PLEASE USE cityList ARRAY. It is already declared and 
	 * already holds all the city objects
	 * @param city: input 
	 * @return the latitude of the city
	 * latitude("Chicago") -> 41.8781136
	 * latitude("Invalid City") -> -1
	 */

	private double latitude(String city){
		//TODO
		
		return -1;
	}
	/**
	 * Get the longitude of a given city
	 *  PLEASE USE cityList ARRAY. It is already declared and 
	 * already holds all the city objects
	 * @param city: input 
	 * @return the longitude of the city
	 * latitude("Chicago") -> -87.6297982
	 * latitude("Invalid City") -> -1
	 */

	private double longitude(String city){
		//TODO
		
		return -1;
	}
	/**
	 Formula:
	 d =  radius * acos(sin(lat1) * sin(lat2) + cos(lat1) * cos(lat2) * cos(lon1 - lon2))
	 -> Where radius = 6371
	 -> latitude and longitude are in radians
	 Use the Math library (java.lang.Math) for all the math operators: sin, cos, etc
	 to convert a number to radians: Math.toRadians(num)
	 Hint: static import the Math class and create variables for lat1, lat2, etc
	 * @param c1: start city
	 * @param c2: destination city
	 * @return the distance between the two cities.
	 */

	public double distance(String c1, String c2){
		//TODO
		double lat1=0, lat2=0,long1=0, long2=0;
		for(City each:cityList) {
			if (each.name.equalsIgnoreCase(c1)) {
				lat1= each.latitude;
				long1= each.longitude;
			}
			if (each.name.equalsIgnoreCase(c2)) {
				lat2= each.latitude;
				long2= each.longitude;
			}
		}

		int radius = 6371;
		double d=0;
		lat1=Math.toRadians(lat1);
		lat2=Math.toRadians(lat2);
		double lonDif=Math.toRadians(long1-long2);
		d = radius * Math.acos(Math.sin(lat1)*Math.sin(lat2)+Math.cos(lat1)*Math.cos(lat2)* Math.cos(lonDif));
		return  d;
	}
//	return 0;
}


