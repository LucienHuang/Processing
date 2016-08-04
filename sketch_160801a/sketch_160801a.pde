int height = 0;
int count = 0;

PShape t1;
PShape t2;

void setup(){
  size(1000, 600);
  background(0);
  t1 = createShape();
  t1.beginShape();
  t1.fill(255);
  t1.noStroke();
  t1.vertex(0, 0);
  t1.vertex(25, 50);
  t1.vertex(50, 0);
  t1.endShape(CLOSE);
  
  t2 = createShape();
  t2.beginShape();
  t2.fill(255);
  t2.noStroke();
  t2.vertex(0, 50);
  t2.vertex(25, 0);
  t2.vertex(50, 50);
  t2.endShape(CLOSE);
  frameRate(10);
}

void draw(){
  if(count%2==0){
    shape(t1, -25, height);
    shape(t1, height, -25);
  }else{
    shape(t2, -25, height);
    shape(t2, height, -25);
  }
  count++;
  height = height + 25;
}