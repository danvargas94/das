import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Tile extends JPanel{
	
	protected int x, y, width, height, posx, posy;
    protected ImageIcon image;
    ImageIcon im = new ImageIcon(Imagenes.Singleton().imagen("BLUE.png"));
    
    public Tile(int x, int y, int width){
        super();
        this.image = im;
        this.width = width;
        this.height = width;
        this.setBounds(x, y, width, height);
    }
    
    public void restartTile(){
    	this.image = im;
    }
    
    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
}
