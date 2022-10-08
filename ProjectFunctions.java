public class ProjectFunctions{

	public static void main (String [] args){
		Game_Grid x1 = new Game_Grid(); // creates grid objects
		Game_Grid x2 = new Game_Grid();
		Game_Grid x3 = new Game_Grid();
		Game_Grid x4 = new Game_Grid();
		Game_Grid x5 = new Game_Grid();
		Game_Grid x6 = new Game_Grid();
		Game_Grid x7 = new Game_Grid();
		Game_Grid x8 = new Game_Grid();
		Game_Grid x9 = new Game_Grid();
		Game_Grid x [][] =  {{x1,x2,x3},
		                     {x4,x5,x6},
							 {x7,x8,x9}}; // creates 3x3 array of grid objects			

        boolean across = false , diagonal = false, pending = true;
		int btnum = 0 ,cnt = 1; // stores button number from 0 to 80 (inclusive)
		
        int [][] StateGrid = new int [3][3]; // Records The State Of Each Object;
		popStateGrid(x , StateGrid); // records the state of each object into the stategrid array
		
		}
		
		while (pending == true) {
			int holder [][] = new int [3][3];// to temporarily hold the array being looked at
			// insert code for botton number and store as btnum	
		    int arrPop [] = new int [2];
			arrPop = popGrid(btnum);
			int x_cor , y_cor ;
			x_cor = arrPop[0]; //x coordinate of population grid
			y_cor = arrPop[1]; // y coordinate of population grid
			holder = x[x_cor][y_cor].getGrid();
			
			
			while (!(Unused(btnum , holder))){ // While you pick a used button in the allowed grid
				// Print out message about the button someone having already played
				// repeat code for getting button number 
				arrPop = popGrid(btnum);
				x_cor = arrPop[0]; 
				y_cor = arrPop[1];
				holder = x[x_cor][y_cor].getGrid();		 
			}
			
			Populate(holder , btnum , cnt); // populates the holder grid
			x[x_cor][y_cor].setGrid(holder); // changes the object grid
			
			
		}
		
		
			
							 
	}
	
	public static void Populate(int [][] h , int num , int cnt ){ // populates the grid being worked on
		int x = nextGrid(num)[0];
		int y = nextGrid(num)[1];	
		if (cnt % 2 == 1){ // if "X" is playing
			h[x][y] = 1;
		}else{
			h[x][y] = -1;
		}
	}
	
	
	public static void popStateGrid(Game_Grid [][] x , int [][] s){
		for (int i = 0 ; i < 3 ; i++){
			for (int j = 0 ; j < 3 ; j++){
			s[i][j] = x[i][j].getState();
		    }
	}
	
	
	
	
	public static boolean Unused (int num , int [][] h){ // checks if button has been used
		int x = nextGrid(num)[0];
		int y = nextGrid(num)[1];
		if (h[x][y] == 0){
			return true;
		}
		return false;	
	}
	
	
	
	
	
	
	
	
	
	
	
	public static boolean Check_Across(int [][]arr){ // Checks horiztantally and vertically if anyone has won
		for (int i = 0 ; i < 3 ; i++){	
		int cnt = 0, cnt2 = 0;
			for (int j = 0 ; j < 3 ; j++ ){
				if ((arr[i][j] != 0 || arr[j][i] != 0) && (arr[i][j] != 2 || arr[j][i] != 2)){ // Not pending nor stalemate
					if(j < 2 && arr[i][j] == arr[i][j+1]){ // horizantal increment
						cnt =  cnt + 1;	
					}
					if (j < 2 && arr[j][i] == arr[j+1][i]){ // vertical increment
						cnt2 = cnt2 + 1;
					}
				}
				
			}
			if (cnt == 2 || cnt2 == 2){
					return true;
			}
		}
		return false;
    }
	
	public static int [] nextGrid (int btnum){  // States which grid you must play in next
	    int arr [] = new int [2];
		int x = btnum % 3;
		int y = (btnum / 9) % 3;
		return arr[x,y];
	}
	
	public static int [] popGrid (int btnum){ // States which grid you currently want to populate
		 int arr [] = new int [2];
		 int x = (btnum % 9) / 3;
		 int y = btnum / 27;
		 return arr[x,y];
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
	public static boolean Check_Diagonal(int [][] arr){ //Checks diagonally from left to right
		int cnt = 0 , cnt_2 = 0 , j  = 2;
		for (int i = 0 ; i < 2 ; i++){
			if ((arr[i][i] != 0 || arr[j][i] != 0) && (arr[i][i] != 2 || arr[j][i] != 2)  )  
				if (arr[i][i] == arr[i+1][i+1]){
					cnt = cnt + 1;
				}
				if (arr[j][i] == arr[j-1][i+1]){
					cnt_2 = cnt_2 + 1;
				}
			j = j - 1;
		}
		if (cnt == 2 || cnt_2 == 2 ){
			return true;
		}
		return false;
	}
//----------------------------------------------------------------------------------------------------------------------------------------------------------
    public static Stale_Mate(int [][] s){    
        for (int i = 0 ; i < 3 ; i++ ){
		    for (int j = 0 ; j < 3 ; j++ ){
				if (s[i][j] != 0){
					return true;
				{
			{
		{
        return false;			
	}

}