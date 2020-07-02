package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell extends Rectangle implements MouseListener {
    private Color color;

    public Cell(int x, int y, int width, int height) {
        super(x, y, width, height);
        color = Color.WHITE;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isStart() {
        return (color.equals(Color.BLUE));
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        color = Color.RED;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
