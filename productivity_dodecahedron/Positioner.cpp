//
//  PRODUCTIVITY DODECAHEDRON
//    
//    Bardo91
//

#include "Positioner.h"

void Positioner::init(){
  
}

void Positioner::update(){
  float x, y, z;
  getPosition(x,y,z);
  queueValues[currentCounter][0] = x;
  queueValues[currentCounter][1] = y;
  queueValues[currentCounter][2] = z;
  currentCounter++;
  if(currentCounter == 20){
    currentCounter = 0;
  }

  float mean[3] = {0,0,0};
  for(unsigned i = 0; i < maxMeasures ; i++){
    mean[0] += queueValues[i][0];
    mean[1] += queueValues[i][1];
    mean[2] += queueValues[i][2];
  }
  mean[0]/=maxMeasures;
  mean[1]/=maxMeasures;
  mean[2]/=maxMeasures;

  float std[3] = {0,0,0};
  for(unsigned i = 0; i < maxMeasures ; i++){
    std[0] += (mean[0] - queueValues[i][0])*(mean[0] - queueValues[i][0]);
    std[1] += (mean[1] - queueValues[i][1])*(mean[1] - queueValues[i][1]);
    std[2] += (mean[2] - queueValues[i][2])*(mean[2] - queueValues[i][2]);
  }
  
  std[0]/=maxMeasures;
  std[1]/=maxMeasures;
  std[2]/=maxMeasures;

  float avgStd = (std[0]+std[1]+std[2])/3;
  Serial.print(" --- ");
  Serial.print(avgStd);
  Serial.print(" --- ");
  
  if(avgStd < cMaxStd){
    isStable_ = true;
  }else{
    isStable_ = false;
  }
}


void Positioner::getPosition(float &_x, float &_y, float &_z){
  _x = analogRead(xpin);
  _y = analogRead(ypin);
  _z = analogRead(zpin);
}

bool Positioner::isStable(){
  return isStable_;
}
