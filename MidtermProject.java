//Executioner's Labyrinth: A Perilous Escape, Alan Xue, Version 1.0.6
import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
public class MidtermProject{
	static int intLuck = 0;
	static int intHealth =100;
	public static void main(String[] args){
		Console con = new Console("Executioner's Labyrinth: A Perilous Escape",1280,720);
		
		con.setDrawColor(new Color(137, 17, 17 ));
		con.fillRect(0,0,1280,720);
		Font fntTitle = con.loadFont("Minecraft.ttf",50);
		con.setDrawFont(fntTitle);
		con.setDrawColor(Color.BLACK);
		con.drawString("Executioner's Labyrinth: A Perilous Escape",105,100);
		Font fntTitleSmall = con.loadFont("Minecraft.ttf",30);
		con.setDrawFont(fntTitleSmall);
		con.drawString("Press Any Key to Continue",405,550);
		con.repaint();
		char currentChar = con.getChar();
        if (Character.isLowerCase(currentChar)) {
			//if any key is pressed, then the user will go to scene 1
			scene1(con);
		}
		boolean sucess = scene2(con,intHealth,intLuck);
		boolean scene3aResult;
		boolean scene3bResult;
		boolean scene4bResult;
		boolean scene4aResult;
		if(sucess) {
			//depending on the result, scene3a either goes to scene4a or scene4b
			scene3aResult = scene3a(con,intHealth,intLuck);
			if(scene3aResult == true){
				//success, therefore the player goes to scene4a
				scene4aResult = scene4a(con, intHealth,intLuck);
				if(scene4aResult == true){
				//success, therefore the player goes to scene5a
				scene5a(con,intHealth,intLuck);
			}else{
				//unsuccessful, therefore the player goes to scene5b
				scene5b(con,intHealth,intLuck);
			}
			}else{
				scene4bResult = scene4b(con, intHealth,intLuck);
				//unsuccessful, therefore the player goes to scene4b
				if(scene4bResult == true){
				//success, therefore the player goes to scene5a
				scene5a(con,intHealth,intLuck);
			}else{
				//unsuccessful, therefore the player goes to scene5b
				scene5b(con,intHealth,intLuck);
			}
			}
		}else{
			//depending on the result, scene3b either goes to scene4a or scene4b
			scene3bResult= scene3b(con,intHealth,intLuck);
			if(scene3bResult == true){
				//success, therefore the player goes to scene4a
				scene4aResult = scene4a(con, intHealth,intLuck);
				if(scene4aResult == true){
				//success, therefore the player goes to scene5a
				scene5a(con,intHealth,intLuck);
			}else{
				//unsuccessful, therefore the player goes to scene5b
				scene5b(con,intHealth,intLuck);
			}
			}else{
				scene4bResult = scene4b(con, intHealth,intLuck);
				//unsuccessful, therefore the player goes to scene4b
				if(scene4bResult == true){
				//success, therefore the player goes to scene5a
				scene5a(con,intHealth,intLuck);
			}else{
				//unsuccessful, therefore the player goes to scene5b
				scene5b(con,intHealth,intLuck);
			}
			}
		}
		
	}

	public static void scene1(Console con){
		//scene 1 introduction
		int intText = 300;
		int intCount = 1;
		String strBack = "";
		String strLetter = "";
		String strProtagonist;
		double dblDifficulty;
		int intDoors;
		String strAnswer;
		int intVowels;
		char chrChoice;
		char chrInitial;
		
		
		BufferedImage imgScene1 = con.loadImage("scene1.png");
		con.drawImage(imgScene1,-200,-200);
		Font fntArcade = con.loadFont("ARCADE.TTF",25);
		con.setTextColor(Color.BLACK);
		con.setTextFont(fntArcade);
		
		
				
		
		con.repaint();
		con.println("-------------------------------------------------------------------------------------------------------------------------------------");
		con.sleep(300);
		con.println("You were once a loyal knight of the kingdom of St.Augustine, sworn to protect the king and his people.");
		con.sleep(2300);
		con.println("But everything changed when a dark force corrupted the king and became a tyrant.");
		con.sleep(2300);
		con.println("He ordered you to execute innocent villagers who opposed his rule, but you refused.");
		con.sleep(2300);
		con.println("You were arrested and thrown into the dungeon, where you have been tortured and starved for months.");
		con.sleep(2300);
		con.println("You know that your time is running out, as the king has planned a public execution for you and ");
		con.sleep(2300);
		con.println("other rebels. You have to find a way to escape and join the resistance, or die trying.");
		con.sleep(2300);
		con.println("You are not alone in the dungeon. ");
		con.sleep(2300);
		con.println("You have made friends among the other prisoners, who share your ideals and hope.");
		con.sleep(2300);
		con.println("You also have some enemies, who are loyal to the king or who want to betray you for their own gain.");
		con.sleep(2300);
		con.println("You have to be careful who you trust and who you help. You also have to deal with the guards,");
		con.sleep(2300);
		con.println("You have heard rumours of a secret passage that leads out of the dungeon, but you don't");
		con.sleep(2300);
		con.println("know where it is or how to access it. You have to explore the dark and dangerous corridors,");
		con.sleep(2300);
		con.println("looking for clues and items that might help you. You have to avoid traps,");
		con.sleep(2300);
		con.println("fight monsters, and solve puzzles along the way. You also have to make decisions");
		con.sleep(2300);
		con.println("that will affect your story and your relationships with other characters.");
		con.sleep(2300);
		con.println("Will you be brave or cowardly?");
		con.sleep(3300);
		con.println("Will you be loyal or treacherous?");
		con.sleep(3300);
		con.println("Your choices will determine your fate.");
		con.sleep(330);
		con.println("-------------------------------------------------------------------------------------------------------------------------------------");
		con.sleep(2300);
		
		intLuck = (int)(Math.random()*10+1);
		con.println("");
		con.println("Your luck is "+intLuck);
		con.println("Your health is "+intHealth);
		con.println("What is your name");
		strProtagonist = con.readLine();
		int intLength = strProtagonist.length();
		for(int intCount1 = intLength; intCount1 >= 1; intCount1 --){
		strLetter = strProtagonist.substring(intCount1-1 , intCount1);
		strBack = strBack + strLetter;
		}
		if(strProtagonist.equalsIgnoreCase(strBack)){
			//if name is palindrome, luck increases by 1 and a hint pops up
			intLuck += 1;
			con.println("Lucky name, increased luck value: "+intLuck);
			con.println("Hint: press \"a\" in the next scene");
			}else{
			//if name is not a palindrome, luck decreases by 1
			intLuck -= 1;
			con.println("Unlucky name, decreased luck value: "+intLuck);
			}
		con.println("Choose difficulty level (1.0 - easy, 2.0 - medium, 3.0 - hard)");
		while(true){
			//the loop will run until one of the choices is chosen
			dblDifficulty = con.readDouble();
			if(dblDifficulty == 1.0){
				//if the player enters 1.0, the intLuck value remains unchanged and a message is displayed indicating the luck stays the same.
				intLuck = intLuck;
				con.println("your luck stays the same "+intLuck);
				break;
			}else if(dblDifficulty == 2.0){
				//if the player enters 2.0, the intLuck value is decreased by 2 and a message is displayed indicating the luck has decreased by 2.
				intLuck -= 2;
				con.println("your luck decreases by 2, your luck is now: "+intLuck);
				break;
			}else if(dblDifficulty == 3.0){
				//if the player enters 3.0, the intLuck value is decreased by 3 and a message is displayed indicating the luck has decreased by 3.
				intLuck -= 3;
				con.println("your luck decreases by 3, your luck is now: "+intLuck);
				break;
			}else{
				//if the player enters any other value, an error message is displayed indicating invalid input and the player is prompted to try again with the valid options (1.0, 2.0, or 3.0) for the difficulty level.
				con.println("Invalid input, please try again with (1.0 - easy, 2.0 - medium, 3.0 - hard)");
			}
		}
		con.println("Good luck");
		con.sleep(2600);
		
		return;


		
	}
	public static boolean scene2(Console con, int intHealth, int intLuck) {
    //scene2 The cell
    con.clear();
    BufferedImage imgPrison = con.loadImage("prison.jpg");
    con.drawImage(imgPrison, 0, 0);
    con.setTextColor(Color.WHITE);
    
    con.println("You wake up groggily, your head throbbing from the blow that knocked you unconscious.");
    con.sleep(2300);
    con.println("As your eyes adjust to the dim light, you realize that you are in a small cell with a heavy iron door.");
    con.sleep(2300);
    con.println("A guard is now standing inside, keeping watch.");
    con.sleep(2000);
    con.println("Press either 'a'(attack guard) or 'b'(bribe guard) or 'c'(charm guard) on your keyboard");

    int intGuard = 300;
    int intDelta = 10;
    int intDirection = -1;
    int intRightBound = 800;

    BufferedImage imgGuard = con.loadImage("Guard.png");
    BufferedImage imgPrisoner = con.loadImage("Prisoner.png");
    while (true){
		//the code will run until the condition is not true
        if (intGuard== 300) {
			//the guard will move forwards until it hits 800
            intDirection = intDirection * -1;
            intRightBound = 800;
        
                
        } else if (intGuard == intRightBound) {
			//the guard will switch directions until it hits 300
            intDirection = intDirection * -1;

        }
        con.drawImage(imgPrison, 0, 0);
		intGuard = intGuard + intDirection * intDelta;
		con.drawImage(imgPrisoner, 0, 300);
		con.drawImage(imgGuard, intGuard, 300);
		con.repaint();
		con.sleep(33);
        char currentChar = con.currentChar();
        if (Character.isLowerCase(currentChar)) {
			//if a key is pressed
            if (currentChar == 'a') {
				//This checks if the player pressed the 'a' key. If this condition is true, it means the player is trying to attack the guard.
                con.println("You try to attack the guard.");
                
                if(intLuck>= 5){
					//This checks if the player's luck value (intLuck) is greater than or equal to 5. If this condition is true, it means the player's luck is high enough to successfully knock out the guard and take their keys.
					con.sleep(2300);
					con.println("You knock out the guard and take his keys.");
					con.sleep(2300);
					return true;
				}else if(intLuck<5){
					//This checks if the player's luck value (intLuck) is less than 5. If this condition is true, it means the player's luck is not high enough to successfully knock out the guard.
					con.sleep(2300);
					con.println("The guard overpowers you and brings you to the torture chamber");
					intHealth -= 50;
					con.sleep(2300);
					return false;
			}

            } else if (currentChar == 'b') {
				//This checks if the player pressed the 'b' key. If this condition is true, it means the player is trying to bribe the guard.
                con.println("You try to bribe the guard.");
                //This checks if the player's luck value (intLuck) is greater than or equal to 6. If this condition is true, it means the player's luck is high enough to successfully bribe the guard and be set free.
                if(intLuck>= 6){
					con.sleep(2300);
					con.println("The guard takes your money and sets you free");
					con.sleep(2300);
					return true;
				}else if(intLuck<6){
					//This checks if the player's luck value (intLuck) is less than 6. If this condition is true, it means the player's luck is not high enough to successfully bribe the guard.
					con.sleep(2300);
					con.println("The guard does not care about your insignificant bribe and brings you to the torture chamber.");
					intHealth -= 50;
					con.sleep(2300);
					return false;
				}

            } else if (currentChar == 'c') {
				//This checks if the player pressed the 'c' key. If this condition is true, it means the player is trying to charm the guard.
				con.println("You try to charm the guard.");
                if(intLuck>= 7){
					//This checks if the player's luck value (intLuck) is greater than or equal to 6. If this condition is true, it means the player's luck is high enough to successfully charm the guard.
					con.sleep(2300);
					con.println("You charmed the guard and he sets you free");
					con.sleep(2300);
					return true;
				}else if(intLuck<7){
					//This checks if the player's luck value (intLuck) is less than 6. If this condition is true, it means the player's luck is not high enough to successfully charm the guard.
					con.sleep(2300);
					con.println("The guard is unflattered with your charms and decides you bring you to the torture chamber.");
					intHealth -= 50;
					con.sleep(2300);
					return false;
				}
            }
        }

    }
}

public static boolean scene3a(Console con, int intHealth, int intLuck){
	//scene 3a corridor
	con.clear();
	int intPrisoner1 = -100;
	BufferedImage imgCorridor = con.loadImage("corridor.png");
    BufferedImage imgPrisoner1 = con.loadImage("prisoner1.png");
    con.drawImage(imgCorridor, 0, -200);
	con.drawImage(imgPrisoner1, intPrisoner1, 350);
	con.repaint();
	con.sleep(33);
	
	con.println("You are in a corridor running from guards");
	con.println("How many doors do you want to open (1-5)?");
	con.println("Invalid input = DEATH");
	int intDoors = con.readInt();
	con.sleep(2000);
	if((intDoors <=5)&&(intDoors>=1)){
		//if the intDoors is between 1-5, this code will run
		for(int intCount= 0;intCount<intDoors;intCount++){
			//this code will run for however many times intDoor is
			int intItem = (int)(Math.random()*9)+1;
			
			if(intItem == 2){
				//you find food and your health increases by 10
				con.println("You found food");
				intHealth += 10;
				con.println("Your health has been increased by 10, it is now: "+intHealth);
				con.sleep(2000);
			}else if(intItem == 4){
				//you find armour and your health increases by 10
				con.println("You found armour");
				intHealth += 10;
				con.println("Your health has been increased by 10, it is now: "+intHealth);
				con.sleep(2000);
			}else if(intItem == 6){
				//you find a potion and your health increases by 10
				con.println("You found a potion");
				intHealth += 10;
				con.println("Your health has been increased by 10, it is now: "+intHealth);
				con.sleep(2000);
			}else if(intItem == 8){
				//you find water and your health increases by 10
				con.println("You found water");
				intHealth += 10;
				con.println("Your health has been increased by 10, it is now: "+intHealth);
				con.sleep(2000);
			}else if(intItem == 10){
				//you find a bandaid and your health increases by 10
				con.println("You found bandaid");
				intHealth += 10;
				con.println("Your health has been increased by 10, it is now: "+intHealth);
				con.sleep(2000);
			}else if(intItem == 1){
				//you run into a snake and your health decreases by 10
				con.println("You ran into a poisonous snake");
				intHealth -= 10;
				con.println("Your health has been decreased by 10, it is now: "+intHealth);
				con.sleep(2000);
			}else if(intItem == 3){
				//you run into a trap and your health decreases by 10
				con.println("You ran into a trap");
				intHealth -= 10;
				con.println("Your health has been decreased by 10, it is now: "+intHealth);
				con.sleep(2000);
			}else if(intItem == 5){
				//you run into a witch and your health decreases by 10
				con.println("A witch has cursed you");
				intHealth -= 10;
				con.println("Your health has been decreased by 10, it is now: "+intHealth);
				con.sleep(2000);
			}else if(intItem == 7){
				//you trip on a rock and your health decreases by 10
				con.println("You tripped on a rock");
				intHealth -= 10;
				con.println("Your health has been decreased by 10, it is now: "+intHealth);
				con.sleep(2000);
			}else if(intItem == 9){
				//you get bit by a spider and your health decreases by 10
				con.println("You got bit by a spider");
				intHealth -= 10;
				con.println("Your health has been decreased by 10, it is now: "+intHealth);
				con.sleep(2000);
			}
		}
	}else{
		//this means that the player did not choose a number between 1-5 which will send them to scene4b
		return false;
		
	}
	con.sleep(1000);
	con.clear();
	con.sleep(1000);
	con.println("REMINDER your luck is: "+intLuck);
	con.sleep(1000);
	con.println("In order to escape from the guards chasing you, you must solve this problem");
	con.sleep(1000);
	con.println("Your speed + luck must be equal to 5, what is the speed you need");
	double dblAnswer = 5 - intLuck;
	double dblSpeed = con.readDouble();
	if(dblAnswer == dblSpeed){
		//if the answer is correct, the player will be sent to scene4a
		con.println("Congratulations, you have successfully escaped from the guards");
		con.sleep(3000);
		return true;
	}else{
		//if the answer is incorrect, the player will be sent to scene4b
		con.println("You have been caught and now the king is waiting for your execution");
		con.sleep(3000);
		return false;
	}

	
}
	
public static boolean scene3b(Console con,int intHealth, int intLuck){
	// scene 3b torture chamber
	con.clear();
	BufferedImage imgChamber = con.loadImage("chamber.jpeg");
    BufferedImage imgPrisoner3 = con.loadImage("prisoner3.png");
    BufferedImage imgGuard1 = con.loadImage("Guard1.png");
	int intCount1;
	int intCount2;
	for(intCount2 = 0; intCount2 < 3; intCount2++){
		for(intCount1 = 400; intCount1 > 0; intCount1 -= 8){
			con.drawImage(imgChamber, 0, -200);
			con.drawImage(imgPrisoner3, 450, 50);
			con.drawImage(imgGuard1, 0, 300);
			con.setDrawColor(Color.RED);
			con.drawString("ouch",800,intCount1);
			con.repaint();
			con.sleep(33);
		}
	}
	
	con.println("You have been sent to a torture chamber");
	con.sleep(1000);
	con.println("What do you want to say to the interrogator");
	con.sleep(2300);
	
	con.println("Choose your words wisely");
	String strTorture = con.readLine();
	String strLetter;
	int intLength = strTorture.length();
	int intVowel = 0;

		for(int intCount = 0; intCount < intLength; intCount++){
			//checks for vowels and adds 1 to intVowel each time there is a vowel
			strLetter = strTorture.substring(intCount, intCount +1);
			if(strLetter.equals("a")||strLetter.equals("e")||strLetter.equals("i")||strLetter.equals("o")||strLetter.equals("u")||strLetter.equals("y")){
				intVowel = intVowel +1;
			}
		}
		if(intVowel>=5){
			//if intVowel is more than or equal to 5 the player will get sent to scene4a
			con.println("The interrogator believes you and sets you free");
			con.sleep(2300);
			return true;
		}else{
			//if there are less than 5 vowels in the string, the player will get sent to scene4b
			con.println("The interrogator does not believe you and now the king is waiting for your execution");
			con.sleep(2300);
			return false;
		}
	}
public static boolean scene4a(Console con,int intHealth, int intLuck){
	//The courtyard
	con.clear();
	con.setTextColor(Color.BLACK);
	BufferedImage imgCourtyard = con.loadImage("scene4a.jpeg");
    con.drawImage(imgCourtyard, 0, 0);
    con.repaint();
    con.println("You have reached the courtyard,there is a horse and a gate.");
    con.sleep(1000);
    con.println("Click on either the the horse or the gate to escape");
    while(true){
    if((con.currentMouseX()<526)&&(con.currentMouseX()>0)&&(con.currentMouseY()<691)&&(con.currentMouseY()>412)&&(con.currentMouseButton() == 1)){
		//if the luck is greater or equal to 5, the player will escape and go to scene5a
		if(intLuck>=5){
			con.println("You ride the horse and jump over the gate.");
			con.sleep(2300);
			return true;
		}else if(intLuck <5){
			//if the luck is less than 5, the player will get executed and go to scene5b
			con.println("The horse throws you off and you get executed on the spot.");
			con.sleep(2300);
			return false;
		}
			
	}else if((con.currentMouseX()<1063)&&(con.currentMouseX()>600)&&(con.currentMouseY()<530)&&(con.currentMouseX()>300)&&(con.currentMouseButton() == 1)){
		if(intLuck>=6){
			//if the luck is greater or equal to 6, the player will escape and go to scene5a
			con.println("You loosen the lock on the gate and run away.");
			con.sleep(2300);
			return true;
		}else if(intLuck <6){
			//if the luck is less than 6, the player will get executed and go to scene5b
			con.println("The gate is locked and you get executed on the spot.");
			con.sleep(2300);
			return false;
		}
	}
	
	}
}
public static boolean scene4b(Console con,int intHealth, int intLuck){
	//The Execution
	con.clear();
	BufferedImage imgCastle = con.loadImage("castle.jpg");
	BufferedImage imgCrown1 = con.loadImage("crown1.png");
	BufferedImage imgKing = con.loadImage("king.png");
    con.drawImage(imgCastle, -300, -300);
    BufferedImage imgPrisoner4 = con.loadImage("prisoner4.png");
    BufferedImage imgGuard = con.loadImage("Guard.png");
    con.drawImage(imgCrown1, 1220, 270);
    con.drawImage(imgKing, 1200, 300);
    con.repaint();
    con.sleep(33);
    int intGuard = 0;
    
     while (intGuard < 1000){
		//the code will run until the condition is not true
        if (intGuard < 1000) {
            intGuard +=10;
        
                
        } else if (intGuard == 1000) {
			//the guard will stop at 1100
            intGuard += 10;

        }
        con.drawImage(imgCastle, -300, -300);
        con.drawImage(imgGuard, intGuard, 300);
		con.drawImage(imgPrisoner4, intGuard + 50, 300);
		con.drawImage(imgKing, 1200, 300);
		con.drawImage(imgCrown1, 1220, 270);
		con.setDrawColor(Color.YELLOW);
		con.fillOval(1180,-20,125,125);
		con.repaint();
		con.sleep(33);
	}
		con.setTextColor(Color.RED);
		con.println("Enter 'a'(attack king) or 'b'(beg for mercy) or 'c'(curse king) on your keyboard");
		char currentChar = con.readChar();
        if (Character.isLowerCase(currentChar)) {
			//if a key is pressed
            if (currentChar == 'a') {
				//This checks if the player pressed the 'a' key. If this condition is true, it means the player is trying to attack the king.
                con.println("You try to attack the king");
                
                if(intLuck>= 5){
					//This checks if the player's luck value (intLuck) is greater than or equal to 5. If this condition is true, it means the player's luck is high enough to successfully knock out the guard and attack the king.
					con.sleep(2300);
					con.println("You successfully break free and attack both the king and the guard");
					con.sleep(2300);
					return true;
				}else if(intLuck<5){
					//This checks if the player's luck value (intLuck) is less than 5. If this condition is true, it means the player's luck is not high enough to successfully break free.
					con.sleep(2300);
					con.println("You fail to break free and the king executes you on the spot");
					intHealth -= 50;
					con.sleep(2300);
					return false;
			}

            } else if (currentChar == 'b') {
				//This checks if the player pressed the 'b' key. If this condition is true, it means the player is trying to bribe the guard.
                con.println("You try to beg for mercy.");
                //This checks if the player's luck value (intLuck) is greater than or equal to 6. If this condition is true, it means the player's luck is high enough to successfully beg for mercy and be set free.
                if(intLuck>= 6){
					con.sleep(2300);
					con.println("The king pities you and sets you free");
					con.sleep(2300);
					return true;
				}else if(intLuck<6){
					//This checks if the player's luck value (intLuck) is less than 6. If this condition is true, it means the player's luck is not high enough to make the king pity you.
					con.sleep(2300);
					con.println("The king laughs at your beg for mercy and executes you on the spot");
					intHealth -= 50;
					con.sleep(2300);
					return false;
				}

            } else if (currentChar == 'c') {
				//This checks if the player pressed the 'c' key. If this condition is true, it means the player is trying to charm the guard.
				con.println("You try to curse the king");
                if(intLuck>= 7){
					//This checks if the player's luck value (intLuck) is greater than or equal to 7. If this condition is true, it means the player's luck is high enough to successfully curse the king.
					con.sleep(2300);
					con.println("You curse the king and he dies, the guard is overwhelmed with shock and you run away.");
					con.sleep(2300);
					return true;
				}else if(intLuck<7){
					//This checks if the player's luck value (intLuck) is less than 7. If this condition is true, it means the player's luck is not high enough to successfully curse the king.
					con.sleep(2300);
					con.println("The curse does not seem to work, and enraged, the king executes you on the spot");
					intHealth -= 50;
					con.sleep(2300);
					return false;
				}
            }
        }
        return false;
	}

public static void scene5a(Console con,int intHealth, int intLuck){
	//The freedom
	con.clear();
	int intChoice;
	BufferedImage imgForest = con.loadImage("forest.jpeg");
    con.drawImage(imgForest, 0, -280);
	BufferedImage imgPrisoner = con.loadImage("prisoner5.png");
    con.drawImage(imgPrisoner, 0, 500);
    BufferedImage imgTraveller = con.loadImage("traveller.png");
    con.drawImage(imgTraveller, 800, 300);
    con.repaint();
    con.sleep(1000);
    con.setTextColor(Color.RED);
    con.println("You have reached a forest where you meet a friendly traveller");
    con.sleep(1000);
    con.println("Do you want to 1(Go with the traveler), 2(Stay in the forest), or 3(Go back to the dungeon)");
    con.println("Enter either (1),(2),or (3)");
    con.sleep(1000);
    while(true){
			//the loop will run until one of the choices is chosen
			intChoice = con.readInt();
			if(intChoice == 1){
				//if the player enters 1, a message pops up stating that You go with the traveller and start a new life in another kingdom.
				con.println("You go with the traveller and start a new life in another kingdom.");
				con.sleep(1000);
				con.setTextColor(Color.GREEN);
				con.println("CONGRATULATIONS YOU HAVE BEAT THE GAME");
				con.sleep(4000);
				con.closeConsole();
			}else if(intChoice == 2){
				//if the player enters 1, a message pops up stating that You become a hermit and live in the forest for the rest of your life
				con.println("You become a hermit and live in the forest for the rest of your life");
				con.sleep(1000);
				con.setTextColor(Color.GREEN);
				con.println("CONGRATULATIONS YOU HAVE BEAT THE GAME");
				con.sleep(4000);
				con.closeConsole();
			}else if(intChoice == 3){
				//if the player enters 1, a message pops up stating that You go back to the dungeon, free other prisoners, and overthrow the evil king
				con.println("You go back to the dungeon, free other prisoners, and overthrow the evil king");
				con.sleep(1000);
				con.setTextColor(Color.GREEN);
				con.println("CONGRATULATIONS YOU HAVE BEAT THE GAME");
				con.sleep(4000);
				con.closeConsole();
			}else{
				//if the player enters any other value, an error message is displayed indicating invalid input and the player is prompted to try again with the valid options (1.0, 2.0, or 3.0) for the difficulty level.
				con.println("Invalid input, please try again with 1(Go with the traveler), 2(Stay in the forest), or 3(Go back to the dungeon)");
			}
		}
	}
public static void scene5b(Console con,int intHealth, int intLuck){
	//The death
	con.clear();
	con.setDrawColor(Color.BLACK);
	con.fillRect(0,0,1280,720);
	BufferedImage imgPrisoner = con.loadImage("dead.png");
    con.drawImage(imgPrisoner, 400, 300);
	Font fntTitle = con.loadFont("blood.ttf",150);
	con.setDrawFont(fntTitle);
	con.setDrawColor(Color.RED);
	con.drawString("GAME OVER",265,-100);
    con.repaint();
    con.sleep(4000);
	con.closeConsole();
	}
}



