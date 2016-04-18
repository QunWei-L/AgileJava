package com.sends.io;
import java.io.IOException;
import java.util.Scanner;

public class CConsole {

	
	Scanner scanner;
	
	public CConsole() {
		
		scanner=new Scanner(System.in);
	}

	private void run() throws InterruptedException, IOException {
		
		System.out.println("Please input some thing:");
		
		String input=scanner.next();
		
		System.out.println("You input: "+input);
		
		System.out.println("more?");
		
		input = scanner.next();
		
		System.out.println("aaa\b");
		
		Thread.sleep(1);
		
		System.out.println("Start!!");
		
		System.out.println('\f');
		
		while(true){
			
			int i=1;
			//System.out.print("wait");
			
			System.out.print("\r");
			while(i%101!=0){
				System.out.print('\r');
				System.out.print("Downloading ------>"+i+" %");
				Thread.sleep((long) 25);
				i++;
				
			}
			
			Runtime.getRuntime().exec("clear");
			
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		
		new CConsole().run();

	}

}
