#ifndef __INDEX_H
#define __INDEX_H

#include <iostream>
#include <set>
#include <map>

#include "Location.h"

typedef std::set<Location> Locations;
typedef std::string Word;

class Index {
    public:
        void add_word(Word word, std::string filename, int line);
        friend std::ostream& operator<<(std::ostream& ost, Index& index);
    private:
        std::map<Word, Locations> _index;
};

#endif