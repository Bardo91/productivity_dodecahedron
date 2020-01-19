//
//  PRODUCTIVITY DODECAHEDRON
//    
//    Bardo91
//

#include "Positioner.h"
#include "Classifier.h"
#include "TimeRegistry.h"

int GND_PIN = A6; // D2
int PWR_PIN = A5; //D3

Positioner positioner;
Classifier classifier;
TimeRegistry timeRegistry;

void setup() {
  analogWrite(GND_PIN, 0);
  analogWrite(PWR_PIN, 1023);
  
  Serial.begin(9600);
  positioner.init();
  timeRegistry.reset();
}

void loop() {

  float x,y,z;
  positioner.getPosition(x,y,z);
  //Serial.print(x);
  //Serial.print(", ");
  //Serial.print(y);
  //Serial.print(", ");
  //Serial.print(z);
  //Serial.print(" -->>> ");
  positioner.update();

  if(positioner.isStable()){
    //Serial.print("is stable");  
    int id = classifier.classify(x,y,z);
    
    //Serial.print(" ID is: ");
    //Serial.print(id);
    //Serial.print("---");
      
    timeRegistry.update(id);
  }else{
    //Serial.print("is not stable");
    // nothing
  }
  //Serial.print("\n");

  if(Serial.available()){
    // Clean buffer
    while (Serial.available() > 0) {
        char received = Serial.read();
    }
    timeRegistry.saveCurrent();
    float *times = timeRegistry.getTimes();
    for(unsigned i = 0; i < 12; i++){
      Serial.print(times[i]);
      Serial.print(", ");
    }
    Serial.println();
  }

  
  delay(50);

}
