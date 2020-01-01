package vue;

import java.util.*;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class ImageEditModel{
  private BufferedImage orange,rouge,blanc,noir,bleu;
  private UndoManager undoManager=new UndoManager();

  public ImageEditModel(String o,String r,String bc,String n,String bu) {
    try{
      orange=ImageIO.read(new File(o));
      rouge=ImageIO.read(new File(r));
      blanc=ImageIO.read(new File(bc));
      noir=ImageIO.read(new File(n));
      bleu=ImageIO.read(new File(bu));
    }
    catch(IOException e){
      System.out.println("Image non trouvé");
    }
  }

  public BufferedImage getImage(){
    return this.image;
  }


}
