package template;

import java.awt.*;
import java.util.LinkedList;

public class SquareGradient extends Figure {
    private int size;
    private Color color;
    private Color[] colors;
    private LinkedList<Color> colorsId;
    private int indexColor = 0;
    private DrawingPanel panelTwo;
    private int cX;
    private int cY;
    private long lastShadowTime;

    public SquareGradient(int x, int y, DrawingPanel panel) {
        super(x, y, panel);
        this.size = 35;
        this.colors = createGradientColors();
        cX = x;
        cY = y;
        lastShadowTime = System.currentTimeMillis();
        this.panelTwo = panel;
    }

    private Color[] createGradientColors() {
        Color[] colorsTwo = new Color[26];
        colorsTwo[0] = new Color(143, 220, 31);
        colorsTwo[1] = new Color(190, 242, 10);
        colorsTwo[2] = new Color(239, 242, 10);
        colorsTwo[3] = new Color(239, 200, 10);
        colorsTwo[4] = new Color(239, 179, 10);
        colorsTwo[5] = new Color(242, 158, 10);
        colorsTwo[6] = new Color(242, 101, 10);
        colorsTwo[7] = new Color(242, 70, 10);
        colorsTwo[8] = new Color(242, 43, 10);
        colorsTwo[9] = new Color(242, 11, 28);
        colorsTwo[10] = new Color(242, 10, 109);
        colorsTwo[11] = new Color(242, 10, 201);
        colorsTwo[12] = new Color(223, 10, 142);
        colorsTwo[13] = new Color(201, 10, 242);
        colorsTwo[14] = new Color(174, 10, 242);
        colorsTwo[15] = new Color(130, 10, 242);
        colorsTwo[16] = new Color(65, 10, 242);
        colorsTwo[17] = new Color(12, 18, 242);
        colorsTwo[18] = new Color(10, 98, 242);
        colorsTwo[19] =  new Color(10, 158, 242);
        colorsTwo[20] = new Color(10, 196, 242);
        colorsTwo[21] = new Color(10, 242, 239);
        colorsTwo[22] = new Color(10, 242, 196);
        colorsTwo[23] = new Color(10, 242, 125);
        colorsTwo[24] = new Color(10, 242, 59);
        colorsTwo[25] = new Color(10, 250, 59);

        int countColor = 0;
        Color[] colors = new Color[104];
        for(int i = 0; i < colors.length; i+=4){
            for(int j = 0; j < 4; j++){
                colors[i+j] = colorsTwo[countColor];
            }
            countColor++;
            if(countColor == colorsTwo.length) {
                countColor = 0;
            }
        }
        return colors;
    }
    @Override
    protected void move() {
        x -= xSpeed;
        y -= ySpeed;

        if (x <= 4 || x >= panel.getWidth() - size - 4 ) {
            xSpeed *= -1;
        }
        if (y <= 4 || y >= panel.getHeight() - size - 4 ) {
            ySpeed *= -1;
        }

        if (System.currentTimeMillis() - lastShadowTime >= 25) {
            panelTwo.addShadow(x, y, colors[indexColor]);
            lastShadowTime = System.currentTimeMillis();
        }
        if(indexColor < colors.length){
            indexColor++;
        }
        indexColor = (indexColor + 1 ) % colors.length;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
