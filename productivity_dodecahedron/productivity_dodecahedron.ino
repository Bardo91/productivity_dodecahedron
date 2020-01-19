//
//  PRODUCTIVITY DODECAHEDRON
//    
//    Bardo91
//

#include "Positioner.h"
#include "Classifier.h"
#include "TimeRegistry.h"

Positioner positioner;
Classifier classifier;
TimeRegistry timeRegistry;
void setup() {
  Serial.begin(9600);
  positioner.init();
  timeRegistry.reset();
}

void loop() {

  float x,y,z;
  positioner.getPosition(x,y,z);
  Serial.print(x);
  Serial.print(", ");
  Serial.print(y);
  Serial.print(", ");
  Serial.print(z);
  Serial.print(" -->>> ");
  positioner.update();

  if(positioner.isStable()){
    Serial.print("is stable");  
    int id = classifier.classify(x,y,z);
    
    Serial.print(" ID is: ");
    Serial.print(id);
    Serial.print("---");
      
    timeRegistry.update(id);
  }else{
    Serial.print("is not stable");
    // nothing
  }
  Serial.print("\n");
/*
  float *times = timeRegistry.getTimes();
  for(unsigned i = 0; i < 12; i++){
    Serial.print(times[i]);
    Serial.print(", ");
  }
    Serial.println();
  */
  delay(50);

}
