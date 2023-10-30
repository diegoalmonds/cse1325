#include <iostream>
#include <string>

int main()
{
    std::string input;
    std::cout << "What's your name?" << std::endl;
    getline(std::cin, input);
    std::cout << "Hello, " << input << std::endl;
}