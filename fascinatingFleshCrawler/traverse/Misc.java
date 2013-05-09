package fascinatingFleshCrawler.traverse;

import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

public class Misc {

	//Paths
	public static Tile[] pathToDungeon = new Tile[] { new Tile(3186, 3440, 0), new Tile(3186, 3435, 0), new Tile(3186, 3430, 0), 
		new Tile(3181, 3428, 0), new Tile(3176, 3428, 0), new Tile(3171, 3427, 0), 
		new Tile(3166, 3426, 0), new Tile(3162, 3423, 0), new Tile(3158, 3420, 0), 
		new Tile(3153, 3418, 0), new Tile(3148, 3416, 0), new Tile(3143, 3415, 0), 
		new Tile(3138, 3415, 0), new Tile(3133, 3415, 0), new Tile(3128, 3416, 0), 
		new Tile(3123, 3418, 0), new Tile(3118, 3418, 0), new Tile(3113, 3420, 0), 
		new Tile(3108, 3421, 0), new Tile(3103, 3420, 0), new Tile(3098, 3420, 0), 
		new Tile(3093, 3420, 0), new Tile(3088, 3420, 0), new Tile(3084, 3419, 0) };
	
	public static Tile[] pathFromEdgeToDung = new Tile[] { new Tile(3094, 3492, 0), new Tile(3089, 3490, 0), new Tile(3086, 3486, 0), 
		new Tile(3083, 3482, 0), new Tile(3082, 3477, 0), new Tile(3080, 3472, 0), 
		new Tile(3080, 3467, 0), new Tile(3083, 3463, 0), new Tile(3087, 3460, 0), 
		new Tile(3092, 3458, 0), new Tile(3093, 3452, 0), new Tile(3093, 3447, 0), 
		new Tile(3093, 3442, 0), new Tile(3093, 3437, 0), new Tile(3094, 3432, 0), 
		new Tile(3089, 3426, 0), new Tile(3085, 3423, 0), new Tile(3082, 3419, 0) };
	
	public static Tile[] pathFromLodeToBank = new Tile[] { new Tile(3066, 3504, 0), new Tile(3071, 3502, 0), new Tile(3076, 3501, 0), 
			new Tile(3081, 3501, 0), new Tile(3086, 3501, 0), new Tile(3091, 3500, 0), 
			new Tile(3093, 3497, 0), new Tile(3151, 3512, 0) };
	
	//Areas
	public static Area dungEntranceArea = new Area(new Tile[] { new Tile(3075, 3425, 0), new Tile(3075, 3416, 0), new Tile(3085, 3416, 0), 
			new Tile(3085, 3425, 0), new Tile(3075, 3425, 0) });
	
	public static Area varrock = new Area(new Tile[] { new Tile(3066, 3477, 0), new Tile(3066, 3387, 0), new Tile(3236, 3388, 0), 
			new Tile(3236, 3476, 0), new Tile(3066, 3477, 0) });
	
	public static Area secondLevelArea = new Area(new Tile[] {new Tile(2041, 5241, 0), new Tile(2041, 5244, 0), new Tile(2045, 5244, 0), new Tile(2045, 5241, 0)});
	
	public static Area edgeLodeArea = new Area(new Tile[] { new Tile(3062, 3510, 0), new Tile(3062, 3501, 0), new Tile(3071, 3501, 0), 
			new Tile(3071, 3509, 0), new Tile(3062, 3510, 0) });
	
	public static Area edgeBankArea = new Area(new Tile[] { new Tile(3089, 3500, 0), new Tile(3089, 3487, 0), new Tile(3098, 3487, 0), 
			new Tile(3098, 3500, 0), new Tile(3089, 3500, 0) });
	
	public static final Area fleshcrawlersArea = new Area(
			   new Tile(2047, 5195, 0), new Tile(2046, 5184, 0),
			   new Tile(2036, 5184, 0), new Tile(2036, 5192, 0),
			   new Tile(2034, 5192, 0), new Tile(2034, 5195, 0)
			);
	
		//Areas in-between the doors
	public static Area firstDoorArea = new Area(new Tile[] {new Tile(2044, 5239, 0), new Tile(2045, 5239, 0), 
			new Tile(2045, 5237, 0), new Tile(2044, 5237, 0)});
		
}
