#include "Shape.h"
#include "Circle.h"
#include <iostream>

Circle::Circle(double radius) : __radius{radius} { }

std::string Circle::name()
{
    return "Circle of radius " + std::to_string(__radius);
}
double Circle::area()
{
    return (__radius * __radius) * M_PI;
}