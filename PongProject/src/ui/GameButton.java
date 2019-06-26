package ui;

import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

public abstract class GameButton {
	
	private static final int BORDER_SPACING = 8;
	
	private String buttonText;
	private Font font;
	private int x, y;
	//Used for text display
	private int textX, textY;
	private int textWidth, textHeight;
	//Used for collision detection
	private int rectX, rectY;
	private int rectWidth, rectHeight;
	//Holds whether or not the border is visible
	private boolean isBorderVisible;
	
	/**
	 * The constructor for a game button
	 * @param _buttonText The text being displayed
	 * @param _x The x position of the middle of the button
	 * @param _y The y position of the middle of the button
	 * @param _font The desired font being used
	 */
	public GameButton(String _buttonText, int _x, int _y, int _fontSize)
	{
		buttonText = _buttonText;
		font = new Font(Font.MONOSPACED, Font.BOLD, _fontSize);
		
		x = _x;
		y = _y;
		
		//Gets the text width and height
		AffineTransform affinetransform = new AffineTransform();     
		FontRenderContext frc = new FontRenderContext(affinetransform,true,true); 
		textWidth = (int)(font.getStringBounds(_buttonText, frc).getWidth());
		textHeight = (int)(font.getStringBounds(_buttonText, frc).getHeight());
		
		textX = _x - (textWidth / 2);
		textY = _y + (textHeight / 2);
		
		//Gets collision rectangle variables
		rectX = _x - (textWidth / 2) - BORDER_SPACING;
		rectY = _y;
		
		rectWidth = textWidth + (BORDER_SPACING * 2);
		rectHeight = (textHeight / 2) + BORDER_SPACING;
		
		isBorderVisible = false;
	}
	
	public abstract void onClick();
	
	/**
	 * Checks if rectangle is colliding with point
	 * @param _x The x position of the point
	 * @param _y The y position of the point
	 * @return Returns true if the point is within the bounds of the rectangle
	 */
	public boolean isColliding(int _x, int _y)
	{
		return this.getRectangle().contains(new Point(_x, _y));
	}
	
	//Getters
	public String getButtonText() { return buttonText; }
	public int getX() { return x; }
	public int getY() { return y; }
	public int getRectX() { return rectX; }
	public int getRectY() { return rectY; }
	public int getRectWidth() { return rectWidth; }
	public int getRectHeight() { return rectHeight; }
	public int getTextX() { return textX; }
	public int getTextY() { return textY; }
	public int getTextWidth() { return textWidth; }
	public int getTextHeight() { return textHeight; }
	
	public Font getFont() { return font; }
	public Rectangle getRectangle() { return new Rectangle(rectX, rectY, rectWidth, rectHeight); }
	
	public boolean isBorderVisible() { return isBorderVisible; }
	
	public static int getBorderSpacing() { return BORDER_SPACING; }
	
	public void setBorderVisible(boolean _isBorderVisible) { isBorderVisible = _isBorderVisible; }
}
