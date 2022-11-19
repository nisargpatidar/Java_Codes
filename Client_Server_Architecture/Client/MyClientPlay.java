/*
Student Name: Nisarg Patel
Student ID: 200402077
*/

// A simple program to transfer file from the server to client

//This is my client code

//Included all the necessary packages 
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class MyClientPlay{
	
	//Declaring necessary variables
	private static DataOutputStream dataOutputStream = null;
	private static DataInputStream dataInputStream = null;
	
	
	public static void main(String[] args) throws IOException{
		//I had use ipconfig to get the IP for the server and hardcode the IP here.
		Socket s = new Socket("172.16.1.109", 4999);
		Scanner sc = new Scanner(System.in);
	
	//Asking the user the file name they want
	System.out.println("What's the file name you want?");
	String fileName = sc.nextLine();

	//Pushing the file name to the server
	PrintWriter pr = new PrintWriter(s.getOutputStream());
	pr.println(fileName);
	pr.flush();
	
	//Declaring all necessary variables and assign respective functions
	InputStreamReader in = new InputStreamReader(s.getInputStream());
	BufferedReader bf = new BufferedReader(in);
	dataInputStream = new DataInputStream(
				s.getInputStream());
	
	//See if the file is found in server or not
	String tempFile = bf.readLine();

	//If we found the file then the client will receive the file and store in the current directory.
	if(tempFile.equals("true"))
	{
		//Logic to store the file received from server
		int bytes = 0;
		FileOutputStream fileOutputStream
			= new FileOutputStream(fileName);
		// read file size
		long size = dataInputStream.readLong(); 
		//create the array to get the file chunks
		byte[] buffer = new byte[4 * 1024];
		while (size > 0
			&& (bytes = dataInputStream.read(
					buffer, 0,
					(int)Math.min(buffer.length, size)))
					!= -1) {
			// Here we write the file using write method
			fileOutputStream.write(buffer, 0, bytes);
			size -= bytes; // read upto file size
		}
		// Here we complete receiving file
		System.out.println("File is Received");
		fileOutputStream.close();
	}

	//Here we find out that the file was not been found
	else{
		System.out.println("File not found");
	}
	
	//Getting statistics from the server
	System.out.println(bf.readLine());
	System.out.println(bf.readLine());
	
	
	s.close();
}
}