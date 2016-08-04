int Px = 300;
int Py = 300;
int Rsmall = 120;
int Rlarge = 420;
int count = 0;

void setup() {
  size(600, 600);
  background(0);
  noFill();
  stroke(255, 27, 45);
  strokeWeight(5);
  ellipse(width/2, height/2, Rlarge, Rlarge);
  frameRate(200);
}

int sign = 0;
int G = 233;
int x = 0;
int y = 0;

void draw() {
  if (count==233) {
    sign = 1;
  } else if (count==0) {
    sign = 0;
  }
  if (sign==0) {
    count++;
  } else {
    count--;
  }
  background(0);
  noFill();
  stroke(255, 27, 45);
  strokeWeight(5);
  ellipse(width/2, height/2, Rlarge, Rlarge);
  if (mousePressed) {
    if (((Px-300)*(Px-300)+(Py-300)*(Py-300))<=(150*150)) {
      if (mouseX>Px) {
        Px++;
        x = 1;
      } else if (mouseX<Px) {
        Px--;
        x = -1;
      }

      if (mouseY>Py) {
        Py++;
        y = 1;
      } else if (mouseY<Py) {
        Py--;
        y = -1;
      }
    } else {
      if (x == 1) {
        Px = Px -20;
      } else {
        Px = Px+20;
      }

      if (y==1) {
        Py = Py-20;
      } else {
        Py = Py+20;
      }
    }
    G = 233-count;
  }
  fill(255, G, 30);
  noStroke();
  ellipse(Px, Py, Rsmall, Rsmall);
}