//Credits to Igniter

import java.text.DecimalFormat;
import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.node.SceneObject;
import org.powerbot.game.api.wrappers.widget.WidgetChild;
import org.powerbot.game.bot.event.listener.PaintListener;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

@Manifest(authors = { "Fascination" }, name = "FFBarbarianKiller", description = "Kills Barbarians for exp", version = 1.0)
public class FFBarbarianKiller extends ActiveScript implements PaintListener {
	Area areaExper = new Area(new Tile(3075, 3445, 0), new Tile(3082, 3436, 0));

	private final static int[] BARB_IDs = { 3246, 3248, 3249, 3253, 3259 };

	public static final boolean startScript = false;
	private static int[] FOOD_IDs = { 333, 351, 329, 361, 379, 365, 373, 7946,
			385, 697, 391, 15272 };

	NPC Barb;

	public long startTime = 0;
	public long millis = 0;
	public long hours = 0;
	public long minutes = 0;
	public long seconds = 0;
	private static int startXPStrength;
	private static int startXPAttack;
	private static int startXPDefense;
	private static int startXPRange;
	private static int startXPHP;
	public String Status;

	@Override
	protected void setup() {
		Status = "Starting Up";
		startTime = System.currentTimeMillis();
		startXPStrength = Skills.getExperience(Skills.STRENGTH);
		startXPAttack = Skills.getExperience(Skills.ATTACK);
		startXPDefense = Skills.getExperience(Skills.DEFENSE);
		startXPRange = Skills.getExperience(Skills.RANGE);
		startXPHP = Skills.getExperience(Skills.CONSTITUTION);
		provide(new Eat());
		provide(new WalkBank());
		provide(new Antiban());
		provide(new Attack());
	}

	private int getPerHour(final long value) {
		return (int) (value * 3600000D / (System.currentTimeMillis() - startTime));
	}

	private final DecimalFormat df = new DecimalFormat("###,###,###,###");

	/*
	 * AntiBan
	 */
	public class Antiban extends Strategy implements Task {

		private Timer antiBanTimer;

		private int minTime = (20 * 1000);
		private int maxTime = (180 * 1000);

		public Antiban() {
			antiBanTimer = new Timer(Random.nextInt(minTime, maxTime));
		}

		@Override
		public void run() {
			int whatdo = Random.nextInt(0, 1);
			switch (whatdo) {

			case 0:
				int randomSkill = Random.nextInt(0, 24);
				Tabs.STATS.open();
				WidgetChild randStat = Skills.getWidgetChild(randomSkill);
				Point randStatPoint = randStat.getAbsoluteLocation();
				randStatPoint.x += Random.nextInt(-5, 10);
				randStatPoint.y += Random.nextInt(-5, 10);
				Mouse.move(randStatPoint);

			case 1:
				Status = "Doing Antiban";
				Tabs.FRIENDS.open();
				Time.sleep(2000, 3000);
				Tabs.INVENTORY.open();
				Time.sleep(100, 900);

			case 2:
				if (Players.getLocal().getInteracting() != null) {
					Camera.turnTo(Players.getLocal().getInteracting());
					int CurrentPitch = Camera.getPitch();
					int CurrentYaw = Camera.getYaw();
					Status = "Doing Antiban";
					Camera.setPitch(CurrentPitch + Random.nextInt(-13, 13));
					Camera.setAngle(CurrentYaw + Random.nextInt(-25, 25));

				}
			case 3:

				Status = "Doing Antiban";
				Mouse.move(Barb.getCentralPoint());
				Time.sleep(Random.nextInt(1000, 5000));
				break;

			case 4:
				if (Players.getLocal().getAnimation() == -1) {
					Barb.interact("Examine");
					Status = "Doing Antiban";
				}

			default:
				int CurrentPitch = Camera.getPitch();
				int CurrentYaw = Camera.getYaw();
				Status = "Doing Antiban";
				Camera.setPitch(CurrentPitch + Random.nextInt(-50, 50));
				Camera.setAngle(CurrentYaw + Random.nextInt(-70, 70));

			}

			resetAntiBanTime();
		}

		@Override
		public boolean validate() {
			return startScript && !antiBanTimer.isRunning();
		}

		private void resetAntiBanTime() {
			antiBanTimer.setEndIn(Random.nextInt(minTime, maxTime));
		}
	}

	public class Attack extends Strategy implements Task {
		@Override
		public void run() {
			Inventory.getItem(FOOD_IDs);
			{
				int openDoor = 11620;
				int closedDoor = 11624;
				Tile tile = new Tile(3079, 3435, 0);

				for (SceneObject door : SceneEntities.getLoaded(tile)) {
					if (door.getId() == openDoor) {
						Status = "Opening door";
						door.interact("Open");
						Time.sleep(300, 700);
					} else if (door.getId() == closedDoor) {
					} else {
					}
				}
				NPC Barbarian = NPCs.getNearest(new Filter<NPC>() {
					public boolean accept(NPC n) {
						return (n.getId() == BARB_IDs[0])
								|| (n.getId() == BARB_IDs[1])
								|| (n.getId() == BARB_IDs[2])
								|| (n.getId() == BARB_IDs[3])
								|| (n.getId() == BARB_IDs[4]);
					}
				});
				if (Players.getLocal().getInteracting() != Barbarian) {
					if (Barbarian.validate()) {
						if (Barbarian.isOnScreen()) {
							if (!Barbarian.isInCombat()) {
								Status = "Attacking Barbarian";
								Barbarian.interact("Attack");
								Time.sleep(2000, 2200);
							}
							if (Barbarian.isInCombat()) {
								Time.sleep(200, 300);
							}
						}
						if (!Barbarian.isOnScreen()) {
							Camera.turnTo(Barbarian);
						}
					}
					if (!Barbarian.validate()) {
						Time.sleep(700, 1000);
						{
						}
					}
					if (FOOD_IDs == null)
						;
					{
						Time.sleep(15000, 20000);
						{
						}
					}
				}
			}
		}

		@Override
		public boolean validate() {
			return !Players.getLocal().isInCombat();
		}
	}

	// Eats
	public class Eat extends Strategy implements Task {

		@Override
		public void run() {
			if (Players.getLocal().getHpPercent() < 100) {
				if (Tabs.getCurrent() == Tabs.INVENTORY) {

					Inventory.getItem(FOOD_IDs).getWidgetChild()
							.interact("Eat");
					Status = "Eating";
					Time.sleep(1500);
				}
			}
			if (Tabs.getCurrent() != Tabs.INVENTORY) {
				Tabs.INVENTORY.open();
			}

		}

		@Override
		public boolean validate() {

			return Inventory.getItem(FOOD_IDs) != null;
		}

	}

	// Walks to Bank Class
	public class WalkBank extends Strategy implements Task {
		@Override
		public void run() {

			Status = "Walking to Bank";
			Inventory.getItem(FOOD_IDs);
			{
				Walking.newTilePath(PathToBank).traverse();
			}
		}

		public final Tile[] PathToBank = { new Tile(3078, 3440, 0),
				new Tile(3078, 3433, 0), new Tile(3073, 3435, 0),
				new Tile(3073, 3440, 0), new Tile(3070, 3445, 0),
				new Tile(3071, 3454, 0), new Tile(3071, 3464, 0),
				new Tile(3072, 3475, 0), new Tile(3072, 3482, 0),
				new Tile(3073, 3489, 0), new Tile(3082, 3483, 0),
				new Tile(3086, 3489, 0), new Tile(3093, 3491, 0) };

		@Override
		public boolean validate() {

			return Inventory.getItem(FOOD_IDs) == null;
		}

	}

	// Paint
	private final RenderingHints antialiasing = new RenderingHints(
			RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	private Image getImage(String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch (IOException e) {
			return null;
		}
	}

	private final Color color1 = new Color(226, 147, 74);
	private final Font font1 = new Font("Calibri", 0, 17);
	private final Image img1 = getImage("http://i46.tinypic.com/2j0kp61.png");
	private final Image img2 = getImage("http://i46.tinypic.com/ek3tlj.png");
	private int mouseX;
	private int mouseY;
	private int xpGainedStrength;
	private int xpGainedAttack;
	private int xpGainedDefense;
	private int xpGainedRange;
	private int xpGainedHP;
	private String xpPH;

	public void onRepaint(Graphics g1) {
		xpPH = df.format(getPerHour(xpGainedStrength + xpGainedAttack
				+ xpGainedDefense + xpGainedRange + xpGainedHP));
		xpGainedStrength = Skills.getExperience(Skills.STRENGTH)
				- startXPStrength;
		xpGainedAttack = Skills.getExperience(Skills.ATTACK) - startXPAttack;
		xpGainedDefense = Skills.getExperience(Skills.DEFENSE) - startXPDefense;
		xpGainedRange = Skills.getExperience(Skills.RANGE) - startXPRange;
		xpGainedHP = Skills.getExperience(Skills.CONSTITUTION) - startXPHP;
		long millis = System.currentTimeMillis() - startTime;
		long hours = millis / (1000 * 60 * 60);
		millis -= hours * (1000 * 60 * 60);
		long minutes = millis / (1000 * 60);
		millis -= minutes * (1000 * 60);
		long seconds = millis / 1000;

		mouseX = Mouse.getX();
		mouseY = Mouse.getY();
		Graphics2D g = (Graphics2D) g1;
		g.setRenderingHints(antialiasing);
		g.drawImage(img1, 2, 330, null);
		g.setFont(font1);
		g.setColor(color1);
		g.drawString("Strength:" + xpGainedStrength, 310, 421);
		g.drawString("Attack:" + xpGainedAttack, 310, 444);
		g.drawString("Defense:" + xpGainedDefense, 310, 466);
		g.drawString("Range:" + xpGainedRange, 310, 487);
		g.drawString("Constitution:" + xpGainedHP, 310, 509);
		g.drawString("Run Time:" + hours + ":" + minutes + ":" + seconds, 118,
				475);
		g.drawString("XP P/H:" + xpPH, 118, 449);
		g.drawString("Status:" + Status, 118, 423);
		g.drawImage(img2, mouseX, mouseY, null);
	}

}