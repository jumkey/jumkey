
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.PixelGrabber;

import javax.swing.ImageIcon;

public class ImageHelper {
	final public static int GEOMETRIC_SCALING_NONE = -1;
	final public static int GEOMETRIC_SCALING_AUTO = 0;
	final public static int GEOMETRIC_SCALING_X = 1;
	final public static int GEOMETRIC_SCALING_Y = 2;

	/**
	 * change ImageIcon to BufferedImage
	 * 
	 * @param icon
	 * @param width
	 * @param height
	 * @return
	 */
	final public static BufferedImage toBufferedImage(ImageIcon icon,
			int width, int height) {
		ImageObserver observer = icon.getImageObserver();
		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics gc = bufferedImage.createGraphics();
		gc.drawImage(icon.getImage(), 0, 0, observer);
		return bufferedImage;
	}

	/**
	 * change ImageIcon to BufferedImage
	 * 
	 * @param icon
	 * @return
	 */
	final public static BufferedImage toBufferedImage(ImageIcon icon) {
		return toBufferedImage(icon, icon.getIconWidth(), icon.getIconHeight());
	}

	/**
	 * 
	 * @param source
	 * @param targetWidth
	 * @param targetHeight
	 * @param geometricScaling
	 * @return
	 */
	final public static BufferedImage scale(BufferedImage source,
			int targetWidth, int targetHeight, int geometricScaling) {
		if (source == null) {
			return null;
		}
		double sx = (double) targetWidth / source.getWidth();
		double sy = (double) targetHeight / source.getHeight();
		if (geometricScaling != GEOMETRIC_SCALING_NONE) {
			if (geometricScaling == GEOMETRIC_SCALING_AUTO) {
				if (sx < sy) {
					sx = sy;
					targetWidth = (int) (sx * source.getWidth());
				} else {
					sy = sx;
					targetHeight = (int) (sy * source.getHeight());
				}
			} else if (geometricScaling == GEOMETRIC_SCALING_X) {
				// X
				sy = sx;
				targetHeight = (int) (sy * source.getHeight());
			} else if (geometricScaling == GEOMETRIC_SCALING_Y) {
				// Y
				sx = sy;
				targetWidth = (int) (sx * source.getWidth());
			}
		}
		BufferedImage target = new BufferedImage(targetWidth, targetHeight,
				source.getType());
		target.getGraphics().drawImage(
				source.getScaledInstance(targetWidth, targetHeight,
						Image.SCALE_SMOOTH), 0, 0, null);
		return target;
	}

	// This method returns a buffered image with the contents of an image
	public static BufferedImage toBufferedImage(Image image) {
		if (image instanceof BufferedImage) {
			return (BufferedImage) image;
		}

		// This code ensures that all the pixels in the image are loaded
		image = new ImageIcon(image).getImage();

		// Determine if the image has transparent pixels; for this method's
		// implementation, see e661 Determining If an Image Has Transparent
		// Pixels
		boolean hasAlpha = hasAlpha(image);

		// Create a buffered image with a format that's compatible with the
		// screen
		BufferedImage bimage = null;
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		try {
			// Determine the type of transparency of the new buffered image
			int transparency = Transparency.OPAQUE;
			if (hasAlpha) {
				transparency = Transparency.BITMASK;
			}

			// Create the buffered image
			GraphicsDevice gs = ge.getDefaultScreenDevice();
			GraphicsConfiguration gc = gs.getDefaultConfiguration();
			bimage = gc.createCompatibleImage(image.getWidth(null), image
					.getHeight(null), transparency);
		} catch (HeadlessException e) {
			// The system does not have a screen
		}

		if (bimage == null) {
			// Create a buffered image using the default color model
			int type = BufferedImage.TYPE_INT_RGB;
			if (hasAlpha) {
				type = BufferedImage.TYPE_INT_ARGB;
			}
			bimage = new BufferedImage(image.getWidth(null), image
					.getHeight(null), type);
		}

		// Copy image to buffered image
		Graphics g = bimage.createGraphics();

		// Paint the image onto the buffered image
		g.drawImage(image, 0, 0, null);
		g.dispose();

		return bimage;
	}

	// Determining If an Image Has Transparent Pixels

	// This method returns true if the specified image has transparent pixels
	public static boolean hasAlpha(Image image) {
		// If buffered image, the color model is readily available
		if (image instanceof BufferedImage) {
			BufferedImage bimage = (BufferedImage) image;
			return bimage.getColorModel().hasAlpha();
		}

		// Use a pixel grabber to retrieve the image's color model;
		// grabbing a single pixel is usually sufficient
		PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
		try {
			pg.grabPixels();
		} catch (InterruptedException e) {
		}

		// Get the image's color model
		ColorModel cm = pg.getColorModel();
		return cm.hasAlpha();
	}
}
