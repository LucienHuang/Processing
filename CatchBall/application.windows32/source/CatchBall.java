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

public class CatchBall extends PApplet {

int rectCx = 500;
int rectCy = 380;
int Ballx;
int Bally;
boolean drop = true;
int count = 0;
int score = 0;
PFont f;
int level = 1;
int Ballspeed = 1;
int Ballcolor = color(255, 230, 0);

public void setup() {
  
  background(0);
  frameRate(150);
  f = loadFont("AxureHandwriting-48.vlw");
  textFont(f, 30);
}

public void draw() {
  background(0);
  fill(0, 200, 255);
  text(score, 40, 80);
  text("LEVEL: "+Ballspeed, 40, 40);
  rectMode(CENTER);
  noStroke();
  if (rectCx>880) rectCx = 880;
  else if (rectCx<120) rectCx = 120;
  fill(255);
  rect(rectCx, rectCy, 200, 20);
  fill(Ballcolor);
  if (drop == true) {
    Ballx = (int)random(980);
    Bally = -12;
    ellipse(Ballx, Bally, 20, 20);
    drop = false;
  } else {
    Bally += Ballspeed;
    ellipse(Ballx, Bally, 20, 20);
    if (Bally == 360) {
      level++;
      if (rectCx+100>Ballx&&rectCx-100<Ballx) {
        score++;
        drop = true;
      }
      count = 0;
    } else if (Bally > 360) {
      count++;
    }
    if (count==50) {
      drop = true;
      count = 0;
    }
  }
  if (level>5&&level<=10) {
    Ballspeed = 2;
    Ballcolor = color(255, 150, 0);
  } else if (level>10&&level<=15) {
    Ballspeed = 3;
    Ballcolor = color(255, 70, 0);
  } else if (level>15) {
    Ballspeed = 4;
    Ballcolor = color(255, 0, 0);
  }
}

public void keyPressed() {
  if (key==CODED) {
    if (keyCode==LEFT) {
      rectCx-=5*Ballspeed;
    } else if (keyCode==RIGHT) {
      rectCx+=5*Ballspeed;
    }
  }
}
  public void settings() {  size(1000, 400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "CatchBall" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
