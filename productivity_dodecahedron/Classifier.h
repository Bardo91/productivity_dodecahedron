//
//  PRODUCTIVITY DODECAHEDRON
//    
//    Bardo91
//

class Classifier{
public:
  int classify(float _x, float _y, float _z);

private:
  static const int cMaxCategories = 12;
  float categories_[cMaxCategories][3] = 
  {
    {513.00 , 498.00 , 595.00},   // 0
    {513.00 , 392.00 , 492.00},  // 1
    {395.00 , 513.00 , 489.00},  // 2
    {0,0,0},  // 3
    {0,0,0},  // 4
    {0,0,0},  // 5
    {0,0,0},  // 6
    {0,0,0},  // 7
    {0,0,0},  // 8
    {0,0,0},  // 9
    {0,0,0},  // 10
    {0,0,0}  // 11
  };

};
