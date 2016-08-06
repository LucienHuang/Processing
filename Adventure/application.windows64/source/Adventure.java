import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Adventure extends PApplet {

PFont f;
int bgColor = color(0, 0, 0);
int leftColor = color(62, 194, 255);
int rightColor = color(255, 217, 27);
int tempColor;
int ballColor = color(255, 0, 0);
int dBig, dSmall;
int deltaX = 0, deltaY = 0;
int posX, posY;
int level = 0;
boolean changed = true;
boolean go = false;
int changing = 0;
int Bigger = 0;
int swi = 0;
int tempS = 0;

public void setup() {
  
  background(0);
  f = loadFont("BreakFill-Bold-48.vlw");
  posX = width/2;
  posY = height/2;
  frameRate(150);
}

public void draw() {
  background(bgColor);
  noStroke();
  fill(leftColor);
  ellipse(200, 300, 200, 200);
  fill(rightColor);
  ellipse(600, 300, 200, 200);
  fill(255);
  textFont(f, 24);

  text(title1(swi), 30, 500);
  text(title2(swi), 30, 522);

  if (swi == 8) {
    ballColor = color(255, 230, 0);
  } else if (swi == 7) {
    ballColor = color(36, 210, 255);
  } else if (swi == 11) {
    ballColor = color(255, 114, 0);
  } else if (swi == 12) {
    ballColor = color(101, 5, 191);
  }

  fill(ballColor);
  ellipse(mouseX, mouseY, 40, 40);
  if (mousePressed&&changed==true) {
    if (dist(mouseX, mouseY, 200, 300)<120) {
      tempColor = leftColor;
      changed=false;
      changing = -1;
      level ++;
      go = true;
      leftColor = target(changing, swi, -1);
      rightColor = target(changing, swi, 1);
      tempS = swi*2+1;
    } else if (dist(mouseX, mouseY, 600, 300)<120) {
      tempColor = rightColor;
      changed = false;
      changing = 1;
      level ++;
      go = true;
      leftColor = target(changing, swi, -1);
      rightColor = target(changing, swi, 1);
      tempS = swi*2+2;
    }
  }
  if (go==true) {
    Bigger+=20;
    if (changing==-1) {
      background(bgColor);
      fill(tempColor);
      ellipse(200, 300, 200+Bigger, 200+Bigger);
    } else if (changing ==1) {
      background(bgColor);
      fill(tempColor);
      ellipse(600, 300, 200+Bigger, 200+Bigger);
    }
    if (Bigger>2000) {
      bgColor = tempColor;
      go = false;
      changed = true;
      Bigger = 0;
      swi = tempS;
    }
  }
  fill(255);
  textFont(f, 30);
  text("The Adventure of A Red Ball", 15, 30);
  if (swi==7) {
    background(36, 210, 255);
    fill(0);
    textFont(f, 30);
    text("The Adventure of A Red Ball", 15, 30);
    textFont(f, 24);
    text(title1(swi), 30, 500);
    text(title2(swi), 30, 522);
    changed = false;
  } else if (swi==17) {
    background(5, 87, 49);
    fill(255);
    textFont(f, 30);
    text("The Adventure of A Red Ball", 15, 30);
    textFont(f, 24);
    text(title1(swi), 30, 500);
    text(title2(swi), 30, 522);
    changed = false;
  } else if (swi==18) {
    background(87, 9, 10);
    fill(255);
    textFont(f, 30);
    text("The Adventure of A Red Ball", 15, 30);
    textFont(f, 24);
    text(title1(swi), 30, 500);
    text(title2(swi), 30, 522);
    changed = false;
  } else if (swi==19) {
    background(255);
    fill(0);
    textFont(f, 30);
    text("The Adventure of A Red Ball", 15, 30);
    textFont(f, 24);
    text(title1(swi), 30, 500);
    text(title2(swi), 30, 522);
    changed = false;
  } else if (swi==20) {
    background(14, 62, 120);
    fill(255);
    textFont(f, 30);
    text("The Adventure of A Red Ball", 15, 30);
    textFont(f, 24);
    text(title1(swi), 30, 500);
    text(title2(swi), 30, 522);
    changed = false;
  } else if (swi==10) {
    background(255, 237, 17);
    fill(0);
    textFont(f, 30);
    text("The Adventure of A Red Ball", 15, 30);
    textFont(f, 24);
    text(title1(swi), 30, 500);
    text(title2(swi), 30, 522);
    changed = false;
  } else if (swi==11) {
    background(101, 5, 191);
    fill(255);
    textFont(f, 30);
    text("The Adventure of A Red Ball", 15, 30);
    textFont(f, 24);
    text(title1(swi), 30, 500);
    text(title2(swi), 30, 522);
    changed = false;
  } else if (swi==12) {
    background(255, 114, 0);
    fill(255);
    textFont(f, 30);
    text("The Adventure of A Red Ball", 15, 30);
    textFont(f, 24);
    text(title1(swi), 30, 500);
    text(title2(swi), 30, 522);
    fill(ballColor);
    ellipse(mouseX, mouseY, 40, 40);
    changed = false;
  } else if (swi==13) {
    background(30, 125, 156);
    fill(255);
    textFont(f, 30);
    text("The Adventure of A Red Ball", 15, 30);
    textFont(f, 24);
    text(title1(swi), 30, 500);
    text(title2(swi), 30, 522);
    changed = false;
  } else if (swi==17) {
    background(14, 62, 120);
    fill(255);
    textFont(f, 30);
    text("The Adventure of A Red Ball", 15, 30);
    textFont(f, 24);
    text(title1(swi), 30, 500);
    text(title2(swi), 30, 522);
    changed = false;
  } else if (swi==18) {
    background(87, 9, 10);
    fill(255);
    textFont(f, 30);
    text("The Adventure of A Red Ball", 15, 30);
    textFont(f, 24);
    text(title1(swi), 30, 500);
    text(title2(swi), 30, 522);
    changed = false;
  } else if (swi==19) {
    background(255);
    fill(0);
    textFont(f, 30);
    text("The Adventure of A Red Ball", 15, 30);
    textFont(f, 24);
    text(title1(swi), 30, 500);
    text(title2(swi), 30, 522);
    changed = false;
  } else if (swi==20) {
    background(62, 1, 20);
    fill(255);
    textFont(f, 30);
    text("The Adventure of A Red Ball", 15, 30);
    textFont(f, 24);
    text(title1(swi), 30, 500);
    text(title2(swi), 30, 522);
    changed = false;
  } else if (swi==29) {
    background(255, 38, 59);
    fill(255);
    textFont(f, 30);
    text("The Adventure of A Red Ball", 15, 30);
    textFont(f, 24);
    text(title1(swi), 30, 500);
    text(title2(swi), 30, 522);
    changed = false;
  } else if (swi==30) {
    background(54, 196, 151);
    fill(255);
    textFont(f, 30);
    text("The Adventure of A Red Ball", 15, 30);
    textFont(f, 24);
    text(title1(swi), 30, 500);
    text(title2(swi), 30, 522);
    changed = false;
  }
}

public String title1(int swi) {
  String s="";
  if (swi == 0) {
    s = "Hey, red ball! Let's take an adventure, choose a cave to go in now!";
  } else if (swi == 1) {
    s = "Welcome to the blue world! Now the red ball is hungry, pick a mushroom";
  } else if (swi == 2) {
    s = "So here comes the yellow riddle room. You need to answer this question";
  } else if (swi == 3) {
    s = "The purple mushroom gives you the magic of light. Now you can glow with";
  } else if (swi == 4) {
    s = "The brown mushroom represents the power of the earth. Now you can grow a";
  } else if (swi == 5) {
    s = "Ooooops, this is the wrong answer! now you have to be painted. Which one";
  } else if (swi == 6) {
    s = "Great! Now you got the magic of the wind! Do you want to fly with a blue";
  } else if (swi == 7) {
    s = "Where are you? I can't see you now.... I guess this is it. Bye~";
  } else if (swi == 8) {
    s = "Yay~ Now, you're the yellow wizzard to the rescue! choose a world to help";
  } else if (swi == 9) {
    s = "The tree just kept growing, and you are trying to climbing the tree. Where";
  } else if (swi == 10) {
    s = "Unfortunately, the flower you growed is a ball-eating flower. Good-bye~";
  } else if (swi == 11) {
    s = "HAHA, GOTCHA!";
  } else if (swi == 12) {
    s = "Awwwww, you're so naive... Now you are trapped here!";
  } else if (swi == 13) {
    s = "Why do you fly towards the airplane??? Have you lost your mind?!";
  } else if (swi == 14) {
    s = "Well done! For doing housework. Here is two candies your ball-mother give";
  } else if (swi == 17) {
    s = "This world is full of wizzards. You can improve your magic here with other";
  } else if (swi == 18) {
    s = "This is a world full of scary monsters. But I believe you will make here";
  } else if (swi == 19) {
    s = "This cloud is so comfortable. I think I can lie down here for a year!";
  } else if (swi == 20) {
    s = "WOW! You're flying in the sky! It's amazing!";
  } else if (swi == 29) {
    s = "This candy is very sweet. It will bring you good luck!";
  } else if (swi == 30) {
    s = "This candy is a little sour. It will bring you wealth!";
  }
  return s;
}

public String title2(int swi) {
  String s="";
  if (swi == 0) {
    s = " ";
  } else if (swi == 1) {
    s = "to eat: Purple or brown?";
  } else if (swi == 2) {
    s = "Which balloon is heavier? red or green?";
  } else if (swi == 3) {
    s = "the light of ... (blue or yellow)";
  } else if (swi == 4) {
    s = "green tree or a yellow flower!";
  } else if (swi == 5) {
    s = "do you wanna be in? Purple or orange?";
  } else if (swi == 6) {
    s = "airplane or use the wind to blow a bunch of brown leaves";
  } else if (swi == 8) {
    s = "people there!";
  } else if (swi == 9) {
    s = "do you want to go? The white cloud or the blue sky?";
  } else if (swi == 14) {
    s = "you, take one~";
  } else if (swi == 17) {
    s = "wizzards and witches. Good luck with it!";
  } else if (swi == 18) {
    s = "peaceful again!";
  } 
  return s;
}

public int target(int sign, int swi, int am) {
  int newColor = color(0);
  if (swi==0) {
    if (sign ==-1) {
      if (am==-1) newColor = color(79, 0, 189);
      else newColor = color(212, 103, 3);
    } else {
      if (am==-1) newColor = color(189, 9, 20);
      else newColor = color(0, 117, 71);
    }
  } else if (swi==1) {
    if (sign ==-1) {
      if (am==-1) newColor = color(36, 210, 255);
      else newColor = color(255, 230, 0);
    } else {
      if (am ==-1) newColor = color(100, 191, 0);
      else newColor = color(255, 237, 17);
    }
  } else if (swi==2) {
    if (sign ==-1) {
      if (am==-1) newColor = color(101, 5, 191);
      else newColor = color(255, 114, 0);
    } else {
      if (am ==-1) newColor = color(30, 125, 156);
      else newColor = color(87, 39, 0);
    }
  } else if (swi==3) {
    if (sign ==-1) {
      if (am==-1) newColor = color(36, 210, 255);
      else newColor = color(36, 210, 255);
    } else {
      if (am ==-1) newColor = color(5, 87, 49);
      else newColor = color(87, 9, 10);
    }
  } else if (swi==4) {
    if (sign ==-1) {
      if (am==-1) newColor = color(255);
      else newColor = color(14, 62, 120);
    } else {
      if (am ==-1) newColor = color(5, 87, 49);
      else newColor = color(87, 9, 10);
    }
  } else if (swi==6) {
    if (sign ==-1) {
      if (am==-1) newColor = color(255);
      else newColor = color(14, 62, 120);
    } else {
      if (am ==-1) newColor = color(255, 38, 59);
      else newColor = color(54, 196, 151);
    }
  }
  return newColor;
}

public void keyPressed() {
  bgColor = color(0, 0, 0);
  leftColor = color(62, 194, 255);
  rightColor = color(255, 217, 27);
  ballColor = color(255, 0, 0);
  level = 0;
  changed = true;
  go = false;
  changing = 0;
  Bigger = 0;
  swi = 0;
  tempS = 0;
}
  public void settings() {  size(800, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Adventure" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
