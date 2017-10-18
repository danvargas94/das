import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Tile represent each space of the board, the board has 42 tiles
 * The default image of the Tile is BLUE.png
 * @author danielavargas
 *
 */
public class Tile extends JPanel{
	
	protected int x, y, width, height, posx, posy;
    protected ImageIcon image;
    ImageIcon im = new ImageIcon(Imagenes.Singleton().imagen("BLUE.png"));
    
    /**
     * Constructs and initializes a tile
     * @param x row number
     * @param y column number
     * @param width size 
     */
    public Tile(int x, int y, int width){
        super();
        this.image = im;
        this.width = width;
        this.height = width;
        this.setBounds(x, y, width, height);
    }
    
    /**
     * Restores the image to BLUE.png
     */
    public void restartTile(){
    	this.image = im;
    }
    
    /**
     * Determines the image of the tile
     * @return ImageIcon
     */
    public ImageIcon getImage() {
        return image;
    }
    
    /**
     * Set the tile image
     * @param image
     */
    public void setImage(ImageIcon image) {
        this.image = image;
    }
}
