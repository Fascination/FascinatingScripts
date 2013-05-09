package fascinatingFleshCrawler;

import java.awt.Polygon;
import java.awt.Rectangle;

import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.wrappers.Entity;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

public class Utilities {

	public static boolean isOnScreen(Entity e) {
	    WidgetChild actionbar = Widgets.get(640).getChild(3);
	    Rectangle screen = new Rectangle(0, 50, 515,
	            actionbar != null && actionbar.isOnScreen() ? 260 : 320);
	    for (Polygon p : e.getBounds()) {
	        for (int i = 0; i < p.npoints; i++) {
	            if (screen.contains(p.xpoints[i], p.ypoints[i])) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
}
