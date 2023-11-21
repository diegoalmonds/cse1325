#include <iostream>
#include <fstream>
#include <sstream>
#include <string>

#include "Location.h"
#include "Index.h"

int main(int argc, char* argv[]) { 
    Index index;
    std::string string = "";
    std::string word = "";
    for (int i = 1; i <= argc; i++) { 
        std::string filename = argv[i];
        int lines = 1;
        std::ifstream ist{std::string{argv[i]}};
        if (!ist) throw std::runtime_error {"one of the input files cannot be opened"};
        while (std::getline(ist, string)) {
            std::istringstream iss{string};
            while (std::getline(iss, word, ' ')) {
                for (char& letter : word) tolower(letter);
                std::getline(iss, word, ' ');
                index.add_word(word, filename, lines);
            }
            lines++;
        }
    }
}