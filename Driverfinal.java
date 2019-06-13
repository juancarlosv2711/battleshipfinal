package battleshipfinal;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
//Juan Carlos Velasquez
//Student number: 2017017
public class Driverfinal {
	
	Playerfinal[] myPlayer; // Object from class Playerfinal.
	Boardfinal myBoard;  // Object from class Boardfinal.
	
	/**
	 * DEFAULT CONSTRUCTOR**********************************************************************************
	*/
	
	public Driverfinal() { // Default constructor
		
		
		
		gameStart(); // Welcome method
		myPlayer = creatingPlayers(); // Defining players
		myBoard = sizeBoard(); // Defining board
		int[][] coordinates = sizeShip(myBoard.rows, myBoard.columns); // Creating size of the ship
		showingCoordinates(coordinates); 
		rounds(coordinates); // Displaying rounds
		dislpayingPoints(); // Displaying points
		
		
		
		
		
		
	}
	
	/**
	 * GAME START****************************************************************************************
	 * used in default constructor
	*/ 
	public void gameStart () { // Creating number of Players
		
		System.out.print("Welcome to Battleship, Please insert the number of Players: ");	
	}
	
	/**
	 * VALIDATING PLAYERS**********************************************************************************
	 * Used in creating players
	*/
	public int validatingPlayers() {
		
		// Variables
		String numberPlayers = "";
		int numberPlayersInteger = 0;
		Boolean flag = false;
	

		do {
			numberPlayers = BufferedReader(); // Getting input from user
			if (numberPlayers.matches("[0-9]+")) { //Input must be just numbers
				numberPlayersInteger = Integer.parseInt(numberPlayers);
				if ((numberPlayersInteger >= 1) && (numberPlayersInteger < 5)) { //Can be played just from 1 to 4 players
					flag = true;
				} else {
					System.out.print("This game can just be played by 1 to 4 players try it again: ");
					flag = false;
				}
			} else {
				System.out.print("Plaese enter just numbers try it again: ");
				flag = false;
			}
		} while (flag == false);

		return numberPlayersInteger; // returning variable with the number of players
	}
	
	/**
	 * CREATING EACH PLAYER**********************************************************************************
	 * Used in creating players
	*/
	public Playerfinal creatingPlayer(int number) { // Getting input number of player
		
		// Variables
		String name;
		int age=0;
		String email;
		boolean flag = false;
		
		System.out.println("\n            Player number " + number + "\n"); // Getting input from each player
		
		// Getting the name
		do {
			// Validation for name
			System.out.print("Please enter your name and last name: ");
			name = BufferedReader();
			if (name.matches("^[A-Za-z\\s]+$")) { // Validating the input is just letters
				if (name.contains(" ")) { // Validating contains last name (Space).
					String[] fullName = name.split(" ");
					name = fullName[0] + " ";
					name += fullName[1];
					flag = true;
				} else {
					System.out.println("Sorry thats not your name and lastname");
					flag = false;
				}
			} else {
				System.out.println("Please make sure your name contains just letters");
				flag = false;
			}

		} while (flag == false);

		// Creating age
		String ageString;
		
		System.out.print("Please enter your age: ");
		do {
				ageString= BufferedReader(); // Getting Input from user
			
			if (ageString.matches("[0-9]+")) { // Validating user input is just numbers
				age = Integer.parseInt(ageString);
				
				if ((age > 12) && (age < 100)) { // Validating age is between 12 and 100.
					flag = true;
				} else {
					System.out.print("Please insert an valid age, you must be between 12 and 100 years, try it again: ");
					flag = false;
				}
			} else {
				System.out.print("please enter just numbers try it again: ");
				flag = false;
			}
			
		} while (flag == false);

		//Creating email
		System.out.print("Please enter your email: ");
		do {
			email = BufferedReader();
			if (email.contains("@") & (email.contains("."))) { //Validating email contains "@" and "."
				flag = true;
			} else {
				System.out.println("Please enter a valid email, try it again");
				flag = false;
			}
		} while (flag == false);
		
		Playerfinal myPlayer = new Playerfinal(name, age, email);// creating object Player with information of the player
		return myPlayer; // returning object player
	}
		
	/**
	 * CREATING MULTIPLE PLAYERS**********************************************************************************
	 * Used in default
	*/ 
	public Playerfinal[] creatingPlayers() {
		
		//Variables
		int numberPlayers=0;
		numberPlayers=validatingPlayers();
		Playerfinal[] myPlayer = new Playerfinal[numberPlayers]; // Creating Object of "Playersfinal" class
		
		for(int i=0; i<numberPlayers; i++) {
			myPlayer[i] = creatingPlayer(i+1); //Declaring array.
		}
		
		return myPlayer; // Returning object
	}
		
	/**
	 * SIZE BOARD**********************************************************************************
	 * Used in default
	*/	
	public Boardfinal sizeBoard() { // Personalizing size of the board
		
		//Object
		Boardfinal myBoard;
		
		//Variables
		int rows = 0;
		int columns = 0;
		String inputUser = "";
		boolean flag = false;

		System.out.println("\nWould you like to personalize the size of the board?"); // asking user for size of the board
		System.out.println("YES ----------------- (Y)");
		System.out.println("NO  ----------------- (N)");

		do { // Validating Input is (Y) or (N)
			inputUser = BufferedReader();
			inputUser = inputUser.toUpperCase();
			if (inputUser.equals("Y") || inputUser.equals("N")) {
				flag = true;
			} else {
				flag = false;
				System.out.println("Please enter just (Y) or (N)");
			}

		} while (flag == false);
		
		if (inputUser.equals("Y")) { // For a personalized board
			
			do { // Validation for board between 10 and 20 rows
				
			System.out.print("Please enter the number of rows: ");
			inputUser=BufferedReader();
			rows = Integer.parseInt(inputUser);
				if ((rows >= 10) && (rows < 21)) { // Rows must be between 10 and 20.
					flag = true;
				} else {
					System.out.println("The number of rows must be just between 10 and 20");
					flag = false;
				}
			} while (flag == false);
			
			do {
			System.out.print("Please enter the number of columns: ");
			inputUser=BufferedReader();
			columns = Integer.parseInt(inputUser);
			if ((columns >= 10) && (columns < 21)) { // Columns must be between 10 and 20.
				flag = true;
			} else {
				System.out.println("The number of columns must be just between 10 and 20");
				flag = false;
			}
			} while (flag == false);
			
			
			
			myBoard = new Boardfinal(rows, columns);
			
			
		}else { // the user wants to use the default size
			myBoard = new Boardfinal();
			
		}
		return myBoard; // returning object
	}
	
	/**
	 * SIZE OF THE SHIP**********************************************************************************
	 * Used in default
	*/	
	public int[][] sizeShip(int rows, int columns) {// Generating size of the Ship
		
		//Variables
		int sizeBoat=0;
		
		if(rows>columns) { // getting the smallest border either row or column, to calculate the size of ship
			sizeBoat = columns / 3;
		} else {
			sizeBoat = rows / 3;
		}
		
		int[][] positionBoard = random(rows, columns, sizeBoat);
		
		for(int i=0; i<positionBoard.length; i++) {
			int row = positionBoard[i][0];
			int column = positionBoard[i][1];
			myBoard.position[row][column]=3;
		}
		
		return positionBoard;
	}
	
	/**
	 * RANDOM POSITIONS**********************************************************************************
	 *  Used in size of the ship
	*/	
	public int[][] random(int row, int column, int sizeShip) {

		
		//Variables
		int min = 0; //minimum size random number
		int[][] random = new int[sizeShip][2]; // position of random numbers
		// importing Random
		Random objectRandom = new Random();
		
		// random for first point
		random[0][0] = min + objectRandom.nextInt(row); //Random row
		random[0][1] = min + objectRandom.nextInt(column);// Random column
	
		if (random[0][0] % 2 == 0) { // If change rows
			int restSizeship = sizeShip - 1;// Already counted one
			int add = random[0][0] + restSizeship;

			if (add < row) { // If ship fits
				for (int i = 1; i < sizeShip; i++) { // going down
					int adding = random[0][0] + i;
					random[i][0] = adding; // adding to rows + 1
					random[i][1] = random[0][1]; // maintain columns
				}
			} else {

				for (int i = 1; i < sizeShip; i++) { // going up
					int substraction = random[0][0] - i;
					random[i][0] = substraction; // subtracting to rows - 1
					random[i][1] = random[0][1]; // maintain columns
				}
			}
		} else { // If change columns
			int restSizeship = sizeShip - 1;// Already counted one
			int add = random[0][1] + restSizeship;

			if (add < column) { // If ship fits
				for (int i = 1; i < sizeShip; i++) {
					int adding = random[0][1] + i;
					random[i][1] = adding; // adding columns + 1
					random[i][0] = random[0][0]; // maintain columns
				}
			} else { // going up
				for (int i = 1; i < sizeShip; i++) {
					int substracting = random[0][1] - i;
					random[i][1] = substracting; // Subtracting columns -1
					random[i][0] = random[0][0]; // maintain columns
				}
			}
		}
		return random; // Returning variable array
	}
	
	/**
	 * ROUNDS**********************************************************************************
	 * Used in default
	*/	
	public void rounds(int[][] coordinatesShip) { 
		
		// Variables
		int[][] played = new int[50][2];
		int rounds = 0;
		int row = 0;
		int column = 0;
		boolean flag = false;
		boolean flag2 = false;
		int position = 0;
		rounds = myPlayer.length; //
		int sizeShip = coordinatesShip.length; // number of squares occupied by ship in the grid
		int counterSizeShip = 0;
		int counter = 0;
		

		System.out.println("Ready, go!"); // Starting turns
		
		do {

			if (counterSizeShip != sizeShip) { // Checking ship has been destroyed!!
				for (int i = 0; i < rounds; i++) { // Displaying each player
					counter = counter + 1;
					do {
						System.out.println("\n          " + myPlayer[i].name + "'s turn \n"); // Displaying player's
																								// turn
						System.out.print("Insert Row: ");
						played[i][0] = inputRounds("row");
						System.out.print("Insert Column: ");
						played[i][1] = inputRounds("column");

						// 2nd variables
						row = played[i][0] - 1;
						column = played[i][1] - 1;
						position = myBoard.position[row][column]; // Saving Boards numbers into fixed Variable

						if ((position) == 1 || (position == 2) || (position == 9)) { // if it is already tried
							System.out.println("this coordinate has been played, try another one");
							flag = false;
						} else {
							flag = true;
						}

					} while (flag == false);

					if (position == 0) {
						System.out.println("sorry you have missed");
						myBoard.position[row][column] = 1;
						myPlayer[i].points[0] = myPlayer[i].points[0] + 1; // points[0] missed
					} else {
						System.out.println("Thats a hit well done"); // Hit the ship

						counterSizeShip = counterSizeShip + 1;

						if (counterSizeShip == sizeShip) {
							myBoard.position[row][column] = 9;
							myPlayer[i].points[1] = myPlayer[i].points[1] + 2;
							break;// break if ship is Destroyed.
						} else {
							myBoard.position[row][column] = 9;
							myPlayer[i].points[1] = myPlayer[i].points[1] + 1;

						}
					}

					myBoard.planeBoard(myBoard.rows, myBoard.columns);
				}
			} else {
				myBoard.planeBoard(myBoard.rows, myBoard.columns);
				System.out.println("Ship has ben destroyed!!!");
				flag2 = true;
			}
		} while (flag2 == false);
	}
	
	/**
	 * ROUNDS**********************************************************************************
	 *  Used in default
	*/
	
	public void dislpayingPoints() {
		
		// Variables
		int length = myPlayer.length;
		int[] scorefinal = new int[length];

		// myPlayer[number player].points[1] == hits
		// myPlayer[number player].points[0] == miss
		// myPlayer[number player].points[2] == final

		if (length == 1) { // If is just one player.
			scorefinal[0] = myPlayer[0].points[1] - (myPlayer[0].points[0] * 2);
			System.out.println("Great " + myPlayer[0].name + " your total score is: " + scorefinal[0]);
			System.out
					.println("you missed " + myPlayer[0].points[0] + " times, and you hitted " + myPlayer[0].points[1]);

		} else { // If its a multi-player
			for (int i = 0; i < length; i++) {

				myPlayer[i].points[2] = myPlayer[i].points[1] - (myPlayer[i].points[0] * 2);
				System.out.println(
						"Player " + myPlayer[i].name + "has a total score of: " + myPlayer[i].points[2] + "points");
			}
			int largeScore = myPlayer[0].points[2]; // declaring variable with a value
			for (int i = 0; i < myPlayer.length; i++) { // Getting the higher Score
				if (myPlayer[i].points[2] > largeScore) {
					largeScore = myPlayer[i].points[2];
				}
			}

			for (int j = 0; j < myPlayer.length; j++) { // Displaying the winner

				if (largeScore == myPlayer[j].points[2]) {

					myPlayer[j].points[2] = 0;

					for (int k = 0; k < myPlayer.length; k++) { // Displaying
						if (largeScore == myPlayer[k].points[2]) {
							System.out.println(
									"there is a draw between: " + myPlayer[j].name + " and " + myPlayer[k].name);
							return;

						}
					}
					System.out.println("The winner is: " + myPlayer[j].name);
				}
			}

		}
	}

	/**
	 * VALIDATION INPUTROUNDS**********************************************************************************
	 * Used in default
	*/
	public int inputRounds(String identify) { 
		                         // identify contains row or columns
		//Variables
		boolean flag = false;
		String userInput = "";
		int userInputInt=0;
		
		do {
			userInput = BufferedReader();

			if (userInput.matches("[0-9]+")) { // Verifying user input is just numbers
				if (identify.matches("row")) {// Verifying for rows
					userInputInt = Integer.parseInt(userInput);
					if ((userInputInt > 0) && (userInputInt <= myBoard.rows)) { // if selected column is within the
						
						// board
						flag = true;
					} else {
						System.out.print("the selected row is out of the grid, try it again:");
						flag = false;
					}
				} else { // Verifying columns
					userInputInt = Integer.parseInt(userInput);
					if ((userInputInt > 0) && (userInputInt <= myBoard.columns)) { // If selected column is within the
																					// board
						flag = true;
					} else {
						System.out.print("the selected column is out of the grid, try it again: ");
						flag = false;
					}
				}
			} else {
				System.out.println("Please insert just numbers");
				flag = false;
			}
		} while (flag == false);
		
		return userInputInt;
		
	}
	/**
	 * SHOWING COORDINATES SHIP**********************************************************************************
	 *  Used by programmer
	*/	
	public void showingCoordinates(int[][] random) {
		
		for(int i=0; i<random.length; i++) {
			int j= i+1;
			int row = random[i][0] + 1;
			int column = random[i][1] + 1;
			System.out.println("Point "+ j + " ["+ row + "," + column + "]" );
			
		}
	}
	
	/**
	 * BUFFERED READER**********************************************************************************
	 *  Used by programmer
	*/	
	public String BufferedReader() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String UserInput = "";
		try {

			UserInput = br.readLine(); // Getting input from user
		} catch (Exception e) {
			System.out.println("error reading user");
		}

		return UserInput;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Driverfinal();
	}

}
