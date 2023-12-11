package GUI.Frame;

import javax.swing.*;

public class Menu extends JMenuBar {

    JMenu menu;

    JMenu colorMenu;
    JMenuItem grey;
    JMenuItem green;
    JMenuItem pink;
    JMenuItem ugly;

    JMenu view;
    JMenuItem month;
    JMenuItem week;
    JMenuItem day;

    JMenuItem logOut;

    public Menu(){
        menu = new JMenu("Menu");
        colorMenu = new JMenu("Color Menu");
        logOut = new JMenuItem("Log Out");

        add(menu);
        addViews();
        addColorMenu();
        menu.add(logOut);

        setVisible(true);
    }

    public void addViews(){
        view = new JMenu("View");
        month = new JMenuItem("Month");
        week = new JMenuItem("Week");
        day = new JMenuItem("Day");

        view.add(month);
        view.add(week);
        view.add(day);
        menu.add(view);
    }

    public void addColorMenu(){
        grey = new JMenuItem("Grey");
        green = new JMenuItem("Green");
        pink = new JMenuItem("Pink");
        ugly = new JMenuItem("Funky");

        colorMenu.add(grey);
        colorMenu.add(green);
        colorMenu.add(pink);
        colorMenu.add(ugly);
        menu.add(colorMenu);
    }


}
