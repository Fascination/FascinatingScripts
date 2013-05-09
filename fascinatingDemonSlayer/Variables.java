package fascinatingDemonSlayer;

import javax.swing.SwingUtilities;

import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

import defaultPackage.MasterFarmer.UNT;

public class Variables {

	//Paths
	
	public static Tile[] pathFromBankToShip = new Tile[] { new Tile(3091, 3244, 0), new Tile(3087, 3247, 0), new Tile(3082, 3249, 0), 
		new Tile(3077, 3250, 0), new Tile(3072, 3252, 0), new Tile(3067, 3254, 0), 
		new Tile(3062, 3254, 0), new Tile(3057, 3254, 0), new Tile(3052, 3254, 0), 
		new Tile(3047, 3254, 0), new Tile(3042, 3250, 0), new Tile(3040, 3245, 0), 
		new Tile(3040, 3240, 0), new Tile(3041, 3235, 0), new Tile(3030, 3236, 0), 
		new Tile(3027, 3232, 0), new Tile(3027, 3224, 0), new Tile(3027, 3221, 0) };
	
	public static Tile[] pathToDungeon = new Tile[] { new Tile(2956, 3146, 0), new Tile(2951, 3146, 0), new Tile(2946, 3146, 0), 
			new Tile(2941, 3146, 0), new Tile(2936, 3146, 0), new Tile(2931, 3147, 0), 
			new Tile(2927, 3150, 0), new Tile(2922, 3151, 0), new Tile(2917, 3152, 0), 
			new Tile(2912, 3152, 0), new Tile(2907, 3153, 0), new Tile(2902, 3155, 0), 
			new Tile(2897, 3156, 0), new Tile(2892, 3156, 0), new Tile(2887, 3155, 0), 
			new Tile(2882, 3154, 0), new Tile(2877, 3153, 0), new Tile(2872, 3153, 0), 
			new Tile(2867, 3152, 0), new Tile(2862, 3152, 0), new Tile(2857, 3154, 0), 
			new Tile(2854, 3158, 0), new Tile(2853, 3163, 0) };
	
	public static Tile[] pathToDownLesser = new Tile[] {new Tile(2853, 9575, 0), new Tile(2840, 9582, 0), new Tile(2836, 9566, 0), new Tile(2837, 9561, 0)};
	
	public static Tile[] pathToBank = new Tile[] { new Tile(3105, 3297, 0), new Tile(3101, 3294, 0), new Tile(3096, 3294, 0), 
		new Tile(3092, 3291, 0), new Tile(3087, 3288, 0), new Tile(3084, 3284, 0), 
		new Tile(3084, 3279, 0), new Tile(3084, 3274, 0), new Tile(3084, 3269, 0), 
		new Tile(3084, 3264, 0), new Tile(3089, 3264, 0), new Tile(3090, 3259, 0), 
		new Tile(3086, 3256, 0), new Tile(3083, 3252, 0), new Tile(3086, 3248, 0), 
		new Tile(3091, 3246, 0), new Tile(3093, 3243, 0) };
	
	//Areas
	
	public static Area dungEntranceArea = new Area(new Tile[] { new Tile(2832, 3183, 0), new Tile(2856, 3183, 0), new Tile(2857, 3157, 0), 
			new Tile(2833, 3158, 0), new Tile(2832, 3182, 0) });
	
	public static Area dBankArea = new Area(new Tile[] { new Tile(3087, 3246, 0), new Tile(3097, 3246, 0), new Tile(3097, 3239, 0), 
			new Tile(3087, 3239, 0), new Tile(3087, 3246, 0) });
	
	public static Area ropeArea = new Area(new Tile[] {new Tile(2855, 9568, 0), new Tile(2854, 9572, 0), new Tile(2858, 9572, 0), new Tile(2859, 9567, 0)});
	
	public static Area downLesser = new Area(new Tile[] {new Tile(2828, 9563, 0), new Tile(2838, 9568, 0), new Tile(2847, 9560, 0), new Tile(2837, 9551, 0)});
	
	public static Area lodeArea = new Area(new Tile[] {new Tile(3107, 3296, 0), new Tile(3107, 3301, 0), new Tile(3103, 3301, 0), new Tile(3103, 3296, 0)});
	
	public static Area shipArea = new Area(new Tile[] { new Tile(3037, 3206, 0), new Tile(3037, 3200, 0), new Tile(3052, 3200, 0), 
			new Tile(3052, 3205, 0), new Tile(3037, 3206, 0) });
	public static Area karamjaArea = new Area(new Tile[] { new Tile(2821, 3207, 0), new Tile(2963, 3165, 0), new Tile(2964, 3131, 0), 
			new Tile(2822, 3152, 0), new Tile(2821, 3206, 0) });
	
	//Booleans
	
	public static boolean GUIFinished = false;
	
	//Misc
	public static long startTime = 0;
	public static Timer runTime = null;
	public static Timer failsafeTimer;

	
	//NPCS
	public static int[] LesserDemon = {4697, 82, 4695, 4696, 4694};
	
	//Loot/Items/Food
	public static int food_monk = 7946;
	
	//SceneEntities
	public static int dungEntrance = 492;
	
}
