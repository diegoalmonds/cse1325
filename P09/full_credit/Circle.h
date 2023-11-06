#ifndef __CIRCLE__
#define __CIRCLE__

#include <iostream>
#include "Shape.h"

class Circle : public Shape
{
    public:
        Circle(double radius);
        std::string name();
        double area();

    private:
        double __radius;
};
#endif