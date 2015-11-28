package grafica;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 32, height = 32;

	public static BufferedImage bomberman, sueloRoca1, muroDest, muroIndes,
			rugulo, sueloRoca2, bomba, speedUp, bombality, masacrality,
			fatality, fuego, mainMenu, jugar, volver, ayuda;
	public static BufferedImage[] player_down, player_left, player_right,
			player_up;
	public static BufferedImage[] rugulo_down, rugulo_left, rugulo_right,
			rugulo_up;
	public static BufferedImage[] altair_down, altair_left, altair_right,
			altair_up;
	public static BufferedImage[] sirius_down, sirius_left, sirius_right,
			sirius_up;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(
				ImageLoader.loadImage("/res/spritesheet.png"));
		SpriteSheet bombermanSheet = new SpriteSheet(
				ImageLoader.loadImage("/res/bomberman.png"));
		SpriteSheet ruguloSheet = new SpriteSheet(
				ImageLoader.loadImage("/res/rugulo.png"));
		SpriteSheet altairSheet = new SpriteSheet(
				ImageLoader.loadImage("/res/altair.png"));
		SpriteSheet siriusSheet = new SpriteSheet(
				ImageLoader.loadImage("/res/sirius.png"));
		SpriteSheet menu = new SpriteSheet(ImageLoader.loadImage("/res/mainMenu.png"));
		SpriteSheet jugarSS = new SpriteSheet(ImageLoader.loadImage("/res/jugar.png"));
		SpriteSheet ayudaSS = new SpriteSheet(ImageLoader.loadImage("/res/ayuda.png"));
		SpriteSheet volverSS = new SpriteSheet(ImageLoader.loadImage("/res/volver.png"));

		mainMenu = menu.crop(0, 0, 992, 446);
		jugar = jugarSS.crop(0, 0, 200, 50);
		volver = volverSS.crop(0, 0, 218, 50);
		ayuda = ayudaSS.crop(0, 0, 200, 50);
				
		player_down = new BufferedImage[3];
		player_down[0] = bombermanSheet.crop(0 * width, 0 * height, width,
				height);
		player_down[1] = bombermanSheet.crop(1 * width, 0 * height, width,
				height);
		player_down[2] = bombermanSheet.crop(2 * width, 0 * height, width,
				height);

		player_left = new BufferedImage[3];
		player_left[0] = bombermanSheet.crop(0 * width, 1 * height, width,
				height);
		player_left[1] = bombermanSheet.crop(1 * width, 1 * height, width,
				height);
		player_left[2] = bombermanSheet.crop(2 * width, 1 * height, width,
				height);

		player_right = new BufferedImage[3];
		player_right[0] = bombermanSheet.crop(0 * width, 2 * height, width,
				height);
		player_right[1] = bombermanSheet.crop(1 * width, 2 * height, width,
				height);
		player_right[2] = bombermanSheet.crop(2 * width, 2 * height, width,
				height);

		player_up = new BufferedImage[3];
		player_up[0] = bombermanSheet
				.crop(0 * width, 3 * height, width, height);
		player_up[1] = bombermanSheet
				.crop(1 * width, 3 * height, width, height);
		player_up[2] = bombermanSheet
				.crop(2 * width, 3 * height, width, height);

		rugulo_down = new BufferedImage[3];
		rugulo_down[0] = ruguloSheet.crop(0 * width, 0 * height, width, height);
		rugulo_down[1] = ruguloSheet.crop(1 * width, 0 * height, width, height);
		rugulo_down[2] = ruguloSheet.crop(2 * width, 0 * height, width, height);

		rugulo_left = new BufferedImage[3];
		rugulo_left[0] = ruguloSheet.crop(0 * width, 1 * height, width, height);
		rugulo_left[1] = ruguloSheet.crop(1 * width, 1 * height, width, height);
		rugulo_left[2] = ruguloSheet.crop(2 * width, 1 * height, width, height);

		rugulo_right = new BufferedImage[3];
		rugulo_right[0] = ruguloSheet
				.crop(0 * width, 2 * height, width, height);
		rugulo_right[1] = ruguloSheet
				.crop(1 * width, 2 * height, width, height);
		rugulo_right[2] = ruguloSheet
				.crop(2 * width, 2 * height, width, height);

		rugulo_up = new BufferedImage[3];
		rugulo_up[0] = ruguloSheet.crop(0 * width, 3 * height, width, height);
		rugulo_up[1] = ruguloSheet.crop(1 * width, 3 * height, width, height);
		rugulo_up[2] = ruguloSheet.crop(2 * width, 3 * height, width, height);

		altair_down = new BufferedImage[3];
		altair_down[0] = altairSheet.crop(0 * width, 0 * height, width, height);
		altair_down[1] = altairSheet.crop(1 * width, 0 * height, width, height);
		altair_down[2] = altairSheet.crop(2 * width, 0 * height, width, height);

		altair_left = new BufferedImage[3];
		altair_left[0] = altairSheet.crop(0 * width, 1 * height, width, height);
		altair_left[1] = altairSheet.crop(1 * width, 1 * height, width, height);
		altair_left[2] = altairSheet.crop(2 * width, 1 * height, width, height);

		altair_right = new BufferedImage[3];
		altair_right[0] = altairSheet
				.crop(0 * width, 2 * height, width, height);
		altair_right[1] = altairSheet
				.crop(1 * width, 2 * height, width, height);
		altair_right[2] = altairSheet
				.crop(2 * width, 2 * height, width, height);

		altair_up = new BufferedImage[3];
		altair_up[0] = altairSheet.crop(0 * width, 3 * height, width, height);
		altair_up[1] = altairSheet.crop(1 * width, 3 * height, width, height);
		altair_up[2] = altairSheet.crop(2 * width, 3 * height, width, height);

		sirius_down = new BufferedImage[3];
		sirius_down[0] = siriusSheet.crop(0 * width, 0 * height, width, height);
		sirius_down[1] = siriusSheet.crop(1 * width, 0 * height, width, height);
		sirius_down[2] = siriusSheet.crop(2 * width, 0 * height, width, height);

		sirius_left = new BufferedImage[3];
		sirius_left[0] = siriusSheet.crop(0 * width, 1 * height, width, height);
		sirius_left[1] = siriusSheet.crop(1 * width, 1 * height, width, height);
		sirius_left[2] = siriusSheet.crop(2 * width, 1 * height, width, height);

		sirius_right = new BufferedImage[3];
		sirius_right[0] = siriusSheet
				.crop(0 * width, 2 * height, width, height);
		sirius_right[1] = siriusSheet
				.crop(1 * width, 2 * height, width, height);
		sirius_right[2] = siriusSheet
				.crop(2 * width, 2 * height, width, height);

		sirius_up = new BufferedImage[3];
		sirius_up[0] = siriusSheet.crop(0 * width, 3 * height, width, height);
		sirius_up[1] = siriusSheet.crop(1 * width, 3 * height, width, height);
		sirius_up[2] = siriusSheet.crop(2 * width, 3 * height, width, height);

		fuego = sheet.crop(3 * width, 0 * height, width, height);
		sueloRoca1 = sheet.crop(3 * width, 1 * height, width, height);
		sueloRoca2 = sheet.crop(4 * width, 1 * height, width, height);
		muroDest = sheet.crop(4 * width, 0, width, height);
		muroIndes = sheet.crop(1 * width, 1 * height, width, height);
		bomba = sheet.crop(1 * width, 0 * height, width, height);
		speedUp = sheet.crop(2 * width, 1 * height, width, height);
		bombality = sheet.crop(2 * width, 0 * height, width, height);
		masacrality = sheet.crop(0 * width, 0 * height, width, height);
		fatality = sheet.crop(0 * width, 1 * height, width, height);
	}
}
