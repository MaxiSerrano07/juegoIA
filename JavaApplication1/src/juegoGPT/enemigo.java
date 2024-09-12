/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoGPT;



import java.awt.Color;
import java.awt.Graphics;

public class enemigo {
    private int x, y;
    private int dx, dy;
    private final int width = 20, height = 20;

    public enemigo(int x, int y) {
        this.x = x;
        this.y = y;
        this.dx = 1;  // Velocidad en x
        this.dy = 1;  // Velocidad en y
    }

    public void update() {
        x += dx;
        y += dy;

        // Rebote simple en los bordes de la pantalla
        if (x < 0 || x > 780) {
            dx = -dx;  // Invierte la dirección horizontal
        }
        if (y < 0 || y > 580) {
            dy = -dy;  // Invierte la dirección vertical
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);  // Dibuja el enemigo como un cuadrado rojo
    }

    // Métodos para obtener las coordenadas (para colisiones más adelante)
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
