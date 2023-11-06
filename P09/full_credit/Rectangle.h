#ifndef __RECTANGLE__
#define __RECTANGLE__

#include "Shape.h"
#include <iostream>

class Rectangle : public Shape
{
    public:
        Rectangle(double height, double width);
        std::string name();
        double area();

    private:
        double __height, __width;
};
#endif