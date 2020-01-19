//
//  PRODUCTIVITY DODECAHEDRON
//    
//    Bardo91
//

#include "TimeRegistry.h"
#include "Arduino.h"

void TimeRegistry::update(int _id){
  if(lastId == _id){
    // Same type
  }else{
    // Update time table
    if(lastId > -1 && lastId <= cMaxCategories){
      float incT = millis() - lastTime;
      timeRegistry_[lastId] += incT/1000;
    }
    
    // Update last type
    lastId = _id;
    lastTime = millis();
  }
}

void TimeRegistry::saveCurrent(){
  if(lastId > -1 && lastId <= cMaxCategories){
    float incT = millis() - lastTime;
    timeRegistry_[lastId] += incT/1000;
  }
  lastTime = millis();
}


void TimeRegistry::reset(){
  lastId = -1;
  lastTime = millis();
}

float * TimeRegistry::getTimes(){
  return timeRegistry_;
}
