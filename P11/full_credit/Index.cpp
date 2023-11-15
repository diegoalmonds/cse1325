#include <iostream>
#include <iterator>
#include <set>
#include <map>

#include "Index.h"

void Index::add_word(Word word, std::string filename, int line) { 
    std::map<Word, Locations>::iterator map_iterator = _index.begin();
    while (map_iterator->first != word)
    {
        if (map_iterator->first == word)
            map_iterator->second.insert(Location(filename,line));
    }
}