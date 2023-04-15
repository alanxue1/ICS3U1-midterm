import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
public class MidtermProject{
	public static void main(String[] args){
		Console con = new Console("Executioner's Labyrinth: A Perilous Escape",1280,720);
		
		int intText = 300;
		int intCount = 1;
		String strBack = "";
		String strLetter = "";
		String strProtagonist;
		int intLuck;
		double dblDifficulty;
		
		BufferedImage imgScene1 = con.loadImage("scene1.jpg");
		con.drawImage(imgScene1,-200,-400);
		
		/*con.repaint();
		con.println("You were once a loyal knight of the kingdom of St.Augustine, sworn to protect the king and his people.");
		con.sleep(1300);
		con.println("But everything changed when a dark force corrupted the king and became a tyrant.");
		con.sleep(1300);
		con.println("He ordered you to execute innocent villagers who opposed his rule, but you refused.");
		con.sleep(1300);
		con.println("You were arrested and thrown into the dungeon, where you have been tortured and starved for months.");
		con.sleep(1300);
		con.println("You know that your time is running out, as the king has planned a public execution for you and ");
		con.sleep(1300);
		con.println("other rebels. You have to find a way to escape and join the resistance, or die trying.");
		con.sleep(1300);
		con.println("You are not alone in the dungeon. ");
		con.sleep(1300);
		con.println("You have made friends among the other prisoners, who share your ideals and hope.");
		con.sleep(1300);
		con.println("You also have some enemies, who are loyal to the king or who want to betray you for their own gain.");
		con.sleep(1300);
		con.println("You have to be careful who you trust and who you help. You also have to deal with the guards,");
		con.sleep(1300);
		con.println("You have heard rumours of a secret passage that leads out of the dungeon, but you don't");
		con.sleep(1300);
		con.println("know where it is or how to access it. You have to explore the dark and dangerous corridors,");
		con.sleep(1300);
		con.println("looking for clues and items that might help you. You have to avoid traps,");
		con.sleep(1300);
		con.println("fight monsters, and solve puzzles along the way. You also have to make decisions");
		con.sleep(1300);
		con.println("that will affect your story and your relationships with other characters.");
		con.sleep(2300);
		con.println("Will you be brave or cowardly?");
		con.sleep(2300);
		con.println("Will you be loyal or treacherous?");
		con.sleep(2300);
		con.println("Your choices will determine your fate.");
		con.sleep(330);
		*/
		intLuck = (int)(Math.random()*10+1);
		con.println("");
		con.println("Your luck is "+intLuck);
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
			con.println("Increased luck value: "+intLuck);
			con.println("Hint: press \"a\" in the next scene");
			}else{
			intLuck -= 1;
			con.println("Decreased luck value: "+intLuck);
			}
		con.println("Choose difficulty level (1.0 - easy, 2.0 - medium, 3.0 - hard)");
		while(true){
		dblDifficulty = con.readInt();
		if(dblDifficulty == 1.0){
			intLuck = intLuck;
			con.println("int luck stays the same "+intLuck);
			break;
		}else if(dblDifficulty == 2.0){
			intLuck -= 2;
			con.println("int luck decreases by 2 "+intLuck);
			break;
		}else if(dblDifficulty == 3.0){
			intLuck -= 3;
			con.println("int luck decreases by 3 "+intLuck);
			break;
		}else{
			con.println("Invalid input, please try again with (1.0 - easy, 2.0 - medium, 3.0 - hard)");
		}
		}
		
		
		


		
	}
}
