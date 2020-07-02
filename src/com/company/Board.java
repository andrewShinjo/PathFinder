package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JPanel implements MouseListener {
    private int columns;
    private int rows;
    private final int size = 10;
    private Cell[][] cells;
    private boolean cellsInit;
    State state;
    private int numStartPos;

    public Board() {
        addMouseListener(this);
        cellsInit = false;
        state = State.SET_START;
        numStartPos = 0;
    }

    public void setState(State state) {
        this.state = state;
    }


    @Override
    public void paintComponent(Graphics g) {
        if(! cellsInit) {
            columns = (getHeight() - 200) / size;
            rows = (getWidth() - 200) / size;
            cells = new Cell[columns][rows];
            for(int i = 0; i < columns; i++) {
                for(int j = 0; j < rows; j++) {
                    cells[i][j] = new Cell(j * size, i * size, size, size);
                }
            }
            cellsInit = true;
        }

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        for(int i = 0; i < columns; i++) {
            for(int j = 0; j < rows; j++) {
                g2d.setColor(cells[i][j].getColor());
                g2d.fillRect(100 + cells[i][j].x, 100 + cells[i][j].y, size, size);
            }
        }

        for(int i = 100; i <= getWidth() - 100; i += 10) {
            g.drawLine(i, 100, i, getHeight() - 100);
        }
        for (int i = 100; i <= getHeight() - 100; i += 10) {
            g.drawLine(100, i, getWidth() - 100, i);
        }


    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if(state == State.SET_START) {
            int x = e.getX();
            int y = e.getY();
            int row = (x - 100) / size;
            int column = (y - 100) / size;
            if (row >= 0 && row < rows && column >= 0 && column < columns) {
                cells[column][row].setColor(Color.BLUE);
                repaint();
            }
        }
    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
