import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class ImageOperation{
String path;
 void encrypt(String path,int key)
    {
       try
        {
            FileInputStream fis=new FileInputStream(path);
            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }

            FileOutputStream fos=new FileOutputStream(path);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

  public static void main(String[] args) {
        ImageOperation io1=new ImageOperation();
        System.out.println("this is testing");
        JFrame f=new JFrame();
        f.setTitle("Image Operation");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font=new Font("Roboto",Font.BOLD,45);
       Font font1=new Font("Roboto",Font.BOLD,25);
        //creating button
        JButton button=new JButton();
        button.setText("Select an image");
        button.setFont(font);
       JButton button1=new JButton();
        button1.setText("encrypt");
        button1.setFont(font);
        //creating text field
       JLabel label=new JLabel("enter a key");
       label.setFont(font1);
       JTextField textField=new JTextField(10);  
        textField.setFont(font1);        
        button.addActionListener(e->{
        System.out.println("button clicked");
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();  
        io1.path=file.getAbsolutePath();
        System.out.println(io1.path);
         button1.addActionListener(fh->{
        String text=textField.getText();
        int key=Integer.parseInt(text);
         io1.encrypt(io1.path,key);
        });
        });
   //  System.out.println(" path is "+io1.path);
      f.setLayout(new FlowLayout());
       f.add(button);
       f.add(label);
       f.add(textField);
       f.add(button1);
       f.setVisible(true);

    }
}