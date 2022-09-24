import java.util.Arrays;
public class MyTester{
	public static void main (String [] args){
		int [][] case1 = {{1,1,1},{-1,-1,0},{0,0,0}};
		int [][] case2 = {{-1,-1,0},{1,1,1},{0,0,0}};
		int [][] case3 = {{0,0,0},{-1,-1,0},{1,1,1}};
//---------------------Across-----------------------------------
        int [][] case4 = {{1,-1,0},{1,0,-1},{1,0,0}};
		int [][] case5 = {{0,1,-1},{0,1,-1},{0,1,0}};
		int [][] case6 = {{0,-1,1},{-1,0,1},{0,0,1}};
//--------------------Downwards---------------------------------
        int [][] case7 = {{1,0,0},{0,1,-1},{-1,0,1}};
		int [][] case8 = {{0,-1,1},{-1,1,0},{1,0,0}};
//--------------------Diagonal----------------------------------
        int [][] case9 = {{1,-1,1},{1,-1,1},{-1,1,-1}};
		
		System.out.println("Case 9 Stale Mate : "+Stale_Mate(case9)); // Should print true for stalemate
		System.out.println("Case 1 Stale Mate : "+Stale_Mate(case1));// Should print false for stalemate
		System.out.println("Case 6 Stale Mate : "+Stale_Mate(case6));// Should print false for stalemate
		System.out.println(""); 
		System.out.println(""); 
		System.out.println("Case 7 Diagonal : "+Check_Diagonal(case7)); // Should print true for diagonal
		System.out.println("Case 8 Diagonal : "+Check_Diagonal(case8)); // Should print true for diagonal 
		System.out.println("Case 9 Diagonal : "+Check_Diagonal(case9)); // Should print false for diagonal
		System.out.println("Case 1 Diagonal : "+Check_Diagonal(case1)); // Should print false for diagonal
		System.out.println("Case 4 Diagonal : "+Check_Diagonal(case4)); // Should print false for diagonal
		System.out.println(""); 
		System.out.println(""); 
		System.out.println("Case 1 Across: "+Check_Across(case1));// Should print true for across
		System.out.println("Case 2 Across: "+Check_Across(case2));// Should print true for across
		System.out.println("Case 3 Across: "+Check_Across(case3));// Should print true for across
		System.out.println("Case 4 Downward: "+Check_Across(case4));// Should print true for across
		System.out.println("Case 5 Downward: "+Check_Across(case5));// Should print true for across
		System.out.println("Case 6 Downward: "+Check_Across(case6));// Should print true for across
		System.out.println("Case 7 Across: "+Check_Across(case7));// Should print false for across
		System.out.println("Case 8 Across: "+Check_Across(case8));// Should print false for across
		System.out.println("Case 9 Across: "+Check_Across(case9));// Should print false for across
		System.out.println(""); 
		System.out.println("");
		
		for (int i = 0 ; i < 54 ; i++ ){
			System.out.println(i + " -> next grid is "+Arrays.toString(nextGrid(i)));
			System.out.println(i + " -> Populaton grid is "+Arrays.toString(popGrid(i)));
			System.out.println("");
		}
	}
	
	
	
	
	
	
   public static String symbol (int num ){
	   if (num ==  1){
		   return "X";
	   }
	   return "O";
   }
   
    public static boolean Stale_Mate(int [][] arr){    
        for (int i = 0 ; i < 3 ; i++ ){
		    for (int j = 0 ; j < 3 ; j++ ){
				if (arr[i][j] == 0){
					return false;
				}
			}
		}
        return true;			
	}
	
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
}