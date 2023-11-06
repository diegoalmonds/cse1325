#ifndef __SHAPE__
#define __SHAPE__

#include <iostream>

class Shape
{
    public:
      virtual std::string name();
      virtual double area();
      std::string to_string();
};
#endif