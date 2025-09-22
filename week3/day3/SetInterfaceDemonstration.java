package week3.day3;

import java.util.LinkedHashSet;
import java.util.Set;
//******Classroom Assignment <2>: Demonstrating Set Interface in Java*************
public class SetInterfaceDemonstration {

	public static void main(String[] args) {
	
		String CompanyName = "google";
//Create a Set to store unique characters		
		Set<Character> CompanyNameResult = new LinkedHashSet<>();
		String Result = "";
//Iterate through each character in the companyName string		
		for(int i=0;i<CompanyName.length();i++) {
			char cn =CompanyName.charAt(i);//extract characters in string
//Add each character into the LinkedHashSet			
			CompanyNameResult.add(cn);
			}
		System.out.println("Company Name without duplicates as LinkedHashSet : "+ CompanyNameResult);
//Append the characters ie chars to string
		for (char c : CompanyNameResult) {
		    Result += c;
		}
//Print the unique characters from the string.		
		System.out.println("Company Name without duplicates: "+ Result);

		}
	}


