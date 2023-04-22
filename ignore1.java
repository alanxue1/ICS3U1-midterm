import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
public class ignore1{
	public static void main(String[] args){
		Console con = new Console("Executioner's Labyrinth: A Perilous Escape",1280,720);
		
		int intText = 300;
		int intCount = 1;
		String strBack = "";
		String strLetter = "";
		String strProtagonist;
		int intLuck;
		double dblDifficulty;
		int intHealth = 100;
		int intDoors;
		String strAnswer;
		int intVowels;
		char chrChoice;
		char chrInitial;
		
		Font fntArcade = con.loadFont("ARCADE.TTF",25);
		con.setTextColor(Color.BLACK);
		con.setTextFont(fntArcade);
		BufferedImage imgScene1 = con.loadImage("scene1.png");
		con.drawImage(imgScene1,-200,-200);
		/*
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
		*/
		intLuck = (int)(Math.random()*10+1);
		con.println("");
		con.println("Your luck is "+intLuck);
		con.println("Your health is "+intHealth);
		con.println("What is your name");
		strProtagonist = con.readLine();
		int intLength = strProtagonist.length();
		for(int intCount1 = intLength; intCount1 >= 1; intCount1 --){
		//con.println("TEST: " +intCount);
		strLetter = strProtagonist.substring(intCount1-1 , intCount1);
		//con.println("TEST2: "+strLetter);
		strBack = strBack + strLetter;
		}
		if(strProtagonist.equalsIgnoreCase(strBack)){
			intLuck += 1;
			con.println("Lucky name, increased luck value: "+intLuck);
			con.println("Hint: press \"a\" in the next scene");
			}else{
			intLuck -= 1;
			con.println("Unlucky name, decreased luck value: "+intLuck);
			}
		con.println("Choose difficulty level (1.0 - easy, 2.0 - medium, 3.0 - hard)");
		while(true){
			dblDifficulty = con.readDouble();
			if(dblDifficulty == 1.0){
				intLuck = intLuck;
				con.println("int luck stays the same "+intLuck);
				break;
			}else if(dblDifficulty == 2.0){
				intLuck -= 2;
				con.println("int luck decreases by 2, your luck is now: "+intLuck);
				break;
			}else if(dblDifficulty == 3.0){
				intLuck -= 3;
				con.println("int luck decreases by 3, your luck is now: "+intLuck);
				break;
			}else{
				con.println("Invalid input, please try again with (1.0 - easy, 2.0 - medium, 3.0 - hard)");
			}
		}
		con.println("Good luck");
		con.sleep(2600);
		
		boolean sucess = scene2(con,intLuck, intHealth);
		boolean scene3aResult;
		boolean scene3bResult;
		if(sucess) {
			scene3aResult = scene3a(con,intHealth,intLuck);
			if(scene3aResult == true){
				scene4a(con);
			}else{
				scene4b(con);
			}
		}
		
		else{
			scene3bResult = scene3b(con,intHealth, intLuck);
			if(scene3bResult == true){
				scene4a(con);
			}else{
				scene4b(con);
			}
			
		}
	
		


		
	}
	public static boolean scene2(Console con, int intLuck, int intHealth) {
    con.clear();
    BufferedImage imgPrison = con.loadImage("prison.jpg");
    con.drawImage(imgPrison, 0, 0);
    con.setTextColor(Color.WHITE);
    /*
    con.println("You wake up groggily, your head throbbing from the blow that knocked you unconscious.");
    con.sleep(2300);
    con.println("As your eyes adjust to the dim light, you realize that you are in a small cell with a heavy iron door.");
    con.sleep(2300);
    con.println("A guard is now standing inside, keeping watch.");
    con.sleep(2000);
    */ 
    con.println("Press either 'a'(attack guard) or 'b'(bribe guard) or 'c'(charm guard) on your keyboard");

    int intGuard = 300;
    int intDelta = 10;
    int intDirection = -1;
    int intRightBound = 800;

    BufferedImage imgGuard = con.loadImage("Guard.png");
    BufferedImage imgPrisoner = con.loadImage("Prisoner.png");
    while (true){
		
        if (intGuard== 300) {
            intDirection = intDirection * -1;
            intRightBound = 800;
        
                
        } else if (intGuard == intRightBound) {
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

            if (currentChar == 'a') {
                con.println("You try to attack the guard.");
                
                if(intLuck>= 5){
					con.sleep(2300);
					con.println("You knock out the guard and take his keys.");
					con.sleep(2300);
					return true;
				}else if(intLuck<5){
					con.sleep(2300);
					con.println("The guard overpowers you and brings you to the torture chamber");
					intHealth -= 50;
					con.sleep(2300);
					return false;
			}

            } else if (currentChar == 'b') {
                con.println("You try to bribe the guard.");
                if(intLuck>= 5){
					con.sleep(2300);
					con.println("The guard takes your money and sets you free");
					con.sleep(2300);
					return true;
				}else if(intLuck<5){
					con.sleep(2300);
					con.println("The guard does not care about your insignificant bribe and brings you to the torture chamber.");
					intHealth -= 50;
					con.sleep(2300);
					return false;
				}

            } else if (currentChar == 'c') {
				con.println("You try to charm the guard.");
                if(intLuck>= 5){
					con.sleep(2300);
					con.println("You charmed the guard and he sets you free");
					con.sleep(2300);
					return true;
				}else if(intLuck<5){
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
	con.clear();
	BufferedImage imgPrison = con.loadImage("prison.jpg");
    con.drawImage(imgPrison, 0, 0);
	con.println("The Corridor");
	con.println("How many doors do you want to open?");
	int intDoors = con.readInt();
	con.sleep(1000);
	for(int intCount= 0;intCount<intDoors;intCount++){
		int intItem = (int)(Math.random()*9)+1;
		if(intItem == 2){
			con.println("You found food");
			intHealth += 10;
			con.println("Your health has been increased by 10, it is now: "+intHealth);
			con.sleep(1000);
		}else if(intItem == 4){
			con.println("You found armour");
			intHealth += 10;
			con.println("Your health has been increased by 10, it is now: "+intHealth);
			con.sleep(1000);
		}else if(intItem == 6){
			con.println("You found a potion");
			intHealth += 10;
			con.println("Your health has been increased by 10, it is now: "+intHealth);
			con.sleep(1000);
		}else if(intItem == 8){
			con.println("You found water");
			intHealth += 10;
			con.println("Your health has been increased by 10, it is now: "+intHealth);
			con.sleep(1000);
		}else if(intItem == 10){
			con.println("You found bandaid");
			intHealth += 10;
			con.println("Your health has been increased by 10, it is now: "+intHealth);
			con.sleep(1000);
		}else if(intItem == 1){
			con.println("You ran into a poisonous snake");
			intHealth -= 10;
			con.println("Your health has been decreased by 10, it is now: "+intHealth);
			con.sleep(1000);
		}else if(intItem == 3){
			con.println("You ran into a trap");
			intHealth -= 10;
			con.println("Your health has been decreased by 10, it is now: "+intHealth);
			con.sleep(1000);
		}else if(intItem == 5){
			con.println("A witch has cursed you");
			intHealth -= 10;
			con.println("Your health has been decreased by 10, it is now: "+intHealth);
			con.sleep(1000);
		}else if(intItem == 7){
			con.println("You tripped on a rock");
			intHealth -= 10;
			con.println("Your health has been decreased by 10, it is now: "+intHealth);
			con.sleep(1000);
		}else if(intItem == 9){
			con.println("You got bit by a spider");
			intHealth -= 10;
			con.println("Your health has been decreased by 10, it is now: "+intHealth);
			con.sleep(1000);
		}
	}
	con.clear();
	con.sleep(1000);
	con.println("REMINDER your luck is: "+intLuck);
	con.sleep(1000);
	con.println("In order to escape from the guards chasing you, you must solve this problem");
	con.sleep(1000);
	con.println("Your speed + luck must be equal to 5, what is the minimum speed you need");
	double dblAnswer = 5 - intLuck;
	double dblSpeed = con.readDouble();
	if(dblAnswer == dblSpeed){
		con.println("Congratulations, you have successfully escaped from the guards");
		con.sleep(3000);
		return true;
	}else{
		con.println("You have been caught and now the king is waiting for your execution");
		con.sleep(3000);
		return false;
	}
}
	
public static boolean scene3b(Console con,int intHealth, int intLuck){
	con.clear();
	//BufferedImage imgPrison = con.loadImage("prison.jpg");
    //con.drawImage(imgPrison, 0, 0);
	con.println("The Torture Chamber");
	con.println("What do you want to say to the interrogator");
	String strTorture = con.readLine();
	String strLetter;
	int intLength = strTorture.length();
	int intVowel = 0;

		for(int intCount = 0; intCount < intLength; intCount++){
			strLetter = strTorture.substring(intCount, intCount +1);
			//con.println("TEST: "+strLetter);
			if(strLetter.equals("a")||strLetter.equals("e")||strLetter.equals("i")||strLetter.equals("o")||strLetter.equals("u")||strLetter.equals("y")){
				intVowel = intVowel +1;
			}
		}
		if(intVowel>=5){
			con.println("The interrogator believes you and sets you free");
			con.sleep(1000);
			return true;
		}else{
			con.println("The interrogator does not believe you and now the king is waiting for your execution");
			con.sleep(1000);
			return false;
		}
	}
public static void scene4a(Console con){
	con.clear();
	BufferedImage imgPrison = con.loadImage("prison.jpg");
    con.drawImage(imgPrison, 0, 0);
	con.println("The Courtyard");
	}
public static void scene4b(Console con){
	con.clear();
	BufferedImage imgPrison = con.loadImage("prison.jpg");
    con.drawImage(imgPrison, 0, 0);
	con.println("The Execution");
	}
public static void scene5a(Console con){
	con.clear();
	BufferedImage imgPrison = con.loadImage("prison.jpg");
    con.drawImage(imgPrison, 0, 0);
	con.println("The Freedom");
	}
public static void scene5b(Console con){
	con.clear();
	BufferedImage imgPrison = con.loadImage("prison.jpg");
    con.drawImage(imgPrison, 0, 0);
	con.println("The Death");
	}
}


