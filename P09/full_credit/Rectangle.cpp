#include "Shape.h"
#include "Rectangle.h"
#include <iostream>

Rectangle::Rectangle(double height, double width) : __height{height}, __width{width} { }

std::string Rectangle::name()
{
    return "Rectangle of height " + std::to_string(__height) + " and width " + std::to_string(__width);
}

double Rectangle::area()
{
    return __height * __width;
}