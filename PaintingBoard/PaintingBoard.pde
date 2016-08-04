void setup() {
  size(600, 600);
  background(255);
  fill(255, 0, 0);
  rect(570, 0, 30, 30);
  frameRate(100);
}

int red = 0;
int sig = 0;
int bSize = 20;

void draw() {

  if (mousePressed) {
    if (mouseX>570&&mouseY<30) {
      background(255);
      fill(255, 0, 0);
      rect(570, 0, 30, 30);
    } else {
      if (red==0) {
        sig = 0;
      } else if (red==255) {
        sig = 1;
      }
      if (sig == 0) {
        red++;
      } else {
        red--;
      }
      fill(red, 166, 233);
      noStroke();
      ellipse(mouseX, mouseY, bSize, bSize);
      stroke(red, 166, 233);
      strokeWeight(bSize);
      line(pmouseX, pmouseY, mouseX, mouseY);
    }
  }
}

void keyPressed(){
  if(key  ==CODED){
    if(keyCode==UP){
      bSize += 5;
      println(bSize);
    }else if(key==DOWN){
      bSize -= 5;
    }
  }
}