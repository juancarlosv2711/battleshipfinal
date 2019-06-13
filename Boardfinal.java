package battleshipfinal;
//Juan Carlos Velasquez
//Student number: 2017017
public class Boardfinal {
	int rows;
	int columns;
	int [][] position = new int [20][20];
	
			
	public Boardfinal() {// default constructor size 10X10
		rows = 10;
		columns = 10;
		System.out.println("Hi");
		planeBoard(rows, columns);
	}

	public Boardfinal(int row, int column) { //Default constructor designed

		this.rows = row;
		this.columns = column;
		
		planeBoard(rows, columns);
	}


	public void planeBoard(int row, int column) {

		String board=""; //Variables
		
		board=topBoard(column) + "\n"; // Top board
		for (int i = 0; i < row; i++) { // rows
			board += horizontal(i);
			for (int j = 0; j < column; j++) {// columns
				board += turn(position[i][j]);
				
			}
			board += "\n";
		}
		System.out.println(board);
	}

	public String topBoard(int column) {// Printing off numbers of the top
	
		String number = "   1";
		for (int i = 2; i <= column; i++) {

			if (i < 10) {
				number = number + " " + Integer.toString(i);
			} else if (i >= 10) {
				number = number + Integer.toString(i);
			}
		}
		return number;

	}

	public String horizontal(int i) {
		i = i+1;
		String horizontal = "";
		if (i < 10) {
			horizontal = i + " |";
		} else if (i >= 10) {
			horizontal = i + "|";
		}
		return horizontal;
	}
	
	public String turn(int i) { // Hitting and Missing program
		
		String aim1;
		//i = 0; (Has not been played)
		//i = 1; (Missed ship)
		//i = 3; (Hidden ship)
		//i = 9; (Hit Ship)
		
		if((i==0) || (i==3)) {
			aim1="_|";
		} else if(i==1){
			aim1="M|";
				
			} else {
				aim1="H|";
			}
		return aim1;
		}
	


			
}

