	package fascinatingMagician;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.GeneralPath;

import javax.imageio.ImageIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;

import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Environment;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.node.Item;



import fascinatingMagician.Alcher.misc.Methods;
import fascinatingMagician.Alcher.nodes.BankNode;
import fascinatingMagician.Alcher.nodes.HighAlch;
import fascinatingMagician.Enchantment.nodes.Amulets.amuletBanker;
import fascinatingMagician.Enchantment.nodes.Amulets.diaAmulet;
import fascinatingMagician.Enchantment.nodes.Amulets.draAmulet;
import fascinatingMagician.Enchantment.nodes.Amulets.emeAmulet;
import fascinatingMagician.Enchantment.nodes.Amulets.onyAmulet;
import fascinatingMagician.Enchantment.nodes.Amulets.rubAmulet;
import fascinatingMagician.Enchantment.nodes.Amulets.sapAmulet;
import fascinatingMagician.Enchantment.nodes.Bracelet.braceBanker;
import fascinatingMagician.Enchantment.nodes.Bracelet.diaBracelet;
import fascinatingMagician.Enchantment.nodes.Bracelet.draBracelet;
import fascinatingMagician.Enchantment.nodes.Bracelet.emeBracelet;
import fascinatingMagician.Enchantment.nodes.Bracelet.onyBracelet;
import fascinatingMagician.Enchantment.nodes.Bracelet.rubBracelet;
import fascinatingMagician.Enchantment.nodes.Bracelet.sapBracelet;
import fascinatingMagician.Enchantment.nodes.Necklace.diaNecklace;
import fascinatingMagician.Enchantment.nodes.Necklace.draNecklace;
import fascinatingMagician.Enchantment.nodes.Necklace.emeNecklace;
import fascinatingMagician.Enchantment.nodes.Necklace.neckBanker;
import fascinatingMagician.Enchantment.nodes.Necklace.onyNecklace;
import fascinatingMagician.Enchantment.nodes.Necklace.rubNecklace;
import fascinatingMagician.Enchantment.nodes.Necklace.sapNecklace;
import fascinatingMagician.Enchantment.nodes.Rings.diaRing;
import fascinatingMagician.Enchantment.nodes.Rings.draRing;
import fascinatingMagician.Enchantment.nodes.Rings.emeRing;
import fascinatingMagician.Enchantment.nodes.Rings.onyRing;
import fascinatingMagician.Enchantment.nodes.Rings.ringBanker;
import fascinatingMagician.Enchantment.nodes.Rings.rubRing;
import fascinatingMagician.Enchantment.nodes.Rings.sapRing;
import fascinatingMagician.PlankMake.CastPlankMake;
import fascinatingMagician.PlankMake.BankPlanks.CloseBank;
import fascinatingMagician.PlankMake.BankPlanks.withdrawPlanks;
import fascinatingMagician.teleporting.Teleporter;

@Manifest(authors = { "Fascination" }, name = "[v0.2] Fascinating AIO Magic", description = "Alch. Teleport. Enchant. Humidify. Stun. ANYTIME. ANYWHERE.")
public class FascinatingMagic extends ActiveScript implements PaintListener, MouseListener{

		public static int timerun = 0;
		public static int xp = 0;
		public static int levels = 0;
	
private final Node[] array = new Node[] { 
		//Alching nodes + Teleport
		new HighAlch(), new BankNode(), new Teleporter(),
		
	//Enchantment nodes.. 	
new amuletBanker(), new diaAmulet(), new draAmulet(), new emeAmulet(), new onyAmulet(), new rubAmulet(), new sapAmulet(),
new braceBanker(), new diaBracelet(), new draBracelet(), new emeBracelet(), new onyBracelet(), new rubBracelet(), new sapBracelet(),
new diaNecklace(), new draNecklace(), new emeNecklace(), new neckBanker(), new onyNecklace(), new rubNecklace(), new sapNecklace(),
new diaRing(), new draRing(), new emeRing(), new onyRing(), new ringBanker(), new rubRing(), new sapRing()
		
	//Gatestone 
		,
		
	//Plank make 
		new withdrawPlanks(), new CastPlankMake(), new CloseBank()}; //add classes here

/**
 * Submit data to the database.
 * 
 * @param scriptname : The name of the script submitting.
 * @param everyone : Submit for the "Everyone" signature.
 * @param data : The line of data submission,
 * 
 * for example:
 * 
 * &runtime=0&xp=0&logs=0&profit=0
 */
public static void submitData(String scriptname, boolean everyone,
		String data) {
	try {
		URL submit = new URL("http://fascinatingmagic.comlu.com/" + scriptname
				+ "/submitdata.php?user="
				+ Environment.getDisplayName() + data);
		URLConnection con = submit.openConnection();
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false);
		final BufferedReader rd = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			if (line.toLowerCase().contains("success")) {
				System.out.println("Successfully updated your signature");
			} else if (line.toLowerCase().contains("fuck off")) {
				System.out.println("Something fucked up, couldn't update");
			}
		}
		rd.close();
	} catch (Exception e) {
		e.printStackTrace();
	}

	if (everyone) {
		try {
			URL submit = new URL("http://fascinatingmagic.comlu.com/" + scriptname
					+ "/submitdata.php?user=" + "Everyone" + data);
			URLConnection con = submit.openConnection();
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false);
			final BufferedReader rd = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				if (line.toLowerCase().contains("success")) {
					System.out
							.println("Successfully updated the 'Everyone' signature");
				} else if (line.toLowerCase().contains("fuck off")) {
					System.out
							.println("Something fucked up, couldn't update");
				}
			}
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public static void submitData(){
	
	
	URL url;
	if(Variables.runtime < 93600) {
		try {
			url = new URL("http://fascinatingmagic.comlu.com/submitdata.php?user=" +Environment.getDisplayName()+"&Run_Time="+Variables.runtime+"&Experience="+Variables.expGained+ "&levels=" + levels);
			URLConnection con = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
		} 
		catch (IOException e) {
			System.out.println("Error"); 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else {
		System.out.println("Not sending data. Time was messed up"); 
	}
	
	
}


public void onStop() {
	submitData();
	//submitData("aiomagic", true, "&timerun=" + Variables.runTime + "&xp=" + Variables.expGained + "&levels=" + levels);

}
	
	@Override
    public int loop() {

            for (final Node node : array) {
                    if (node.activate()) {
                            node.execute();
                    }
            }
            return Random.nextInt(10, 50);
    }
	
	public void onStart(){
		initiateGUI();
	}
	
	
	public void initiateGUI() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				final GUI gui = new GUI();
				gui.setVisible(true);
				gui.setResizable(false);
			}
		});

	}

	  //START: Code generated using Enfilade's Easel
    private Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch(IOException e) {
            return null;
        }
    }

    private final Color color1 = new Color(0, 0, 0, 90);
    private final Color color2 = new Color(102, 102, 102);
    private final Color color3 = new Color(255, 255, 255);

    private final BasicStroke stroke1 = new BasicStroke(1);

    private final Font font1 = new Font("Arial", 0, 11);

    private final Image img1 = getImage("http://i.imgur.com/QXhT1Me.png"); //plank
    private final Image img2 = getImage("http://i.imgur.com/OwASLJQ.png"); //top nav bar
    private final Image img3 = getImage("http://i.imgur.com/AhMIiX5.png"); // alch
    private final Image img4 = getImage("http://i.imgur.com/MVHaowl.png"); //enchant
    private final Image img5 = getImage("http://i.imgur.com/HxIihce.png"); //tele

    final LinkedList<MousePathPoint> mousePath = new LinkedList<MousePathPoint>();


    @SuppressWarnings("serial")
    public class MousePathPoint extends Point {
    	private long finishTime;
    	@SuppressWarnings("unused")
    	private double lastingTime;

    	@SuppressWarnings("unused")
    	private int toColor(double d) {
    		return Math.min(255, Math.max(0, (int) d));
    	}

    	public MousePathPoint(int x, int y, int lastingTime) {
    		super(x, y);
    		this.lastingTime = lastingTime;
    		finishTime = System.currentTimeMillis() + lastingTime;
    	}

    	public boolean isUp() {
    		return System.currentTimeMillis() > finishTime;
    	}
    }

    @SuppressWarnings("unused")
    private GeneralPath pathFrom(int[] xs, int[] ys) {
    	GeneralPath gp = new GeneralPath();
    	gp.moveTo(xs[0], ys[0]);
    	for (int i = 1; i < xs.length; i++)
    		gp.lineTo(xs[i], ys[i]);
    	gp.closePath();
    	return gp;
    }
    
    final Item item = Inventory.getItem(Variables.idToAlch);
    
    public void onRepaint(Graphics g1) {
    	
    	final RenderingHints antialiasing = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		((Graphics2D) g1).setRenderingHints(antialiasing);
		Graphics2D spinner = (Graphics2D) g1.create();
		spinner.setColor(Color.BLUE); // you can change ur color (e.g.
										// CYAN, WHITE)
		spinner.rotate(System.currentTimeMillis() % 2000d / 2000d * (-360d)
				* 2 * Math.PI / 180.0, Mouse.getX(), Mouse.getY());
		spinner.drawLine(Mouse.getX() - 8, Mouse.getY(), Mouse.getX() + 8,
				Mouse.getY());
		spinner.drawLine(Mouse.getX(), Mouse.getY() - 8, Mouse.getX(),
				Mouse.getY() + 8);
		while (!mousePath.isEmpty() && mousePath.peek().isUp())
			mousePath.remove();
		Point clientCursor = Mouse.getLocation();
		MousePathPoint mpp = new MousePathPoint(clientCursor.x,
				clientCursor.y, 300);
		if (mousePath.isEmpty() || !mousePath.getLast().equals(mpp))
			mousePath.add(mpp);
		MousePathPoint lastPoint = null;
		for (MousePathPoint a : mousePath) {
			if (lastPoint != null) {
				g1.drawLine(a.x, a.y, lastPoint.x, lastPoint.y);
			}
			lastPoint = a;
		}
    	
    if(Variables.plankmake){
    	if(!Variables.hide){
        Graphics2D g = (Graphics2D)g1;
        g.drawImage(img1, -10, 338, null);
        g.drawImage(img2, 25, 1, null);
        g.setColor(color1);
        g.fillRect(486, 396, 39, 26);
        g.setColor(color2);
        g.setStroke(stroke1);
        //g.drawRect(486, 396, 39, 26);
        g.setFont(font1);
        g.setColor(color3);
        g.drawString("" + Variables.logsCasted, 129, 431);
        g.drawString("Plank Make", 323, 433);
        g.drawString("" + Variables.expGained, 127, 456);
        g.drawString("lvlsGained", 127, 482);
        g.drawString("Profit", 325, 457);
        g.drawString("" + Variables.status, 326, 482);
        g.drawString("" + Variables.timeRunning.toElapsedString(), 170, 28);
        g.drawString("" + "v0.1", 393, 28);
        g.drawString("" + Environment.getDisplayName(), 561, 28);
    	} else if (Variables.hide){
        	Graphics2D g = (Graphics2D)g1;
        	g.drawImage(img2, 25, 1, null);
        	g.setFont(font1);
        	g.drawRect(486, 396, 39, 26);
        	g.drawString("Show", 494, 410);
        	g.drawString("" + Variables.timeRunning.toElapsedString(), 170, 28);
            g.drawString("" + "v0.1", 393, 28);
            g.drawString("" + Environment.getDisplayName(), 561, 28);
        }
    } else if (Variables.HighAlch){
    	Graphics2D g = (Graphics2D)g1;
        g.drawImage(img3, -10, 338, null);
        g.drawImage(img2, 25, 1, null);
        g.setColor(color1);
        g.fillRect(486, 396, 39, 26);
        g.setColor(color2);
        g.setStroke(stroke1);
        g.drawRect(486, 396, 39, 26);
        g.setFont(font1);
        g.setColor(color3);
        g.drawString("" + Variables.alched, 129, 431);
        g.drawString("High/Low Alch", 323, 433);
        g.drawString("" + Variables.expGained, 127, 456);
        g.drawString("lvlsGained", 127, 482);
        g.drawString("Profit", 325, 457);
        g.drawString("" + Variables.status, 326, 482);
        g.drawString("" + Variables.timeRunning.toElapsedString(), 170, 28);
        g.drawString("" + "v0.1", 393, 28);
        g.drawString("" + Environment.getDisplayName(), 561, 28);

    }
    
   
    //END: Code generated using Enfilade's Easel
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		final Rectangle hide = new Rectangle(486, 396, 39, 26);
		if(hide.contains(e.getPoint()) && !Variables.hide){
			Variables.hide = true;
		} else if (hide.contains(e.getPoint()) && Variables.hide){
			Variables.hide = false;
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}