/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoGPT;


import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.util.ArrayList;

public class escenario extends JPanel implements ActionListener, KeyListener {

    private Timer timer;
    private jugador player;
    private ArrayList<enemigo> enemigos;

    public escenario() {
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(this);

        player = new jugador(50, 50);  // Posición inicial del jugador

        // Crea la lista de enemigos
        enemigos = new ArrayList<>();
        enemigos.add(new enemigo(100, 100));  // Agrega un enemigo en la posición (100, 100)
        enemigos.add(new enemigo(300, 300));  // Agrega otro enemigo en la posición (300, 300)

        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);  // Dibuja al jugador

        // Dibuja a todos los enemigos
        for (enemigo e : enemigos) {
            e.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();  // Actualiza la posición del jugador

        // Actualiza la posición de todos los enemigos
        for (enemigo enemy : enemigos) {
            enemy.update();
        }

        repaint();  // Redibuja la pantalla
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            player.setDx(-1);
        } else if (key == KeyEvent.VK_RIGHT) {
            player.setDx(1);
        } else if (key == KeyEvent.VK_UP) {
            player.setDy(-1);
        } else if (key == KeyEvent.VK_DOWN) {
            player.setDy(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            player.setDx(0);
        } else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            player.setDy(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
