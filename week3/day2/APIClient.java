package week3.day2;
//******Home Assignment <2A>: Demonstrating Method Overloading in Java****

/*Create a Java class named APIClient and 
 * create two methods with the same name passing different input arguments.*/
public class APIClient {
	public void sendRequest(String endpoint) {
		System.out.println("::SendRequest at Endpoint is displayed as " + endpoint);
	}
	public void sendRequest(String endpoint, String requestBody, boolean requestStatus) {
		System.out.println("::Overloaded SendRequest at Endpoint is displayed as " + endpoint);
		System.out.println("::SendRequest at RequestBody: " + requestBody );
		System.out.println("::RequestStatus to verify whether the "+ (requestStatus ? "Success(True)" : "Failed(False)"));
		}
	public static void main(String[] args) {
		APIClient API = new APIClient();
		API.sendRequest("https://api.test.com/getUsers");
		API.sendRequest("https://api.test.com/createUser", "{name:'xyz'}", true);
	}
}
