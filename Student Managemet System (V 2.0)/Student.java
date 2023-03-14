import java.util.*;
class Student {

	public static boolean check(String id){
		boolean b=false;
		char ch=id.charAt(0);
		if('S'==ch ){
			String snum=id.substring(1);
			b=true;
			char[] chs=snum.toCharArray();
			for (int i = 0; i <chs.length; i++)
			{
				if(!Character.isDigit(chs[i])){
					b=false;
					break;
				}
			}

		}

		return 	b;
	}
	public static void printMain(){
		System.out.println("+-----------------------------------------------------------------------------------------+");
		System.out.println("|                                                                                         |");
		System.out.println("|                       WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                           | ");
		System.out.println("|                                                                                         |");
		System.out.println("+-----------------------------------------------------------------------------------------+ \n\n\n");



		System.out.println("    [1] ADD NEW STUDENT \t\t\t[2]  ADD NEW STUDENT WITH MARKS");
		System.out.println("    [3] ADD MARKS       \t\t\t[4]  UPDATE STUDENT DETAILS    ");
		System.out.println("    [5] UPDATE MARKS    \t\t\t[6]  DELETE STUDENT            ");
		System.out.println("    [7] PRINT STUDENT DETAILS \t\t\t[8]  PRINT STUDENT RANKS ");
		System.out.println("    [9] BEST IN PROGRAMMING FUNDEMENTALS \t[10] BEST IN DATABASE MANAGEMENT SYSTEM\n\n");
	}
	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (final Exception e) {
			e.printStackTrace();
			// Handle any exceptions.
		}
	}
	public static void main(String args[]) {
		Scanner input=new Scanner(System.in);
		StudentList d1=new StudentList();
        printMain();
		L2: while (true) {
			System.out.print("\n Enter an option to continue > ");
			int op = input.nextInt();


			if (op >= 0 && op <= 10) {
				clearConsole();

				if (op == 1) {
					input.nextLine();
					L1:		while(true){
						System.out.println(" -------------------------------------------------------------------------------");
						System.out.println("|                              ADD NEW STUDENT                                  |");
						System.out.println(" -------------------------------------------------------------------------------\n");



						L9:  while(true){
							int count=0;
							do{
								count=0;
								System.out.print("Enter Student ID    : ");
								String id=input.nextLine();
								int size=id.length();
								//------------------------------------------------
								if(size!=4){
									System.out.println("Invalid Student ID. \n");
									continue L9;
								}

								if(check(id)){}else{
									System.out.println("Invalid Student ID. \n");
									continue L9;
								}
								//---------------------------------------------------

								if(d1.sIdcheck(id)){

									System.out.print("Enter Student NAME  : ");
									String name=input.nextLine();
									d1.addNewStudent(id,name);


									System.out.print("\nStudent has been added successfully. ");
								}else{
									System.out.println("The Student ID already exists\n");
									count=1;
								}
							}while(count==1);

							L14:	while(true){
								System.out.print("Do you want to add a new student (Y/N) : ");
								char x =input.next().charAt(0);
								if(x=='Y' || x=='y'){
									input.nextLine();
									clearConsole();
									continue L1;
								}else if(x=='N' || x=='n'){
									clearConsole();
									printMain();
									input.nextLine();
									continue L2;
								}else{
									System.out.print("Invalid option. ");
									continue L14;
								}
							}//L14
						}//L9
					}//L1

			}//if(op==1)
//-------------------2---------------------------------

				if(op==2){
					L6:     while(true){
						System.out.println(" -------------------------------------------------------------------------------");
						System.out.println("|                         ADD NEW STUDENT WITH MARKS                            |");
						System.out.println(" -------------------------------------------------------------------------------\n");
						input.nextLine();
						int count=0;

						L9:        while(true){

							do{

								count=0;
								System.out.print("Enter Student ID    : ");
								String id=input.nextLine();

								int size=id.length();
								//------------------------------------------------
								if(size!=4){
									System.out.println("Invalid Student ID. \n");
									continue L9;
								}

								if(check(id)){}else{
									System.out.println("Invalid Student ID. \n");
									continue L9;
								}
								//---------------------------------------------------


								if(d1.sIdcheck(id)){

									System.out.print("Enter Student NAME  : ");
									String name=input.nextLine();
									d1.addNewStudent(id,name);

									System.out.println();
									int[] mark=new int[2];

									L3:		for (int i = 0; ; i++)
									{
										System.out.print("Programming Fundamentals Marks      : ");
										int pm=input.nextInt();
										if(pm>=0 && pm<=100){
											mark[0]=pm;
											break;
										}else{
											System.out.println("Invalid marks, please enter correct marks.\n");
											continue L3;
										}
									}

									L4:		for (int i = 0; ; i++)
									{
										System.out.print("Database Management System Marks    : ");
										int dm=input.nextInt();
										if(dm>=0 && dm<=100){
											mark[1]=dm;
											d1.addMarksprf_dbm(mark);
											break;
										}else{
											System.out.println("Invalid marks, please enter correct marks.\n");
											continue L4;
										}
									}
									mark[0]=-1;
									mark[1]=-1;

									System.out.print("\nStudent has been added successfully. ");

									L15:   	while(true){
										System.out.print("Do you want to add a new student (Y/n) : ");
										char A =input.next().charAt(0);
										if(A=='Y' || A=='y'){
											clearConsole();
											continue L6;

										}else if(A=='N' || A=='n'){
											clearConsole();
											printMain();
											input.nextLine();
											continue L2;
										}else{
											System.out.print("Invalid option. ");
											continue L15;
										}
									}//15
								}else{
									System.out.println("The Student ID already exists\n");
									count=1;
								}
							}while(count==1);

						}//L9
					}//L6
				}//if(op==2)

//-----------------------3-----------------------
				if(op==3){

					L12:		 while(true){
						System.out.println(" -------------------------------------------------------------------------------");
						System.out.println("|                                 ADD MARKS                                     |");
						System.out.println(" -------------------------------------------------------------------------------\n");

						L8:      while(true){
							System.out.print("Enter Student ID : ");
							input.nextLine();
							String id=input.nextLine();

							if( d1.search(id)){
								System.out.println("Student Name   : "+d1.getName(id));

								if(d1.checkMarks(id)){

									System.out.println();
									L3:		for (int i = 0; ; i++)
									{
										System.out.print("Programming Fundamentals Marks     : ");
										int pm=input.nextInt();
										if(pm>=0 && pm<=100){
											d1.onlyMarksprf(id,pm);
											break;
										}else{
											System.out.println("Invalid marks, please enter correct marks.\n");
											continue L3;
										}
									}

									L4:		for (int i = 0; ; i++)
									{
										System.out.print("Database Management System Marks    : ");
										int dm=input.nextInt();
										if(dm>=0 && dm<=100){
											d1.onlyMarksdbm(id,dm);
											break;
										}else{
											System.out.println("Invalid marks, please enter correct marks.\n");
											continue L4;
										}
									}
									System.out.print("Marks have been added. ");

									L1:	  while(true){
										System.out.print("Do you want to add marks for another student? (Y/n)  ");
										char a=input.next().charAt(0);
										if(a=='Y' || a=='y'){
											clearConsole();
											continue L12;

										}else if(a=='N' || a=='n'){
											clearConsole();
											printMain();
											input.nextLine();
											continue L2;
										}else{
											System.out.print("Invalid option. ");
											continue L1;
										}
									}//L1

								}else{
									System.out.println("This student's marks have been already added.");
									System.out.println("If you want to update the marks,please use [5] Update Marks option.\n");
									L11:	  while(true){
										System.out.print("Do you want to add marks for another student? (Y/n)  ");
										char a=input.next().charAt(0);
										if(a=='Y' || a=='y'){
											clearConsole();
											continue L12;

										}else if(a=='N' || a=='n'){
											clearConsole();
											printMain();
											input.nextLine();
											continue L2;
										}else{
											System.out.print("Invalid option. ");
											continue L11;
										}
									}//L11

								}

							}else{
								System.out.print("Invalid Student ID. ");


								L7:	  while(true){
									System.out.print("Do you want to search again? (Y/n)  ");
									char a=input.next().charAt(0);
									if(a=='Y' || a=='y'){
										System.out.println();
										continue L8;

									}else if(a=='N' || a=='n'){
										clearConsole();
										printMain();
										input.nextLine();
										continue L2;
									}else{
										System.out.print("Invalid option. ");
										continue L7;
									}
								}//L7

							}

						}//L8
					}//L12
				}//(op==3)

				//-----------------------4-------------------------------
				if(op==4){

					L4:		   while(true){
						System.out.println(" -------------------------------------------------------------------------------");
						System.out.println("|                             UPDATE STUDENT DETAILS                            |");
						System.out.println(" -------------------------------------------------------------------------------\n");
						L8:		   while(true){
							System.out.print("Enter Student ID : ");
							input.nextLine();
							String id=input.nextLine();
							if(d1.search(id)){
								System.out.println("Student Name   : "+d1.getName(id));
								System.out.println();

								System.out.print("Enter the new student name : ");
								String up=input.nextLine();
								d1.updateName(id,up);
								System.out.println();
								System.out.println("Student details has been update successfully.");

								L5:			while(true){
									System.out.print("Do you want to update another student details? (Y/n)  ");
									char ch=input.next().charAt(0);
									if(ch=='Y' || ch=='y'){
										clearConsole();
										continue L4;
									}else if(ch=='N' || ch=='n'){
										clearConsole();
										printMain();
										input.nextLine();
										continue L2;
									}else{
										System.out.print("Invalid option. ");
										continue L5;
									}
								}//L5

							}else{
								System.out.print("Invalid Student ID. ");
								L3:	  while(true){
									System.out.print("Do you want to search again? (Y/n)  ");
									char C=input.next().charAt(0);
									if(C=='Y' || C=='y'){
										System.out.println();
										continue L8;

									}else if(C=='N' || C=='n'){
										clearConsole();
										printMain();
										input.nextLine();
										continue L2;
									}else{
										System.out.print("Invalid option. ");
										continue L3;
									}
								}//L3
							}
						}//L8
					}//L4
				}//(op==4)

//-------------------------------5------------------------------------
				if(op==5){

					L4:			 while(true){
						System.out.println(" -------------------------------------------------------------------------------");
						System.out.println("|                                  UPDATE MARKS                                 |");
						System.out.println(" -------------------------------------------------------------------------------\n");

						L8:		     while(true){
							System.out.print("Enter Student ID : ");
							input.nextLine();
							String id=input.nextLine();
							if(d1.search(id)){
								System.out.println("Student Name   : "+d1.getName(id));
								System.out.println();
								if(d1.checkMarks(id)){
									System.out.println("This student's marks yet to be added.");

									L5:			while(true){
										System.out.print("Do you want to update marks for another student? (Y/n)  ");
										char ch=input.next().charAt(0);
										if(ch=='Y' || ch=='y'){
											clearConsole();
											continue L4;
										}else if(ch=='N' || ch=='n'){
											clearConsole();
											printMain();
											input.nextLine();
											continue L2;
										}else{
											System.out.print("Invalid option. ");
											continue L5;
										}
									}//L5

								}else{
									System.out.println("Programming Fundamentals Marks      : "+d1.getprfMarks(id));
									System.out.println("Database Management System Marks    : "+d1.getdbmMarks(id));
									System.out.println();
									L3:		for (int i = 0; ; i++)
									{
										System.out.print("Enter new Programming Fundamentals Marks     : ");
										int pm=input.nextInt();
										if(pm>=0 && pm<=100){
											d1.onlyMarksprf(id,pm);
											break;
										}else{
											System.out.println("Invalid marks, please enter correct marks.\n");
											continue L3;
										}
									}

									L7:		for (int i = 0; ; i++)
									{
										System.out.print("Enter new Database Management System Marks    : ");
										int dm=input.nextInt();
										if(dm>=0 && dm<=100){
											d1.onlyMarksdbm(id,dm);
											break;
										}else{
											System.out.println("Invalid marks, please enter correct marks.\n");
											continue L7;
										}
									}
									System.out.print("Marks have been update successfully.\n");


									L6:			while(true){
										System.out.print("Do you want to update marks for another student? (Y/n)  ");
										char ch=input.next().charAt(0);
										if(ch=='Y' || ch=='y'){
											clearConsole();
											continue L4;
										}else if(ch=='N' || ch=='n'){
											clearConsole();
											printMain();
											input.nextLine();
											continue L2;
										}else{
											System.out.print("Invalid option. ");
											continue L6;
										}
									}//L6
								}
							}else{
								System.out.print("Invalid Student ID. ");
								L3:	  while(true){
									System.out.print("Do you want to search again? (Y/n)  ");
									char C=input.next().charAt(0);
									if(C=='Y' || C=='y'){
										System.out.println();
										continue L8;

									}else if(C=='N' || C=='n'){
										clearConsole();
										printMain();
										input.nextLine();
										continue L2;
									}else{
										System.out.print("Invalid option. ");
										continue L3;
									}
								}//L3
							}
						}//L8
					}//L4
				}//(op==5)

//------------------------------------6---------------------------------------
				if(op==6){

					L4:			while(true){
						System.out.println(" -------------------------------------------------------------------------------");
						System.out.println("|                                DELETE STUDENT                                 |");
						System.out.println(" -------------------------------------------------------------------------------\n");

						L8:		while(true){
							System.out.print("Enter Student ID : ");
							input.nextLine();
							String id=input.nextLine();
							if(d1.search(id)){
								d1.deleteS(id);

								System.out.println("Student has been deleted successfully.");


								L6:			while(true){
									System.out.print("Do you want to delete another student? (Y/n) ");
									char ch=input.next().charAt(0);
									if(ch=='Y' || ch=='y'){
										clearConsole();
										continue L4;
									}else if(ch=='N' || ch=='n'){
										clearConsole();
										printMain();
										input.nextLine();
										continue L2;
									}else{
										System.out.print("Invalid option. ");
										continue L6;
									}
								}//L6

							}else{
								System.out.print("Invalid Student ID.");
								L3:	      while(true){
									System.out.print("Do you want to search again? (Y/n)  ");
									char C=input.next().charAt(0);
									if(C=='Y' || C=='y'){
										System.out.println();
										continue L8;

									}else if(C=='N' || C=='n'){
										clearConsole();
										printMain();
										input.nextLine();
										continue L2;
									}else{
										System.out.print("Invalid option. ");
										continue L3;
									}
								}//L3

							}
						}//L8
					}//L4

				}//(op==6)

//----------------------------7-----------------------------------------
				if(op==7){

					L4:			while(true){
						System.out.println(" -------------------------------------------------------------------------------");
						System.out.println("|                             PRINT STUDENT DETAILS                             |");
						System.out.println(" -------------------------------------------------------------------------------\n");

						L8:		    while(true){
							System.out.print("Enter Student ID : ");
							input.nextLine();
							String id=input.nextLine();
							if(d1.search(id)){
								System.out.println("Student Name   : "+d1.getName(id));

								if(d1.checkMarks(id)){
									System.out.println();
									System.out.println("This student's marks yet to be added.");

									L5:			while(true){
										System.out.print("Do you want to search another student details? (Y/n)  ");
										char ch=input.next().charAt(0);
										if(ch=='Y' || ch=='y'){
											clearConsole();
											continue L4;
										}else if(ch=='N' || ch=='n'){
											clearConsole();
											printMain();
											input.nextLine();
											continue L2;
										}else{
											System.out.print("Invalid option. ");
											continue L5;
										}
									}//L5
								}else{
									d1.printStudentD(id);

									System.out.println();
									L6:			while(true){
										System.out.print("Do you want to search another student details? (Y/n) ");
										char ch=input.next().charAt(0);
										if(ch=='Y' || ch=='y'){
											clearConsole();
											continue L4;
										}else if(ch=='N' || ch=='n'){
											clearConsole();
											printMain();
											input.nextLine();
											continue L2;
										}else{
											System.out.print("Invalid option. ");
											continue L6;
										}
									}//L6

								}

							}else{
								System.out.print("Invalid Student ID.");
								L3:	      while(true){
									System.out.print("Do you want to search again? (Y/n)  ");
									char C=input.next().charAt(0);
									if(C=='Y' || C=='y'){
										System.out.println();
										continue L8;

									}else if(C=='N' || C=='n'){
										clearConsole();
										printMain();
										input.nextLine();
										continue L2;
									}else{
										System.out.print("Invalid option. ");
										continue L3;
									}
								}//L3
							}
						}//L8
					}//L4
				}//(op==7)

//--------------------------------8------------------------------------------
				if(op==8){

					System.out.println(" -------------------------------------------------------------------------------");
					System.out.println("|                             PRINT STUDENT'S RANKS                             |");
					System.out.println(" -------------------------------------------------------------------------------\n");

					d1.printrank();


					L3:	      while(true){
						System.out.print("Do you want to go back to main menu? (Y/n)  ");
						char C=input.next().charAt(0);
						if(C=='Y' || C=='y'){
							clearConsole();
							printMain();
							input.nextLine();
							continue L2;

						}else if(C=='N' || C=='n'){
							char f=2 ;
							char z=3;
							System.out.println("Thank You "+f+z);
							break L2;
						}else{
							System.out.print("Invalid option. ");
							continue L3;
						}
					}//L3

				}//(op==8)

//---------------------------------9-----------------------------------------------
				if(op==9){

					System.out.println(" -------------------------------------------------------------------------------");
					System.out.println("|                     BEST IN PROGRAMMING FUNDAMENTALS                          |");
					System.out.println(" -------------------------------------------------------------------------------\n");

					d1.printBestprf();
					System.out.println();

					L3:	      while(true){
						System.out.print("Do you want to go back to main menu? (Y/n)  ");
						char C=input.next().charAt(0);
						if(C=='Y' || C=='y'){
							clearConsole();
							printMain();
							input.nextLine();
							continue L2;

						}else if(C=='N' || C=='n'){
							char f=2 ;
							char z=3;
							System.out.println("\n                                      Thank You "+f+z);
							break L2;
						}else{
							System.out.print("Invalid option. ");
							continue L3;
						}
					}//L3

				}//(op==9)

//-----------------------------10---------------------------------------------
				if(op==10){

					System.out.println(" -------------------------------------------------------------------------------");
					System.out.println("|                     BEST IN DATABASE MANAGEMENT SYSTEM                        |");
					System.out.println(" -------------------------------------------------------------------------------\n");

					d1.printBestdbm();
					System.out.println();

					L3:	      while(true){
						System.out.print("Do you want to go back to main menu? (Y/n)  ");
						char C=input.next().charAt(0);
						if(C=='Y' || C=='y'){
							clearConsole();
							printMain();
							input.nextLine();
							continue L2;

						}else if(C=='N' || C=='n'){
							char f=2 ;
							char z=3;
							System.out.println("\n                                      Thank You "+f+z);
							break L2;
						}else{
							System.out.print("Invalid option. ");
							continue L3;
						}
					}//L3


				}//(op==10)

			} else {
				char h = 1;
				System.out.print(" Wrong option " + h);
				continue L2;
			}

		}//L2
	}
}