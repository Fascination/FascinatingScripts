package fascinatingMagician;

import java.util.concurrent.TimeUnit;

import org.powerbot.game.api.util.Timer;

public class Variables {

	public static int startingExperience, startingLevel, alchs, slot,
	coinsMade;
	public static long startTime = 0;
	public static Timer runTime = null;
	public static Timer timeRunning = new Timer(0);
	public static String status = "";

	public static long miliseconds = System.currentTimeMillis() - startTime;
	public static long runtime = TimeUnit.MILLISECONDS.toSeconds(miliseconds);
	
	public static int expGained = 0;
	public static int levelsGained = 0;
	
	//Misc
	
	public static int COSMIC_RUNE = 564;
	public static boolean hide = false;
	
	
	public static boolean amulet = false;
	public static boolean ring = false;
	public static boolean bracelet = false;
	public static boolean necklace = false;

	//Saphires
	public static int sapAmulet = 1694;
	public static int sapBracelet = 11072;
	public static int sapNecklace = 1656;
	public static int sapRing = 1637;
	
		
	
	public static int eSapAmulet = 1727;
	public static int eEmeAmulet = 1729;
	public static int eRubAmulet = 1725;
	public static int eDiaAmulet = 1731;
	public static int eDraAmulet = 1712;
	public static int eOnyAmulet = 6585;
	
	public static int eSapBrace = 11074;
	public static int eEmeBrace = 11079;
	public static int eRubBrace = 11088;
	public static int eDiaBrace = 11095;
	public static int eDraBrace = 11126;
	public static int eOnyBrace = 11133;
	
	public static int eSapNecklace = 3853;
	public static int eEmeNecklace = 5521;
	public static int eRubNecklace = 2558;
	public static int eDiaNecklace = 11090;
	public static int eDraNecklace =  11105;
	public static int eOnyNecklace = 11128;
	
	public static int eSapRing = 2550;
	public static int eEmeRing = 2552;
	public static int eRubRing = 11194;
	public static int eDiaRing = 2570;
	public static int eDraRing = 20659;
	public static int eOnyRing = 6583;
	
	//Emerald
	public static int emeAmulet = 1696;
	public static int emeBracelet = 11076;
	public static int emeNecklace = 1658;
	public static int emeRing = 1639;
	
	
	//Ruby
	public static int rubAmulet = 1698;
	public static int rubBracelet = 11085;
	public static int rubNecklace = 1660;
	public static int rubRing = 1641;
	
	//Diamond
	public static int diaAmulet = 1731;
	public static int diaBracelet = 11072;
	public static int diaNecklace = 1656;
	public static int diaRing = 1637;
	
	//DragonStone
	public static int draAmulet = 1702;
	public static int draBracelet = 11115;
	public static int draNecklace = 1664;
	public static int draRing = 1645;
	
	//Onyx
	public static int onyAmulet = 1694;
	public static int onyBracelet = 11072;
	public static int onyNecklace = 1656;
	public static int onyRing = 1637;
	
	//Alching
	public static final int NATURE_RUNE = 561;
	public static int idToAlch = 0;
	public static boolean HighAlch = false;
	public static boolean LowAlch = false;
	public static int alched = 0;
	
	//Teleporting
	public static boolean Teleport = false;
	public static int noOfTele = 0;
	
	//Enchantment
	public static boolean Enchant = false;
	
	public static int amuletToEnchant;
	
	public static int braceToEnchant;
	public static int braceID = 0;
	
	public static int neckToEnchant;
	public static int neckID = 0;
	
	public static int ringToEnchant;
	public static int ringID = 0;
	
	//Gatestone creator
	public static boolean gatestone = false;
	public static int kinship = 15707;
	public static int enterDung = 48496;
	public static boolean partyCreated = false;
	public static boolean inDung = false;
	public static int Smuggler = 11226;
	
	public static int bould = 18171;
	public static int short_eel = 18167;
	public static int blue_crab = 18175;
	public static int giant = 18165;
	public static int dusk_eel = 18163;
	public static int heim = 18159;
	
	//Plank Make
	public static int normal = 123;
	public static int oak = 213;
	public static int teak = 234;
	public static int mahogany = 6332;
	
	public static int normal_plank = 123;
	public static int oak_plank = 213;
	public static int teak_plank = 234;
	public static int mahogany_plank = 8782;

	public static int astral = 9075;
	public static int exp_maho = 90;
	public static int logsCasted = 0;
	
	public static int logsToPlank;
	public static int planksToBank;
	public static boolean plankmake = false;
	public static boolean needPlanks = false;
	
	//GUI
	public static boolean GUIFinished = false;

}
