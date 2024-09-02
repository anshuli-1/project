package emailaap;

import java.util.Scanner;



public class email {
	private String firstname;
	private String lastname;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultpasswordlength = 10;
	private String alternateEmail;
	private String companySuffix = "anscomapany.com";
	
	//Constructor to receive the first name and last name
	public email(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		//System.out.println("EMAIL CREATED : " + this.firstname + " "  + this.lastname);
		
		//Call a method asking for a department - return the department
		this.department = setdepartment();
		//System.out.println("Department: " + this.department);
		
		//call a method that returns a random password
		this.password = randomPass(defaultpasswordlength);
		//System.out.println("Your password is : " + this.password);
			
		// Combine elements to generate email
		email = firstname.toLowerCase() + "." +lastname.toLowerCase() + "@" + department + "." + companySuffix;
		//System.out.println("Your Email is: " + email);
		
	} 
	//Ask for the department
		private String setdepartment() {
			System.out.print("New worker: " + firstname + ". Department Codes: \n 1 for sales\n 2 for dept\n 3 for accnt\n 0 for none\n Enter the department Code: ");
			Scanner in = new Scanner(System.in);
			int depChoice = in.nextInt();
			if(depChoice == 1) {return "sales";}
			else if(depChoice == 2) {return "dept"; }
			else if(depChoice == 3) {return "accnt"; }
			else {return "" ; }
		}
	//Generate a random password
			private String randomPass(int length) {
				String passwordSet  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
				char[] password = new char[length];
				for(int i =0; i<length; i++) {
					int random = (int) (Math.random() * passwordSet.length());
					password[i] = passwordSet.charAt(random);
				}
				
				return new String(password);
			}
		
	
	//Set the mailbox capacity
			public void setMailboxCapacity(int capacity) {
				this.mailboxCapacity  = capacity;
				
			}
			
	//Set the alternate email
			public void setAlternateEmail(String altEmail) {
				this.alternateEmail = altEmail;
			}	
	//Change the password
			public void changepassword(	String password) {
				this.password = password;
			}
			public int getMailboxCapacity() {return mailboxCapacity;}
			public String getAlternateEmail() {return alternateEmail;}
			public String getPassword() {return password; }
			
			public String showInfo() {
			return "DISPLAY NAME: " + firstname + " " + lastname + "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb"+ "\npassword: " + password;
			}
			}
