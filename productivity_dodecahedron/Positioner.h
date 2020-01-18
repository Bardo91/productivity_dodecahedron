//
//  PRODUCTIVITY DODECAHEDRON
//    
//    Bardo91
//

#include "Arduino.h"

class Positioner{
public:
  void init();

  void update();

  void getPosition(float &_x, float &_y, float &_z);

  bool isStable();

private:
  const int xpin = A1;                  // x-axis of the accelerometer
  const int ypin = A2;                  // y-axis
  const int zpin = A3;                  // z-axis (only on 3-axis models)

  bool isStable_ = false;
  int currentCounter = 0;
  static const int maxMeasures = 10;
  float queueValues[maxMeasures][3];

  const float cMaxStd = 5;
  
};
