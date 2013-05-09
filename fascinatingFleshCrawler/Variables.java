package fascinatingFleshCrawler;

import org.powerbot.game.api.util.Timer;

public class Variables {
	
		//NPCs
		public static int monster[] = {4390};
		
		//Loot/Items
		public static int food_monk = 7946;
		public static int loots[] = {441, 554, 12159, 213, 217, 
			1621, 12158, 561, 207, 1619};
		
						public static int herbs[] = {199, 207, 213, 211};
						public static int runes[] = {561, 554};
						public static int gems[] = {1619};
						public static int charms[] = {12159, 12158};
						
		
		
		public static int strPot_4 = 113;
		public static int strPot_3 = 115;
		public static int strPot_2 = 117;
		public static int strPot_1 = 119;
		
		public static int superStrPot_4 = 2400;
		public static int superStrPot_3 = 157;
		public static int superStrPot_2 = 159;
		public static int superStrPot_1 = 161;
		
		public static int defPot_4 = 2432;
		public static int defPot_3 = 133;
		public static int defPot_2 = 135;
		public static int defPot_1 = 137;
		
		public static int superDefPot_4 = 2442;
		public static int superDefPot_3 = 163;
		public static int superDefPot_2 = 165;
		public static int superDefPot_1 = 167;
		
		
		public static int attPot_4 = 2428;
		public static int attPot_3 = 121;
		public static int attPot_2 = 123;
		public static int attPot_1 = 125;
		
		public static int superAttPot_4 = 2436;
		public static int superAttPot_3 = 145;
		public static int superAttPot_2 = 147;
		public static int superAttPot_1 = 149;
		
		//All
		public static int strengthPots[] = {113, 115, 117, 119};
		public static int superStrengthPots[] = {2400, 157, 159, 161};
		public static int defencePots[] = {2432, 133, 117, 119};
		
	
		//Booleans
	
		public static boolean GUIFinished = false;
		
		public static boolean useStrPots = false;
		public static boolean useSuperStrPots = false;
		public static boolean useExtStrPots = false;
		
		public static boolean useDefPots = false;
		public static boolean useSuperDefPots = false;
		public static boolean useExtDefPots = false;
		
		public static boolean useAttPots = false;
		public static boolean useSuperAttPots = false;
		public static boolean useExtAttPots = false;
		
		//Paint related
		public static boolean summaryClicked = true;
		public static boolean statsClicked = false;
		
		
		//SceneEntites
		public static final int first_door = 16066;
		public static final int second_door = 16065;
		
		//Misc
		public static long startTime = 0;
		public static Timer runTime = null;
		public static Timer failsafeTimer;
		
		public static int noOfStr = 0;
		public static int noOfDef = 0;
		public static int noOfAtt = 0;
		
		public static boolean lootCount = false;
		public static int killCount = 0;
		
		public static String status;
		
	
}
