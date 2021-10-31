import java.util.*;
public class Game {

  public static void main(String[] args) {
	  int numKey = 5;
	  int userInput = 0;
	  boolean[] keys = new boolean[numKey];
	  for(int j = 0 ;j<keys.length;j++) {
		  keys[j]=false;
	  }
	  Room[] game =createSimpleGame(numKey);
	  Scanner in = new Scanner(System.in);
	  System.out.println("Welcome to [Generic Game]");
	  System.out.println("To exit game input [99] at any time!");
	  boolean foundTreasure = false;
	  while (userInput != 99&&foundTreasure==false) {
		  printHallway(game,keys);
		  userInput = in.nextInt();
		  if(userInput == 1) {
			  keys[1]=true;
			  keys[2]=true;
			  printRoom(game[0],keys);
			  foundTreasure = game[0].getTreasure();
			  System.out.println();
			  printHallway(game,keys);
			  userInput = in.nextInt();
		  }
		  if(userInput == 2) {
			  while(game[1].getLock()==true&&userInput != 9) {
				  System.out.println("Which key would you like to try? [Input key id or 9 to go back]");
				  userInput = in.nextInt();
			  		if(game[1].unlock(userInput)==true&&keys[1]!=true) {
			  			game[1].setToLocked();
			  			System.out.println("You don't have this key yet");
			  		}
			  		else if(game[1].unlock(userInput)==true&&keys[1]==true) {
						  keys[0] = true;
						  keys[4] = true;
						  printRoom(game[1],keys); 
						  foundTreasure = game[1].getTreasure();
						  System.out.println();
				  }
			  }
		  }
		  if(userInput == 3) {
			  while(game[2].getLock()==true&&userInput != 9) {
				  System.out.println("Which key would you like to try? [Input key id or 9 to go back]");
				  userInput = in.nextInt();
				  		if(game[2].unlock(userInput)==true&&keys[2]!=true) {
				  			game[2].setToLocked();
				  			System.out.println("You don't have this key yet");
				  		}
				  		else if(game[2].unlock(userInput)==true&&keys[2]==true) {
						  keys[3] = true;
						  printRoom(game[2],keys); 
						  foundTreasure = game[2].getTreasure();
						  System.out.println();
				  }
			  }
			  
		  }
		  if(userInput == 4) {
			  while(game[3].getLock()==true&&userInput != 9) {
				  System.out.println("Which key would you like to try? [Input key id or 9 to go back]");
				  userInput = in.nextInt();
			  		if(game[3].unlock(userInput)==true&&keys[3]!=true) {
			  			game[3].setToLocked();
			  			System.out.println("You don't have this key yet");
			  		}
			  		else if(game[3].unlock(userInput)==true&&keys[3]==true) {
						  printRoom(game[3],keys);
						  foundTreasure = game[3].getTreasure();
						  System.out.println();
				  }
			  }
			  
		  }
		  if(userInput == 5) {
			  while(game[4].getLock()==true&&userInput != 9) {
				  System.out.println("Which key would you like to try? [Input key id or 9 to go back]");
				  userInput = in.nextInt();
			  		if(game[4].unlock(userInput)==true&&keys[4]!=true) {
			  			game[4].setToLocked();
			  			System.out.println("You don't have this key yet");
			  		}
			  		else if(game[4].unlock(userInput)==true&&keys[4]==true) {
						  printRoom(game[4],keys); 
						  foundTreasure = game[4].getTreasure();
						  System.out.println();
				  }
			  }
			  
		  }
	  }
	  if(foundTreasure == true) {
		  System.out.print("Congratulations! You beat a very buggy game!");
	  }
  }
  static Room[] createSimpleGame(int numKey){
	  Key fR = new Key(1);
	  Key sR = new Key(2);
	  Key tR = new Key(3);
	  Key frR = new Key(4);
	  Key ffR = new Key(5);

	  Key[] keysInFirst = {sR,tR};
	  Key[] keysInSecond = {fR,ffR};
	  Key[] keysInThird =  {frR};
	  Key[] keysInFourth = {};
	  Key[] keysInFifth = {};
	  Room room1 = new Room(false,false,fR,keysInFirst,"Welcome to First Room","Right Room");
	  Room room2 = new Room(false,true,sR,keysInSecond,"Welcome to Second Room","Left Room");
	  Room room3 = new Room(true,true,tR,keysInThird,"Welcome to Third Room","Winning Room");
	  Room room4 = new Room(false,true,frR,keysInFourth,"Welcome to Fourth Room"," Left Room 2");
	  Room room5 = new Room(false,true,ffR,keysInFifth,"Welcome to Fifth Room","Right Room 2");
	  Room[] gameRooms = {room1,room2,room3,room4,room5};
	  
    return gameRooms;
  }

  static void printHallway(Room[] rooms, boolean[] keysFound){
	  System.out.println("There are "+ rooms.length+" rooms");
	  int n =1;
	  while(n<=rooms.length) {
		  System.out.println("Room "+n+" is "+rooms[n-1].available());
		  n++;
	  }
	  System.out.println("Which room would you like to enter? [Enter room number 1-5]");
  }
  static void printRoom(Room room, boolean[] keysFound){
	  System.out.println("You enter room "+ room.getRoomName());
	  room.printKeys();
	  if(room.getTreasure()==false) {
		  System.out.println("No Treasure here check another room");
	  }
	  else {
		  System.out.println("You found the treasure!");
	  }
  }
}

