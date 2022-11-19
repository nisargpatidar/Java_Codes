/*
Student Name: Nisarg Patel
Student ID: 200402077
*/

// A simple program to transfer file from the server to client

//This is my server code

//Included all the necessary packages
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class MyServerPlay{

	//Declaring variables for statistics
	public static int N = 0; //N is the total number of requests so far
	public static int M = 0; //M is the number of successful requests

	
	public static void main(String[] args) throws IOException{
	
		ServerSocket ss = new ServerSocket(4999);
		
		
		//To keep the server always online
		while(true){
		Socket s = ss.accept();
	
		//When the client get connected, it will show the message on server
		System.out.println("client connected");

		//Here we get the IP address for the client connected
		InetSocketAddress socketAddress = (InetSocketAddress)s.getRemoteSocketAddress();

		//Here we print out the client IP to the server
		String clientIpAddress = socketAddress.getAddress().getHostAddress();
		System.out.println(clientIpAddress);
		
		//Getting ready to receive data from the client
		InputStreamReader in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);

		//Getting file name from the client
		String str = bf.readLine();
		
		//Printing the file name the client requested
		System.out.println("client requested: " + str);
		
		//Getting the current directory where the server code is
		String dir = System.getProperty("user.dir");

		//Adding the file name to the server, which client requested
		str = dir + "\\" + str;
		
		//Insert the file in the tmpDir, if file found at the directory
		File tmpDir = new File(str);
		
		
		//To print it to client and also put true in the parameter so that we don't need to use the pr.flush everytime.
		PrintWriter pr = new PrintWriter(s.getOutputStream(), true);
		

		
		DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
				

		//If file exists then it will go through this if conditions
		if(tmpDir.exists())
		{
			//It will send the message "true" to the client
			pr.println("true");
			
			//Increment the M variable, the successful requests so far
			M++;
	
			//Will print the sending the file on the server to state that the file is started to transfer to the client
			System.out.println("Sending the File to the Client");

	  int bytes = 0;
		// Open the File where he located in your pc
		FileInputStream fileInputStream
			= new FileInputStream(tmpDir);

		// Here we send the File to Server
		dataOutputStream.writeLong(tmpDir.length());
		// Here we break file into chunks
		byte[] buffer = new byte[4 * 1024];
		while ((bytes = fileInputStream.read(buffer))
			!= -1) {
		// Send the file to Server Socket
		dataOutputStream.write(buffer, 0, bytes);
			dataOutputStream.flush();
		}
		// close the file here
		fileInputStream.close();
		
		}
		
		//If the file doesn't exists then it will go through the else loop
		else {
			
			//It will send the message "false" to the client
			pr.println("false");
			
			//Will print the "File not found" on the server, if no file found
			System.out.println("File not found.");
		}
		//Here we increase the N variable, Total number of requests so far
		N++;

		//Print out the necessary  statistics
		System.out.println("Number of successful requests is: " + M);
		System.out.println("Total number of requests so far is:" + N);
	
	
	//Here we push all the necessary statistics to the client
	pr.println("Number of successful requests is: " + M);
	pr.println("Total number of requests so far is: " + N);
		}
	}
}
	
	
	
