package defaultPackage;

import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Settings;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.SceneObject;

import java.util.Arrays;
import java.util.Comparator;

import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.node.GroundItem;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


@Manifest(authors = { "Fascination","Defeat3d" }, name = "[v1.1] Citadel Junky", description = "Does all the activities", version = 1.1, website = "http://www.powerbot.org/community/topic/767076-citadel-junky-by-fascination-defeat3d-all-activities/" )
public class CitadelJunky extends ActiveScript {

	//Boolean
	public static boolean ChopFish = false;
	public static boolean stew = false;
	public static boolean grill = false;
	public static boolean ChopRoots = false;
	public static boolean craft = false;
	public static boolean kiln = false;
	public static boolean minestone = false;
	public static boolean mineore = false;
	public static boolean minepreciousore = false;
	public static boolean smith = false;
	public static boolean summon = false;
	public static boolean pickOrts = false;
	public static boolean antiban = false;
	private boolean GUIFinished = false;
	public static boolean startScript = false;
	public static long startTime;
	
	//Miscallenous
	public static Timer runTime = null;
	
	//ROOT_IDs
	public static int ROOT_ID[] = {

		// T7
		18406, 18496, 18503, 18662, 18856,
		18859,
		// T6
		17931, 17971, 17995, 17998, 18328,
		18331,
		// T5
		17861, 17858, 17866, 17907, 17913,
		17920,
		// T4
		19450, 19478, 19483, 19550, 19568, 19627, 17329, 17330, 17331,
		17332, 17333,
		17334,
		// T3

		// T2
		18874, 18883, 18901, 18907, 18920, 18921,
		// T1
		17301, 17318, 17319, 17326, 17327, 17328, 18921, 18920, 18907,
		18901, 18883, 18874, 17301, 17318, 17319, 17326, 17327, 16328, 
		
		//unknown
		18331,18328,17998,17995,17971,17931
	
	};
	
	
	/*
	 * MINE_ORE_IDs
	 */
	
	public static int ORE_ID[] = {
		//T7
		25053, 25052,
		//T6

		//T5
25031, 25032,
		//T4
		25030, 24983,
		//T3
		24982, 24981, 24980, 24979,
	
		//unknown
		25049, 25050,25051
	
	};
	
	
	/*
	 * MINE_STONE_IDs
	 */
	
	public static int STONE_ID[] = {
		// T7
		21738, 21751, 21760, 21754,
		// T6
		21673, 21672, 21643, 21656, 21528, 21566,
		// T5
		21568, 21567, 21564, 21563,
		// T4
		21556, 21528, 21557, 21558, 23539, 23540, 23543, 23542,

		// T3
		21500, 24533, 24522, 21518,
		// T2
		20986, 20985, 24421, 24422, 
	
		//unknown
		21643,21656,21672,21673
		
	};
		
	/*
	 * MINE_PRECIOUSORE_IDs
	 */
	
	public static int PRECIOUS_ORE_ID[] = {
		// T7
		25063, 25062,
		// T6
		25055, 25056,
		// T5
		25058, 25057,
		// T4
		25056, 25055, 
		
		//unknown
		25059,25060,25061
	};
	
	//LOOM_IDs
	public static int[] LOOM_ID = { 14317, 14335, 14337, 14340, 14341, 14342,
		14343, 14345, 14347, 14355, 14359, 14361, 14363, 14435, 14477,
		14478, 14662, 14688, 14690, 14692, 14722, 14737, 14814, 14815,
		14817, 14818, 14819, 14820, 14821, 14822, 14824, 14861, 14900,
		14901, 15022, 15023, 15055, 15056, 15057, 15174, 15176, 15180,
		15220, 15221, 15258, 15272, 15332, 15333, 15335, 15338, 15339,
		15340, 15357, 15359, 15360, 15417, 15433, 15449, 15451, 15461,
		15521, 15574, 15575, 15679, 15680, 15684, 15685, 15691, 15692,
		15693, 15693, 15694, 15634, 15735, 15636, 15737, 15738, 15739,
		15741, 15742, 15743, 15744, 15745, 15055, 15056, 15057, 15174 };
	
	//CHOP_FISH_IDs
	public static int[] LARGE_CHOPPING_BOARD_ID = { 28871, 28912, 29195, 29209,
		29240, 29263, 29369, 29458, 29520, 29582, 29683, 29691, 29831,
		29845, 29858, 29883, 30054, 30078, 30277, 30385, 30451, 30678,
		30871, 30880 };
	
	//GRILL_IDs
	public static int[] GRILL_ID = { 28897, 28994, 29202, 29213, 29251, 29267,
		29427, 29469, 29575, 29622, 29688, 29769, 29838, 29848, 29875,
		29932, 30069, 30241, 30346, 30446, 30619, 30719, 30877, 30890,
		29239,29240,29251,29263,29260,29267};
	
	//STEW_IDS
	public static int[] STEW_ID = { 28870, 28907, 29153, 29208, 29239, 29260,
		29368, 29446, 29487, 29580, 29682, 29690, 29825, 29844, 29852,
		29882, 30008, 30072, 30257, 30348, 30450, 30677, 30866, 30879 };
	
	//SUMMON_IDS
	public static int[] OBELISK_ID = {
		// T7
		20585,
		// T6
		20464, 20451,
		// T5
		20451, 20511 };
	
	//EMPTY_MOULD_IDS
	public static int[] MOULD_ID = {
		// T7
		27167, 27171, 27188
		// T6

		// T5

		// T4
		};
	
	//EMPTY_THROUGH_IDS
	public static int[] THROUGH_ID = {
		// T7
		27118, 27139, 27148
		// T6

		// T5

		// T4
		};
	
	//ORE_CONTAINER_IDS
	public static int[] ORE_CONTAINER_ID = {
		// T7
		27201, 27209, 27214,
		// T6

		// T5

		// T4
		27752, 27753, 
		// T3
		};
	
	private Timer t;
	private boolean timerInitialized = false;
	
private final Node[] array = new Node[] {new ChopRoots(), new MineOre(), new MineStone(), new MinePreciousOre(), new Summon(), 
										 new Grill(), new ChopFish(), new Craft(), new Stew(), new EmptyMould(), new EmptyThrough(),
										 new Shovel()}; //add classes here
				
	@Override
    public int loop() {

            for (final Node node : array) {
                    if (node.activate()) {
                            node.execute();
                    }
            }
            return 0;
    }
	
	public void onStart(){
		initiateGUI();
		
	}
	
	public void initiateGUI() {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				final CITjunkyGUI gui = new CITjunkyGUI();
				gui.setVisible(true);
				gui.setResizable(false);
			}
		});
		
	}
	
	//METHODS:
	
	public static class Locatables {
		/**
		 * Returns an array with SceneObjects sorted by distance that have the given
		 * id(s).
		 * 
		 * @param ids
		 *            : The ID(s) of the object(s) you want to sort.
		 */
		public static SceneObject[] sortNearestObject(final int... ids) {
			final SceneObject[] objects = SceneEntities.getLoaded(ids);

			Arrays.sort(objects, new Comparator<SceneObject>() {
				public int compare(SceneObject o1, SceneObject o2) {
					return (int) Math.signum(Calculations.distanceTo(o1)
							- Calculations.distanceTo(o2));
				}
			});
			return objects;
		}

		/**
		 * Returns an array with Tiles sorted by distance.
		 * 
		 * @param tileArray
		 *            : The tiles you want to sort.
		 */
		public static Tile[] sortNearestTile(final Tile[] tileArray) {
			final Tile[] tiles = tileArray;

			Arrays.sort(tiles, new Comparator<Tile>() {
				public int compare(Tile o1, Tile o2) {
					return (int) Math.signum(Calculations.distanceTo(o1)
							- Calculations.distanceTo(o2));
				}
			});
			return tiles;
		}

		/**
		 * Returns an array with GroundItems sorted by distance that have the given
		 * id.
		 * 
		 * @param id
		 *            : The ID of the grounditem you want to sort.
		 */
		public static GroundItem[] sortNearestGroundItem(final int id) {
			final GroundItem[] items = GroundItems.getLoaded(id);

			Arrays.sort(items, new Comparator<GroundItem>() {
				public int compare(GroundItem o1, GroundItem o2) {
					return (int) Math.signum(Calculations.distanceTo(o1)
							- Calculations.distanceTo(o2));
				}
			});
			return items;
		}

		/**
		 * Returns an array with NPCs sorted by distance that have the given id(s).
		 * 
		 * @param ids
		 *            : The ID(s) of the NPC(s) you want to sort.
		 */
		public static NPC[] sortNearestNPC(final int... ids) {
			final NPC[] npcs = NPCs.getLoaded(ids);

			Arrays.sort(npcs, new Comparator<NPC>() {
				public int compare(NPC o1, NPC o2) {
					return (int) Math.signum(Calculations.distanceTo(o1)
							- Calculations.distanceTo(o2));
				}
			});
			return npcs;
		}

		/**
		 * Returns an array with SceneObjects sorted by distance that have the given
		 * name.
		 * 
		 * @param name
		 *            : The name of the object you want to sort.
		 */
		public static SceneObject[] sortNearestObjectByName(final String name) {
			final SceneObject[] objects = SceneEntities
					.getLoaded(new Filter<SceneObject>() {

						@Override
						public boolean accept(SceneObject s) {
							return s.getDefinition().getName().contains(name);
						}

					});
			Arrays.sort(objects, new Comparator<SceneObject>() {
				public int compare(SceneObject o1, SceneObject o2) {
					return (int) Math.signum(Calculations.distanceTo(o1)
							- Calculations.distanceTo(o2));
				}
			});
			return objects;
		}

		/**
		 * Returns true if the given object is null.
		 * 
		 * @param object
		 *            : The object you want to check.
		 */
		public static boolean isObjectNull(final SceneObject object) {
			return object == null;
		}

		/**
		 * Returns true if the given NPC is null.
		 * 
		 * @param npc
		 *            : The NPC you want to check.
		 */
		public static boolean isNPCNull(final NPC npc) {
			return npc == null;
		}
	}
	

	//PLOTS
	public class ChopRoots extends Node {

		public SceneObject[] sortNearestObject(final int... ids) {
			final SceneObject[] objects = SceneEntities.getLoaded(ids);

			Arrays.sort(objects, new Comparator<SceneObject>() {
				public int compare(SceneObject o1, SceneObject o2) {
					return (int) Math.signum(Calculations.distanceTo(o1)
							- Calculations.distanceTo(o2));
				}
			});
			return objects;
		}
		
		public SceneObject[] getNearest(final int... ids) {
			final SceneObject[] objects = SceneEntities.getLoaded(ROOT_ID);

			Arrays.sort(objects, new Comparator<SceneObject>() {
				public int compare(SceneObject o1, SceneObject o2) {
					return (int) Math.signum(Calculations.distanceTo(o1)
							- Calculations.distanceTo(o2));
				}
			});
			return objects; // returns the objects array
		}	
		
		private boolean rootAvailable(){
			return Settings.get(2537) > 0;
		}
		
		@Override
		public boolean activate() {
			
			if(!GUIFinished){
				return Boolean.FALSE;
			}
			
			if(ChopRoots == true){
				return Boolean.TRUE;
			}
			
			return sortNearestObject(ROOT_ID)[0].isOnScreen() && ChopRoots == true;
		}

		@Override
		public void execute() {
			
			final SceneObject logs = SceneEntities.getNearest(ROOT_ID);
			SceneObject[] objects = getNearest(ROOT_ID);
			SceneObject next = objects[1]; // Assuming the current one is the
			// closest
			if (!rootAvailable() && Players.getLocal().getAnimation() == -1
					&& next.isOnScreen()) {
				Camera.turnTo(logs);
				next.interact("Chop");
				Task.sleep(1200, 1400);
				
			}
			if (logs != null && rootAvailable()
					&& Players.getLocal().getAnimation() == -1
					&& logs.isOnScreen()) {
				Camera.turnTo(logs);
				logs.interact("Chop");
				Task.sleep(1200, 1400);
			}
			
		}
		
	}
	
	public class MineOre extends Node {

		private boolean rockAvailable(){
			return Settings.get(2273) == 0;
		}
		
		@Override
		public boolean activate() {
			if(!GUIFinished){
				return Boolean.FALSE;
			}
			
			return Locatables.sortNearestObject(ORE_ID)[0].isOnScreen() && mineore == true;
		}

		@Override
		public void execute() {
			final SceneObject[] Rock = Locatables.sortNearestObject(ORE_ID);

			if (!timerInitialized) {
				t = new Timer(2000);
				timerInitialized = true;
			}

			if (Players.getLocal().getAnimation() == -1 && t.getElapsed() > 1500) {
				t = new Timer(2000);
			}

			if (!rockAvailable() && Players.getLocal().getAnimation() == -1
					&& Rock[1].isOnScreen() && t.getElapsed() > 1000) {

				if (SceneEntities.getAt(Rock[0].getLocation().getX() + 3, Rock[0]
						.getLocation().getY()) != null) {
					SceneEntities.getAt(Rock[0].getLocation().getX() + 3,
							Rock[0].getLocation().getY()).interact("Mine", "Ore");
					Task.sleep(1200, 1400);
				} else

				if (SceneEntities.getAt(Rock[1].getLocation().getX() - 3, Rock[0]
						.getLocation().getY()) != null) {
					SceneEntities.getAt(Rock[1].getLocation().getX() - 3,
							Rock[1].getLocation().getY()).interact("Mine", "Ore");
					Task.sleep(1200, 1400);
				}
			}

			if (rockAvailable() && Players.getLocal().getAnimation() == -1
					&& Rock[0].isOnScreen() && t.getElapsed() > 1000) {
				Rock[0].interact("Mine", "Ore");
				Task.sleep(1200, 1400);
			}
			
		}
		
	}
	
	public class MineStone extends Node {

		private boolean rockAvailable(){
			return Settings.get(2273) == 0;
		}
		
		@Override
		public boolean activate() {
			if(!GUIFinished){
				return Boolean.FALSE;
			}
			
			if(minestone == true){
				return Boolean.TRUE;
			}
			
			return Locatables.sortNearestObject(STONE_ID)[0].isOnScreen() && minestone == true;
		}

		@Override
		public void execute() {
			final SceneObject[] Rock = Locatables.sortNearestObject(STONE_ID);

			if (!timerInitialized) {
				t = new Timer(2000);
				timerInitialized = true;
			}

			if (Players.getLocal().getAnimation() == -1 && t.getElapsed() > 1500) {
				t = new Timer(2000);
			}

			if (!rockAvailable() && Players.getLocal().getAnimation() == -1
					&& Rock[1].isOnScreen() && t.getElapsed() > 1000) {

				if (SceneEntities.getAt(Rock[0].getLocation().getX() + 3, Rock[0]
						.getLocation().getY()) != null) {
					SceneEntities.getAt(Rock[0].getLocation().getX() + 3,
							Rock[0].getLocation().getY()).interact("Mine", "Stone");
					Task.sleep(1200, 1400);
				} else

				if (SceneEntities.getAt(Rock[1].getLocation().getX() - 3, Rock[0]
						.getLocation().getY()) != null) {
					SceneEntities.getAt(Rock[1].getLocation().getX() - 3,
							Rock[1].getLocation().getY()).interact("Mine", "Stone");
					Task.sleep(1200, 1400);
				}
			}

			if (rockAvailable() && Players.getLocal().getAnimation() == -1
					&& Rock[0].isOnScreen() && t.getElapsed() > 1000) {
				Rock[0].interact("Mine", "Stone");
				Task.sleep(1200, 1400);
			}
			
		}
		
	}
	
	public class MinePreciousOre extends Node {

		private boolean rockAvailable(){
			return Settings.get(2273) == 0;
		}
		
		@Override
		public boolean activate() {
			if(!GUIFinished){
				return Boolean.FALSE;
			}
			
			return Locatables.sortNearestObject(PRECIOUS_ORE_ID)[0].isOnScreen() && minepreciousore == true;
		}

		@Override
		public void execute() {
			final SceneObject[] Rock = Locatables
					.sortNearestObject(PRECIOUS_ORE_ID);

			if (!timerInitialized) {
				t = new Timer(2000);
				timerInitialized = true;
			}

			if (Players.getLocal().getAnimation() == -1 && t.getElapsed() > 1500) {
				t = new Timer(2000);
			}

			if (!rockAvailable() && Players.getLocal().getAnimation() == -1
					&& Rock[1].isOnScreen() && t.getElapsed() > 1000) {

				if (SceneEntities.getAt(Rock[0].getLocation().getX() + 3, Rock[0]
						.getLocation().getY()) != null) {
					SceneEntities.getAt(Rock[0].getLocation().getX() + 3,
							Rock[0].getLocation().getY()).interact("Mine",
							"Precious Ore");
					Task.sleep(1200, 1400);
				} else

				if (SceneEntities.getAt(Rock[1].getLocation().getX() - 3, Rock[0]
						.getLocation().getY()) != null) {
					SceneEntities.getAt(Rock[1].getLocation().getX() - 3,
							Rock[1].getLocation().getY()).interact("Mine",
							"Precious Ore");
					Task.sleep(1200, 1400);
				}
			}

			if (rockAvailable() && Players.getLocal().getAnimation() == -1
					&& Rock[0].isOnScreen() && t.getElapsed() > 1000) {
				Rock[0].interact("Mine", "Precious Ore");
				Task.sleep(1200, 1400);
			}

		
			
		}
		
	}
	
	public class Craft extends Node {

		@Override
		public boolean activate() {
			if(!GUIFinished){
				return Boolean.FALSE;
			}
			
			return Locatables.sortNearestObject(LOOM_ID)[0].isOnScreen() && craft == true;
		}

		@Override
		public void execute() {
			final SceneObject[] Loom = Locatables.sortNearestObject(LOOM_ID);

			if (!timerInitialized) {
				t = new Timer(2000);
				timerInitialized = true;
			}

			if (Players.getLocal().getAnimation() == -1 && t.getElapsed() > 1500) {
				t = new Timer(2000);
			}

			if (Players.getLocal().getAnimation() == -1 && Loom[0].isOnScreen()
					&& t.getElapsed() > 400) {
				SceneEntities.getAt(Loom[0]).interact("Weave", "Loom");
				Task.sleep(1200, 1400);
			}
			
		}
		
	}

	public class ChopFish extends Node {
	
		
		@Override
		public boolean activate() {
			if(!GUIFinished){
				return Boolean.FALSE;
			}
			
			return Locatables.sortNearestObject(LARGE_CHOPPING_BOARD_ID)[0]
					.isOnScreen() && ChopFish == true;
		}

		@Override
		public void execute() {
			final SceneObject LargeChoppingBoard = Locatables
					.sortNearestObject(LARGE_CHOPPING_BOARD_ID)[0];

			if (!timerInitialized) {
				t = new Timer(2000);
				timerInitialized = true;
			}

			if (Players.getLocal().getAnimation() == -1 && t.getElapsed() > 1500) {
				t = new Timer(2000);
			}

			if (LargeChoppingBoard != null) {
				if (Players.getLocal().getAnimation() == -1
						&& LargeChoppingBoard.isOnScreen() && t.getElapsed() > 1000) {
					Camera.turnTo(LargeChoppingBoard);
					LargeChoppingBoard.interact("Chop", "Large Chopping Board");
					Task.sleep(1600, 2000);
				}
			}
			
		}
		
	}
	
	public class Grill extends Node {

		@Override
		public boolean activate() {
			if(!GUIFinished){
				return Boolean.FALSE;
			}
			
			return Locatables.sortNearestObject(GRILL_ID)[0].isOnScreen() && grill == true;
		}

		@Override
		public void execute() {
			final SceneObject Grill = Locatables.sortNearestObject(GRILL_ID)[0];

			if (!timerInitialized) {
				t = new Timer(2000);
				timerInitialized = true;
			}

			if (Players.getLocal().getAnimation() == -1 && t.getElapsed() > 1500) {
				t = new Timer(2000);
			}

			if (Grill != null) {
				if (Players.getLocal().getAnimation() == -1 && Grill.isOnScreen()
						&& t.getElapsed() > 1000) {
					Camera.turnTo(Grill);
					Grill.interact("Use", "Grill");
					Task.sleep(1600, 2000);
				}
			}
			
		}
		
	}
	
	public class Stew extends Node {

		@Override
		public boolean activate() {
			if(!GUIFinished){
				return Boolean.FALSE;
			}
			
			return Locatables.sortNearestObject(STEW_ID)[0].isOnScreen() && stew == true;
		}

		@Override
		public void execute() {
			final SceneObject Stewer = Locatables.sortNearestObject(STEW_ID)[0];

			if (!timerInitialized) {
				t = new Timer(2000);
				timerInitialized = true;
			}

			if (Players.getLocal().getAnimation() == -1 && t.getElapsed() > 1500) {
				t = new Timer(2000);
			}

			if (Stewer != null) {
				if (Players.getLocal().getAnimation() == -1 && Stewer.isOnScreen() && t.getElapsed() > 1000) {
					Camera.turnTo(Stewer);
					Stewer.interact("Stew", "Stewing Pot");
					Task.sleep(1600, 2000);
				}
			}
			
		}
		
	}
	
	public class Summon extends Node {

		@Override
		public boolean activate() {
			if(!GUIFinished){
				return Boolean.FALSE;
			}
			
			return summon == true;
		}

		@Override
		public void execute() {
			final SceneObject[] Obelisk = Locatables.sortNearestObject(OBELISK_ID);

			if (!timerInitialized) {
				t = new Timer(2000);
				timerInitialized = true;
			}

			if (Players.getLocal().getAnimation() == -1 && t.getElapsed() > 1500) {
				t = new Timer(2000);
			}

			if (!Obelisk[0].isOnScreen()) {
				Walking.walk(Obelisk[0]);
				Camera.turnTo(Obelisk[0]);
			}

			if (Players.getLocal().getAnimation() == -1 && Obelisk[0].isOnScreen()
					&& t.getElapsed() > 400) {
				Obelisk[0].interact("Summon", "Obelisk");
				Task.sleep(1200, 1400);
			}
			
		}
		
	}
	
	public class EmptyMould extends Node {

		@Override
		public boolean activate() {
			if(!GUIFinished){
				return Boolean.FALSE;
			}
			
			return Locatables.sortNearestObject(MOULD_ID) != null && smith == true;
		}

		@Override
		public void execute() {
			final SceneObject Mould = Locatables.sortNearestObject(MOULD_ID)[0];

			if (!timerInitialized) {
				t = new Timer(2000);
				timerInitialized = true;
			}

			if (Players.getLocal().getAnimation() == -1 && t.getElapsed() > 1500) {
				t = new Timer(2000);
			}

			if (Players.getLocal().getAnimation() == -1 && Mould.isOnScreen()) {
				Camera.turnTo(Mould);
				Mould.interact("Empty");
				Task.sleep(1600, 2000);
			}
			
		}
		
	}
	
	public class EmptyThrough extends Node {

		@Override
		public boolean activate() {
			if(!GUIFinished){
				return Boolean.FALSE;
			}
			
			return Locatables.sortNearestObject(MOULD_ID) != null && smith == true;
		}

		@Override
		public void execute() {
			final SceneObject Through = Locatables.sortNearestObject(THROUGH_ID)[0];

			if (!timerInitialized) {
				t = new Timer(2000);
				timerInitialized = true;
			}

			if (Players.getLocal().getAnimation() == -1 && t.getElapsed() > 1500) {
				t = new Timer(2000);
			}

			if (Players.getLocal().getAnimation() == -1 && Through.isOnScreen()) {
				Camera.turnTo(Through);
				Through.interact("Empty");
				Task.sleep(1600, 2000);
			}
			
		}
		
	}
	
	public class Shovel extends Node {

		@Override
		public boolean activate() {
			
			if(!GUIFinished){
				return Boolean.FALSE;
			}
			return Locatables.sortNearestObject(MOULD_ID) != null && smith == true;
		}

		@Override
		public void execute() {
			final SceneObject Container = Locatables
					.sortNearestObject(ORE_CONTAINER_ID)[0];

			if (!timerInitialized) {
				t = new Timer(2000);
				timerInitialized = true;
			}

			if (Players.getLocal().getAnimation() == -1 && t.getElapsed() > 1500) {
				t = new Timer(2000);
			}

			if (Players.getLocal().getAnimation() == -1 && Container.isOnScreen()) {
				Camera.turnTo(Container);
				Container.interact("Shovel");
				Task.sleep(1600, 2000);
			}
			
		}
		
	}
	//GUI
	public class CITjunkyGUI extends JFrame {
		private static final long serialVersionUID = 1L;
		
		boolean isRunning = true;
		
		public CITjunkyGUI() {
			initComponents();
		}

		private void selectStartActionPerformed(ActionEvent e) {
			this.setVisible(true);
			
			if(chopRoots.isSelected()){
				ChopRoots = true;
			}
			
			if(mineStone.isSelected()){
				minestone = true;
			}
			
			if(mineOre.isSelected()){
				mineore = true;
			}
			
			if(minePreciousOre.isSelected()){
				minepreciousore = true;
			}
			
			if(useStew.isSelected()){
				stew = true;
			}
			
			if(useKiln.isSelected()){
				kiln = true;
			}
			
			if(useCraft.isSelected()){
				craft = true;
			}
			
			if(useSmith.isSelected()){
				smith = true;
			}
			
			if(useSummon.isSelected()){
				summon = true;
			}
			
			if(chopFish.isSelected()){
				ChopFish = true;
			}
			
			if(useGrill.isSelected()){
				grill = true;
			}
			
			dispose();	
			
			GUIFinished = true;
			isRunning = false;
			startTime = System.currentTimeMillis();
			runTime = new Timer(0);
			dispose();
			}

		private void initComponents() {
			// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
			// Generated using JFormDesigner Evaluation license - guest Bhide
			label1 = new JLabel();
			label2 = new JLabel();
			separator1 = new JSeparator();
			chopRoots = new JRadioButton();
			mineStone = new JRadioButton();
			mineOre = new JRadioButton();
			minePreciousOre = new JRadioButton();
			useStew = new JRadioButton();
			useKiln = new JRadioButton();
			useCraft = new JRadioButton();
			useSmith = new JRadioButton();
			useSummon = new JRadioButton();
			chopFish = new JRadioButton();
			useGrill = new JRadioButton();
			label3 = new JLabel();
			separator2 = new JSeparator();
			selectStart = new JButton();

			//======== this ========
			setTitle("[v2.50] Citadel Junky GUI");
			Container contentPane = getContentPane();

			//---- label1 ----
			label1.setText("Citadel Junky");
			label1.setFont(new Font("Trajan Pro", Font.PLAIN, 26));

			//---- label2 ----
			label2.setText("By Fascination & Defeat3d");

			//---- separator1 ----
			separator1.setForeground(new Color(153, 153, 153));

			//---- chopRoots ----
			chopRoots.setText("Chop Roots");

			//---- mineStone ----
			mineStone.setText("Mine Stone");

			//---- mineOre ----
			mineOre.setText("Mine Ore");

			//---- minePreciousOre ----
			minePreciousOre.setText("Mine Precious Ore");

			//---- useStew ----
			useStew.setText("Stew");

			//---- useKiln ----
			useKiln.setText("Kiln");
			useKiln.setEnabled(false);

			//---- useCraft ----
			useCraft.setText("Craft");

			//---- useSmith ----
			useSmith.setText("Smith");

			//---- useSummon ----
			useSummon.setText("Summon");

			//---- chopFish ----
			chopFish.setText("Chop Fish");

			//---- useGrill ----
			useGrill.setText("Grill");

			//---- label3 ----
			label3.setText("Choose which Plot to cap:");

			//---- separator2 ----
			separator2.setForeground(new Color(153, 153, 153));
			separator2.setOrientation(SwingConstants.VERTICAL);

			//---- selectStart ----
			selectStart.setText("Start!");
			selectStart.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					selectStartActionPerformed(e);
				}
			});

			GroupLayout contentPaneLayout = new GroupLayout(contentPane);
			contentPane.setLayout(contentPaneLayout);
			contentPaneLayout.setHorizontalGroup(
				contentPaneLayout.createParallelGroup()
					.addGroup(contentPaneLayout.createSequentialGroup()
						.addGroup(contentPaneLayout.createParallelGroup()
							.addGroup(contentPaneLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(contentPaneLayout.createParallelGroup()
									.addComponent(separator1, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
									.addGroup(contentPaneLayout.createSequentialGroup()
										.addGroup(contentPaneLayout.createParallelGroup()
											.addComponent(mineStone)
											.addComponent(mineOre)
											.addComponent(minePreciousOre)
											.addComponent(useStew)
											.addComponent(chopRoots))
										.addGap(64, 64, 64)
										.addComponent(separator2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
										.addGap(65, 65, 65)
										.addGroup(contentPaneLayout.createParallelGroup()
											.addComponent(useGrill)
											.addComponent(chopFish)
											.addComponent(useSummon)
											.addComponent(useSmith)
											.addComponent(useCraft))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE))))
							.addGroup(contentPaneLayout.createSequentialGroup()
								.addGroup(contentPaneLayout.createParallelGroup()
									.addGroup(contentPaneLayout.createSequentialGroup()
										.addGap(175, 175, 175)
										.addComponent(label1)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(label2))
									.addGroup(contentPaneLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(label3))
									.addGroup(contentPaneLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(useKiln))
									.addGroup(contentPaneLayout.createSequentialGroup()
										.addGap(64, 64, 64)
										.addComponent(selectStart, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)))
								.addGap(0, 22, Short.MAX_VALUE)))
						.addContainerGap())
			);
			contentPaneLayout.setVerticalGroup(
				contentPaneLayout.createParallelGroup()
					.addGroup(contentPaneLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addComponent(label2)
							.addComponent(label1))
						.addGap(2, 2, 2)
						.addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(label3)
						.addGap(13, 13, 13)
						.addGroup(contentPaneLayout.createParallelGroup()
							.addGroup(contentPaneLayout.createSequentialGroup()
								.addComponent(chopRoots)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(mineStone)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(mineOre)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(minePreciousOre)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(useStew)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(useKiln))
							.addGroup(contentPaneLayout.createSequentialGroup()
								.addComponent(useCraft)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(useSmith)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(useSummon)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(chopFish)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(useGrill))
							.addComponent(separator2, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addComponent(selectStart)
						.addContainerGap(21, Short.MAX_VALUE))
			);
			pack();
			setLocationRelativeTo(getOwner());
			// JFormDesigner - End of component initialization  //GEN-END:initComponents
		}

		// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
		// Generated using JFormDesigner Evaluation license - guest Bhide
		private JLabel label1;
		private JLabel label2;
		private JSeparator separator1;
		private JRadioButton chopRoots;
		private JRadioButton mineStone;
		private JRadioButton mineOre;
		private JRadioButton minePreciousOre;
		private JRadioButton useStew;
		private JRadioButton useKiln;
		private JRadioButton useCraft;
		private JRadioButton useSmith;
		private JRadioButton useSummon;
		private JRadioButton chopFish;
		private JRadioButton useGrill;
		private JLabel label3;
		private JSeparator separator2;
		private JButton selectStart;
		// JFormDesigner - End of variables declaration  //GEN-END:variables
	}


}