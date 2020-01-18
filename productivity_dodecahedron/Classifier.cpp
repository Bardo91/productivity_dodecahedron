//
//  PRODUCTIVITY DODECAHEDRON
//    
//    Bardo91
//

#include "Classifier.h"
#include "Arduino.h"

int Classifier::classify(float _x, float _y, float _z){

  float minDist = 999999999999;
  int minIdx = 0;
  for(unsigned i = 0; i < cMaxCategories; i++){
    float dx = categories_[i][0] - _x;
    float dy = categories_[i][1] - _y;
    float dz = categories_[i][2] - _z;
    
    float dist = sqrt(dx*dx + dy*dy + dz*dz);

    if(dist < minDist){
      minDist = dist;
      minIdx = i;
    }
  }
  return minIdx;
}
