import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;

public class volumeShapeGUI {
    private static VolumeShape vs = new VolumeShape(" ");
    private static double resCuboid, resCube, resCylinder, resCone, resSphere, resHemisphere;
    private static JLabel statusBar;
    private static JFrame currentFrame;







    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Volume Shape Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the frame
        frame.setSize(600, 400);
        
        JToolBar toolBar = new JToolBar();
        
        JButton cuboidButton = createToolbarButton("Cuboid", "cuboid.png", e -> {
            updateStatusBar("Selected: Compute Cuboid Surface Area");
            closeCurrentFrame();
            openCuboidFrame();
        });
        toolBar.add(cuboidButton);
        
        JButton cubeButton = createToolbarButton("Cube", "cube.png", e -> {
            updateStatusBar("Selected: Compute Cube Surface Area");
            closeCurrentFrame();
            openCubeFrame();
        });
        toolBar.add(cubeButton);
        
        JButton cylinderButton = createToolbarButton("Cylinder", "cylinder.png", e -> {
            updateStatusBar("Selected: Compute Cylinder Surface Area");
            closeCurrentFrame();
            openCylinderFrame();
        });
        toolBar.add(cylinderButton);
        
        JButton coneButton = createToolbarButton("Cone", "cone.png", e -> {
            updateStatusBar("Selected: Compute Cone Surface Area");
            closeCurrentFrame();
            openConeFrame();
        });
        toolBar.add(coneButton);
        JButton sphereButton = createToolbarButton("sphere", "sphere.png", e -> {
            updateStatusBar("selected: compute surface area");
            closeCurrentFrame();
            OpenSphereFrame();
        });
        toolBar.add(sphereButton);
        JButton hemisphereButton = createToolbarButton("Hemispere", "hemisphere.png", e -> {

            updateStatusBar("selected: compute hemisphere surface area");
            closeCurrentFrame();
            openHemiSphereFrame();});
        toolBar.add(hemisphereButton);
        JButton displayButton = createToolbarButton("display", "setting.png", e->{
            updateStatusBar("selected: Dislay calculations");
            closeCurrentFrame();
            displayCalculations();
        });

        JButton GroupButton = createToolbarButton("NAME OF STUDENTS", "group.png", e -> {
            updateStatusBar("selected: list name of student");
            closeCurrentFrame();
            nameofstudent();
        });
        toolBar.add(GroupButton);

        toolBar.add(displayButton);
        JButton exitButton = createToolbarButton("Exit", "exit.png", e ->
            System.exit(0));
            toolBar.add(exitButton);

            statusBar = new JLabel("Ready");
            statusBar.setBorder(BorderFactory.createEtchedBorder());
            frame.getContentPane().add(toolBar, BorderLayout.NORTH);
            frame.getContentPane().add(statusBar, BorderLayout.SOUTH);
            frame.setVisible(true);
    }





    private static void nameofstudent() {
        currentFrame = new JFrame("Name of student");
        currentFrame.setSize(500, 500);
        currentFrame.setLayout(new GridLayout(5, 3));

    
        JLabel sideLabel = new JLabel("1->abeba abebab ");
        JLabel sideLabe2 = new JLabel("1->abeba abebab ");
        JLabel sideLabe3 = new JLabel("1->abeba abebab ");
        JLabel sideLabe4 = new JLabel("1->abeba abebab ");
        JLabel sideLabe5 = new JLabel("1->abeba abebab ");


        JLabel sideL1 = new JLabel("1->abeba abebab ");
        JLabel sideL2 = new JLabel("1->abeba abebab ");
        JLabel sideL3 = new JLabel("1->abeba abebab ");
        JLabel sideL4 = new JLabel("1->abeba abebab ");
        JLabel sideL5 = new JLabel("1->abeba abebab ");

        JLabel sl = new JLabel("1->abeba abebab ");
        JLabel s2 = new JLabel("1->abeba abebab ");
        JLabel s3 = new JLabel("1->abeba abebab ");
        JLabel s4 = new JLabel("1->abeba abebab ");
        JLabel s5 = new JLabel("1->abeba abebab ");
        currentFrame.add(sideLabel);
        currentFrame.add(sideL1);
        currentFrame.add(sl);

        currentFrame.add(sideLabe2);
        currentFrame.add(sideL2);
        currentFrame.add(s2);

        currentFrame.add(sideLabe3);
        currentFrame.add(sideL3);
        currentFrame.add(s3);

        currentFrame.add(sideLabe4);
        currentFrame.add(sideL4);
        currentFrame.add(s4);

        currentFrame.add(sideLabe5);
        currentFrame.add(sideL5);
        currentFrame.add(s5);

        centerFrame(currentFrame);
        currentFrame.setVisible(true);
    }









    private static void OpenSphereFrame() {
        currentFrame = new JFrame("Compute Surface Area of Sphere");
        currentFrame.setSize(300, 150);
        currentFrame.setLayout(new GridLayout(2, 2));

        JLabel radiusLabel = new JLabel("Enter value of radius: ");
        JTextField radiusField = new JTextField();

        JButton computeButton = new JButton("Compute");
        computeButton.addActionListener(e -> {
            try {
                double radius = Double.parseDouble(radiusField.getText());
                resSphere = vs.surfaceAreaSphere(radius);
                JOptionPane.showMessageDialog(currentFrame, "Surface area of SPHERE: " + resSphere);
                updateStatusBar("Computed surface area of Sphere");
                closeCurrentFrame();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(currentFrame, "Invalid input! Please enter valid numbers.");
                updateStatusBar("Error: Invalid input for Sphere");
            }
        });

        currentFrame.add(radiusLabel);
        currentFrame.add(radiusField);
        currentFrame.add(computeButton);
        centerFrame(currentFrame);
        currentFrame.setVisible(true);
    }
    private static void openCuboidFrame() {
        currentFrame = new JFrame("Compute Surface Area of Cuboid");
        currentFrame.setSize(300, 200);
        currentFrame.setLayout(new GridLayout(4, 2));
    
        JLabel baseLabel = new JLabel("Enter value of base: ");
        JTextField baseField = new JTextField();
    
        JLabel heightLabel = new JLabel("Enter value of height: ");
        JTextField heightField = new JTextField();
    
        JLabel lengthLabel = new JLabel("Enter value of length: ");
        JTextField lengthField = new JTextField();
    
        JButton computeButton = new JButton("Compute");
        computeButton.addActionListener(e -> {
            try {
                double base = Double.parseDouble(baseField.getText());
                double height = Double.parseDouble(heightField.getText());
                double length = Double.parseDouble(lengthField.getText());
                double resCuboid = vs.surfaceAreaCuboid(base, height, length);
                JOptionPane.showMessageDialog(currentFrame, "Surface area of CUBOID: " + resCuboid);
                updateStatusBar("Computed surface area of Cuboid");
                closeCurrentFrame();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(currentFrame, "Invalid input! Please enter valid numbers.");
                updateStatusBar("Error: Invalid input for Cuboid");
            }
        });
    
        currentFrame.add(baseLabel);
        currentFrame.add(baseField);
        currentFrame.add(heightLabel);
        currentFrame.add(heightField);
        currentFrame.add(lengthLabel);
        currentFrame.add(lengthField);
        currentFrame.add(computeButton);
    
        centerFrame(currentFrame);
        currentFrame.setVisible(true);
    }
    private static void openConeFrame() {
        currentFrame = new JFrame("Compute Surface Area of Cone");
        currentFrame.setSize(300, 200);
        currentFrame.setLayout(new GridLayout(3, 2));
    
        JLabel lLabel = new JLabel("Enter value of l: ");
        JTextField lField = new JTextField();
    
        JLabel radiusLabel = new JLabel("Enter value of radius: ");
        JTextField radiusField = new JTextField();
    
        JButton computeButton = new JButton("Compute");
        computeButton.addActionListener(e -> {
            try {
                double l = Double.parseDouble(lField.getText());
                double radius = Double.parseDouble(radiusField.getText());
                double resCone = vs.surfaceAreaCone(l, radius);
                JOptionPane.showMessageDialog(currentFrame, "Surface area of CONE: " + resCone);
                updateStatusBar("Computed surface area of Cone");
                closeCurrentFrame();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(currentFrame, "Invalid input! Please enter valid numbers.");
                updateStatusBar("Error: Invalid input for Cone");
            }
        });
    
        currentFrame.add(lLabel);
        currentFrame.add(lField);
        currentFrame.add(radiusLabel);
        currentFrame.add(radiusField);
        currentFrame.add(computeButton);
    
        centerFrame(currentFrame);
        currentFrame.setVisible(true);
    }
        
    private static void openCubeFrame() {
        currentFrame = new JFrame("Compute Surface Area of Cube");
        currentFrame.setSize(300, 150);
        currentFrame.setLayout(new GridLayout(2, 2));
    
        JLabel sideLabel = new JLabel("Enter value of side: ");
        JTextField sideField = new JTextField();
    
        JButton computeButton = new JButton("Compute");
        computeButton.addActionListener(e -> {
            try {
                double side = Double.parseDouble(sideField.getText());
                resCube = vs.surfaceAreaCube(side);
                JOptionPane.showMessageDialog(currentFrame, "Surface area of CUBE: " + resCube);
                updateStatusBar("Computed surface area of Cube");
                closeCurrentFrame();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(currentFrame, "Invalid input! Please enter valid numbers.");
                updateStatusBar("Error: Invalid input for Cube");
            }
        });
    
        currentFrame.add(sideLabel);
        currentFrame.add(sideField);
        currentFrame.add(computeButton);
    
        centerFrame(currentFrame);
        currentFrame.setVisible(true);
    }
    private static void openCylinderFrame() {
        currentFrame = new JFrame("Compute Surface Area of Cylinder");
        currentFrame.setSize(300, 200);
        currentFrame.setLayout(new GridLayout(3, 2));
    
        JLabel radiusLabel = new JLabel("Enter value of radius: ");
        JTextField radiusField = new JTextField();
    
        JLabel heightLabel = new JLabel("Enter value of height: ");
        JTextField heightField = new JTextField();
    
        JButton computeButton = new JButton("Compute");
        computeButton.addActionListener(e -> {
            try {
                double radius = Double.parseDouble(radiusField.getText());
                double height = Double.parseDouble(heightField.getText());
                resCylinder = vs.surfaceAreaCylinder(radius, height);
                JOptionPane.showMessageDialog(currentFrame, "Surface area of CYLINDER: " + resCylinder);
                updateStatusBar("Computed surface area of Cylinder");
                closeCurrentFrame();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(currentFrame, "Invalid input! Please enter valid numbers.");
                updateStatusBar("Error: Invalid input for Cylinder");
            }
        });
    
        currentFrame.add(radiusLabel);
        currentFrame.add(radiusField);
        currentFrame.add(heightLabel);
        currentFrame.add(heightField);
        currentFrame.add(computeButton);
    
        centerFrame(currentFrame);
        currentFrame.setVisible(true);
    }
        

    private static void openHemiSphereFrame() {
        currentFrame = new JFrame("Compute Surface Area of Hemisphere");
        currentFrame.setSize(300, 150);
        currentFrame.setLayout(new GridLayout(2, 2));

        JLabel radiusLabel = new JLabel("Enter value of radius: ");
        JTextField radiusField = new JTextField();

        JButton computeButton = new JButton("Compute");
        computeButton.addActionListener(e -> {
            try {
                double radius = Double.parseDouble(radiusField.getText());
                resHemisphere = vs.surfaceAreaHemisphere(radius);
                JOptionPane.showMessageDialog(currentFrame, "Surface area of HEMISPHERE: " + resHemisphere);
                updateStatusBar("Computed surface area of Hemisphere");
                closeCurrentFrame();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(currentFrame, "Invalid input! Please enter valid numbers.");
                updateStatusBar("Error: Invalid input for Hemisphere");
            }
        });

        currentFrame.add(radiusLabel);
        currentFrame.add(radiusField);
        currentFrame.add(computeButton);
        centerFrame(currentFrame);
        currentFrame.setVisible(true);
    }

    private static void displayCalculations() {
        String calculations = String.format(
            "Surface Area of CUBOID: %f\n" +
            "Surface Area of CUBE: %f\n" +
            "Surface Area of CYLINDER: %f\n" +
            "Surface Area of CONE: %f\n" +
            "Surface Area of SPHERE: %f\n" +
            "Surface Area of HEMISPHERE: %f\n",
            resCuboid, resCube, resCylinder, resCone, resSphere, resHemisphere
        );
        JOptionPane.showMessageDialog(null, calculations);
        updateStatusBar("Displayed all calculations");
    }

    private static void updateStatusBar(String message) {
        statusBar.setText(message);
    }

    

    
    

    private static JButton createToolbarButton(String text, String iconPath, ActionListener actionListener) {
        JButton button = new JButton(text);
        URL iconURL = volumeShapeGUI.class.getResource(iconPath);
        if (iconURL != null) {
            ImageIcon originalIcon = new ImageIcon(iconURL);
            Image scaledImage = originalIcon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(scaledImage));
        }
        button.addActionListener(actionListener);
        return button;
    }
    


    private static void closeCurrentFrame() {
        if (currentFrame != null) {
            currentFrame.dispose();
        }
    }

    private static void centerFrame(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(volumeShapeGUI::createAndShowGUI);
    }
}
