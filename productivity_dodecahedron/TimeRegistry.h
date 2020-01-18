//
//  PRODUCTIVITY DODECAHEDRON
//    
//    Bardo91
//


class TimeRegistry{
public:
  void update(int _id);

  void reset();

  float *getTimes();

private:
  static const int cMaxCategories = 12;
  float timeRegistry_[cMaxCategories] = {0,0,0,0,0,0,0,0,0,0,0,0};
  int lastId = -1;
  unsigned long lastTime;
};
