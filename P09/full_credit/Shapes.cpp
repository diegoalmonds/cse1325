#include <iostream>
#include <vector>
#include "Shape.h"
#include "Rectangle.h"
#include "Circle.h"

int main()
{
    std::vector<Shape*> shape_list;
    shape_list.push_back(new Rectangle{3,4});
    shape_list.push_back(new Circle{2});
    for(auto shape: shape_list)
    {
        std::cout << shape->to_string() << std::endl;
    }
};