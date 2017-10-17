import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;


public class DrawGame extends JComponent {
	public void paint(Graphics g){
		Graphics2D graph = (Graphics2D)g;
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Shape drawRect = new Rectangle2D.Float(20, 20, this.getWidth() - 40, this.getHeight() - 40);
		graph.setColor(Color.blue);
		Shape circle = new Ellipse2D.Float(5, 5, 40, 40);
		graph.fill(drawRect);
		graph.draw(circle);
	}
}
