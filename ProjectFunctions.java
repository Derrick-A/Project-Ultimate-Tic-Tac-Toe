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
		int counter  = 0; // counter that checks if 1 (X) or -1 (O) needs to be entered
		int popX  , popY ; // population co ordinates
		int nextX , nextY ; // next grid coordinates
        int [][] StateGrid = new int [3][3]; // Records The State Of Each Object;
		for (int i = 0 ; i < 3 ; i++){
			for (int j = 0 ; j < 3 ; j++){
			StateGrid[i][j] = x[i][j].getState();
		    }
		}
		
		
		while (pending == true) {
			// insert code to retreive button number as btnum	
            counter = counter + 1;	
            int play = player(counter);	// gives 1 or -1 X or O
			
                        			
		}
		
		
			
							 
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
		arr[0] = x;
		arr[1] = y;
		return arr;
	}
	
	
	
	
	
	
	
	
	
	
	
	public static int [] popGrid (int btnum){ // States which grid you currently want to populate
		 int arr [] = new int [2];
		 int x = (btnum % 9) / 3;
		 int y = btnum / 27;
		 arr[0] = x;
		 arr[1] = y;
		 return arr;
	}
	
	public static int player (int num){// returns the player number
		if (num % 2 == 0){
			return -1;
		}
		return 1;
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