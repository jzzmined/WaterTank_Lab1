package LabActivity;

import javax.swing.*;

    // Abstract class
abstract class WaterTankProgram {
    protected int capacity;
    protected int currentLevel;

    public WaterTankProgram(int capacity) {
        this.capacity = capacity;
        this.currentLevel = 0;
    }

    public abstract void fillTank(int liters);
    public abstract void useTubig(int liters);
    public abstract String checkStatus();
}
    // Home Tank Subclass
class Home extends WaterTankProgram {
    public Home() {
        super(200);
    }

    @Override
    public void fillTank(int liters) {
        if (currentLevel + liters >= capacity) {
            currentLevel = capacity;
            JOptionPane.showMessageDialog(null, "Tank is FULL!" +
                    "\nCurrent Level: " + currentLevel + "/" + capacity);
        } else {
            currentLevel += liters;
            JOptionPane.showMessageDialog(null, " Liters added!" +
                    "\nCurrent Level: " + currentLevel + "/" + capacity);
        }
    }

    @Override
    public void useTubig(int liters) {
        if (currentLevel - liters <= 0) {
            currentLevel = 0;
            JOptionPane.showMessageDialog(null, "Tank is now EMPTY!" +
                    "\nCurrent Level: " + currentLevel + "/" + capacity);
        } else {
            currentLevel -= liters;
            JOptionPane.showMessageDialog(null, " Liters used!" +
                    "\nCurrent Level: " + currentLevel + "/" + capacity);
        }
    }

    @Override
    public String checkStatus() {
        if (currentLevel == 0) return "Empty";
        else if (currentLevel == capacity) return "Full";
        return "Tank is used, it is currently " + currentLevel +"L.";
    }
}
    // Building Tank Subclass
class Building extends WaterTankProgram {
    public Building() {
        super(1000);
    }

    @Override
    public void fillTank(int liters) {
        if (currentLevel + liters >= capacity) {
            currentLevel = capacity;
            JOptionPane.showMessageDialog(null, "Tank is FULL!" +
                    "\nCurrent Level: " + currentLevel + "/" + capacity);
        } else {
            currentLevel += liters;
            JOptionPane.showMessageDialog(null, " Liters added!" +
                    "\nCurrent Level: " + currentLevel + "/" + capacity);
        }
    }

    @Override
    public void useTubig(int liters) {
        if (currentLevel - liters <= 0) {
            currentLevel = 0;
            JOptionPane.showMessageDialog(null, "Tank is now EMPTY!" +
                    "\nCurrent Level: " + currentLevel + "/" + capacity);
        } else {
            currentLevel -= liters;
            JOptionPane.showMessageDialog(null, " Liters used!" +
                    "\nCurrent Level: " + currentLevel + "/" + capacity);
        }
    }

    @Override
    public String checkStatus() {
        if (currentLevel == 0) return "Water tank is EMPTY!!!";
        else if (currentLevel == capacity) return "Water tank is FULL!!!";
        return "Tank is used, it is currently " + currentLevel + "L";
    }
}
    // Main Program
public class WaterTank_LabAct1 {
    public static void main(String[] args) {
        WaterTankProgram tank = null;

        JOptionPane.showMessageDialog(null, "Welcome to Water Tank Program!",
                "WaterTank Program", JOptionPane.INFORMATION_MESSAGE);

        String choose = JOptionPane.showInputDialog(
                "CHOOSE TANK:\n1.) Home Tank (200L)\n2.) Building Tank (1000L)");

        if (choose.equals("1")) {
            tank = new Home();
        } else if (choose.equals("2")) {
            tank = new Building();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Choice! Exiting the program.");
            return;
        }

        while (true) {
            String act = JOptionPane.showInputDialog(
                    "CHOOSE ACTION:\n1.) Fill Tank\n2.) Use Water\n3.) Check Status\n4.) Exit Program.");

            if (act.equals("1")) {
                int lt = Integer.parseInt(JOptionPane.showInputDialog("Enter liters to fill: "));
                tank.fillTank(lt);
            } else if (act.equals("2")) {
                int lt = Integer.parseInt(JOptionPane.showInputDialog("Enter liters to use: "));
                tank.useTubig(lt);
            } else if (act.equals("3")) {
                JOptionPane.showMessageDialog(null, "Tank Status: " + tank.checkStatus());
            } else if (act.equals("4")) {
                JOptionPane.showMessageDialog(null, "Exiting program...");
                break;
            }

            if (tank.checkStatus().equals("Full") || tank.checkStatus().equals("Empty")) {
                JOptionPane.showMessageDialog(null,
                        "Tank is " + tank.checkStatus() + ". The program is ended.");
                break;
            }
        }
    }
}